package defpackage;

import androidx.recyclerview.widget.DiffUtil;

/* JADX INFO: renamed from: wh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4226wh extends DiffUtil.ItemCallback {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(C4064uh c4064uh, C4064uh c4064uh2) {
        return c4064uh.q().equals(c4064uh2.q()) && c4064uh.n().equals(c4064uh2.n()) && C2160f10.X(c4064uh.r()).equals(C2160f10.X(c4064uh2.r())) && c4064uh.p().equals(c4064uh2.p()) && c4064uh.b().equals(c4064uh2.b()) && C2160f10.X(c4064uh.s()).equals(C2160f10.X(c4064uh2.s())) && c4064uh.f().equals(c4064uh2.f()) && c4064uh.t() == c4064uh2.t() && C2160f10.X(c4064uh.o()).equals(C2160f10.X(c4064uh2.o()));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(C4064uh c4064uh, C4064uh c4064uh2) {
        return c4064uh.q().equals(c4064uh2.q());
    }
}
