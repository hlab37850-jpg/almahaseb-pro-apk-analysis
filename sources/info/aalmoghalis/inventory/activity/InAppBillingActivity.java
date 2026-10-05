package info.aalmoghalis.inventory.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import defpackage.C0974Ur;
import defpackage.C1000Vr;
import defpackage.DI;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;

/* JADX INFO: loaded from: classes3.dex */
public class InAppBillingActivity extends Activity {
    public int c;
    public C0974Ur d;
    public Button e;
    public Button f;
    public SQLiteDatabase g;
    public Z00 h;
    public boolean a = false;
    public boolean b = false;
    public C0974Ur.g i = new a();
    public C0974Ur.f j = new b();
    public C0974Ur.g k = new c();
    public C0974Ur.e l = new d();

    public class a implements C0974Ur.g {
        public a() {
        }
    }

    public class b implements C0974Ur.f {
        public b() {
        }

        @Override // defpackage.C0974Ur.f
        public void a(C1000Vr c1000Vr, DI di) {
            Log.d("purchase_inventory", "Purchase finished: " + c1000Vr + ", purchase: " + di);
            if (InAppBillingActivity.this.d == null) {
                return;
            }
            if (c1000Vr.b()) {
                InAppBillingActivity.this.c("Error purchasing: " + c1000Vr);
                InAppBillingActivity.this.f(false);
                return;
            }
            if (!InAppBillingActivity.this.i(di)) {
                InAppBillingActivity.this.c("Error purchasing. Authenticity verification failed.");
                InAppBillingActivity.this.f(false);
                return;
            }
            Log.d("purchase_inventory", "Purchase successful.");
            if (di.b().equals("inv_yearly")) {
                Log.d("purchase_inventory", "Infinite gas subscription purchased.");
                InAppBillingActivity.this.h(di.c());
                InAppBillingActivity inAppBillingActivity = InAppBillingActivity.this;
                inAppBillingActivity.b(inAppBillingActivity.getString(R.string.done));
                InAppBillingActivity.this.f.setEnabled(false);
                InAppBillingActivity.this.f(false);
            }
        }
    }

    public class c implements C0974Ur.g {
        public c() {
        }
    }

    public class d implements C0974Ur.e {
        public d() {
        }
    }

    public void b(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(str);
        builder.setNeutralButton("OK", (DialogInterface.OnClickListener) null);
        Log.d("purchase_inventory", "Showing alert dialog: " + str);
        builder.create().show();
    }

    public void buttonClicked(View view) {
        this.e.setEnabled(false);
        this.f.setEnabled(true);
    }

    public void buyClick(View view) {
        if (!this.d.r()) {
            c("Subscriptions not supported on your device yet. Sorry!");
        } else {
            f(true);
            Log.d("purchase_inventory", "Launching purchase flow for infinite gas subscription.");
        }
    }

    public void c(String str) {
        Log.e("purchase_inventory", "**** TrivialDrive Error: " + str);
        b("Error: " + str);
    }

    public void d() {
        this.c = getPreferences(0).getInt("tank", 2);
        Log.d("purchase_inventory", "Loaded data: tank = " + String.valueOf(this.c));
    }

    public void e() {
        SharedPreferences.Editor editorEdit = getPreferences(0).edit();
        editorEdit.putInt("tank", this.c);
        editorEdit.commit();
        Log.d("purchase_inventory", "Saved data: tank = " + String.valueOf(this.c));
    }

    public void f(boolean z) {
        findViewById(R.id.screen_main).setVisibility(z ? 8 : 0);
        findViewById(R.id.screen_wait).setVisibility(z ? 0 : 8);
    }

    public void g() {
    }

    public void h(String str) {
        this.h.Lc("token", str);
    }

    public boolean i(DI di) {
        di.a();
        return true;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Log.d("purchase_inventory", "onActivityResult(" + i + "," + i2 + "," + intent);
        C0974Ur c0974Ur = this.d;
        if (c0974Ur == null) {
            return;
        }
        if (c0974Ur.l(i, i2, intent)) {
            Log.d("purchase_inventory", "onActivityResult handled by IABUtil.");
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBuyGasButtonClicked(View view) {
        Log.d("purchase_inventory", "Buy gas button clicked.");
        if (this.b) {
            c("No need! You're subscribed to infinite gas. Isn't that awesome?");
        } else if (this.c >= 4) {
            c("Your tank is full. Drive around a bit!");
        } else {
            f(true);
            Log.d("purchase_inventory", "Launching purchase flow for gas.");
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_in_app_billing);
        d();
        this.h = new Z00(this.g, this);
        if (getPackageName().startsWith("com.example")) {
            throw new RuntimeException("Please change the sample's package name! See README.");
        }
        Log.d("purchase_inventory", "Creating IAB helper.");
        C0974Ur c0974Ur = new C0974Ur(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjIq7awTGxLV70jCMwubBPW06x1+SHASSefVHYH7q1Wk+w2z9wWtSHhVp1JRDNnEpSCeVy/DVXM1Pppw4+J7MXZO5g//8z6mHucGRmYCN0+DNGMt6Sy5U1OQVpD3kuNmErumBAcMw2hcG0WhiFAHexSZSbm+TA2+aB2Unq8bIr2NNWEwE5IFQoi+9r0VJ2ztZfnRN1gUi6qt1vP2F/uu6zmOuE1kpnygAfKQsm6q2z/EpuAMfdwQZ6yhToaY0NW96XlaXHXQ0QsHr4LsAhM19AQ01djDRKzd3nhAvB8BxAugizHCne8OFEmFx2qD9v/YPUENIZZaWy0jkmcqfFR5svQIDAQAB");
        this.d = c0974Ur;
        c0974Ur.h(true);
        Log.d("purchase_inventory", "Starting setup.");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.d("purchase_inventory", "Destroying helper.");
        C0974Ur c0974Ur = this.d;
        if (c0974Ur != null) {
            c0974Ur.g();
            this.d = null;
        }
    }

    public void onDriveButtonClicked(View view) {
        Log.d("purchase_inventory", "Drive button clicked.");
        boolean z = this.b;
        if (!z && this.c <= 0) {
            b("Oh, no! You are out of gas! Try buying some!");
            return;
        }
        if (!z) {
            this.c--;
        }
        e();
        b("Vroooom, you drove a few miles.");
        g();
        Log.d("purchase_inventory", "Vrooom. Tank is now " + this.c);
    }

    public void onInfiniteGasButtonClicked(View view) {
        if (!this.d.r()) {
            c("Subscriptions not supported on your device yet. Sorry!");
        } else {
            f(true);
            Log.d("purchase_inventory", "Launching purchase flow for infinite gas subscription.");
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.f = (Button) findViewById(R.id.buyButton);
        Button button = (Button) findViewById(R.id.clickButton);
        this.e = button;
        button.setEnabled(false);
    }

    public void onUpgradeAppButtonClicked(View view) {
        Log.d("purchase_inventory", "Upgrade button clicked; launching purchase flow for upgrade.");
        f(true);
    }
}
