package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/* JADX INFO: renamed from: x7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4261x7 {
    public Bitmap a;
    public Canvas b;

    public C4261x7(Bitmap bitmap, Canvas canvas) {
        this.a = bitmap;
        this.b = canvas;
    }

    public Canvas a() {
        if (this.b == null) {
            this.b = new Canvas(this.a);
        }
        return this.b;
    }
}
