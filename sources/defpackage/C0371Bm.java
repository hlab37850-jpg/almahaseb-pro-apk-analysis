package defpackage;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;

/* JADX INFO: renamed from: Bm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0371Bm implements Provider {
    public final FirebaseApp a;
    public final Context b;

    public C0371Bm(FirebaseApp firebaseApp, Context context) {
        this.a = firebaseApp;
        this.b = context;
    }

    public static Provider a(FirebaseApp firebaseApp, Context context) {
        return new C0371Bm(firebaseApp, context);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        return FirebaseApp.lambda$new$0(this.a, this.b);
    }
}
