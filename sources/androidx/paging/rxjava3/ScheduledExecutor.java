package androidx.paging.rxjava3;

import androidx.paging.rxjava3.ScheduledExecutor;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AN;
import defpackage.AbstractC4492zt;
import defpackage.IN;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class ScheduledExecutor extends AN implements Executor {
    private final Executor executor;
    private final AN scheduler;

    public ScheduledExecutor(AN an) {
        AbstractC4492zt.h(an, "scheduler");
        final AN.c cVarCreateWorker = an.createWorker();
        AbstractC4492zt.g(cVarCreateWorker, "scheduler.createWorker()");
        this.executor = new Executor() { // from class: yN
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                ScheduledExecutor._init_$lambda$0(cVarCreateWorker, runnable);
            }
        };
        this.scheduler = an;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(AN.c cVar, Runnable runnable) {
        AbstractC4492zt.h(cVar, "$worker");
        cVar.b(runnable);
    }

    @Override // defpackage.AN
    public AN.c createWorker() {
        AN.c cVarCreateWorker = this.scheduler.createWorker();
        AbstractC4492zt.g(cVarCreateWorker, "scheduler.createWorker()");
        return cVarCreateWorker;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        AbstractC4492zt.h(runnable, HTML.Tag.COMMAND);
        this.executor.execute(runnable);
    }

    public ScheduledExecutor(Executor executor) {
        AbstractC4492zt.h(executor, "executor");
        this.executor = executor;
        AN anA = IN.a(executor);
        AbstractC4492zt.g(anA, "from(executor)");
        this.scheduler = anA;
    }
}
