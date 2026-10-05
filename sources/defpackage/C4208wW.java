package defpackage;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: wW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4208wW extends AbstractC3842s0 {
    public C4208wW(Map map) {
        super(map);
    }

    public static C4208wW m() {
        return new C4208wW(HashBiMap.create(2));
    }

    public static C4208wW n(Map map) {
        return new C4208wW(ImmutableBiMap.copyOf(map));
    }

    @Override // defpackage.InterfaceC3459nD
    public Set a() {
        return Collections.unmodifiableSet(((BiMap) this.a).values());
    }

    @Override // defpackage.InterfaceC3459nD
    public Set k(Object obj) {
        return new C0721Lk(((BiMap) this.a).inverse(), obj);
    }
}
