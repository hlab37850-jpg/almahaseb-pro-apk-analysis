package defpackage;

import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.gms.internal.vision.zzaq;

/* JADX INFO: renamed from: t50, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3934t50 extends ContentObserver {
    public C3934t50(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzaq.zze.set(true);
    }
}
