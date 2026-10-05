package defpackage;

import com.google.android.gms.internal.common.zzag;

/* JADX INFO: renamed from: o40, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3527o40 extends Li0 {
    public final zzag c;

    public C3527o40(zzag zzagVar, int i) {
        super(zzagVar.size(), i);
        this.c = zzagVar;
    }

    @Override // defpackage.Li0
    public final Object a(int i) {
        return this.c.get(i);
    }
}
