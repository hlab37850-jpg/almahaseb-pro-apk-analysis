package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import info.aalmoghalis.inventory.activity.Bill_edit;
import info.aalmoghalis.inventory.activity.Customer_Det_List_edit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: Qv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0870Qv extends ArrayAdapter implements Filterable {
    public Context a;
    public LayoutInflater b;
    public int c;
    public List d;
    public List e;
    public b f;
    public String g;
    public SparseBooleanArray h;
    public ArrayList i;
    public Bitmap j;
    public Bitmap k;
    public int[] l;
    public SQLiteDatabase n;
    public Z00 p;

    /* JADX INFO: renamed from: Qv$a */
    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ c b;

        /* JADX INFO: renamed from: Qv$a$a, reason: collision with other inner class name */
        public class C0013a implements AdapterView.OnItemClickListener {
            public final /* synthetic */ View a;
            public final /* synthetic */ Dialog b;
            public final /* synthetic */ C4143vg c;

            public C0013a(View view, Dialog dialog, C4143vg c4143vg) {
                this.a = view;
                this.b = dialog;
                this.c = c4143vg;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                String str;
                String str2;
                String str3;
                String str4;
                String string = C0870Qv.this.a.getString(R.string.pref_default_display_name);
                String strIa = C0870Qv.this.p.ia("prefSMS_header", string);
                String strIa2 = C0870Qv.this.p.ia("prefSMS_footer", string);
                String strIa3 = C0870Qv.this.p.ia("prefSMS_credit", string);
                String strIa4 = C0870Qv.this.p.ia("prefSMS_debit", string);
                if (strIa3.equals(string)) {
                    strIa3 = C0870Qv.this.a.getString(R.string.credit);
                }
                if (strIa4.equals(string)) {
                    strIa4 = C0870Qv.this.a.getString(R.string.debit);
                }
                if (i == 0) {
                    if (C2160f10.h > 0 && !new C2160f10(C0870Qv.this.p).l("-9", "new")) {
                        Context context = C0870Qv.this.a;
                        Toast.makeText(context, context.getString(R.string.no_priv), 0).show();
                        return;
                    }
                    Intent intent = new Intent(this.a.getContext(), (Class<?>) Customer_Det_List_edit.class);
                    intent.putExtra("CUS_NAME", a.this.b.b.getText().toString());
                    intent.putExtra("CUS_GSM", a.this.b.c.getText().toString());
                    intent.putExtra("CUS_ID", a.this.b.a.getText().toString());
                    intent.putExtra("G_NAME", a.this.b.h);
                    intent.putExtra("CURR_NAME", a.this.b.i);
                    Bill_edit.P2 = false;
                    C0870Qv.this.getContext().startActivity(intent);
                    this.b.dismiss();
                    return;
                }
                String str5 = "";
                if (i == 1) {
                    if (this.c.h() == null || this.c.h().length() < 4) {
                        Context context2 = C0870Qv.this.a;
                        Toast.makeText(context2, context2.getString(R.string.no_phone), 1).show();
                        this.b.dismiss();
                        return;
                    }
                    if (this.c.k() == R.drawable.up) {
                        Z00 z00 = C0870Qv.this.p;
                        String strH = this.c.h();
                        StringBuilder sb = new StringBuilder();
                        if (strIa.length() != 0) {
                            strIa3 = strIa + ":\n" + strIa3;
                        }
                        sb.append(strIa3);
                        sb.append(":");
                        sb.append(this.c.a());
                        if (Z00.Z) {
                            str4 = "\t" + this.c.b();
                        } else {
                            str4 = "";
                        }
                        sb.append(str4);
                        if (strIa2.length() != 0) {
                            str5 = StringUtilities.LF + strIa2;
                        }
                        sb.append(str5);
                        z00.Rc(strH, sb.toString());
                    } else if (this.c.k() == R.drawable.down) {
                        Z00 z01 = C0870Qv.this.p;
                        String strH2 = this.c.h();
                        StringBuilder sb2 = new StringBuilder();
                        if (strIa.length() != 0) {
                            strIa4 = strIa + ":\n" + strIa4;
                        }
                        sb2.append(strIa4);
                        sb2.append(":");
                        sb2.append(this.c.a());
                        if (Z00.Z) {
                            str3 = "\t" + this.c.b();
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
                if (i != 2) {
                    if (i == 3) {
                        if ((this.c.h() == null || this.c.h().length() < 4) && C0870Qv.this.p.ja("approval_wa", true)) {
                            Context context3 = C0870Qv.this.a;
                            Toast.makeText(context3, context3.getString(R.string.no_phone), 1).show();
                            this.b.dismiss();
                            return;
                        }
                        C0870Qv.this.p.ob(this.c.j(), C0870Qv.this.p.ic(this.c.j() + "-" + C0870Qv.this.a.getString(R.string.approval)), CSS.Value.PERCENTAGE);
                        if (C0870Qv.this.p.ja("approval_wa", true)) {
                            Z00 z02 = C0870Qv.this.p;
                            String strH3 = this.c.h();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(C0870Qv.this.p.ic(this.c.j() + "-" + C0870Qv.this.a.getString(R.string.approval)));
                            sb3.append(".pdf");
                            z02.Hd(strH3, sb3.toString());
                        } else {
                            Z00 z03 = C0870Qv.this.p;
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(C0870Qv.this.p.ic(this.c.j() + "-" + C0870Qv.this.a.getString(R.string.approval)));
                            sb4.append(".pdf");
                            z03.ra(sb4.toString());
                        }
                        this.b.dismiss();
                        return;
                    }
                    return;
                }
                if (this.c.h() == null || this.c.h().length() < 4) {
                    Context context4 = C0870Qv.this.a;
                    Toast.makeText(context4, context4.getString(R.string.no_phone), 1).show();
                    this.b.dismiss();
                    return;
                }
                if (this.c.k() == R.drawable.up) {
                    Z00 z04 = C0870Qv.this.p;
                    String strH4 = this.c.h();
                    StringBuilder sb5 = new StringBuilder();
                    if (strIa.length() != 0) {
                        strIa3 = strIa + ":\n" + strIa3;
                    }
                    sb5.append(strIa3);
                    sb5.append(":");
                    sb5.append(this.c.a());
                    if (Z00.Z) {
                        str2 = "\t" + this.c.b();
                    } else {
                        str2 = "";
                    }
                    sb5.append(str2);
                    if (strIa2.length() != 0) {
                        str5 = StringUtilities.LF + strIa2;
                    }
                    sb5.append(str5);
                    z04.Ed(strH4, sb5.toString());
                } else if (this.c.k() == R.drawable.down) {
                    Z00 z05 = C0870Qv.this.p;
                    String strH5 = this.c.h();
                    StringBuilder sb6 = new StringBuilder();
                    if (strIa.length() != 0) {
                        strIa4 = strIa + ":\n" + strIa4;
                    }
                    sb6.append(strIa4);
                    sb6.append(":");
                    sb6.append(this.c.a());
                    if (Z00.Z) {
                        str = "\t" + this.c.b();
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

        public a(int i, c cVar) {
            this.a = i;
            this.b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C4143vg c4143vg = (C4143vg) C0870Qv.this.d.get(this.a);
            Dialog dialog = new Dialog(C0870Qv.this.a);
            LinearLayout linearLayout = new LinearLayout(C0870Qv.this.a);
            String[] stringArray = C0870Qv.this.a.getResources().getStringArray(R.array.titles9);
            TypedArray typedArrayObtainTypedArray = C0870Qv.this.a.getResources().obtainTypedArray(R.array.icons9);
            C0870Qv c0870Qv = C0870Qv.this;
            C0870Qv c0870Qv2 = C0870Qv.this;
            c0870Qv.p = new Z00(c0870Qv2.n, c0870Qv2.a);
            if (!C0870Qv.this.p.ja("approval_wa", true) && stringArray.length > 3) {
                stringArray[3] = C0870Qv.this.a.getString(R.string.approval_title);
            }
            ListView listView = new ListView(C0870Qv.this.a);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < stringArray.length; i++) {
                if (i != 3 || C0870Qv.this.p.ja("approval_wa", true)) {
                    arrayList.add(new C3874sM(stringArray[i], typedArrayObtainTypedArray.getResourceId(i, -1)));
                } else {
                    arrayList.add(new C3874sM(stringArray[i], R.drawable.pdf));
                }
            }
            typedArrayObtainTypedArray.recycle();
            listView.setAdapter((ListAdapter) new C3900sg(C0870Qv.this.a, arrayList));
            C0870Qv.this.a.getString(R.string.credit);
            C0870Qv.this.a.getString(R.string.debit);
            listView.setOnItemClickListener(new C0013a(view, dialog, c4143vg));
            linearLayout.setFocusable(true);
            listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            listView.setDividerHeight(0);
            linearLayout.addView(listView, -1, -1);
            dialog.requestWindowFeature(1);
            dialog.setContentView(linearLayout);
            dialog.show();
        }
    }

    /* JADX INFO: renamed from: Qv$b */
    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            C0870Qv.this.g = charSequence.toString();
            if (charSequence.length() > 0) {
                ArrayList arrayList = new ArrayList();
                C0870Qv c0870Qv = C0870Qv.this;
                C0870Qv c0870Qv2 = C0870Qv.this;
                c0870Qv.p = new Z00(c0870Qv2.n, c0870Qv2.a);
                C0870Qv.this.p.M1(charSequence.toString().toUpperCase().trim());
                for (int i = 0; i < Z00.d0.size(); i++) {
                    if (((C4143vg) Z00.d0.get(i)).j().toUpperCase().trim().contains(charSequence.toString().toUpperCase().trim()) || ((((C4143vg) Z00.d0.get(i)).h() != null && ((C4143vg) Z00.d0.get(i)).h().toUpperCase().contains(charSequence.toString().toUpperCase())) || ((C4143vg) Z00.d0.get(i)).a().replaceAll(",", "").toUpperCase().contains(charSequence.toString().toUpperCase()) || (((C4143vg) Z00.d0.get(i)).l() != null && ((C4143vg) Z00.d0.get(i)).l().toUpperCase().contains(charSequence.toString().toUpperCase())))) {
                        arrayList.add(new C4143vg(((C4143vg) Z00.d0.get(i)).i(), ((C4143vg) Z00.d0.get(i)).j(), ((C4143vg) Z00.d0.get(i)).h(), Double.valueOf(((C4143vg) Z00.d0.get(i)).a().replaceAll(",", "").replaceAll("-0", "0")).doubleValue(), ((C4143vg) Z00.d0.get(i)).k(), ((C4143vg) Z00.d0.get(i)).e(), ((C4143vg) Z00.d0.get(i)).f(), ((C4143vg) Z00.d0.get(i)).b(), ((C4143vg) Z00.d0.get(i)).l(), ((C4143vg) Z00.d0.get(i)).c()));
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            } else {
                filterResults.count = C0870Qv.this.e.size();
                filterResults.values = C0870Qv.this.e;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            try {
                C0870Qv c0870Qv = C0870Qv.this;
                c0870Qv.d = (ArrayList) filterResults.values;
                c0870Qv.notifyDataSetChanged();
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ b(C0870Qv c0870Qv, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Qv$c */
    public static class c {
        public TextView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public ImageView e;
        public ImageView f;
        public TextView g;
        public String h;
        public String i;
        public int j;

        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public C0870Qv(Context context, int i, List list) {
        super(context, i, list);
        this.g = "";
        this.i = new ArrayList();
        this.l = new int[]{R.drawable.up, 1, R.drawable.down};
        this.h = new SparseBooleanArray();
        this.a = context;
        this.d = list;
        this.e = list;
        this.c = i;
        this.b = LayoutInflater.from(context);
        this.j = ((BitmapDrawable) context.getResources().getDrawable(this.l[0])).getBitmap();
        this.k = ((BitmapDrawable) context.getResources().getDrawable(this.l[2])).getBitmap();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C4143vg getItem(int i) {
        return (C4143vg) this.d.get(i);
    }

    public int b() {
        return this.h.size();
    }

    public SparseBooleanArray c() {
        return this.h;
    }

    @Override // android.widget.ArrayAdapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void remove(C4143vg c4143vg) {
        this.d.remove(c4143vg);
        notifyDataSetChanged();
    }

    public void e() {
        this.h = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void f(int i, boolean z) {
        if (z) {
            this.h.put(i, z);
        } else {
            this.h.delete(i);
        }
        notifyDataSetChanged();
    }

    public void g(int i) {
        if (this.i.contains(Integer.valueOf(i))) {
            this.i.remove(Integer.valueOf(i));
        } else {
            this.i.add(Integer.valueOf(i));
        }
        f(i, !this.h.get(i));
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        List list = this.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public Filter getFilter() {
        if (this.f == null) {
            this.f = new b(this, null);
        }
        return this.f;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        try {
            return this.d.indexOf(getItem(i));
        } catch (Exception unused) {
            return -1L;
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            int i2 = this.c;
            a aVar = null;
            if (i2 == R.layout.customer_row_edit2) {
                c cVar = new c(aVar);
                view = this.b.inflate(this.c, (ViewGroup) null);
                cVar.a = (TextView) view.findViewById(R.id.cus_id);
                cVar.b = (TextView) view.findViewById(R.id.customer_name);
                cVar.c = (TextView) view.findViewById(R.id.cus_phone);
                view.setTag(cVar);
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                cVar.a.setText(((C4143vg) this.d.get(i)).i());
                cVar.b.setText(((C4143vg) this.d.get(i)).j());
                cVar.c.setText(((C4143vg) this.d.get(i)).h());
            } else if (i2 == R.layout.list_backup) {
                c cVar2 = new c(aVar);
                view = this.b.inflate(this.c, (ViewGroup) null);
                cVar2.a = (TextView) view.findViewById(R.id.file_id);
                cVar2.b = (TextView) view.findViewById(R.id.title);
                cVar2.c = (TextView) view.findViewById(R.id.bk_date);
                cVar2.d = (TextView) view.findViewById(R.id.bk_size);
                view.setTag(cVar2);
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                cVar2.a.setText(((C4143vg) this.d.get(i)).i());
                cVar2.b.setText(((C4143vg) this.d.get(i)).j());
                cVar2.c.setText(((C4143vg) this.d.get(i)).h());
                cVar2.d.setText(((C4143vg) this.d.get(i)).f());
            } else if (i2 == R.layout.group_item) {
                c cVar3 = new c(aVar);
                view = this.b.inflate(this.c, (ViewGroup) null);
                cVar3.a = (TextView) view.findViewById(R.id.g_name);
                cVar3.b = (TextView) view.findViewById(R.id.g_cnt);
                view.setTag(cVar3);
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                cVar3.a.setText(((C4143vg) this.d.get(i)).j());
                cVar3.b.setText(((C4143vg) this.d.get(i)).h());
            } else if (i2 == R.layout.group_item_) {
                c cVar4 = new c(aVar);
                view = this.b.inflate(this.c, (ViewGroup) null);
                cVar4.a = (TextView) view.findViewById(R.id.g_name);
                cVar4.b = (TextView) view.findViewById(R.id.g_cnt);
                cVar4.c = (TextView) view.findViewById(R.id.fils_name);
                view.setTag(cVar4);
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                cVar4.a.setText(((C4143vg) this.d.get(i)).j());
                cVar4.c.setText(((C4143vg) this.d.get(i)).h());
                cVar4.b.setText(((C4143vg) this.d.get(i)).a());
            } else if (i2 == R.layout.customer_row) {
                c cVar5 = new c(aVar);
                view = this.b.inflate(this.c, (ViewGroup) null);
                cVar5.a = (TextView) view.findViewById(R.id.cus_id);
                cVar5.b = (TextView) view.findViewById(R.id.customer_name);
                cVar5.c = (TextView) view.findViewById(R.id.cus_phone);
                cVar5.d = (TextView) view.findViewById(R.id.balance);
                cVar5.f = (ImageView) view.findViewById(R.id.img);
                cVar5.h = "";
                cVar5.i = "";
                ImageView imageView = (ImageView) view.findViewById(R.id.img_add);
                cVar5.e = imageView;
                imageView.setOnClickListener(new a(i, cVar5));
                cVar5.g = (TextView) view.findViewById(R.id.count);
                view.setTag(cVar5);
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                cVar5.a.setText(((C4143vg) this.d.get(i)).i());
                cVar5.b.setText(((C4143vg) this.d.get(i)).j());
                cVar5.c.setText(((C4143vg) this.d.get(i)).h());
                cVar5.d.setText(((C4143vg) this.d.get(i)).a().equals("-0") ? "0" : ((C4143vg) this.d.get(i)).a());
                cVar5.j = i;
                C4192wG.n(this.a).i(((C4143vg) this.d.get(i)).k()).c(cVar5.f);
                cVar5.g.setText(((C4143vg) this.d.get(i)).l());
                cVar5.h = ((C4143vg) this.d.get(i)).f();
                cVar5.i = ((C4143vg) this.d.get(i)).b();
                cVar5.b.setTag(((C4143vg) this.d.get(i)).b());
                C4143vg c4143vg = (C4143vg) this.d.get(i);
                String lowerCase = c4143vg.j().toLowerCase(Locale.getDefault());
                if (lowerCase.contains(this.g)) {
                    int iIndexOf = lowerCase.indexOf(this.g);
                    int length = this.g.length() + iIndexOf;
                    Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(cVar5.b.getText());
                    spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
                    cVar5.b.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
                }
                String lowerCase2 = c4143vg.a().replaceAll(",", "").toLowerCase(Locale.getDefault());
                if (lowerCase2.contains(this.g)) {
                    int iIndexOf2 = lowerCase2.indexOf(this.g);
                    int length2 = this.g.length() + iIndexOf2;
                    String string = cVar5.d.getText().toString();
                    int length3 = string.length() - string.replaceAll(",", "").length();
                    if (this.g.length() > 0) {
                        Spannable spannableNewSpannable2 = Spannable.Factory.getInstance().newSpannable(string);
                        spannableNewSpannable2.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf2, length2 + length3, 33);
                        cVar5.d.setText(spannableNewSpannable2, TextView.BufferType.SPANNABLE);
                    }
                }
            }
            if (this.i.contains(Integer.valueOf(i))) {
                view.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
            } else {
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        } catch (Exception unused) {
        }
        return view;
    }
}
