package com.itextpdf.text.pdf.qrcode;

import com.google.zxing.common.StringUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class CharacterSetECI {
    private static HashMap<String, CharacterSetECI> NAME_TO_ECI;
    private final String encodingName;
    private final int value;

    private CharacterSetECI(int i, String str) {
        this.encodingName = str;
        this.value = i;
    }

    private static void addCharacterSet(int i, String str, HashMap<String, CharacterSetECI> map) {
        map.put(str, new CharacterSetECI(i, str));
    }

    public static CharacterSetECI getCharacterSetECIByName(String str) {
        if (NAME_TO_ECI == null) {
            initialize();
        }
        return NAME_TO_ECI.get(str);
    }

    private static void initialize() {
        HashMap<String, CharacterSetECI> map = new HashMap<>(29);
        addCharacterSet(0, "Cp437", map);
        addCharacterSet(1, new String[]{"ISO8859_1", "ISO-8859-1"}, map);
        addCharacterSet(2, "Cp437", map);
        addCharacterSet(3, new String[]{"ISO8859_1", "ISO-8859-1"}, map);
        addCharacterSet(4, new String[]{"ISO8859_2", "ISO-8859-2"}, map);
        addCharacterSet(5, new String[]{"ISO8859_3", "ISO-8859-3"}, map);
        addCharacterSet(6, new String[]{"ISO8859_4", "ISO-8859-4"}, map);
        addCharacterSet(7, new String[]{"ISO8859_5", "ISO-8859-5"}, map);
        addCharacterSet(8, new String[]{"ISO8859_6", "ISO-8859-6"}, map);
        addCharacterSet(9, new String[]{"ISO8859_7", "ISO-8859-7"}, map);
        addCharacterSet(10, new String[]{"ISO8859_8", "ISO-8859-8"}, map);
        addCharacterSet(11, new String[]{"ISO8859_9", "ISO-8859-9"}, map);
        addCharacterSet(12, new String[]{"ISO8859_10", "ISO-8859-10"}, map);
        addCharacterSet(13, new String[]{"ISO8859_11", "ISO-8859-11"}, map);
        addCharacterSet(15, new String[]{"ISO8859_13", "ISO-8859-13"}, map);
        addCharacterSet(16, new String[]{"ISO8859_14", "ISO-8859-14"}, map);
        addCharacterSet(17, new String[]{"ISO8859_15", "ISO-8859-15"}, map);
        addCharacterSet(18, new String[]{"ISO8859_16", "ISO-8859-16"}, map);
        addCharacterSet(20, new String[]{StringUtils.SHIFT_JIS, "Shift_JIS"}, map);
        NAME_TO_ECI = map;
    }

    public String getEncodingName() {
        return this.encodingName;
    }

    public int getValue() {
        return this.value;
    }

    private static void addCharacterSet(int i, String[] strArr, HashMap<String, CharacterSetECI> map) {
        CharacterSetECI characterSetECI = new CharacterSetECI(i, strArr[0]);
        for (String str : strArr) {
            map.put(str, characterSetECI);
        }
    }
}
