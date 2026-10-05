package defpackage;

import com.google.android.gms.internal.play_billing.zzbg;
import com.google.android.gms.internal.play_billing.zzbt;
import java.util.Objects;

/* JADX INFO: renamed from: m80, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3371m80 extends zzbt {
    public final transient Object[] a;
    public final transient int b;
    public final transient int c;

    public C3371m80(Object[] objArr, int i, int i2) {
        this.a = objArr;
        this.b = i;
        this.c = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzbg.zza(i, this.c, "index");
        Object obj = this.a[i + i + this.b];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final boolean zzf() {
        return true;
    }
}
