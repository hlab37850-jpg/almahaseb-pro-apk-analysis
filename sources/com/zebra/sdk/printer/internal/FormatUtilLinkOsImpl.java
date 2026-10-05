package com.zebra.sdk.printer.internal;

import com.google.android.material.timepicker.TimeModel;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.graphics.ZebraImageI;
import com.zebra.sdk.printer.FormatUtilLinkOs;
import com.zebra.sdk.printer.ZebraPrinterLinkOs;
import com.zebra.sdk.util.internal.ZPLUtilities;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FormatUtilLinkOsImpl implements FormatUtilLinkOs {
    private ZebraPrinterLinkOs printer;

    public FormatUtilLinkOsImpl(ZebraPrinterLinkOs zebraPrinterLinkOs) {
        this.printer = zebraPrinterLinkOs;
    }

    private int getVariableNumber(String str, int i, int i2, int i3) {
        int i4 = i + 3;
        if (i3 != -1 && i2 >= i3) {
            i2 = i3;
        }
        return Integer.parseInt(str.substring(i4, i2));
    }

    @Override // com.zebra.sdk.printer.FormatUtilLinkOs
    public void printStoredFormatWithVarGraphics(String str, Map<Integer, String> map) {
        printStoredFormatWithVarGraphics(str, map, System.getProperty("file.encoding"));
    }

    @Override // com.zebra.sdk.printer.FormatUtilLinkOs
    public void printStoredFormatWithVarGraphics(String str, Map<Integer, String> map, String str2) {
        String strSubstring;
        int i;
        try {
            String strSubstring2 = str.substring(str.indexOf(":") + 1, str.lastIndexOf("."));
            String strReplace = ZPLUtilities.replaceInternalCharactersWithReadableCharacters(new String(this.printer.retrieveFormatFromPrinter(str))).replace("^DF" + strSubstring2 + ",", "").replace("^DF" + str + "^FS", "");
            int iIndexOf = 0;
            while (true) {
                iIndexOf = strReplace.indexOf("^XG^FN", iIndexOf + 1);
                if (iIndexOf == -1) {
                    break;
                }
                int iIndexOf2 = strReplace.indexOf(",", iIndexOf);
                int iIndexOf3 = strReplace.indexOf("\"", iIndexOf);
                int i2 = iIndexOf + 6;
                if (iIndexOf3 != -1) {
                    if (iIndexOf2 >= iIndexOf3) {
                        iIndexOf2 = iIndexOf3;
                    }
                    i = Integer.parseInt(strReplace.substring(i2, iIndexOf2));
                    strReplace = strReplace.replace(strReplace.substring(iIndexOf3, strReplace.indexOf("\"", iIndexOf3 + 1) + 1), "");
                } else {
                    i = Integer.parseInt(strReplace.substring(i2, iIndexOf2));
                }
                strReplace = strReplace.replaceFirst("\\^FN" + i, map.get(Integer.valueOf(i)));
            }
            while (true) {
                int iIndexOf4 = strReplace.indexOf("^FN");
                if (iIndexOf4 == -1) {
                    this.printer.getConnection().write(ZPLUtilities.replaceAllWithInternalCharacters(strReplace).getBytes(str2));
                    return;
                }
                int i3 = iIndexOf4 + 1;
                int iIndexOf5 = strReplace.indexOf("^", i3);
                int iIndexOf6 = strReplace.indexOf("\"", i3);
                String strSubstring3 = strReplace.substring(iIndexOf4, iIndexOf5);
                if (strReplace.indexOf("^FD") == iIndexOf5) {
                    strSubstring = strReplace.substring(iIndexOf5, strReplace.indexOf("^", iIndexOf5 + 1));
                    strReplace = strReplace.replace(strSubstring, "");
                } else {
                    strSubstring = "^FD" + map.get(Integer.valueOf(getVariableNumber(strReplace, iIndexOf4, iIndexOf5, iIndexOf6)));
                }
                strReplace = strReplace.replace(strSubstring3, strSubstring);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override // com.zebra.sdk.printer.FormatUtilLinkOs
    public void printStoredFormatWithVarGraphics(String str, Map<Integer, ZebraImageI> map, Map<Integer, String> map2) throws Throwable {
        printStoredFormatWithVarGraphics(str, map, map2, System.getProperty("file.encoding"));
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    @Override // com.zebra.sdk.printer.FormatUtilLinkOs
    public void printStoredFormatWithVarGraphics(String str, Map<Integer, ZebraImageI> map, Map<Integer, String> map2, String str2) throws Throwable {
        GraphicsUtilZpl graphicsUtilZpl = new GraphicsUtilZpl(this.printer.getConnection());
        int i = 1;
        for (Integer num : map.keySet()) {
            int i2 = i + 1;
            try {
                String str3 = "R:SDK" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i)) + ".GRF";
                graphicsUtilZpl.storeImage(str3, map.get(num), map.get(num).getWidth(), map.get(num).getHeight());
                map2.put(num, str3);
            } catch (ZebraIllegalArgumentException e) {
                e.printStackTrace();
            }
            i = i2;
        }
        printStoredFormatWithVarGraphics(str, map2, str2);
    }
}
