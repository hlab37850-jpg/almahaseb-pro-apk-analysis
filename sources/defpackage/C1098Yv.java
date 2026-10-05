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
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: Yv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1098Yv extends ArrayAdapter implements Filterable {
    public Context a;
    public LayoutInflater b;
    public int c;
    public int d;
    public List e;
    public List f;
    public b g;
    public String h;
    public int[] i;
    public int j;
    public SparseBooleanArray k;
    public ArrayList l;

    /* JADX INFO: renamed from: Yv$b */
    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            C1098Yv.this.h = charSequence != null ? charSequence.toString().trim() : "";
            if (charSequence == null || charSequence.length() <= 0) {
                filterResults.count = C1098Yv.this.f.size();
                filterResults.values = C1098Yv.this.f;
            } else {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < C1098Yv.this.f.size(); i++) {
                    if (((C4145vh) C1098Yv.this.f.get(i)).a().toUpperCase().contains(charSequence.toString().toUpperCase().trim()) || ((C4145vh) C1098Yv.this.f.get(i)).o().toUpperCase().contains(charSequence.toString().toUpperCase().trim())) {
                        arrayList.add(new C4145vh(((C4145vh) C1098Yv.this.f.get(i)).v(), ((C4145vh) C1098Yv.this.f.get(i)).a(), ((C4145vh) C1098Yv.this.f.get(i)).n(), ((C4145vh) C1098Yv.this.f.get(i)).o(), ((C4145vh) C1098Yv.this.f.get(i)).p(), ((C4145vh) C1098Yv.this.f.get(i)).q()));
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            C1098Yv c1098Yv = C1098Yv.this;
            c1098Yv.e = (ArrayList) filterResults.values;
            c1098Yv.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: Yv$c */
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

    public C1098Yv(Context context, int i, List list, int i2) {
        super(context, i, list);
        this.h = "";
        this.i = new int[]{R.drawable.up, 1, R.drawable.down};
        this.j = android.R.drawable.ic_menu_close_clear_cancel;
        this.l = new ArrayList();
        this.k = new SparseBooleanArray();
        this.a = context;
        this.e = list;
        this.f = list;
        this.c = i;
        this.d = i2;
        this.b = LayoutInflater.from(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C4145vh getItem(int i) {
        return (C4145vh) this.e.get(i);
    }

    @Override // android.widget.ArrayAdapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void remove(C4145vh c4145vh) {
        this.e.remove(c4145vh);
        notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        List list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public Filter getFilter() {
        if (this.g == null) {
            this.g = new b();
        }
        return this.g;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return this.e.indexOf(getItem(i));
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        String strTrim;
        c cVar = new c();
        View viewInflate = this.b.inflate(this.c, (ViewGroup) null);
        cVar.a = (TextView) viewInflate.findViewById(R.id.id);
        cVar.b = (TextView) viewInflate.findViewById(R.id.f1);
        cVar.c = (TextView) viewInflate.findViewById(R.id.f2);
        cVar.d = (TextView) viewInflate.findViewById(R.id.f3);
        cVar.e = (TextView) viewInflate.findViewById(R.id.f4);
        cVar.f = (TextView) viewInflate.findViewById(R.id.f5);
        int i2 = this.d;
        if (i2 == 1 || i2 == 2) {
            cVar.j = (ImageView) viewInflate.findViewById(R.id.more);
        } else if (i2 == 3 || i2 == 4 || i2 == 5) {
            cVar.g = (TextView) viewInflate.findViewById(R.id.f6);
            cVar.h = (TextView) viewInflate.findViewById(R.id.f7);
            cVar.i = (TextView) viewInflate.findViewById(R.id.f8);
        }
        int i3 = this.d;
        if (i3 == 6 || i3 == 7) {
            cVar.j = (ImageView) viewInflate.findViewById(R.id.more);
            cVar.g = (TextView) viewInflate.findViewById(R.id.f6);
            cVar.h = (TextView) viewInflate.findViewById(R.id.f7);
            cVar.i = (TextView) viewInflate.findViewById(R.id.f8);
            cVar.j.setImageResource(this.j);
        }
        viewInflate.setTag(cVar);
        viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        cVar.a.setText(((C4145vh) this.e.get(i)).v());
        cVar.b.setText(((C4145vh) this.e.get(i)).a());
        cVar.c.setText(((C4145vh) this.e.get(i)).n());
        cVar.d.setText(((C4145vh) this.e.get(i)).o());
        cVar.e.setText(((C4145vh) this.e.get(i)).p());
        cVar.f.setText(((C4145vh) this.e.get(i)).q());
        try {
            strTrim = ((C4145vh) this.e.get(i)).a().toLowerCase(Locale.getDefault()).trim();
        } catch (Exception unused) {
            strTrim = "";
        }
        String str = this.h;
        if (str != null && !str.isEmpty() && strTrim.contains(this.h)) {
            int iIndexOf = strTrim.indexOf(this.h);
            int length = this.h.length() + iIndexOf;
            Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(cVar.b.getText());
            spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
            cVar.b.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
        }
        if (this.l.contains(Integer.valueOf(i))) {
            viewInflate.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
        } else {
            viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        return viewInflate;
    }
}
