package defpackage;

import com.google.android.gms.common.api.internal.zabq;

/* JADX INFO: loaded from: classes2.dex */
public final class S10 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ zabq b;

    public S10(zabq zabqVar, int i) {
        this.b = zabqVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.zaI(this.a);
    }
}
