package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import info.aalmoghalis.inventory.R;

/* JADX INFO: renamed from: jj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3172jj implements ViewBinding {
    public final LinearLayout a;
    public final AutoCompleteTextView b;

    public C3172jj(LinearLayout linearLayout, AutoCompleteTextView autoCompleteTextView) {
        this.a = linearLayout;
        this.b = autoCompleteTextView;
    }

    public static C3172jj a(View view) {
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) ViewBindings.findChildViewById(view, R.id.info_name);
        if (autoCompleteTextView != null) {
            return new C3172jj((LinearLayout) view, autoCompleteTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.info_name)));
    }

    public static C3172jj c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C3172jj d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_info, viewGroup, false);
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
