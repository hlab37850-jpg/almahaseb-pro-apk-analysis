package defpackage;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: nm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3503nm extends C0690Kf {
    public C3503nm(Context context) {
        super(context);
    }

    public static int k(Uri uri) {
        int attributeInt = new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
        if (attributeInt == 3) {
            return ShapeTypes.MATH_EQUAL;
        }
        if (attributeInt == 6) {
            return 90;
        }
        if (attributeInt != 8) {
            return 0;
        }
        return TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
    }

    @Override // defpackage.C0690Kf, defpackage.AbstractC4116vL
    public boolean c(C3792rL c3792rL) {
        return Annotation.FILE.equals(c3792rL.d.getScheme());
    }

    @Override // defpackage.C0690Kf, defpackage.AbstractC4116vL
    public AbstractC4116vL.a f(C3792rL c3792rL, int i) {
        return new AbstractC4116vL.a(null, j(c3792rL), C4192wG.e.DISK, k(c3792rL.d));
    }
}
