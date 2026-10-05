package info.aalmoghalis.inventory.helper;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.kyanogen.signatureview.SignatureView;
import defpackage.C0372Bn;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;

/* JADX INFO: loaded from: classes3.dex */
public class Signature_add extends BaseActivity {
    public static boolean i = false;
    public Bitmap c;
    public Button d;
    public Button e;
    public SignatureView f;
    public SQLiteDatabase g;
    public Z00 h;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Signature_add.this.f.a();
            Signature_add.this.h.Lc("Sign_Decode", "");
            Signature_add.i = true;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Signature_add signature_add = Signature_add.this;
            signature_add.c = signature_add.f.getSignatureBitmap();
            Signature_add.this.h.Lc("Sign_Decode", Z00.d(Signature_add.this.c));
            Signature_add.i = true;
            Signature_add.this.finish();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_signature);
        this.h = new Z00(this.g, this);
        this.f = (SignatureView) findViewById(R.id.signature_view);
        if (!this.h.ia("Sign_Decode", "").equals("")) {
            this.f.setBitmap(Z00.o0(this.h.ia("Sign_Decode", "")).copy(Bitmap.Config.ARGB_8888, true));
        }
        this.d = (Button) findViewById(R.id.clear);
        this.e = (Button) findViewById(R.id.save);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.d);
        c0372Bn.a(this, this.e);
        this.d.setOnClickListener(new a());
        this.e.setOnClickListener(new b());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
