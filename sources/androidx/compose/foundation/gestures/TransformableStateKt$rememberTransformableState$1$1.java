package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class TransformableStateKt$rememberTransformableState$1$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ State<InterfaceC0552Gp> $lambdaState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TransformableStateKt$rememberTransformableState$1$1(State<? extends InterfaceC0552Gp> state) {
        super(3);
        this.$lambdaState = state;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m365invoked4ec7I(((Number) obj).floatValue(), ((Offset) obj2).m2808unboximpl(), ((Number) obj3).floatValue());
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
    public final void m365invoked4ec7I(float f, long j, float f2) {
        this.$lambdaState.getValue().invoke(Float.valueOf(f), Offset.m2787boximpl(j), Float.valueOf(f2));
    }
}
