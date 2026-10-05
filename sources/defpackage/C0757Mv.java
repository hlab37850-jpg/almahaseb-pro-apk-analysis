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
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: Mv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0757Mv extends ArrayAdapter implements Filterable {
    public Context a;
    public LayoutInflater b;
    public int c;
    public List d;
    public List e;
    public b f;
    public String g;
    public SparseBooleanArray h;
    public ArrayList i;

    /* JADX INFO: renamed from: Mv$b */
    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            C0757Mv.this.g = charSequence.toString();
            if (charSequence.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < C0757Mv.this.e.size(); i++) {
                    if (((XF) C0757Mv.this.e.get(i)).c().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                        arrayList.add(new XF(((XF) C0757Mv.this.e.get(i)).b(), ((XF) C0757Mv.this.e.get(i)).c(), "", "", ((XF) C0757Mv.this.e.get(i)).a(), ""));
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            } else {
                filterResults.count = C0757Mv.this.e.size();
                filterResults.values = C0757Mv.this.e;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            C0757Mv c0757Mv = C0757Mv.this;
            c0757Mv.d = (ArrayList) filterResults.values;
            c0757Mv.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: Mv$c */
    public class c {
        public TextView a;
        public CheckBox b;
        public ImageView c;
        public ImageView d;

        public c() {
        }
    }

    public C0757Mv(Context context, int i, List list) {
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
    public XF getItem(int i) {
        return (XF) this.d.get(i);
    }

    public SparseBooleanArray b() {
        return this.h;
    }

    @Override // android.widget.ArrayAdapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void remove(XF xf) {
        this.d.remove(xf);
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
        c cVar = new c();
        View viewInflate = this.b.inflate(this.c, (ViewGroup) null);
        cVar.a = (TextView) viewInflate.findViewById(R.id.page_name);
        int i2 = this.c;
        if (i2 == R.layout.page_det_row3) {
            cVar.b = (CheckBox) viewInflate.findViewById(R.id.page_enable);
        } else if (i2 == R.layout.cat_det_row3) {
            cVar.d = (ImageView) viewInflate.findViewById(R.id.page_enable);
        }
        cVar.c = (ImageView) viewInflate.findViewById(R.id.page_delete);
        viewInflate.setTag(cVar);
        viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        cVar.a.setText(((XF) this.d.get(i)).c());
        int i3 = this.c;
        if (i3 == R.layout.page_det_row3) {
            if (((XF) this.d.get(i)).a().equals("1")) {
                cVar.b.setChecked(true);
            } else {
                cVar.b.setChecked(false);
            }
        } else if (i3 == R.layout.cat_det_row3) {
            if (((XF) this.d.get(i)).a().equals("1")) {
                cVar.d.setImageResource(android.R.drawable.btn_star_big_on);
                cVar.d.setTag(Integer.valueOf(android.R.drawable.btn_star_big_on));
            } else {
                cVar.d.setImageResource(android.R.drawable.btn_star_big_off);
                cVar.d.setTag(Integer.valueOf(android.R.drawable.btn_star_big_off));
            }
        }
        String lowerCase = ((XF) this.d.get(i)).c().toLowerCase(Locale.getDefault());
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
