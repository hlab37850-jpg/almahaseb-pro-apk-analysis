package defpackage;

import com.google.common.base.Predicate;
import com.google.common.collect.ListMultimap;
import java.util.List;

/* JADX INFO: renamed from: qm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3747qm extends C3827rm implements ListMultimap {
    public C3747qm(ListMultimap listMultimap, Predicate predicate) {
        super(listMultimap, predicate);
    }

    @Override // defpackage.C3827rm, defpackage.InterfaceC3989tm
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ListMultimap a() {
        return (ListMultimap) super.a();
    }

    @Override // defpackage.C3827rm, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public List get(Object obj) {
        return (List) super.get(obj);
    }

    @Override // defpackage.C3827rm, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public List removeAll(Object obj) {
        return (List) super.removeAll(obj);
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public List replaceValues(Object obj, Iterable iterable) {
        return (List) super.replaceValues(obj, iterable);
    }
}
