package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.MultichannelConnection;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;
import com.zebra.sdk.printer.ZebraPrinterLinkOs;
import com.zebra.sdk.printer.discovery.DiscoveredPrinterNetwork;
import com.zebra.sdk.printer.discovery.DiscoveryPacketDecodeException;
import com.zebra.sdk.printer.discovery.internal.DiscoveredPrinterNetworkFactory;
import com.zebra.sdk.settings.internal.JsonHelper;
import com.zebra.sdk.settings.internal.JsonValidator;
import com.zebra.sdk.util.internal.Base64;
import com.zebra.sdk.util.internal.SGDUtilities;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LinkOsPrinterCreatorSgdOrJson {
    private PrinterLanguage language;
    private LinkOsInformation linkosInfo;

    public LinkOsPrinterCreatorSgdOrJson(LinkOsInformation linkOsInformation) {
        this(linkOsInformation, null);
    }

    private ZebraPrinterLinkOs createLinkOsPrinterFromMultiChannelConnection(ZebraPrinter zebraPrinter) {
        MultichannelConnection multichannelConnection = (MultichannelConnection) zebraPrinter.getConnection();
        this.language = obtainLanguage(multichannelConnection);
        LinkOsInformation linkOsInformationObtainVersion = obtainVersion(multichannelConnection);
        this.linkosInfo = linkOsInformationObtainVersion;
        return new ZebraPrinterLinkOsImpl(zebraPrinter, linkOsInformationObtainVersion, this.language);
    }

    private ZebraPrinterLinkOs createLinkOsPrinterFromStandardConnection(ZebraPrinter zebraPrinter) {
        this.language = obtainLanguage(zebraPrinter.getConnection());
        LinkOsInformation linkOsInformationObtainVersion = obtainVersion(zebraPrinter.getConnection());
        this.linkosInfo = linkOsInformationObtainVersion;
        return new ZebraPrinterLinkOsImpl(zebraPrinter, linkOsInformationObtainVersion, this.language);
    }

    private Map<String, String> getDiscoMapViaJson(Connection connection) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SGDUtilities.DISCOVERY_NAME);
        try {
            return parseDiscoPacket(Base64.decode(JsonHelper.parseGetResponse(connection.sendAndWaitForValidResponse(JsonHelper.buildQuery(arrayList), connection.getMaxTimeoutForRead(), connection.getTimeToWaitForMoreData(), new JsonValidator())).get(SGDUtilities.DISCOVERY_NAME).split(":")[0]));
        } catch (ZebraIllegalArgumentException | DiscoveryPacketDecodeException unused) {
            return null;
        }
    }

    private Map<String, String> getDiscoMapViaSgd(Connection connection) {
        try {
            return parseDiscoPacket(Base64.decode(SGD.GET(SGDUtilities.DISCOVERY_NAME, connection).split(":")[0]));
        } catch (DiscoveryPacketDecodeException unused) {
            return null;
        }
    }

    private PrinterLanguage getLanguageViaJson(Connection connection) throws ZebraPrinterLanguageUnknownException {
        try {
            return PrinterLanguage.getLanguage(StringUtilities.convertKeyValueJsonToMap(connection.sendAndWaitForValidResponse("{}{\"device.languages\":null}".getBytes(), connection.getMaxTimeoutForRead(), connection.getTimeToWaitForMoreData(), new JsonValidator())).get(SGDUtilities.DEVICE_LANGUAGES));
        } catch (IOException unused) {
            throw new ZebraPrinterLanguageUnknownException("Zebra printer language could not be determined for " + connection.toString());
        }
    }

    private PrinterLanguage getLanguageViaSgd(Connection connection) {
        return PrinterLanguage.getLanguage(SGD.GET(SGDUtilities.DEVICE_LANGUAGES, connection));
    }

    private LinkOsInformation getLinkOsVersionFromDiscoMap(Map<String, String> map) {
        return new LinkOsInformation(StringUtilities.getIntValueForKey(map, "LINK_OS_MAJOR_VER"), StringUtilities.getIntValueForKey(map, "LINK_OS_MINOR_VER"));
    }

    private PrinterLanguage obtainLanguage(Connection connection) {
        return shouldQueryLanguage() ? queryPrinterLanguage(connection) : this.language;
    }

    private LinkOsInformation obtainVersion(Connection connection) {
        return shouldQueryPrinter() ? queryVersionNumber(connection) : this.linkosInfo;
    }

    private Map<String, String> parseDiscoPacket(byte[] bArr) throws DiscoveryPacketDecodeException {
        DiscoveredPrinterNetwork discoveredPrinterNetwork = DiscoveredPrinterNetworkFactory.getDiscoveredPrinterNetwork(bArr);
        if (DiscoveredPrinterNetworkFactory.isLinkOsPrinter(discoveredPrinterNetwork)) {
            return discoveredPrinterNetwork.getDiscoveryDataMap();
        }
        return null;
    }

    private PrinterLanguage queryPrinterLanguage(Connection connection) {
        if (connection instanceof MultichannelConnection) {
            MultichannelConnection multichannelConnection = (MultichannelConnection) connection;
            if (multichannelConnection.getStatusChannel().isConnected()) {
                return getLanguageViaJson(multichannelConnection.getStatusChannel());
            }
        } else if (connection instanceof StatusConnection) {
            return getLanguageViaJson(connection);
        }
        return getLanguageViaSgd(connection);
    }

    private Map<String, String> queryVersionInfoOverSingleChannel(Connection connection) {
        return (this.language == PrinterLanguage.ZPL || (connection instanceof StatusConnection)) ? getDiscoMapViaJson(connection) : getDiscoMapViaSgd(connection);
    }

    private LinkOsInformation queryVersionNumber(Connection connection) {
        Map<String, String> mapQueryVersionInfoOverSingleChannel;
        if (connection instanceof MultichannelConnection) {
            MultichannelConnection multichannelConnection = (MultichannelConnection) connection;
            if (multichannelConnection.getStatusChannel().isConnected()) {
                mapQueryVersionInfoOverSingleChannel = getDiscoMapViaJson(multichannelConnection.getStatusChannel());
            } else {
                connection = multichannelConnection.getPrintingChannel();
                mapQueryVersionInfoOverSingleChannel = queryVersionInfoOverSingleChannel(connection);
            }
        } else {
            mapQueryVersionInfoOverSingleChannel = queryVersionInfoOverSingleChannel(connection);
        }
        return getLinkOsVersionFromDiscoMap(mapQueryVersionInfoOverSingleChannel);
    }

    private boolean shouldQueryLanguage() {
        return this.language == null;
    }

    private boolean shouldQueryPrinter() {
        return this.linkosInfo.getMajor() < 0;
    }

    public ZebraPrinterLinkOs create(Connection connection) {
        return create(new ZebraPrinterZpl(connection));
    }

    public LinkOsPrinterCreatorSgdOrJson(LinkOsInformation linkOsInformation, PrinterLanguage printerLanguage) {
        this.linkosInfo = linkOsInformation;
        this.language = printerLanguage;
    }

    public ZebraPrinterLinkOs create(ZebraPrinter zebraPrinter) {
        try {
            return zebraPrinter.getConnection() instanceof MultichannelConnection ? createLinkOsPrinterFromMultiChannelConnection(zebraPrinter) : createLinkOsPrinterFromStandardConnection(zebraPrinter);
        } catch (ZebraPrinterLanguageUnknownException | RuntimeException unused) {
            return null;
        }
    }

    public LinkOsPrinterCreatorSgdOrJson(PrinterLanguage printerLanguage) {
        this(new LinkOsInformation(-1, -1), printerLanguage);
    }
}
