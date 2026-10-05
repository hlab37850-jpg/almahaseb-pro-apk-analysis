package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: dx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2071dx implements InterfaceC2421i9 {
    public final LinkedHashMap a;
    public final int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public C2071dx(Context context) {
        this(AbstractC4047uX.b(context));
    }

    @Override // defpackage.InterfaceC2421i9
    public final synchronized int a() {
        return this.b;
    }

    @Override // defpackage.InterfaceC2421i9
    public void b(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            try {
                this.d++;
                this.c += AbstractC4047uX.k(bitmap);
                Bitmap bitmap2 = (Bitmap) this.a.put(str, bitmap);
                if (bitmap2 != null) {
                    this.c -= AbstractC4047uX.k(bitmap2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        c(this.b);
    }

    public final void c(int i) {
        while (true) {
            synchronized (this) {
                try {
                    if (this.c < 0 || (this.a.isEmpty() && this.c != 0)) {
                        break;
                    }
                    if (this.c > i && !this.a.isEmpty()) {
                        Map.Entry entry = (Map.Entry) this.a.entrySet().iterator().next();
                        String str = (String) entry.getKey();
                        Bitmap bitmap = (Bitmap) entry.getValue();
                        this.a.remove(str);
                        this.c -= AbstractC4047uX.k(bitmap);
                        this.e++;
                    }
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    @Override // defpackage.InterfaceC2421i9
    public Bitmap get(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                Bitmap bitmap = (Bitmap) this.a.get(str);
                if (bitmap != null) {
                    this.f++;
                    return bitmap;
                }
                this.g++;
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.InterfaceC2421i9
    public final synchronized int size() {
        return this.c;
    }

    public C2071dx(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.b = i;
        this.a = new LinkedHashMap(0, 0.75f, true);
    }
}
