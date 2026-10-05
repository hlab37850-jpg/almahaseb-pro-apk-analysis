package defpackage;

import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: ux, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4081ux {
    public static final Object a(Map map, Object obj) {
        AbstractC4492zt.h(map, "<this>");
        if (map instanceof InterfaceC4000tx) {
            return ((InterfaceC4000tx) map).i(obj);
        }
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }
}
