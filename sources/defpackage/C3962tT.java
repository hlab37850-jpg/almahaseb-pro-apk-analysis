package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: tT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3962tT extends ArrayAdapter {
    public Context a;
    public int b;
    public List c;
    public List d;
    public List e;
    public Filter f;

    /* JADX INFO: renamed from: tT$a */
    public class a extends Filter {
        public a() {
        }

        @Override // android.widget.Filter
        public CharSequence convertResultToString(Object obj) {
            return (String) obj;
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            if (charSequence == null) {
                return new Filter.FilterResults();
            }
            C3962tT.this.e.clear();
            for (String str : C3962tT.this.d) {
                if (str.toLowerCase().contains(charSequence.toString().toLowerCase())) {
                    C3962tT.this.e.add(str);
                }
            }
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = C3962tT.this.e;
            filterResults.count = C3962tT.this.e.size();
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            ArrayList arrayList = (ArrayList) filterResults.values;
            if (filterResults.count > 0) {
                C3962tT.this.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C3962tT.this.add((String) it.next());
                    C3962tT.this.notifyDataSetChanged();
                }
            }
        }
    }

    public C3962tT(Context context, int i, List list) {
        super(context, i, 0, list);
        this.f = new a();
        this.a = context;
        this.b = i;
        this.c = list;
        this.d = new ArrayList(list);
        this.e = new ArrayList();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public Filter getFilter() {
        return this.f;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(this.b, viewGroup, false);
        }
        String str = (String) this.c.get(i);
        if (str != null && (view instanceof TextView)) {
            ((TextView) view).setText(str);
        }
        return view;
    }
}
