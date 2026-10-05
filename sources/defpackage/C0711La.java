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

/* JADX INFO: renamed from: La, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0711La implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;
    public final CardView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final LinearLayout k;
    public final LinearLayout l;
    public final TextView n;

    public C0711La(LinearLayout linearLayout, TextView textView, CardView cardView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView5) {
        this.a = linearLayout;
        this.b = textView;
        this.c = cardView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = imageView;
        this.h = imageView2;
        this.i = imageView3;
        this.j = imageView4;
        this.k = linearLayout2;
        this.l = linearLayout3;
        this.n = textView5;
    }

    public static C0711La a(View view) {
        int i = R.id.branch_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.branch_name);
        if (textView != null) {
            i = R.id.card_view;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.card_view);
            if (cardView != null) {
                i = R.id.cash_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.cash_name);
                if (textView2 != null) {
                    i = R.id.hide1;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.hide1);
                    if (textView3 != null) {
                        i = R.id.id_no;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.id_no);
                        if (textView4 != null) {
                            i = R.id.img_delete;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.img_delete);
                            if (imageView != null) {
                                i = R.id.img_edit;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.img_edit);
                                if (imageView2 != null) {
                                    i = R.id.img_report;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.img_report);
                                    if (imageView3 != null) {
                                        i = R.id.img_setting;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.img_setting);
                                        if (imageView4 != null) {
                                            i = R.id.row1;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.row1);
                                            if (linearLayout != null) {
                                                i = R.id.row_all;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.row_all);
                                                if (linearLayout2 != null) {
                                                    i = R.id.user_name;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.user_name);
                                                    if (textView5 != null) {
                                                        return new C0711La((LinearLayout) view, textView, cardView, textView2, textView3, textView4, imageView, imageView2, imageView3, imageView4, linearLayout, linearLayout2, textView5);
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

    public static C0711La c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.card_user_layout, viewGroup, false);
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
