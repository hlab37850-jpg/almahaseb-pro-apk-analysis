package com.zebra.sdk.util.internal;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class CPCLUtilities {
    private static final int ASCII_FF = 12;
    private static final int ASCII_H = 104;
    private static final int ASCII_V = 86;
    private static final int CPCL_ESC = 27;
    public static final String[] VERSION_PREFIXES = {"SH", "H8", "C"};
    public static final String PRINTER_STATUS = new String(new byte[]{Ascii.ESC, 104});
    public static final String PRINTER_CONFIG_LABEL = new String(new byte[]{Ascii.ESC, 86});
    public static final String PRINTER_FORM_FEED = new String(new byte[]{12});
}
