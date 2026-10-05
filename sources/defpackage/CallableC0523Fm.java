package defpackage;

import com.google.firebase.installations.FirebaseInstallations;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: Fm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CallableC0523Fm implements Callable {
    public final FirebaseInstallations a;

    public CallableC0523Fm(FirebaseInstallations firebaseInstallations) {
        this.a = firebaseInstallations;
    }

    public static Callable a(FirebaseInstallations firebaseInstallations) {
        return new CallableC0523Fm(firebaseInstallations);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.a.deleteFirebaseInstallationId();
    }
}
