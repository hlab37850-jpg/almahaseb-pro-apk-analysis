package androidx.compose.material3;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalMaterial3Api
public final class DismissState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final SwipeableV2State<DismissValue> swipeableState;

    /* JADX INFO: renamed from: androidx.compose.material3.DismissState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(DismissValue dismissValue) {
            AbstractC4492zt.h(dismissValue, "it");
            return Boolean.TRUE;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Saver<DismissState, DismissValue> Saver(InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC3750qp, "confirmValueChange");
            AbstractC4492zt.h(interfaceC0526Fp, "positionalThreshold");
            return SaverKt.Saver(DismissState$Companion$Saver$1.INSTANCE, new DismissState$Companion$Saver$2(interfaceC3750qp, interfaceC0526Fp));
        }

        private Companion() {
        }
    }

    public DismissState(DismissValue dismissValue, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(dismissValue, "initialValue");
        AbstractC4492zt.h(interfaceC3750qp, "confirmValueChange");
        AbstractC4492zt.h(interfaceC0526Fp, "positionalThreshold");
        this.swipeableState = new SwipeableV2State<>(dismissValue, null, interfaceC3750qp, interfaceC0526Fp, SwipeToDismissKt.DismissThreshold, 2, null);
    }

    public final Object dismiss(DismissDirection dismissDirection, InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo$default = SwipeableV2State.animateTo$default(this.swipeableState, dismissDirection == DismissDirection.StartToEnd ? DismissValue.DismissedToEnd : DismissValue.DismissedToStart, 0.0f, interfaceC0793Of, 2, null);
        return objAnimateTo$default == AbstractC0378Bt.d() ? objAnimateTo$default : FW.a;
    }

    public final DismissValue getCurrentValue() {
        return this.swipeableState.getCurrentValue();
    }

    public final DismissDirection getDismissDirection() {
        if (AbstractC4492zt.b(getOffset$material3_release(), 0.0f) || getOffset$material3_release() == null) {
            return null;
        }
        Float offset$material3_release = getOffset$material3_release();
        AbstractC4492zt.e(offset$material3_release);
        return offset$material3_release.floatValue() > 0.0f ? DismissDirection.StartToEnd : DismissDirection.EndToStart;
    }

    public final Float getOffset$material3_release() {
        return this.swipeableState.getOffset();
    }

    public final float getProgress() {
        return this.swipeableState.getProgress();
    }

    public final SwipeableV2State<DismissValue> getSwipeableState$material3_release() {
        return this.swipeableState;
    }

    public final DismissValue getTargetValue() {
        return this.swipeableState.getTargetValue();
    }

    public final boolean isDismissed(DismissDirection dismissDirection) {
        AbstractC4492zt.h(dismissDirection, CSS.Property.DIRECTION);
        return getCurrentValue() == (dismissDirection == DismissDirection.StartToEnd ? DismissValue.DismissedToEnd : DismissValue.DismissedToStart);
    }

    public final float requireOffset() {
        return this.swipeableState.requireOffset();
    }

    public final Object reset(InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo$default = SwipeableV2State.animateTo$default(this.swipeableState, DismissValue.Default, 0.0f, interfaceC0793Of, 2, null);
        return objAnimateTo$default == AbstractC0378Bt.d() ? objAnimateTo$default : FW.a;
    }

    public final Object snapTo(DismissValue dismissValue, InterfaceC0793Of interfaceC0793Of) {
        Object objSnapTo = this.swipeableState.snapTo(dismissValue, interfaceC0793Of);
        return objSnapTo == AbstractC0378Bt.d() ? objSnapTo : FW.a;
    }

    public /* synthetic */ DismissState(DismissValue dismissValue, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, int i, AbstractC0419Di abstractC0419Di) {
        this(dismissValue, (i & 2) != 0 ? AnonymousClass1.INSTANCE : interfaceC3750qp, (i & 4) != 0 ? SwipeToDismissDefaults.INSTANCE.getFixedPositionalThreshold() : interfaceC0526Fp);
    }
}
