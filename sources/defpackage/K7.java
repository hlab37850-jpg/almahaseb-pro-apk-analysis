package defpackage;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.play_billing.zzc;

/* JADX INFO: loaded from: classes2.dex */
public abstract class K7 {

    public static final class a {
        public volatile C4111vG a;
        public final Context b;
        public volatile FI c;
        public volatile boolean d;
        public volatile boolean e;
        public volatile boolean f;

        public /* synthetic */ a(Context context, AbstractC1252ai0 abstractC1252ai0) {
            this.b = context;
        }

        public K7 a() {
            Context context = this.b;
            if (context == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            if (this.c == null) {
                if (this.d || this.e) {
                    return d() ? new C3453n80(null, context, null, null, this) : new M7(null, context, null, null, this);
                }
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            }
            if (this.a == null || !this.a.a()) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            if (this.c == null) {
                C4111vG c4111vG = this.a;
                return d() ? new C3453n80(null, c4111vG, context, null, null, null, this) : new M7(null, c4111vG, context, null, null, null, this);
            }
            C4111vG c4111vG2 = this.a;
            FI fi = this.c;
            return d() ? new C3453n80(null, c4111vG2, context, fi, null, null, null, this) : new M7(null, c4111vG2, context, fi, null, null, null, this);
        }

        public a b(C4111vG c4111vG) {
            this.a = c4111vG;
            return this;
        }

        public a c(FI fi) {
            this.c = fi;
            return this;
        }

        public final boolean d() {
            try {
                Context context = this.b;
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("com.google.android.play.billingclient.enableBillingOverridesTesting", false);
            } catch (Exception e) {
                zzc.zzo("BillingClient", "Unable to retrieve metadata value for enableBillingOverridesTesting.", e);
                return false;
            }
        }
    }

    public static a c(Context context) {
        return new a(context, null);
    }

    public abstract void a(V1 v1, W1 w1);

    public abstract com.android.billingclient.api.a b(Activity activity, O7 o7);

    public abstract void d(YI yi, InterfaceC2267gI interfaceC2267gI);

    public abstract void e(C1218aJ c1218aJ, EI ei);

    public abstract void f(N7 n7);
}
