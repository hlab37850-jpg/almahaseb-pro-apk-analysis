package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.service.zaa;

/* JADX INFO: renamed from: k20, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC3195k20 extends zaa {
    public final BaseImplementation.ResultHolder a;

    public BinderC3195k20(BaseImplementation.ResultHolder resultHolder) {
        this.a = resultHolder;
    }

    @Override // com.google.android.gms.common.internal.service.zaa, com.google.android.gms.common.internal.service.zak
    public final void zab(int i) {
        this.a.setResult(new Status(i));
    }
}
