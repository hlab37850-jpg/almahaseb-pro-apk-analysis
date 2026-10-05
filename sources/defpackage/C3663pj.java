package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: pj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3663pj extends K {
    public transient Reference d;
    public transient Reference e;

    /* JADX INFO: renamed from: pj$a */
    public class a extends AbstractC3376mC {
        public final /* synthetic */ Object c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Map map, Object obj, Object obj2) {
            super(map, obj);
            this.c = obj2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C3663pj.this.s().count(this.c);
        }
    }

    public C3663pj(Map map, Map map2, int i) {
        super(map, map2, i);
    }

    public static Object o(Reference reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public static C3663pj p() {
        return new C3663pj(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
    }

    public static C3663pj q(Map map, Map map2, int i) {
        return new C3663pj(ImmutableMap.copyOf(map), ImmutableMap.copyOf(map2), i);
    }

    @Override // defpackage.InterfaceC3459nD
    public Set b() {
        return Collections.unmodifiableSet(s().elementSet());
    }

    @Override // defpackage.InterfaceC3459nD
    public Set c() {
        return Collections.unmodifiableSet(r().elementSet());
    }

    @Override // defpackage.K, defpackage.InterfaceC3459nD
    public Object d(Object obj, boolean z) {
        Object objD = super.d(obj, z);
        Multiset multiset = (Multiset) o(this.d);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(objD));
        }
        return objD;
    }

    @Override // defpackage.K, defpackage.InterfaceC3459nD
    public Object h(Object obj) {
        Object objH = super.h(obj);
        Multiset multiset = (Multiset) o(this.e);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(objH));
        }
        return objH;
    }

    @Override // defpackage.K, defpackage.InterfaceC3459nD
    public void j(Object obj, Object obj2) {
        super.j(obj, obj2);
        Multiset multiset = (Multiset) o(this.e);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(obj2));
        }
    }

    @Override // defpackage.InterfaceC3459nD
    public Set k(Object obj) {
        return new a(this.b, obj, obj);
    }

    @Override // defpackage.K, defpackage.InterfaceC3459nD
    public void l(Object obj, Object obj2, boolean z) {
        super.l(obj, obj2, z);
        Multiset multiset = (Multiset) o(this.d);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(obj2));
        }
    }

    public final Multiset r() {
        Multiset multiset = (Multiset) o(this.d);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset hashMultisetCreate = HashMultiset.create(this.a.values());
        this.d = new SoftReference(hashMultisetCreate);
        return hashMultisetCreate;
    }

    public final Multiset s() {
        Multiset multiset = (Multiset) o(this.e);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset hashMultisetCreate = HashMultiset.create(this.b.values());
        this.e = new SoftReference(hashMultisetCreate);
        return hashMultisetCreate;
    }
}
