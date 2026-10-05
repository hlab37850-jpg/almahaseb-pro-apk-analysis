package defpackage;

import android.content.Context;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import info.aalmoghalis.inventory.R;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class QC extends BaseExpandableListAdapter implements Filterable {
    public Context a;
    public ArrayList b;
    public List c;
    public b d;
    public String e = "";
    public double f = 0.0d;
    public double g = 0.0d;

    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            QC.this.e = charSequence.toString();
            if (charSequence.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < QC.this.c.size(); i++) {
                    if (((C3549oL) QC.this.c.get(i)).k().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C3549oL) QC.this.c.get(i)).i().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                        C3549oL c3549oL = new C3549oL(((C3549oL) QC.this.c.get(i)).j(), ((C3549oL) QC.this.c.get(i)).k(), ((C3549oL) QC.this.c.get(i)).i(), ((C3549oL) QC.this.c.get(i)).b().replaceAll(",", ""), ((C3549oL) QC.this.c.get(i)).h().replaceAll(",", ""), ((C3549oL) QC.this.c.get(i)).m().replaceAll(",", ""));
                        c3549oL.n(((C3549oL) QC.this.c.get(i)).e());
                        arrayList.add(c3549oL);
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            } else {
                filterResults.count = QC.this.c.size();
                filterResults.values = QC.this.c;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            QC qc = QC.this;
            qc.b = (ArrayList) filterResults.values;
            qc.notifyDataSetChanged();
        }
    }

    public QC(Context context, ArrayList arrayList) {
        this.a = context;
        this.b = arrayList;
        this.c = arrayList;
    }

    public String a(String str) {
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(str));
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return ((C3549oL) this.b.get(i)).e().get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (i2 == 0) {
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.report5_amount_qty_exp_hdr, (ViewGroup) null);
            this.f = 0.0d;
            this.g = 0.0d;
        }
        if (i2 > 0 && i2 < getChildrenCount(i) - 1) {
            C3467nL c3467nL = (C3467nL) getChild(i, i2 - 1);
            View viewInflate = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.report5_amount_qty_exp, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.f1);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.f2);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.f3);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.f4);
            TextView textView5 = (TextView) viewInflate.findViewById(R.id.f5);
            textView.setText(c3467nL.i());
            textView2.setText(c3467nL.e());
            textView3.setText(c3467nL.k());
            textView4.setText(c3467nL.b());
            textView5.setText(c3467nL.f());
            this.f += Double.parseDouble(c3467nL.k().replaceAll(",", ""));
            this.g += Double.parseDouble(c3467nL.f().replaceAll(",", ""));
            view = viewInflate;
        }
        if (i2 != getChildrenCount(i) - 1) {
            return view;
        }
        View viewInflate2 = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.report5_amount_qty_exp_footer, (ViewGroup) null);
        TextView textView6 = (TextView) viewInflate2.findViewById(R.id.balance);
        TextView textView7 = (TextView) viewInflate2.findViewById(R.id.balance2);
        textView6.setText(a(String.valueOf(this.f)));
        textView7.setText(a(String.valueOf(this.g)));
        return viewInflate2;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((C3549oL) this.b.get(i)).e().size() + 2;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.d == null) {
            this.d = new b();
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
        C3549oL c3549oL = (C3549oL) getGroup(i);
        if (view == null) {
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.report5_amount_qty, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.f1);
        TextView textView2 = (TextView) view.findViewById(R.id.f2);
        TextView textView3 = (TextView) view.findViewById(R.id.f3);
        TextView textView4 = (TextView) view.findViewById(R.id.f4);
        TextView textView5 = (TextView) view.findViewById(R.id.f5);
        TextView textView6 = (TextView) view.findViewById(R.id.f6);
        textView.setText(c3549oL.k());
        textView2.setText(c3549oL.i());
        textView3.setText(c3549oL.b());
        textView4.setText(c3549oL.h());
        textView5.setText(c3549oL.m());
        textView6.setText(c3549oL.j());
        String lowerCase = c3549oL.k().toLowerCase(Locale.getDefault());
        if (lowerCase.contains(this.e)) {
            int iIndexOf = lowerCase.indexOf(this.e);
            int length = this.e.length() + iIndexOf;
            Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(textView.getText());
            spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
            textView.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
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
