package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
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

/* JADX INFO: renamed from: Pv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0835Pv extends ArrayAdapter implements Filterable {
    public Context a;
    public LayoutInflater b;
    public int c;
    public List d;
    public List e;
    public b f;
    public String g;
    public SparseBooleanArray h;
    public ArrayList i;
    public int[] j;
    public Bitmap k;
    public Bitmap l;

    /* JADX INFO: renamed from: Pv$b */
    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            C0835Pv.this.g = charSequence.toString();
            String lowerCase = charSequence.toString().toLowerCase();
            if (lowerCase == null || lowerCase.length() <= 0) {
                filterResults.count = C0835Pv.this.e.size();
                filterResults.values = C0835Pv.this.e;
            } else {
                ArrayList arrayList = new ArrayList();
                Log.d("filter=", "start..:" + C0835Pv.this.g);
                for (int i = 0; i < C0835Pv.this.e.size(); i++) {
                    C0795Oh c0795Oh = (C0795Oh) C0835Pv.this.e.get(i);
                    if (c0795Oh.q().toLowerCase().contains(lowerCase) || c0795Oh.l().replace(",", "").contains(lowerCase) || c0795Oh.n().contains(lowerCase) || c0795Oh.p().toLowerCase().contains(lowerCase)) {
                        arrayList.add(c0795Oh);
                    }
                }
                Log.d("filter=", "end..:" + C0835Pv.this.g + ":" + arrayList.size());
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            C0835Pv c0835Pv = C0835Pv.this;
            c0835Pv.d = (ArrayList) filterResults.values;
            c0835Pv.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: Pv$c */
    public static class c {
        public TextView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public ImageView e;
        public TextView f;

        public c() {
        }
    }

    public C0835Pv(Context context, int i, List list) {
        super(context, i, list);
        this.g = "";
        this.i = new ArrayList();
        this.j = new int[]{R.drawable.up, 1, R.drawable.down};
        this.h = new SparseBooleanArray();
        this.a = context;
        this.d = list;
        this.e = list;
        this.c = i;
        this.b = LayoutInflater.from(context);
        this.k = ((BitmapDrawable) context.getResources().getDrawable(this.j[0])).getBitmap();
        this.l = ((BitmapDrawable) context.getResources().getDrawable(this.j[2])).getBitmap();
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
        c cVar = new c();
        View viewInflate = this.b.inflate(this.c, (ViewGroup) null);
        cVar.a = (TextView) viewInflate.findViewById(R.id.tr_id);
        cVar.b = (TextView) viewInflate.findViewById(R.id.tr_date);
        cVar.c = (TextView) viewInflate.findViewById(R.id.tr_amount);
        cVar.d = (TextView) viewInflate.findViewById(R.id.tr_remarks);
        cVar.f = (TextView) viewInflate.findViewById(R.id.tr_name);
        cVar.e = (ImageView) viewInflate.findViewById(R.id.img);
        viewInflate.setTag(cVar);
        cVar.a.setText(((C0795Oh) this.d.get(i)).o());
        cVar.b.setText(((C0795Oh) this.d.get(i)).n());
        cVar.c.setText(((C0795Oh) this.d.get(i)).l());
        cVar.d.setText(((C0795Oh) this.d.get(i)).q());
        cVar.f.setText(((C0795Oh) this.d.get(i)).p());
        C4192wG.n(this.a).i(((C0795Oh) this.d.get(i)).r()).c(cVar.e);
        cVar.e.setTag(Integer.valueOf(((C0795Oh) this.d.get(i)).r()));
        cVar.d.setTag(((C0795Oh) this.d.get(i)).m());
        cVar.c.setTag(((C0795Oh) this.d.get(i)).b());
        cVar.b.setTag(((C0795Oh) this.d.get(i)).a());
        C0795Oh c0795Oh = (C0795Oh) this.d.get(i);
        String lowerCase = c0795Oh.q() == null ? "" : c0795Oh.q().toLowerCase(Locale.getDefault());
        String str = this.g;
        if (str != null && !str.isEmpty()) {
            if (lowerCase.contains(this.g)) {
                int iIndexOf = lowerCase.indexOf(this.g);
                int length = this.g.length() + iIndexOf;
                Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(cVar.d.getText());
                spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
                cVar.d.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
            }
            String lowerCase2 = c0795Oh.p().toLowerCase(Locale.getDefault());
            if (lowerCase2.contains(this.g)) {
                int iIndexOf2 = lowerCase2.indexOf(this.g);
                int length2 = this.g.length() + iIndexOf2;
                Spannable spannableNewSpannable2 = Spannable.Factory.getInstance().newSpannable(cVar.f.getText());
                spannableNewSpannable2.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf2, length2, 33);
                cVar.f.setText(spannableNewSpannable2, TextView.BufferType.SPANNABLE);
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
        }
        if (this.i.contains(Integer.valueOf(i))) {
            viewInflate.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
        } else {
            viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        return viewInflate;
    }
}
