package com.zebra.sdk.util.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.common.primitives.UnsignedBytes;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class StringUtilities {
    public static final String CRLF = "\r\n";
    public static final String LF = "\n";

    public static byte[] byteArrayPadToPlaces(int i, byte[] bArr) {
        if (bArr.length >= i) {
            return bArr;
        }
        int length = i - bArr.length;
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        while (length < i) {
            bArr2[length] = bArr[i2];
            length++;
            i2++;
        }
        return bArr2;
    }

    public static String byteArrayToHexString(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            str = (str + Integer.toString((b & UnsignedBytes.MAX_VALUE) >> 4, 16)) + Integer.toString(b & 15, 16);
        }
        return str;
    }

    public static String convertDoubleToString(double d) {
        return NumberFormat.getInstance().format(d);
    }

    public static Map<String, String> convertKeyValueJsonToMap(String str) {
        String strWriteValueAsString;
        Map map = (Map) JacksonObjectMapperFactory.getInstance().readValue(str, TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, Object.class));
        HashMap map2 = new HashMap();
        for (String str2 : map.keySet()) {
            Object obj = map.get(str2);
            if (obj instanceof Map) {
                strWriteValueAsString = new ObjectMapper().writeValueAsString(obj);
            } else if (obj instanceof String) {
                strWriteValueAsString = (String) obj;
            } else if (obj == null) {
                strWriteValueAsString = null;
            }
            map2.put(str2, strWriteValueAsString);
        }
        return map2;
    }

    public static double convertStringToDouble(String str) throws ZebraIllegalArgumentException {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            try {
                return NumberFormat.getInstance().parse(str).doubleValue();
            } catch (ParseException unused) {
                throw new ZebraIllegalArgumentException(e.getLocalizedMessage());
            }
        }
    }

    public static String convertTo16dot3(String str) {
        return convertToXdot3(str, 16);
    }

    public static String convertTo8dot3(String str) {
        return convertToXdot3(str, 8);
    }

    private static String convertToXdot3(String str, int i) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf == -1) {
            if (str.length() < i) {
                i = str.length();
            }
            return str.substring(0, i);
        }
        if (iLastIndexOf <= i) {
            i = iLastIndexOf;
        }
        String strSubstring = str.substring(0, i);
        String strSubstring2 = str.substring(iLastIndexOf);
        if (strSubstring2.length() > 4) {
            strSubstring2 = strSubstring2.substring(0, 4);
        }
        return strSubstring + strSubstring2;
    }

    public static int countSubstringOccurences(String str, String str2) {
        int iIndexOf = 0;
        int i = 0;
        while (iIndexOf >= 0) {
            iIndexOf = str.indexOf(str2, iIndexOf);
            if (iIndexOf >= 0) {
                i++;
                iIndexOf += str2.length();
            }
        }
        return i;
    }

    public static boolean doesPrefixExistInArray(String[] strArr, String str) {
        if (str == null || strArr == null || str.length() == 0 || strArr.length == 0) {
            return false;
        }
        for (int i = 0; i < strArr.length; i++) {
            String str2 = strArr[i];
            if (str2 != null && str2.length() != 0 && str.toUpperCase().startsWith(strArr[i].toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static int getIntValueForKey(Map<String, String> map, String str) {
        return Integer.parseInt(getStringValueForKey(map, str));
    }

    public static String getStringValueForKey(Map<String, String> map, String str) {
        String str2 = map.get(str);
        if (str2 == null || str2.length() <= 0) {
            throw new IllegalArgumentException();
        }
        return str2;
    }

    public static byte[] hexToByteArray(String str) throws ZebraIllegalArgumentException {
        int length = str.length();
        if (length % 2 != 0) {
            throw new ZebraIllegalArgumentException("Hex string must have an even number of digits");
        }
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            int iDigit = Character.digit(str.charAt(i), 16);
            int iDigit2 = Character.digit(str.charAt(i + 1), 16);
            if (iDigit == -1 || iDigit2 == -1) {
                throw new ZebraIllegalArgumentException("Input contains data that is not a hex digit");
            }
            bArr[i / 2] = (byte) ((iDigit << 4) + iDigit2);
        }
        return bArr;
    }

    public static int indexOf(String str, String[] strArr, int i) {
        int length = str.length();
        for (String str2 : strArr) {
            int iIndexOf = str.indexOf(str2, i);
            if (iIndexOf >= 0 && iIndexOf < length) {
                length = iIndexOf;
            }
        }
        if (length == str.length()) {
            return -1;
        }
        return length;
    }

    public static String join(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return "";
        }
        String str2 = "";
        for (String str3 : strArr) {
            str2 = str2 + str3 + str;
        }
        return !str2.equals("") ? str2.substring(0, str2.length() - str.length()) : str2;
    }

    public static String padWithChar(String str, char c, int i, boolean z) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int length = i - str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (z) {
                stringBuffer.insert(0, c);
            } else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

    public static String repeat(String str, int i) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str.length() * i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static String[] split(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        int iIndexOf = 0;
        int length = 0;
        while (iIndexOf >= 0) {
            iIndexOf = str.indexOf(str2, length);
            if (iIndexOf >= 0) {
                arrayList.add(str.substring(length, iIndexOf));
                length = str2.length() + iIndexOf;
            } else if (length <= str.length() - 1) {
                arrayList.add(str.substring(length));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static String stringPadToPlaces(int i, char c, String str, boolean z) {
        if (str.length() >= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i - str.length(); i2++) {
            sb.append(c);
        }
        if (z) {
            sb = sb.insert(0, str, 0, str.length());
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public static long stringToLong(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            try {
                char cCharAt = str.charAt(i);
                Integer.parseInt("" + cCharAt);
                sb.append(cCharAt);
            } catch (NumberFormatException unused) {
            }
        }
        return Long.parseLong(sb.toString());
    }

    public static String stripQuotes(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\"') {
                stringBuffer.append(cCharAt);
            }
        }
        return stringBuffer.toString();
    }

    public static List<String> toList(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; strArr != null && i < strArr.length; i++) {
            arrayList.add(strArr[i]);
        }
        return arrayList;
    }

    public static Map<String, String> convertKeyValueJsonToMap(byte[] bArr) {
        return convertKeyValueJsonToMap(new String(bArr, "utf-8"));
    }

    public static String stringPadToPlaces(int i, String str, String str2) {
        if (str2.length() >= i) {
            return str2;
        }
        String str3 = "";
        for (int i2 = 0; i2 < i - str2.length(); i2++) {
            str3 = str3 + str;
        }
        return str3 + str2;
    }

    public static List<String> toList(String[][] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String[] strArr2 : strArr) {
            for (String str : strArr2) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static String stringPadToPlaces(int i, String str, String str2, boolean z) {
        if (str2.length() >= i) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i - str2.length(); i2++) {
            sb.append(str);
        }
        if (z) {
            sb = sb.insert(0, str2, 0, str2.length());
        } else {
            sb.append(str2);
        }
        return sb.toString();
    }
}
