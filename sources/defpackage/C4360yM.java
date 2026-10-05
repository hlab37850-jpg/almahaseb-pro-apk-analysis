package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.RecyclerView;
import info.aalmoghalis.inventory.R;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: yM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4360yM extends PagingDataAdapter implements Filterable {
    public static int y;
    public Context a;
    public LayoutInflater b;
    public int c;
    public List d;
    public List e;
    public c f;
    public String g;
    public int[] h;
    public int i;
    public SparseBooleanArray j;
    public ArrayList k;
    public C4279xM.c l;
    public DE n;
    public String p;
    public int q;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public C0615Ja x;

    /* JADX INFO: renamed from: yM$a */
    public class a implements View.OnLongClickListener {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (C4360yM.this.l == null) {
                return true;
            }
            C4360yM.this.l.a(this.a.getAdapterPosition());
            return true;
        }
    }

    /* JADX INFO: renamed from: yM$b */
    public class b implements View.OnClickListener {
        public final /* synthetic */ C4145vh a;
        public final /* synthetic */ d b;

        public b(C4145vh c4145vh, d dVar) {
            this.a = c4145vh;
            this.b = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C4360yM.this.n != null && C4360yM.this.d() == 0) {
                C4360yM.this.n.e(1, this.a);
            } else {
                if (C4360yM.this.d() == 0 || C4360yM.this.l == null) {
                    return;
                }
                C4360yM.this.l.a(this.b.getAdapterPosition());
            }
        }
    }

    /* JADX INFO: renamed from: yM$c */
    public class c extends Filter {
        public c() {
        }

        /* JADX WARN: Code duplicated, block: B:56:0x01e6  */
        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            C4360yM.this.g = charSequence.toString();
            if (charSequence.length() <= 0) {
                filterResults.count = C4360yM.this.e.size();
                filterResults.values = C4360yM.this.e;
                return filterResults;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < C4360yM.this.e.size()) {
                if (((C4145vh) C4360yM.this.e.get(i)).a().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C4145vh) C4360yM.this.e.get(i)).n().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                    arrayList.add(new C4145vh(((C4145vh) C4360yM.this.e.get(i)).v(), ((C4145vh) C4360yM.this.e.get(i)).a(), ((C4145vh) C4360yM.this.e.get(i)).n(), ((C4145vh) C4360yM.this.e.get(i)).o(), ((C4145vh) C4360yM.this.e.get(i)).p(), ((C4145vh) C4360yM.this.e.get(i)).q(), ((C4145vh) C4360yM.this.e.get(i)).r(), ((C4145vh) C4360yM.this.e.get(i)).s(), ((C4145vh) C4360yM.this.e.get(i)).t(), ((C4145vh) C4360yM.this.e.get(i)).u(), ((C4145vh) C4360yM.this.e.get(i)).b(), ((C4145vh) C4360yM.this.e.get(i)).c(), ((C4145vh) C4360yM.this.e.get(i)).e(), ((C4145vh) C4360yM.this.e.get(i)).f(), ((C4145vh) C4360yM.this.e.get(i)).h(), ((C4145vh) C4360yM.this.e.get(i)).i(), ((C4145vh) C4360yM.this.e.get(i)).j(), ((C4145vh) C4360yM.this.e.get(i)).k(), ((C4145vh) C4360yM.this.e.get(i)).l(), ((C4145vh) C4360yM.this.e.get(i)).m()));
                } else {
                    String upperCase = "";
                    if ((((C4145vh) C4360yM.this.e.get(i)).o() != null ? ((C4145vh) C4360yM.this.e.get(i)).o().toUpperCase() : "").contains(charSequence.toString().toUpperCase())) {
                        arrayList.add(new C4145vh(((C4145vh) C4360yM.this.e.get(i)).v(), ((C4145vh) C4360yM.this.e.get(i)).a(), ((C4145vh) C4360yM.this.e.get(i)).n(), ((C4145vh) C4360yM.this.e.get(i)).o(), ((C4145vh) C4360yM.this.e.get(i)).p(), ((C4145vh) C4360yM.this.e.get(i)).q(), ((C4145vh) C4360yM.this.e.get(i)).r(), ((C4145vh) C4360yM.this.e.get(i)).s(), ((C4145vh) C4360yM.this.e.get(i)).t(), ((C4145vh) C4360yM.this.e.get(i)).u(), ((C4145vh) C4360yM.this.e.get(i)).b(), ((C4145vh) C4360yM.this.e.get(i)).c(), ((C4145vh) C4360yM.this.e.get(i)).e(), ((C4145vh) C4360yM.this.e.get(i)).f(), ((C4145vh) C4360yM.this.e.get(i)).h(), ((C4145vh) C4360yM.this.e.get(i)).i(), ((C4145vh) C4360yM.this.e.get(i)).j(), ((C4145vh) C4360yM.this.e.get(i)).k(), ((C4145vh) C4360yM.this.e.get(i)).l(), ((C4145vh) C4360yM.this.e.get(i)).m()));
                    } else {
                        if ((((C4145vh) C4360yM.this.e.get(i)).p() != null ? ((C4145vh) C4360yM.this.e.get(i)).p().toUpperCase() : "").contains(charSequence.toString().toUpperCase())) {
                            arrayList.add(new C4145vh(((C4145vh) C4360yM.this.e.get(i)).v(), ((C4145vh) C4360yM.this.e.get(i)).a(), ((C4145vh) C4360yM.this.e.get(i)).n(), ((C4145vh) C4360yM.this.e.get(i)).o(), ((C4145vh) C4360yM.this.e.get(i)).p(), ((C4145vh) C4360yM.this.e.get(i)).q(), ((C4145vh) C4360yM.this.e.get(i)).r(), ((C4145vh) C4360yM.this.e.get(i)).s(), ((C4145vh) C4360yM.this.e.get(i)).t(), ((C4145vh) C4360yM.this.e.get(i)).u(), ((C4145vh) C4360yM.this.e.get(i)).b(), ((C4145vh) C4360yM.this.e.get(i)).c(), ((C4145vh) C4360yM.this.e.get(i)).e(), ((C4145vh) C4360yM.this.e.get(i)).f(), ((C4145vh) C4360yM.this.e.get(i)).h(), ((C4145vh) C4360yM.this.e.get(i)).i(), ((C4145vh) C4360yM.this.e.get(i)).j(), ((C4145vh) C4360yM.this.e.get(i)).k(), ((C4145vh) C4360yM.this.e.get(i)).l(), ((C4145vh) C4360yM.this.e.get(i)).m()));
                        } else {
                            if (((((C4145vh) C4360yM.this.e.get(i)).q() == null || ((C4145vh) C4360yM.this.e.get(i)).q().length() <= 0) ? "" : ((C4145vh) C4360yM.this.e.get(i)).q().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                                arrayList.add(new C4145vh(((C4145vh) C4360yM.this.e.get(i)).v(), ((C4145vh) C4360yM.this.e.get(i)).a(), ((C4145vh) C4360yM.this.e.get(i)).n(), ((C4145vh) C4360yM.this.e.get(i)).o(), ((C4145vh) C4360yM.this.e.get(i)).p(), ((C4145vh) C4360yM.this.e.get(i)).q(), ((C4145vh) C4360yM.this.e.get(i)).r(), ((C4145vh) C4360yM.this.e.get(i)).s(), ((C4145vh) C4360yM.this.e.get(i)).t(), ((C4145vh) C4360yM.this.e.get(i)).u(), ((C4145vh) C4360yM.this.e.get(i)).b(), ((C4145vh) C4360yM.this.e.get(i)).c(), ((C4145vh) C4360yM.this.e.get(i)).e(), ((C4145vh) C4360yM.this.e.get(i)).f(), ((C4145vh) C4360yM.this.e.get(i)).h(), ((C4145vh) C4360yM.this.e.get(i)).i(), ((C4145vh) C4360yM.this.e.get(i)).j(), ((C4145vh) C4360yM.this.e.get(i)).k(), ((C4145vh) C4360yM.this.e.get(i)).l(), ((C4145vh) C4360yM.this.e.get(i)).m()));
                            } else {
                                if (((((C4145vh) C4360yM.this.e.get(i)).r() == null || ((C4145vh) C4360yM.this.e.get(i)).r().length() <= 0) ? "" : ((C4145vh) C4360yM.this.e.get(i)).r().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                                    arrayList.add(new C4145vh(((C4145vh) C4360yM.this.e.get(i)).v(), ((C4145vh) C4360yM.this.e.get(i)).a(), ((C4145vh) C4360yM.this.e.get(i)).n(), ((C4145vh) C4360yM.this.e.get(i)).o(), ((C4145vh) C4360yM.this.e.get(i)).p(), ((C4145vh) C4360yM.this.e.get(i)).q(), ((C4145vh) C4360yM.this.e.get(i)).r(), ((C4145vh) C4360yM.this.e.get(i)).s(), ((C4145vh) C4360yM.this.e.get(i)).t(), ((C4145vh) C4360yM.this.e.get(i)).u(), ((C4145vh) C4360yM.this.e.get(i)).b(), ((C4145vh) C4360yM.this.e.get(i)).c(), ((C4145vh) C4360yM.this.e.get(i)).e(), ((C4145vh) C4360yM.this.e.get(i)).f(), ((C4145vh) C4360yM.this.e.get(i)).h(), ((C4145vh) C4360yM.this.e.get(i)).i(), ((C4145vh) C4360yM.this.e.get(i)).j(), ((C4145vh) C4360yM.this.e.get(i)).k(), ((C4145vh) C4360yM.this.e.get(i)).l(), ((C4145vh) C4360yM.this.e.get(i)).m()));
                                } else {
                                    if (((((C4145vh) C4360yM.this.e.get(i)).e() == null || ((C4145vh) C4360yM.this.e.get(i)).e().length() <= 0) ? "" : ((C4145vh) C4360yM.this.e.get(i)).e().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                                        arrayList.add(new C4145vh(((C4145vh) C4360yM.this.e.get(i)).v(), ((C4145vh) C4360yM.this.e.get(i)).a(), ((C4145vh) C4360yM.this.e.get(i)).n(), ((C4145vh) C4360yM.this.e.get(i)).o(), ((C4145vh) C4360yM.this.e.get(i)).p(), ((C4145vh) C4360yM.this.e.get(i)).q(), ((C4145vh) C4360yM.this.e.get(i)).r(), ((C4145vh) C4360yM.this.e.get(i)).s(), ((C4145vh) C4360yM.this.e.get(i)).t(), ((C4145vh) C4360yM.this.e.get(i)).u(), ((C4145vh) C4360yM.this.e.get(i)).b(), ((C4145vh) C4360yM.this.e.get(i)).c(), ((C4145vh) C4360yM.this.e.get(i)).e(), ((C4145vh) C4360yM.this.e.get(i)).f(), ((C4145vh) C4360yM.this.e.get(i)).h(), ((C4145vh) C4360yM.this.e.get(i)).i(), ((C4145vh) C4360yM.this.e.get(i)).j(), ((C4145vh) C4360yM.this.e.get(i)).k(), ((C4145vh) C4360yM.this.e.get(i)).l(), ((C4145vh) C4360yM.this.e.get(i)).m()));
                                    } else {
                                        if (((C4145vh) C4360yM.this.e.get(i)).f() != null && ((C4145vh) C4360yM.this.e.get(i)).f().length() > 0) {
                                            upperCase = ((C4145vh) C4360yM.this.e.get(i)).f().toUpperCase();
                                        }
                                        if (upperCase.contains(charSequence.toString().toUpperCase())) {
                                            arrayList.add(new C4145vh(((C4145vh) C4360yM.this.e.get(i)).v(), ((C4145vh) C4360yM.this.e.get(i)).a(), ((C4145vh) C4360yM.this.e.get(i)).n(), ((C4145vh) C4360yM.this.e.get(i)).o(), ((C4145vh) C4360yM.this.e.get(i)).p(), ((C4145vh) C4360yM.this.e.get(i)).q(), ((C4145vh) C4360yM.this.e.get(i)).r(), ((C4145vh) C4360yM.this.e.get(i)).s(), ((C4145vh) C4360yM.this.e.get(i)).t(), ((C4145vh) C4360yM.this.e.get(i)).u(), ((C4145vh) C4360yM.this.e.get(i)).b(), ((C4145vh) C4360yM.this.e.get(i)).c(), ((C4145vh) C4360yM.this.e.get(i)).e(), ((C4145vh) C4360yM.this.e.get(i)).f(), ((C4145vh) C4360yM.this.e.get(i)).h(), ((C4145vh) C4360yM.this.e.get(i)).i(), ((C4145vh) C4360yM.this.e.get(i)).j(), ((C4145vh) C4360yM.this.e.get(i)).k(), ((C4145vh) C4360yM.this.e.get(i)).l(), ((C4145vh) C4360yM.this.e.get(i)).m()));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i++;
                filterResults = filterResults;
            }
            Filter.FilterResults filterResults2 = filterResults;
            filterResults2.count = arrayList.size();
            filterResults2.values = arrayList;
            return filterResults2;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            C4360yM c4360yM = C4360yM.this;
            c4360yM.d = (ArrayList) filterResults.values;
            c4360yM.notifyDataSetChanged();
        }

        public /* synthetic */ c(C4360yM c4360yM, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: yM$d */
    public static class d extends RecyclerView.ViewHolder {
        public C0615Ja a;

        public d(C0615Ja c0615Ja) {
            super(c0615Ja.getRoot());
            this.a = c0615Ja;
        }
    }

    public C4360yM(Context context, int i, List list, int i2, boolean z, int i3, DE de, C4279xM.c cVar) {
        super(new C4307xh());
        this.g = "";
        this.h = new int[]{R.drawable.up, 1, R.drawable.down};
        this.i = android.R.drawable.ic_menu_close_clear_cancel;
        this.k = new ArrayList();
        this.p = "";
        this.q = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.j = new SparseBooleanArray();
        this.a = context;
        this.d = list;
        this.e = list;
        this.c = i;
        y = i2;
        this.t = z;
        this.w = i3;
        this.b = LayoutInflater.from(context);
        this.l = cVar;
        this.n = de;
    }

    public List c() {
        return snapshot().getItems();
    }

    public int d() {
        return this.j.size();
    }

    public SparseBooleanArray e() {
        return this.j;
    }

    public String f(String str) {
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(str));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(d dVar, int i) {
        String lowerCase;
        String lowerCase2;
        String strReplace;
        String lowerCase3;
        String lowerCase4;
        String lowerCase5;
        String string;
        int adapterPosition = dVar.getAdapterPosition();
        C4145vh c4145vh = (C4145vh) getItem(i);
        dVar.a.l.setText(c4145vh.v());
        dVar.a.d.setText(c4145vh.a());
        dVar.a.e.setText(c4145vh.n());
        dVar.a.f.setText(c4145vh.o());
        dVar.a.g.setText(c4145vh.p());
        dVar.a.h.setText(c4145vh.q());
        dVar.a.i.setText(c4145vh.r());
        dVar.a.j.setText(c4145vh.s());
        dVar.a.k.setText(c4145vh.t());
        String lowerCase6 = "";
        if (y == 20) {
            TextView textView = dVar.a.f;
            StringBuilder sb = new StringBuilder();
            sb.append(f(Math.abs(Double.parseDouble(c4145vh.o())) + ""));
            sb.append(" ");
            sb.append(c4145vh.b());
            textView.setText(sb.toString());
            if (c4145vh.e() != null && !c4145vh.e().equals("0")) {
                dVar.a.d.setTextColor(-16776961);
                dVar.a.d.setTypeface(Typeface.SANS_SERIF, 3);
            }
        }
        if (y == 4 && c4145vh.e() != null && !c4145vh.e().equals("0")) {
            dVar.a.d.setTextColor(-16776961);
            dVar.a.d.setTypeface(Typeface.SANS_SERIF, 3);
        }
        dVar.a.t.setVisibility(8);
        if (c4145vh.i.length() > 0) {
            dVar.a.t.setText(c4145vh.i);
            dVar.a.t.setVisibility(0);
        }
        dVar.a.b.setVisibility(8);
        if (c4145vh.j.length() > 0) {
            dVar.a.b.setText(c4145vh.j);
            dVar.a.b.setVisibility(0);
        }
        try {
            lowerCase = c4145vh.a().toLowerCase(Locale.getDefault());
        } catch (Exception unused) {
            lowerCase = "";
        }
        String str = this.g;
        if (str != null && !str.isEmpty() && lowerCase.contains(this.g)) {
            int iIndexOf = lowerCase.indexOf(this.g);
            int length = this.g.length() + iIndexOf;
            Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(dVar.a.d.getText());
            spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
            dVar.a.d.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
        }
        try {
            lowerCase2 = c4145vh.n().toLowerCase(Locale.getDefault());
        } catch (Exception unused2) {
            lowerCase2 = "";
        }
        String str2 = this.g;
        if (str2 != null && !str2.isEmpty() && lowerCase2.contains(this.g)) {
            int iIndexOf2 = lowerCase2.indexOf(this.g);
            int length2 = this.g.length() + iIndexOf2;
            Spannable spannableNewSpannable2 = Spannable.Factory.getInstance().newSpannable(dVar.a.e.getText());
            spannableNewSpannable2.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf2, length2, 33);
            dVar.a.e.setText(spannableNewSpannable2, TextView.BufferType.SPANNABLE);
        }
        try {
            strReplace = (c4145vh.o().length() > 0 ? c4145vh.o().toLowerCase(Locale.getDefault()) : "").replace(",", "");
        } catch (Exception e) {
            e.printStackTrace();
            strReplace = "";
        }
        String str3 = this.g;
        if (str3 != null && !str3.isEmpty() && strReplace.contains(this.g)) {
            int iIndexOf3 = strReplace.indexOf(this.g);
            int length3 = this.g.length() + iIndexOf3;
            String string2 = dVar.a.f.getText().toString();
            int length4 = string2.length() - string2.replaceAll(",", "").length();
            Spannable spannableNewSpannable3 = Spannable.Factory.getInstance().newSpannable(dVar.a.f.getText());
            spannableNewSpannable3.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf3, length3 + length4, 33);
            dVar.a.f.setText(spannableNewSpannable3, TextView.BufferType.SPANNABLE);
        }
        try {
            lowerCase3 = c4145vh.p().length() > 0 ? c4145vh.p().toLowerCase(Locale.getDefault()) : "";
        } catch (Exception unused3) {
        }
        String str4 = this.g;
        if (str4 != null && !str4.isEmpty() && lowerCase3.contains(this.g)) {
            int iIndexOf4 = lowerCase3.indexOf(this.g);
            int length5 = this.g.length() + iIndexOf4;
            Spannable spannableNewSpannable4 = Spannable.Factory.getInstance().newSpannable(dVar.a.g.getText());
            spannableNewSpannable4.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf4, length5, 33);
            dVar.a.g.setText(spannableNewSpannable4, TextView.BufferType.SPANNABLE);
        }
        if (y == 20) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f(Math.abs(Double.parseDouble(c4145vh.o())) + ""));
                sb2.append(" ");
                sb2.append(c4145vh.b().length() > 0 ? c4145vh.b().toLowerCase(Locale.getDefault()) : "");
                string = sb2.toString();
            } catch (Exception unused4) {
                string = "";
            }
            String str5 = this.g;
            if (str5 != null && !str5.isEmpty() && string.contains(this.g)) {
                int iIndexOf5 = string.indexOf(this.g);
                int length6 = this.g.length() + iIndexOf5;
                Spannable spannableNewSpannable5 = Spannable.Factory.getInstance().newSpannable(dVar.a.f.getText());
                spannableNewSpannable5.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf5, length6, 33);
                dVar.a.f.setText(spannableNewSpannable5, TextView.BufferType.SPANNABLE);
            }
        }
        try {
            lowerCase4 = c4145vh.q().toLowerCase(Locale.getDefault());
        } catch (Exception unused5) {
            lowerCase4 = "";
        }
        String str6 = this.g;
        if (str6 != null && !str6.isEmpty() && lowerCase4.contains(this.g)) {
            int iIndexOf6 = lowerCase4.indexOf(this.g);
            int length7 = this.g.length() + iIndexOf6;
            Spannable spannableNewSpannable6 = Spannable.Factory.getInstance().newSpannable(dVar.a.h.getText());
            spannableNewSpannable6.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf6, length7, 33);
            dVar.a.h.setText(spannableNewSpannable6, TextView.BufferType.SPANNABLE);
        }
        try {
            lowerCase5 = c4145vh.i.length() > 0 ? c4145vh.i.toLowerCase(Locale.getDefault()) : "";
        } catch (Exception unused6) {
        }
        String str7 = this.g;
        if (str7 != null && !str7.isEmpty() && lowerCase5.contains(this.g)) {
            int iIndexOf7 = lowerCase5.indexOf(this.g);
            int length8 = this.g.length() + iIndexOf7;
            Spannable spannableNewSpannable7 = Spannable.Factory.getInstance().newSpannable(dVar.a.t.getText());
            spannableNewSpannable7.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf7, length8, 33);
            dVar.a.t.setText(spannableNewSpannable7, TextView.BufferType.SPANNABLE);
        }
        try {
            if (c4145vh.j.length() > 0) {
                lowerCase6 = c4145vh.j.toLowerCase(Locale.getDefault());
            }
        } catch (Exception unused7) {
        }
        String str8 = this.g;
        if (str8 != null && !str8.isEmpty() && lowerCase6.contains(this.g)) {
            int iIndexOf8 = lowerCase6.indexOf(this.g);
            int length9 = this.g.length() + iIndexOf8;
            Spannable spannableNewSpannable8 = Spannable.Factory.getInstance().newSpannable(dVar.a.b.getText());
            spannableNewSpannable8.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf8, length9, 33);
            dVar.a.b.setText(spannableNewSpannable8, TextView.BufferType.SPANNABLE);
        }
        if (this.k.contains(Integer.valueOf(adapterPosition))) {
            dVar.a.p.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
        } else {
            dVar.a.p.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        dVar.itemView.setOnLongClickListener(new a(dVar));
        dVar.itemView.setOnClickListener(new b(c4145vh, dVar));
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f == null) {
            this.f = new c(this, null);
        }
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.x = C0615Ja.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new d(this.x);
    }

    public void i() {
        this.j = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void j(int i, boolean z) {
        if (z) {
            this.j.put(i, z);
        } else {
            this.j.delete(i);
        }
        notifyDataSetChanged();
    }

    public void k(int i) {
        if (this.k.contains(Integer.valueOf(i))) {
            this.k.remove(Integer.valueOf(i));
        } else {
            this.k.add(Integer.valueOf(i));
        }
        j(i, !this.j.get(i));
    }
}
