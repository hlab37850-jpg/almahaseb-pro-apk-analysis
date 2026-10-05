package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: Tl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0938Tl {
    public static Executor a() {
        return new ExecutorC3794rN(Executors.newSingleThreadExecutor());
    }
}
