package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: kb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC3238kb {
    public static final void a(IJ ij, Throwable th) {
        CancellationException cancellationExceptionA = null;
        if (th != null) {
            cancellationExceptionA = th instanceof CancellationException ? (CancellationException) th : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = AbstractC0747Ml.a("Channel was consumed, consumer had failed", th);
            }
        }
        ij.cancel(cancellationExceptionA);
    }
}
