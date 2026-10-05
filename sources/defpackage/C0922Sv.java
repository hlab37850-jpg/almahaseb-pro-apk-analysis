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
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.zebra.sdk.util.internal.StringUtilities;
import info.aalmoghalis.inventory.R;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: Sv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0922Sv extends ArrayAdapter implements Filterable {
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
    public String n;
    public int p;
    public boolean q;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;

    /* JADX INFO: renamed from: Sv$b */
    public class b extends Filter {
        public b() {
        }

        /* JADX WARN: Code duplicated, block: B:70:0x0265  */
        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            C0922Sv.this.h = charSequence.toString();
            if (charSequence.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < C0922Sv.this.f.size(); i++) {
                    if (((C4145vh) C0922Sv.this.f.get(i)).a().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C4145vh) C0922Sv.this.f.get(i)).n().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                        arrayList.add((C4145vh) C0922Sv.this.f.get(i));
                    } else {
                        String upperCase = "";
                        if ((((C4145vh) C0922Sv.this.f.get(i)).o() != null ? ((C4145vh) C0922Sv.this.f.get(i)).o().toUpperCase() : "").contains(charSequence.toString().toUpperCase())) {
                            arrayList.add((C4145vh) C0922Sv.this.f.get(i));
                        } else if ((((C4145vh) C0922Sv.this.f.get(i)).p() != null ? ((C4145vh) C0922Sv.this.f.get(i)).p().toUpperCase() : "").contains(charSequence.toString().toUpperCase())) {
                            arrayList.add((C4145vh) C0922Sv.this.f.get(i));
                        } else if (((((C4145vh) C0922Sv.this.f.get(i)).q() == null || ((C4145vh) C0922Sv.this.f.get(i)).q().length() <= 0) ? "" : ((C4145vh) C0922Sv.this.f.get(i)).q().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                            arrayList.add((C4145vh) C0922Sv.this.f.get(i));
                        } else if (((((C4145vh) C0922Sv.this.f.get(i)).r() == null || ((C4145vh) C0922Sv.this.f.get(i)).r().length() <= 0) ? "" : ((C4145vh) C0922Sv.this.f.get(i)).r().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                            arrayList.add((C4145vh) C0922Sv.this.f.get(i));
                        } else if (((((C4145vh) C0922Sv.this.f.get(i)).e() == null || ((C4145vh) C0922Sv.this.f.get(i)).e().length() <= 0) ? "" : ((C4145vh) C0922Sv.this.f.get(i)).e().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                            arrayList.add((C4145vh) C0922Sv.this.f.get(i));
                        } else if (((((C4145vh) C0922Sv.this.f.get(i)).f() == null || ((C4145vh) C0922Sv.this.f.get(i)).f().length() <= 0) ? "" : ((C4145vh) C0922Sv.this.f.get(i)).f().toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                            arrayList.add((C4145vh) C0922Sv.this.f.get(i));
                        } else if (((((C4145vh) C0922Sv.this.f.get(i)).i == null || ((C4145vh) C0922Sv.this.f.get(i)).i.length() <= 0) ? "" : ((C4145vh) C0922Sv.this.f.get(i)).i.toUpperCase()).contains(charSequence.toString().toUpperCase())) {
                            arrayList.add((C4145vh) C0922Sv.this.f.get(i));
                        } else {
                            if (((C4145vh) C0922Sv.this.f.get(i)).c() != null && ((C4145vh) C0922Sv.this.f.get(i)).c().length() > 0) {
                                upperCase = ((C4145vh) C0922Sv.this.f.get(i)).c().toUpperCase();
                            }
                            if (upperCase.contains(charSequence.toString().toUpperCase())) {
                                arrayList.add((C4145vh) C0922Sv.this.f.get(i));
                            }
                        }
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            } else {
                filterResults.count = C0922Sv.this.f.size();
                filterResults.values = C0922Sv.this.f;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            C0922Sv c0922Sv = C0922Sv.this;
            c0922Sv.e = (ArrayList) filterResults.values;
            c0922Sv.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: Sv$c */
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
        public TextView j;
        public ImageView k;
        public TextView l;
        public TextView m;
        public TextView n;

        public c() {
        }
    }

    public C0922Sv(Context context, int i, List list, int i2) {
        super(context, i, list);
        this.h = "";
        this.i = new int[]{R.drawable.up, 1, R.drawable.down};
        this.j = android.R.drawable.ic_menu_close_clear_cancel;
        this.l = new ArrayList();
        this.n = "";
        this.p = 0;
        this.q = false;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = false;
        this.k = new SparseBooleanArray();
        this.a = context;
        this.e = list;
        this.f = list;
        this.c = i;
        this.d = i2;
        this.b = LayoutInflater.from(context);
    }

    public boolean a(String str) {
        return (!str.startsWith("-") || str.equals("-0") || str.equals("-0.0")) ? false : true;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C4145vh getItem(int i) {
        return (C4145vh) this.e.get(i);
    }

    public SparseBooleanArray c() {
        return this.k;
    }

    public String d(String str) {
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(str));
    }

    public String e(String str) {
        String str2 = NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(str));
        return str2.equals("-0") ? "0" : str2;
    }

    public void f(List list) {
        this.e = list;
        this.f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void remove(C4145vh c4145vh) {
        this.e.remove(c4145vh);
        notifyDataSetChanged();
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

    /* JADX WARN: Code duplicated, block: B:202:0x0a36  */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        String str;
        int i3;
        int i4;
        TextView textView;
        String lowerCase;
        String lowerCase2;
        String lowerCase3;
        String lowerCase4;
        String lowerCase5;
        String str2;
        String str3;
        c cVar = new c();
        View viewInflate = this.b.inflate(this.c, (ViewGroup) null);
        cVar.a = (TextView) viewInflate.findViewById(R.id.id);
        cVar.b = (TextView) viewInflate.findViewById(R.id.f1);
        cVar.c = (TextView) viewInflate.findViewById(R.id.f2);
        cVar.d = (TextView) viewInflate.findViewById(R.id.f3);
        cVar.e = (TextView) viewInflate.findViewById(R.id.f4);
        cVar.f = (TextView) viewInflate.findViewById(R.id.f5);
        try {
            cVar.j = (TextView) viewInflate.findViewById(R.id.user_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i5 = this.d;
        if (i5 == 1 || i5 == 2) {
            i2 = R.id.more;
            cVar.k = (ImageView) viewInflate.findViewById(R.id.more);
        } else {
            if (i5 == 3 || i5 == 4 || i5 == -4 || i5 == 5 || i5 == 15 || i5 == 21 || i5 == 16 || i5 == 17 || i5 == 27 || i5 == 18 || i5 == 19 || i5 == 20) {
                cVar.g = (TextView) viewInflate.findViewById(R.id.f6);
                cVar.h = (TextView) viewInflate.findViewById(R.id.f7);
                cVar.i = (TextView) viewInflate.findViewById(R.id.f8);
                if (this.d == -4) {
                    cVar.l = (TextView) viewInflate.findViewById(R.id.item_unit);
                    cVar.m = (TextView) viewInflate.findViewById(R.id.item_date);
                    cVar.n = (TextView) viewInflate.findViewById(R.id.item_barcode);
                }
            }
            i2 = R.id.more;
        }
        int i6 = this.d;
        if (i6 == 6 || i6 == 7) {
            cVar.k = (ImageView) viewInflate.findViewById(i2);
            cVar.g = (TextView) viewInflate.findViewById(R.id.f6);
            cVar.h = (TextView) viewInflate.findViewById(R.id.f7);
            cVar.i = (TextView) viewInflate.findViewById(R.id.f8);
            cVar.k.setImageResource(this.j);
        }
        viewInflate.setTag(cVar);
        viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        cVar.a.setText(((C4145vh) this.e.get(i)).v());
        int i7 = this.d;
        String lowerCase6 = "";
        if (i7 == 16 || i7 == 22) {
            if (((C4145vh) this.e.get(i)).b() == null || ((C4145vh) this.e.get(i)).b().equals(".")) {
                str = "";
            } else {
                str = StringUtilities.LF + ((C4145vh) this.e.get(i)).b();
            }
            cVar.b.setText(((C4145vh) this.e.get(i)).a() + str);
            if (str.length() > 0) {
                i(cVar.b, str);
            }
        } else {
            cVar.b.setText(((C4145vh) this.e.get(i)).a());
        }
        if (this.d == 17) {
            if (((C4145vh) this.e.get(i)).b() == null || ((C4145vh) this.e.get(i)).b().equals(".")) {
                str3 = "";
            } else {
                str3 = StringUtilities.LF + ((C4145vh) this.e.get(i)).b();
            }
            cVar.c.setText(((C4145vh) this.e.get(i)).n() + str3);
            if (str3.length() > 0) {
                i(cVar.c, str3);
            }
        } else {
            cVar.c.setText(((C4145vh) this.e.get(i)).n());
        }
        if (this.d == 27) {
            if (((C4145vh) this.e.get(i)).b() == null || ((C4145vh) this.e.get(i)).b().equals(".")) {
                str2 = "";
            } else {
                str2 = StringUtilities.LF + ((C4145vh) this.e.get(i)).b();
            }
            cVar.b.setText(((C4145vh) this.e.get(i)).a() + str2);
            if (str2.length() > 0) {
                i(cVar.b, str2);
            }
        } else {
            cVar.b.setText(((C4145vh) this.e.get(i)).a());
        }
        cVar.d.setText(((C4145vh) this.e.get(i)).o());
        cVar.e.setText(((C4145vh) this.e.get(i)).p());
        cVar.f.setText(((C4145vh) this.e.get(i)).q());
        int i8 = this.d;
        if (i8 == 1) {
            cVar.f.setVisibility(8);
            cVar.e.setText(d(((C4145vh) this.e.get(i)).p()));
            cVar.k.setVisibility(0);
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
        } else if (i8 == 2) {
            cVar.f.setVisibility(8);
            cVar.c.setText(d(((C4145vh) this.e.get(i)).n()));
            cVar.d.setText(d(((C4145vh) this.e.get(i)).o()));
            cVar.e.setText(d(((C4145vh) this.e.get(i)).p()));
            cVar.k.setVisibility(0);
            cVar.k.setImageResource(this.i[Integer.parseInt(((C4145vh) this.e.get(i)).q())]);
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
        } else if (i8 == 3) {
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
        } else if (i8 == 4 || i8 == 16 || i8 == -4 || i8 == 17 || i8 == 27 || i8 == 18 || i8 == 19 || i8 == 20) {
            if (this.q) {
                int i9 = this.v;
                if (i9 == 4) {
                    cVar.e.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams15 = (LinearLayout.LayoutParams) cVar.c.getLayoutParams();
                    layoutParams15.weight = 40.0f;
                    cVar.c.setLayoutParams(layoutParams15);
                } else if (i9 == 1) {
                    cVar.b.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams16 = (LinearLayout.LayoutParams) cVar.c.getLayoutParams();
                    layoutParams16.weight = 60.0f;
                    cVar.c.setLayoutParams(layoutParams16);
                }
            }
            if (this.t) {
                cVar.g.setVisibility(8);
                LinearLayout.LayoutParams layoutParams17 = (LinearLayout.LayoutParams) cVar.d.getLayoutParams();
                layoutParams17.weight = 40.0f;
                cVar.d.setLayoutParams(layoutParams17);
            }
            if (this.p == 2) {
                LinearLayout.LayoutParams layoutParams18 = (LinearLayout.LayoutParams) cVar.c.getLayoutParams();
                cVar.c.setLayoutParams((LinearLayout.LayoutParams) cVar.b.getLayoutParams());
                cVar.b.setLayoutParams(layoutParams18);
                LinearLayout.LayoutParams layoutParams19 = (LinearLayout.LayoutParams) cVar.d.getLayoutParams();
                cVar.d.setLayoutParams((LinearLayout.LayoutParams) cVar.c.getLayoutParams());
                cVar.c.setLayoutParams(layoutParams19);
            }
            cVar.g.setText(((C4145vh) this.e.get(i)).r());
            cVar.h.setText(((C4145vh) this.e.get(i)).s());
            cVar.i.setText(((C4145vh) this.e.get(i)).t());
            int i10 = this.d;
            if (i10 == 18) {
                cVar.e.setText(d(((C4145vh) this.e.get(i)).p()));
                cVar.f.setText(d(((C4145vh) this.e.get(i)).q()));
                cVar.g.setText(e(((C4145vh) this.e.get(i)).r()));
            } else if (i10 == 19) {
                cVar.f.setText(d(((C4145vh) this.e.get(i)).q()));
                if (this.v == 4 && ((C4145vh) this.e.get(i)).h() != null && ((C4145vh) this.e.get(i)).h().equals("2")) {
                    cVar.e.setTextColor(-16776961);
                    cVar.e.setTypeface(Typeface.SANS_SERIF, 3);
                }
            } else if (i10 == 20) {
                TextView textView2 = cVar.d;
                StringBuilder sb = new StringBuilder();
                sb.append(d(Math.abs(Double.parseDouble(((C4145vh) this.e.get(i)).o())) + ""));
                sb.append(" ");
                sb.append(((C4145vh) this.e.get(i)).b());
                textView2.setText(sb.toString());
                if (((C4145vh) this.e.get(i)).c() != null && ((C4145vh) this.e.get(i)).c().equals("2")) {
                    cVar.f.setTextColor(-16776961);
                    cVar.f.setTypeface(Typeface.SANS_SERIF, 3);
                }
            } else {
                if (i10 == -4) {
                    if (((C4145vh) this.e.get(i)).e() == null || ((C4145vh) this.e.get(i)).e().equals(".")) {
                        cVar.l.setVisibility(8);
                    } else {
                        cVar.l.setText(((C4145vh) this.e.get(i)).e());
                        cVar.l.setVisibility(0);
                    }
                    if (((C4145vh) this.e.get(i)).f() == null || ((C4145vh) this.e.get(i)).f().equals("")) {
                        cVar.m.setVisibility(8);
                    } else {
                        cVar.m.setText(((C4145vh) this.e.get(i)).f());
                        cVar.m.setVisibility(0);
                    }
                    if (((C4145vh) this.e.get(i)).c() == null || ((C4145vh) this.e.get(i)).c().equals("")) {
                        i3 = 8;
                        cVar.n.setVisibility(8);
                    } else {
                        cVar.n.setText(((C4145vh) this.e.get(i)).c());
                        cVar.n.setVisibility(0);
                    }
                }
                i4 = this.d;
                if ((i4 != 4 || i4 == 19) && (textView = cVar.j) != null) {
                    textView.setVisibility(i3);
                    if (((C4145vh) this.e.get(i)).i.length() > 0) {
                        cVar.j.setText(((C4145vh) this.e.get(i)).i);
                        cVar.j.setVisibility(0);
                    }
                }
            }
            i3 = 8;
            i4 = this.d;
            if (i4 != 4) {
                textView.setVisibility(i3);
                if (((C4145vh) this.e.get(i)).i.length() > 0) {
                    cVar.j.setText(((C4145vh) this.e.get(i)).i);
                    cVar.j.setVisibility(0);
                }
            } else {
                textView.setVisibility(i3);
                if (((C4145vh) this.e.get(i)).i.length() > 0) {
                    cVar.j.setText(((C4145vh) this.e.get(i)).i);
                    cVar.j.setVisibility(0);
                }
            }
        } else if (i8 == 5) {
            cVar.i.setVisibility(8);
            if (this.u) {
                cVar.d.setText(((C4145vh) this.e.get(i)).t());
                cVar.e.setText(((C4145vh) this.e.get(i)).u());
            }
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
        } else if (i8 == 15) {
            cVar.i.setVisibility(8);
            cVar.g.setText(((C4145vh) this.e.get(i)).r());
            cVar.h.setText(((C4145vh) this.e.get(i)).s());
            cVar.i.setText(((C4145vh) this.e.get(i)).t());
            if (((C4145vh) this.e.get(i)).r().equals("1")) {
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
        } else if (i8 == 21) {
            cVar.i.setVisibility(8);
            cVar.g.setText(((C4145vh) this.e.get(i)).r());
            cVar.h.setText(((C4145vh) this.e.get(i)).s());
            cVar.i.setText(((C4145vh) this.e.get(i)).t());
            if (((C4145vh) this.e.get(i)).q().contains("-")) {
                cVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.up, 0, 0, 0);
            } else if (((C4145vh) this.e.get(i)).q().equals("0")) {
                cVar.f.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                cVar.f.setCompoundDrawablesWithIntrinsicBounds(R.drawable.down, 0, 0, 0);
            }
        } else if (i8 == 6) {
            cVar.f.setVisibility(8);
            cVar.g.setVisibility(8);
            cVar.h.setVisibility(8);
            cVar.i.setVisibility(8);
            cVar.k.setVisibility(0);
            cVar.k.setImageResource(this.j);
            LinearLayout.LayoutParams layoutParams20 = (LinearLayout.LayoutParams) cVar.b.getLayoutParams();
            layoutParams20.weight = 20.0f;
            cVar.b.setLayoutParams(layoutParams20);
            LinearLayout.LayoutParams layoutParams21 = (LinearLayout.LayoutParams) cVar.c.getLayoutParams();
            layoutParams21.weight = 30.0f;
            cVar.c.setLayoutParams(layoutParams21);
            LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) cVar.d.getLayoutParams();
            layoutParams22.weight = 40.0f;
            cVar.d.setLayoutParams(layoutParams22);
            LinearLayout.LayoutParams layoutParams23 = (LinearLayout.LayoutParams) cVar.e.getLayoutParams();
            layoutParams23.weight = 30.0f;
            cVar.e.setLayoutParams(layoutParams23);
        } else if (i8 == 7) {
            cVar.e.setVisibility(8);
            cVar.i.setVisibility(8);
            cVar.g.setText(((C4145vh) this.e.get(i)).r());
            cVar.h.setText(((C4145vh) this.e.get(i)).s());
            cVar.i.setText(((C4145vh) this.e.get(i)).t());
            cVar.k.setVisibility(0);
            cVar.k.setImageResource(this.j);
            LinearLayout.LayoutParams layoutParams24 = (LinearLayout.LayoutParams) cVar.b.getLayoutParams();
            layoutParams24.weight = 40.0f;
            cVar.b.setLayoutParams(layoutParams24);
            LinearLayout.LayoutParams layoutParams25 = (LinearLayout.LayoutParams) cVar.c.getLayoutParams();
            layoutParams25.weight = 40.0f;
            cVar.c.setLayoutParams(layoutParams25);
            LinearLayout.LayoutParams layoutParams26 = (LinearLayout.LayoutParams) cVar.d.getLayoutParams();
            layoutParams26.weight = 40.0f;
            cVar.d.setLayoutParams(layoutParams26);
            LinearLayout.LayoutParams layoutParams27 = (LinearLayout.LayoutParams) cVar.f.getLayoutParams();
            layoutParams27.weight = 40.0f;
            cVar.f.setLayoutParams(layoutParams27);
            LinearLayout.LayoutParams layoutParams28 = (LinearLayout.LayoutParams) cVar.g.getLayoutParams();
            layoutParams28.weight = 40.0f;
            cVar.g.setLayoutParams(layoutParams28);
            LinearLayout.LayoutParams layoutParams29 = (LinearLayout.LayoutParams) cVar.h.getLayoutParams();
            layoutParams29.weight = 40.0f;
            cVar.h.setLayoutParams(layoutParams29);
        }
        if (this.d != 22 || this.n.length() <= 0 || ((C4145vh) this.e.get(i)).n().length() <= 0) {
            int i11 = this.d;
            if (i11 == 18 && this.w) {
                if (a(((C4145vh) this.e.get(i)).r())) {
                    if (((C4145vh) this.e.get(i)).a().equals("شراء")) {
                        k(new TextView[]{cVar.b, cVar.c, cVar.g}, true);
                    } else {
                        k(new TextView[]{cVar.g}, true);
                    }
                }
            } else if (i11 == 16 && this.w) {
                if (a(((C4145vh) this.e.get(i)).o())) {
                    k(new TextView[]{cVar.b, cVar.c, cVar.d}, true);
                }
            } else if ((i11 == 17 || i11 == 27) && this.w && a(((C4145vh) this.e.get(i)).p())) {
                k(new TextView[]{cVar.e}, true);
            }
        } else if (this.n.compareTo(((C4145vh) this.e.get(i)).n()) >= 0) {
            k(new TextView[]{cVar.b, cVar.c, cVar.f}, true);
        }
        C4145vh c4145vh = (C4145vh) this.e.get(i);
        try {
            lowerCase = c4145vh.a().toLowerCase(Locale.getDefault());
        } catch (Exception unused) {
            lowerCase = "";
        }
        String str4 = this.h;
        if (str4 != null && !str4.isEmpty() && lowerCase.contains(this.h)) {
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
        String str5 = this.h;
        if (str5 != null && !str5.isEmpty() && lowerCase2.contains(this.h)) {
            int iIndexOf2 = lowerCase2.indexOf(this.h);
            int length2 = this.h.length() + iIndexOf2;
            Spannable spannableNewSpannable2 = Spannable.Factory.getInstance().newSpannable(cVar.c.getText());
            spannableNewSpannable2.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf2, length2, 33);
            cVar.c.setText(spannableNewSpannable2, TextView.BufferType.SPANNABLE);
        }
        try {
            lowerCase3 = c4145vh.o().length() > 0 ? c4145vh.o().toLowerCase(Locale.getDefault()) : "";
            if (this.d == 20 && c4145vh.o().length() > 0) {
                lowerCase3 = d(c4145vh.o());
            }
        } catch (Exception unused3) {
            lowerCase3 = "";
        }
        String str6 = this.h;
        if (str6 != null && !str6.isEmpty() && lowerCase3.contains(this.h)) {
            int iIndexOf3 = lowerCase3.indexOf(this.h);
            int length3 = this.h.length() + iIndexOf3;
            Spannable spannableNewSpannable3 = Spannable.Factory.getInstance().newSpannable(cVar.d.getText());
            spannableNewSpannable3.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf3, length3, 33);
            cVar.d.setText(spannableNewSpannable3, TextView.BufferType.SPANNABLE);
        }
        try {
            lowerCase4 = c4145vh.p().length() > 0 ? c4145vh.p().toLowerCase(Locale.getDefault()) : "";
        } catch (Exception unused4) {
        }
        String str7 = this.h;
        if (str7 != null && !str7.isEmpty() && lowerCase4.contains(this.h)) {
            int iIndexOf4 = lowerCase4.indexOf(this.h);
            int length4 = this.h.length() + iIndexOf4;
            Spannable spannableNewSpannable4 = Spannable.Factory.getInstance().newSpannable(cVar.e.getText());
            spannableNewSpannable4.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf4, length4, 33);
            cVar.e.setText(spannableNewSpannable4, TextView.BufferType.SPANNABLE);
        }
        int i12 = this.d;
        if ((i12 == 4 || i12 == 19) && c4145vh.i.length() > 0 && cVar.j != null) {
            try {
                lowerCase5 = c4145vh.i.length() > 0 ? c4145vh.i.toLowerCase(Locale.getDefault()) : "";
            } catch (Exception unused5) {
            }
            String str8 = this.h;
            if (str8 != null && !str8.isEmpty() && lowerCase5.contains(this.h)) {
                int iIndexOf5 = lowerCase5.indexOf(this.h);
                int length5 = this.h.length() + iIndexOf5;
                Spannable spannableNewSpannable5 = Spannable.Factory.getInstance().newSpannable(cVar.j.getText());
                spannableNewSpannable5.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf5, length5, 33);
                cVar.j.setText(spannableNewSpannable5, TextView.BufferType.SPANNABLE);
            }
        }
        if (this.d == -4) {
            try {
                C2160f10 c2160f10 = new C2160f10();
                TextView[] textViewArr = {cVar.n};
                if (c4145vh.c() != null) {
                    lowerCase6 = c4145vh.c().toLowerCase(Locale.getDefault());
                }
                c2160f10.m(textViewArr, new String[]{lowerCase6}, this.h);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.l.contains(Integer.valueOf(i))) {
            viewInflate.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
        } else {
            viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        return viewInflate;
    }

    public void h() {
        this.k = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void i(TextView textView, String str) {
        int iIndexOf = textView.getText().toString().indexOf(str);
        int length = str.length() + iIndexOf;
        Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(textView.getText());
        spannableNewSpannable.setSpan(new RelativeSizeSpan(0.9f), iIndexOf, length, 33);
        textView.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
    }

    public void j(int i, boolean z) {
        if (z) {
            this.k.put(i, z);
        } else {
            this.k.delete(i);
        }
        notifyDataSetChanged();
    }

    public void k(TextView[] textViewArr, boolean z) {
        for (int i = 0; i < textViewArr.length; i++) {
            if (z) {
                textViewArr[i].setTextColor(SupportMenu.CATEGORY_MASK);
                TextView textView = textViewArr[i];
                textView.setPaintFlags(textView.getPaintFlags() | 8);
            }
        }
    }

    public void l(int i) {
        if (this.l.contains(Integer.valueOf(i))) {
            this.l.remove(Integer.valueOf(i));
        } else {
            this.l.add(Integer.valueOf(i));
        }
        j(i, !this.k.get(i));
    }

    public C0922Sv(Context context, int i, List list, int i2, String str) {
        super(context, i, list);
        this.h = "";
        this.i = new int[]{R.drawable.up, 1, R.drawable.down};
        this.j = android.R.drawable.ic_menu_close_clear_cancel;
        this.l = new ArrayList();
        this.n = "";
        this.p = 0;
        this.q = false;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = false;
        this.k = new SparseBooleanArray();
        this.a = context;
        this.e = list;
        this.f = list;
        this.c = i;
        this.d = i2;
        this.b = LayoutInflater.from(context);
        this.n = str;
    }

    public C0922Sv(Context context, int i, List list, int i2, int i3) {
        super(context, i, list);
        this.h = "";
        this.i = new int[]{R.drawable.up, 1, R.drawable.down};
        this.j = android.R.drawable.ic_menu_close_clear_cancel;
        this.l = new ArrayList();
        this.n = "";
        this.p = 0;
        this.q = false;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = false;
        this.k = new SparseBooleanArray();
        this.a = context;
        this.e = list;
        this.f = list;
        this.c = i;
        this.d = i2;
        this.b = LayoutInflater.from(context);
        this.p = i3;
    }

    public C0922Sv(Context context, int i, List list, int i2, boolean z, int i3) {
        super(context, i, list);
        this.h = "";
        this.i = new int[]{R.drawable.up, 1, R.drawable.down};
        this.j = android.R.drawable.ic_menu_close_clear_cancel;
        this.l = new ArrayList();
        this.n = "";
        this.p = 0;
        this.q = false;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = false;
        this.k = new SparseBooleanArray();
        this.a = context;
        this.e = list;
        this.f = list;
        this.c = i;
        this.d = i2;
        this.q = z;
        this.v = i3;
        this.b = LayoutInflater.from(context);
    }

    public C0922Sv(Context context, int i, List list, int i2, boolean z, int i3, boolean z2) {
        super(context, i, list);
        this.h = "";
        this.i = new int[]{R.drawable.up, 1, R.drawable.down};
        this.j = android.R.drawable.ic_menu_close_clear_cancel;
        this.l = new ArrayList();
        this.n = "";
        this.p = 0;
        this.q = false;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = false;
        this.k = new SparseBooleanArray();
        this.a = context;
        this.e = list;
        this.f = list;
        this.c = i;
        this.d = i2;
        this.q = z;
        this.v = i3;
        this.b = LayoutInflater.from(context);
        this.u = z2;
    }

    public C0922Sv(Context context, int i, List list, int i2, boolean z, boolean z2, int i3) {
        super(context, i, list);
        this.h = "";
        this.i = new int[]{R.drawable.up, 1, R.drawable.down};
        this.j = android.R.drawable.ic_menu_close_clear_cancel;
        this.l = new ArrayList();
        this.n = "";
        this.p = 0;
        this.q = false;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = false;
        this.k = new SparseBooleanArray();
        this.a = context;
        this.e = list;
        this.f = list;
        this.c = i;
        this.d = i2;
        this.q = z;
        this.t = z2;
        this.v = i3;
        this.b = LayoutInflater.from(context);
    }

    public C0922Sv(Context context, int i, List list, int i2, boolean z) {
        super(context, i, list);
        this.h = "";
        this.i = new int[]{R.drawable.up, 1, R.drawable.down};
        this.j = android.R.drawable.ic_menu_close_clear_cancel;
        this.l = new ArrayList();
        this.n = "";
        this.p = 0;
        this.q = false;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = false;
        this.k = new SparseBooleanArray();
        this.a = context;
        this.e = list;
        this.f = list;
        this.c = i;
        this.d = i2;
        this.w = z;
        this.b = LayoutInflater.from(context);
    }
}
