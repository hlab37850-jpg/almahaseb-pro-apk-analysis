package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.preference.PreferenceManager;
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

/* JADX INFO: renamed from: Nv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0783Nv extends ArrayAdapter implements Filterable {
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
    public boolean n;

    /* JADX INFO: renamed from: Nv$b */
    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            C0783Nv.this.g = charSequence.toString();
            if (charSequence.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < C0783Nv.this.e.size(); i++) {
                    if (((C4064uh) C0783Nv.this.e.get(i)).r().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C4064uh) C0783Nv.this.e.get(i)).n().replaceAll(",", "").toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C4064uh) C0783Nv.this.e.get(i)).p().toUpperCase(Locale.ENGLISH).contains(charSequence.toString().toUpperCase())) {
                        arrayList.add(new C4064uh(((C4064uh) C0783Nv.this.e.get(i)).q(), ((C4064uh) C0783Nv.this.e.get(i)).p(), ((C4064uh) C0783Nv.this.e.get(i)).n().replaceAll(",", ""), ((C4064uh) C0783Nv.this.e.get(i)).r(), ((C4064uh) C0783Nv.this.e.get(i)).t(), ((C4064uh) C0783Nv.this.e.get(i)).f().replaceAll(",", ""), "", "" + ((C4064uh) C0783Nv.this.e.get(i)).b(), ((C4064uh) C0783Nv.this.e.get(i)).a(), ((C4064uh) C0783Nv.this.e.get(i)).h(), ((C4064uh) C0783Nv.this.e.get(i)).k(), ((C4064uh) C0783Nv.this.e.get(i)).i(), ((C4064uh) C0783Nv.this.e.get(i)).e(), ((C4064uh) C0783Nv.this.e.get(i)).j(), ((C4064uh) C0783Nv.this.e.get(i)).s()));
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            } else {
                filterResults.count = C0783Nv.this.e.size();
                filterResults.values = C0783Nv.this.e;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            try {
                C0783Nv c0783Nv = C0783Nv.this;
                c0783Nv.d = (ArrayList) filterResults.values;
                c0783Nv.notifyDataSetChanged();
                C0783Nv.this.getClass();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: Nv$c */
    public static class c {
        public TextView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public ImageView e;
        public TextView f;
        public int g;
        public TextView h;

        public c() {
        }
    }

    public C0783Nv(Context context, int i, List list, EE ee) {
        super(context, i, list);
        this.g = "";
        this.i = new ArrayList();
        this.j = new int[]{R.drawable.up, 1, R.drawable.down};
        this.n = false;
        this.h = new SparseBooleanArray();
        this.a = context;
        this.d = list;
        this.e = list;
        this.c = i;
        this.b = LayoutInflater.from(context);
        this.k = ((BitmapDrawable) context.getResources().getDrawable(this.j[0])).getBitmap();
        this.l = ((BitmapDrawable) context.getResources().getDrawable(this.j[2])).getBitmap();
        this.n = c("prefOthers_tr_time", true);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C4064uh getItem(int i) {
        return (C4064uh) this.d.get(i);
    }

    public SparseBooleanArray b() {
        return this.h;
    }

    public boolean c(String str, boolean z) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(this.a).getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // android.widget.ArrayAdapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void remove(C4064uh c4064uh) {
        this.d.remove(c4064uh);
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
        try {
            return this.d.indexOf(getItem(i));
        } catch (Exception unused) {
            return -1L;
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar = new c();
        View viewInflate = this.b.inflate(this.c, (ViewGroup) null);
        cVar.a = (TextView) viewInflate.findViewById(R.id.tr_id);
        cVar.b = (TextView) viewInflate.findViewById(R.id.tr_date);
        cVar.c = (TextView) viewInflate.findViewById(R.id.tr_amount);
        cVar.h = (TextView) viewInflate.findViewById(R.id.tr_time);
        cVar.d = (TextView) viewInflate.findViewById(R.id.tr_remarks);
        cVar.f = (TextView) viewInflate.findViewById(R.id.tr_bal);
        cVar.e = (ImageView) viewInflate.findViewById(R.id.img);
        viewInflate.setTag(cVar);
        try {
            cVar.a.setText(((C4064uh) this.d.get(i)).q());
            cVar.b.setText(((C4064uh) this.d.get(i)).p());
            cVar.c.setText(((C4064uh) this.d.get(i)).n());
            cVar.d.setText(((C4064uh) this.d.get(i)).r());
            cVar.f.setText(((C4064uh) this.d.get(i)).f());
            cVar.g = i;
            C4192wG.n(this.a).i(((C4064uh) this.d.get(i)).t()).c(cVar.e);
            cVar.e.setTag(Integer.valueOf(((C4064uh) this.d.get(i)).t()));
            cVar.d.setTag(((C4064uh) this.d.get(i)).o());
            cVar.c.setTag(((C4064uh) this.d.get(i)).b());
            cVar.b.setTag(((C4064uh) this.d.get(i)).a());
            cVar.a.setTag(((C4064uh) this.d.get(i)).h());
            cVar.h.setText(((C4064uh) this.d.get(i)).s());
            if (!this.n || ((C4064uh) this.d.get(i)).s().length() <= 4) {
                cVar.h.setVisibility(8);
            } else {
                cVar.h.setVisibility(0);
                cVar.h.setText(((C4064uh) this.d.get(i)).s().substring(0, 5));
            }
            C4064uh c4064uh = (C4064uh) this.d.get(i);
            if (c4064uh.r() != null) {
                String lowerCase = c4064uh.r().toLowerCase(Locale.getDefault());
                String str = this.g;
                if (str != null && !str.isEmpty() && lowerCase.contains(this.g)) {
                    int iIndexOf = lowerCase.indexOf(this.g);
                    int length = this.g.length() + iIndexOf;
                    Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(cVar.d.getText());
                    spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
                    cVar.d.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
                }
                String lowerCase2 = c4064uh.p().toLowerCase(Locale.getDefault());
                if (lowerCase2.contains(this.g)) {
                    int iIndexOf2 = lowerCase2.indexOf(this.g);
                    int length2 = this.g.length() + iIndexOf2;
                    Spannable spannableNewSpannable2 = Spannable.Factory.getInstance().newSpannable(cVar.b.getText());
                    spannableNewSpannable2.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf2, length2, 33);
                    cVar.b.setText(spannableNewSpannable2, TextView.BufferType.SPANNABLE);
                }
                String lowerCase3 = c4064uh.n().replaceAll(",", "").toLowerCase(Locale.getDefault());
                if (lowerCase3.contains(this.g)) {
                    int iIndexOf3 = lowerCase3.indexOf(this.g);
                    int length3 = this.g.length() + iIndexOf3;
                    String string = cVar.c.getText().toString();
                    int length4 = string.length() - string.replaceAll(",", "").length();
                    if (this.g.length() > 0) {
                        Spannable spannableNewSpannable3 = Spannable.Factory.getInstance().newSpannable(string);
                        spannableNewSpannable3.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf3, length3 + length4, 33);
                        cVar.c.setText(spannableNewSpannable3, TextView.BufferType.SPANNABLE);
                    }
                }
            }
            if (this.i.contains(Integer.valueOf(i))) {
                viewInflate.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
            } else {
                viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        } catch (Exception unused) {
        }
        return viewInflate;
    }
}
