package defpackage;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;

/* JADX INFO: loaded from: classes3.dex */
public class ZS extends AbstractThreadedSyncAdapter {
    public static boolean c = false;
    public SQLiteDatabase a;
    public Z00 b;

    public ZS(Context context, boolean z) {
        super(context, z);
        Log.d("fire_chk=", "start:SyncAdapter");
        this.b = new Z00(this.a, getContext());
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        synchronized (ZS.class) {
            try {
                if (c) {
                    return;
                }
                c = true;
                try {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("start:onPerformSync:sync=");
                        sb.append(c);
                        sb.append(":f2=");
                        sb.append(FragmentStatePagerSupport_Main.S == null ? "null" : "notNull");
                        sb.append(":c=");
                        sb.append(Q00.D);
                        sb.append(":t=");
                        sb.append(Q00.E);
                        sb.append(":s=");
                        VQ vq = Q00.C;
                        sb.append(vq == null ? "null" : Boolean.valueOf(vq.z()));
                        Log.d("fire_chk=", sb.toString());
                        if (FragmentStatePagerSupport_Main.S == null) {
                            FragmentStatePagerSupport_Main.S = new Q00(this.b, getContext(), null);
                        } else {
                            if (Q00.C == null || Q00.D == 0 || Q00.E) {
                                Log.d("fire_chk=", "reconnect_socket:t4");
                                VQ vq2 = Q00.C;
                                if (vq2 != null) {
                                    if (vq2.z()) {
                                        Q00.C.B();
                                    }
                                    Q00.F = true;
                                    Q00.C.y();
                                } else {
                                    FragmentStatePagerSupport_Main.S.u();
                                }
                            }
                            if (this.b.S()) {
                                FragmentStatePagerSupport_Main.S.X();
                            }
                        }
                        if (!this.b.S()) {
                            AbstractC1794bT.f(getContext());
                        }
                        synchronized (ZS.class) {
                            c = false;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        c = false;
                        syncResult.stats.numParseExceptions++;
                        if (!this.b.S()) {
                            AbstractC1794bT.f(getContext());
                        }
                        synchronized (ZS.class) {
                            c = false;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (ZS.class) {
                        c = false;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
