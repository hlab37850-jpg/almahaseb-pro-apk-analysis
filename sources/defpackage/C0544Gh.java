package defpackage;

import androidx.recyclerview.widget.DiffUtil;

/* JADX INFO: renamed from: Gh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0544Gh extends DiffUtil.ItemCallback {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
        return c0795Oh.o().equals(c0795Oh2.o()) && c0795Oh.l().equals(c0795Oh2.l()) && C2160f10.X(c0795Oh.q()).equals(C2160f10.X(c0795Oh2.q())) && c0795Oh.n().equals(c0795Oh2.n()) && c0795Oh.p().equals(c0795Oh2.l());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
        return c0795Oh.o().equals(c0795Oh2.o());
    }
}
