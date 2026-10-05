package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: Vv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1004Vv extends ArrayAdapter implements Filterable {
    public Context a;
    public LayoutInflater b;
    public int c;
    public List d;
    public List e;
    public b f;
    public String g;
    public SparseBooleanArray h;
    public ArrayList i;

    /* JADX INFO: renamed from: Vv$b */
    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            C1004Vv.this.g = charSequence.toString();
            if (charSequence.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < C1004Vv.this.e.size(); i++) {
                    if (((C0795Oh) C1004Vv.this.e.get(i)).q().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C0795Oh) C1004Vv.this.e.get(i)).l().replaceAll(",", "").toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C0795Oh) C1004Vv.this.e.get(i)).c().replaceAll(",", "").toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C0795Oh) C1004Vv.this.e.get(i)).n().toUpperCase(Locale.ENGLISH).contains(charSequence.toString().toUpperCase()) || ((C0795Oh) C1004Vv.this.e.get(i)).p().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                        arrayList.add(new C0795Oh(((C0795Oh) C1004Vv.this.e.get(i)).o(), ((C0795Oh) C1004Vv.this.e.get(i)).n(), ((C0795Oh) C1004Vv.this.e.get(i)).l().replaceAll(",", ""), ((C0795Oh) C1004Vv.this.e.get(i)).q(), ((C0795Oh) C1004Vv.this.e.get(i)).r(), ((C0795Oh) C1004Vv.this.e.get(i)).p().replaceAll(",", ""), ((C0795Oh) C1004Vv.this.e.get(i)).a().replaceAll(",", ""), ((C0795Oh) C1004Vv.this.e.get(i)).b().replaceAll(",", ""), ((C0795Oh) C1004Vv.this.e.get(i)).m(), ((C0795Oh) C1004Vv.this.e.get(i)).j(), ((C0795Oh) C1004Vv.this.e.get(i)).k(), ((C0795Oh) C1004Vv.this.e.get(i)).c().replaceAll(",", "")));
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            } else {
                filterResults.count = C1004Vv.this.e.size();
                filterResults.values = C1004Vv.this.e;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            C1004Vv c1004Vv = C1004Vv.this;
            c1004Vv.d = (ArrayList) filterResults.values;
            c1004Vv.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: Vv$c */
    public static class c {
        public TextView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public ImageView f;
        public TextView g;

        public c() {
        }
    }

    public C1004Vv(Context context, int i, List list) {
        super(context, i, list);
        this.g = "";
        this.i = new ArrayList();
        this.h = new SparseBooleanArray();
        this.a = context;
        this.d = list;
        this.e = list;
        this.c = i;
        this.b = LayoutInflater.from(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0795Oh getItem(int i) {
        return (C0795Oh) this.d.get(i);
    }

    public SparseBooleanArray b() {
        return this.h;
    }

    @Override // android.widget.ArrayAdapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void remove(C0795Oh c0795Oh) {
        this.d.remove(c0795Oh);
        notifyDataSetChanged();
    }

    public void d() {
        this.h = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void e(int i, boolean z) {
        if (z) {
            this.h.put(i, z);
        } else {
            this.h.delete(i);
        }
        notifyDataSetChanged();
    }

    public void f(int i) {
        if (this.i.contains(Integer.valueOf(i))) {
            this.i.remove(Integer.valueOf(i));
        } else {
            this.i.add(Integer.valueOf(i));
        }
        e(i, !this.h.get(i));
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.d.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public Filter getFilter() {
        if (this.f == null) {
            this.f = new b();
        }
        return this.f;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return this.d.indexOf(getItem(i));
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        c cVar;
        if (view == null) {
            cVar = new c();
            viewInflate = this.b.inflate(this.c, (ViewGroup) null);
            cVar.a = (TextView) viewInflate.findViewById(R.id.tr_id);
            cVar.b = (TextView) viewInflate.findViewById(R.id.tr_date);
            cVar.c = (TextView) viewInflate.findViewById(R.id.tr_amount);
            cVar.d = (TextView) viewInflate.findViewById(R.id.tr_amount2);
            cVar.e = (TextView) viewInflate.findViewById(R.id.tr_remarks);
            cVar.g = (TextView) viewInflate.findViewById(R.id.tr_name);
            cVar.f = (ImageView) viewInflate.findViewById(R.id.img);
            viewInflate.setTag(cVar);
            viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else {
            viewInflate = view;
            cVar = (c) view.getTag();
        }
        cVar.a.setText(((C0795Oh) this.d.get(i)).o());
        cVar.b.setText(((C0795Oh) this.d.get(i)).n());
        cVar.c.setText(((C0795Oh) this.d.get(i)).l());
        cVar.d.setText(((C0795Oh) this.d.get(i)).c());
        cVar.e.setText(((C0795Oh) this.d.get(i)).q());
        cVar.g.setText(((C0795Oh) this.d.get(i)).p());
        cVar.e.setTag(((C0795Oh) this.d.get(i)).m());
        cVar.c.setTag(((C0795Oh) this.d.get(i)).b());
        cVar.b.setTag(((C0795Oh) this.d.get(i)).a());
        C0795Oh c0795Oh = (C0795Oh) this.d.get(i);
        String lowerCase = c0795Oh.q().toLowerCase(Locale.getDefault());
        String str = this.g;
        if (str != null && !str.isEmpty()) {
            if (lowerCase.contains(this.g)) {
                int iIndexOf = lowerCase.indexOf(this.g);
                int length = this.g.length() + iIndexOf;
                Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(cVar.e.getText());
                spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
                cVar.e.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
            }
            String lowerCase2 = c0795Oh.p().toLowerCase(Locale.getDefault());
            if (lowerCase2.contains(this.g)) {
                int iIndexOf2 = lowerCase2.indexOf(this.g);
                int length2 = this.g.length() + iIndexOf2;
                Spannable spannableNewSpannable2 = Spannable.Factory.getInstance().newSpannable(cVar.g.getText());
                spannableNewSpannable2.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf2, length2, 33);
                cVar.g.setText(spannableNewSpannable2, TextView.BufferType.SPANNABLE);
            }
            String lowerCase3 = c0795Oh.n().toLowerCase(Locale.getDefault());
            if (lowerCase3.contains(this.g)) {
                int iIndexOf3 = lowerCase3.indexOf(this.g);
                int length3 = this.g.length() + iIndexOf3;
                Spannable spannableNewSpannable3 = Spannable.Factory.getInstance().newSpannable(cVar.b.getText());
                spannableNewSpannable3.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf3, length3, 33);
                cVar.b.setText(spannableNewSpannable3, TextView.BufferType.SPANNABLE);
            }
            String lowerCase4 = c0795Oh.l().replaceAll(",", "").toLowerCase(Locale.getDefault());
            if (lowerCase4.contains(this.g)) {
                int iIndexOf4 = lowerCase4.indexOf(this.g);
                int length4 = this.g.length() + iIndexOf4;
                String string = cVar.c.getText().toString();
                int length5 = string.length() - string.replaceAll(",", "").length();
                if (this.g.length() > 0) {
                    Spannable spannableNewSpannable4 = Spannable.Factory.getInstance().newSpannable(string);
                    spannableNewSpannable4.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf4, length4 + length5, 33);
                    cVar.c.setText(spannableNewSpannable4, TextView.BufferType.SPANNABLE);
                }
            }
            String lowerCase5 = c0795Oh.c().replaceAll(",", "").toLowerCase(Locale.getDefault());
            if (lowerCase5.contains(this.g)) {
                int iIndexOf5 = lowerCase5.indexOf(this.g);
                int length6 = this.g.length() + iIndexOf5;
                String string2 = cVar.d.getText().toString();
                int length7 = string2.length() - string2.replaceAll(",", "").length();
                if (this.g.length() > 0) {
                    Spannable spannableNewSpannable5 = Spannable.Factory.getInstance().newSpannable(string2);
                    spannableNewSpannable5.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf5, length6 + length7, 33);
                    cVar.d.setText(spannableNewSpannable5, TextView.BufferType.SPANNABLE);
                }
            }
        }
        if (this.i.contains(Integer.valueOf(i))) {
            viewInflate.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
        } else {
            viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        return viewInflate;
    }
}
