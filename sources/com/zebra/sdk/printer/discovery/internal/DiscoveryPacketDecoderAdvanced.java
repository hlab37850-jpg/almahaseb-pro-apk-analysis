package com.zebra.sdk.printer.discovery.internal;

import com.google.android.gms.stats.CodePackage;
import com.itextpdf.text.pdf.PdfBoolean;
import com.zebra.sdk.printer.discovery.DiscoveredPrinterNetwork;
import com.zebra.sdk.printer.discovery.DiscoveryPacketDecodeException;
import com.zebra.sdk.util.internal.Base64;
import com.zebra.sdk.util.internal.PacketParsingUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class DiscoveryPacketDecoderAdvanced {
    private static final int ACTIVE_INTERFACE_OFFSET = 320;
    private static final int ACTIVE_INTERFACE_SIZE = 4;
    private static final int ADVANCED_PACKET_FORMAT_OFFSET = 4;
    private static final int AVAILABLE_INTERFACES_BITFIELD_OFFSET = 184;
    private static final int AVAILABLE_INTERFACES_BITFIELD_SIZE = 4;
    private static final int AVAILABLE_LANGUAGES_BITFIELD_OFFSET = 352;
    private static final int AVAILABLE_LANGUAGES_BITFIELD_SIZE = 4;
    private static final int AVAILABLE_PROTOCOLS_OFFSET = 346;
    private static final int AVAILABLE_PROTOCOLS_SIZE = 2;
    private static final int AVAILABLE_SECONDARY_LANGUAGES_BITFIELD_OFFSET = 356;
    private static final int AVAILABLE_SECONDARY_LANGUAGES_BITFIELD_SIZE = 4;
    private static final int AVS_INI_VERSION_OFFSET = 402;
    private static final int AVS_INI_VERSION_SIZE = 6;
    private static final int COMPANY_ABBERVIATION_OFFSET = 8;
    private static final int COMPANY_ABBERVIATION_SIZE = 5;
    private static final int DARKNESS_OFFSET = 368;
    private static final int DARKNESS_SIZE = 2;
    private static final int DEVICE_UNIQUE_ID_OFFSET = 188;
    private static final int DEVICE_UNIQUE_ID_SIZE = 32;
    private static final int DISCOVERY_VERSION_OFFSET = 3;
    private static final int DNS_DOMAIN_OFFSET = 220;
    private static final int DNS_DOMAIN_SIZE = 100;
    private static final int DOTS_PER_DOT_ROW_OFFSET = 362;
    private static final int DOTS_PER_DOT_ROW_SIZE = 2;
    private static final int DOTS_PER_MM_OFFSET = 360;
    private static final int DOTS_PER_MM_SIZE = 2;
    private static final int ERRORS_SEGMENT0_OFFSET = 160;
    private static final int ERRORS_SEGMENT0_SIZE = 4;
    private static final int ERRORS_SEGMENT1_OFFSET = 164;
    private static final int ERRORS_SEGMENT1_SIZE = 4;
    private static final int ERRORS_SEGMENT2_OFFSET = 168;
    private static final int ERRORS_SEGMENT2_SIZE = 4;
    private static final int FW_VERSION_OFFSET = 108;
    private static final int FW_VERSION_SIZE = 16;
    private static final int GATEWAY_MASK_OFFSET = 340;
    private static final int GATEWAY_MASK_SIZE = 4;
    private static final int IP_ACQUISITION_PROTO_OFFSET = 330;
    private static final int IP_ACQUISITION_PROTO_SIZE = 2;
    private static final int IP_ADDRESS_OFFSET = 332;
    private static final int IP_ADDRESS_SIZE = 4;
    private static final int JSON_PORT_OFFSET = 398;
    private static final int JSON_PORT_SIZE = 2;
    private static final int LABELS_QUEUED_OFFSET = 390;
    private static final int LABELS_QUEUED_SIZE = 2;
    private static final int LABEL_LENGTH_OFFSET = 364;
    private static final int LABEL_LENGTH_SIZE = 2;
    private static final int LABEL_WIDTH_OFFSET = 366;
    private static final int LABEL_WIDTH_SIZE = 2;
    private static final int LINK_OS_MAJOR_VER_OFFSET = 400;
    private static final int LINK_OS_MINOR_VER_OFFSET = 401;
    private static final int LOCATION_OFFSET = 124;
    private static final int LOCATION_SIZE = 36;
    private static final int MAC_ADDRESS_OFFSET = 324;
    private static final int MAC_ADDRESS_SIZE = 6;
    private static final int MEDIA_TYPE_OFFSET = 370;
    private static final int MEDIA_TYPE_SIZE = 2;
    private static final int MIN_PACKET_SIZE = 395;
    private static final int NUM_OF_LABELS_IN_BATCH_OFFSET = 388;
    private static final int NUM_OF_LABELS_IN_BATCH_SIZE = 2;
    private static final int ODOMETER_MARKER_ONE_OFFSET = 380;
    private static final int ODOMETER_MARKER_ONE_SIZE = 4;
    private static final int ODOMETER_MARKER_TWO_OFFSET = 384;
    private static final int ODOMETER_MARKER_TWO_SIZE = 4;
    private static final int ODOMETER_TOTAL_OFFSET = 376;
    private static final int ODOMETER_TOTAL_SIZE = 4;
    private static final int PORT_OFFSET = 344;
    private static final int PORT_SIZE = 2;
    private static final int PRIMARY_LANGUAGE_OFFSET = 348;
    private static final int PRIMARY_LANGUAGE_SIZE = 4;
    private static final int PRINT_HEAD_WIDTH_OFFSET = 396;
    private static final int PRINT_HEAD_WIDTH_SIZE = 2;
    private static final int PRINT_METHOD_OFFSET = 372;
    private static final int PRINT_METHOD_SIZE = 2;
    private static final int PRINT_MODE_OFFSET = 374;
    private static final int PRINT_MODE_SIZE = 2;
    private static final int PROCESSOR_ID_OFFSET = 408;
    private static final int PROCESSOR_ID_SIZE = 8;
    private static final int PRODUCT_NAME_OFFSET = 76;
    private static final int PRODUCT_NAME_SIZE = 32;
    private static final int SUBNET_MASK_OFFSET = 336;
    private static final int SUBNET_MASK_SIZE = 4;
    private static final int SYSTEM_NAME_OFFSET = 13;
    private static final int SYSTEM_NAME_SIZE = 63;
    private static final int TLS_JSON_PORT_OFFSET = 418;
    private static final int TLS_JSON_PORT_SIZE = 2;
    private static final int TLS_RAW_PORT_OFFSET = 416;
    private static final int TLS_RAW_PORT_SIZE = 2;
    private static final int WARNINGS_SEGMENT0_OFFSET = 172;
    private static final int WARNINGS_SEGMENT0_SIZE = 4;
    private static final int WARNINGS_SEGMENT1_OFFSET = 176;
    private static final int WARNINGS_SEGMENT1_SIZE = 4;
    private static final int WARNINGS_SEGMENT2_OFFSET = 180;
    private static final int WARNINGS_SEGMENT2_SIZE = 4;
    private static final int WIRED_8021X_SECURITY_SETTING_OFFSET = 420;
    private static final int WIRED_8021X_SECURITY_SETTING_SIZE = 1;
    private static final int ZBI_ENABLED_OFFSET = 392;
    private static final int ZBI_ENABLED_SIZE = 1;
    private static final int ZBI_MAJOR_VERSION_OFFSET = 394;
    private static final int ZBI_MINOR_VERSION_OFFSET = 395;
    private static final int ZBI_STATE_OFFSET = 393;
    private static final int ZBI_STATE_SIZE = 1;
    private byte[] rawDiscoveryPacket;

    public DiscoveryPacketDecoderAdvanced(byte[] bArr) {
        this.rawDiscoveryPacket = bArr;
    }

    private int getAdvancedDiscoveryVer() {
        return PacketParsingUtil.byte2int(this.rawDiscoveryPacket[4]);
    }

    private Set<PrinterInterface> getAvailableInterfaces() {
        return PrinterInterface.getEnumSetFromBitmask(PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, 184, 4));
    }

    private Set<DiscoveredPrinterLanguage> getAvailableLanguages() {
        return DiscoveredPrinterLanguage.getEnumSetFromBitmask(PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, AVAILABLE_LANGUAGES_BITFIELD_OFFSET, 4));
    }

    private Set<NetworkProtocol> getAvailableNetworkProtocols() {
        return NetworkProtocol.getEnumSetFromBitmask(PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, AVAILABLE_PROTOCOLS_OFFSET, 2));
    }

    private Set<SecondaryPrinterLanguage> getAvailableSecondaryLanguages() {
        return SecondaryPrinterLanguage.getEnumSetFromBitmask(PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, AVAILABLE_SECONDARY_LANGUAGES_BITFIELD_OFFSET, 4));
    }

    private String getAvsIniVersion() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, 402, 6);
    }

    private String getCompanyAbbreviation() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, 8, 5);
    }

    private PrinterInterface getCurrentlyActiveNetworkInterface() {
        return parseNetworkInterface(this.rawDiscoveryPacket, 320, 4);
    }

    private short getDarkness() {
        return (short) PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, DARKNESS_OFFSET, 2);
    }

    private String getDeviceUniqueId() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, DEVICE_UNIQUE_ID_OFFSET, 32);
    }

    private HashMap<String, String> getDiscoveryDataMap() {
        HashMap<String, String> map = new HashMap<>();
        int advancedDiscoveryVer = getAdvancedDiscoveryVer();
        map.put("DISCOVERY_VER", String.valueOf(getDiscoveryVersion()));
        map.put("ADVANCED_DISCOVERY_VER", String.valueOf(advancedDiscoveryVer));
        map.put("COMPANY_ABBREVIATION", getCompanyAbbreviation());
        map.put("SYSTEM_NAME", getSystemName());
        map.put("PRODUCT_NAME", getProductName());
        map.put("FIRMWARE_VER", getFirmwareVersion());
        map.put(CodePackage.LOCATION, getLocation());
        map.put("ERRORS", iterateSetAndStringConcatValues(getErrors()));
        map.put("WARNINGS", iterateSetAndStringConcatValues(getWarnings()));
        map.put("ACTIVE_NETWORK_INTERFACE", getCurrentlyActiveNetworkInterface().toString());
        String deviceUniqueId = getDeviceUniqueId();
        map.put("SERIAL_NUMBER", deviceUniqueId);
        map.put("DEVICE_UNIQUE_ID", deviceUniqueId);
        map.put("DNS_DOMAIN", getDnsDomain());
        map.put("HARDWARE_ADDRESS", getMacAddress());
        boolean usingNetProtocol = getUsingNetProtocol();
        String str = PdfBoolean.FALSE;
        map.put("USING_NET_PROTOCOL", usingNetProtocol ? PdfBoolean.TRUE : PdfBoolean.FALSE);
        map.put("DNS_NAME", getSystemName());
        map.put("IP_ACQUISITION_PROTOCOL", getIpAcquisitionProtocol().toString());
        map.put("ADDRESS", getIpAddress());
        map.put("SUBNET_MASK", getSubnetMask());
        map.put("GATEWAY", getGateway());
        map.put("PORT_NUMBER", String.valueOf(getPort()));
        map.put("AVAILABLE_NETWORK_PROTOCOLS", iterateSetAndStringConcatValues(getAvailableNetworkProtocols()));
        map.put("AVAILABLE_INTERFACES", iterateSetAndStringConcatValues(getAvailableInterfaces()));
        map.put("PRIMARY_LANGUAGE", getPrimaryLanguage().toString());
        map.put("AVAILABLE_LANGUAGES", iterateSetAndStringConcatValues(getAvailableLanguages()));
        map.put("SECONDARY_PRINTER_LANGUAGE", iterateSetAndStringConcatValues(getAvailableSecondaryLanguages()));
        map.put("DOTS_PER_MM", String.valueOf((int) getDotsPerMM()));
        map.put("DOTS_PER_ROW", String.valueOf((int) getDotsPerDotRow()));
        map.put("LABEL_LENGTH", String.valueOf((int) getLabelLength()));
        map.put("LABEL_WIDTH", String.valueOf((int) getLabelWidth()));
        map.put("DARKNESS", String.valueOf((int) getDarkness()));
        map.put("PRINTER_MEDIA_TYPE", getMediaType().toString());
        map.put("PRINT_METHOD", getPrintMethod().toString());
        map.put("PRINT_MODE", getPrintMode().toString());
        map.put("ODOMETER_TOTAL_LABEL_COUNT", String.valueOf(getOdometerTotalLabelCount()));
        map.put("ODOMETER_MEDIAMARKER_COUNT_ONE", String.valueOf(getOdometerMarkerCountOne()));
        map.put("ODOMETER_MEDIAMARKER_COUNT_TWO", String.valueOf(getOdometerMarkerCountTwo()));
        map.put("NUMBER_LABELS_REMAIN_IN_BATCH", String.valueOf(getNumberOfLabelsRemainingInBatch()));
        map.put("NUMBER_LABELS_QUEUED", String.valueOf(getNumberOfLabelsQueued()));
        if (getZbiEnabled()) {
            str = PdfBoolean.TRUE;
        }
        map.put("ZBI_ENABLED", str);
        map.put("ZBI_STATE", getZbiState().toString());
        map.put("ZBI_MAJOR_VER", String.valueOf(getZbiMajorVersion()));
        map.put("ZBI_MINOR_VER", String.valueOf(getZbiMinorVersion()));
        if (advancedDiscoveryVer >= 1) {
            map.put("PRINT_HEAD_WIDTH", String.valueOf(getPrintHeadWidth()));
        }
        if (advancedDiscoveryVer >= 2) {
            map.put("JSON_PORT_NUMBER", String.valueOf(getJsonPort()));
            map.put("LINK_OS_MAJOR_VER", String.valueOf(getLinkOsMajorVer()));
            map.put("LINK_OS_MINOR_VER", String.valueOf(getLinkOsMinorVer()));
        }
        if (advancedDiscoveryVer >= 3) {
            map.put("AVS_INI_VER", getAvsIniVersion());
        }
        if (advancedDiscoveryVer >= 4) {
            map.put("PROCESSOR_ID", getProcessorId());
            map.put("TLS_RAW_PORT_NUMBER", String.valueOf(getTlsRawPortNumber()));
            map.put("TLS_JSON_PORT_NUMBER", String.valueOf(getTlsJsonPortNumber()));
            map.put("WIRED_8021X_SECURITY_SETTING", getWired8021xSecuritySetting().toString());
        }
        map.put("PORT_STATUS", getPortStatus().toString());
        map.put("PRODUCT_NUMBER", "");
        map.put("PORT_NAME", "");
        map.put("DATE_CODE", "");
        return map;
    }

    private int getDiscoveryVersion() {
        return PacketParsingUtil.byte2int(this.rawDiscoveryPacket[3]);
    }

    private String getDnsDomain() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, DNS_DOMAIN_OFFSET, 100);
    }

    private short getDotsPerDotRow() {
        return (short) PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, DOTS_PER_DOT_ROW_OFFSET, 2);
    }

    private short getDotsPerMM() {
        return (short) PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, DOTS_PER_MM_OFFSET, 2);
    }

    private Set<PrinterError> getErrors() {
        int integer = PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, 160, 4);
        int integer2 = PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, 164, 4);
        int integer3 = PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, 168, 4);
        Set<PrinterError> enumSetFromBitmask = PrinterError.getEnumSetFromBitmask(0, integer);
        enumSetFromBitmask.addAll(PrinterError.getEnumSetFromBitmask(1, integer2));
        enumSetFromBitmask.addAll(PrinterError.getEnumSetFromBitmask(2, integer3));
        return enumSetFromBitmask;
    }

    private String getFirmwareVersion() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, 108, 16);
    }

    private String getGateway() {
        return PacketParsingUtil.parseAddress(this.rawDiscoveryPacket, 340, 4);
    }

    private IPAquisitionProtocol getIpAcquisitionProtocol() {
        return IPAquisitionProtocol.intToEnum(PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, 330, 2));
    }

    private String getIpAddress() {
        return PacketParsingUtil.parseAddress(this.rawDiscoveryPacket, 332, 4);
    }

    private int getJsonPort() {
        return PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, JSON_PORT_OFFSET, 2);
    }

    private short getLabelLength() {
        return (short) PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, LABEL_LENGTH_OFFSET, 2);
    }

    private short getLabelWidth() {
        return (short) PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, LABEL_WIDTH_OFFSET, 2);
    }

    private int getLinkOsMajorVer() {
        return PacketParsingUtil.byte2int(this.rawDiscoveryPacket[LINK_OS_MAJOR_VER_OFFSET]);
    }

    private int getLinkOsMinorVer() {
        return PacketParsingUtil.byte2int(this.rawDiscoveryPacket[401]);
    }

    private String getLocation() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, 124, 36);
    }

    private String getMacAddress() {
        return PacketParsingUtil.parseGeneralByte(this.rawDiscoveryPacket, 324, 6);
    }

    private PrinterMediaType getMediaType() {
        return PrinterMediaType.intToEnum(PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, MEDIA_TYPE_OFFSET, 2));
    }

    private int getNumberOfLabelsQueued() {
        return PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, LABELS_QUEUED_OFFSET, 2);
    }

    private int getNumberOfLabelsRemainingInBatch() {
        return PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, NUM_OF_LABELS_IN_BATCH_OFFSET, 2);
    }

    private int getOdometerMarkerCountOne() {
        return PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, ODOMETER_MARKER_ONE_OFFSET, 4);
    }

    private int getOdometerMarkerCountTwo() {
        return PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, ODOMETER_MARKER_TWO_OFFSET, 4);
    }

    private int getOdometerTotalLabelCount() {
        return PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, ODOMETER_TOTAL_OFFSET, 4);
    }

    private int getPort() {
        return PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, PORT_OFFSET, 2);
    }

    private PrinterPortStatus getPortStatus() {
        Set<PrinterError> errors = getErrors();
        if (errors.contains(PrinterError.HEAD_OPEN)) {
            return PrinterPortStatus.DOOR_OPEN;
        }
        if (errors.contains(PrinterError.MEDIA_OUT)) {
            return PrinterPortStatus.PAPER_OUT;
        }
        if (errors.contains(PrinterError.PAPER_FEED_ERROR)) {
            return PrinterPortStatus.PAPER_JAMMED;
        }
        return errors.size() == 0 ? PrinterPortStatus.ONLINE : PrinterPortStatus.PRINTER_ERROR;
    }

    private DiscoveredPrinterLanguage getPrimaryLanguage() {
        return DiscoveredPrinterLanguage.intToEnum(PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, PRIMARY_LANGUAGE_OFFSET, 4));
    }

    private int getPrintHeadWidth() {
        return PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, PRINT_HEAD_WIDTH_OFFSET, 2);
    }

    private PrintMethod getPrintMethod() {
        return PrintMethod.intToEnum(PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, PRINT_METHOD_OFFSET, 2));
    }

    private PrintMode getPrintMode() {
        return PrintMode.intToEnum(PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, PRINT_MODE_OFFSET, 2));
    }

    private String getProcessorId() {
        return PacketParsingUtil.parseGeneralByte(this.rawDiscoveryPacket, PROCESSOR_ID_OFFSET, 8);
    }

    private String getProductName() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, 76, 32);
    }

    private String getSubnetMask() {
        return PacketParsingUtil.parseAddress(this.rawDiscoveryPacket, 336, 4);
    }

    private String getSystemName() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, 13, 63);
    }

    private int getTlsJsonPortNumber() {
        return PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, TLS_JSON_PORT_OFFSET, 2);
    }

    private int getTlsRawPortNumber() {
        return PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, 416, 2);
    }

    private boolean getUsingNetProtocol() {
        return getIpAcquisitionProtocol() != IPAquisitionProtocol.STATIC;
    }

    private Set<PrinterWarning> getWarnings() {
        int integer = PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, 172, 4);
        int integer2 = PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, 176, 4);
        int integer3 = PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, 180, 4);
        Set<PrinterWarning> enumSetFromBitmask = PrinterWarning.getEnumSetFromBitmask(0, integer);
        enumSetFromBitmask.addAll(PrinterWarning.getEnumSetFromBitmask(1, integer2));
        enumSetFromBitmask.addAll(PrinterWarning.getEnumSetFromBitmask(2, integer3));
        return enumSetFromBitmask;
    }

    private Wired8021xSecuritySetting getWired8021xSecuritySetting() {
        return Wired8021xSecuritySetting.intToEnum(PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, 420, 1));
    }

    private boolean getZbiEnabled() {
        return PacketParsingUtil.parseBoolean(this.rawDiscoveryPacket, ZBI_ENABLED_OFFSET, 1);
    }

    private int getZbiMajorVersion() {
        return this.rawDiscoveryPacket[ZBI_MAJOR_VERSION_OFFSET];
    }

    private int getZbiMinorVersion() {
        return this.rawDiscoveryPacket[395];
    }

    private ZbiState getZbiState() {
        return ZbiState.intToEnum(PacketParsingUtil.parseInteger(this.rawDiscoveryPacket, ZBI_STATE_OFFSET, 1));
    }

    private String iterateSetAndStringConcatValues(Set<?> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static void main(String[] strArr) {
        System.out.println(new DiscoveryPacketDecoderAdvanced(Base64.decode("OiwuBAIBAAFaQlIAAFhYUUxWMTIzNAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFpUQyBRTG4yMjAtMjAzZHBpIENQQ0wAAAAAAAAAAAAAVjY4LjIwLjAyUDM0Nzc2LQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAW1YWFFMVjEyMzQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHplYnJhLmxhbgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABAAdNRjzhAAAKUBYn////AApQFgEX1QH/AAAAAgAAAAcAAAADAAgR8AfuAKgAZAABAAAAAAAAAukAAAKaAAAnzgAAAAABAgIBAkAj8AQA")).getZbiState());
    }

    private PrinterInterface parseNetworkInterface(byte[] bArr, int i, int i2) {
        return PrinterInterface.intToEnum(PacketParsingUtil.parseInteger(bArr, i, i2));
    }

    public DiscoveredPrinterNetwork getDiscoveredPrinterNetworkAdvanced() throws DiscoveryPacketDecodeException {
        if (this.rawDiscoveryPacket.length >= 395) {
            return new DiscoveredPrinterNetwork(getDiscoveryDataMap());
        }
        throw new DiscoveryPacketDecodeException("Unable to parse the supplied discovery packet due to an invalid discovery packet length");
    }
}
