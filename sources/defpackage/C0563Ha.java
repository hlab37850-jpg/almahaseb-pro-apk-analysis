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

/* JADX INFO: renamed from: Ha, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0563Ha implements ViewBinding {
    public final LinearLayout a;
    public final CardView b;
    public final ImageView c;
    public final LinearLayout d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;

    public C0563Ha(LinearLayout linearLayout, CardView cardView, ImageView imageView, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.a = linearLayout;
        this.b = cardView;
        this.c = imageView;
        this.d = linearLayout2;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
        this.i = textView5;
        this.j = textView6;
    }

    public static C0563Ha a(View view) {
        int i = R.id.card_view;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.card_view);
        if (cardView != null) {
            i = R.id.img;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.img);
            if (imageView != null) {
                i = R.id.ll_card;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_card);
                if (linearLayout != null) {
                    i = R.id.tr_amount;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tr_amount);
                    if (textView != null) {
                        i = R.id.tr_bal;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tr_bal);
                        if (textView2 != null) {
                            i = R.id.tr_date;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tr_date);
                            if (textView3 != null) {
                                i = R.id.tr_id;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tr_id);
                                if (textView4 != null) {
                                    i = R.id.tr_remarks;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tr_remarks);
                                    if (textView5 != null) {
                                        i = R.id.tr_time;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tr_time);
                                        if (textView6 != null) {
                                            return new C0563Ha((LinearLayout) view, cardView, imageView, linearLayout, textView, textView2, textView3, textView4, textView5, textView6);
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

    public static C0563Ha c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.card_customer_det_row3, viewGroup, false);
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
