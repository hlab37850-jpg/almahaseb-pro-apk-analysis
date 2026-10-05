package androidx.compose.material3;

import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class TooltipKt$TooltipBox$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC2052dg $coroutineScope;
    final /* synthetic */ TooltipState $tooltipState;

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipKt$TooltipBox$1$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.TooltipKt$TooltipBox$1$1$1", f = "Tooltip.kt", l = {TIFFConstants.TIFFTAG_SUBFILETYPE}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ TooltipState $tooltipState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TooltipState tooltipState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$tooltipState = tooltipState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.$tooltipState, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                TooltipState tooltipState = this.$tooltipState;
                this.label = 1;
                if (tooltipState.dismiss(this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooltipKt$TooltipBox$1$1(TooltipState tooltipState, InterfaceC2052dg interfaceC2052dg) {
        super(0);
        this.$tooltipState = tooltipState;
        this.$coroutineScope = interfaceC2052dg;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m2051invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2051invoke() {
        if (this.$tooltipState.isVisible()) {
            O8.d(this.$coroutineScope, null, null, new AnonymousClass1(this.$tooltipState, null), 3, null);
        }
    }
}
