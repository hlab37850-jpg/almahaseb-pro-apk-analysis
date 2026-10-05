package defpackage;

import com.google.android.gms.internal.clearcut.zzcr;
import com.google.android.gms.internal.clearcut.zzdo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class H80 implements Map.Entry {
    public Map.Entry a;

    public H80(Map.Entry entry) {
        this.a = entry;
    }

    public final zzcr a() {
        return (zzcr) this.a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((zzcr) this.a.getValue()) == null) {
            return null;
        }
        return zzcr.zzbr();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzdo) {
            return ((zzcr) this.a.getValue()).zzi((zzdo) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
