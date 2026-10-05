package defpackage;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: qj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3744qj extends K {
    public C3744qj(Map map, Map map2, int i) {
        super(map, map2, i);
    }

    public static C3744qj n() {
        return new C3744qj(HashBiMap.create(2), HashBiMap.create(2), 0);
    }

    public static C3744qj o(Map map, Map map2, int i) {
        return new C3744qj(ImmutableBiMap.copyOf(map), ImmutableBiMap.copyOf(map2), i);
    }

    @Override // defpackage.InterfaceC3459nD
    public Set b() {
        return Collections.unmodifiableSet(((BiMap) this.b).values());
    }

    @Override // defpackage.InterfaceC3459nD
    public Set c() {
        return Collections.unmodifiableSet(((BiMap) this.a).values());
    }

    @Override // defpackage.InterfaceC3459nD
    public Set k(Object obj) {
        return new C0721Lk(((BiMap) this.b).inverse(), obj);
    }
}
