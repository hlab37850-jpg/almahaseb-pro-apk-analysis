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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import info.aalmoghalis.inventory.R;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: Uv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0978Uv extends ArrayAdapter implements Filterable {
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
    public boolean n;
    public boolean p;
    public int q;

    /* JADX INFO: renamed from: Uv$b */
    public class b extends Filter {
        public b() {
        }

        /* JADX WARN: Code duplicated, block: B:40:0x0167  */
        /* JADX WARN: Code duplicated, block: B:76:0x0360  */
        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            C0978Uv.this.h = charSequence.toString();
            if (charSequence.length() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                if (Z00.i0.size() == 0) {
                    while (i < C0978Uv.this.f.size()) {
                        if (((C4145vh) C0978Uv.this.f.get(i)).a().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C4145vh) C0978Uv.this.f.get(i)).n().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                            arrayList.add(new C4145vh(((C4145vh) C0978Uv.this.f.get(i)).v(), ((C4145vh) C0978Uv.this.f.get(i)).a(), ((C4145vh) C0978Uv.this.f.get(i)).n(), ((C4145vh) C0978Uv.this.f.get(i)).o(), ((C4145vh) C0978Uv.this.f.get(i)).p(), ((C4145vh) C0978Uv.this.f.get(i)).q(), ((C4145vh) C0978Uv.this.f.get(i)).r(), ((C4145vh) C0978Uv.this.f.get(i)).s(), ((C4145vh) C0978Uv.this.f.get(i)).t(), ((C4145vh) C0978Uv.this.f.get(i)).u(), ((C4145vh) C0978Uv.this.f.get(i)).b(), ((C4145vh) C0978Uv.this.f.get(i)).c(), ((C4145vh) C0978Uv.this.f.get(i)).e(), ((C4145vh) C0978Uv.this.f.get(i)).f()));
                        } else {
                            if ((((C4145vh) C0978Uv.this.f.get(i)).o().length() > 0 ? ((C4145vh) C0978Uv.this.f.get(i)).o().toUpperCase() : "").contains(charSequence.toString().toUpperCase())) {
                                arrayList.add(new C4145vh(((C4145vh) C0978Uv.this.f.get(i)).v(), ((C4145vh) C0978Uv.this.f.get(i)).a(), ((C4145vh) C0978Uv.this.f.get(i)).n(), ((C4145vh) C0978Uv.this.f.get(i)).o(), ((C4145vh) C0978Uv.this.f.get(i)).p(), ((C4145vh) C0978Uv.this.f.get(i)).q(), ((C4145vh) C0978Uv.this.f.get(i)).r(), ((C4145vh) C0978Uv.this.f.get(i)).s(), ((C4145vh) C0978Uv.this.f.get(i)).t(), ((C4145vh) C0978Uv.this.f.get(i)).u(), ((C4145vh) C0978Uv.this.f.get(i)).b(), ((C4145vh) C0978Uv.this.f.get(i)).c(), ((C4145vh) C0978Uv.this.f.get(i)).e(), ((C4145vh) C0978Uv.this.f.get(i)).f()));
                            } else {
                                if ((((C4145vh) C0978Uv.this.f.get(i)).p().length() > 0 ? ((C4145vh) C0978Uv.this.f.get(i)).p().toUpperCase() : "").contains(charSequence.toString().toUpperCase())) {
                                    arrayList.add(new C4145vh(((C4145vh) C0978Uv.this.f.get(i)).v(), ((C4145vh) C0978Uv.this.f.get(i)).a(), ((C4145vh) C0978Uv.this.f.get(i)).n(), ((C4145vh) C0978Uv.this.f.get(i)).o(), ((C4145vh) C0978Uv.this.f.get(i)).p(), ((C4145vh) C0978Uv.this.f.get(i)).q(), ((C4145vh) C0978Uv.this.f.get(i)).r(), ((C4145vh) C0978Uv.this.f.get(i)).s(), ((C4145vh) C0978Uv.this.f.get(i)).t(), ((C4145vh) C0978Uv.this.f.get(i)).u(), ((C4145vh) C0978Uv.this.f.get(i)).b(), ((C4145vh) C0978Uv.this.f.get(i)).c(), ((C4145vh) C0978Uv.this.f.get(i)).e(), ((C4145vh) C0978Uv.this.f.get(i)).f()));
                                } else {
                                    if (((((C4145vh) C0978Uv.this.f.get(i)).q() == null || ((C4145vh) C0978Uv.this.f.get(i)).q().length() <= 0) ? "" : ((C4145vh) C0978Uv.this.f.get(i)).q().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                                        arrayList.add(new C4145vh(((C4145vh) C0978Uv.this.f.get(i)).v(), ((C4145vh) C0978Uv.this.f.get(i)).a(), ((C4145vh) C0978Uv.this.f.get(i)).n(), ((C4145vh) C0978Uv.this.f.get(i)).o(), ((C4145vh) C0978Uv.this.f.get(i)).p(), ((C4145vh) C0978Uv.this.f.get(i)).q(), ((C4145vh) C0978Uv.this.f.get(i)).r(), ((C4145vh) C0978Uv.this.f.get(i)).s(), ((C4145vh) C0978Uv.this.f.get(i)).t(), ((C4145vh) C0978Uv.this.f.get(i)).u(), ((C4145vh) C0978Uv.this.f.get(i)).b(), ((C4145vh) C0978Uv.this.f.get(i)).c(), ((C4145vh) C0978Uv.this.f.get(i)).e(), ((C4145vh) C0978Uv.this.f.get(i)).f()));
                                    } else {
                                        if (((((C4145vh) C0978Uv.this.f.get(i)).r() == null || ((C4145vh) C0978Uv.this.f.get(i)).r().length() <= 0) ? "" : ((C4145vh) C0978Uv.this.f.get(i)).r().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                                            arrayList.add(new C4145vh(((C4145vh) C0978Uv.this.f.get(i)).v(), ((C4145vh) C0978Uv.this.f.get(i)).a(), ((C4145vh) C0978Uv.this.f.get(i)).n(), ((C4145vh) C0978Uv.this.f.get(i)).o(), ((C4145vh) C0978Uv.this.f.get(i)).p(), ((C4145vh) C0978Uv.this.f.get(i)).q(), ((C4145vh) C0978Uv.this.f.get(i)).r(), ((C4145vh) C0978Uv.this.f.get(i)).s(), ((C4145vh) C0978Uv.this.f.get(i)).t(), ((C4145vh) C0978Uv.this.f.get(i)).u(), ((C4145vh) C0978Uv.this.f.get(i)).b(), ((C4145vh) C0978Uv.this.f.get(i)).c(), ((C4145vh) C0978Uv.this.f.get(i)).e(), ((C4145vh) C0978Uv.this.f.get(i)).f()));
                                        }
                                    }
                                }
                            }
                        }
                        i++;
                    }
                } else {
                    while (i < Z00.i0.size()) {
                        if (((C4145vh) Z00.i0.get(i)).a().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C4145vh) Z00.i0.get(i)).n().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                            arrayList.add(new C4145vh(((C4145vh) Z00.i0.get(i)).v(), ((C4145vh) Z00.i0.get(i)).a(), ((C4145vh) Z00.i0.get(i)).n(), ((C4145vh) Z00.i0.get(i)).o(), ((C4145vh) Z00.i0.get(i)).p(), ((C4145vh) Z00.i0.get(i)).q(), ((C4145vh) Z00.i0.get(i)).r(), ((C4145vh) Z00.i0.get(i)).s(), ((C4145vh) Z00.i0.get(i)).t(), ((C4145vh) Z00.i0.get(i)).u(), ((C4145vh) Z00.i0.get(i)).b(), ((C4145vh) Z00.i0.get(i)).c(), ((C4145vh) Z00.i0.get(i)).e(), ((C4145vh) Z00.i0.get(i)).f()));
                        } else {
                            if ((((C4145vh) Z00.i0.get(i)).o().length() > 0 ? ((C4145vh) Z00.i0.get(i)).o().toUpperCase() : "").contains(charSequence.toString().toUpperCase())) {
                                arrayList.add(new C4145vh(((C4145vh) Z00.i0.get(i)).v(), ((C4145vh) Z00.i0.get(i)).a(), ((C4145vh) Z00.i0.get(i)).n(), ((C4145vh) Z00.i0.get(i)).o(), ((C4145vh) Z00.i0.get(i)).p(), ((C4145vh) Z00.i0.get(i)).q(), ((C4145vh) Z00.i0.get(i)).r(), ((C4145vh) Z00.i0.get(i)).s(), ((C4145vh) Z00.i0.get(i)).t(), ((C4145vh) Z00.i0.get(i)).u(), ((C4145vh) Z00.i0.get(i)).b(), ((C4145vh) Z00.i0.get(i)).c(), ((C4145vh) Z00.i0.get(i)).e(), ((C4145vh) Z00.i0.get(i)).f()));
                            } else {
                                if ((((C4145vh) Z00.i0.get(i)).p().length() > 0 ? ((C4145vh) Z00.i0.get(i)).p().toUpperCase() : "").contains(charSequence.toString().toUpperCase())) {
                                    arrayList.add(new C4145vh(((C4145vh) Z00.i0.get(i)).v(), ((C4145vh) Z00.i0.get(i)).a(), ((C4145vh) Z00.i0.get(i)).n(), ((C4145vh) Z00.i0.get(i)).o(), ((C4145vh) Z00.i0.get(i)).p(), ((C4145vh) Z00.i0.get(i)).q(), ((C4145vh) Z00.i0.get(i)).r(), ((C4145vh) Z00.i0.get(i)).s(), ((C4145vh) Z00.i0.get(i)).t(), ((C4145vh) Z00.i0.get(i)).u(), ((C4145vh) Z00.i0.get(i)).b(), ((C4145vh) Z00.i0.get(i)).c(), ((C4145vh) Z00.i0.get(i)).e(), ((C4145vh) Z00.i0.get(i)).f()));
                                } else {
                                    if (((((C4145vh) Z00.i0.get(i)).q() == null || ((C4145vh) Z00.i0.get(i)).q().length() <= 0) ? "" : ((C4145vh) Z00.i0.get(i)).q().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                                        arrayList.add(new C4145vh(((C4145vh) Z00.i0.get(i)).v(), ((C4145vh) Z00.i0.get(i)).a(), ((C4145vh) Z00.i0.get(i)).n(), ((C4145vh) Z00.i0.get(i)).o(), ((C4145vh) Z00.i0.get(i)).p(), ((C4145vh) Z00.i0.get(i)).q(), ((C4145vh) Z00.i0.get(i)).r(), ((C4145vh) Z00.i0.get(i)).s(), ((C4145vh) Z00.i0.get(i)).t(), ((C4145vh) Z00.i0.get(i)).u(), ((C4145vh) Z00.i0.get(i)).b(), ((C4145vh) Z00.i0.get(i)).c(), ((C4145vh) Z00.i0.get(i)).e(), ((C4145vh) Z00.i0.get(i)).f()));
                                    } else {
                                        if (((((C4145vh) Z00.i0.get(i)).r() == null || ((C4145vh) Z00.i0.get(i)).r().length() <= 0) ? "" : ((C4145vh) Z00.i0.get(i)).r().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                                            arrayList.add(new C4145vh(((C4145vh) Z00.i0.get(i)).v(), ((C4145vh) Z00.i0.get(i)).a(), ((C4145vh) Z00.i0.get(i)).n(), ((C4145vh) Z00.i0.get(i)).o(), ((C4145vh) Z00.i0.get(i)).p(), ((C4145vh) Z00.i0.get(i)).q(), ((C4145vh) Z00.i0.get(i)).r(), ((C4145vh) Z00.i0.get(i)).s(), ((C4145vh) Z00.i0.get(i)).t(), ((C4145vh) Z00.i0.get(i)).u(), ((C4145vh) Z00.i0.get(i)).b(), ((C4145vh) Z00.i0.get(i)).c(), ((C4145vh) Z00.i0.get(i)).e(), ((C4145vh) Z00.i0.get(i)).f()));
                                        }
                                    }
                                }
                            }
                        }
                        i++;
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            } else {
                filterResults.count = C0978Uv.this.f.size();
                filterResults.values = C0978Uv.this.f;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            C0978Uv c0978Uv = C0978Uv.this;
            c0978Uv.e = (ArrayList) filterResults.values;
            c0978Uv.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: Uv$c */
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

    public C0978Uv(Context context, int i, List list, int i2) {
        super(context, i, list);
        this.h = "";
        this.i = new int[]{R.drawable.up, 1, R.drawable.down};
        this.j = android.R.drawable.ic_menu_close_clear_cancel;
        this.l = new ArrayList();
        this.n = false;
        this.p = false;
        this.q = 0;
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

    public SparseBooleanArray b() {
        return this.k;
    }

    public String c(String str) {
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(str));
    }

    @Override // android.widget.ArrayAdapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void remove(C4145vh c4145vh) {
        this.e.remove(c4145vh);
        notifyDataSetChanged();
    }

    public void e() {
        this.k = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void f(int i, boolean z) {
        if (z) {
            this.k.put(i, z);
        } else {
            this.k.delete(i);
        }
        notifyDataSetChanged();
    }

    public void g(int i) {
        if (this.l.contains(Integer.valueOf(i))) {
            this.l.remove(Integer.valueOf(i));
        } else {
            this.l.add(Integer.valueOf(i));
        }
        f(i, !this.k.get(i));
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.e.size();
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
        c cVar;
        View viewInflate;
        String lowerCase;
        String lowerCase2;
        String lowerCase3;
        String lowerCase4 = "";
        if (view == null) {
            cVar = new c();
            viewInflate = this.b.inflate(this.c, (ViewGroup) null);
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
        } else {
            cVar = (c) view.getTag();
            viewInflate = view;
        }
        cVar.a.setText(((C4145vh) this.e.get(i)).v());
        cVar.b.setText(((C4145vh) this.e.get(i)).a());
        cVar.c.setText(((C4145vh) this.e.get(i)).n());
        cVar.d.setText(((C4145vh) this.e.get(i)).o());
        cVar.e.setText(((C4145vh) this.e.get(i)).p());
        cVar.f.setText(((C4145vh) this.e.get(i)).q());
        int i4 = this.d;
        if (i4 == 1) {
            cVar.f.setVisibility(8);
            cVar.e.setText(c(((C4145vh) this.e.get(i)).p()));
            cVar.j.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.b.getLayoutParams();
            layoutParams.weight = 20.0f;
            cVar.b.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.c.getLayoutParams();
            layoutParams2.weight = 40.0f;
            cVar.c.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) cVar.d.getLayoutParams();
            layoutParams3.weight = 23.0f;
            cVar.d.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) cVar.e.getLayoutParams();
            layoutParams4.weight = 37.0f;
            cVar.e.setLayoutParams(layoutParams4);
        } else if (i4 == 2) {
            cVar.f.setVisibility(8);
            cVar.c.setText(c(((C4145vh) this.e.get(i)).n()));
            cVar.d.setText(c(((C4145vh) this.e.get(i)).o()));
            cVar.e.setText(c(((C4145vh) this.e.get(i)).p()));
            cVar.j.setVisibility(0);
            cVar.j.setImageResource(this.i[Integer.parseInt(((C4145vh) this.e.get(i)).q())]);
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) cVar.b.getLayoutParams();
            layoutParams5.weight = 30.0f;
            cVar.b.setLayoutParams(layoutParams5);
            LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) cVar.c.getLayoutParams();
            layoutParams6.weight = 30.0f;
            cVar.c.setLayoutParams(layoutParams6);
            LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) cVar.d.getLayoutParams();
            layoutParams7.weight = 30.0f;
            cVar.d.setLayoutParams(layoutParams7);
            LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) cVar.e.getLayoutParams();
            layoutParams8.weight = 30.0f;
            cVar.e.setLayoutParams(layoutParams8);
        } else if (i4 == 3) {
            cVar.e.setVisibility(8);
            cVar.i.setVisibility(8);
            cVar.g.setText(((C4145vh) this.e.get(i)).r());
            cVar.h.setText(((C4145vh) this.e.get(i)).s());
            cVar.i.setText(((C4145vh) this.e.get(i)).t());
            LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) cVar.b.getLayoutParams();
            layoutParams9.weight = 40.0f;
            cVar.b.setLayoutParams(layoutParams9);
            LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) cVar.c.getLayoutParams();
            layoutParams10.weight = 40.0f;
            cVar.c.setLayoutParams(layoutParams10);
            LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) cVar.d.getLayoutParams();
            layoutParams11.weight = 40.0f;
            cVar.d.setLayoutParams(layoutParams11);
            LinearLayout.LayoutParams layoutParams12 = (LinearLayout.LayoutParams) cVar.f.getLayoutParams();
            layoutParams12.weight = 40.0f;
            cVar.f.setLayoutParams(layoutParams12);
            LinearLayout.LayoutParams layoutParams13 = (LinearLayout.LayoutParams) cVar.g.getLayoutParams();
            layoutParams13.weight = 40.0f;
            cVar.g.setLayoutParams(layoutParams13);
            LinearLayout.LayoutParams layoutParams14 = (LinearLayout.LayoutParams) cVar.g.getLayoutParams();
            layoutParams14.weight = 40.0f;
            cVar.h.setLayoutParams(layoutParams14);
        } else if (i4 == 4) {
            if (this.n) {
                int i5 = this.q;
                if (i5 == 4) {
                    cVar.e.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams15 = (LinearLayout.LayoutParams) cVar.c.getLayoutParams();
                    layoutParams15.weight = 40.0f;
                    cVar.c.setLayoutParams(layoutParams15);
                } else if (i5 == 1) {
                    cVar.b.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams16 = (LinearLayout.LayoutParams) cVar.c.getLayoutParams();
                    layoutParams16.weight = 60.0f;
                    cVar.c.setLayoutParams(layoutParams16);
                }
            }
            if (this.p) {
                cVar.g.setVisibility(8);
                LinearLayout.LayoutParams layoutParams17 = (LinearLayout.LayoutParams) cVar.d.getLayoutParams();
                layoutParams17.weight = 40.0f;
                cVar.d.setLayoutParams(layoutParams17);
            }
            cVar.g.setText(((C4145vh) this.e.get(i)).r());
            cVar.h.setText(((C4145vh) this.e.get(i)).s());
            cVar.i.setText(((C4145vh) this.e.get(i)).t());
        } else if (i4 == 5) {
            cVar.i.setVisibility(8);
            cVar.g.setText(((C4145vh) this.e.get(i)).r());
            cVar.h.setText(((C4145vh) this.e.get(i)).s());
            cVar.i.setText(((C4145vh) this.e.get(i)).t());
            if (((C4145vh) this.e.get(i)).q().equals("1")) {
                cVar.b.setTextColor(-16776961);
                cVar.c.setTextColor(-16776961);
                cVar.d.setTextColor(-16776961);
                cVar.e.setTextColor(-16776961);
            } else {
                cVar.b.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                cVar.c.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                cVar.d.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                cVar.e.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
        } else if (i4 == 6) {
            cVar.f.setVisibility(8);
            cVar.g.setVisibility(8);
            cVar.h.setVisibility(8);
            cVar.i.setVisibility(8);
            cVar.j.setVisibility(0);
            cVar.j.setImageResource(this.j);
            LinearLayout.LayoutParams layoutParams18 = (LinearLayout.LayoutParams) cVar.b.getLayoutParams();
            layoutParams18.weight = 20.0f;
            cVar.b.setLayoutParams(layoutParams18);
            LinearLayout.LayoutParams layoutParams19 = (LinearLayout.LayoutParams) cVar.c.getLayoutParams();
            layoutParams19.weight = 30.0f;
            cVar.c.setLayoutParams(layoutParams19);
            LinearLayout.LayoutParams layoutParams20 = (LinearLayout.LayoutParams) cVar.d.getLayoutParams();
            layoutParams20.weight = 40.0f;
            cVar.d.setLayoutParams(layoutParams20);
            LinearLayout.LayoutParams layoutParams21 = (LinearLayout.LayoutParams) cVar.e.getLayoutParams();
            layoutParams21.weight = 30.0f;
            cVar.e.setLayoutParams(layoutParams21);
        } else if (i4 == 7) {
            cVar.e.setVisibility(8);
            cVar.i.setVisibility(8);
            cVar.g.setText(((C4145vh) this.e.get(i)).r());
            cVar.h.setText(((C4145vh) this.e.get(i)).s());
            cVar.i.setText(((C4145vh) this.e.get(i)).t());
            cVar.j.setVisibility(0);
            cVar.j.setImageResource(this.j);
            LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) cVar.b.getLayoutParams();
            layoutParams22.weight = 40.0f;
            cVar.b.setLayoutParams(layoutParams22);
            LinearLayout.LayoutParams layoutParams23 = (LinearLayout.LayoutParams) cVar.c.getLayoutParams();
            layoutParams23.weight = 40.0f;
            cVar.c.setLayoutParams(layoutParams23);
            LinearLayout.LayoutParams layoutParams24 = (LinearLayout.LayoutParams) cVar.d.getLayoutParams();
            layoutParams24.weight = 40.0f;
            cVar.d.setLayoutParams(layoutParams24);
            LinearLayout.LayoutParams layoutParams25 = (LinearLayout.LayoutParams) cVar.f.getLayoutParams();
            layoutParams25.weight = 40.0f;
            cVar.f.setLayoutParams(layoutParams25);
            LinearLayout.LayoutParams layoutParams26 = (LinearLayout.LayoutParams) cVar.g.getLayoutParams();
            layoutParams26.weight = 40.0f;
            cVar.g.setLayoutParams(layoutParams26);
            LinearLayout.LayoutParams layoutParams27 = (LinearLayout.LayoutParams) cVar.h.getLayoutParams();
            layoutParams27.weight = 40.0f;
            cVar.h.setLayoutParams(layoutParams27);
        }
        C4145vh c4145vh = (C4145vh) this.e.get(i);
        try {
            lowerCase = c4145vh.a().toLowerCase(Locale.getDefault());
        } catch (Exception unused) {
            lowerCase = "";
        }
        String str = this.h;
        if (str != null && !str.isEmpty() && lowerCase.contains(this.h)) {
            int iIndexOf = lowerCase.indexOf(this.h);
            int length = this.h.length() + iIndexOf;
            Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(cVar.b.getText());
            spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
            cVar.b.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
        }
        try {
            lowerCase2 = c4145vh.n().toLowerCase(Locale.getDefault());
        } catch (Exception unused2) {
            lowerCase2 = "";
        }
        String str2 = this.h;
        if (str2 != null && !str2.isEmpty() && lowerCase2.contains(this.h)) {
            int iIndexOf2 = lowerCase2.indexOf(this.h);
            int length2 = this.h.length() + iIndexOf2;
            Spannable spannableNewSpannable2 = Spannable.Factory.getInstance().newSpannable(cVar.c.getText());
            spannableNewSpannable2.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf2, length2, 33);
            cVar.c.setText(spannableNewSpannable2, TextView.BufferType.SPANNABLE);
        }
        try {
            lowerCase3 = c4145vh.o().length() > 0 ? c4145vh.o().toLowerCase(Locale.getDefault()) : "";
        } catch (Exception unused3) {
        }
        String str3 = this.h;
        if (str3 != null && !str3.isEmpty() && lowerCase3.contains(this.h)) {
            int iIndexOf3 = lowerCase3.indexOf(this.h);
            int length3 = this.h.length() + iIndexOf3;
            Spannable spannableNewSpannable3 = Spannable.Factory.getInstance().newSpannable(cVar.d.getText());
            spannableNewSpannable3.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf3, length3, 33);
            cVar.d.setText(spannableNewSpannable3, TextView.BufferType.SPANNABLE);
        }
        try {
            if (c4145vh.p().length() > 0) {
                lowerCase4 = c4145vh.p().toLowerCase(Locale.getDefault());
            }
        } catch (Exception unused4) {
        }
        String str4 = this.h;
        if (str4 != null && !str4.isEmpty() && lowerCase4.contains(this.h)) {
            int iIndexOf4 = lowerCase4.indexOf(this.h);
            int length4 = this.h.length() + iIndexOf4;
            Spannable spannableNewSpannable4 = Spannable.Factory.getInstance().newSpannable(cVar.e.getText());
            spannableNewSpannable4.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf4, length4, 33);
            cVar.e.setText(spannableNewSpannable4, TextView.BufferType.SPANNABLE);
        }
        if (this.l.contains(Integer.valueOf(i))) {
            viewInflate.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
        } else {
            viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        return viewInflate;
    }

    public C0978Uv(Context context, int i, List list, int i2, boolean z, int i3) {
        super(context, i, list);
        this.h = "";
        this.i = new int[]{R.drawable.up, 1, R.drawable.down};
        this.j = android.R.drawable.ic_menu_close_clear_cancel;
        this.l = new ArrayList();
        this.n = false;
        this.p = false;
        this.q = 0;
        this.k = new SparseBooleanArray();
        this.a = context;
        this.e = list;
        this.f = list;
        this.c = i;
        this.d = i2;
        this.n = z;
        this.q = i3;
        this.b = LayoutInflater.from(context);
    }
}
