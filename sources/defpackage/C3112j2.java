package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import info.aalmoghalis.inventory.R;

/* JADX INFO: renamed from: j2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3112j2 implements ViewBinding {
    public final RelativeLayout a;
    public final RecyclerView b;

    public C3112j2(RelativeLayout relativeLayout, RecyclerView recyclerView) {
        this.a = relativeLayout;
        this.b = recyclerView;
    }

    public static C3112j2 a(View view) {
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.idRVCourse);
        if (recyclerView != null) {
            return new C3112j2((RelativeLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.idRVCourse)));
    }

    public static C3112j2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C3112j2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_reminders, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
