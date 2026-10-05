package com.zebra.sdk.printer;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.internal.ConnectionBuilderInternal;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SettingsSetter {
    private SettingsSetter() {
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.zebra.sdk.comm.Connection] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.zebra.sdk.comm.Connection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public static Map<String, String> process(String str, Map<String, String> map) throws Throwable {
        Connection connectionBuild;
        ?? r0 = 0;
        mapProcessSettingsViaMap = null;
        Map<String, String> mapProcessSettingsViaMap = null;
        try {
            try {
                connectionBuild = ConnectionBuilderInternal.build(str);
                try {
                    connectionBuild.open();
                    mapProcessSettingsViaMap = ZebraPrinterFactory.createLinkOsPrinter(ZebraPrinterFactory.getInstance(connectionBuild)).processSettingsViaMap(map);
                    str = connectionBuild;
                } catch (ZebraPrinterLanguageUnknownException e) {
                    e = e;
                    e.printStackTrace();
                    str = connectionBuild;
                    if (connectionBuild != null) {
                    }
                    return mapProcessSettingsViaMap;
                }
            } catch (Throwable th) {
                th = th;
                r0 = str;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (ZebraPrinterLanguageUnknownException e2) {
            e = e2;
            connectionBuild = null;
        } catch (Throwable th2) {
            th = th2;
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
        str.close();
        return mapProcessSettingsViaMap;
    }
}
