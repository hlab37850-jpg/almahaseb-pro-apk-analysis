package defpackage;

import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.api.internal.zabq;

/* JADX INFO: loaded from: classes2.dex */
public final class T10 implements Runnable {
    public final /* synthetic */ g a;

    public T10(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zabq zabqVar = this.a.a;
        zabqVar.zac.disconnect(zabqVar.zac.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
