package com.zebra.sdk.util.internal;

/* JADX INFO: loaded from: classes3.dex */
public class SGDUtilities {
    public static final String APPL_NAME = "appl.name";
    public static final String CALIBRATE_PRINTER = "zpl.calibrate";
    public static final String CALIBRATE_PRINTER_JSON = "{}{\"zpl.calibrate\":\"\"}";
    public static final String DEVICE_LANGUAGES = "device.languages";
    public static final String DEVICE_RESET = "device.reset";
    public static final String DISCOVERY_NAME = "ip.discovery_packet";
    public static final String HOST_STATUS = "device.host_status";
    public static final String NETWORK_DEFAULT = "device.prompted_default_network";
    public static final String NETWORK_DEFAULT_JSON = "{}{\"device.prompted_default_network\":\"y\"}";
    public static final String NETWORK_RESET = "device.prompted_network_reset";
    public static final String NETWORK_RESET_JSON = "{}{\"device.prompted_network_reset\":\"y\"}";
    public static final String PRINTER_DEFAULT = "ezpl.restore_defaults";
    public static final String PRINTER_DEFAULT_JSON = "{}{\"ezpl.restore_defaults\":\"reload printer\"}";
    public static final String PRINTER_RESET_JSON = "{}{\"device.reset\":\"\"}";

    public static String decorateWithGetCommand(String str) {
        return "! U1 getvar \"" + str + "\"" + StringUtilities.CRLF;
    }
}
