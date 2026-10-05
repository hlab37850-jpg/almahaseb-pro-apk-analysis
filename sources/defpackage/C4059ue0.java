package defpackage;

import com.google.android.gms.internal.vision.zzht;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: ue0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4059ue0 extends AbstractC4140ve0 {
    public int a = 0;
    public final int b;
    public final /* synthetic */ zzht c;

    public C4059ue0(zzht zzhtVar) {
        this.c = zzhtVar;
        this.b = zzhtVar.zza();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b;
    }

    @Override // com.google.android.gms.internal.vision.zzhy
    public final byte zza() {
        int i = this.a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.a = i + 1;
        return this.c.zzb(i);
    }
}
