package defpackage;

import java.util.Iterator;

/* JADX INFO: renamed from: pg0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3659pg0 extends C4144vg0 {
    public final /* synthetic */ AbstractC3577og0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3659pg0(AbstractC3577og0 abstractC3577og0) {
        super(abstractC3577og0, null);
        this.b = abstractC3577og0;
    }

    @Override // defpackage.C4144vg0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new C3740qg0(this.b, null);
    }

    public /* synthetic */ C3659pg0(AbstractC3577og0 abstractC3577og0, C3495ng0 c3495ng0) {
        this(abstractC3577og0);
    }
}
