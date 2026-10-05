package com.zebra.sdk.weblink;

import androidx.work.WorkRequest;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.ConnectionReestablisher;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.NotALinkOsPrinterException;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.PrinterReconnectionHandler;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.ZebraPrinterLinkOs;
import com.zebra.sdk.printer.discovery.DiscoveredPrinter;
import com.zebra.sdk.settings.SettingsValues;
import com.zebra.sdk.util.internal.SGDUtilities;
import com.zebra.sdk.util.internal.Sleeper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.validator.routines.RegexValidator;
import org.apache.commons.validator.routines.UrlValidator;

/* JADX INFO: loaded from: classes3.dex */
public class WeblinkConfigurator {
    Connection connection;
    private LinkOsInformation linkOsVersion;
    WeblinkConfigurationState myState;
    ConfigurationStatus myStatus;
    private PrinterLanguage printerLanguage;
    private ConnectionReestablisher reestablisher;
    private WeblinkLocationToSet weblinkLocationToSet;

    /* JADX INFO: renamed from: com.zebra.sdk.weblink.WeblinkConfigurator$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$zebra$sdk$weblink$WeblinkAddressStrategy;
        static final /* synthetic */ int[] $SwitchMap$com$zebra$sdk$weblink$WeblinkConfigurator$WeblinkLocationToSet;

