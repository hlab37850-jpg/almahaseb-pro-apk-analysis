package androidx.work.impl;

import androidx.work.impl.model.WorkSpec;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class WorkerUpdater$updateWorkImpl$type$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final WorkerUpdater$updateWorkImpl$type$1 INSTANCE = new WorkerUpdater$updateWorkImpl$type$1();

    public WorkerUpdater$updateWorkImpl$type$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final String invoke(WorkSpec workSpec) {
        AbstractC4492zt.h(workSpec, "spec");
        return workSpec.isPeriodic() ? "Periodic" : "OneTime";
    }
}
