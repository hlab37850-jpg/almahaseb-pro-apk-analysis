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
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: Wv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1030Wv extends ArrayAdapter implements Filterable {
    public Context a;
    public LayoutInflater b;
    public int c;
    public List d;
    public List e;
    public b f;
    public String g;
    public SparseBooleanArray h;
    public ArrayList i;

    /* JADX INFO: renamed from: Wv$b */
    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            C1030Wv.this.g = charSequence.toString();
            if (charSequence.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < C1030Wv.this.e.size(); i++) {
                    if (((C0634Jt) C1030Wv.this.e.get(i)).e().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                        arrayList.add(new C0634Jt(((C0634Jt) C1030Wv.this.e.get(i)).d(), ((C0634Jt) C1030Wv.this.e.get(i)).e(), ((C0634Jt) C1030Wv.this.e.get(i)).l(), ((C0634Jt) C1030Wv.this.e.get(i)).n(), ((C0634Jt) C1030Wv.this.e.get(i)).h(), ((C0634Jt) C1030Wv.this.e.get(i)).g(), ((C0634Jt) C1030Wv.this.e.get(i)).f(), ((C0634Jt) C1030Wv.this.e.get(i)).j(), ((C0634Jt) C1030Wv.this.e.get(i)).b(), ((C0634Jt) C1030Wv.this.e.get(i)).l(), ((C0634Jt) C1030Wv.this.e.get(i)).m(), ((C0634Jt) C1030Wv.this.e.get(i)).i(), "", ((C0634Jt) C1030Wv.this.e.get(i)).c()));
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            } else {
                filterResults.count = C1030Wv.this.e.size();
                filterResults.values = C1030Wv.this.e;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            C1030Wv c1030Wv = C1030Wv.this;
            c1030Wv.d = (ArrayList) filterResults.values;
            c1030Wv.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: Wv$c */
    public class c {
        public TextView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;

        public c() {
        }
    }

    public C1030Wv(Context context, int i, List list) {
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

    @Override // android.widget.ArrayAdapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void remove(C0634Jt c0634Jt) {
        this.d.remove(c0634Jt);
        notifyDataSetChanged();
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
            cVar.b = (TextView) viewInflate.findViewById(R.id.item_unit);
            cVar.c = (TextView) viewInflate.findViewById(R.id.inv_qty);
            cVar.d = (TextView) viewInflate.findViewById(R.id.br_qty);
            cVar.e = (TextView) viewInflate.findViewById(R.id.diff_qty);
            if (this.c == R.layout.inv_chk_item_det_row) {
                cVar.f = (TextView) viewInflate.findViewById(R.id.item_date);
            }
            viewInflate.setTag(cVar);
            viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else {
            viewInflate = view;
            cVar = (c) view.getTag();
        }
        cVar.a.setText(((C0634Jt) this.d.get(i)).e());
        cVar.b.setText(((C0634Jt) this.d.get(i)).l());
        cVar.c.setText(((C0634Jt) this.d.get(i)).n());
        cVar.d.setText(((C0634Jt) this.d.get(i)).h());
        cVar.e.setText(((C0634Jt) this.d.get(i)).g());
        if (this.c == R.layout.inv_chk_item_det_row) {
            if (((C0634Jt) this.d.get(i)).c() == null || ((C0634Jt) this.d.get(i)).c().equals("")) {
                cVar.f.setVisibility(8);
            } else {
                cVar.f.setText(((C0634Jt) this.d.get(i)).c());
                cVar.f.setVisibility(0);
            }
        }
        String lowerCase = ((C0634Jt) this.d.get(i)).e().toLowerCase(Locale.getDefault());
        if (lowerCase.contains(this.g)) {
            int iIndexOf = lowerCase.indexOf(this.g);
            int length = this.g.length() + iIndexOf;
            Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(cVar.a.getText());
            spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
            cVar.a.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
        }
        if (this.i.contains(Integer.valueOf(i))) {
            viewInflate.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
        } else {
            viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        return viewInflate;
    }
}
