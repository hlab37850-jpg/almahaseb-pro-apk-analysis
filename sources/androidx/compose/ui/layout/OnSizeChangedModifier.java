package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.YB;
import defpackage.ZB;

/* JADX INFO: loaded from: classes.dex */
final class OnSizeChangedModifier extends InspectorValueInfo implements OnRemeasuredModifier {
    private final InterfaceC3750qp onSizeChanged;
    private long previousSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnSizeChangedModifier(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        super(interfaceC3750qp2);
        AbstractC4492zt.h(interfaceC3750qp, "onSizeChanged");
        AbstractC4492zt.h(interfaceC3750qp2, "inspectorInfo");
        this.onSizeChanged = interfaceC3750qp;
        this.previousSize = IntSizeKt.IntSize(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(InterfaceC3750qp interfaceC3750qp) {
        return ZB.a(this, interfaceC3750qp);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(InterfaceC3750qp interfaceC3750qp) {
        return ZB.b(this, interfaceC3750qp);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OnSizeChangedModifier) {
            return AbstractC4492zt.d(this.onSizeChanged, ((OnSizeChangedModifier) obj).onSizeChanged);
        }
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        return ZB.c(this, obj, interfaceC0526Fp);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        return ZB.d(this, obj, interfaceC0526Fp);
    }

    public final InterfaceC3750qp getOnSizeChanged() {
        return this.onSizeChanged;
    }

    public int hashCode() {
        return this.onSizeChanged.hashCode();
    }

    @Override // androidx.compose.ui.layout.OnRemeasuredModifier
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public void mo261onRemeasuredozmzZPI(long j) {
        if (IntSize.m5318equalsimpl0(this.previousSize, j)) {
            return;
        }
        this.onSizeChanged.invoke(IntSize.m5312boximpl(j));
        this.previousSize = j;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return YB.a(this, modifier);
    }
}
