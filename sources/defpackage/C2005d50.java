package defpackage;

import android.os.Bundle;

/* JADX INFO: renamed from: d50, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2005d50 extends Y40 {
    public C2005d50(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    @Override // defpackage.Y40
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        c(bundle2);
    }

    @Override // defpackage.Y40
    public final boolean d() {
        return false;
    }
}
