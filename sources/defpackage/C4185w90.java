package defpackage;

import com.google.android.gms.internal.play_billing.zzdd;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: w90, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4185w90 extends TimeoutException {
    public /* synthetic */ C4185w90(String str, zzdd zzddVar) {
        super(str);
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
