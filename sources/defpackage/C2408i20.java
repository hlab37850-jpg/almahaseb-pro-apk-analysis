package defpackage;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: renamed from: i20, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2408i20 {
    public final Uri a;

    public C2408i20(Uri uri) {
        this.a = uri;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2408i20) {
            return Objects.equal(((C2408i20) obj).a, this.a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a);
    }
}
