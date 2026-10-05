package defpackage;

import com.google.android.gms.internal.auth.zzee;
import com.google.common.primitives.UnsignedBytes;
import java.util.Comparator;

/* JADX INFO: renamed from: ma0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3401ma0 implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzee zzeeVar = (zzee) obj;
        zzee zzeeVar2 = (zzee) obj2;
        C2450ia0 c2450ia0 = new C2450ia0(zzeeVar);
        C2450ia0 c2450ia1 = new C2450ia0(zzeeVar2);
        while (c2450ia0.hasNext() && c2450ia1.hasNext()) {
            int iCompareTo = Integer.valueOf(c2450ia0.zza() & UnsignedBytes.MAX_VALUE).compareTo(Integer.valueOf(c2450ia1.zza() & UnsignedBytes.MAX_VALUE));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzeeVar.zzd()).compareTo(Integer.valueOf(zzeeVar2.zzd()));
    }
}
