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
import info.aalmoghalis.inventory.activity.item_price_exp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class TC extends BaseExpandableListAdapter implements Filterable {
    public Context a;
    public ArrayList b;
    public List c;
    public b d;
    public String e = "";
    public Z00 f;
    public int g;
    public item_price_exp h;

    public class a implements View.OnClickListener {
        public final /* synthetic */ C3549oL a;

        public a(C3549oL c3549oL) {
            this.a = c3549oL;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            item_price_exp item_price_expVar = TC.this.h;
            if (item_price_expVar != null) {
                C3549oL c3549oL = this.a;
                item_price_expVar.Z = c3549oL.j;
                item_price_expVar.W(view, c3549oL.j(), this.a.c());
            }
        }
    }

    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            TC.this.e = charSequence.toString();
            if (charSequence.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < TC.this.c.size(); i++) {
                    if (((C3549oL) TC.this.c.get(i)).k().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C3549oL) TC.this.c.get(i)).i().toUpperCase().contains(charSequence.toString().toUpperCase()) || (((C3549oL) TC.this.c.get(i)).k != null && ((C3549oL) TC.this.c.get(i)).k.toUpperCase().contains(charSequence.toString().toUpperCase()))) {
                        C3549oL c3549oL = new C3549oL(((C3549oL) TC.this.c.get(i)).j(), ((C3549oL) TC.this.c.get(i)).k(), ((C3549oL) TC.this.c.get(i)).i(), ((C3549oL) TC.this.c.get(i)).b().replaceAll(",", ""), ((C3549oL) TC.this.c.get(i)).h().replaceAll(",", ""), ((C3549oL) TC.this.c.get(i)).m().replaceAll(",", ""), ((C3549oL) TC.this.c.get(i)).c());
                        c3549oL.k = ((C3549oL) TC.this.c.get(i)).k;
                        c3549oL.n(((C3549oL) TC.this.c.get(i)).e());
                        arrayList.add(c3549oL);
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            } else {
                filterResults.count = TC.this.c.size();
                filterResults.values = TC.this.c;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            TC tc = TC.this;
            tc.b = (ArrayList) filterResults.values;
            tc.notifyDataSetChanged();
        }

        public /* synthetic */ b(TC tc, a aVar) {
            this();
        }
    }

    public TC(Context context, ArrayList arrayList, Z00 z00, int i, item_price_exp item_price_expVar) {
        this.a = context;
        this.b = arrayList;
        this.c = arrayList;
        this.f = z00;
        this.g = i;
        this.h = item_price_expVar;
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
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.report3_balance_group_exp, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.item_name);
        TextView textView2 = (TextView) view.findViewById(R.id.item_price);
        TextView textView3 = (TextView) view.findViewById(R.id.item_curr);
        TextView textView4 = (TextView) view.findViewById(R.id.start_date);
        textView.setText(c3467nL.i());
        int i3 = this.g;
        if (i3 == 1) {
            textView2.setText(c3467nL.a() + "" + c3467nL.f());
            textView3.setText(c3467nL.c());
        } else if (i3 == 2) {
            textView2.setText(c3467nL.a() + "" + c3467nL.f());
            textView3.setText("");
        } else {
            textView2.setText(c3467nL.b());
            textView3.setText(c3467nL.e());
        }
        textView4.setText(c3467nL.k());
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((C3549oL) this.b.get(i)).e().size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.d == null) {
            this.d = new b(this, null);
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
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.report3_balance_group, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.item_name);
        TextView textView2 = (TextView) view.findViewById(R.id.item_price);
        TextView textView3 = (TextView) view.findViewById(R.id.item_curr);
        TextView textView4 = (TextView) view.findViewById(R.id.start_date);
        textView.setText(c3549oL.k());
        textView2.setText(c3549oL.b());
        textView3.setText(c3549oL.h());
        textView4.setText(c3549oL.m());
        TextView textView5 = (TextView) view.findViewById(R.id.item_barcode);
        textView5.setVisibility(8);
        String str = c3549oL.k;
        if (str != null && str.length() > 0) {
            textView5.setText(c3549oL.k);
            textView5.setVisibility(0);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.indicator);
        imageView.setVisibility(0);
        if (z) {
            imageView.setImageResource(R.drawable.sort_up_);
        } else {
            imageView.setImageResource(R.drawable.sort_down_);
        }
        ((ImageView) view.findViewById(R.id.indicator2)).setOnClickListener(new a(c3549oL));
        String lowerCase = c3549oL.k().toLowerCase(Locale.getDefault());
        if (lowerCase.contains(this.e)) {
            int iIndexOf = lowerCase.indexOf(this.e);
            int length = this.e.length() + iIndexOf;
            Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(textView.getText());
            spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
            textView.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
        }
        try {
            C2160f10 c2160f10 = new C2160f10();
            TextView[] textViewArr = {textView5};
            String str2 = c3549oL.k;
            c2160f10.m(textViewArr, new String[]{str2 == null ? "" : str2.toLowerCase(Locale.getDefault())}, this.e);
        } catch (Exception e) {
            e.printStackTrace();
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
