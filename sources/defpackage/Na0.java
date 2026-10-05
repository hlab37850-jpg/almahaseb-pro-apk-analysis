package defpackage;

import com.google.android.gms.internal.clearcut.zzcb;
import java.lang.reflect.Field;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class Na0 {
    public int A;
    public int B;
    public Field C;
    public Object D;
    public Object E;
    public Object F;
    public final Ra0 a;
    public final Object[] b;
    public Class c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int[] n;
    public int o;
    public int p;
    public int q = Integer.MAX_VALUE;
    public int r = Integer.MIN_VALUE;
    public int s = 0;
    public int t = 0;
    public int u = 0;
    public int v = 0;
    public int w = 0;
    public int x;
    public int y;
    public int z;

    public Na0(Class cls, String str, Object[] objArr) {
        this.c = cls;
        Ra0 ra0 = new Ra0(str);
        this.a = ra0;
        this.b = objArr;
        this.d = ra0.b();
        int iB = ra0.b();
        this.e = iB;
        if (iB == 0) {
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.l = 0;
            this.k = 0;
            this.m = 0;
            this.n = null;
            return;
        }
        int iB2 = ra0.b();
        this.f = iB2;
        int iB3 = ra0.b();
        this.g = iB3;
        this.h = ra0.b();
        this.i = ra0.b();
        this.l = ra0.b();
        this.k = ra0.b();
        this.j = ra0.b();
        this.m = ra0.b();
        int iB4 = ra0.b();
        this.n = iB4 != 0 ? new int[iB4] : null;
        this.o = (iB2 << 1) + iB3;
    }

    public static Field c(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString());
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:40:0x00cc  */
    public final boolean a() {
        int i;
        Object type;
        if (!this.a.a()) {
            return false;
        }
        this.x = this.a.b();
        int iB = this.a.b();
        this.y = iB;
        int i2 = iB & 255;
        this.z = i2;
        int i3 = this.x;
        if (i3 < this.q) {
            this.q = i3;
        }
        if (i3 > this.r) {
            this.r = i3;
        }
        zzcb zzcbVar = zzcb.zziw;
        if (i2 == zzcbVar.id()) {
            this.s++;
        } else if (this.z >= zzcb.zzhq.id() && this.z <= zzcb.zziv.id()) {
            this.t++;
        }
        int i4 = this.w + 1;
        this.w = i4;
        if (Ya0.s(this.q, this.x, i4)) {
            int i5 = this.x + 1;
            this.v = i5;
            i = i5 - this.q;
        } else {
            i = this.u + 1;
        }
        this.u = i;
        if ((this.y & 1024) != 0) {
            int[] iArr = this.n;
            int i6 = this.p;
            this.p = i6 + 1;
            iArr[i6] = this.x;
        }
        this.D = null;
        this.E = null;
        this.F = null;
        if (k()) {
            this.A = this.a.b();
            if (this.z == zzcb.zzhh.id() + 51 || this.z == zzcb.zzhp.id() + 51) {
                type = f();
                this.D = type;
            } else if (this.z == zzcb.zzhk.id() + 51 && i()) {
                this.E = f();
            }
        } else {
            this.C = c(this.c, (String) f());
            if (o()) {
                this.B = this.a.b();
            }
            if (this.z == zzcb.zzhh.id() || this.z == zzcb.zzhp.id()) {
                type = this.C.getType();
                this.D = type;
            } else if (this.z == zzcb.zzhz.id() || this.z == zzcb.zziv.id()) {
                type = f();
                this.D = type;
            } else if (this.z == zzcb.zzhk.id() || this.z == zzcb.zzic.id() || this.z == zzcb.zziq.id()) {
                if (i()) {
                    this.E = f();
                }
            } else if (this.z == zzcbVar.id()) {
                this.F = f();
                if ((this.y & 2048) != 0) {
                    this.E = f();
                }
            }
        }
        return true;
    }

    public final Object f() {
        Object[] objArr = this.b;
        int i = this.o;
        this.o = i + 1;
        return objArr[i];
    }

    public final int g() {
        return this.x;
    }

    public final int h() {
        return this.z;
    }

    public final boolean i() {
        return (this.d & 1) == 1;
    }

    public final boolean k() {
        return this.z > zzcb.zziw.id();
    }

    public final Field l() {
        int i = this.A << 1;
        Object obj = this.b[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field fieldC = c(this.c, (String) obj);
        this.b[i] = fieldC;
        return fieldC;
    }

    public final Field m() {
        int i = (this.A << 1) + 1;
        Object obj = this.b[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field fieldC = c(this.c, (String) obj);
        this.b[i] = fieldC;
        return fieldC;
    }

    public final Field n() {
        return this.C;
    }

    public final boolean o() {
        return i() && this.z <= zzcb.zzhp.id();
    }

    public final Field p() {
        int i = (this.f << 1) + (this.B / 32);
        Object obj = this.b[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field fieldC = c(this.c, (String) obj);
        this.b[i] = fieldC;
        return fieldC;
    }

    public final int q() {
        return this.B % 32;
    }

    public final boolean r() {
        return (this.y & 256) != 0;
    }

    public final boolean s() {
        return (this.y & 512) != 0;
    }

    public final Object t() {
        return this.D;
    }

    public final Object u() {
        return this.E;
    }

    public final Object v() {
        return this.F;
    }
}
