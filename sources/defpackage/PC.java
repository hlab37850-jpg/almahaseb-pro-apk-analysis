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
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class PC extends BaseExpandableListAdapter implements Filterable {
    public Context a;
    public ArrayList b;
    public List c;
    public b d;
    public String e = "";

    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            PC.this.e = charSequence.toString();
            if (charSequence.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < PC.this.c.size(); i++) {
                    if (((C3549oL) PC.this.c.get(i)).k().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C3549oL) PC.this.c.get(i)).i().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                        C3549oL c3549oL = new C3549oL(((C3549oL) PC.this.c.get(i)).j(), ((C3549oL) PC.this.c.get(i)).k(), ((C3549oL) PC.this.c.get(i)).i(), ((C3549oL) PC.this.c.get(i)).a().replaceAll(",", ""), ((C3549oL) PC.this.c.get(i)).f().replaceAll(",", ""), ((C3549oL) PC.this.c.get(i)).l().replaceAll(",", ""));
                        c3549oL.n(((C3549oL) PC.this.c.get(i)).e());
                        arrayList.add(c3549oL);
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            } else {
                filterResults.count = PC.this.c.size();
                filterResults.values = PC.this.c;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            PC pc = PC.this;
            pc.b = (ArrayList) filterResults.values;
            pc.notifyDataSetChanged();
        }
    }

    public PC(Context context, ArrayList arrayList) {
        this.a = context;
        this.b = arrayList;
        this.c = arrayList;
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
        C3467nL c3467nL = (C3467nL) getChild(i, i2);
        if (view == null) {
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.report5_balance_group_exp, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.customer_name);
        TextView textView2 = (TextView) view.findViewById(R.id.cr_amount);
        TextView textView3 = (TextView) view.findViewById(R.id.db_amount);
        TextView textView4 = (TextView) view.findViewById(R.id.net_balance);
        textView.setText(c3467nL.i());
        textView4.setText(c3467nL.j());
        textView2.setText(c3467nL.a());
        textView3.setText(c3467nL.c());
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((C3549oL) this.b.get(i)).e().size();
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
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.report5_balance_group, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.customer_name);
        TextView textView2 = (TextView) view.findViewById(R.id.cr_amount);
        TextView textView3 = (TextView) view.findViewById(R.id.db_amount);
        TextView textView4 = (TextView) view.findViewById(R.id.net_balance);
        textView.setText(c3549oL.k());
        textView2.setText(c3549oL.a());
        textView3.setText(c3549oL.f());
        textView4.setText(c3549oL.l());
        try {
            ImageView imageView = (ImageView) view.findViewById(R.id.indicator);
            imageView.setVisibility(0);
            if (z) {
                imageView.setImageResource(R.drawable.sort_up_);
            } else {
                imageView.setImageResource(R.drawable.sort_down_);
            }
        } catch (Exception unused) {
        }
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
