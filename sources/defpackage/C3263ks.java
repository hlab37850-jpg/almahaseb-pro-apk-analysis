package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: renamed from: ks, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3263ks extends X1 {
    public C3263ks(C4192wG c4192wG, ImageView imageView, C3792rL c3792rL, int i, int i2, int i3, Drawable drawable, String str, Object obj, InterfaceC3400ma interfaceC3400ma, boolean z) {
        super(c4192wG, imageView, c3792rL, i, i2, i3, drawable, str, obj, z);
    }

    @Override // defpackage.X1
    public void a() {
        super.a();
    }

    @Override // defpackage.X1
    public void b(Bitmap bitmap, C4192wG.e eVar) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        ImageView imageView = (ImageView) this.c.get();
        if (imageView == null) {
            return;
        }
        C4192wG c4192wG = this.a;
        C4273xG.c(imageView, c4192wG.d, bitmap, eVar, this.d, c4192wG.l);
    }

    @Override // defpackage.X1
    public void c() {
        ImageView imageView = (ImageView) this.c.get();
        if (imageView == null) {
            return;
        }
        int i = this.g;
        if (i != 0) {
            imageView.setImageResource(i);
            return;
        }
        Drawable drawable = this.h;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }
}
