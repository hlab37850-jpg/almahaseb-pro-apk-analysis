package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes3.dex */
public final class TB implements Closeable {
    public final boolean a;
    public final H8 b;
    public final Inflater c;
    public final C0581Hs d;

    public TB(boolean z) {
        this.a = z;
        H8 h8 = new H8();
        this.b = h8;
        Inflater inflater = new Inflater(true);
        this.c = inflater;
        this.d = new C0581Hs((InterfaceC3309lR) h8, inflater);
    }

    public final void c(H8 h8) throws IOException {
        AbstractC4492zt.h(h8, "buffer");
        if (this.b.R() != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.a) {
            this.c.reset();
        }
        this.b.Y(h8);
        this.b.writeInt(65535);
        long bytesRead = this.c.getBytesRead() + this.b.R();
        do {
            this.d.c(h8, LocationRequestCompat.PASSIVE_INTERVAL);
        } while (this.c.getBytesRead() < bytesRead);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d.close();
    }
}
