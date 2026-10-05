package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zal;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class B10 extends F10 {
    public final Map b;
    public final /* synthetic */ zaaw c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B10(zaaw zaawVar, Map map) {
        super(zaawVar, null);
        this.c = zaawVar;
        this.b = map;
    }

    @Override // defpackage.F10
    public final void a() {
        zal zalVar = new zal(this.c.zad);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.b.keySet()) {
            if (!client.requiresGooglePlayServices() || ((d) this.b.get(client)).c) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i = 0;
        int iZab = -1;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i < size) {
                iZab = zalVar.zab(this.c.zac, (Api.Client) arrayList.get(i));
                i++;
                if (iZab != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i < size2) {
                iZab = zalVar.zab(this.c.zac, (Api.Client) arrayList2.get(i));
                i++;
                if (iZab == 0) {
                    break;
                }
            }
        }
        if (iZab != 0) {
            ConnectionResult connectionResult = new ConnectionResult(iZab, null);
            zaaw zaawVar = this.c;
            zaawVar.zaa.zal(new C4422z10(this, zaawVar, connectionResult));
            return;
        }
        zaaw zaawVar2 = this.c;
        if (zaawVar2.zam && zaawVar2.zak != null) {
            zaawVar2.zak.zab();
        }
        for (Api.Client client2 : this.b.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (BaseGmsClient.ConnectionProgressReportCallbacks) this.b.get(client2);
            if (!client2.requiresGooglePlayServices() || zalVar.zab(this.c.zac, client2) == 0) {
                client2.connect(connectionProgressReportCallbacks);
            } else {
                zaaw zaawVar3 = this.c;
                zaawVar3.zaa.zal(new A10(this, zaawVar3, connectionProgressReportCallbacks));
            }
        }
    }
}
