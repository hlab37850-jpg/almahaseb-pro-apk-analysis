package androidx.activity;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class ComponentActivity$fullyDrawnReporter$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ ComponentActivity this$0;

    /* JADX INFO: renamed from: androidx.activity.ComponentActivity$fullyDrawnReporter$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ ComponentActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ComponentActivity componentActivity) {
            super(0);
            this.this$0 = componentActivity;
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m1invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1invoke() {
            this.this$0.reportFullyDrawn();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComponentActivity$fullyDrawnReporter$2(ComponentActivity componentActivity) {
        super(0);
        this.this$0 = componentActivity;
    }

    @Override // defpackage.InterfaceC3588op
    public final FullyDrawnReporter invoke() {
        return new FullyDrawnReporter(this.this$0.reportFullyDrawnExecutor, new AnonymousClass1(this.this$0));
    }
}
