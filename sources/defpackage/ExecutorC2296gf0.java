package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: gf0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ExecutorC2296gf0 implements Executor {
    public static final Executor a = new ExecutorC2296gf0();

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
