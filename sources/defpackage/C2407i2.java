package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import info.aalmoghalis.inventory.R;

/* JADX INFO: renamed from: i2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2407i2 implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;
    public final Button c;
    public final ProgressBar d;
    public final RecyclerView e;
    public final Button f;

    public C2407i2(LinearLayout linearLayout, TextView textView, Button button, ProgressBar progressBar, RecyclerView recyclerView, Button button2) {
        this.a = linearLayout;
        this.b = textView;
        this.c = button;
        this.d = progressBar;
        this.e = recyclerView;
        this.f = button2;
    }

    public static C2407i2 a(View view) {
        int i = R.id.info_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.info_name);
        if (textView != null) {
            i = R.id.online_add;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.online_add);
            if (button != null) {
                i = R.id.progress_bar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress_bar);
                if (progressBar != null) {
                    i = R.id.recycler_view;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view);
                    if (recyclerView != null) {
                        i = R.id.refresh_online;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.refresh_online);
                        if (button2 != null) {
                            return new C2407i2((LinearLayout) view, textView, button, progressBar, recyclerView, button2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C2407i2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C2407i2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_online_status, viewGroup, false);
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
