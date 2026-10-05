package defpackage;

import com.google.common.base.Predicate;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.q;
import java.util.Set;

/* JADX INFO: renamed from: pm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3666pm extends q implements InterfaceC4151vm {
    public C3666pm(SetMultimap setMultimap, Predicate predicate) {
        super(setMultimap, predicate);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.AbstractC1954d
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Set createEntries() {
        return Sets.filter(a().entries(), b());
    }

    @Override // com.google.common.collect.q, defpackage.InterfaceC3989tm
    public SetMultimap a() {
        return (SetMultimap) this.a;
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public Set entries() {
        return (Set) super.entries();
    }

    @Override // com.google.common.collect.q, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Set get(Object obj) {
        return (Set) super.get(obj);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Set removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Set replaceValues(Object obj, Iterable iterable) {
        return (Set) super.replaceValues(obj, iterable);
    }
}
