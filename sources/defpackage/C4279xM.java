package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.zebra.sdk.util.internal.StringUtilities;
import info.aalmoghalis.inventory.R;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: xM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4279xM extends PagingDataAdapter implements Filterable {
    public static int y;
    public Context a;
    public LayoutInflater b;
    public int c;
    public List d;
    public List e;
    public d f;
    public String g;
    public int[] h;
    public int i;
    public SparseBooleanArray j;
    public ArrayList k;
    public c l;
    public DE n;
    public String p;
    public int q;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public C0685Ka x;

    /* JADX INFO: renamed from: xM$a */
    public class a implements View.OnLongClickListener {
        public final /* synthetic */ e a;

        public a(e eVar) {
            this.a = eVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (C4279xM.this.l == null) {
                return true;
            }
            C4279xM.this.l.a(this.a.getAdapterPosition());
            return true;
        }
    }

    /* JADX INFO: renamed from: xM$b */
    public class b implements View.OnClickListener {
        public final /* synthetic */ C4145vh a;
        public final /* synthetic */ e b;

        public b(C4145vh c4145vh, e eVar) {
            this.a = c4145vh;
            this.b = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C4279xM.this.n != null && C4279xM.this.d() == 0) {
                C4279xM.this.n.e(1, this.a);
            } else {
                if (C4279xM.this.d() == 0 || C4279xM.this.l == null) {
                    return;
                }
                C4279xM.this.l.a(this.b.getAdapterPosition());
            }
        }
    }

    /* JADX INFO: renamed from: xM$c */
    public interface c {
        void a(int i);
    }

    /* JADX INFO: renamed from: xM$d */
    public class d extends Filter {
        public d() {
        }

        /* JADX WARN: Code duplicated, block: B:56:0x01e6  */
        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            C4279xM.this.g = charSequence.toString();
            if (charSequence.length() <= 0) {
                filterResults.count = C4279xM.this.e.size();
                filterResults.values = C4279xM.this.e;
                return filterResults;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < C4279xM.this.e.size()) {
                if (((C4145vh) C4279xM.this.e.get(i)).a().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C4145vh) C4279xM.this.e.get(i)).n().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                    arrayList.add(new C4145vh(((C4145vh) C4279xM.this.e.get(i)).v(), ((C4145vh) C4279xM.this.e.get(i)).a(), ((C4145vh) C4279xM.this.e.get(i)).n(), ((C4145vh) C4279xM.this.e.get(i)).o(), ((C4145vh) C4279xM.this.e.get(i)).p(), ((C4145vh) C4279xM.this.e.get(i)).q(), ((C4145vh) C4279xM.this.e.get(i)).r(), ((C4145vh) C4279xM.this.e.get(i)).s(), ((C4145vh) C4279xM.this.e.get(i)).t(), ((C4145vh) C4279xM.this.e.get(i)).u(), ((C4145vh) C4279xM.this.e.get(i)).b(), ((C4145vh) C4279xM.this.e.get(i)).c(), ((C4145vh) C4279xM.this.e.get(i)).e(), ((C4145vh) C4279xM.this.e.get(i)).f(), ((C4145vh) C4279xM.this.e.get(i)).h(), ((C4145vh) C4279xM.this.e.get(i)).i(), ((C4145vh) C4279xM.this.e.get(i)).j(), ((C4145vh) C4279xM.this.e.get(i)).k(), ((C4145vh) C4279xM.this.e.get(i)).l(), ((C4145vh) C4279xM.this.e.get(i)).m()));
                } else {
                    String upperCase = "";
                    if ((((C4145vh) C4279xM.this.e.get(i)).o() != null ? ((C4145vh) C4279xM.this.e.get(i)).o().toUpperCase() : "").contains(charSequence.toString().toUpperCase())) {
                        arrayList.add(new C4145vh(((C4145vh) C4279xM.this.e.get(i)).v(), ((C4145vh) C4279xM.this.e.get(i)).a(), ((C4145vh) C4279xM.this.e.get(i)).n(), ((C4145vh) C4279xM.this.e.get(i)).o(), ((C4145vh) C4279xM.this.e.get(i)).p(), ((C4145vh) C4279xM.this.e.get(i)).q(), ((C4145vh) C4279xM.this.e.get(i)).r(), ((C4145vh) C4279xM.this.e.get(i)).s(), ((C4145vh) C4279xM.this.e.get(i)).t(), ((C4145vh) C4279xM.this.e.get(i)).u(), ((C4145vh) C4279xM.this.e.get(i)).b(), ((C4145vh) C4279xM.this.e.get(i)).c(), ((C4145vh) C4279xM.this.e.get(i)).e(), ((C4145vh) C4279xM.this.e.get(i)).f(), ((C4145vh) C4279xM.this.e.get(i)).h(), ((C4145vh) C4279xM.this.e.get(i)).i(), ((C4145vh) C4279xM.this.e.get(i)).j(), ((C4145vh) C4279xM.this.e.get(i)).k(), ((C4145vh) C4279xM.this.e.get(i)).l(), ((C4145vh) C4279xM.this.e.get(i)).m()));
                    } else {
                        if ((((C4145vh) C4279xM.this.e.get(i)).p() != null ? ((C4145vh) C4279xM.this.e.get(i)).p().toUpperCase() : "").contains(charSequence.toString().toUpperCase())) {
                            arrayList.add(new C4145vh(((C4145vh) C4279xM.this.e.get(i)).v(), ((C4145vh) C4279xM.this.e.get(i)).a(), ((C4145vh) C4279xM.this.e.get(i)).n(), ((C4145vh) C4279xM.this.e.get(i)).o(), ((C4145vh) C4279xM.this.e.get(i)).p(), ((C4145vh) C4279xM.this.e.get(i)).q(), ((C4145vh) C4279xM.this.e.get(i)).r(), ((C4145vh) C4279xM.this.e.get(i)).s(), ((C4145vh) C4279xM.this.e.get(i)).t(), ((C4145vh) C4279xM.this.e.get(i)).u(), ((C4145vh) C4279xM.this.e.get(i)).b(), ((C4145vh) C4279xM.this.e.get(i)).c(), ((C4145vh) C4279xM.this.e.get(i)).e(), ((C4145vh) C4279xM.this.e.get(i)).f(), ((C4145vh) C4279xM.this.e.get(i)).h(), ((C4145vh) C4279xM.this.e.get(i)).i(), ((C4145vh) C4279xM.this.e.get(i)).j(), ((C4145vh) C4279xM.this.e.get(i)).k(), ((C4145vh) C4279xM.this.e.get(i)).l(), ((C4145vh) C4279xM.this.e.get(i)).m()));
                        } else {
                            if (((((C4145vh) C4279xM.this.e.get(i)).q() == null || ((C4145vh) C4279xM.this.e.get(i)).q().length() <= 0) ? "" : ((C4145vh) C4279xM.this.e.get(i)).q().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                                arrayList.add(new C4145vh(((C4145vh) C4279xM.this.e.get(i)).v(), ((C4145vh) C4279xM.this.e.get(i)).a(), ((C4145vh) C4279xM.this.e.get(i)).n(), ((C4145vh) C4279xM.this.e.get(i)).o(), ((C4145vh) C4279xM.this.e.get(i)).p(), ((C4145vh) C4279xM.this.e.get(i)).q(), ((C4145vh) C4279xM.this.e.get(i)).r(), ((C4145vh) C4279xM.this.e.get(i)).s(), ((C4145vh) C4279xM.this.e.get(i)).t(), ((C4145vh) C4279xM.this.e.get(i)).u(), ((C4145vh) C4279xM.this.e.get(i)).b(), ((C4145vh) C4279xM.this.e.get(i)).c(), ((C4145vh) C4279xM.this.e.get(i)).e(), ((C4145vh) C4279xM.this.e.get(i)).f(), ((C4145vh) C4279xM.this.e.get(i)).h(), ((C4145vh) C4279xM.this.e.get(i)).i(), ((C4145vh) C4279xM.this.e.get(i)).j(), ((C4145vh) C4279xM.this.e.get(i)).k(), ((C4145vh) C4279xM.this.e.get(i)).l(), ((C4145vh) C4279xM.this.e.get(i)).m()));
                            } else {
                                if (((((C4145vh) C4279xM.this.e.get(i)).r() == null || ((C4145vh) C4279xM.this.e.get(i)).r().length() <= 0) ? "" : ((C4145vh) C4279xM.this.e.get(i)).r().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                                    arrayList.add(new C4145vh(((C4145vh) C4279xM.this.e.get(i)).v(), ((C4145vh) C4279xM.this.e.get(i)).a(), ((C4145vh) C4279xM.this.e.get(i)).n(), ((C4145vh) C4279xM.this.e.get(i)).o(), ((C4145vh) C4279xM.this.e.get(i)).p(), ((C4145vh) C4279xM.this.e.get(i)).q(), ((C4145vh) C4279xM.this.e.get(i)).r(), ((C4145vh) C4279xM.this.e.get(i)).s(), ((C4145vh) C4279xM.this.e.get(i)).t(), ((C4145vh) C4279xM.this.e.get(i)).u(), ((C4145vh) C4279xM.this.e.get(i)).b(), ((C4145vh) C4279xM.this.e.get(i)).c(), ((C4145vh) C4279xM.this.e.get(i)).e(), ((C4145vh) C4279xM.this.e.get(i)).f(), ((C4145vh) C4279xM.this.e.get(i)).h(), ((C4145vh) C4279xM.this.e.get(i)).i(), ((C4145vh) C4279xM.this.e.get(i)).j(), ((C4145vh) C4279xM.this.e.get(i)).k(), ((C4145vh) C4279xM.this.e.get(i)).l(), ((C4145vh) C4279xM.this.e.get(i)).m()));
                                } else {
                                    if (((((C4145vh) C4279xM.this.e.get(i)).e() == null || ((C4145vh) C4279xM.this.e.get(i)).e().length() <= 0) ? "" : ((C4145vh) C4279xM.this.e.get(i)).e().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                                        arrayList.add(new C4145vh(((C4145vh) C4279xM.this.e.get(i)).v(), ((C4145vh) C4279xM.this.e.get(i)).a(), ((C4145vh) C4279xM.this.e.get(i)).n(), ((C4145vh) C4279xM.this.e.get(i)).o(), ((C4145vh) C4279xM.this.e.get(i)).p(), ((C4145vh) C4279xM.this.e.get(i)).q(), ((C4145vh) C4279xM.this.e.get(i)).r(), ((C4145vh) C4279xM.this.e.get(i)).s(), ((C4145vh) C4279xM.this.e.get(i)).t(), ((C4145vh) C4279xM.this.e.get(i)).u(), ((C4145vh) C4279xM.this.e.get(i)).b(), ((C4145vh) C4279xM.this.e.get(i)).c(), ((C4145vh) C4279xM.this.e.get(i)).e(), ((C4145vh) C4279xM.this.e.get(i)).f(), ((C4145vh) C4279xM.this.e.get(i)).h(), ((C4145vh) C4279xM.this.e.get(i)).i(), ((C4145vh) C4279xM.this.e.get(i)).j(), ((C4145vh) C4279xM.this.e.get(i)).k(), ((C4145vh) C4279xM.this.e.get(i)).l(), ((C4145vh) C4279xM.this.e.get(i)).m()));
                                    } else {
                                        if (((C4145vh) C4279xM.this.e.get(i)).f() != null && ((C4145vh) C4279xM.this.e.get(i)).f().length() > 0) {
                                            upperCase = ((C4145vh) C4279xM.this.e.get(i)).f().toUpperCase();
                                        }
                                        if (upperCase.contains(charSequence.toString().toUpperCase())) {
                                            arrayList.add(new C4145vh(((C4145vh) C4279xM.this.e.get(i)).v(), ((C4145vh) C4279xM.this.e.get(i)).a(), ((C4145vh) C4279xM.this.e.get(i)).n(), ((C4145vh) C4279xM.this.e.get(i)).o(), ((C4145vh) C4279xM.this.e.get(i)).p(), ((C4145vh) C4279xM.this.e.get(i)).q(), ((C4145vh) C4279xM.this.e.get(i)).r(), ((C4145vh) C4279xM.this.e.get(i)).s(), ((C4145vh) C4279xM.this.e.get(i)).t(), ((C4145vh) C4279xM.this.e.get(i)).u(), ((C4145vh) C4279xM.this.e.get(i)).b(), ((C4145vh) C4279xM.this.e.get(i)).c(), ((C4145vh) C4279xM.this.e.get(i)).e(), ((C4145vh) C4279xM.this.e.get(i)).f(), ((C4145vh) C4279xM.this.e.get(i)).h(), ((C4145vh) C4279xM.this.e.get(i)).i(), ((C4145vh) C4279xM.this.e.get(i)).j(), ((C4145vh) C4279xM.this.e.get(i)).k(), ((C4145vh) C4279xM.this.e.get(i)).l(), ((C4145vh) C4279xM.this.e.get(i)).m()));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i++;
                filterResults = filterResults;
            }
            Filter.FilterResults filterResults2 = filterResults;
            filterResults2.count = arrayList.size();
            filterResults2.values = arrayList;
            return filterResults2;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            C4279xM c4279xM = C4279xM.this;
            c4279xM.d = (ArrayList) filterResults.values;
            c4279xM.notifyDataSetChanged();
        }

        public /* synthetic */ d(C4279xM c4279xM, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: xM$e */
    public static class e extends RecyclerView.ViewHolder {
        public C0685Ka a;

        public e(C0685Ka c0685Ka) {
            super(c0685Ka.getRoot());
            this.a = c0685Ka;
        }
    }

    public C4279xM(Context context, int i, List list, int i2, boolean z, boolean z2, int i3, DE de, c cVar) {
        super(new C4307xh());
        this.g = "";
        this.h = new int[]{R.drawable.up, 1, R.drawable.down};
        this.i = android.R.drawable.ic_menu_close_clear_cancel;
        this.k = new ArrayList();
        this.p = "";
        this.q = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.j = new SparseBooleanArray();
        this.a = context;
        this.d = list;
        this.e = list;
        this.c = i;
        y = i2;
        this.t = z;
        this.u = z2;
        this.w = i3;
        this.b = LayoutInflater.from(context);
        this.l = cVar;
        this.n = de;
    }

    public List c() {
        return snapshot().getItems();
    }

    public int d() {
        return this.j.size();
    }

    public SparseBooleanArray e() {
        return this.j;
    }

    public String f(String str) {
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(str));
    }

    public String g(String str) {
        String str2 = NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(str));
        return str2.equals("-0") ? "0" : str2;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f == null) {
            this.f = new d(this, null);
        }
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(e eVar, int i) {
        String str;
        int i2;
        float f;
        String lowerCase;
        String lowerCase2;
        String lowerCase3;
        String lowerCase4;
        String str2;
        int adapterPosition = eVar.getAdapterPosition();
        C4145vh c4145vh = (C4145vh) getItem(i);
        eVar.a.k.setText(c4145vh.v());
        int i3 = y;
        String lowerCase5 = "";
        if (i3 == 16 || i3 == 22) {
            if (c4145vh.b() == null || c4145vh.b().equals(".")) {
                str = "";
            } else {
                str = StringUtilities.LF + c4145vh.b();
            }
            eVar.a.c.setText(c4145vh.a() + str);
            if (str.length() > 0) {
                k(eVar.a.c, str);
            }
        } else {
            eVar.a.c.setText(c4145vh.a());
        }
        if (y == 17) {
            if (c4145vh.b() == null || c4145vh.b().equals(".")) {
                str2 = "";
            } else {
                str2 = StringUtilities.LF + c4145vh.b();
            }
            eVar.a.d.setText(c4145vh.n() + str2);
            if (str2.length() > 0) {
                k(eVar.a.d, str2);
            }
        } else {
            eVar.a.d.setText(c4145vh.n());
        }
        eVar.a.e.setText(c4145vh.o());
        eVar.a.f.setText(c4145vh.p());
        eVar.a.g.setText(c4145vh.q());
        int i4 = y;
        if (i4 == 4 || i4 == 16 || i4 == -4 || i4 == 17 || i4 == 18 || i4 == 19 || i4 == 20) {
            if (this.w == 4) {
                if (this.t) {
                    eVar.a.f.setVisibility(8);
                    f = 43.0f;
                } else {
                    f = 25.0f;
                }
                if (this.u) {
                    eVar.a.h.setVisibility(8);
                    f += 15.0f;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) eVar.a.e.getLayoutParams();
                layoutParams.weight = f;
                eVar.a.e.setLayoutParams(layoutParams);
            }
            if (this.t && (i2 = this.w) != 4 && i2 == 1) {
                eVar.a.c.setVisibility(8);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) eVar.a.d.getLayoutParams();
                layoutParams2.weight = 60.0f;
                eVar.a.d.setLayoutParams(layoutParams2);
            }
            if (this.q == 2) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) eVar.a.d.getLayoutParams();
                eVar.a.d.setLayoutParams((LinearLayout.LayoutParams) eVar.a.c.getLayoutParams());
                eVar.a.c.setLayoutParams(layoutParams3);
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) eVar.a.e.getLayoutParams();
                eVar.a.e.setLayoutParams((LinearLayout.LayoutParams) eVar.a.d.getLayoutParams());
                eVar.a.d.setLayoutParams(layoutParams4);
            }
            eVar.a.h.setText(c4145vh.r());
            eVar.a.i.setText(c4145vh.s());
            eVar.a.j.setText(c4145vh.t());
            int i5 = y;
            if (i5 == 18) {
                eVar.a.f.setText(f(c4145vh.p()));
                eVar.a.g.setText(f(c4145vh.q()));
                eVar.a.h.setText(g(c4145vh.r()));
            } else if (i5 == 19) {
                eVar.a.g.setText(f(c4145vh.q()));
                if (this.w == 4 && c4145vh.h() != null && c4145vh.h() != null) {
                    eVar.a.c.setTextColor(-16776961);
                    eVar.a.c.setTypeface(Typeface.SANS_SERIF, 3);
                }
                eVar.a.u.setVisibility(8);
                if (c4145vh.i.length() > 0) {
                    eVar.a.u.setText(c4145vh.i);
                    eVar.a.u.setVisibility(0);
                }
                try {
                    eVar.a.n.setVisibility(8);
                    String str3 = c4145vh.k;
                    if (str3 != null && str3.length() > 0) {
                        int i6 = Integer.parseInt(c4145vh.k);
                        if (i6 < 0) {
                            try {
                                eVar.a.n.setVisibility(0);
                                eVar.a.n.setImageResource(R.drawable.ic_cancel_circle);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else if (i6 == 1) {
                            eVar.a.n.setVisibility(0);
                            eVar.a.n.setImageResource(R.drawable.ic_check_circle);
                        } else if (i6 == 2) {
                            eVar.a.n.setVisibility(0);
                            eVar.a.n.setImageResource(R.drawable.ic_double_check_circle);
                        } else if (i6 == 3) {
                            eVar.a.n.setVisibility(0);
                            eVar.a.n.setImageResource(R.drawable.ic_check_circle_w);
                        } else if (i6 == 4) {
                            eVar.a.n.setVisibility(0);
                            eVar.a.n.setImageResource(R.drawable.ic_double_check_circle_w);
                        } else if (i6 == 0) {
                            eVar.a.n.setVisibility(0);
                            eVar.a.n.setImageResource(R.drawable.ic_pending_dot);
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } else if (i5 == 20) {
                TextView textView = eVar.a.e;
                StringBuilder sb = new StringBuilder();
                sb.append(f(Math.abs(Double.parseDouble(c4145vh.o())) + ""));
                sb.append(" ");
                sb.append(c4145vh.b());
                textView.setText(sb.toString());
                if (c4145vh.e() != null && !c4145vh.e().equals("0")) {
                    eVar.a.g.setTextColor(-16776961);
                    eVar.a.g.setTypeface(Typeface.SANS_SERIF, 3);
                }
            }
        }
        try {
            lowerCase = c4145vh.a().toLowerCase(Locale.getDefault());
        } catch (Exception unused) {
            lowerCase = "";
        }
        String str4 = this.g;
        if (str4 != null && !str4.isEmpty() && lowerCase.contains(this.g)) {
            int iIndexOf = lowerCase.indexOf(this.g);
            int length = this.g.length() + iIndexOf;
            Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(eVar.a.c.getText());
            spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
            eVar.a.c.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
        }
        try {
            lowerCase2 = c4145vh.n().toLowerCase(Locale.getDefault());
        } catch (Exception unused2) {
            lowerCase2 = "";
        }
        String str5 = this.g;
        if (str5 != null && !str5.isEmpty() && lowerCase2.contains(this.g)) {
            int iIndexOf2 = lowerCase2.indexOf(this.g);
            int length2 = this.g.length() + iIndexOf2;
            Spannable spannableNewSpannable2 = Spannable.Factory.getInstance().newSpannable(eVar.a.d.getText());
            spannableNewSpannable2.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf2, length2, 33);
            eVar.a.d.setText(spannableNewSpannable2, TextView.BufferType.SPANNABLE);
        }
        try {
            lowerCase3 = c4145vh.o().length() > 0 ? c4145vh.o().toLowerCase(Locale.getDefault()) : "";
            if (y == 20 && c4145vh.o().length() > 0) {
                lowerCase3 = f(c4145vh.o());
            }
        } catch (Exception unused3) {
            lowerCase3 = "";
        }
        String str6 = this.g;
        if (str6 != null && !str6.isEmpty() && lowerCase3.contains(this.g)) {
            int iIndexOf3 = lowerCase3.indexOf(this.g);
            int length3 = this.g.length() + iIndexOf3;
            Spannable spannableNewSpannable3 = Spannable.Factory.getInstance().newSpannable(eVar.a.e.getText());
            spannableNewSpannable3.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf3, length3, 33);
            eVar.a.e.setText(spannableNewSpannable3, TextView.BufferType.SPANNABLE);
        }
        try {
            lowerCase4 = c4145vh.p().length() > 0 ? c4145vh.p().toLowerCase(Locale.getDefault()) : "";
        } catch (Exception unused4) {
        }
        String str7 = this.g;
        if (str7 != null && !str7.isEmpty() && lowerCase4.contains(this.g)) {
            int iIndexOf4 = lowerCase4.indexOf(this.g);
            int length4 = this.g.length() + iIndexOf4;
            Spannable spannableNewSpannable4 = Spannable.Factory.getInstance().newSpannable(eVar.a.f.getText());
            spannableNewSpannable4.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf4, length4, 33);
            eVar.a.f.setText(spannableNewSpannable4, TextView.BufferType.SPANNABLE);
        }
        try {
            if (c4145vh.i.length() > 0) {
                lowerCase5 = c4145vh.i.toLowerCase(Locale.getDefault());
            }
        } catch (Exception unused5) {
        }
        String str8 = this.g;
        if (str8 != null && !str8.isEmpty() && lowerCase5.contains(this.g)) {
            int iIndexOf5 = lowerCase5.indexOf(this.g);
            int length5 = this.g.length() + iIndexOf5;
            Spannable spannableNewSpannable5 = Spannable.Factory.getInstance().newSpannable(eVar.a.u.getText());
            spannableNewSpannable5.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf5, length5, 33);
            eVar.a.u.setText(spannableNewSpannable5, TextView.BufferType.SPANNABLE);
        }
        if (this.k.contains(Integer.valueOf(adapterPosition))) {
            eVar.a.q.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
        } else {
            eVar.a.q.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        eVar.itemView.setOnLongClickListener(new a(eVar));
        eVar.itemView.setOnClickListener(new b(c4145vh, eVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public e onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.x = C0685Ka.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new e(this.x);
    }

    public void j() {
        this.j = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void k(TextView textView, String str) {
        int iIndexOf = textView.getText().toString().indexOf(str);
        int length = str.length() + iIndexOf;
        Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(textView.getText());
        spannableNewSpannable.setSpan(new RelativeSizeSpan(0.9f), iIndexOf, length, 33);
        textView.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
    }

    public void l(int i, boolean z) {
        if (z) {
            this.j.put(i, z);
        } else {
            this.j.delete(i);
        }
        notifyDataSetChanged();
    }

    public void m(int i) {
        if (this.k.contains(Integer.valueOf(i))) {
            this.k.remove(Integer.valueOf(i));
        } else {
            this.k.add(Integer.valueOf(i));
        }
        l(i, !this.j.get(i));
    }
}
