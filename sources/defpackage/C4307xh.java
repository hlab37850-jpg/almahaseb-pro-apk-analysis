package defpackage;

import androidx.recyclerview.widget.DiffUtil;

/* JADX INFO: renamed from: xh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4307xh extends DiffUtil.ItemCallback {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(C4145vh c4145vh, C4145vh c4145vh2) {
        return C2160f10.X(c4145vh.v()).equals(C2160f10.X(c4145vh2.v())) && C2160f10.X(c4145vh.a()).equals(C2160f10.X(c4145vh2.a())) && C2160f10.X(c4145vh.n()).equals(C2160f10.X(c4145vh2.n())) && C2160f10.X(c4145vh.o()).equals(C2160f10.X(c4145vh2.o())) && C2160f10.X(c4145vh.p()).equals(C2160f10.X(c4145vh2.p())) && C2160f10.X(c4145vh.q()).equals(C2160f10.X(c4145vh2.q())) && C2160f10.X(c4145vh.r()).equals(C2160f10.X(c4145vh2.r())) && C2160f10.X(c4145vh.s()).equals(C2160f10.X(c4145vh2.s())) && C2160f10.X(c4145vh.t()).equals(C2160f10.X(c4145vh2.t())) && C2160f10.X(c4145vh.k).equals(C2160f10.X(c4145vh2.k)) && C2160f10.X(c4145vh.i).equals(C2160f10.X(c4145vh2.i));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(C4145vh c4145vh, C4145vh c4145vh2) {
        return c4145vh.v().equals(c4145vh2.v());
    }
}
