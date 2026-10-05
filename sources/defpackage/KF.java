package defpackage;

import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public class KF extends AbstractC3215kF {
    public Path a;
    public int b;
    public RectF c;

    public KF(Path path, int i) {
        this.a = new Path(path);
        this.b = i;
        RectF rectF = new RectF();
        this.c = rectF;
        path.computeBounds(rectF, false);
    }

    @Override // defpackage.AbstractC3215kF
    public RectF a(JF jf) {
        RectF rectFO;
        if ((this.b & 2) != 0) {
            rectFO = jf.o(this.a);
            Path path = this.a;
            if (path != null) {
                jf.w(path);
            }
        } else {
            rectFO = null;
        }
        if ((this.b & 1) != 0) {
            RectF rectFB = jf.B(this.a);
            if (rectFO == null) {
                rectFO = rectFB;
            } else {
                rectFO.union(rectFB);
            }
        }
        if ((this.b & 4) != 0) {
            jf.l(this.a);
        }
        return rectFO;
    }
}
