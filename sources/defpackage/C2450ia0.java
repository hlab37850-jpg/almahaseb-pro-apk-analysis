package defpackage;

import com.google.android.gms.internal.auth.zzee;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: ia0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2450ia0 extends AbstractC3647pa0 {
    public int a = 0;
    public final int b;
    public final /* synthetic */ zzee c;

    public C2450ia0(zzee zzeeVar) {
        this.c = zzeeVar;
        this.b = zzeeVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b;
    }

    @Override // com.google.android.gms.internal.auth.zzdz
    public final byte zza() {
        int i = this.a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.a = i + 1;
        return this.c.zzb(i);
    }
}
