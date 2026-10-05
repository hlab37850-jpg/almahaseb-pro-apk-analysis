package defpackage;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public final class M40 implements WorkAccountApi.AddAccountResult {
    public static final Account c = new Account("DUMMY_NAME", "com.google");
    public final Status a;
    public final Account b;

    public M40(Status status, Account account) {
        this.a = status;
        this.b = account == null ? c : account;
    }

    @Override // com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult
    public final Account getAccount() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
