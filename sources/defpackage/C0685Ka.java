package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import info.aalmoghalis.inventory.R;

/* JADX INFO: renamed from: Ka, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0685Ka implements ViewBinding {
    public final LinearLayout a;
    public final CardView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final ImageView n;
    public final LinearLayout p;
    public final LinearLayout q;
    public final LinearLayout t;
    public final TextView u;

    public C0685Ka(LinearLayout linearLayout, CardView cardView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView11) {
        this.a = linearLayout;
        this.b = cardView;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
        this.h = textView6;
        this.i = textView7;
        this.j = textView8;
        this.k = textView9;
        this.l = textView10;
        this.n = imageView;
        this.p = linearLayout2;
        this.q = linearLayout3;
        this.t = linearLayout4;
        this.u = textView11;
    }

    public static C0685Ka a(View view) {
        int i = R.id.card_view;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.card_view);
        if (cardView != null) {
            i = R.id.f1;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f1);
            if (textView != null) {
                i = R.id.f2;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f2);
                if (textView2 != null) {
                    i = R.id.f3;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f3);
                    if (textView3 != null) {
                        i = R.id.f4;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f4);
                        if (textView4 != null) {
                            i = R.id.f5;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f5);
                            if (textView5 != null) {
                                i = R.id.f6;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.f6);
                                if (textView6 != null) {
                                    i = R.id.f7;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.f7);
                                    if (textView7 != null) {
                                        i = R.id.f8;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.f8);
                                        if (textView8 != null) {
                                            i = R.id.id;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.id);
                                            if (textView9 != null) {
                                                i = R.id.id2;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, R.id.id2);
                                                if (textView10 != null) {
                                                    i = R.id.img_status;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.img_status);
                                                    if (imageView != null) {
                                                        i = R.id.ll_f2;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_f2);
                                                        if (linearLayout != null) {
                                                            i = R.id.row1;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.row1);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.row2;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.row2);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.user_name;
                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, R.id.user_name);
                                                                    if (textView11 != null) {
                                                                        return new C0685Ka((LinearLayout) view, cardView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, imageView, linearLayout, linearLayout2, linearLayout3, textView11);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C0685Ka c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.card_data_det_row_rep6_2, viewGroup, false);
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
