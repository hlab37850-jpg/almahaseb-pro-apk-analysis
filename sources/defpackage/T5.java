package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.itextpdf.text.Annotation;

/* JADX INFO: loaded from: classes3.dex */
public class T5 extends AbstractC4116vL {
    public static final int b = 22;
    public final AssetManager a;

    public T5(Context context) {
        this.a = context.getAssets();
    }

    public static String j(C3792rL c3792rL) {
        return c3792rL.d.toString().substring(b);
    }

    @Override // defpackage.AbstractC4116vL
    public boolean c(C3792rL c3792rL) {
        Uri uri = c3792rL.d;
        return Annotation.FILE.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    @Override // defpackage.AbstractC4116vL
    public AbstractC4116vL.a f(C3792rL c3792rL, int i) {
        return new AbstractC4116vL.a(this.a.open(j(c3792rL)), C4192wG.e.DISK);
    }
}
