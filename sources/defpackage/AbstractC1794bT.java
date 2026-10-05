package defpackage;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;

/* JADX INFO: renamed from: bT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1794bT {
    public static String a;
    public static Account b;
    public static AccountManager c;

    public static void a() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("force", true);
        bundle.putBoolean("expedited", true);
        bundle.putBoolean("do_not_retry", true);
        if (e()) {
            return;
        }
        if (!e() && d()) {
            b();
        }
        ContentResolver.requestSync(b, "info.aalmoghalis.inventory.sync.provider", bundle);
    }

    public static void b() {
        ContentResolver.cancelSync(b, "info.aalmoghalis.inventory.sync.provider");
    }

    public static void c(Context context) {
        b = new Account(AbstractC2242g10.h(context, "PREF_ACCOUNT_NAME", ""), "info.aalmoghalis.inventory");
        a = FirebaseInstanceId.getInstance().getToken();
        Log.d("fire_chk=", "init:SyncAdapterManager:");
        AccountManager accountManager = (AccountManager) context.getSystemService("account");
        c = accountManager;
        if (accountManager.addAccountExplicitly(b, null, null)) {
            Log.d("fire_chk=", "add_account:success");
        } else {
            Log.d("fire_chk=", "add_account:failed");
        }
    }

    public static boolean d() {
        Account account = b;
        if (account == null) {
            Log.w(Q00.H, "Account is null, cannot check sync pending status.");
            return false;
        }
        boolean zIsSyncPending = ContentResolver.isSyncPending(account, "info.aalmoghalis.inventory.sync.provider");
        Log.d(Q00.H, "Sync pending for " + b.name + " " + zIsSyncPending);
        return zIsSyncPending;
    }

    public static boolean e() {
        Account account = b;
        if (account == null) {
            Log.d(Q00.H, "Account is null, cannot check sync status.");
            return false;
        }
        boolean zIsSyncActive = ContentResolver.isSyncActive(account, "info.aalmoghalis.inventory.sync.provider");
        Log.d(Q00.H, "Sync active for " + b.name + " " + zIsSyncActive);
        return zIsSyncActive;
    }

    public static void f(Context context) {
        AccountManager accountManager;
        Account account;
        c = (AccountManager) context.getSystemService("account");
        b = new Account(AbstractC2242g10.h(context, "PREF_ACCOUNT_NAME", ""), "info.aalmoghalis.inventory");
        StringBuilder sb = new StringBuilder();
        sb.append("remove_account::m=");
        sb.append(c == null ? "null" : "notNull");
        sb.append(":a=");
        sb.append(b == null ? "null" : "notNull");
        Log.d("fire_chk=", sb.toString());
        if (Build.VERSION.SDK_INT < 22 || (accountManager = c) == null || (account = b) == null) {
            return;
        }
        accountManager.removeAccountExplicitly(account);
    }
}
