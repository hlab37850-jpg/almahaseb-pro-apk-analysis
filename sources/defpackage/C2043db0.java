package defpackage;

import java.util.Iterator;

/* JADX INFO: renamed from: db0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2043db0 extends C3485nb0 {
    public final /* synthetic */ Za0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2043db0(Za0 za0) {
        super(za0, null);
        this.b = za0;
    }

    @Override // defpackage.C3485nb0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new C1885cb0(this.b, null);
    }

    public /* synthetic */ C2043db0(Za0 za0, C1804bb0 c1804bb0) {
        this(za0);
    }
}
