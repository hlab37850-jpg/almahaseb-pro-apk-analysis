package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.io.CharSource;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

/* JADX INFO: renamed from: sC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3864sC extends Reader {
    public final Iterator a;
    public Reader b;

    public C3864sC(Iterator it) {
        this.a = it;
        c();
    }

    public final void c() {
        close();
        if (this.a.hasNext()) {
            this.b = ((CharSource) this.a.next()).openStream();
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Reader reader = this.b;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.b = null;
            }
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        Preconditions.checkNotNull(cArr);
        Reader reader = this.b;
        if (reader == null) {
            return -1;
        }
        int i3 = reader.read(cArr, i, i2);
        if (i3 != -1) {
            return i3;
        }
        c();
        return read(cArr, i, i2);
    }

    @Override // java.io.Reader
    public boolean ready() {
        Reader reader = this.b;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        Preconditions.checkArgument(j >= 0, "n is negative");
        if (j > 0) {
            while (true) {
                Reader reader = this.b;
                if (reader == null) {
                    break;
                }
                long jSkip = reader.skip(j);
                if (jSkip > 0) {
                    return jSkip;
                }
                c();
            }
        }
        return 0L;
    }
}
