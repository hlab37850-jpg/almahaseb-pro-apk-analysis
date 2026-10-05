package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import info.aalmoghalis.inventory.R;

/* JADX INFO: renamed from: a2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1193a2 implements ViewBinding {
    public final FrameLayout a;

    public C1193a2(FrameLayout frameLayout) {
        this.a = frameLayout;
    }

    public static C1193a2 a(View view) {
        if (view != null) {
            return new C1193a2((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static C1193a2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C1193a2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_activation, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
