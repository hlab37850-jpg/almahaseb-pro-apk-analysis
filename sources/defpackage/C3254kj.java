package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import info.aalmoghalis.inventory.R;

/* JADX INFO: renamed from: kj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3254kj implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final CheckBox f;
    public final EditText g;
    public final EditText h;
    public final TextView i;
    public final TextView j;

    public C3254kj(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, CheckBox checkBox, EditText editText, EditText editText2, TextView textView5, TextView textView6) {
        this.a = linearLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
        this.f = checkBox;
        this.g = editText;
        this.h = editText2;
        this.i = textView5;
        this.j = textView6;
    }

    public static C3254kj a(View view) {
        int i = R.id.branch_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.branch_name);
        if (textView != null) {
            i = R.id.cash_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.cash_name);
            if (textView2 != null) {
                i = R.id.cash_name_hdr;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.cash_name_hdr);
                if (textView3 != null) {
                    i = R.id.cus_name_hdr;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.cus_name_hdr);
                    if (textView4 != null) {
                        i = R.id.is_active;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.is_active);
                        if (checkBox != null) {
                            i = R.id.name;
                            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.name);
                            if (editText != null) {
                                i = R.id.pwd;
                                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.pwd);
                                if (editText2 != null) {
                                    i = R.id.pwd_hdr;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.pwd_hdr);
                                    if (textView5 != null) {
                                        i = R.id.remarks_hdr;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.remarks_hdr);
                                        if (textView6 != null) {
                                            return new C3254kj((LinearLayout) view, textView, textView2, textView3, textView4, checkBox, editText, editText2, textView5, textView6);
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

    public static C3254kj c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C3254kj d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_user, viewGroup, false);
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
