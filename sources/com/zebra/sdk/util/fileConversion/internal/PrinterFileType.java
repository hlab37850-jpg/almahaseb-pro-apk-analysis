package com.zebra.sdk.util.fileConversion.internal;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public enum PrinterFileType implements Serializable {
    UNSUPPORTED(new String[0]),
    PRINTER_PNG(".PNG", "~DY_P"),
    PRINTER_GRF(".GRF", "~DY_G"),
    FONT(".TTF", ".TTE", ".FNT", "~DY_E", "~DY_T"),
    ZPL(".ZPL"),
    NRD(".NRD", "~DY_NRD"),
    PAC(".PAC", "~DY_PAC"),
    FIRMWARE(new String[0]),
    PCX(".PCX", "~DY_X"),
    BMP(".BMP", "~DY_B");

    private List<String> extensions;

    PrinterFileType(String... strArr) {
        this.extensions = Arrays.asList(strArr);
    }

    public static PrinterFileType getUnwrappedType(String str) {
        for (PrinterFileType printerFileType : values()) {
            if (!printerFileType.extensions.contains(str.toUpperCase())) {
                if (!printerFileType.extensions.contains("." + str.toUpperCase())) {
                }
            }
            return printerFileType;
        }
        return UNSUPPORTED;
    }
}
