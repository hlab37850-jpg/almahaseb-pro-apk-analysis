package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: ut, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4077ut extends LinkedHashMap {
    public static final C4077ut a = new C4077ut();

    public C4077ut() {
        super(100, 0.8f, true);
    }

    public synchronized String a(String str) {
        String strIntern;
        strIntern = (String) get(str);
        if (strIntern == null) {
            strIntern = str.intern();
            put(strIntern, strIntern);
        }
        return strIntern;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry entry) {
        return size() > 100;
    }
}
