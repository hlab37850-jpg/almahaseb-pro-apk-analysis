package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.internal.p000authapi.zbd;

/* JADX INFO: renamed from: s30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC3849s30 extends zbd {
    public final BaseImplementation.ResultHolder a;

    public BinderC3849s30(BaseImplementation.ResultHolder resultHolder) {
        this.a = resultHolder;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbd, com.google.android.gms.internal.p000authapi.zbs
    public final void zbc(Status status) {
        this.a.setResult(status);
    }
}
