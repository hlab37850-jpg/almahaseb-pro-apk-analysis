package defpackage;

import com.google.android.gms.internal.vision.zzcz;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: da0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2041da0 extends AbstractSet {
    public final /* synthetic */ V90 a;

    public C2041da0(V90 v90) {
        this.a = v90;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map mapO = this.a.o();
        if (mapO != null) {
            return mapO.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int iC = this.a.c(entry.getKey());
            if (iC != -1 && zzcz.zza(this.a.d[iC], entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.a.v();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map mapO = this.a.o();
        if (mapO != null) {
            return mapO.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.a.j()) {
            return false;
        }
        int iY = this.a.y();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object obj2 = this.a.a;
        V90 v90 = this.a;
        int iC = Fa0.c(key, value, iY, obj2, v90.b, v90.c, v90.d);
        if (iC == -1) {
            return false;
        }
        this.a.h(iC, iY);
        V90.t(this.a);
        this.a.r();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.size();
    }
}
