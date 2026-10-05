package androidx.compose.foundation;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class IndicationKt$LocalIndication$1 extends AbstractC2233fv implements InterfaceC3588op {
    public static final IndicationKt$LocalIndication$1 INSTANCE = new IndicationKt$LocalIndication$1();

    public IndicationKt$LocalIndication$1() {
        super(0);
    }

    @Override // defpackage.InterfaceC3588op
    public final Indication invoke() {
        return DefaultDebugIndication.INSTANCE;
    }
}
