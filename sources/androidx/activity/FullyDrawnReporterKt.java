package androidx.activity;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC0819Pf;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
public final class FullyDrawnReporterKt {

    /* JADX INFO: renamed from: androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", l = {ShapeTypes.CHART_X}, m = "reportWhenComplete")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FullyDrawnReporterKt.reportWhenComplete(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [FW, java.lang.Object] */
    public static final Object reportWhenComplete(FullyDrawnReporter fullyDrawnReporter, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        FullyDrawnReporter fullyDrawnReporter2;
        if (interfaceC0793Of instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
        }
        Object obj = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                LL.b(obj);
                fullyDrawnReporter.addReporter();
                if (fullyDrawnReporter.isFullyDrawnReported()) {
                    return FW.a;
                }
                anonymousClass1.L$0 = fullyDrawnReporter;
                anonymousClass1.label = 1;
                if (interfaceC3750qp.invoke(anonymousClass1) == objD) {
                    fullyDrawnReporter2 = fullyDrawnReporter;
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                FullyDrawnReporter fullyDrawnReporter3 = (FullyDrawnReporter) anonymousClass1.L$0;
                LL.b(obj);
                fullyDrawnReporter2 = fullyDrawnReporter3;
            }
            fullyDrawnReporter2 = fullyDrawnReporter;
            AbstractC0703Ks.b(1);
            fullyDrawnReporter2.removeReporter();
            AbstractC0703Ks.a(1);
            fullyDrawnReporter = FW.a;
            return fullyDrawnReporter;
        } catch (Throwable th) {
            AbstractC0703Ks.b(1);
            fullyDrawnReporter.removeReporter();
            AbstractC0703Ks.a(1);
            throw th;
        }
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter fullyDrawnReporter, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        fullyDrawnReporter.addReporter();
        if (fullyDrawnReporter.isFullyDrawnReported()) {
            return FW.a;
        }
        try {
            interfaceC3750qp.invoke(interfaceC0793Of);
            return FW.a;
        } finally {
            AbstractC0703Ks.b(1);
            fullyDrawnReporter.removeReporter();
            AbstractC0703Ks.a(1);
        }
    }
}
