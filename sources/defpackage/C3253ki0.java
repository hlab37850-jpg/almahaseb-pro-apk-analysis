package defpackage;

import com.google.android.gms.internal.common.zzq;
import com.google.android.gms.internal.common.zzx;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: renamed from: ki0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3253ki0 implements Iterable {
    public final /* synthetic */ CharSequence a;
    public final /* synthetic */ zzx b;

    public C3253ki0(zzx zzxVar, CharSequence charSequence) {
        this.b = zzxVar;
        this.a = charSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.b.zzh(this.a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                sb.append(zzq.zza(it.next(), ", "));
                while (it.hasNext()) {
                    sb.append((CharSequence) ", ");
                    sb.append(zzq.zza(it.next(), ", "));
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
