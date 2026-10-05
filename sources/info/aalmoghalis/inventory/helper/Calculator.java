package info.aalmoghalis.inventory.helper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import defpackage.C2142em;
import defpackage.F5;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class Calculator extends BaseActivity {
    public int[] c = {R.id.btnZero, R.id.btnOne, R.id.btnTwo, R.id.btnThree, R.id.btnFour, R.id.btnFive, R.id.btnSix, R.id.btnSeven, R.id.btnEight, R.id.btnNine};
    public int[] d = {R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide};
    public TextView e;
    public boolean f;
    public boolean g;
    public boolean h;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Button button = (Button) view;
            if (Calculator.this.g) {
                Calculator.this.e.setText(button.getText());
                Calculator.this.g = false;
            } else {
                Calculator.this.e.append(button.getText());
            }
            Calculator.this.f = true;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!Calculator.this.f || Calculator.this.g) {
                return;
            }
            Calculator.this.e.append(((Button) view).getText());
            Calculator.this.f = false;
            Calculator.this.h = false;
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Calculator.this.g || Calculator.this.h) {
                return;
            }
            if (Calculator.this.f) {
                Calculator.this.e.append(".");
            } else {
                Calculator.this.e.append("0.");
            }
            Calculator.this.f = false;
            Calculator.this.h = true;
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Calculator.this.e.setText("");
            Calculator.this.f = false;
            Calculator.this.g = false;
            Calculator.this.h = false;
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Calculator.this.H();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Calculator.this.G();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int length = Calculator.this.e.getText().length();
            if (Calculator.this.g || length < 1) {
                return;
            }
            int i = length - 1;
            if (Calculator.this.e.getText().toString().substring(i, length).equals(".") || Calculator.this.e.getText().toString().substring(i, length).equals("*") || Calculator.this.e.getText().toString().substring(i, length).equals("+") || Calculator.this.e.getText().toString().substring(i, length).equals("/") || Calculator.this.e.getText().toString().substring(i, length).equals("-")) {
                Calculator.this.h = false;
                Calculator.this.f = true;
            }
            Calculator.this.e.setText(Calculator.this.e.getText().toString().substring(0, i));
            int length2 = Calculator.this.e.getText().length();
            if (length2 >= 1) {
                int i2 = length2 - 1;
                if (Calculator.this.e.getText().toString().substring(i2, length2).equals(".")) {
                    Calculator.this.h = true;
                    Calculator.this.f = false;
                } else if (Calculator.this.e.getText().toString().substring(i2, length2).equals("*") || Calculator.this.e.getText().toString().substring(i2, length2).equals("+") || Calculator.this.e.getText().toString().substring(i2, length2).equals("/") || Calculator.this.e.getText().toString().substring(i2, length2).equals("-")) {
                    Calculator.this.h = false;
                    Calculator.this.f = false;
                }
            }
        }
    }

    public String F(String str) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        numberFormat.setMaximumFractionDigits(5);
        return numberFormat.format(Double.parseDouble(str));
    }

    public final void G() {
        try {
            if (!this.f || this.g) {
                return;
            }
            String string = this.e.getText().toString();
            if (string.isEmpty()) {
                return;
            }
            this.e.setText(Double.toString(new C2142em(string).a().a()));
            this.h = true;
            Intent intent = new Intent();
            intent.putExtra("calc_result", this.e.getText().toString());
            setResult(2, intent);
            finish();
        } catch (ArithmeticException unused) {
            this.e.setText("Error");
            this.g = true;
            this.f = false;
        }
    }

    public final void H() {
        if (!this.f || this.g) {
            return;
        }
        String string = this.e.getText().toString();
        if (string.isEmpty()) {
            return;
        }
        try {
            this.e.setText(F(Double.toString(new C2142em(string).a().a())).replaceAll(",", ""));
            this.h = true;
        } catch (ArithmeticException e2) {
            e2.printStackTrace();
            this.e.setText("Error");
            this.g = true;
            this.f = false;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void I() {
        a aVar = new a();
        for (int i : this.c) {
            findViewById(i).setOnClickListener(aVar);
        }
    }

    public final void J() {
        b bVar = new b();
        for (int i : this.d) {
            findViewById(i).setOnClickListener(bVar);
        }
        findViewById(R.id.btnDot).setOnClickListener(new c());
        findViewById(R.id.btnClear).setOnClickListener(new d());
        findViewById(R.id.btnEqual).setOnClickListener(new e());
        findViewById(R.id.confirm).setOnClickListener(new f());
        findViewById(R.id.btnClr).setOnClickListener(new g());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof F5) {
                    fragment.onActivityResult(i, i2, intent);
                }
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0, new Intent());
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        supportRequestWindowFeature(1);
        setContentView(R.layout.calculator);
        this.e = (TextView) findViewById(R.id.txtScreen);
        I();
        J();
        if (getIntent().getStringExtra("tr_amount") == null || getIntent().getStringExtra("tr_amount").length() < 1) {
            return;
        }
        this.e.setText(getIntent().getStringExtra("tr_amount").replaceAll(",", ""));
        this.f = true;
        if (this.e.getText() == null || !this.e.getText().toString().contains(".")) {
            return;
        }
        this.h = true;
    }
}
