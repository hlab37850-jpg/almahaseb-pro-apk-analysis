package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.KJ;

/* JADX INFO: loaded from: classes.dex */
final class ReportDrawnComposition implements InterfaceC3588op {
    private final InterfaceC3750qp checkReporter;
    private final FullyDrawnReporter fullyDrawnReporter;
    private final InterfaceC3588op predicate;
    private final SnapshotStateObserver snapshotStateObserver;

    /* JADX INFO: renamed from: androidx.activity.compose.ReportDrawnComposition$observeReporter$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ InterfaceC3588op $predicate;
        final /* synthetic */ KJ $reporterPassed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(KJ kj, InterfaceC3588op interfaceC3588op) {
            super(0);
            this.$reporterPassed = kj;
            this.$predicate = interfaceC3588op;
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m11invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m11invoke() {
            this.$reporterPassed.a = ((Boolean) this.$predicate.invoke()).booleanValue();
        }
    }

    public ReportDrawnComposition(FullyDrawnReporter fullyDrawnReporter, InterfaceC3588op interfaceC3588op) {
        this.fullyDrawnReporter = fullyDrawnReporter;
        this.predicate = interfaceC3588op;
        SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(ReportDrawnComposition$snapshotStateObserver$1.INSTANCE);
        snapshotStateObserver.start();
        this.snapshotStateObserver = snapshotStateObserver;
        this.checkReporter = new ReportDrawnComposition$checkReporter$1(this);
        fullyDrawnReporter.addOnReportDrawnListener(this);
        if (fullyDrawnReporter.isFullyDrawnReported()) {
            return;
        }
        fullyDrawnReporter.addReporter();
        observeReporter(interfaceC3588op);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observeReporter(InterfaceC3588op interfaceC3588op) {
        KJ kj = new KJ();
        this.snapshotStateObserver.observeReads(interfaceC3588op, this.checkReporter, new AnonymousClass1(kj, interfaceC3588op));
        if (kj.a) {
            removeReporter();
        }
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m10invoke();
        return FW.a;
    }

    public final void removeReporter() {
        this.snapshotStateObserver.clear(this.predicate);
        if (!this.fullyDrawnReporter.isFullyDrawnReported()) {
            this.fullyDrawnReporter.removeReporter();
        }
        m10invoke();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public void m10invoke() {
        this.snapshotStateObserver.clear();
        this.snapshotStateObserver.stop();
    }
}
