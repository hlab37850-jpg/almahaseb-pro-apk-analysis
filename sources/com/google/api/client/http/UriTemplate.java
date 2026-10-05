package com.google.api.client.http;

import com.google.api.client.repackaged.com.google.common.base.Splitter;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UriTemplate {
    private static final String COMPOSITE_NON_EXPLODE_JOINER = ",";
    static final Map<Character, a> COMPOSITE_PREFIXES = new HashMap();

    public enum a {
        PLUS('+', "", UriTemplate.COMPOSITE_NON_EXPLODE_JOINER, false, true),
        HASH('#', "#", UriTemplate.COMPOSITE_NON_EXPLODE_JOINER, false, true),
        DOT('.', ".", ".", false, false),
        FORWARD_SLASH('/', "/", "/", false, false),
        SEMI_COLON(';', ";", ";", true, false),
        QUERY('?', "?", "&", true, false),
        AMP('&', "&", "&", true, false),
        SIMPLE(null, "", UriTemplate.COMPOSITE_NON_EXPLODE_JOINER, false, false);

        public final Character a;
        public final String b;
        public final String c;
        public final boolean d;
        public final boolean e;

        a(Character ch, String str, String str2, boolean z, boolean z2) {
            this.a = ch;
            this.b = (String) Preconditions.checkNotNull(str);
            this.c = (String) Preconditions.checkNotNull(str2);
            this.d = z;
            this.e = z2;
            if (ch != null) {
                UriTemplate.COMPOSITE_PREFIXES.put(ch, this);
            }
        }

        public String a(String str) {
            return this.e ? CharEscapers.escapeUriPath(str) : CharEscapers.escapeUri(str);
        }

        public String b() {
            return this.c;
        }

        public String c() {
            return this.b;
        }

        public boolean e() {
            return this.e;
        }

        public int f() {
            return this.a == null ? 0 : 1;
        }

        public boolean h() {
            return this.d;
        }
    }

    static {
        a.values();
    }

    public static String expand(String str, String str2, Object obj, boolean z) {
        if (str2.startsWith("/")) {
            GenericUrl genericUrl = new GenericUrl(str);
            genericUrl.setRawPath(null);
            str2 = genericUrl.build() + str2;
        } else if (!str2.startsWith("http://") && !str2.startsWith("https://")) {
            str2 = str + str2;
        }
        return expand(str2, obj, z);
    }

    public static a getCompositeOutput(String str) {
        a aVar = COMPOSITE_PREFIXES.get(Character.valueOf(str.charAt(0)));
        return aVar == null ? a.SIMPLE : aVar;
    }

    private static String getListPropertyValue(String str, Iterator<?> it, boolean z, a aVar) {
        String strB;
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            strB = aVar.b();
        } else {
            if (aVar.h()) {
                sb.append(CharEscapers.escapeUriPath(str));
                sb.append("=");
            }
            strB = COMPOSITE_NON_EXPLODE_JOINER;
        }
        while (it.hasNext()) {
            if (z && aVar.h()) {
                sb.append(CharEscapers.escapeUriPath(str));
                sb.append("=");
            }
            sb.append(aVar.a(it.next().toString()));
            if (it.hasNext()) {
                sb.append(strB);
            }
        }
        return sb.toString();
    }

    private static Map<String, Object> getMap(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : Data.mapOf(obj).entrySet()) {
            Object value = entry.getValue();
            if (value != null && !Data.isNull(value)) {
                linkedHashMap.put(entry.getKey(), value);
            }
        }
        return linkedHashMap;
    }

    private static String getMapPropertyValue(String str, Map<String, Object> map, boolean z, a aVar) {
        String strB;
        if (map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String str2 = "=";
        if (z) {
            strB = aVar.b();
        } else {
            if (aVar.h()) {
                sb.append(CharEscapers.escapeUriPath(str));
                sb.append("=");
            }
            str2 = COMPOSITE_NON_EXPLODE_JOINER;
            strB = COMPOSITE_NON_EXPLODE_JOINER;
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            String strA = aVar.a(next.getKey());
            String strA2 = aVar.a(next.getValue().toString());
            sb.append(strA);
            sb.append(str2);
            sb.append(strA2);
            if (it.hasNext()) {
                sb.append(strB);
            }
        }
        return sb.toString();
    }

    public static String expand(String str, Object obj, boolean z) {
        Object listPropertyValue;
        Map<String, Object> map = getMap(obj);
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int iIndexOf = str.indexOf(123, i);
            if (iIndexOf == -1) {
                if (i == 0 && !z) {
                    return str;
                }
                sb.append(str.substring(i));
                break;
            }
            sb.append(str.substring(i, iIndexOf));
            int iIndexOf2 = str.indexOf(125, iIndexOf + 2);
            int i2 = iIndexOf2 + 1;
            String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
            a compositeOutput = getCompositeOutput(strSubstring);
            ListIterator<String> listIterator = Splitter.on(',').splitToList(strSubstring).listIterator();
            boolean z2 = true;
            while (listIterator.hasNext()) {
                String next = listIterator.next();
                boolean zEndsWith = next.endsWith("*");
                int iF = listIterator.nextIndex() == 1 ? compositeOutput.f() : 0;
                int length2 = next.length();
                if (zEndsWith) {
                    length2--;
                }
                String strSubstring2 = next.substring(iF, length2);
                Object objRemove = map.remove(strSubstring2);
                if (objRemove != null) {
                    if (!z2) {
                        sb.append(compositeOutput.b());
                    } else {
                        sb.append(compositeOutput.c());
                        z2 = false;
                    }
                    if (objRemove instanceof Iterator) {
                        listPropertyValue = getListPropertyValue(strSubstring2, (Iterator) objRemove, zEndsWith, compositeOutput);
                    } else if (!(objRemove instanceof Iterable) && !objRemove.getClass().isArray()) {
                        if (objRemove.getClass().isEnum()) {
                            if (FieldInfo.of((Enum<?>) objRemove).getName() != null) {
                                if (compositeOutput.h()) {
                                    objRemove = String.format("%s=%s", strSubstring2, objRemove);
                                }
                                objRemove = CharEscapers.escapeUriPath(objRemove.toString());
                            }
                            listPropertyValue = objRemove;
                        } else if (!Data.isValueOfPrimitiveType(objRemove)) {
                            listPropertyValue = getMapPropertyValue(strSubstring2, getMap(objRemove), zEndsWith, compositeOutput);
                        } else {
                            if (compositeOutput.h()) {
                                objRemove = String.format("%s=%s", strSubstring2, objRemove);
                            }
                            if (compositeOutput.e()) {
                                listPropertyValue = CharEscapers.escapeUriPathWithoutReserved(objRemove.toString());
                            } else {
                                listPropertyValue = CharEscapers.escapeUriPath(objRemove.toString());
                            }
                        }
                    } else {
                        listPropertyValue = getListPropertyValue(strSubstring2, Types.iterableOf(objRemove).iterator(), zEndsWith, compositeOutput);
                    }
                    sb.append(listPropertyValue);
                }
            }
            i = i2;
        }
        if (z) {
            GenericUrl.addQueryParams(map.entrySet(), sb);
        }
        return sb.toString();
    }
}
