package androidx.compose.material;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
public final class DismissState extends SwipeableState<DismissValue> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: androidx.compose.material.DismissState$1, reason: invalid class name */
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

        public final Saver<DismissState, DismissValue> Saver(InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
            return SaverKt.Saver(DismissState$Companion$Saver$1.INSTANCE, new DismissState$Companion$Saver$2(interfaceC3750qp));
        }

        private Companion() {
        }
    }

    public /* synthetic */ DismissState(DismissValue dismissValue, InterfaceC3750qp interfaceC3750qp, int i, AbstractC0419Di abstractC0419Di) {
        this(dismissValue, (i & 2) != 0 ? AnonymousClass1.INSTANCE : interfaceC3750qp);
    }

    public final Object dismiss(DismissDirection dismissDirection, InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, dismissDirection == DismissDirection.StartToEnd ? DismissValue.DismissedToEnd : DismissValue.DismissedToStart, null, interfaceC0793Of, 2, null);
        return objAnimateTo$default == AbstractC0378Bt.d() ? objAnimateTo$default : FW.a;
    }

    public final DismissDirection getDismissDirection() {
        if (getOffset().getValue().floatValue() == 0.0f) {
            return null;
        }
        return getOffset().getValue().floatValue() > 0.0f ? DismissDirection.StartToEnd : DismissDirection.EndToStart;
    }

    public final boolean isDismissed(DismissDirection dismissDirection) {
        AbstractC4492zt.h(dismissDirection, CSS.Property.DIRECTION);
        return getCurrentValue() == (dismissDirection == DismissDirection.StartToEnd ? DismissValue.DismissedToEnd : DismissValue.DismissedToStart);
    }

    public final Object reset(InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, DismissValue.Default, null, interfaceC0793Of, 2, null);
        return objAnimateTo$default == AbstractC0378Bt.d() ? objAnimateTo$default : FW.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DismissState(DismissValue dismissValue, InterfaceC3750qp interfaceC3750qp) {
        super(dismissValue, null, interfaceC3750qp, 2, null);
        AbstractC4492zt.h(dismissValue, "initialValue");
        AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
    }
}
