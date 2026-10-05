package defpackage;

import com.google.android.gms.internal.play_billing.zzei;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Ea0 extends Ia0 {
    public int a;
    public final int b;
    public final /* synthetic */ zzei c;

    public Ea0(zzei zzeiVar) {
        Objects.requireNonNull(zzeiVar);
        this.c = zzeiVar;
        this.a = 0;
        this.b = zzeiVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b;
    }

    @Override // com.google.android.gms.internal.play_billing.zzed
    public final byte zza() {
        int i = this.a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.a = i + 1;
        return this.c.zzb(i);
    }
}
