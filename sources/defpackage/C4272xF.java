package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: renamed from: xF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4272xF {
    public char a;
    public String b;
    public PointF c;
    public Path d;
    public CF e;

    public C4272xF(char c, String str, Path path, PointF pointF) {
        this.d = path;
        this.c = pointF;
        this.a = c;
        this.b = str;
    }

    public PointF a(CF cf, Matrix matrix, int i) {
        if (this.d != null) {
            Path path = new Path();
            this.d.transform(matrix, path);
            cf.a(new KF(path, i));
        } else {
            CF cf2 = this.e;
            if (cf2 != null) {
                cf.c(cf2, matrix);
            }
        }
        return this.c;
    }

    public char b() {
        return this.a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        return stringBuffer.toString();
    }

    public C4272xF(char c, String str, CF cf, PointF pointF) {
        this.e = cf;
        this.c = pointF;
        this.a = c;
        this.b = str;
    }
}
