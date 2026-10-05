package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.api.client.util.Lists;
import com.google.common.collect.FluentIterable;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes3.dex */
public class L1 extends PagingDataAdapter implements Filterable {
    public Context a;
    public List b;
    public b c;
    public String d;
    public SparseBooleanArray e;
    public ArrayList f;
    public C4330y1.c g;
    public DE h;
    public C0589Ia i;

    public class a implements View.OnLongClickListener {
        public final /* synthetic */ c a;

        public a(c cVar) {
            this.a = cVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (L1.this.g == null) {
                return true;
            }
            L1.this.g.a(this.a.getAdapterPosition());
            return true;
        }
    }

    public class b extends Filter {
        public b() {
        }

        public final /* synthetic */ boolean g(C0795Oh c0795Oh) {
            return c0795Oh.q().toLowerCase().contains(L1.this.d);
        }

        public final /* synthetic */ boolean h(C0795Oh c0795Oh) {
            return c0795Oh.l().replace(",", "").contains(L1.this.d);
        }

        public final /* synthetic */ boolean i(C0795Oh c0795Oh) {
            return c0795Oh.n().contains(L1.this.d);
        }

        public final /* synthetic */ boolean j(C0795Oh c0795Oh) {
            return c0795Oh.p().toLowerCase().contains(L1.this.d);
        }

        public final /* synthetic */ boolean k(C0795Oh c0795Oh) {
            return (c0795Oh.q().toLowerCase() + c0795Oh.p() + c0795Oh.l().replace(",", "") + c0795Oh.n()).contains(L1.this.d);
        }

