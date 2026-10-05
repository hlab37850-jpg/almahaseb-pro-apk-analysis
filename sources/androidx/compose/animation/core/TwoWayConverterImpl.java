package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class TwoWayConverterImpl<T, V extends AnimationVector> implements TwoWayConverter<T, V> {
    private final InterfaceC3750qp convertFromVector;
    private final InterfaceC3750qp convertToVector;

    public TwoWayConverterImpl(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        AbstractC4492zt.h(interfaceC3750qp, "convertToVector");
        AbstractC4492zt.h(interfaceC3750qp2, "convertFromVector");
        this.convertToVector = interfaceC3750qp;
        this.convertFromVector = interfaceC3750qp2;
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    public InterfaceC3750qp getConvertFromVector() {
        return this.convertFromVector;
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    public InterfaceC3750qp getConvertToVector() {
        return this.convertToVector;
    }
}
