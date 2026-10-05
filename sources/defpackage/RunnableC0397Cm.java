package defpackage;

import com.google.firebase.installations.FirebaseInstallations;

/* JADX INFO: renamed from: Cm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC0397Cm implements Runnable {
    public final FirebaseInstallations a;

    public RunnableC0397Cm(FirebaseInstallations firebaseInstallations) {
        this.a = firebaseInstallations;
    }

    public static Runnable a(FirebaseInstallations firebaseInstallations) {
        return new RunnableC0397Cm(firebaseInstallations);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.doGetId();
    }
}
