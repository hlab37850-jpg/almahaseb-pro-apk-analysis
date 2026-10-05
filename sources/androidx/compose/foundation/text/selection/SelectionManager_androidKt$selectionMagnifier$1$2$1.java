package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.MagnifierKt;
import androidx.compose.foundation.MagnifierStyle;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionManager_androidKt$selectionMagnifier$1$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Density $density;
    final /* synthetic */ MutableState<IntSize> $magnifierSize$delegate;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$2$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3588op $center;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC3588op interfaceC3588op) {
            super(1);
            this.$center = interfaceC3588op;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Offset.m2787boximpl(m941invoketuRUvjQ((Density) obj));
        }

        /* JADX INFO: renamed from: invoke-tuRUvjQ, reason: not valid java name */
        public final long m941invoketuRUvjQ(Density density) {
            AbstractC4492zt.h(density, "$this$magnifier");
            return ((Offset) this.$center.invoke()).m2808unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$2$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Density $density;
        final /* synthetic */ MutableState<IntSize> $magnifierSize$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Density density, MutableState<IntSize> mutableState) {
            super(1);
            this.$density = density;
            this.$magnifierSize$delegate = mutableState;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m942invokeEaSLcWc(((DpSize) obj).m5266unboximpl());
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke-EaSLcWc, reason: not valid java name */
        public final void m942invokeEaSLcWc(long j) {
            MutableState<IntSize> mutableState = this.$magnifierSize$delegate;
            Density density = this.$density;
            SelectionManager_androidKt.AnonymousClass1.invoke$lambda$2(mutableState, IntSizeKt.IntSize(density.mo327roundToPx0680j_4(DpSize.m5258getWidthD9Ej5fM(j)), density.mo327roundToPx0680j_4(DpSize.m5256getHeightD9Ej5fM(j))));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionManager_androidKt$selectionMagnifier$1$2$1(Density density, MutableState<IntSize> mutableState) {
        super(1);
        this.$density = density;
        this.$magnifierSize$delegate = mutableState;
    }

    @Override // defpackage.InterfaceC3750qp
    public final Modifier invoke(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "center");
        return MagnifierKt.magnifier$default(Modifier.Companion, new AnonymousClass1(interfaceC3588op), null, 0.0f, MagnifierStyle.Companion.getTextDefault(), new AnonymousClass2(this.$density, this.$magnifierSize$delegate), 6, null);
    }
}
