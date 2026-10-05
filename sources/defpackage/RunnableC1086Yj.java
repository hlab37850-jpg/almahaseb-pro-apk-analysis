package defpackage;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import info.aalmoghalis.inventory.R;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: renamed from: Yj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC1086Yj implements Runnable {
    public int a;
    public int b;
    public ArrayAdapter c;
    public Context e;
    public ArrayAdapter q;
    public ArrayAdapter t;
    public C3962tT u;
    public C0783Nv v;
    public int y;
    public String z;
    public ArrayList d = new ArrayList();
    public LinearLayout f = null;
    public Button g = null;
    public AutoCompleteTextView h = null;
    public AutoCompleteTextView i = null;
    public AutoCompleteTextView j = null;
    public AutoCompleteTextView k = null;
    public ArrayList l = new ArrayList();
    public AutoCompleteTextView n = null;
    public AutoCompleteTextView p = null;
    public String[] w = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public String[] x = {""};
    public TextView A = null;
    public EditText B = null;

    /* JADX INFO: renamed from: Yj$a */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AutoCompleteTextView autoCompleteTextView;
            AutoCompleteTextView autoCompleteTextView2;
            Log.d("action_type=", RunnableC1086Yj.this.a + ":" + this.a);
            RunnableC1086Yj runnableC1086Yj = RunnableC1086Yj.this;
            int i = runnableC1086Yj.a;
            if (i == 2) {
                runnableC1086Yj.h.setText(this.a);
                RunnableC1086Yj.this.g.performClick();
                return;
            }
            if (i == 3) {
                int i2 = runnableC1086Yj.b;
                if (i2 == 2 && (autoCompleteTextView2 = runnableC1086Yj.h) != null) {
                    autoCompleteTextView2.setText(this.a);
                    RunnableC1086Yj.this.g.performClick();
                } else {
                    if (i2 == 2 || (autoCompleteTextView = runnableC1086Yj.i) == null) {
                        return;
                    }
                    autoCompleteTextView.setText(this.a);
                }
            }
        }
    }

    public void a() {
        this.k.setAdapter(new SimpleAdapter(this.e, this.l, R.layout.custcontview, new String[]{"Name", "Phone", "Type"}, new int[]{R.id.ccontName, R.id.ccontNo, R.id.ccontType}));
        this.k.setThreshold(1);
        if (this.k.hasFocus()) {
            this.k.showDropDown();
        }
    }

    public void b(ArrayList arrayList) {
        LayoutInflater layoutInflater = (LayoutInflater) this.e.getSystemService("layout_inflater");
        int size = arrayList.size();
        if (this.f.getChildCount() > 0) {
            this.f.removeAllViews();
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2) != null) {
                i++;
                if (i >= 4) {
                    return;
                }
                RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.clickable_remarks, (ViewGroup) null);
                new LinearLayout.LayoutParams(-2, -2);
                Button button = (Button) relativeLayout.findViewById(R.id.btn_remarks);
                button.setText((CharSequence) arrayList.get(i2));
                button.setOnClickListener(new a((String) arrayList.get(i2)));
                this.f.addView(relativeLayout);
            }
        }
    }

    public void c() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.e, android.R.layout.simple_dropdown_item_1line, this.w);
        this.q = arrayAdapter;
        int i = this.b;
        if (i == 1 || i == 3) {
            this.i.setAdapter(arrayAdapter);
        } else if (i == 2) {
            this.h.setAdapter(arrayAdapter);
        }
    }

    public void d() {
        Log.d("bill_remarks=", this.x.length + "");
        this.t = new ArrayAdapter(this.e, android.R.layout.simple_dropdown_item_1line, this.x);
        this.j.setThreshold(1);
        this.j.setAdapter(this.t);
    }

    public String e(String str) {
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(str));
    }

    public void f() {
        this.u = new C3962tT(this.e, android.R.layout.simple_dropdown_item_1line, this.d);
        this.n.setThreshold(1);
        if (this.a == 2) {
            this.p.setThreshold(1);
            this.p.setAdapter(this.c);
        }
        this.n.setAdapter(this.c);
        b(this.d);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            int i = this.a;
            if (i != 1) {
                if (i == 2 || i == 3) {
                    f();
                } else if (i == 4) {
                    c();
                } else if (i == 5) {
                    a();
                } else if (i == 13) {
                    if (this.y > 0) {
                        SpannableString spannableString = new SpannableString(this.A.getText().toString());
                        spannableString.setSpan(new UnderlineSpan(), this.A.getText().toString().length() - this.z.length(), this.A.getText().toString().length(), 0);
                        this.A.setText(spannableString);
                    }
                } else if (i == 16) {
                    d();
                } else if (i == 17) {
                    if (!this.B.getText().toString().equals(C2018dE.d(this.B.getText().toString().replaceAll(",", "")))) {
                        EditText editText = this.B;
                        editText.setText(C2018dE.d(editText.getText().toString().replaceAll(",", "")));
                        EditText editText2 = this.B;
                        editText2.setSelection(editText2.getText().toString().length());
                    }
                } else if (i == 18) {
                    this.v.notifyDataSetChanged();
                } else if (i == 19) {
                    this.A.setText(e(String.valueOf(C0908Sh.n)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
