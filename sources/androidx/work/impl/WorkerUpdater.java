package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkerUpdater;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.EnqueueUtilsKt;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class WorkerUpdater {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Operation enqueueUniquelyNamedPeriodic(final WorkManagerImpl workManagerImpl, final String str, final WorkRequest workRequest) {
        AbstractC4492zt.h(workManagerImpl, "<this>");
        AbstractC4492zt.h(str, "name");
        AbstractC4492zt.h(workRequest, "workRequest");
        final OperationImpl operationImpl = new OperationImpl();
        final WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1 workerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1 = new WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1(workRequest, workManagerImpl, str, operationImpl);
        workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor().execute(new Runnable() { // from class: OZ
            @Override // java.lang.Runnable
            public final void run() {
                WorkerUpdater.enqueueUniquelyNamedPeriodic$lambda$3(workManagerImpl, str, operationImpl, workerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1, workRequest);
            }
        });
        return operationImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueueUniquelyNamedPeriodic$lambda$3(WorkManagerImpl workManagerImpl, String str, OperationImpl operationImpl, InterfaceC3588op interfaceC3588op, WorkRequest workRequest) {
        AbstractC4492zt.h(workManagerImpl, "$this_enqueueUniquelyNamedPeriodic");
        AbstractC4492zt.h(str, "$name");
        AbstractC4492zt.h(operationImpl, "$operation");
        AbstractC4492zt.h(interfaceC3588op, "$enqueueNew");
        AbstractC4492zt.h(workRequest, "$workRequest");
        WorkSpecDao workSpecDao = workManagerImpl.getWorkDatabase().workSpecDao();
        List<WorkSpec.IdAndState> workSpecIdAndStatesForName = workSpecDao.getWorkSpecIdAndStatesForName(str);
        if (workSpecIdAndStatesForName.size() > 1) {
            failWorkTypeChanged(operationImpl, "Can't apply UPDATE policy to the chains of work.");
            return;
        }
        WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState) AbstractC3240kc.d0(workSpecIdAndStatesForName);
        if (idAndState == null) {
            interfaceC3588op.invoke();
            return;
        }
        WorkSpec workSpec = workSpecDao.getWorkSpec(idAndState.id);
        if (workSpec == null) {
            operationImpl.markState(new Operation.State.FAILURE(new IllegalStateException("WorkSpec with " + idAndState.id + ", that matches a name \"" + str + "\", wasn't found")));
            return;
        }
        if (!workSpec.isPeriodic()) {
            failWorkTypeChanged(operationImpl, "Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
            return;
        }
        if (idAndState.state == WorkInfo.State.CANCELLED) {
            workSpecDao.delete(idAndState.id);
            interfaceC3588op.invoke();
            return;
        }
        WorkSpec workSpec2 = workRequest.getWorkSpec();
        WorkSpec workSpecCopy = workSpec2.copy((1048574 & 1) != 0 ? workSpec2.id : idAndState.id, (1048574 & 2) != 0 ? workSpec2.state : null, (1048574 & 4) != 0 ? workSpec2.workerClassName : null, (1048574 & 8) != 0 ? workSpec2.inputMergerClassName : null, (1048574 & 16) != 0 ? workSpec2.input : null, (1048574 & 32) != 0 ? workSpec2.output : null, (1048574 & 64) != 0 ? workSpec2.initialDelay : 0L, (1048574 & 128) != 0 ? workSpec2.intervalDuration : 0L, (1048574 & 256) != 0 ? workSpec2.flexDuration : 0L, (1048574 & 512) != 0 ? workSpec2.constraints : null, (1048574 & 1024) != 0 ? workSpec2.runAttemptCount : 0, (1048574 & 2048) != 0 ? workSpec2.backoffPolicy : null, (1048574 & 4096) != 0 ? workSpec2.backoffDelayDuration : 0L, (1048574 & 8192) != 0 ? workSpec2.lastEnqueueTime : 0L, (1048574 & 16384) != 0 ? workSpec2.minimumRetentionDuration : 0L, (1048574 & 32768) != 0 ? workSpec2.scheduleRequestedAt : 0L, (1048574 & 65536) != 0 ? workSpec2.expedited : false, (131072 & 1048574) != 0 ? workSpec2.outOfQuotaPolicy : null, (1048574 & 262144) != 0 ? workSpec2.periodCount : 0, (1048574 & 524288) != 0 ? workSpec2.generation : 0);
        try {
            Processor processor = workManagerImpl.getProcessor();
            AbstractC4492zt.g(processor, "processor");
            WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
            AbstractC4492zt.g(workDatabase, "workDatabase");
            Configuration configuration = workManagerImpl.getConfiguration();
            AbstractC4492zt.g(configuration, "configuration");
            List<Scheduler> schedulers = workManagerImpl.getSchedulers();
            AbstractC4492zt.g(schedulers, "schedulers");
            updateWorkImpl(processor, workDatabase, configuration, schedulers, workSpecCopy, workRequest.getTags());
            operationImpl.markState(Operation.SUCCESS);
        } catch (Throwable th) {
            operationImpl.markState(new Operation.State.FAILURE(th));
        }
    }

    private static final void failWorkTypeChanged(OperationImpl operationImpl, String str) {
        operationImpl.markState(new Operation.State.FAILURE(new UnsupportedOperationException(str)));
    }

    private static final WorkManager.UpdateResult updateWorkImpl(Processor processor, final WorkDatabase workDatabase, Configuration configuration, final List<? extends Scheduler> list, final WorkSpec workSpec, final Set<String> set) {
        final String str = workSpec.id;
        final WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(str);
        if (workSpec2 == null) {
            throw new IllegalArgumentException("Worker with " + str + " doesn't exist");
        }
        if (workSpec2.state.isFinished()) {
            return WorkManager.UpdateResult.NOT_APPLIED;
        }
        if (workSpec2.isPeriodic() ^ workSpec.isPeriodic()) {
            WorkerUpdater$updateWorkImpl$type$1 workerUpdater$updateWorkImpl$type$1 = WorkerUpdater$updateWorkImpl$type$1.INSTANCE;
            throw new UnsupportedOperationException("Can't update " + ((String) workerUpdater$updateWorkImpl$type$1.invoke((Object) workSpec2)) + " Worker to " + ((String) workerUpdater$updateWorkImpl$type$1.invoke((Object) workSpec)) + " Worker. Update operation must preserve worker's type.");
        }
        final boolean zIsEnqueued = processor.isEnqueued(str);
        if (!zIsEnqueued) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((Scheduler) it.next()).cancel(str);
            }
        }
        workDatabase.runInTransaction(new Runnable() { // from class: MZ
            @Override // java.lang.Runnable
            public final void run() {
                WorkerUpdater.updateWorkImpl$lambda$1(workDatabase, workSpec, workSpec2, list, str, set, zIsEnqueued);
            }
        });
        if (!zIsEnqueued) {
            Schedulers.schedule(configuration, workDatabase, list);
        }
        return zIsEnqueued ? WorkManager.UpdateResult.APPLIED_FOR_NEXT_RUN : WorkManager.UpdateResult.APPLIED_IMMEDIATELY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWorkImpl$lambda$1(WorkDatabase workDatabase, WorkSpec workSpec, WorkSpec workSpec2, List list, String str, Set set, boolean z) {
        AbstractC4492zt.h(workDatabase, "$workDatabase");
        AbstractC4492zt.h(workSpec, "$newWorkSpec");
        AbstractC4492zt.h(workSpec2, "$oldWorkSpec");
        AbstractC4492zt.h(list, "$schedulers");
        AbstractC4492zt.h(str, "$workSpecId");
        AbstractC4492zt.h(set, "$tags");
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkTagDao workTagDao = workDatabase.workTagDao();
        workSpecDao.updateWorkSpec(EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(list, workSpec.copy((1048574 & 1) != 0 ? workSpec.id : null, (1048574 & 2) != 0 ? workSpec.state : workSpec2.state, (1048574 & 4) != 0 ? workSpec.workerClassName : null, (1048574 & 8) != 0 ? workSpec.inputMergerClassName : null, (1048574 & 16) != 0 ? workSpec.input : null, (1048574 & 32) != 0 ? workSpec.output : null, (1048574 & 64) != 0 ? workSpec.initialDelay : 0L, (1048574 & 128) != 0 ? workSpec.intervalDuration : 0L, (1048574 & 256) != 0 ? workSpec.flexDuration : 0L, (1048574 & 512) != 0 ? workSpec.constraints : null, (1048574 & 1024) != 0 ? workSpec.runAttemptCount : workSpec2.runAttemptCount, (1048574 & 2048) != 0 ? workSpec.backoffPolicy : null, (1048574 & 4096) != 0 ? workSpec.backoffDelayDuration : 0L, (1048574 & 8192) != 0 ? workSpec.lastEnqueueTime : workSpec2.lastEnqueueTime, (1048574 & 16384) != 0 ? workSpec.minimumRetentionDuration : 0L, (1048574 & 32768) != 0 ? workSpec.scheduleRequestedAt : 0L, (1048574 & 65536) != 0 ? workSpec.expedited : false, (131072 & 1048574) != 0 ? workSpec.outOfQuotaPolicy : null, (1048574 & 262144) != 0 ? workSpec.periodCount : 0, (1048574 & 524288) != 0 ? workSpec.generation : workSpec2.getGeneration() + 1)));
        workTagDao.deleteByWorkSpecId(str);
        workTagDao.insertTags(str, set);
        if (z) {
            return;
        }
        workSpecDao.markWorkSpecScheduled(str, -1L);
        workDatabase.workProgressDao().delete(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWorkImpl$lambda$2(SettableFuture settableFuture, WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        AbstractC4492zt.h(workManagerImpl, "$this_updateWorkImpl");
        AbstractC4492zt.h(workRequest, "$workRequest");
        if (settableFuture.isCancelled()) {
            return;
        }
        try {
            Processor processor = workManagerImpl.getProcessor();
            AbstractC4492zt.g(processor, "processor");
            WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
            AbstractC4492zt.g(workDatabase, "workDatabase");
            Configuration configuration = workManagerImpl.getConfiguration();
            AbstractC4492zt.g(configuration, "configuration");
            List<Scheduler> schedulers = workManagerImpl.getSchedulers();
            AbstractC4492zt.g(schedulers, "schedulers");
            settableFuture.set(updateWorkImpl(processor, workDatabase, configuration, schedulers, workRequest.getWorkSpec(), workRequest.getTags()));
        } catch (Throwable th) {
            settableFuture.setException(th);
        }
    }

    public static final ListenableFuture<WorkManager.UpdateResult> updateWorkImpl(final WorkManagerImpl workManagerImpl, final WorkRequest workRequest) {
        AbstractC4492zt.h(workManagerImpl, "<this>");
        AbstractC4492zt.h(workRequest, "workRequest");
        final SettableFuture settableFutureCreate = SettableFuture.create();
        workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor().execute(new Runnable() { // from class: NZ
            @Override // java.lang.Runnable
            public final void run() {
                WorkerUpdater.updateWorkImpl$lambda$2(settableFutureCreate, workManagerImpl, workRequest);
            }
        });
        AbstractC4492zt.g(settableFutureCreate, "future");
        return settableFutureCreate;
    }
}
