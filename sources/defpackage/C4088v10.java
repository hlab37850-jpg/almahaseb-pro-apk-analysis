package defpackage;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zaad;

/* JADX INFO: renamed from: v10, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4088v10 implements PendingResult.StatusListener {
    public final /* synthetic */ BasePendingResult a;
    public final /* synthetic */ zaad b;

    public C4088v10(zaad zaadVar, BasePendingResult basePendingResult) {
        this.b = zaadVar;
        this.a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        this.b.zaa.remove(this.a);
    }
}
