package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.widget.Toast;
import com.android.billingclient.api.Purchase;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: renamed from: Ur, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0974Ur implements FI {
    public Context h;
    public Activity i;
    public ServiceConnection j;
    public int k;
    public String l;
    public String m;
    public K7 o;
    public Z00 p;
    public f q;
    public boolean a = false;
    public String b = "IabHelper";
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public String g = "";
    public W1 n = new b();

    /* JADX INFO: renamed from: Ur$a */
    public class a implements EI {
        public a() {
        }

        @Override // defpackage.EI
        public void a(com.android.billingclient.api.a aVar, List list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            C0974Ur.this.m(list);
        }
    }

    /* JADX INFO: renamed from: Ur$b */
    public class b implements W1 {
        public b() {
        }

        @Override // defpackage.W1
        public void a(com.android.billingclient.api.a aVar) {
            Log.d("purchase=", "Item Purchased:onAcknowledgePurchaseResponse");
            if (aVar.c() == 0) {
                Log.d("purchase=", "Item Purchased:onAcknowledgePurchaseResponse:");
                Z00 z00 = C0974Ur.this.p;
                C0974Ur c0974Ur = C0974Ur.this;
                z00.J0(c0974Ur.h, c0974Ur.p.ia("token", ""), C0974Ur.this.p.ia("payload", "0"), Boolean.FALSE);
                Toast.makeText(C0974Ur.this.h, "Item Purchased", 0).show();
            }
        }
    }

    /* JADX INFO: renamed from: Ur$c */
    public class c implements N7 {

        /* JADX INFO: renamed from: Ur$c$a */
        public class a implements EI {
            public a() {
            }

            @Override // defpackage.EI
            public void a(com.android.billingclient.api.a aVar, List list) {
                if (list.size() == 0 || C0974Ur.this.p.ia("token", "").equals("") || C0974Ur.this.p.ja("token_list", false)) {
                    C0974Ur.this.n();
                    return;
                }
                if (list.size() > 0) {
                    Log.d("purchase=", "onBillingSetupFinished:" + list.size());
                    C0974Ur.this.m(list);
                }
            }
        }

        public c() {
        }

        @Override // defpackage.N7
        public void a(com.android.billingclient.api.a aVar) {
            Log.d("purchase=", "onBillingSetupFinished:" + aVar.c() + ":" + aVar.a());
            if (aVar.c() == 0) {
                C0974Ur.this.o.e(C1218aJ.a().b("subs").a(), new a());
                return;
            }
            Log.d("purchase=", "err_" + aVar.a());
            Toast.makeText(C0974Ur.this.h, "Error " + aVar.a(), 0).show();
        }

        @Override // defpackage.N7
        public void b() {
            Log.d("purchase=", "onBillingServiceDisconnected");
        }
    }

    /* JADX INFO: renamed from: Ur$d */
    public class d implements InterfaceC2267gI {
        public d() {
        }

        @Override // defpackage.InterfaceC2267gI
        public void a(com.android.billingclient.api.a aVar, ZI zi) {
            if (aVar.c() != 0) {
                Log.d("purchase=", "err_" + aVar.a());
                Toast.makeText(C0974Ur.this.h, " Error " + aVar.a(), 0).show();
                return;
            }
            if (zi.a() == null || zi.a().isEmpty()) {
                Log.d("purchase=", "Purchase Item not Found");
                Toast.makeText(C0974Ur.this.h, "Purchase Item not Found", 0).show();
                return;
            }
            List listA = zi.a();
            Log.d("purchase=", "skuDetailsList_size=" + listA.size());
            C0974Ur.this.o.b(C0974Ur.this.i, O7.a().b(ImmutableList.of(O7.b.a().c((C2185fI) listA.get(0)).b(((C2185fI.e) ((C2185fI) listA.get(0)).e().get(0)).a()).a())).a());
        }
    }

    /* JADX INFO: renamed from: Ur$e */
    public interface e {
    }

    /* JADX INFO: renamed from: Ur$f */
    public interface f {
        void a(C1000Vr c1000Vr, DI di);
    }

    /* JADX INFO: renamed from: Ur$g */
    public interface g {
    }

    public C0974Ur(Context context, String str) {
        this.m = null;
        this.h = context.getApplicationContext();
        this.m = str;
        o("IAB helper created.");
    }

    public static String k(int i) {
        String[] strArrSplit = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] strArrSplit2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i > -1000) {
            if (i >= 0 && i < strArrSplit.length) {
                return strArrSplit[i];
            }
            return String.valueOf(i) + ":Unknown";
        }
        int i2 = (-1000) - i;
        if (i2 >= 0 && i2 < strArrSplit2.length) {
            return strArrSplit2[i2];
        }
        return String.valueOf(i) + ":Unknown IAB Helper Error";
    }

    @Override // defpackage.FI
    public void a(com.android.billingclient.api.a aVar, List list) {
        Log.d("purchase=", "onPurchasesUpdated:" + aVar.c() + ":" + aVar.a());
        if (aVar.c() == 0 && list != null) {
            Log.d("purchase=", "onPurchasesUpdated0:" + list.size());
            m(list);
            return;
        }
        if (aVar.c() == 7) {
            this.o.e(C1218aJ.a().b("subs").a(), new a());
            return;
        }
        if (aVar.c() == 1) {
            Log.d("purchase=", "onPurchasesUpdated:canceled");
            Toast.makeText(this.h, "Purchase Canceled", 0).show();
            return;
        }
        Log.d("purchase=", "onPurchasesUpdated:error");
        Toast.makeText(this.h, "Error " + aVar.a(), 0).show();
    }

    public final void e() {
        if (this.d) {
            throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
        }
    }

    public void f(String str) {
        if (this.c) {
            return;
        }
        p("Illegal state for operation (" + str + "): IAB helper is not set up.");
        throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
    }

    public void g() {
        o("Disposing.");
        this.c = false;
        if (this.j != null) {
            o("Unbinding from service.");
            Context context = this.h;
            if (context != null) {
                context.unbindService(this.j);
            }
        }
        this.d = true;
        this.h = null;
        this.j = null;
        this.q = null;
    }

    public void h(boolean z) {
        e();
        this.a = z;
    }

    public void i() {
        o("Ending async operation: " + this.g);
        this.g = "";
        this.f = false;
    }

    public int j(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            p("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return (int) ((Long) obj).longValue();
        }
        p("Unexpected type for intent response code.");
        p(obj.getClass().getName());
        throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
    }

    public boolean l(int i, int i2, Intent intent) {
        if (i != this.k) {
            return false;
        }
        e();
        f("handleActivityResult");
        i();
        if (intent == null) {
            p("Null data in IAB activity result.");
            C1000Vr c1000Vr = new C1000Vr(-1002, "Null data in IAB result");
            f fVar = this.q;
            if (fVar != null) {
                fVar.a(c1000Vr, null);
            }
            return true;
        }
        int iJ = j(intent);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (i2 == -1 && iJ == 0) {
            o("Successful resultcode from purchase activity.");
            o("Purchase data: " + stringExtra);
            o("Data signature: " + stringExtra2);
            o("Extras: " + intent.getExtras());
            o("Expected item type: " + this.l);
            if (stringExtra == null || stringExtra2 == null) {
                p("BUG: either purchaseData or dataSignature is null.");
                o("Extras: " + intent.getExtras().toString());
                C1000Vr c1000Vr2 = new C1000Vr(-1008, "IAB returned null purchaseData or dataSignature");
                f fVar2 = this.q;
                if (fVar2 != null) {
                    fVar2.a(c1000Vr2, null);
                }
                return true;
            }
            try {
                DI di = new DI(this.l, stringExtra, stringExtra2);
                String strB = di.b();
                if (!AbstractC3224kO.c(this.m, stringExtra, stringExtra2)) {
                    p("Purchase signature verification FAILED for sku " + strB);
                    C1000Vr c1000Vr3 = new C1000Vr(-1003, "Signature verification failed for sku " + strB);
                    f fVar3 = this.q;
                    if (fVar3 != null) {
                        fVar3.a(c1000Vr3, di);
                    }
                    return true;
                }
                o("Purchase signature successfully verified.");
                f fVar4 = this.q;
                if (fVar4 != null) {
                    fVar4.a(new C1000Vr(0, "Success"), di);
                }
            } catch (JSONException e2) {
                p("Failed to parse purchase data.");
                e2.printStackTrace();
                C1000Vr c1000Vr4 = new C1000Vr(-1002, "Failed to parse purchase data.");
                f fVar5 = this.q;
                if (fVar5 != null) {
                    fVar5.a(c1000Vr4, null);
                }
                return true;
            }
        } else if (i2 == -1) {
            o("Result code was OK but in-app billing response was not OK: " + k(iJ));
            if (this.q != null) {
                this.q.a(new C1000Vr(iJ, "Problem purchashing item."), null);
            }
        } else if (i2 == 0) {
            o("Purchase canceled - Response: " + k(iJ));
            C1000Vr c1000Vr5 = new C1000Vr(-1005, "User canceled.");
            f fVar6 = this.q;
            if (fVar6 != null) {
                fVar6.a(c1000Vr5, null);
            }
        } else {
            p("Purchase failed. Result code: " + Integer.toString(i2) + ". Response: " + k(iJ));
            C1000Vr c1000Vr6 = new C1000Vr(-1006, "Unknown purchase response.");
            f fVar7 = this.q;
            if (fVar7 != null) {
                fVar7.a(c1000Vr6, null);
            }
        }
        return true;
    }

    public void m(List list) {
        if (list.size() > 0) {
            Log.d("purchase=", "handlePurchases:" + ((Purchase) list.get(0)).b());
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Purchase purchase = (Purchase) it.next();
            if (purchase.e().contains("inv_yearly") && purchase.b() == 1) {
                if (!t(purchase.a(), purchase.d())) {
                    Toast.makeText(this.h, "Error : Invalid Purchase", 0).show();
                    return;
                }
                if (purchase.f()) {
                    s(purchase.c());
                    Z00 z00 = this.p;
                    z00.J0(this.h, z00.ia("token", ""), this.p.ia("payload", "0"), Boolean.FALSE);
                    Toast.makeText(this.h, "Item Purchased", 0).show();
                } else {
                    V1 v1A = V1.b().b(purchase.c()).a();
                    s(purchase.c());
                    Z00 z01 = this.p;
                    z01.J0(this.h, z01.ia("token", ""), this.p.ia("payload", "0"), Boolean.FALSE);
                    this.o.a(v1A, this.n);
                }
            } else if (purchase.e().contains("inv_yearly") && purchase.b() == 2) {
                Toast.makeText(this.h, "Purchase is Pending. Please complete Transaction", 0).show();
            } else if (purchase.e().contains("inv_yearly") && purchase.b() == 0) {
                s("");
                Toast.makeText(this.h, "Purchase Status Unknown", 0).show();
            }
        }
    }

    public final void n() {
        ImmutableList immutableListOf = ImmutableList.of(YI.b.a().b("inv_yearly").c("subs").a());
        YI.a aVarA = YI.a();
        aVarA.b(immutableListOf);
        this.o.d(aVarA.a(), new d());
    }

    public void o(String str) {
        if (this.a) {
            Log.d(this.b, str);
        }
    }

    public void p(String str) {
        Log.e(this.b, "In-app billing error: " + str);
    }

    public void q(Z00 z00) {
        this.p = z00;
        K7 k7A = K7.c(this.h).b(C4111vG.c().b().a()).c(this).a();
        this.o = k7A;
        k7A.f(new c());
    }

    public boolean r() {
        e();
        return this.e;
    }

    public void s(String str) {
        this.p.Lc("token", str);
        Z00 z00 = this.p;
        z00.Lc("payload", z00.ia("PREF_ACCOUNT_NAME", "0"));
    }

    public final boolean t(String str, String str2) {
        return AbstractC3224kO.c("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjIq7awTGxLV70jCMwubBPW06x1+SHASSefVHYH7q1Wk+w2z9wWtSHhVp1JRDNnEpSCeVy/DVXM1Pppw4+J7MXZO5g//8z6mHucGRmYCN0+DNGMt6Sy5U1OQVpD3kuNmErumBAcMw2hcG0WhiFAHexSZSbm+TA2+aB2Unq8bIr2NNWEwE5IFQoi+9r0VJ2ztZfnRN1gUi6qt1vP2F/uu6zmOuE1kpnygAfKQsm6q2z/EpuAMfdwQZ6yhToaY0NW96XlaXHXQ0QsHr4LsAhM19AQ01djDRKzd3nhAvB8BxAugizHCne8OFEmFx2qD9v/YPUENIZZaWy0jkmcqfFR5svQIDAQAB", str, str2);
    }
}
