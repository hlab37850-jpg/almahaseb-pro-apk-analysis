package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import info.aalmoghalis.inventory.R;

/* JADX INFO: renamed from: Ma, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0736Ma implements ViewBinding {
    public final LinearLayout a;
    public final CheckBox b;
    public final CardView c;
    public final CheckBox d;
    public final CheckBox e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final TextView h;
    public final CheckBox i;

    public C0736Ma(LinearLayout linearLayout, CheckBox checkBox, CardView cardView, CheckBox checkBox2, CheckBox checkBox3, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, CheckBox checkBox4) {
        this.a = linearLayout;
        this.b = checkBox;
        this.c = cardView;
        this.d = checkBox2;
        this.e = checkBox3;
        this.f = linearLayout2;
        this.g = linearLayout3;
        this.h = textView;
        this.i = checkBox4;
    }

    public static C0736Ma a(View view) {
        int i = R.id.add;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.add);
        if (checkBox != null) {
            i = R.id.card_view;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.card_view);
            if (cardView != null) {
                i = R.id.del;
                CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.del);
                if (checkBox2 != null) {
                    i = R.id.edit;
                    CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.edit);
                    if (checkBox3 != null) {
                        i = R.id.row1;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.row1);
                        if (linearLayout != null) {
                            i = R.id.row_all;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.row_all);
                            if (linearLayout2 != null) {
                                i = R.id.screen_name;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.screen_name);
                                if (textView != null) {
                                    i = R.id.view;
                                    CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.view);
                                    if (checkBox4 != null) {
                                        return new C0736Ma((LinearLayout) view, checkBox, cardView, checkBox2, checkBox3, linearLayout, linearLayout2, textView, checkBox4);
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

    public static C0736Ma c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.card_userpriv_layout, viewGroup, false);
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
