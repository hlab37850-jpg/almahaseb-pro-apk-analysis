package defpackage;

import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.auth.api.signin.zba;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

/* JADX INFO: renamed from: b30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1762b30 implements PendingResultUtil.ResultConverter {
    public /* synthetic */ C1762b30(zba zbaVar) {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ Object convert(Result result) {
        return ((GoogleSignInResult) result).getSignInAccount();
    }
}
