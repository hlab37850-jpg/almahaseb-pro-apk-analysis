package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.preference.PreferenceManager;
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
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: renamed from: y1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4330y1 extends PagingDataAdapter implements Filterable {
    public Context a;
    public List b;
    public d c;
    public String d;
    public boolean e;
    public SparseBooleanArray f;
    public ArrayList g;
    public int[] h;
    public Bitmap i;
    public Bitmap j;
    public C0563Ha k;
    public c l;
    public DE n;

    /* JADX INFO: renamed from: y1$a */
    public class a implements View.OnLongClickListener {
        public final /* synthetic */ e a;

        public a(e eVar) {
            this.a = eVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (C4330y1.this.l == null) {
                return true;
            }
            C4330y1.this.l.a(this.a.getAdapterPosition());
            return true;
        }
    }

    /* JADX INFO: renamed from: y1$b */
    public class b implements View.OnClickListener {
        public final /* synthetic */ C4064uh a;
        public final /* synthetic */ e b;

        public b(C4064uh c4064uh, e eVar) {
            this.a = c4064uh;
            this.b = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C4330y1.this.n != null && C4330y1.this.d() == 0) {
                C4330y1.this.n.c(1, this.a);
            } else {
                if (C4330y1.this.d() == 0 || C4330y1.this.l == null) {
                    return;
                }
                C4330y1.this.l.a(this.b.getAdapterPosition());
            }
        }
    }

    /* JADX INFO: renamed from: y1$c */
    public interface c {
        void a(int i);
    }

    /* JADX INFO: renamed from: y1$d */
    public class d extends Filter {
        public d() {
        }

        public final /* synthetic */ boolean f(C4064uh c4064uh) {
            return c4064uh.r().toLowerCase().contains(C4330y1.this.d);
        }

        public final /* synthetic */ boolean g(C4064uh c4064uh) {
            return c4064uh.n().replace(",", "").contains(C4330y1.this.d);
        }

        public final /* synthetic */ boolean h(C4064uh c4064uh) {
            return c4064uh.p().contains(C4330y1.this.d);
        }

        public final /* synthetic */ boolean i(C4064uh c4064uh) {
            return (c4064uh.r().toLowerCase() + c4064uh.n().replace(",", "") + c4064uh.p()).contains(C4330y1.this.d);
        }

        public final /* synthetic */ boolean j(C4064uh c4064uh) {
            return (c4064uh.r().toLowerCase() + c4064uh.n().replace(",", "") + c4064uh.p()).contains(C4330y1.this.d);
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            ArrayList arrayListNewArrayList;
            Filter.FilterResults filterResults = new Filter.FilterResults();
            Executors.newSingleThreadExecutor();
            C4330y1.this.d = charSequence.toString().toLowerCase();
            Log.d("filter=", "start..:" + C4330y1.this.d);
            if (charSequence.length() > 0) {
                new ArrayList();
                Predicate predicate = new Predicate() { // from class: I1
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return this.a.f((C4064uh) obj);
                    }
                };
                Predicate predicate2 = new Predicate() { // from class: G1
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return this.a.g((C4064uh) obj);
                    }
                };
                Predicate predicate3 = new Predicate() { // from class: H1
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return this.a.h((C4064uh) obj);
                    }
                };
                if (Build.VERSION.SDK_INT >= 24) {
                    arrayListNewArrayList = (ArrayList) D1.a(C4330y1.this.b.stream().parallel()).filter(predicate.or(predicate2).or(predicate3)).collect(Collectors.toList());
                } else {
                    new Predicate() { // from class: J1
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return this.a.i((C4064uh) obj);
                        }
                    };
                    arrayListNewArrayList = Lists.newArrayList(FluentIterable.from(C4330y1.this.b).filter(new com.google.common.base.Predicate() { // from class: K1
                        @Override // com.google.common.base.Predicate
                        public final boolean apply(Object obj) {
                            return this.a.j((C4064uh) obj);
                        }
                    }).toList());
                }
                Log.d("filter=", "end..:" + arrayListNewArrayList.size());
                filterResults.count = arrayListNewArrayList.size();
                filterResults.values = arrayListNewArrayList;
            } else {
                filterResults.count = C4330y1.this.b.size();
                filterResults.values = C4330y1.this.b;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            try {
                C4330y1.this.notifyDataSetChanged();
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ d(C4330y1 c4330y1, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: y1$e */
    public static class e extends RecyclerView.ViewHolder {
        public C0563Ha a;
        public int b;

        public e(C0563Ha c0563Ha) {
            super(c0563Ha.getRoot());
            this.a = c0563Ha;
        }
    }

    public C4330y1(Context context, List list, DE de, c cVar) {
        super(new C4226wh());
        this.d = "";
        this.e = false;
        this.g = new ArrayList();
        this.h = new int[]{R.drawable.up, 1, R.drawable.down};
        this.f = new SparseBooleanArray();
        this.a = context;
        this.b = list;
        this.n = de;
        this.l = cVar;
        this.i = ((BitmapDrawable) context.getResources().getDrawable(this.h[0])).getBitmap();
        this.j = ((BitmapDrawable) context.getResources().getDrawable(this.h[2])).getBitmap();
        this.e = f("prefOthers_tr_time", true);
    }

    public List c() {
        return snapshot().getItems();
    }

    public int d() {
        return this.f.size();
    }

    public SparseBooleanArray e() {
        return this.f;
    }

    public boolean f(String str, boolean z) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(this.a).getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(e eVar, int i) {
        int adapterPosition = eVar.getAdapterPosition();
        C4064uh c4064uh = (C4064uh) getItem(i);
        eVar.a.h.setText(c4064uh.q());
        eVar.a.g.setText(c4064uh.p());
        eVar.a.j.setText(c4064uh.s());
        if (!this.e || c4064uh.s().length() <= 4) {
            eVar.a.j.setVisibility(8);
        } else {
            eVar.a.j.setVisibility(0);
            eVar.a.j.setText(c4064uh.s().substring(0, 5));
        }
        eVar.a.e.setText(c4064uh.n());
        eVar.a.i.setText(c4064uh.r());
        eVar.a.f.setText(c4064uh.f());
        eVar.b = adapterPosition;
        C4192wG.n(this.a).i(c4064uh.t()).c(eVar.a.c);
        eVar.a.c.setTag(Integer.valueOf(c4064uh.t()));
        eVar.a.i.setTag(c4064uh.o());
        eVar.a.e.setTag(c4064uh.b());
        try {
            if (c4064uh.r() != null) {
                String lowerCase = c4064uh.r().toLowerCase(Locale.getDefault());
                String str = this.d;
                if (str != null && !str.isEmpty() && lowerCase.contains(this.d)) {
                    int iIndexOf = lowerCase.indexOf(this.d);
                    int length = this.d.length() + iIndexOf;
                    Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(eVar.a.i.getText());
                    spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
                    eVar.a.i.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
                }
                String lowerCase2 = c4064uh.p().toLowerCase(Locale.getDefault());
                if (lowerCase2.contains(this.d)) {
                    int iIndexOf2 = lowerCase2.indexOf(this.d);
                    int length2 = this.d.length() + iIndexOf2;
                    Spannable spannableNewSpannable2 = Spannable.Factory.getInstance().newSpannable(eVar.a.g.getText());
                    spannableNewSpannable2.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf2, length2, 33);
                    eVar.a.g.setText(spannableNewSpannable2, TextView.BufferType.SPANNABLE);
                }
                String lowerCase3 = c4064uh.n().replaceAll(",", "").toLowerCase(Locale.getDefault());
                if (lowerCase3.contains(this.d)) {
                    int iIndexOf3 = lowerCase3.indexOf(this.d);
                    int length3 = this.d.length() + iIndexOf3;
                    String string = eVar.a.e.getText().toString();
                    int length4 = string.length() - string.replaceAll(",", "").length();
                    if (this.d.length() > 0) {
                        Spannable spannableNewSpannable3 = Spannable.Factory.getInstance().newSpannable(string);
                        spannableNewSpannable3.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf3, length3 + length4, 33);
                        eVar.a.e.setText(spannableNewSpannable3, TextView.BufferType.SPANNABLE);
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (this.g.contains(Integer.valueOf(eVar.getAdapterPosition()))) {
            eVar.a.d.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
        } else {
            eVar.a.d.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        eVar.itemView.setOnLongClickListener(new a(eVar));
        eVar.itemView.setOnClickListener(new b(c4064uh, eVar));
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.c == null) {
            this.c = new d(this, null);
        }
        return this.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public e onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.k = C0563Ha.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new e(this.k);
    }

    public void i(C4064uh c4064uh) {
        notifyDataSetChanged();
    }

    public void j() {
        this.f = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void k(int i, boolean z) {
        if (z) {
            this.f.put(i, z);
        } else {
            this.f.delete(i);
        }
        notifyItemChanged(i);
    }

    public void l(List list) {
        this.b = list;
    }

    public void m(int i) {
        if (this.g.contains(Integer.valueOf(i))) {
            this.g.remove(Integer.valueOf(i));
        } else {
            this.g.add(Integer.valueOf(i));
        }
        k(i, !this.f.get(i));
    }
}
