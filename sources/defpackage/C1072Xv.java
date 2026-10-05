package defpackage;

import android.content.Context;
import android.graphics.Color;
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
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: Xv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1072Xv extends ArrayAdapter implements Filterable {
    public Context a;
    public LayoutInflater b;
    public int c;
    public List d;
    public List e;
    public b f;
    public String g;
    public SparseBooleanArray h;
    public ArrayList i;

    /* JADX INFO: renamed from: Xv$b */
    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            C1072Xv.this.g = charSequence.toString();
            if (charSequence.length() > 0) {
                new ArrayList();
                ArrayList arrayListR = new C2160f10().r(C1072Xv.this.e, charSequence.toString());
                filterResults.count = arrayListR.size();
                filterResults.values = arrayListR;
            } else {
                filterResults.count = C1072Xv.this.e.size();
                filterResults.values = C1072Xv.this.e;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            C1072Xv c1072Xv = C1072Xv.this;
            c1072Xv.d = (ArrayList) filterResults.values;
            c1072Xv.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: Xv$c */
    public class c {
        public TextView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public ImageView f;

        public c() {
        }
    }

    public C1072Xv(Context context, int i, List list) {
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
    public C0634Jt getItem(int i) {
        return (C0634Jt) this.d.get(i);
    }

    public SparseBooleanArray b() {
        return this.h;
    }

    @Override // android.widget.ArrayAdapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void remove(C0634Jt c0634Jt) {
        this.d.remove(c0634Jt);
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
            cVar.a = (TextView) viewInflate.findViewById(R.id.item_name);
            cVar.b = (TextView) viewInflate.findViewById(R.id.item_qty);
            cVar.c = (TextView) viewInflate.findViewById(R.id.no_);
            if (this.c == R.layout.move_item_det_row3) {
                cVar.d = (TextView) viewInflate.findViewById(R.id.item_unit);
                cVar.e = (TextView) viewInflate.findViewById(R.id.item_date);
            }
            cVar.f = (ImageView) viewInflate.findViewById(R.id.page_delete);
            viewInflate.setTag(cVar);
            viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else {
            viewInflate = view;
            cVar = (c) view.getTag();
        }
        cVar.a.setText(((C0634Jt) this.d.get(i)).e());
        cVar.b.setText(((C0634Jt) this.d.get(i)).h());
        cVar.c.setText(((C0634Jt) this.d.get(i)).f());
        try {
            if (this.c == R.layout.move_item_det_row3) {
                if (((C0634Jt) this.d.get(i)).l() == null || ((C0634Jt) this.d.get(i)).l().equals(".")) {
                    cVar.d.setVisibility(8);
                } else {
                    cVar.d.setText(((C0634Jt) this.d.get(i)).l());
                    cVar.d.setVisibility(0);
                }
                if (((C0634Jt) this.d.get(i)).c() == null || ((C0634Jt) this.d.get(i)).c().equals("")) {
                    cVar.e.setVisibility(8);
                } else {
                    cVar.e.setText(((C0634Jt) this.d.get(i)).c());
                    cVar.e.setVisibility(0);
                }
            }
        } catch (Exception e) {
            Log.d("error=", e.getMessage());
        }
        C0634Jt c0634Jt = (C0634Jt) this.d.get(i);
        try {
            new C2160f10().m(new TextView[]{cVar.a, cVar.e, cVar.d, cVar.b}, new String[]{c0634Jt.e().toLowerCase(Locale.getDefault()), c0634Jt.c().toLowerCase(Locale.getDefault()), c0634Jt.l().toLowerCase(Locale.getDefault()), c0634Jt.h().toLowerCase(Locale.getDefault())}, this.g);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.i.contains(Integer.valueOf(i))) {
            viewInflate.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
        } else {
            viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        return viewInflate;
    }
}
