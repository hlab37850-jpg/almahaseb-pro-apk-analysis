package info.aalmoghalis.inventory.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import defpackage.B2;
import defpackage.R00;
import info.aalmoghalis.inventory.R;

/* JADX INFO: loaded from: classes3.dex */
public class FontSetupActivity extends AppCompatActivity {
    public TextView a;
    public TextView b;
    public TextView c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;
    public View i;
    public SeekBar j;
    public int k;
    public int l;
    public int n;
    public int p;
    public int q;
    public int t;
    public R00 u = new R00();

    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            FontSetupActivity fontSetupActivity = FontSetupActivity.this;
            fontSetupActivity.t = fontSetupActivity.u.a + i;
            FontSetupActivity.this.D();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public final void B() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.k = defaultSharedPreferences.getInt("pref_title_color", this.u.b);
        this.l = defaultSharedPreferences.getInt("pref_body_color", this.u.c);
        this.n = defaultSharedPreferences.getInt("pref_header_color", this.u.d);
        this.p = defaultSharedPreferences.getInt("pref_credit_color", this.u.e);
        this.q = defaultSharedPreferences.getInt("pref_debit_color", this.u.f);
        int i = defaultSharedPreferences.getInt("pref_font_size", this.u.a);
        this.t = i;
        int i2 = this.u.a;
        if (i >= i2) {
            this.j.setProgress(i - i2);
        }
        D();
    }

    public final void C(int i, B2.h hVar) {
        new B2(this, i, hVar).u();
    }

    public final void D() {
        this.a.setTextColor(this.k);
        this.b.setTextColor(this.l);
        this.d.setBackgroundColor(this.n);
        this.e.setBackgroundColor(this.k);
        this.f.setBackgroundColor(this.l);
        this.g.setBackgroundColor(this.n);
        this.h.setBackgroundColor(this.p);
        this.i.setBackgroundColor(this.q);
        this.b.setTextSize(this.t);
        this.a.setTextSize(this.t + 4);
        this.c.setText(getString(R.string.font_size) + ": " + this.t);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_font_setup);
        this.a = (TextView) findViewById(R.id.preview_title);
        this.b = (TextView) findViewById(R.id.preview_body);
        this.d = findViewById(R.id.preview_container);
        this.c = (TextView) findViewById(R.id.label_font_size);
        this.e = findViewById(R.id.box_color_title);
        this.f = findViewById(R.id.box_color_body);
        this.g = findViewById(R.id.box_color_header);
        this.h = findViewById(R.id.box_credit_color);
        this.i = findViewById(R.id.box_debit_color);
        this.j = (SeekBar) findViewById(R.id.seekbar_font);
        B();
        this.j.setOnSeekBarChangeListener(new a());
    }

    public void pickBodyColor(View view) {
        C(this.l, new c());
    }

    public void pickCreditColor(View view) {
        C(this.p, new e());
    }

    public void pickDebitColor(View view) {
        C(this.q, new f());
    }

    public void pickHeaderColor(View view) {
        C(this.n, new d());
    }

    public void pickTitleColor(View view) {
        C(this.k, new b());
    }

    public void saveSettings(View view) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(this).edit();
        editorEdit.putInt("pref_title_color", this.k);
        editorEdit.putInt("pref_body_color", this.l);
        editorEdit.putInt("pref_header_color", this.n);
        editorEdit.putInt("pref_credit_color", this.p);
        editorEdit.putInt("pref_debit_color", this.q);
        editorEdit.putInt("pref_font_size", this.t);
        editorEdit.apply();
        Toast.makeText(this, "Settings Saved!", 0).show();
        finish();
    }

    public class b implements B2.h {
        public b() {
        }

        @Override // B2.h
        public void b(B2 b2, int i) {
            FontSetupActivity.this.k = i;
            FontSetupActivity.this.D();
        }

        @Override // B2.h
        public void a(B2 b2) {
        }
    }

    public class c implements B2.h {
        public c() {
        }

        @Override // B2.h
        public void b(B2 b2, int i) {
            FontSetupActivity.this.l = i;
            FontSetupActivity.this.D();
        }

        @Override // B2.h
        public void a(B2 b2) {
        }
    }

    public class d implements B2.h {
        public d() {
        }

        @Override // B2.h
        public void b(B2 b2, int i) {
            FontSetupActivity.this.n = i;
            FontSetupActivity.this.D();
        }

        @Override // B2.h
        public void a(B2 b2) {
        }
    }

    public class e implements B2.h {
        public e() {
        }

        @Override // B2.h
        public void b(B2 b2, int i) {
            FontSetupActivity.this.p = i;
            FontSetupActivity.this.D();
        }

        @Override // B2.h
        public void a(B2 b2) {
        }
    }

    public class f implements B2.h {
        public f() {
        }

        @Override // B2.h
        public void b(B2 b2, int i) {
            FontSetupActivity.this.q = i;
            FontSetupActivity.this.D();
        }

        @Override // B2.h
        public void a(B2 b2) {
        }
    }
}
