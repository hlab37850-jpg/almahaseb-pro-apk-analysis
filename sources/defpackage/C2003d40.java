package defpackage;

import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.gms.internal.clearcut.zzab;

/* JADX INFO: renamed from: d40, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2003d40 extends ContentObserver {
    public final /* synthetic */ zzab a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2003d40(zzab zzabVar, Handler handler) {
        super(null);
        this.a = zzabVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.a.zzh();
        this.a.zzj();
    }
}
