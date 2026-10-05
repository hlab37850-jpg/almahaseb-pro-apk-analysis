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

/* JADX INFO: renamed from: vW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4127vW extends AbstractC3842s0 {
    public transient Reference b;

    /* JADX INFO: renamed from: vW$a */
    public class a extends AbstractC3376mC {
        public final /* synthetic */ Object c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Map map, Object obj, Object obj2) {
            super(map, obj);
            this.c = obj2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C4127vW.this.n().count(this.c);
        }
    }

    public C4127vW(Map map) {
        super(map);
    }

    private static Object o(Reference reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public static C4127vW p() {
        return new C4127vW(new HashMap(2, 1.0f));
    }

    public static C4127vW q(Map map) {
        return new C4127vW(ImmutableMap.copyOf(map));
    }

    @Override // defpackage.InterfaceC3459nD
    public Set a() {
        return Collections.unmodifiableSet(n().elementSet());
    }

    @Override // defpackage.AbstractC3842s0, defpackage.InterfaceC3459nD
    public Object d(Object obj, boolean z) {
        if (z) {
            return null;
        }
        return h(obj);
    }

    @Override // defpackage.AbstractC3842s0, defpackage.InterfaceC3459nD
    public Object h(Object obj) {
        Object objH = super.h(obj);
        Multiset multiset = (Multiset) o(this.b);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(objH));
        }
        return objH;
    }

    @Override // defpackage.AbstractC3842s0, defpackage.InterfaceC3459nD
    public void j(Object obj, Object obj2) {
        super.j(obj, obj2);
        Multiset multiset = (Multiset) o(this.b);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(obj2));
        }
    }

    @Override // defpackage.InterfaceC3459nD
    public Set k(Object obj) {
        return new a(this.a, obj, obj);
    }

    @Override // defpackage.AbstractC3842s0, defpackage.InterfaceC3459nD
    public void l(Object obj, Object obj2, boolean z) {
        if (z) {
            return;
        }
        j(obj, obj2);
    }

    public final Multiset n() {
        Multiset multiset = (Multiset) o(this.b);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset hashMultisetCreate = HashMultiset.create(this.a.values());
        this.b = new SoftReference(hashMultisetCreate);
        return hashMultisetCreate;
    }
}