        public final /* synthetic */ boolean l(C0795Oh c0795Oh) {
            return (c0795Oh.q().toLowerCase() + c0795Oh.p() + c0795Oh.l().replace(",", "") + c0795Oh.n()).contains(L1.this.d);
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            ArrayList arrayListNewArrayList;
            Filter.FilterResults filterResults = new Filter.FilterResults();
            L1.this.d = charSequence.toString().toLowerCase();
            String string = charSequence.toString();
            if (string == null || string.length() <= 0) {
                filterResults.count = L1.this.b.size();
                filterResults.values = L1.this.b;
            } else {
                new ArrayList();
                Log.d("filter=", "start..:" + L1.this.d);
                Predicate predicate = new Predicate() { // from class: M1
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return this.a.g((C0795Oh) obj);
                    }
                };
                Predicate predicate2 = new Predicate() { // from class: P1
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return this.a.h((C0795Oh) obj);
                    }
                };
                Predicate predicate3 = new Predicate() { // from class: Q1
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return this.a.i((C0795Oh) obj);
                    }
                };
                Predicate predicate4 = new Predicate() { // from class: R1
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return this.a.j((C0795Oh) obj);
                    }
                };
                if (Build.VERSION.SDK_INT >= 24) {
                    arrayListNewArrayList = (ArrayList) D1.a(L1.this.b.stream().parallel()).filter(predicate.or(predicate2).or(predicate3).or(predicate4)).collect(Collectors.toList());
                } else {
                    new Predicate() { // from class: N1
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return this.a.k((C0795Oh) obj);
                        }
                    };
                    arrayListNewArrayList = Lists.newArrayList(FluentIterable.from(L1.this.b).filter(new com.google.common.base.Predicate() { // from class: O1
                        @Override // com.google.common.base.Predicate
                        public final boolean apply(Object obj) {
                            return this.a.l((C0795Oh) obj);
                        }
                    }).toList());
                }
                Log.d("filter=", "end..:" + arrayListNewArrayList.size());
                filterResults.count = arrayListNewArrayList.size();
                filterResults.values = arrayListNewArrayList;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            L1.this.notifyDataSetChanged();
        }

        public /* synthetic */ b(L1 l1, a aVar) {
            this();
        }
    }

    public static class c extends RecyclerView.ViewHolder {
        public C0589Ia a;

        public c(C0589Ia c0589Ia) {
            super(c0589Ia.getRoot());
            this.a = c0589Ia;
        }
    }

    public L1(Context context, List list, DE de, C4330y1.c cVar) {
        super(new C0544Gh());
        this.d = "";
        this.f = new ArrayList();
        this.e = new SparseBooleanArray();
        this.a = context;
        this.h = de;
        this.g = cVar;
    }

    public List b() {
        return snapshot().getItems();
    }

    public int c() {
        return this.e.size();
    }

    public SparseBooleanArray d() {
        return this.e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i) {
        int adapterPosition = cVar.getAdapterPosition();
        C0795Oh c0795Oh = (C0795Oh) getItem(i);
        cVar.a.d.setBackgroundColor(Color.parseColor("#FFFFFF"));
        cVar.a.g.setText(c0795Oh.o());
        cVar.a.f.setText(c0795Oh.n());
        cVar.a.e.setText(c0795Oh.l());
        cVar.a.i.setText(c0795Oh.q());
        cVar.a.h.setText(c0795Oh.p());
        C4192wG.n(this.a).i(c0795Oh.r()).c(cVar.a.c);
        String lowerCase = c0795Oh.q().toLowerCase(Locale.getDefault());
        String str = this.d;
        if (str != null && !str.isEmpty()) {
            if (lowerCase.contains(this.d)) {
                int iIndexOf = lowerCase.indexOf(this.d);
                int length = this.d.length() + iIndexOf;
                Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(cVar.a.i.getText());
                spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
                cVar.a.i.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
            }
            String lowerCase2 = c0795Oh.p().toLowerCase(Locale.getDefault());
            if (lowerCase2.contains(this.d)) {
                int iIndexOf2 = lowerCase2.indexOf(this.d);
                int length2 = this.d.length() + iIndexOf2;
                Spannable spannableNewSpannable2 = Spannable.Factory.getInstance().newSpannable(cVar.a.h.getText());
                spannableNewSpannable2.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf2, length2, 33);
                cVar.a.h.setText(spannableNewSpannable2, TextView.BufferType.SPANNABLE);
            }
            String lowerCase3 = c0795Oh.n().toLowerCase(Locale.getDefault());
            if (lowerCase3.contains(this.d)) {
                int iIndexOf3 = lowerCase3.indexOf(this.d);
                int length3 = this.d.length() + iIndexOf3;
                Spannable spannableNewSpannable3 = Spannable.Factory.getInstance().newSpannable(cVar.a.f.getText());
                spannableNewSpannable3.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf3, length3, 33);
                cVar.a.f.setText(spannableNewSpannable3, TextView.BufferType.SPANNABLE);
            }
            String lowerCase4 = c0795Oh.l().replaceAll(",", "").toLowerCase(Locale.getDefault());
            if (lowerCase4.contains(this.d)) {
                int iIndexOf4 = lowerCase4.indexOf(this.d);
                int length4 = this.d.length() + iIndexOf4;
                String string = cVar.a.e.getText().toString();
                int length5 = string.length() - string.replaceAll(",", "").length();
                if (this.d.length() > 0) {
                    Spannable spannableNewSpannable4 = Spannable.Factory.getInstance().newSpannable(string);
                    spannableNewSpannable4.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf4, length4 + length5, 33);
                    cVar.a.e.setText(spannableNewSpannable4, TextView.BufferType.SPANNABLE);
                }
            }
        }
        if (this.f.contains(Integer.valueOf(adapterPosition))) {
            cVar.a.d.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
        } else {
            cVar.a.d.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        cVar.itemView.setOnLongClickListener(new a(cVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.i = C0589Ia.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new c(this.i);
    }

    public void g(C0795Oh c0795Oh) {
        notifyDataSetChanged();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.c == null) {
            this.c = new b(this, null);
        }
        return this.c;
    }

    public void h() {
        this.e = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void i(int i, boolean z) {
        if (z) {
            this.e.put(i, z);
        } else {
            this.e.delete(i);
        }
        notifyDataSetChanged();
    }

    public void j(List list) {
        notifyDataSetChanged();
    }

    public void k(String str) {
        this.d = str;
    }

    public void l(List list) {
        this.b = list;
    }

    public void m(int i) {
        if (this.f.contains(Integer.valueOf(i))) {
            this.f.remove(Integer.valueOf(i));
        } else {
            this.f.add(Integer.valueOf(i));
        }
        i(i, !this.e.get(i));
    }
}
