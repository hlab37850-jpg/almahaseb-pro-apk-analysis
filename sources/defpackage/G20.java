package defpackage;

import android.app.Dialog;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.api.internal.zabw;

/* JADX INFO: loaded from: classes2.dex */
public final class G20 extends zabw {
    public final /* synthetic */ Dialog a;
    public final /* synthetic */ l b;

    public G20(l lVar, Dialog dialog) {
        this.b = lVar;
        this.a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void zaa() {
        this.b.b.zad();
        if (this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
