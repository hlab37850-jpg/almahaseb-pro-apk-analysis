package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzag;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Oi0 {
    public String a = null;
    public long b = -1;
    public zzag c = zzag.zzl();
    public zzag d = zzag.zzl();

    public final Oi0 a(long j) {
        this.b = j;
        return this;
    }

    public final Oi0 b(List list) {
        Preconditions.checkNotNull(list);
        this.d = zzag.zzk(list);
        return this;
    }

    public final Oi0 c(List list) {
        Preconditions.checkNotNull(list);
        this.c = zzag.zzk(list);
        return this;
    }

    public final Oi0 d(String str) {
        this.a = str;
        return this;
    }

    public final U30 e() {
        if (this.a == null) {
            throw new IllegalStateException("packageName must be defined");
        }
        if (this.b < 0) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        }
        if (this.c.isEmpty() && this.d.isEmpty()) {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        return new U30(this.a, this.b, this.c, this.d, null);
    }
}
