package defpackage;

import com.google.firebase.installations.FirebaseInstallations;

/* JADX INFO: renamed from: Em, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC0449Em implements Runnable {
    public final FirebaseInstallations a;

    public RunnableC0449Em(FirebaseInstallations firebaseInstallations) {
        this.a = firebaseInstallations;
    }

    public static Runnable a(FirebaseInstallations firebaseInstallations) {
        return new RunnableC0449Em(firebaseInstallations);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.doGetAuthTokenWithoutForceRefresh();
    }
}
