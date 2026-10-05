package defpackage;

import com.google.android.gms.internal.vision.zzcy;

/* JADX INFO: renamed from: z90, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4438z90 extends zzcy {
    public final Object a;

    public C4438z90(Object obj) {
        this.a = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C4438z90) {
            return this.a.equals(((C4438z90) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() + 1502476572;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 13);
        sb.append("Optional.of(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.vision.zzcy
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzcy
    public final Object zzb() {
        return this.a;
    }
}
