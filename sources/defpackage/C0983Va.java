package defpackage;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: renamed from: Va, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0983Va {
    public final String a;
    public final Map b;

    public C0983Va(String str, Map map) {
        String lowerCase;
        AbstractC4492zt.h(str, "scheme");
        AbstractC4492zt.h(map, "authParams");
        this.a = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (str2 != null) {
                Locale locale = Locale.US;
                AbstractC4492zt.g(locale, "US");
                lowerCase = str2.toLowerCase(locale);
                AbstractC4492zt.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, str3);
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        AbstractC4492zt.g(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.b = mapUnmodifiableMap;
    }

    public final Charset a() {
        String str = (String) this.b.get("charset");
        if (str != null) {
            try {
                Charset charsetForName = Charset.forName(str);
                AbstractC4492zt.g(charsetForName, "forName(charset)");
                return charsetForName;
            } catch (Exception unused) {
            }
        }
        Charset charset = StandardCharsets.ISO_8859_1;
        AbstractC4492zt.g(charset, "ISO_8859_1");
        return charset;
    }

    public final String b() {
        return (String) this.b.get("realm");
    }

    public final String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0983Va) {
            C0983Va c0983Va = (C0983Va) obj;
            if (AbstractC4492zt.d(c0983Va.a, this.a) && AbstractC4492zt.d(c0983Va.b, this.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.a.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return this.a + " authParams=" + this.b;
    }
}
