package defpackage;

import android.R;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.itextpdf.tool.xml.css.CSS;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: Zj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC1171Zj implements Runnable {
    public String[] A;
    public String[] B;
    public ArrayAdapter C;
    public ArrayAdapter D;
    public AutoCompleteTextView E;
    public int F;
    public AutoCompleteTextView G;
    public C1098Yv H;
    public String I;
    public TextView J;
    public String K;
    public String L;
    public String M;
    public int N;
    public int O;
    public ArrayList P;
    public RunnableC1086Yj a;
    public ArrayList b;
    public ArrayAdapter c;
    public AutoCompleteTextView d;
    public AutoCompleteTextView e;
    public AutoCompleteTextView f;
    public AutoCompleteTextView g;
    public AutoCompleteTextView h;
    public C3962tT i;
    public Context j;
    public LinearLayout k;
    public Button l;
    public int n;
    public Z00 p;
    public EditText q;
    public String t;
    public String u;
    public double v;
    public List w;
    public C0783Nv x;
    public int y;
    public List z;

    public RunnableC1171Zj(int i, Z00 z00, Context context) {
        this.b = new ArrayList();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.k = null;
        this.l = null;
        this.q = null;
        this.v = 0.0d;
        this.w = new ArrayList();
        this.z = new ArrayList();
        this.A = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.B = new String[]{""};
        this.E = null;
        this.F = 0;
        this.G = null;
        this.J = null;
        this.N = 0;
        this.O = 0;
        this.P = new ArrayList();
        this.n = i;
        this.p = z00;
        this.j = context;
        Log.d("trace_thread=", i + "");
    }

    public void a(Context context) {
        Cursor cursorQuery;
        this.P.clear();
        if (this.G.getText() == null || this.G.getText().length() <= 0) {
            cursorQuery = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1", "display_name", "data2"}, null, null, null);
            Log.d("people_cnt=", cursorQuery.getCount() + "#2");
        } else {
            Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI, Uri.encode(this.G.getText().toString()));
            Log.d("people_cnt=", this.G.getText().toString() + "#SSS");
            StringBuilder sb = new StringBuilder();
            sb.append(CSS.Value.PERCENTAGE);
            sb.append(this.G.getText().toString());
            sb.append(CSS.Value.PERCENTAGE);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CSS.Value.PERCENTAGE);
            sb2.append(this.G.getText().toString());
            sb2.append(CSS.Value.PERCENTAGE);
            cursorQuery = context.getContentResolver().query(uriWithAppendedPath, new String[]{"data1", "display_name", "data2"}, null, null, null);
            Log.d("people_cnt=", cursorQuery.getCount() + "#1");
        }
        while (cursorQuery.moveToNext()) {
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("data2"));
            if (string2.length() > 0) {
                string2 = string2.replaceAll("-", "").replaceAll(" ", "");
            }
            HashMap map = new HashMap();
            map.put("Name", string);
            map.put("Phone", string2);
            if (string3.equals("0")) {
                map.put("Type", "Work");
            } else if (string3.equals("1")) {
                map.put("Type", "Home");
            } else if (string3.equals("2")) {
                map.put("Type", "Mobile");
            } else {
                map.put("Type", "Other");
            }
            this.P.add(map);
            map.put("Name", string);
            map.put("Phone", string2);
        }
        cursorQuery.close();
    }

    public void b() {
        this.v = 0.0d;
        try {
            for (int size = this.w.size() - 1; size >= 0; size--) {
                this.v += Double.parseDouble(((C4064uh) this.w.get(size)).n().replaceAll(",", "")) * (Double.parseDouble(((C4064uh) this.w.get(size)).f().replaceAll(",", "")) - 1.0d);
                C4064uh c4064uh = (C4064uh) this.w.get(size);
                c4064uh.w(String.valueOf(this.v));
                this.w.set(size, c4064uh);
            }
        } catch (Exception unused) {
        }
    }

    public void c() {
        Cursor cursorE8 = this.p.E8(this.d.getText().toString());
        int count = cursorE8.getCount();
        Log.d("Remarks_CNT=", count + ":" + this.d.getText().toString());
        this.A = new String[count];
        if (cursorE8.moveToFirst()) {
            int i = 0;
            do {
                this.A[i] = cursorE8.getString(cursorE8.getColumnIndex("remarks"));
                i++;
            } while (cursorE8.moveToNext());
        }
        cursorE8.close();
    }

    public void d() {
        Cursor cursorD8 = this.p.D8(this.f.getText().toString());
        int count = cursorD8.getCount();
        Log.d("Remarks_CNT=", count + ":" + this.f.getText().toString());
        this.B = new String[count];
        if (cursorD8.moveToFirst()) {
            int i = 0;
            do {
                this.B[i] = cursorD8.getString(cursorD8.getColumnIndex("remark"));
                i++;
            } while (cursorD8.moveToNext());
        }
        cursorD8.close();
    }

    public double e(List list) {
        double d = 0.0d;
        for (int i = 0; i < list.size(); i++) {
            if (this.y == 13) {
                d += Double.parseDouble(((C4145vh) list.get(i)).f().replaceAll(",", ""));
            }
        }
        return d;
    }

    public void f() {
        AutoCompleteTextView autoCompleteTextView;
        AutoCompleteTextView autoCompleteTextView2;
        int i = this.n;
        if (i == 2) {
            this.c = new ArrayAdapter(this.j, R.layout.simple_dropdown_item_1line, this.p.K4(this.d.getText().toString(), this.g.getText().toString()));
            if (this.h.getText().toString().length() <= 0) {
                this.b = this.p.F8(this.d.getText().toString(), this.g.getText().toString());
                return;
            }
            this.b = this.p.G8(this.d.getText().toString(), this.g.getText().toString(), CSS.Value.PERCENTAGE + this.h.getText().toString() + CSS.Value.PERCENTAGE);
            return;
        }
        if (i == 3) {
            this.c = new ArrayAdapter(this.j, R.layout.simple_dropdown_item_1line, this.p.K4(this.d.getText().toString(), ""));
            if (this.F == 2 && (autoCompleteTextView2 = this.h) != null && autoCompleteTextView2.getText().toString().length() > 0) {
                this.b = this.p.G8(this.d.getText().toString(), "", CSS.Value.PERCENTAGE + this.h.getText().toString() + CSS.Value.PERCENTAGE);
                return;
            }
            if (this.F == 2 || (autoCompleteTextView = this.E) == null || autoCompleteTextView.getText().toString().length() <= 0) {
                this.b = this.p.F8(this.d.getText().toString(), "");
                return;
            }
            this.b = this.p.G8(this.d.getText().toString(), "", CSS.Value.PERCENTAGE + this.E.getText().toString() + CSS.Value.PERCENTAGE);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            int i = this.n;
            if (i == 1) {
                this.p.Vb();
            } else if (i == 2 || i == 3) {
                f();
            } else if (i == 4) {
                c();
            } else if (i == 5) {
                a(this.j);
            } else if (i == 6) {
                this.p.L1();
                this.p.U0();
            } else if (i == 7) {
                this.p.Sb();
            } else if (i == 8) {
                this.p.F0(this.j);
            } else if (i != 9) {
                if (i == 10) {
                    this.p.J0(this.j, this.t, this.u, Boolean.TRUE);
                } else if (i == 11) {
                    this.p.oe();
                } else if (i == 12) {
                    this.p.N1();
                } else if (i == 13) {
                    Log.d("trace_S_curr_cnt=", FragmentStatePagerSupport_Main.X());
                    int i2 = this.N;
                    if (i2 == 0) {
                        this.O = this.p.S5(this.K, this.L, this.M).getCount();
                    } else if (i2 == 1) {
                        this.O = this.p.H3(this.K, this.M).getCount();
                    }
                    Log.d("trace_E_curr_cnt=", FragmentStatePagerSupport_Main.X());
                } else if (i == 14) {
                    this.p.K1();
                } else if (this.F == 15) {
                    this.H.getFilter().filter(this.I);
                } else if (i == 16) {
                    d();
                } else if (i == 18) {
                    b();
                } else if (i == 19) {
                    double dE = e(this.z);
                    C0908Sh.n = dE;
                    this.v = dE;
                } else if (i == 21) {
                    this.p.G0(this.j);
                }
            }
            RunnableC1086Yj runnableC1086Yj = this.a;
            if (runnableC1086Yj != null) {
                runnableC1086Yj.a = this.n;
                runnableC1086Yj.b = this.F;
                runnableC1086Yj.e = this.j;
                runnableC1086Yj.c = this.c;
                runnableC1086Yj.q = this.C;
                runnableC1086Yj.t = this.D;
                runnableC1086Yj.l = this.P;
                runnableC1086Yj.k = this.G;
                runnableC1086Yj.w = this.A;
                runnableC1086Yj.x = this.B;
                runnableC1086Yj.f = this.k;
                runnableC1086Yj.g = this.l;
                runnableC1086Yj.n = this.d;
                runnableC1086Yj.j = this.e;
                runnableC1086Yj.p = this.g;
                runnableC1086Yj.d = this.b;
                runnableC1086Yj.h = this.h;
                runnableC1086Yj.i = this.E;
                runnableC1086Yj.u = this.i;
                runnableC1086Yj.y = this.O;
                runnableC1086Yj.z = this.M;
                runnableC1086Yj.A = this.J;
                runnableC1086Yj.B = this.q;
                runnableC1086Yj.v = this.x;
                C1044Xj.a().b().execute(this.a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RunnableC1171Zj(int i, EditText editText, RunnableC1086Yj runnableC1086Yj) {
        this.b = new ArrayList();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.k = null;
        this.l = null;
        this.q = null;
        this.v = 0.0d;
        this.w = new ArrayList();
        this.z = new ArrayList();
        this.A = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.B = new String[]{""};
        this.E = null;
        this.F = 0;
        this.G = null;
        this.J = null;
        this.N = 0;
        this.O = 0;
        this.P = new ArrayList();
        this.n = i;
        this.q = editText;
        Log.d("trace_thread=", i + "");
        this.a = runnableC1086Yj;
    }

    public RunnableC1171Zj(int i, Z00 z00, Context context, String str, String str2) {
        this.b = new ArrayList();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.k = null;
        this.l = null;
        this.q = null;
        this.v = 0.0d;
        this.w = new ArrayList();
        this.z = new ArrayList();
        this.A = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.B = new String[]{""};
        this.E = null;
        this.F = 0;
        this.G = null;
        this.J = null;
        this.N = 0;
        this.O = 0;
        this.P = new ArrayList();
        this.n = i;
        this.p = z00;
        this.j = context;
        this.t = str;
        this.u = str2;
        Log.d("trace_thread=", i + "");
    }

    public RunnableC1171Zj(int i, Z00 z00, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, AutoCompleteTextView autoCompleteTextView3, Context context, LinearLayout linearLayout, Button button, RunnableC1086Yj runnableC1086Yj) {
        this.b = new ArrayList();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.k = null;
        this.l = null;
        this.q = null;
        this.v = 0.0d;
        this.w = new ArrayList();
        this.z = new ArrayList();
        this.A = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.B = new String[]{""};
        this.E = null;
        this.F = 0;
        this.G = null;
        this.J = null;
        this.N = 0;
        this.O = 0;
        this.P = new ArrayList();
        this.n = i;
        this.p = z00;
        this.d = autoCompleteTextView;
        this.g = autoCompleteTextView2;
        this.h = autoCompleteTextView3;
        this.j = context;
        this.k = linearLayout;
        this.l = button;
        this.a = runnableC1086Yj;
        Log.d("trace_thread=", i + "");
    }

    public RunnableC1171Zj(int i, Z00 z00, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, Context context, RunnableC1086Yj runnableC1086Yj) {
        this.b = new ArrayList();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.k = null;
        this.l = null;
        this.q = null;
        this.v = 0.0d;
        this.w = new ArrayList();
        this.z = new ArrayList();
        this.A = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.B = new String[]{""};
        this.E = null;
        this.F = 0;
        this.G = null;
        this.J = null;
        this.N = 0;
        this.O = 0;
        this.P = new ArrayList();
        this.n = i;
        this.p = z00;
        this.f = autoCompleteTextView;
        this.e = autoCompleteTextView2;
        this.j = context;
        this.a = runnableC1086Yj;
        Log.d("trace_thread=", i + "");
    }

    public RunnableC1171Zj(int i, Z00 z00, AutoCompleteTextView autoCompleteTextView, AutoCompleteTextView autoCompleteTextView2, AutoCompleteTextView autoCompleteTextView3, Context context, LinearLayout linearLayout, int i2, Button button, RunnableC1086Yj runnableC1086Yj) {
        this.b = new ArrayList();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.k = null;
        this.l = null;
        this.q = null;
        this.v = 0.0d;
        this.w = new ArrayList();
        this.z = new ArrayList();
        this.A = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.B = new String[]{""};
        this.E = null;
        this.F = 0;
        this.G = null;
        this.J = null;
        this.N = 0;
        this.O = 0;
        this.P = new ArrayList();
        this.n = i;
        this.p = z00;
        this.d = autoCompleteTextView;
        this.h = autoCompleteTextView2;
        this.E = autoCompleteTextView3;
        this.j = context;
        this.k = linearLayout;
        this.F = i2;
        this.l = button;
        this.a = runnableC1086Yj;
    }

    public RunnableC1171Zj(int i, Context context, AutoCompleteTextView autoCompleteTextView, RunnableC1086Yj runnableC1086Yj) {
        this.b = new ArrayList();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.k = null;
        this.l = null;
        this.q = null;
        this.v = 0.0d;
        this.w = new ArrayList();
        this.z = new ArrayList();
        this.A = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.B = new String[]{""};
        this.E = null;
        this.F = 0;
        this.G = null;
        this.J = null;
        this.N = 0;
        this.O = 0;
        this.P = new ArrayList();
        this.n = i;
        this.j = context;
        this.G = autoCompleteTextView;
        this.a = runnableC1086Yj;
    }

    public RunnableC1171Zj(int i, Z00 z00, TextView textView, String str, String str2, String str3, int i2, RunnableC1086Yj runnableC1086Yj) {
        this.b = new ArrayList();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.k = null;
        this.l = null;
        this.q = null;
        this.v = 0.0d;
        this.w = new ArrayList();
        this.z = new ArrayList();
        this.A = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.B = new String[]{""};
        this.E = null;
        this.F = 0;
        this.G = null;
        this.J = null;
        this.N = 0;
        this.O = 0;
        this.P = new ArrayList();
        this.n = i;
        this.p = z00;
        this.J = textView;
        this.K = str;
        this.L = str2;
        this.M = str3;
        this.N = i2;
        this.a = runnableC1086Yj;
    }
}
