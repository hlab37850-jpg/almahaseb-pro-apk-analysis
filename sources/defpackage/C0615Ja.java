package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import info.aalmoghalis.inventory.R;

/* JADX INFO: renamed from: Ja, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0615Ja implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;
    public final CardView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView n;
    public final LinearLayout p;
    public final LinearLayout q;
    public final TextView t;

    public C0615Ja(LinearLayout linearLayout, TextView textView, CardView cardView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView12) {
        this.a = linearLayout;
        this.b = textView;
        this.c = cardView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
        this.h = textView6;
        this.i = textView7;
        this.j = textView8;
        this.k = textView9;
        this.l = textView10;
        this.n = textView11;
        this.p = linearLayout2;
        this.q = linearLayout3;
        this.t = textView12;
    }

    public static C0615Ja a(View view) {
        int i = R.id.acc_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.acc_name);
        if (textView != null) {
            i = R.id.card_view;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.card_view);
            if (cardView != null) {
                i = R.id.f1;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f1);
                if (textView2 != null) {
                    i = R.id.f2;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f2);
                    if (textView3 != null) {
                        i = R.id.f3;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f3);
                        if (textView4 != null) {
                            i = R.id.f4;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f4);
                            if (textView5 != null) {
                                i = R.id.f5;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.f5);
                                if (textView6 != null) {
                                    i = R.id.f6;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.f6);
                                    if (textView7 != null) {
                                        i = R.id.f7;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.f7);
                                        if (textView8 != null) {
                                            i = R.id.f8;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.f8);
                                            if (textView9 != null) {
                                                i = R.id.id;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, R.id.id);
                                                if (textView10 != null) {
                                                    i = R.id.id2;
                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, R.id.id2);
                                                    if (textView11 != null) {
                                                        i = R.id.row1;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.row1);
                                                        if (linearLayout != null) {
                                                            i = R.id.row2;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.row2);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.user_name;
                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, R.id.user_name);
                                                                if (textView12 != null) {
                                                                    return new C0615Ja((LinearLayout) view, textView, cardView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, linearLayout, linearLayout2, textView12);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C0615Ja c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.card_data_det_row_bill4_, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
