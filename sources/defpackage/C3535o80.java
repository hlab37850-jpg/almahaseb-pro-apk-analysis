package defpackage;

import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.gms.internal.auth.zzcg;

/* JADX INFO: renamed from: o80, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3535o80 extends ContentObserver {
    public final /* synthetic */ zzcg a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3535o80(zzcg zzcgVar, Handler handler) {
        super(null);
        this.a = zzcgVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.a.zze();
    }
}
