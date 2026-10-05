package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class OffsetKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.OffsetKt$absoluteOffset$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ float $x;
        final /* synthetic */ float $y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(float f, float f2) {
            super(1);
            this.$x = f;
            this.$y = f2;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((InspectorInfo) obj);
            return FW.a;
        }

        public final void invoke(InspectorInfo inspectorInfo) {
            AbstractC4492zt.h(inspectorInfo, "$this$$receiver");
            inspectorInfo.setName("absoluteOffset");
            inspectorInfo.getProperties().set("x", Dp.m5158boximpl(this.$x));
            inspectorInfo.getProperties().set("y", Dp.m5158boximpl(this.$y));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.OffsetKt$absoluteOffset$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $offset;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$offset = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((InspectorInfo) obj);
            return FW.a;
        }

        public final void invoke(InspectorInfo inspectorInfo) {
            AbstractC4492zt.h(inspectorInfo, "$this$$receiver");
            inspectorInfo.setName("absoluteOffset");
            inspectorInfo.getProperties().set(TypedValues.CycleType.S_WAVE_OFFSET, this.$offset);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.OffsetKt$offset$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13471 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ float $x;
        final /* synthetic */ float $y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13471(float f, float f2) {
            super(1);
            this.$x = f;
            this.$y = f2;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((InspectorInfo) obj);
            return FW.a;
        }

        public final void invoke(InspectorInfo inspectorInfo) {
            AbstractC4492zt.h(inspectorInfo, "$this$$receiver");
            inspectorInfo.setName(TypedValues.CycleType.S_WAVE_OFFSET);
            inspectorInfo.getProperties().set("x", Dp.m5158boximpl(this.$x));
            inspectorInfo.getProperties().set("y", Dp.m5158boximpl(this.$y));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.OffsetKt$offset$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13482 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $offset;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13482(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$offset = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((InspectorInfo) obj);
            return FW.a;
        }

        public final void invoke(InspectorInfo inspectorInfo) {
            AbstractC4492zt.h(inspectorInfo, "$this$$receiver");
            inspectorInfo.setName(TypedValues.CycleType.S_WAVE_OFFSET);
            inspectorInfo.getProperties().set(TypedValues.CycleType.S_WAVE_OFFSET, this.$offset);
        }
    }

    public static final Modifier absoluteOffset(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, TypedValues.CycleType.S_WAVE_OFFSET);
        return modifier.then(new OffsetPxElement(interfaceC3750qp, false, new AnonymousClass2(interfaceC3750qp)));
    }

    @Stable
    /* JADX INFO: renamed from: absoluteOffset-VpY3zN4, reason: not valid java name */
    public static final Modifier m443absoluteOffsetVpY3zN4(Modifier modifier, float f, float f2) {
        AbstractC4492zt.h(modifier, "$this$absoluteOffset");
        return modifier.then(new OffsetElement(f, f2, false, new AnonymousClass1(f, f2), null));
    }

    /* JADX INFO: renamed from: absoluteOffset-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m444absoluteOffsetVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m5160constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m5160constructorimpl(0);
        }
        return m443absoluteOffsetVpY3zN4(modifier, f, f2);
    }

    public static final Modifier offset(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, TypedValues.CycleType.S_WAVE_OFFSET);
        return modifier.then(new OffsetPxElement(interfaceC3750qp, true, new C13482(interfaceC3750qp)));
    }

    @Stable
    /* JADX INFO: renamed from: offset-VpY3zN4, reason: not valid java name */
    public static final Modifier m445offsetVpY3zN4(Modifier modifier, float f, float f2) {
        AbstractC4492zt.h(modifier, "$this$offset");
        return modifier.then(new OffsetElement(f, f2, true, new C13471(f, f2), null));
    }

    /* JADX INFO: renamed from: offset-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m446offsetVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m5160constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m5160constructorimpl(0);
        }
        return m445offsetVpY3zN4(modifier, f, f2);
    }
}
