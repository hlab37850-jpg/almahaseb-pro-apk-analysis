package defpackage;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzee;
import java.util.AbstractMap;

/* JADX INFO: renamed from: ub0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4053ub0 extends zzee {
    public final /* synthetic */ C3649pb0 a;

    public C4053ub0(C3649pb0 c3649pb0) {
        this.a = c3649pb0;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzde.zza(i, this.a.d);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.a.b[i2], this.a.b[i2 + 1]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.d;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzf() {
        return true;
    }
}
