package defpackage;

import android.os.Bundle;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.auth.api.signin.internal.zbc;
import com.google.android.gms.auth.api.signin.internal.zbv;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: renamed from: w30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4173w30 implements LoaderManager.LoaderCallbacks {
    public final /* synthetic */ SignInHubActivity a;

    public /* synthetic */ C4173w30(SignInHubActivity signInHubActivity, zbv zbvVar) {
        this.a = signInHubActivity;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final Loader onCreateLoader(int i, Bundle bundle) {
        return new zbc(this.a, GoogleApiClient.getAllClients());
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final /* bridge */ /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        SignInHubActivity signInHubActivity = this.a;
        signInHubActivity.setResult(signInHubActivity.zbe, signInHubActivity.zbf);
        this.a.finish();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final void onLoaderReset(Loader loader) {
    }
}
