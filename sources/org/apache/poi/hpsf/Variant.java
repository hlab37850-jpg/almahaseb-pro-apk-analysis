package org.apache.poi.hpsf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Variant {
    public static final int VT_ARRAY = 8192;
    public static final int VT_BLOB = 65;
    public static final int VT_BLOB_OBJECT = 70;
    public static final int VT_BOOL = 11;
    public static final int VT_BSTR = 8;
    public static final int VT_BYREF = 16384;
    public static final int VT_CARRAY = 28;
    public static final int VT_CF = 71;
    public static final int VT_CLSID = 72;
    public static final int VT_CY = 6;
    public static final int VT_DATE = 7;
    public static final int VT_DECIMAL = 14;
    public static final int VT_DISPATCH = 9;
    public static final int VT_EMPTY = 0;
    public static final int VT_ERROR = 10;
    public static final int VT_FILETIME = 64;
    public static final int VT_HRESULT = 25;
    public static final int VT_I1 = 16;
    public static final int VT_I2 = 2;
    public static final int VT_I4 = 3;
    public static final int VT_I8 = 20;
    public static final int VT_ILLEGAL = 65535;
    public static final int VT_ILLEGALMASKED = 4095;
    public static final int VT_INT = 22;
    public static final int VT_LPSTR = 30;
    public static final int VT_LPWSTR = 31;
    public static final int VT_NULL = 1;
    public static final int VT_PTR = 26;
    public static final int VT_R4 = 4;
    public static final int VT_R8 = 5;
    public static final int VT_RESERVED = 32768;
    public static final int VT_SAFEARRAY = 27;
    public static final int VT_STORAGE = 67;
    public static final int VT_STORED_OBJECT = 69;
    public static final int VT_STREAM = 66;
    public static final int VT_STREAMED_OBJECT = 68;
    public static final int VT_TYPEMASK = 4095;
    public static final int VT_UI1 = 17;
    public static final int VT_UI2 = 18;
    public static final int VT_UI4 = 19;
    public static final int VT_UI8 = 21;
    public static final int VT_UINT = 23;
    public static final int VT_UNKNOWN = 13;
    public static final int VT_USERDEFINED = 29;
    public static final int VT_VARIANT = 12;
    public static final int VT_VECTOR = 4096;
    public static final int VT_VOID = 24;
    private static Map numberToLength;
    private static Map numberToName;
    public static final Integer LENGTH_UNKNOWN = -2;
    public static final Integer LENGTH_VARIABLE = -1;
    public static final Integer LENGTH_0 = 0;
    public static final Integer LENGTH_2 = 2;
    public static final Integer LENGTH_4 = 4;
    public static final Integer LENGTH_8 = 8;

    static {
        HashMap map = new HashMap();
        map.put(0L, "VT_EMPTY");
        map.put(1L, "VT_NULL");
        map.put(2L, "VT_I2");
        map.put(3L, "VT_I4");
        map.put(4L, "VT_R4");
        map.put(5L, "VT_R8");
        map.put(6L, "VT_CY");
        map.put(7L, "VT_DATE");
        map.put(8L, "VT_BSTR");
        map.put(9L, "VT_DISPATCH");
        map.put(10L, "VT_ERROR");
        map.put(11L, "VT_BOOL");
        map.put(12L, "VT_VARIANT");
        map.put(13L, "VT_UNKNOWN");
        map.put(14L, "VT_DECIMAL");
        map.put(16L, "VT_I1");
        map.put(17L, "VT_UI1");
        map.put(18L, "VT_UI2");
        map.put(19L, "VT_UI4");
        map.put(20L, "VT_I8");
        map.put(21L, "VT_UI8");
        map.put(22L, "VT_INT");
        map.put(23L, "VT_UINT");
        map.put(24L, "VT_VOID");
        map.put(25L, "VT_HRESULT");
        map.put(26L, "VT_PTR");
        map.put(27L, "VT_SAFEARRAY");
        map.put(28L, "VT_CARRAY");
        map.put(29L, "VT_USERDEFINED");
        map.put(30L, "VT_LPSTR");
        map.put(31L, "VT_LPWSTR");
        map.put(64L, "VT_FILETIME");
        map.put(65L, "VT_BLOB");
        map.put(66L, "VT_STREAM");
        map.put(67L, "VT_STORAGE");
        map.put(68L, "VT_STREAMED_OBJECT");
        map.put(69L, "VT_STORED_OBJECT");
        map.put(70L, "VT_BLOB_OBJECT");
        map.put(71L, "VT_CF");
        map.put(72L, "VT_CLSID");
        HashMap map2 = new HashMap(map.size(), 1.0f);
        map2.putAll(map);
        numberToName = Collections.unmodifiableMap(map2);
        map.clear();
        map.put(0L, 0);
        map.put(1L, -2);
        map.put(2L, 2);
        map.put(3L, 4);
        map.put(4L, 4);
        map.put(5L, 8);
        map.put(6L, -2);
        map.put(7L, -2);
        map.put(8L, -2);
        map.put(9L, -2);
        map.put(10L, -2);
        map.put(11L, -2);
        map.put(12L, -2);
        map.put(13L, -2);
        map.put(14L, -2);
        map.put(16L, -2);
        map.put(17L, -2);
        map.put(18L, -2);
        map.put(19L, -2);
        map.put(20L, -2);
        map.put(21L, -2);
        map.put(22L, -2);
        map.put(23L, -2);
        map.put(24L, -2);
        map.put(25L, -2);
        map.put(26L, -2);
        map.put(27L, -2);
        map.put(28L, -2);
        map.put(29L, -2);
        map.put(30L, -1);
        map.put(31L, -2);
        map.put(64L, 8);
        map.put(65L, -2);
        map.put(66L, -2);
        map.put(67L, -2);
        map.put(68L, -2);
        map.put(69L, -2);
        map.put(70L, -2);
        map.put(71L, -2);
        map.put(72L, -2);
        HashMap map3 = new HashMap(map.size(), 1.0f);
        map3.putAll(map);
        numberToLength = Collections.unmodifiableMap(map3);
    }

    public static int getVariantLength(long j) {
        Long l = (Long) numberToLength.get(Long.valueOf((int) j));
        if (l == null) {
            return -2;
        }
        return l.intValue();
    }

    public static String getVariantName(long j) {
        String str = (String) numberToName.get(Long.valueOf(j));
        return str != null ? str : "unknown variant type";
    }
}
