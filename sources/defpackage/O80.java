package defpackage;

import com.google.android.gms.internal.vision.zzcy;

/* JADX INFO: loaded from: classes2.dex */
public final class O80 extends zzcy {
    public static final O80 a = new O80();

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.android.gms.internal.vision.zzcy
    public final boolean zza() {
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzcy
    public final Object zzb() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }
}