        static {
            int[] iArr = new int[WeblinkAddressStrategy.values().length];
            $SwitchMap$com$zebra$sdk$weblink$WeblinkAddressStrategy = iArr;
            try {
                iArr[WeblinkAddressStrategy.AUTO_SELECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zebra$sdk$weblink$WeblinkAddressStrategy[WeblinkAddressStrategy.FORCE_CONNECTION_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$zebra$sdk$weblink$WeblinkAddressStrategy[WeblinkAddressStrategy.FORCE_CONNECTION_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[WeblinkLocationToSet.values().length];
            $SwitchMap$com$zebra$sdk$weblink$WeblinkConfigurator$WeblinkLocationToSet = iArr2;
            try {
                iArr2[WeblinkLocationToSet.SET_LOCATION_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$zebra$sdk$weblink$WeblinkConfigurator$WeblinkLocationToSet[WeblinkLocationToSet.SET_LOCATION_2.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum WeblinkLocationToSet {
        SET_LOCATION_1,
        SET_LOCATION_2
    }

    public WeblinkConfigurator(Connection connection) {
        this.printerLanguage = null;
        this.linkOsVersion = null;
        this.connection = connection;
        this.myState = WeblinkConfigurationState.ConnectToPrinter;
        this.myStatus = ConfigurationStatus.NOT_STARTED;
    }

    private boolean checkConnection(String str, Map<String, String> map) {
        String str2 = map.get(str);
        return (str2 == null || str2.equals("0")) ? false : true;
    }

    private void connectToPrinter() {
        this.connection.open();
    }

    private LinkOsInformation getLinkOsVersionInfo() throws NotALinkOsPrinterException {
        if (this.linkOsVersion == null) {
            String strGET = SGD.GET("appl.link_os_version", this.connection);
            if (strGET.equals("?")) {
                throw new NotALinkOsPrinterException();
            }
            this.linkOsVersion = new LinkOsInformation(strGET);
        }
        return this.linkOsVersion;
    }

    private PrinterLanguage getPrinterLanguage() throws NotALinkOsPrinterException {
        if (this.printerLanguage == null) {
            String strGET = SGD.GET(SGDUtilities.DEVICE_LANGUAGES, this.connection);
            if (strGET.equals("?")) {
                throw new NotALinkOsPrinterException();
            }
            this.printerLanguage = PrinterLanguage.getLanguage(strGET);
        }
        return this.printerLanguage;
    }

    private Map<String, String> getSettings() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("rtc.date");
        arrayList.add("weblink.ip.conn1.location");
        arrayList.add("weblink.ip.conn2.location");
        arrayList.add("weblink.ip.conn1.num_connections");
        arrayList.add("weblink.ip.conn2.num_connections");
        arrayList.add("appl.link_os_version");
        this.printerLanguage = getPrinterLanguage();
        this.linkOsVersion = getLinkOsVersionInfo();
        return new SettingsValues().getValues(arrayList, this.connection, this.printerLanguage, this.linkOsVersion);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0163  */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0158, code lost:
    
        if (r11 != 3) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.Map<java.lang.String, java.lang.String> getSettingsToConfigure(java.lang.String r10, com.zebra.sdk.weblink.WeblinkAddressStrategy r11, com.zebra.sdk.weblink.WeblinkConfigurationStateUpdater r12, java.util.Map<java.lang.String, java.lang.String> r13) throws com.zebra.sdk.weblink.ZebraWeblinkException {
        /*
            Method dump skipped, instruction units count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zebra.sdk.weblink.WeblinkConfigurator.getSettingsToConfigure(java.lang.String, com.zebra.sdk.weblink.WeblinkAddressStrategy, com.zebra.sdk.weblink.WeblinkConfigurationStateUpdater, java.util.Map):java.util.Map");
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0025 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:? A[RETURN, SYNTHETIC] */
    private boolean isConnected(Map<String, String> map) {
        String str;
        int i;
        int i2 = AnonymousClass2.$SwitchMap$com$zebra$sdk$weblink$WeblinkConfigurator$WeblinkLocationToSet[this.weblinkLocationToSet.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                i = -1;
            } else {
                str = "weblink.ip.conn2.num_connections";
            }
            if (i > 0) {
                return true;
            }
            return false;
        }
        str = "weblink.ip.conn1.num_connections";
        i = Integer.parseInt(map.get(str));
        if (i > 0) {
            return true;
        }
        return false;
    }

    private void reconnectToPrinter(WeblinkConfigurationStateUpdater weblinkConfigurationStateUpdater) {
        updateState(weblinkConfigurationStateUpdater, WeblinkConfigurationState.ReconnectToPrinter);
        Sleeper.sleep(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        this.reestablisher.reestablishConnection(new PrinterReconnectionHandler() { // from class: com.zebra.sdk.weblink.WeblinkConfigurator.1
            @Override // com.zebra.sdk.printer.PrinterReconnectionHandler
            public void printerOnline(ZebraPrinterLinkOs zebraPrinterLinkOs, String str) {
                WeblinkConfigurator.this.connection = zebraPrinterLinkOs.getConnection();
            }
        });
    }

    private void restartPrinter(WeblinkConfigurationStateUpdater weblinkConfigurationStateUpdater) {
        updateState(weblinkConfigurationStateUpdater, WeblinkConfigurationState.RestartPrinter);
        SGD.SET(SGDUtilities.DEVICE_RESET, "", this.connection);
        this.connection.close();
    }

    private boolean rtcTooOld(Map<String, String> map) {
        String str = map.get("rtc.date");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        try {
            return simpleDateFormat.parse(str).before(simpleDateFormat.parse("01-01-2013"));
        } catch (Exception unused) {
            return false;
        }
    }

    private void updateState(WeblinkConfigurationStateUpdater weblinkConfigurationStateUpdater, WeblinkConfigurationState weblinkConfigurationState) {
        weblinkConfigurationStateUpdater.updateState(weblinkConfigurationState);
        this.myState = weblinkConfigurationState;
    }

    private void verifyPrinterNumConnections(Map<String, String> map, Map<String, String> map2, WeblinkConfigurationStateUpdater weblinkConfigurationStateUpdater) throws ZebraWeblinkException {
        updateState(weblinkConfigurationStateUpdater, WeblinkConfigurationState.VerifyWeblinkConnection);
        boolean zIsConnected = false;
        if (new LinkOsInformation(map2.get("appl.link_os_version")).getMajor() >= 2) {
            try {
                WeblinkLocationToSet weblinkLocationToSet = this.weblinkLocationToSet;
                if (weblinkLocationToSet == WeblinkLocationToSet.SET_LOCATION_1) {
                    if (Integer.parseInt(map2.get("weblink.ip.conn1.num_connections")) > 0) {
                        return;
                    }
                } else if (weblinkLocationToSet == WeblinkLocationToSet.SET_LOCATION_2 && Integer.parseInt(map2.get("weblink.ip.conn2.num_connections")) > 0) {
                    return;
                }
                zIsConnected = isConnected(getSettings());
                int i = 0;
                while (!zIsConnected && i < 5) {
                    Sleeper.sleep(2000L);
                    i++;
                    zIsConnected = isConnected(getSettings());
                }
            } catch (ZebraIllegalArgumentException e) {
                throw new ZebraWeblinkException(e);
            } catch (NumberFormatException unused) {
            }
        }
        if (!zIsConnected) {
            throw new ZebraWeblinkException("Could not verify the connection to the Zebra Weblink server. You may need to review the printer weblink logs and/or the server logs if there are any connection issues.");
        }
    }

    public void configure(String str, WeblinkAddressStrategy weblinkAddressStrategy, WeblinkConfigurationStateUpdater weblinkConfigurationStateUpdater) throws ZebraWeblinkException {
        this.myStatus = ConfigurationStatus.IN_PROCESS;
        updateState(weblinkConfigurationStateUpdater, WeblinkConfigurationState.ConnectToPrinter);
        if (str == null || str.isEmpty() || !isValidWeblinkUrl(str)) {
            this.myStatus = ConfigurationStatus.CONFIGURATION_FAILED;
            updateState(weblinkConfigurationStateUpdater, this.myState);
            throw new ZebraWeblinkException("Invalid weblink address.");
        }
        ConfigurationStatus configurationStatus = this.myStatus;
        try {
            try {
                try {
                    connectToPrinter();
                    this.reestablisher = this.connection.getConnectionReestablisher(240000L);
                    updateState(weblinkConfigurationStateUpdater, WeblinkConfigurationState.GetSettings);
                    Map<String, String> settings = getSettings();
                    Map<String, String> settingsToConfigure = getSettingsToConfigure(str, weblinkAddressStrategy, weblinkConfigurationStateUpdater, settings);
                    if (settingsToConfigure.size() > 0) {
                        new SettingsValues().setValues(settingsToConfigure, this.connection, this.printerLanguage, this.linkOsVersion);
                        Sleeper.sleep(1000L);
                        restartPrinter(weblinkConfigurationStateUpdater);
                        reconnectToPrinter(weblinkConfigurationStateUpdater);
                    }
                    verifyPrinterNumConnections(settingsToConfigure, settings, weblinkConfigurationStateUpdater);
                    ConfigurationStatus configurationStatus2 = ConfigurationStatus.SUCCESSFULLY_COMPLETED;
                    Connection connection = this.connection;
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (ConnectionException unused) {
                        }
                    }
                    this.myStatus = configurationStatus2;
                    updateState(weblinkConfigurationStateUpdater, this.myState);
                } catch (Throwable th) {
                    Connection connection2 = this.connection;
                    if (connection2 != null) {
                        try {
                            connection2.close();
                        } catch (ConnectionException unused2) {
                        }
                    }
                    this.myStatus = configurationStatus;
                    updateState(weblinkConfigurationStateUpdater, this.myState);
                    throw th;
                }
            } catch (ZebraWeblinkException e) {
                ConfigurationStatus configurationStatus3 = ConfigurationStatus.CONFIGURATION_FAILED;
                throw e;
            }
        } catch (Exception e2) {
            ConfigurationStatus configurationStatus4 = ConfigurationStatus.CONFIGURATION_FAILED;
            throw new ZebraWeblinkException(e2);
        }
    }

    public WeblinkConfigurationState getCurrentState() {
        return this.myState;
    }

    public ConfigurationStatus getStatus() {
        return this.myStatus;
    }

    public boolean isValidWeblinkUrl(String str) {
        return new UrlValidator(new String[]{"https"}, new RegexValidator("^((?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{1,63}(:\\d+)?$"), 8L).isValid(str);
    }

    public WeblinkConfigurator(DiscoveredPrinter discoveredPrinter) {
        this(discoveredPrinter.getConnection());
    }
}
