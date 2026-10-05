package androidx.compose.foundation;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3790rJ;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0789Ob;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ProgressSemanticsKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.ProgressSemanticsKt$progressSemantics$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ int $steps;
        final /* synthetic */ float $value;
        final /* synthetic */ InterfaceC0789Ob $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(float f, InterfaceC0789Ob interfaceC0789Ob, int i) {
            super(1);
            this.$value = f;
            this.$valueRange = interfaceC0789Ob;
            this.$steps = i;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SemanticsPropertyReceiver) obj);
            return FW.a;
        }

        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
            SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(((Number) AbstractC3871sJ.o(Float.valueOf(this.$value), this.$valueRange)).floatValue(), this.$valueRange, this.$steps));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.ProgressSemanticsKt$progressSemantics$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SemanticsPropertyReceiver) obj);
            return FW.a;
        }

        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
            SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, ProgressBarRangeInfo.Companion.getIndeterminate());
        }
    }

    @Stable
    public static final Modifier progressSemantics(Modifier modifier, float f, InterfaceC0789Ob interfaceC0789Ob, int i) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC0789Ob, "valueRange");
        return SemanticsModifierKt.semantics(modifier, true, new AnonymousClass1(f, interfaceC0789Ob, i));
    }

    public static /* synthetic */ Modifier progressSemantics$default(Modifier modifier, float f, InterfaceC0789Ob interfaceC0789Ob, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            interfaceC0789Ob = AbstractC3790rJ.b(0.0f, 1.0f);
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return progressSemantics(modifier, f, interfaceC0789Ob, i);
    }

    @Stable
    public static final Modifier progressSemantics(Modifier modifier) {
        AbstractC4492zt.h(modifier, "<this>");
        return SemanticsModifierKt.semantics(modifier, true, AnonymousClass2.INSTANCE);
    }
}
