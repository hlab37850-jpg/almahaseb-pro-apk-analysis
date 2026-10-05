package defpackage;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.zag;

/* JADX INFO: renamed from: p20, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3605p20 extends zag {
    public final /* synthetic */ Intent a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ int c;

    public C3605p20(Intent intent, Fragment fragment, int i) {
        this.a = intent;
        this.b = fragment;
        this.c = i;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.a;
        if (intent != null) {
            this.b.startActivityForResult(intent, this.c);
        }
    }
}
