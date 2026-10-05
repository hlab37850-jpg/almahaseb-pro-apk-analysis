package defpackage;

import com.google.android.gms.internal.clearcut.zzci;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class Da0 {
    public static final Da0 c = new Da0();
    public final Ua0 a;
    public final ConcurrentMap b = new ConcurrentHashMap();

    public Da0() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        Ua0 ua0C = null;
        for (int i = 0; i <= 0; i++) {
            ua0C = c(strArr[0]);
            if (ua0C != null) {
                break;
            }
        }
        this.a = ua0C == null ? new A90() : ua0C;
    }

    public static Da0 a() {
        return c;
    }

    public static Ua0 c(String str) {
        try {
            return (Ua0) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Ta0 b(Class cls) {
        zzci.zza(cls, "messageType");
        Ta0 ta0 = (Ta0) this.b.get(cls);
        if (ta0 != null) {
            return ta0;
        }
        Ta0 ta0A = this.a.a(cls);
        zzci.zza(cls, "messageType");
        zzci.zza(ta0A, "schema");
        Ta0 ta1 = (Ta0) this.b.putIfAbsent(cls, ta0A);
        return ta1 != null ? ta1 : ta0A;
    }

    public final Ta0 d(Object obj) {
        return b(obj.getClass());
    }
}
