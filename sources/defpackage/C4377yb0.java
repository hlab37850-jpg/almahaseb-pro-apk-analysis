package defpackage;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzee;

/* JADX INFO: renamed from: yb0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4377yb0 extends zzee {
    public final transient Object[] a;
    public final transient int b;
    public final transient int c;

    public C4377yb0(Object[] objArr, int i, int i2) {
        this.a = objArr;
        this.b = i;
        this.c = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzde.zza(i, this.c);
        return this.a[(i * 2) + this.b];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzf() {
        return true;
    }
}
