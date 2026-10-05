package defpackage;

import android.content.Context;
import com.itextpdf.text.Annotation;
import java.io.InputStream;

/* JADX INFO: renamed from: Kf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0690Kf extends AbstractC4116vL {
    public final Context a;

    public C0690Kf(Context context) {
        this.a = context;
    }

    @Override // defpackage.AbstractC4116vL
    public boolean c(C3792rL c3792rL) {
        return Annotation.CONTENT.equals(c3792rL.d.getScheme());
    }

    @Override // defpackage.AbstractC4116vL
    public AbstractC4116vL.a f(C3792rL c3792rL, int i) {
        return new AbstractC4116vL.a(j(c3792rL), C4192wG.e.DISK);
    }

    public InputStream j(C3792rL c3792rL) {
        return this.a.getContentResolver().openInputStream(c3792rL.d);
    }
}
