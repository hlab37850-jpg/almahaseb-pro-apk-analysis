package defpackage;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PO {
    public static Set a(Set set) {
        AbstractC4492zt.h(set, "builder");
        return ((NO) set).a();
    }

    public static Set b() {
        return new NO();
    }

    public static Set c(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        AbstractC4492zt.g(setSingleton, "singleton(...)");
        return setSingleton;
    }

    public static TreeSet d(Object... objArr) {
        AbstractC4492zt.h(objArr, "elements");
        return (TreeSet) R5.k0(objArr, new TreeSet());
    }
}
