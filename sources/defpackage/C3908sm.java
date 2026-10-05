package defpackage;

import com.google.common.base.Predicate;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Set;

/* JADX INFO: renamed from: sm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3908sm extends C3827rm implements InterfaceC4151vm {

    /* JADX INFO: renamed from: sm$a */
    public class a extends C3827rm.c implements Set {
        public a(C3908sm c3908sm) {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.equalsImpl(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    public C3908sm(SetMultimap setMultimap, Predicate predicate) {
        super(setMultimap, predicate);
    }

    @Override // defpackage.C3827rm, com.google.common.collect.AbstractC1954d
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Set createEntries() {
        return new a(this);
    }

    @Override // defpackage.C3827rm, defpackage.InterfaceC3989tm
    public SetMultimap a() {
        return (SetMultimap) this.a;
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public Set entries() {
        return (Set) super.entries();
    }

    @Override // defpackage.C3827rm, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Set get(Object obj) {
        return (Set) super.get(obj);
    }

    @Override // defpackage.C3827rm, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Set removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Set replaceValues(Object obj, Iterable iterable) {
        return (Set) super.replaceValues(obj, iterable);
    }
}
