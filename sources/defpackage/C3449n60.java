package defpackage;

import com.google.android.gms.internal.clearcut.zzbb;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: n60, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3449n60 implements Iterator {
    public int a = 0;
    public final int b;
    public final /* synthetic */ zzbb c;

    public C3449n60(zzbb zzbbVar) {
        this.c = zzbbVar;
        this.b = zzbbVar.size();
    }

    public final byte a() {
        try {
            zzbb zzbbVar = this.c;
            int i = this.a;
            this.a = i + 1;
            return zzbbVar.zzj(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return Byte.valueOf(a());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
