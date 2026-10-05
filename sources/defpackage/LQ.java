package defpackage;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes3.dex */
public interface LQ extends Closeable, Flushable {
    JU b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    void p(H8 h8, long j);
}
