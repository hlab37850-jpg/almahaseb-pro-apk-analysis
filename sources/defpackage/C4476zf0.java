package defpackage;

import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzkk;
import java.util.Map;

/* JADX INFO: renamed from: zf0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4476zf0 implements Map.Entry {
    public Map.Entry a;

    public C4476zf0(Map.Entry entry) {
        this.a = entry;
    }

    public final zzjp a() {
        return (zzjp) this.a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((zzjp) this.a.getValue()) == null) {
            return null;
        }
        return zzjp.zza();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzkk) {
            return ((zzjp) this.a.getValue()).zza((zzkk) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
