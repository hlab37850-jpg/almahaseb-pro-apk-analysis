package defpackage;

import com.google.android.gms.internal.auth.zzey;
import com.google.android.gms.internal.auth.zzfh;

/* JADX INFO: renamed from: ec0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2126ec0 extends AbstractC3159jc0 {
    public /* synthetic */ C2126ec0(zzfh zzfhVar) {
        super(null);
    }

    @Override // defpackage.AbstractC3159jc0
    public final void a(Object obj, long j) {
        ((zzey) AbstractC1244ae0.f(obj, j)).zzb();
    }

    @Override // defpackage.AbstractC3159jc0
    public final void b(Object obj, Object obj2, long j) {
        zzey zzeyVarZzd = (zzey) AbstractC1244ae0.f(obj, j);
        zzey zzeyVar = (zzey) AbstractC1244ae0.f(obj2, j);
        int size = zzeyVarZzd.size();
        int size2 = zzeyVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzeyVarZzd.zzc()) {
                zzeyVarZzd = zzeyVarZzd.zzd(size2 + size);
            }
            zzeyVarZzd.addAll(zzeyVar);
        }
        if (size > 0) {
            zzeyVar = zzeyVarZzd;
        }
        AbstractC1244ae0.p(obj, j, zzeyVar);
    }
}
