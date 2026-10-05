package defpackage;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class E00 {
    public boolean a = false;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public String k = "";
    public boolean l = false;
    public long m = 0;
    public String n = "";
    public String o = "";
    public String p = "";
    public String q = "";
    public C4064uh r = null;
    public int s = 0;
    public boolean t = false;
    public boolean u = false;
    public ActivityResultLauncher v;

    public class a implements AdapterView.OnItemClickListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public a(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
        }
    }

    public class b implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public b(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.showDropDown();
            return false;
        }
    }

    public class c implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Z00 a;
        public final /* synthetic */ AutoCompleteTextView b;
        public final /* synthetic */ EditText c;

        public c(Z00 z00, AutoCompleteTextView autoCompleteTextView, EditText editText) {
            this.a = z00;
            this.b = autoCompleteTextView;
            this.c = editText;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Map map = (Map) adapterView.getItemAtPosition(i);
            String str = (String) map.get("Name");
            this.a.nd(this.b, (String) map.get("Phone"));
            this.b.dismissDropDown();
            if (this.c.getText().toString().length() == 0) {
                this.c.setText(str);
            }
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
            ActivityResultLauncher activityResultLauncher = E00.this.v;
            if (activityResultLauncher != null) {
                activityResultLauncher.launch(intent);
            }
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Z00 c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ AlertDialog e;

        public h(AutoCompleteTextView autoCompleteTextView, String str, Z00 z00, EditText editText, AlertDialog alertDialog) {
            this.a = autoCompleteTextView;
            this.b = str;
            this.c = z00;
            this.d = editText;
            this.e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AbstractC4371yX.a(this.a)) {
                if (this.b != null) {
                    this.c.v0("update customers set name='" + this.d.getText().toString() + "',gsm='" + this.a.getText().toString() + "' where id=(select id from customers  where name='" + this.d.getText().toString() + "')");
                    C4064uh c4064uhP0 = this.c.P0(this.d.getText().toString());
                    E00.this.k = this.c.q4(this.d.getText().toString()).i();
                    E00 e00 = E00.this;
                    if (e00.j == 1 && e00.n.equals("")) {
                        String strAd = this.c.Ad(c4064uhP0, this.d.getText().toString(), Double.parseDouble(c4064uhP0.v));
                        Z00 z00 = this.c;
                        String string = this.a.getText().toString();
                        E00 e01 = E00.this;
                        z00.F(string, strAd, e01.k, e01.p, 1);
                    } else {
                        E00 e02 = E00.this;
                        if (e02.j == 2 && e02.n.equals("")) {
                            String strAd2 = this.c.Ad(c4064uhP0, this.d.getText().toString(), Double.parseDouble(c4064uhP0.v));
                            Z00 z01 = this.c;
                            String string2 = this.a.getText().toString();
                            E00 e03 = E00.this;
                            z01.F(string2, strAd2, e03.k, e03.p, 2);
                        } else {
                            E00 e04 = E00.this;
                            int i = e04.j;
                            if (i != 6 || e04.r == null) {
                                if (i == 7 && e04.r != null) {
                                    Z00 z02 = this.c;
                                    String string3 = this.a.getText().toString();
                                    Z00 z03 = this.c;
                                    C4064uh c4064uh = E00.this.r;
                                    z02.Rc(string3, z03.Dd(c4064uh, c4064uh.m(), Double.parseDouble(E00.this.r.c()), E00.this.r.q()));
                                } else if (e04.n.length() > 0) {
                                    Z00 z04 = this.c;
                                    String string4 = this.d.getText().toString();
                                    E00 e05 = E00.this;
                                    C4064uh c4064uhQ0 = z04.Q0(string4, e05.o, e05.m);
                                    Z00 z05 = this.c;
                                    String string5 = this.a.getText().toString();
                                    Z00 z06 = this.c;
                                    double d = Double.parseDouble(c4064uhQ0.v);
                                    E00 e06 = E00.this;
                                    z05.F(string5, z06.Cd(c4064uhQ0, d, e06.m, e06.n, e06.q), E00.this.k, this.c.ic(E00.this.p) + ".jpg", E00.this.j);
                                }
                            } else if (e04.u) {
                                e04.u = false;
                                Z00 z07 = this.c;
                                String string6 = this.a.getText().toString();
                                Z00 z08 = this.c;
                                C4064uh c4064uh2 = E00.this.r;
                                z07.F(string6, z08.Dd(c4064uh2, c4064uh2.t, Double.parseDouble(c4064uh2.c()), E00.this.r.q()), E00.this.r.x, E00.this.p + ".jpg", 2);
                            } else {
                                Z00 z09 = this.c;
                                String string7 = this.a.getText().toString();
                                Z00 z010 = this.c;
                                C4064uh c4064uh3 = E00.this.r;
                                z09.Ed(string7, z010.Dd(c4064uh3, c4064uh3.m(), Double.parseDouble(E00.this.r.c()), E00.this.r.q()));
                            }
                        }
                    }
                    E00.this.j = 0;
                }
                this.e.dismiss();
            }
        }
    }

    public class i implements ActivityResultCallback {
        public i() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onActivityResult(ActivityResult activityResult) {
            if (activityResult.getResultCode() == -1) {
                E00.this.b(activityResult);
            }
        }
    }

    public E00(Activity activity) {
        try {
            this.v = a((ComponentActivity) activity);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public ActivityResultLauncher a(ComponentActivity componentActivity) {
        return componentActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new i());
    }

    public void c(Activity activity, Z00 z00, String str, String str2) {
        try {
            Log.d("trace_auto_sms2=", str + ":" + str2 + ":" + this.j);
            FragmentStatePagerSupport_Main.a0 = true;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            View viewInflate = activity.getLayoutInflater().inflate(R.layout.dialog_customer_auto, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.cus_name);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_phone);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_call);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.img_class);
            AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) viewInflate.findViewById(R.id.cus_group);
            autoCompleteTextView2.setFilters(new InputFilter[]{new C4270xD()});
            imageView2.setVisibility(8);
            autoCompleteTextView2.setVisibility(8);
            editText.setText(str);
            autoCompleteTextView.setText(str2);
            ArrayAdapter arrayAdapter = new ArrayAdapter(activity, android.R.layout.simple_spinner_dropdown_item, z00.U5());
            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(arrayAdapter);
            autoCompleteTextView2.setOnItemClickListener(new a(autoCompleteTextView2));
            autoCompleteTextView2.setOnTouchListener(new b(autoCompleteTextView2));
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.setOnItemClickListener(new c(z00, autoCompleteTextView, editText));
            z00.ed(activity, autoCompleteTextView);
            autoCompleteTextView.addTextChangedListener(new d(autoCompleteTextView, new boolean[]{true}, activity, z00));
            imageView.setOnClickListener(new e());
            builder.setPositiveButton(activity.getString(R.string.resourceID_OK), new f());
            builder.setNegativeButton(activity.getString(R.string.resourceID_Cancel), new g());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new h(autoCompleteTextView, str, z00, editText, alertDialogCreate));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public class d implements TextWatcher {
        public final /* synthetic */ AutoCompleteTextView a;
        public final /* synthetic */ boolean[] b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ Z00 d;

        public d(AutoCompleteTextView autoCompleteTextView, boolean[] zArr, Activity activity, Z00 z00) {
            this.a = autoCompleteTextView;
            this.b = zArr;
            this.c = activity;
            this.d = z00;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.a.hasFocus()) {
                boolean[] zArr = this.b;
                if (zArr[0]) {
                    zArr[0] = false;
                    C1044Xj.a().c(new RunnableC1171Zj(5, this.c, this.a, new RunnableC1086Yj()));
                }
            }
            this.d.kd(this.c, this.a, charSequence.toString());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public void b(ActivityResult activityResult) {
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
