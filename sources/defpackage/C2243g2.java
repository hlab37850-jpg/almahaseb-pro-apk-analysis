package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import info.aalmoghalis.inventory.R;

/* JADX INFO: renamed from: g2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2243g2 implements ViewBinding {
    public final LinearLayout a;
    public final AutoCompleteTextView b;
    public final LinearLayout c;
    public final Button d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final ImageView h;
    public final ScrollView i;
    public final EditText j;

    public C2243g2(LinearLayout linearLayout, AutoCompleteTextView autoCompleteTextView, LinearLayout linearLayout2, Button button, TextView textView, TextView textView2, TextView textView3, ImageView imageView, ScrollView scrollView, EditText editText) {
        this.a = linearLayout;
        this.b = autoCompleteTextView;
        this.c = linearLayout2;
        this.d = button;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = imageView;
        this.i = scrollView;
        this.j = editText;
    }

    public static C2243g2 a(View view) {
        int i = R.id.email;
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) ViewBindings.findChildViewById(view, R.id.email);
        if (autoCompleteTextView != null) {
            i = R.id.email_login_form;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.email_login_form);
            if (linearLayout != null) {
                i = R.id.email_sign_in_button;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.email_sign_in_button);
                if (button != null) {
                    i = R.id.err_msg;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.err_msg);
                    if (textView != null) {
                        i = R.id.errorText;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.errorText);
                        if (textView2 != null) {
                            i = R.id.forget_password;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.forget_password);
                            if (textView3 != null) {
                                i = R.id.img_icon;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.img_icon);
                                if (imageView != null) {
                                    i = R.id.login_form;
                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.login_form);
                                    if (scrollView != null) {
                                        i = R.id.password;
                                        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.password);
                                        if (editText != null) {
                                            return new C2243g2((LinearLayout) view, autoCompleteTextView, linearLayout, button, textView, textView2, textView3, imageView, scrollView, editText);
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

    public static C2243g2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C2243g2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_login, viewGroup, false);
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
