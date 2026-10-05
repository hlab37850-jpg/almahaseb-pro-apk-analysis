package defpackage;

import android.os.Bundle;
import com.google.firebase.iid.zzap;

/* JADX INFO: renamed from: a50, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1200a50 extends Y40 {
    public C1200a50(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    @Override // defpackage.Y40
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            c(null);
        } else {
            b(new zzap(4, "Invalid response to one way request"));
        }
    }

    @Override // defpackage.Y40
    public final boolean d() {
        return true;
    }
}
