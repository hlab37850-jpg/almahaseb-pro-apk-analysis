package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: Ov, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0809Ov extends ArrayAdapter implements Filterable {
    public Context a;
    public LayoutInflater b;
    public int c;
    public List d;
    public List e;
    public b f;
    public String g;
    public String h;
    public SparseBooleanArray i;
    public ArrayList j;

    /* JADX INFO: renamed from: Ov$b */
    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            C0809Ov.this.g = charSequence.toString();
            if (charSequence.length() > 0) {
                new ArrayList();
                ArrayList arrayListR = new C2160f10().r(C0809Ov.this.e, charSequence.toString());
                filterResults.count = arrayListR.size();
                filterResults.values = arrayListR;
            } else {
                filterResults.count = C0809Ov.this.e.size();
                filterResults.values = C0809Ov.this.e;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            C0809Ov c0809Ov = C0809Ov.this;
            c0809Ov.d = (ArrayList) filterResults.values;
            c0809Ov.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: Ov$c */
    public class c {
        public TextView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public TextView h;
        public TextView i;
        public ImageView j;

        public c() {
        }
    }

    public C0809Ov(Context context, int i, List list) {
        super(context, i, list);
        this.g = "";
        this.h = "";
        this.j = new ArrayList();
        this.i = new SparseBooleanArray();
        this.a = context;
        this.d = list;
        this.e = list;
        this.c = i;
        this.b = LayoutInflater.from(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0634Jt getItem(int i) {
        return (C0634Jt) this.d.get(i);
    }

    public SparseBooleanArray b() {
        return this.i;
    }

    @Override // android.widget.ArrayAdapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void remove(C0634Jt c0634Jt) {
        this.d.remove(c0634Jt);
        notifyDataSetChanged();
    }

    public void d() {
        this.i = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void e(int i, boolean z) {
        if (z) {
            this.i.put(i, z);
        } else {
            this.i.delete(i);
        }
        notifyDataSetChanged();
    }

    public void f(int i) {
        if (this.j.contains(Integer.valueOf(i))) {
            this.j.remove(Integer.valueOf(i));
        } else {
            this.j.add(Integer.valueOf(i));
        }
        e(i, !this.i.get(i));
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
        cVar.a = (TextView) viewInflate.findViewById(R.id.item_name);
        cVar.f = (TextView) viewInflate.findViewById(R.id.item_unit);
        cVar.b = (TextView) viewInflate.findViewById(R.id.item_weight);
        cVar.c = (TextView) viewInflate.findViewById(R.id.item_qty);
        cVar.d = (TextView) viewInflate.findViewById(R.id.item_price);
        cVar.e = (TextView) viewInflate.findViewById(R.id.no_);
        if (this.c == R.layout.bill_item_det_row3) {
            cVar.i = (TextView) viewInflate.findViewById(R.id.item_date);
        }
        if (this.c == R.layout.doc_item_det_row3) {
            cVar.g = (TextView) viewInflate.findViewById(R.id.item_unit2);
        }
        if (this.c == R.layout.doc_item_det_row6) {
            cVar.g = (TextView) viewInflate.findViewById(R.id.item_unit2);
            cVar.h = (TextView) viewInflate.findViewById(R.id.item_unit3);
        }
        cVar.j = (ImageView) viewInflate.findViewById(R.id.page_delete);
        viewInflate.setTag(cVar);
        viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        cVar.a.setText(((C0634Jt) this.d.get(i)).e());
        int i2 = this.c;
        String lowerCase = "";
        if (i2 == R.layout.bill_item_det_row3) {
            if (((C0634Jt) this.d.get(i)).l() == null || ((C0634Jt) this.d.get(i)).l().equals(".")) {
                cVar.f.setVisibility(8);
            } else {
                cVar.f.setText(((C0634Jt) this.d.get(i)).l());
                cVar.f.setVisibility(0);
            }
            if (((C0634Jt) this.d.get(i)).c() == null || ((C0634Jt) this.d.get(i)).c().equals("")) {
                cVar.i.setVisibility(8);
            } else {
                cVar.i.setText(((C0634Jt) this.d.get(i)).c());
                cVar.i.setVisibility(0);
            }
        } else if (i2 == R.layout.doc_item_det_row5) {
            if (this.h.equals(((C0634Jt) this.d.get(i)).j())) {
                cVar.f.setVisibility(8);
            } else {
                cVar.f.setText(((C0634Jt) this.d.get(i)).j());
                cVar.f.setVisibility(0);
            }
        } else if (i2 == R.layout.doc_item_det_row3) {
            if (this.h.equals(((C0634Jt) this.d.get(i)).j())) {
                cVar.f.setVisibility(8);
                cVar.g.setVisibility(8);
            } else if (((C0634Jt) this.d.get(i)).g().equals("0")) {
                cVar.f.setText(((C0634Jt) this.d.get(i)).j());
                cVar.f.setVisibility(0);
            } else {
                cVar.g.setText(((C0634Jt) this.d.get(i)).j());
                cVar.g.setVisibility(0);
            }
        } else if (i2 == R.layout.doc_item_det_row6) {
            cVar.f.setText(((C0634Jt) this.d.get(i)).l());
            cVar.f.setVisibility(0);
            cVar.g.setText(((C0634Jt) this.d.get(i)).j());
            cVar.g.setVisibility(0);
            cVar.h.setText(((C0634Jt) this.d.get(i)).j());
            cVar.h.setVisibility(0);
        }
        cVar.b.setText(((C0634Jt) this.d.get(i)).n());
        cVar.c.setText(((C0634Jt) this.d.get(i)).h());
        cVar.d.setText(((C0634Jt) this.d.get(i)).g());
        cVar.e.setText(((C0634Jt) this.d.get(i)).f());
        C0634Jt c0634Jt = (C0634Jt) this.d.get(i);
        try {
            C2160f10 c2160f10 = new C2160f10();
            TextView[] textViewArr = {cVar.a, cVar.i, cVar.f, cVar.c};
            String lowerCase2 = c0634Jt.e().toLowerCase(Locale.getDefault());
            String lowerCase3 = c0634Jt.c() == null ? "" : c0634Jt.c().toLowerCase(Locale.getDefault());
            String lowerCase4 = c0634Jt.l() == null ? "" : c0634Jt.l().toLowerCase(Locale.getDefault());
            if (c0634Jt.h() != null) {
                lowerCase = c0634Jt.h().toLowerCase(Locale.getDefault());
            }
            c2160f10.m(textViewArr, new String[]{lowerCase2, lowerCase3, lowerCase4, lowerCase}, this.g);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.j.contains(Integer.valueOf(i))) {
            viewInflate.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
        } else {
            viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        return viewInflate;
    }

    public C0809Ov(Context context, int i, List list, String str) {
        super(context, i, list);
        this.g = "";
        this.h = "";
        this.j = new ArrayList();
        this.i = new SparseBooleanArray();
        this.a = context;
        this.d = list;
        this.e = list;
        this.c = i;
        this.b = LayoutInflater.from(context);
        this.h = str;
    }
}
