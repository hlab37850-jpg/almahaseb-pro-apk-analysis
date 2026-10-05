package defpackage;

import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* JADX INFO: renamed from: zT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC4458zT {
    public static void a(TaskExecutor taskExecutor, Runnable runnable) {
        taskExecutor.getSerialTaskExecutor().execute(runnable);
    }
}
