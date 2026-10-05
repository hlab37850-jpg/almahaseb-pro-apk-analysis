package defpackage;

import com.google.android.gms.internal.vision.zzcz;
import java.util.Map;

/* JADX INFO: renamed from: sa0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3889sa0 extends N90 {
    public final Object a;
    public int b;
    public final /* synthetic */ V90 c;

    public C3889sa0(V90 v90, int i) {
        this.c = v90;
        this.a = v90.c[i];
        this.b = i;
    }

    public final void a() {
        int i = this.b;
        if (i == -1 || i >= this.c.size() || !zzcz.zza(this.a, this.c.c[this.b])) {
            this.b = this.c.c(this.a);
        }
    }

    @Override // defpackage.N90, java.util.Map.Entry
    public final Object getKey() {
        return this.a;
    }

    @Override // defpackage.N90, java.util.Map.Entry
    public final Object getValue() {
        Map mapO = this.c.o();
        if (mapO != null) {
            return mapO.get(this.a);
        }
        a();
        int i = this.b;
        if (i == -1) {
            return null;
        }
        return this.c.d[i];
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map mapO = this.c.o();
        if (mapO != null) {
            return mapO.put(this.a, obj);
        }
        a();
        int i = this.b;
        if (i == -1) {
            this.c.put(this.a, obj);
            return null;
        }
        Object[] objArr = this.c.d;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }
}
