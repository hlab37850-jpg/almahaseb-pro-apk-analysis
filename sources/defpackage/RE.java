package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class RE {
    public final float a;
    public int b;
    public int c;
    public int d;
    public Object[] e;

    public RE() {
        this(16, 0.75f);
    }

    public static int c(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public boolean a(Object obj) {
        Object obj2;
        Object[] objArr = this.e;
        int i = this.b;
        int iC = c(obj.hashCode()) & i;
        Object obj3 = objArr[iC];
        if (obj3 != null) {
            if (obj3.equals(obj)) {
                return false;
            }
            do {
                iC = (iC + 1) & i;
                obj2 = objArr[iC];
                if (obj2 == null) {
                }
            } while (!obj2.equals(obj));
            return false;
        }
        objArr[iC] = obj;
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 >= this.d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.e;
    }

    public void d() {
        Object obj;
        Object[] objArr = this.e;
        int length = objArr.length;
        int i = length << 1;
        int i2 = i - 1;
        Object[] objArr2 = new Object[i];
        int i3 = this.c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                this.b = i2;
                this.d = (int) (i * this.a);
                this.e = objArr2;
                return;
            }
            do {
                length--;
                obj = objArr[length];
            } while (obj == null);
            int iC = c(obj.hashCode()) & i2;
            if (objArr2[iC] != null) {
                do {
                    iC = (iC + 1) & i2;
                } while (objArr2[iC] != null);
            }
            objArr2[iC] = objArr[length];
            i3 = i4;
        }
    }

    public boolean e(Object obj) {
        Object obj2;
        Object[] objArr = this.e;
        int i = this.b;
        int iC = c(obj.hashCode()) & i;
        Object obj3 = objArr[iC];
        if (obj3 == null) {
            return false;
        }
        if (obj3.equals(obj)) {
            return f(iC, objArr, i);
        }
        do {
            iC = (iC + 1) & i;
            obj2 = objArr[iC];
            if (obj2 == null) {
                return false;
            }
        } while (!obj2.equals(obj));
        return f(iC, objArr, i);
    }

    public boolean f(int i, Object[] objArr, int i2) {
        int i3;
        Object obj;
        this.c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                obj = objArr[i3];
                if (obj != null) {
                    int iC = c(obj.hashCode()) & i2;
                    if (i > i3) {
                        if (i >= iC && iC > i3) {
                            break;
                        }
                        i4 = i3 + 1;
                    } else {
                        if (i >= iC || iC > i3) {
                            break;
                        }
                        i4 = i3 + 1;
                    }
                } else {
                    objArr[i] = null;
                    return true;
                }
            }
            objArr[i] = obj;
            i = i3;
        }
    }

    public RE(int i, float f) {
        this.a = f;
        int iA = AbstractC1216aH.a(i);
        this.b = iA - 1;
        this.d = (int) (f * iA);
        this.e = new Object[iA];
    }
}
