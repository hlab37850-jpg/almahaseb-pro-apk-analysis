package defpackage;

import com.google.android.gms.internal.play_billing.zzbg;
import com.google.android.gms.internal.play_billing.zzbt;
import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: renamed from: b80, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1772b80 extends zzbt {
    public final /* synthetic */ C2174f80 a;

    public C1772b80(C2174f80 c2174f80) {
        Objects.requireNonNull(c2174f80);
        this.a = c2174f80;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        C2174f80 c2174f80 = this.a;
        zzbg.zza(i, c2174f80.c, "index");
        int i2 = i + i;
        Object obj = c2174f80.b[i2];
        Objects.requireNonNull(obj);
        Object obj2 = c2174f80.b[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.c;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final boolean zzf() {
        return true;
    }
}
