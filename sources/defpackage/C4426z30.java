package defpackage;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnTokenCanceledListener;

/* JADX INFO: renamed from: z30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4426z30 implements OnSuccessListener {
    public final /* synthetic */ OnTokenCanceledListener a;

    public C4426z30(C1768b60 c1768b60, OnTokenCanceledListener onTokenCanceledListener) {
        this.a = onTokenCanceledListener;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        this.a.onCanceled();
    }
}
