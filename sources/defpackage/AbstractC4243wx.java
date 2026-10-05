package defpackage;

import com.itextpdf.text.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: wx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4243wx extends AbstractC4162vx {
    public static Map g() {
        C2223fl c2223fl = C2223fl.a;
        AbstractC4492zt.f(c2223fl, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return c2223fl;
    }

    public static Object h(Map map, Object obj) {
        AbstractC4492zt.h(map, "<this>");
        return AbstractC4081ux.a(map, obj);
    }

    public static HashMap i(C2020dG... c2020dGArr) {
        AbstractC4492zt.h(c2020dGArr, "pairs");
        HashMap map = new HashMap(AbstractC4162vx.d(c2020dGArr.length));
        p(map, c2020dGArr);
        return map;
    }

    public static Map j(C2020dG... c2020dGArr) {
        AbstractC4492zt.h(c2020dGArr, "pairs");
        return c2020dGArr.length > 0 ? u(c2020dGArr, new LinkedHashMap(AbstractC4162vx.d(c2020dGArr.length))) : g();
    }

    public static Map k(C2020dG... c2020dGArr) {
        AbstractC4492zt.h(c2020dGArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC4162vx.d(c2020dGArr.length));
        p(linkedHashMap, c2020dGArr);
        return linkedHashMap;
    }

    public static final Map l(Map map) {
        AbstractC4492zt.h(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : AbstractC4162vx.f(map);
        }
        return g();
    }

    public static Map m(Map map, C2020dG c2020dG) {
        AbstractC4492zt.h(map, "<this>");
        AbstractC4492zt.h(c2020dG, "pair");
        if (map.isEmpty()) {
            return AbstractC4162vx.e(c2020dG);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(c2020dG.c(), c2020dG.e());
        return linkedHashMap;
    }

    public static void n(Map map, InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(map, "<this>");
        AbstractC4492zt.h(interfaceC4362yO, "pairs");
        Iterator it = interfaceC4362yO.iterator();
        while (it.hasNext()) {
            C2020dG c2020dG = (C2020dG) it.next();
            map.put(c2020dG.a(), c2020dG.b());
        }
    }

    public static void o(Map map, Iterable iterable) {
        AbstractC4492zt.h(map, "<this>");
        AbstractC4492zt.h(iterable, "pairs");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            C2020dG c2020dG = (C2020dG) it.next();
            map.put(c2020dG.a(), c2020dG.b());
        }
    }

    public static void p(Map map, C2020dG[] c2020dGArr) {
        AbstractC4492zt.h(map, "<this>");
        AbstractC4492zt.h(c2020dGArr, "pairs");
        for (C2020dG c2020dG : c2020dGArr) {
            map.put(c2020dG.a(), c2020dG.b());
        }
    }

    public static Map q(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return l(r(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return g();
        }
        if (size != 1) {
            return r(iterable, new LinkedHashMap(AbstractC4162vx.d(collection.size())));
        }
        return AbstractC4162vx.e((C2020dG) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    public static final Map r(Iterable iterable, Map map) {
        AbstractC4492zt.h(iterable, "<this>");
        AbstractC4492zt.h(map, Annotation.DESTINATION);
        o(map, iterable);
        return map;
    }

    public static Map s(Map map) {
        AbstractC4492zt.h(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? v(map) : AbstractC4162vx.f(map);
        }
        return g();
    }

    public static Map t(C2020dG[] c2020dGArr) {
        AbstractC4492zt.h(c2020dGArr, "<this>");
        int length = c2020dGArr.length;
        if (length != 0) {
            return length != 1 ? u(c2020dGArr, new LinkedHashMap(AbstractC4162vx.d(c2020dGArr.length))) : AbstractC4162vx.e(c2020dGArr[0]);
        }
        return g();
    }

    public static final Map u(C2020dG[] c2020dGArr, Map map) {
        AbstractC4492zt.h(c2020dGArr, "<this>");
        AbstractC4492zt.h(map, Annotation.DESTINATION);
        p(map, c2020dGArr);
        return map;
    }

    public static Map v(Map map) {
        AbstractC4492zt.h(map, "<this>");
        return new LinkedHashMap(map);
    }
}
