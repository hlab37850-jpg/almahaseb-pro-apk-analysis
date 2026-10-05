package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import info.aalmoghalis.inventory.R;

/* JADX INFO: renamed from: h2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2325h2 implements ViewBinding {
    public final LinearLayout a;
    public final LinearLayout b;
    public final TextView c;
    public final TextView d;
    public final EditText e;
    public final ImageView f;
    public final ScrollView g;
    public final EditText h;
    public final Button i;

    public C2325h2(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, EditText editText, ImageView imageView, ScrollView scrollView, EditText editText2, Button button) {
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = textView;
        this.d = textView2;
        this.e = editText;
        this.f = imageView;
        this.g = scrollView;
        this.h = editText2;
        this.i = button;
    }

    public static C2325h2 a(View view) {
        int i = R.id.email_login_form;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.email_login_form);
        if (linearLayout != null) {
            i = R.id.err_msg;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.err_msg);
            if (textView != null) {
                i = R.id.forget_password;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.forget_password);
                if (textView2 != null) {
                    i = R.id.id_no;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.id_no);
                    if (editText != null) {
                        i = R.id.img_icon;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.img_icon);
                        if (imageView != null) {
                            i = R.id.login_form;
                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.login_form);
                            if (scrollView != null) {
                                i = R.id.password;
                                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.password);
                                if (editText2 != null) {
                                    i = R.id.sign_in_button;
                                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.sign_in_button);
                                    if (button != null) {
                                        return new C2325h2((LinearLayout) view, linearLayout, textView, textView2, editText, imageView, scrollView, editText2, button);
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

    public static C2325h2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C2325h2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_login_pwd, viewGroup, false);
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
