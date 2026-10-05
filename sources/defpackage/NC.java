package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.internal.view.SupportMenu;
import com.itextpdf.tool.xml.css.CSS;
import com.zebra.sdk.util.internal.StringUtilities;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class NC extends BaseExpandableListAdapter implements Filterable {
    public Context a;
    public ArrayList b;
    public List c;
    public b d;
    public String e = "";
    public int f;
    public Z00 g;
    public SQLiteDatabase h;
    public ViewOnClickListenerC0967Uo i;

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        /* JADX INFO: renamed from: NC$a$a, reason: collision with other inner class name */
        public class HandlerC0011a extends Handler {
            public HandlerC0011a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                throw new RuntimeException();
            }
        }

        public class b implements AdapterView.OnItemClickListener {
            public final /* synthetic */ C1896ch a;
            public final /* synthetic */ Dialog b;

            public b(C1896ch c1896ch, Dialog dialog) {
                this.a = c1896ch;
                this.b = dialog;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                String str;
                String str2;
                String str3;
                String str4;
                String string = NC.this.a.getString(R.string.pref_default_display_name);
                String strIa = NC.this.g.ia("prefSMS_header", string);
                String strIa2 = NC.this.g.ia("prefSMS_footer", string);
                String strIa3 = NC.this.g.ia("prefSMS_credit", string);
                String strIa4 = NC.this.g.ia("prefSMS_debit", string);
                if (strIa3.equals(string)) {
                    strIa3 = NC.this.a.getString(R.string.credit);
                }
                if (strIa4.equals(string)) {
                    strIa4 = NC.this.a.getString(R.string.debit);
                }
                String str5 = "";
                if (i == 0) {
                    if (this.a.h() == null || this.a.h().length() < 4) {
                        Toast.makeText(NC.this.a, NC.this.a.getString(R.string.no_phone), 1).show();
                        this.b.dismiss();
                        return;
                    }
                    if (this.a.k() == R.drawable.up) {
                        Z00 z00 = NC.this.g;
                        String strH = this.a.h();
                        StringBuilder sb = new StringBuilder();
                        if (strIa.length() != 0) {
                            strIa3 = strIa + ":\n" + strIa3;
                        }
                        sb.append(strIa3);
                        sb.append(":");
                        sb.append(this.a.a());
                        if (Z00.Z) {
                            str4 = "\t" + this.a.c();
                        } else {
                            str4 = "";
                        }
                        sb.append(str4);
                        if (strIa2.length() != 0) {
                            str5 = StringUtilities.LF + strIa2;
                        }
                        sb.append(str5);
                        z00.Rc(strH, sb.toString());
                    } else if (this.a.k() == R.drawable.down) {
                        Z00 z01 = NC.this.g;
                        String strH2 = this.a.h();
                        StringBuilder sb2 = new StringBuilder();
                        if (strIa.length() != 0) {
                            strIa4 = strIa + ":\n" + strIa4;
                        }
                        sb2.append(strIa4);
                        sb2.append(":");
                        sb2.append(this.a.a());
                        if (Z00.Z) {
                            str3 = "\t" + this.a.c();
                        } else {
                            str3 = "";
                        }
                        sb2.append(str3);
                        if (strIa2.length() != 0) {
                            str5 = StringUtilities.LF + strIa2;
                        }
                        sb2.append(str5);
                        z01.Rc(strH2, sb2.toString());
                    }
                    this.b.dismiss();
                    return;
                }
                if (i != 1) {
                    if (i == 2) {
                        if ((this.a.h() == null || this.a.h().length() < 4) && NC.this.g.ja("approval_wa", true)) {
                            Toast.makeText(NC.this.a, NC.this.a.getString(R.string.no_phone), 1).show();
                            this.b.dismiss();
                            return;
                        }
                        NC.this.g.ob(this.a.j(), NC.this.g.ic(this.a.j() + "-" + NC.this.a.getString(R.string.approval)), CSS.Value.PERCENTAGE);
                        if (NC.this.g.ja("approval_wa", true)) {
                            Z00 z02 = NC.this.g;
                            String strH3 = this.a.h();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(NC.this.g.ic(this.a.j() + "-" + NC.this.a.getString(R.string.approval)));
                            sb3.append(".pdf");
                            z02.Hd(strH3, sb3.toString());
                        } else {
                            Z00 z03 = NC.this.g;
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(NC.this.g.ic(this.a.j() + "-" + NC.this.a.getString(R.string.approval)));
                            sb4.append(".pdf");
                            z03.ra(sb4.toString());
                        }
                        this.b.dismiss();
                        return;
                    }
                    return;
                }
                if (this.a.h() == null || this.a.h().length() < 4) {
                    Toast.makeText(NC.this.a, NC.this.a.getString(R.string.no_phone), 1).show();
                    this.b.dismiss();
                    return;
                }
                if (this.a.k() == R.drawable.up) {
                    Z00 z04 = NC.this.g;
                    String strH4 = this.a.h();
                    StringBuilder sb5 = new StringBuilder();
                    if (strIa.length() != 0) {
                        strIa3 = strIa + ":\n" + strIa3;
                    }
                    sb5.append(strIa3);
                    sb5.append(":");
                    sb5.append(this.a.a());
                    if (Z00.Z) {
                        str2 = "\t" + this.a.c();
                    } else {
                        str2 = "";
                    }
                    sb5.append(str2);
                    if (strIa2.length() != 0) {
                        str5 = StringUtilities.LF + strIa2;
                    }
                    sb5.append(str5);
                    z04.Ed(strH4, sb5.toString());
                } else if (this.a.k() == R.drawable.down) {
                    Z00 z05 = NC.this.g;
                    String strH5 = this.a.h();
                    StringBuilder sb6 = new StringBuilder();
                    if (strIa.length() != 0) {
                        strIa4 = strIa + ":\n" + strIa4;
                    }
                    sb6.append(strIa4);
                    sb6.append(":");
                    sb6.append(this.a.a());
                    if (Z00.Z) {
                        str = "\t" + this.a.c();
                    } else {
                        str = "";
                    }
                    sb6.append(str);
                    if (strIa2.length() != 0) {
                        str5 = StringUtilities.LF + strIa2;
                    }
                    sb6.append(str5);
                    z05.Ed(strH5, sb6.toString());
                }
                this.b.dismiss();
            }
        }

        public a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NC nc = NC.this;
            NC nc2 = NC.this;
            nc.g = new Z00(nc2.h, nc2.a);
            C1896ch c1896ch = (C1896ch) NC.this.getGroup(this.a);
            if ((c1896ch.h() == null || c1896ch.h().length() < 4) && NC.this.i != null) {
                HandlerC0011a handlerC0011a = new HandlerC0011a();
                NC nc3 = NC.this;
                nc3.g.fe(nc3.i.getActivity(), c1896ch.i(), c1896ch.j(), c1896ch.h(), NC.this.g.k4(c1896ch.i()), NC.this.g.y3(c1896ch.i()), NC.this.g.P4(c1896ch.i()), NC.this.g.v3(c1896ch.i()), handlerC0011a, NC.this.i.w);
                try {
                    Looper.loop();
                } catch (RuntimeException unused) {
                }
                NC.this.i.getActivity().recreate();
                return;
            }
            Dialog dialog = new Dialog(NC.this.a);
            LinearLayout linearLayout = new LinearLayout(NC.this.a);
            String[] stringArray = NC.this.a.getResources().getStringArray(R.array.titles9);
            TypedArray typedArrayObtainTypedArray = NC.this.a.getResources().obtainTypedArray(R.array.icons9);
            NC nc4 = NC.this;
            NC nc5 = NC.this;
            nc4.g = new Z00(nc5.h, nc5.a);
            if (!NC.this.g.ja("approval_wa", true) && stringArray.length > 3) {
                stringArray[3] = NC.this.a.getString(R.string.approval_title);
            }
            ListView listView = new ListView(NC.this.a);
            ArrayList arrayList = new ArrayList();
            for (int i = 1; i < stringArray.length; i++) {
                if (i != 3 || NC.this.g.ja("approval_wa", true)) {
                    arrayList.add(new C3874sM(stringArray[i], typedArrayObtainTypedArray.getResourceId(i, -1)));
                } else {
                    arrayList.add(new C3874sM(stringArray[i], R.drawable.pdf));
                }
            }
            typedArrayObtainTypedArray.recycle();
            listView.setAdapter((ListAdapter) new C3900sg(NC.this.a, arrayList));
            NC.this.a.getString(R.string.credit);
            NC.this.a.getString(R.string.debit);
            listView.setOnItemClickListener(new b(c1896ch, dialog));
            linearLayout.setFocusable(true);
            listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            listView.setDividerHeight(0);
            linearLayout.addView(listView, -1, -1);
            dialog.requestWindowFeature(1);
            dialog.setContentView(linearLayout);
            dialog.show();
        }
    }

    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            NC.this.e = charSequence.toString();
            if (charSequence.length() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                if (Z00.e0.size() == 0) {
                    while (i < NC.this.c.size()) {
                        if (((C1896ch) NC.this.c.get(i)).j().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((((C1896ch) NC.this.c.get(i)).h() != null && ((C1896ch) NC.this.c.get(i)).h().toUpperCase().contains(charSequence.toString().toUpperCase())) || ((C1896ch) NC.this.c.get(i)).a().replaceAll(",", "").toUpperCase().contains(charSequence.toString().toUpperCase()))) {
                            C1896ch c1896ch = new C1896ch(((C1896ch) NC.this.c.get(i)).i(), ((C1896ch) NC.this.c.get(i)).j(), ((C1896ch) NC.this.c.get(i)).h(), ((C1896ch) NC.this.c.get(i)).a().replaceAll(",", "").replaceAll("-0", "0"), ((C1896ch) NC.this.c.get(i)).k(), ((C1896ch) NC.this.c.get(i)).f(), ((C1896ch) NC.this.c.get(i)).c());
                            c1896ch.m(((C1896ch) NC.this.c.get(i)).e());
                            arrayList.add(c1896ch);
                        }
                        i++;
                    }
                } else {
                    while (i < Z00.e0.size()) {
                        if (((C1896ch) Z00.e0.get(i)).j().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((((C1896ch) Z00.e0.get(i)).h() != null && ((C1896ch) Z00.e0.get(i)).h().toUpperCase().contains(charSequence.toString().toUpperCase())) || ((C1896ch) Z00.e0.get(i)).a().replaceAll(",", "").toUpperCase().contains(charSequence.toString().toUpperCase()) || (((C1896ch) Z00.e0.get(i)).b() != null && ((C1896ch) Z00.e0.get(i)).b().toUpperCase().contains(charSequence.toString().toUpperCase())))) {
                            C1896ch c1896ch2 = new C1896ch(((C1896ch) Z00.e0.get(i)).i(), ((C1896ch) Z00.e0.get(i)).j(), ((C1896ch) Z00.e0.get(i)).h(), ((C1896ch) Z00.e0.get(i)).a().replaceAll(",", ""), ((C1896ch) Z00.e0.get(i)).k(), ((C1896ch) Z00.e0.get(i)).f(), ((C1896ch) Z00.e0.get(i)).c());
                            c1896ch2.l(((C1896ch) Z00.e0.get(i)).b());
                            Log.d("cus_curr=", c1896ch2.j() + ":" + c1896ch2.c());
                            arrayList.add(c1896ch2);
                        }
                        i++;
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            } else {
                filterResults.count = NC.this.c.size();
                filterResults.values = NC.this.c;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            NC nc = NC.this;
            nc.b = (ArrayList) filterResults.values;
            nc.notifyDataSetChanged();
        }

        public /* synthetic */ b(NC nc, a aVar) {
            this();
        }
    }

    public NC(Context context, ArrayList arrayList, int i, ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo) {
        this.a = context;
        this.b = arrayList;
        this.c = arrayList;
        this.f = i;
        this.i = viewOnClickListenerC0967Uo;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return ((C1896ch) this.b.get(i)).e().get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C1815bh c1815bh = (C1815bh) getChild(i, i2);
        if (view == null) {
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.report3_balance_month_exp, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.customer_name);
        TextView textView2 = (TextView) view.findViewById(R.id.balance);
        ImageView imageView = (ImageView) view.findViewById(R.id.img);
        TextView textView3 = (TextView) view.findViewById(R.id.days_late);
        textView.setText(c1815bh.e());
        textView3.setText(c1815bh.h());
        textView2.setText(c1815bh.a());
        imageView.setImageResource(c1815bh.f());
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((C1896ch) this.b.get(i)).e().size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.d == null) {
            this.d = new b(this, null);
        }
        return this.d;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C1896ch c1896ch = (C1896ch) getGroup(i);
        if (view == null) {
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.report2_customers_late, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.customer_name);
        TextView textView2 = (TextView) view.findViewById(R.id.balance);
        ImageView imageView = (ImageView) view.findViewById(R.id.img);
        TextView textView3 = (TextView) view.findViewById(R.id.days_late);
        TextView textView4 = (TextView) view.findViewById(R.id.count);
        textView.setText(c1896ch.j());
        textView3.setText(String.valueOf(c1896ch.f()));
        textView2.setText(c1896ch.a());
        imageView.setImageResource(c1896ch.k());
        textView4.setText(c1896ch.b());
        try {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.indicator);
            imageView2.setVisibility(0);
            if (z) {
                imageView2.setImageResource(R.drawable.sort_up_);
            } else {
                imageView2.setImageResource(R.drawable.sort_down_);
            }
            ImageView imageView3 = (ImageView) view.findViewById(R.id.indicator2);
            if (c1896ch.h() == null || c1896ch.h().length() < 4) {
                imageView3.setImageResource(R.drawable.add5);
            }
            imageView3.setOnClickListener(new a(i));
        } catch (Exception unused) {
        }
        String lowerCase = c1896ch.j().toLowerCase(Locale.getDefault());
        if (lowerCase.contains(this.e)) {
            int iIndexOf = lowerCase.indexOf(this.e);
            int length = this.e.length() + iIndexOf;
            Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(textView.getText());
            spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
            textView.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
        }
        String lowerCase2 = c1896ch.a().replaceAll(",", "").toLowerCase(Locale.getDefault());
        if (lowerCase2.contains(this.e)) {
            int iIndexOf2 = lowerCase2.indexOf(this.e);
            int length2 = this.e.length() + iIndexOf2;
            String string = textView2.getText().toString();
            int length3 = string.length() - string.replaceAll(",", "").length();
            if (this.e.length() > 0) {
                Spannable spannableNewSpannable2 = Spannable.Factory.getInstance().newSpannable(string);
                spannableNewSpannable2.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf2, length2 + length3, 33);
                textView2.setText(spannableNewSpannable2, TextView.BufferType.SPANNABLE);
            }
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
