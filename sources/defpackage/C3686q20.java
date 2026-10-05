package defpackage;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.zag;

/* JADX INFO: renamed from: q20, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3686q20 extends zag {
    public final /* synthetic */ Intent a;
    public final /* synthetic */ LifecycleFragment b;

    public C3686q20(Intent intent, LifecycleFragment lifecycleFragment, int i) {
        this.a = intent;
        this.b = lifecycleFragment;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.a;
        if (intent != null) {
            this.b.startActivityForResult(intent, 2);
        }
    }
}
