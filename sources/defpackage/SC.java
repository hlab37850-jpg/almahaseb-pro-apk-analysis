package defpackage;

import android.content.Context;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
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
public class SC extends BaseExpandableListAdapter implements Filterable {
    public Context a;
    public ArrayList b;
    public List c;
    public b d;
    public String e = "";
    public int f;

    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            SC.this.e = charSequence.toString();
            if (charSequence.length() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                if (Z00.e0.size() == 0) {
                    while (i < SC.this.c.size()) {
                        if (((C1896ch) SC.this.c.get(i)).j().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((((C1896ch) SC.this.c.get(i)).h() != null && ((C1896ch) SC.this.c.get(i)).h().toUpperCase().contains(charSequence.toString().toUpperCase())) || ((C1896ch) SC.this.c.get(i)).a().replaceAll(",", "").toUpperCase().contains(charSequence.toString().toUpperCase()))) {
                            C1896ch c1896ch = new C1896ch(((C1896ch) SC.this.c.get(i)).i(), ((C1896ch) SC.this.c.get(i)).j(), ((C1896ch) SC.this.c.get(i)).h(), ((C1896ch) SC.this.c.get(i)).a().replaceAll(",", "").replaceAll("-0", "0"), ((C1896ch) SC.this.c.get(i)).k(), ((C1896ch) SC.this.c.get(i)).f(), ((C1896ch) SC.this.c.get(i)).c());
                            c1896ch.m(((C1896ch) SC.this.c.get(i)).e());
                            arrayList.add(c1896ch);
                        }
                        i++;
                    }
                } else {
                    while (i < Z00.e0.size()) {
                        if (((C1896ch) Z00.e0.get(i)).j().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((((C1896ch) Z00.e0.get(i)).h() != null && ((C1896ch) Z00.e0.get(i)).h().toUpperCase().contains(charSequence.toString().toUpperCase())) || ((C1896ch) Z00.e0.get(i)).a().replaceAll(",", "").toUpperCase().contains(charSequence.toString().toUpperCase()) || (((C1896ch) Z00.e0.get(i)).b() != null && ((C1896ch) Z00.e0.get(i)).b().toUpperCase().contains(charSequence.toString().toUpperCase())))) {
                            C1896ch c1896ch2 = new C1896ch(((C1896ch) Z00.e0.get(i)).i(), ((C1896ch) Z00.e0.get(i)).j(), ((C1896ch) Z00.e0.get(i)).h(), ((C1896ch) Z00.e0.get(i)).a().replaceAll(",", ""), ((C1896ch) Z00.e0.get(i)).k(), ((C1896ch) Z00.e0.get(i)).f(), ((C1896ch) Z00.e0.get(i)).c());
                            c1896ch2.l(((C1896ch) Z00.e0.get(i)).b());
                            Log.d("cus_curr=", c1896ch2.j() + ":" + c1896ch2.c());
                            arrayList.add(c1896ch2);
                        }
                        i++;
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            } else {
                filterResults.count = SC.this.c.size();
                filterResults.values = SC.this.c;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            SC sc = SC.this;
            sc.b = (ArrayList) filterResults.values;
            sc.notifyDataSetChanged();
        }
    }

    public SC(Context context, ArrayList arrayList, int i) {
        this.a = context;
        this.b = arrayList;
        this.c = arrayList;
        this.f = i;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return ((C1896ch) this.b.get(i)).e().get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C1815bh c1815bh = (C1815bh) getChild(i, i2);
        if (view == null) {
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.report2_screens, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.customer_name);
        TextView textView2 = (TextView) view.findViewById(R.id.cus_id);
        C0372Bn.f.a(this.a, textView);
        textView.setText(c1815bh.e());
        textView2.setText(c1815bh.c());
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((C1896ch) this.b.get(i)).e().size();
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

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C1896ch c1896ch = (C1896ch) getGroup(i);
        if (view == null) {
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.report2_screens_hdr, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.customer_name);
        TextView textView2 = (TextView) view.findViewById(R.id.cus_id);
        ImageView imageView = (ImageView) view.findViewById(R.id.indicator);
        if (z) {
            imageView.setImageResource(R.drawable.group_up);
        } else {
            imageView.setImageResource(R.drawable.group_down);
        }
        C0372Bn.e.a(this.a, textView);
        textView.setText(c1896ch.j());
        textView2.setText(c1896ch.i());
        imageView.setTag(c1896ch.i());
        String lowerCase = c1896ch.j().toLowerCase(Locale.getDefault());
        if (lowerCase.contains(this.e)) {
            int iIndexOf = lowerCase.indexOf(this.e);
            int length = this.e.length() + iIndexOf;
            Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(textView.getText());
            spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
            textView.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
        }
        String lowerCase2 = c1896ch.a().replaceAll(",", "").toLowerCase(Locale.getDefault());
        if (lowerCase2.contains(this.e)) {
            int iIndexOf2 = lowerCase2.indexOf(this.e);
            int length2 = this.e.length() + iIndexOf2;
            String string = textView2.getText().toString();
            int length3 = string.length() - string.replaceAll(",", "").length();
            if (this.e.length() > 0) {
                Spannable spannableNewSpannable2 = Spannable.Factory.getInstance().newSpannable(string);
                spannableNewSpannable2.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf2, length2 + length3, 33);
                textView2.setText(spannableNewSpannable2, TextView.BufferType.SPANNABLE);
            }
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
