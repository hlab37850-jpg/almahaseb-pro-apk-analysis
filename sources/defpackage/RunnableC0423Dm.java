package defpackage;

import com.google.firebase.installations.FirebaseInstallations;

/* JADX INFO: renamed from: Dm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC0423Dm implements Runnable {
    public final FirebaseInstallations a;

    public RunnableC0423Dm(FirebaseInstallations firebaseInstallations) {
        this.a = firebaseInstallations;
    }

    public static Runnable a(FirebaseInstallations firebaseInstallations) {
        return new RunnableC0423Dm(firebaseInstallations);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.doGetAuthTokenForceRefresh();
    }
}
