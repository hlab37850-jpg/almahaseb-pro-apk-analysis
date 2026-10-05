package defpackage;

import com.google.android.gms.internal.vision.zzfa;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: ib0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2452ib0 extends zzfa {
    public boolean a;
    public final /* synthetic */ Object b;

    public C2452ib0(Object obj) {
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
