package defpackage;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: vx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4162vx extends AbstractC4081ux {
    public static Map b(Map map) {
        AbstractC4492zt.h(map, "builder");
        return ((C3514nx) map).n();
    }

    public static Map c() {
        return new C3514nx();
    }

    public static int d(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map e(C2020dG c2020dG) {
        AbstractC4492zt.h(c2020dG, "pair");
        Map mapSingletonMap = Collections.singletonMap(c2020dG.c(), c2020dG.e());
        AbstractC4492zt.g(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final Map f(Map map) {
        AbstractC4492zt.h(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        AbstractC4492zt.g(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }
}
