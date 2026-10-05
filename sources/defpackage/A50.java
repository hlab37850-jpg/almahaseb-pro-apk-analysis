package defpackage;

import com.google.android.gms.internal.fido.zzaz;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class A50 extends zzaz {
    public boolean a;
    public final /* synthetic */ Object b;

    public A50(Object obj) {
        this.b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.a) {
            throw new NoSuchElementException();
        }
        this.a = true;
        return this.b;
    }
}
