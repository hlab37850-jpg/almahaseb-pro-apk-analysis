package yuku.ambilwarna.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class AmbilWarnaPrefWidgetView extends View {
    public Paint a;
    public float b;
    public float c;

    public AmbilWarnaPrefWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f = context.getResources().getDisplayMetrics().density;
        this.b = (float) Math.floor((24.0f * f) + 0.5f);
        this.c = (float) Math.floor((f * 1.0f) + 0.5f);
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(-1);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.c);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.c;
        float f2 = this.b;
        canvas.drawRect(f, f, f2 - f, f2 - f, this.a);
    }
}
