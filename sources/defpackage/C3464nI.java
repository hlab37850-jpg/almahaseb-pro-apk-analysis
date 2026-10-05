package defpackage;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import info.aalmoghalis.inventory.R;

/* JADX INFO: renamed from: nI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3464nI implements ViewBinding {
    public final LinearLayout a;
    public final ProgressBar b;

    public C3464nI(LinearLayout linearLayout, ProgressBar progressBar) {
        this.a = linearLayout;
        this.b = progressBar;
    }

    public static C3464nI a(View view) {
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.loader);
        if (progressBar != null) {
            return new C3464nI((LinearLayout) view, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.loader)));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
