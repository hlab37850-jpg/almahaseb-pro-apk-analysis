package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public class DF {
    public static boolean b = false;
    public Paint a;

    public DF(int i) {
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(i);
        this.a.setAntiAlias(b);
    }

    public static DF b(int i) {
        DF df = new DF(i);
        df.d().setStyle(Paint.Style.STROKE);
        return df;
    }

    public static DF c(int i) {
        DF df = new DF(i);
        df.d().setStyle(Paint.Style.FILL);
        return df;
    }

    public RectF a(JF jf, Canvas canvas, Path path) {
        canvas.drawPath(path, this.a);
        RectF rectF = new RectF();
        RectF rectF2 = new RectF();
        path.computeBounds(rectF, false);
        canvas.getMatrix().mapRect(rectF2, rectF);
        return rectF;
    }

    public Paint d() {
        return this.a;
    }
}
