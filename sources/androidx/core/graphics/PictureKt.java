package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import defpackage.AbstractC0703Ks;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PictureKt {
    public static final Picture record(Picture picture, int i, int i2, InterfaceC3750qp interfaceC3750qp) {
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        try {
            interfaceC3750qp.invoke(canvasBeginRecording);
            return picture;
        } finally {
            AbstractC0703Ks.b(1);
            picture.endRecording();
            AbstractC0703Ks.a(1);
        }
    }
}
