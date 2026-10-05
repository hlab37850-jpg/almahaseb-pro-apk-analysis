package defpackage;

import com.google.android.gms.phenotype.zzi;
import java.util.Comparator;

/* JADX INFO: renamed from: pf0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3657pf0 implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzi zziVar = (zzi) obj;
        zzi zziVar2 = (zzi) obj2;
        int i = zziVar.zzah;
        int i2 = zziVar2.zzah;
        return i == i2 ? zziVar.name.compareTo(zziVar2.name) : i - i2;
    }
}
