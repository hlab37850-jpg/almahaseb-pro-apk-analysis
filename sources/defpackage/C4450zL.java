package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.FileNotFoundException;

/* JADX INFO: renamed from: zL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4450zL extends AbstractC4116vL {
    public final Context a;

    public C4450zL(Context context) {
        this.a = context;
    }

    public static Bitmap j(Resources resources, int i, C3792rL c3792rL) {
        BitmapFactory.Options optionsD = AbstractC4116vL.d(c3792rL);
        if (AbstractC4116vL.g(optionsD)) {
            BitmapFactory.decodeResource(resources, i, optionsD);
            AbstractC4116vL.b(c3792rL.h, c3792rL.i, optionsD, c3792rL);
        }
        return BitmapFactory.decodeResource(resources, i, optionsD);
    }

    @Override // defpackage.AbstractC4116vL
    public boolean c(C3792rL c3792rL) {
        if (c3792rL.e != 0) {
            return true;
        }
        return "android.resource".equals(c3792rL.d.getScheme());
    }

    @Override // defpackage.AbstractC4116vL
    public AbstractC4116vL.a f(C3792rL c3792rL, int i) throws FileNotFoundException {
        Resources resourcesO = AbstractC4047uX.o(this.a, c3792rL);
        return new AbstractC4116vL.a(j(resourcesO, AbstractC4047uX.n(resourcesO, c3792rL), c3792rL), C4192wG.e.DISK);
    }
}
