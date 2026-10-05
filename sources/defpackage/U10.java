package defpackage;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.zabr;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class U10 {
    public final ApiKey a;
    public final Feature b;

    public /* synthetic */ U10(ApiKey apiKey, Feature feature, zabr zabrVar) {
        this.a = apiKey;
        this.b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof U10)) {
            U10 u10 = (U10) obj;
            if (Objects.equal(this.a, u10.a) && Objects.equal(this.b, u10.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, this.b);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("key", this.a).add("feature", this.b).toString();
    }
}
