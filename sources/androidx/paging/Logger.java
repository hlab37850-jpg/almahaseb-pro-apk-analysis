package androidx.paging;

/* JADX INFO: loaded from: classes2.dex */
public interface Logger {

    public static final class DefaultImpls {
    }

    boolean isLoggable(int i);

    void log(int i, String str, Throwable th);
}
