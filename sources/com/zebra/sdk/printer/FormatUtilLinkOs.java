package com.zebra.sdk.printer;

import com.zebra.sdk.graphics.ZebraImageI;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface FormatUtilLinkOs {
    void printStoredFormatWithVarGraphics(String str, Map<Integer, String> map);

    void printStoredFormatWithVarGraphics(String str, Map<Integer, String> map, String str2);

    void printStoredFormatWithVarGraphics(String str, Map<Integer, ZebraImageI> map, Map<Integer, String> map2);

    void printStoredFormatWithVarGraphics(String str, Map<Integer, ZebraImageI> map, Map<Integer, String> map2, String str2);
}
