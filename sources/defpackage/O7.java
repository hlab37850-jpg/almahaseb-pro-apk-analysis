package defpackage;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzbg;
import com.google.android.gms.internal.play_billing.zzbt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class O7 {
    public boolean a;
    public String b;
    public String c;
    public c d;
    public zzbt e;
    public ArrayList f;
    public boolean g;

    public static class a {
        public String a;
        public String b;
        public List c;
        public ArrayList d;
        public boolean e;
        public c.a f;

        public /* synthetic */ a(AbstractC3698q80 abstractC3698q80) {
            c.a aVarA = c.a();
            c.a.b(aVarA);
            this.f = aVarA;
        }

        public O7 a() {
            ArrayList arrayList = this.d;
            boolean z = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.c;
            boolean z2 = (list == null || list.isEmpty()) ? false : true;
            if (!z && !z2) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z && z2) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            AbstractC3698q80 abstractC3698q80 = null;
            if (!z) {
                List list2 = this.c;
                if (list2 != null) {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        if (((b) it.next()) == null) {
                            throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                        }
                    }
                }
            } else {
                if (this.d.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if (this.d.size() > 1) {
                    AbstractC3574of.a(this.d.get(0));
                    throw null;
                }
            }
            O7 o7 = new O7(abstractC3698q80);
            if (z) {
                AbstractC3574of.a(this.d.get(0));
                throw null;
            }
            o7.a = z2 && !((b) this.c.get(0)).b().f().isEmpty();
            o7.b = this.a;
            o7.c = this.b;
            o7.d = this.f.a();
            ArrayList arrayList2 = this.d;
            o7.f = arrayList2 != null ? new ArrayList(arrayList2) : new ArrayList();
            o7.g = this.e;
            List list3 = this.c;
            o7.e = list3 != null ? zzbt.zzj(list3) : zzbt.zzk();
            return o7;
        }

        public a b(List list) {
            this.c = new ArrayList(list);
            return this;
        }
    }

    public static final class b {
        public final C2185fI a;
        public final String b;

        public static class a {
            public C2185fI a;
            public String b;

            public /* synthetic */ a(AbstractC3698q80 abstractC3698q80) {
            }

            public b a() {
                zzbg.zzc(this.a, "ProductDetails is required for constructing ProductDetailsParams.");
                return new b(this, null);
            }

            public a b(String str) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("offerToken can not be empty");
                }
                this.b = str;
                return this;
            }

            public a c(C2185fI c2185fI) {
                this.a = c2185fI;
                if (c2185fI.a() != null) {
                    c2185fI.a().getClass();
                    C2185fI.b bVarA = c2185fI.a();
                    if (bVarA.a() != null) {
                        this.b = bVarA.a();
                    }
                }
                return this;
            }
        }

        public /* synthetic */ b(a aVar, AbstractC3698q80 abstractC3698q80) {
            this.a = aVar.a;
            this.b = aVar.b;
        }

        public static a a() {
            return new a(null);
        }

        public final C2185fI b() {
            return this.a;
        }

        public final String c() {
            return this.b;
        }
    }

    public static class c {
        public String a;
        public String b;
        public int c = 0;

        public static class a {
            public String a;
            public String b;
            public boolean c;
            public int d = 0;

            public /* synthetic */ a(AbstractC3698q80 abstractC3698q80) {
            }

            public static /* synthetic */ a b(a aVar) {
                aVar.c = true;
                return aVar;
            }

            public c a() {
                boolean z = true;
                AbstractC3698q80 abstractC3698q80 = null;
                if (TextUtils.isEmpty(this.a) && TextUtils.isEmpty(null)) {
                    z = false;
                }
                boolean zIsEmpty = TextUtils.isEmpty(this.b);
                if (z && !zIsEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.c && !z && zIsEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                c cVar = new c(abstractC3698q80);
                cVar.a = this.a;
                cVar.c = this.d;
                cVar.b = this.b;
                return cVar;
            }
        }

        public /* synthetic */ c(AbstractC3698q80 abstractC3698q80) {
        }

        public static a a() {
            return new a(null);
        }

        public final int b() {
            return this.c;
        }

        public final String c() {
            return this.a;
        }

        public final String d() {
            return this.b;
        }
    }

    public /* synthetic */ O7(AbstractC3698q80 abstractC3698q80) {
    }

    public static a a() {
        return new a(null);
    }

    public int b() {
        return 0;
    }

    public final int c() {
        return this.d.b();
    }

    public long d() {
        return 0L;
    }

    public final com.android.billingclient.api.a e() {
        C2185fI.b bVar;
        if (this.e.isEmpty()) {
            return com.android.billingclient.api.b.i;
        }
        b bVar2 = (b) this.e.get(0);
        for (int i = 1; i < this.e.size(); i++) {
            b bVar3 = (b) this.e.get(i);
            if (!bVar3.b().d().equals(bVar2.b().d()) && !bVar3.b().d().equals("play_pass_subs")) {
                return com.android.billingclient.api.b.a(5, "All products should have same ProductType.");
            }
        }
        String strF = bVar2.b().f();
        HashMap map = new HashMap();
        HashSet<String> hashSet = new HashSet();
        zzbt zzbtVar = this.e;
        int size = zzbtVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar4 = (b) zzbtVar.get(i2);
            if (bVar4.b().e() != null && bVar4.c() == null) {
                return com.android.billingclient.api.b.a(5, String.format("offerToken is required for constructing ProductDetailsParams for subscriptions. Missing value for product id: %s", bVar4.b().c()));
            }
            if (map.containsKey(bVar4.b().c())) {
                return com.android.billingclient.api.b.a(5, String.format("ProductId can not be duplicated. Invalid product id: %s.", bVar4.b().c()));
            }
            map.put(bVar4.b().c(), bVar4);
            if (!bVar2.b().d().equals("play_pass_subs") && !bVar4.b().d().equals("play_pass_subs") && !strF.equals(bVar4.b().f())) {
                return com.android.billingclient.api.b.a(5, "All products must have the same package name.");
            }
        }
        for (String str : hashSet) {
            if (map.containsKey(str)) {
                return com.android.billingclient.api.b.a(5, String.format("OldProductId must not be one of the products to be purchased. Invalid old product id: %s.", str));
            }
        }
        List listB = bVar2.b().b();
        String strC = bVar2.c();
        if (strC != null && listB != null) {
            Iterator it = listB.iterator();
            do {
                if (!it.hasNext()) {
                    bVar = null;
                    break;
                }
                bVar = (C2185fI.b) it.next();
            } while (!strC.equals(bVar.a()));
            if (bVar != null && bVar.b() != null) {
                return com.android.billingclient.api.b.a(5, "Both autoPayDetails and autoPayBalanceThreshold is required for constructing ProductDetailsParams for autopay.");
            }
        }
        return com.android.billingclient.api.b.i;
    }

    public final String f() {
        return this.b;
    }

    public final String g() {
        return this.c;
    }

    public String h() {
        return null;
    }

    public final String i() {
        return this.d.c();
    }

    public final String j() {
        return this.d.d();
    }

    public final ArrayList k() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f);
        return arrayList;
    }

    public final List l() {
        return this.e;
    }

    public final boolean t() {
        return this.g;
    }

    public final boolean u() {
        if (this.b != null || this.c != null || this.d.d() != null || this.d.b() != 0 || this.a || this.g) {
            return true;
        }
        zzbt zzbtVar = this.e;
        if (zzbtVar != null) {
            int size = zzbtVar.size();
            for (int i = 0; i < size; i++) {
            }
        }
        return false;
    }
}
