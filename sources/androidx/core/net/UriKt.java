package androidx.core.net;

import android.net.Uri;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class UriKt {
    public static final File toFile(Uri uri) {
        if (!AbstractC4492zt.d(uri.getScheme(), Annotation.FILE)) {
            throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
    }

    public static final Uri toUri(String str) {
        return Uri.parse(str);
    }

    public static final Uri toUri(File file) {
        return Uri.fromFile(file);
    }
}
