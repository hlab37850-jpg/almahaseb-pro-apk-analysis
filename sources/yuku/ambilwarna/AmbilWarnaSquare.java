package yuku.ambilwarna;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes4.dex */
public class AmbilWarnaSquare extends View {
    public Paint a;
    public Shader b;
    public final float[] c;

    public AmbilWarnaSquare(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new float[]{1.0f, 1.0f, 1.0f};
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.a == null) {
            this.a = new Paint();
            this.b = new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), -1, ViewCompat.MEASURED_STATE_MASK, Shader.TileMode.CLAMP);
        }
        this.a.setShader(new ComposeShader(this.b, new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, -1, Color.HSVToColor(this.c), Shader.TileMode.CLAMP), PorterDuff.Mode.MULTIPLY));
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.a);
    }

    public void setHue(float f) {
        this.c[0] = f;
        invalidate();
    }

    public AmbilWarnaSquare(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new float[]{1.0f, 1.0f, 1.0f};
    }
}
