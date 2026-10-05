package defpackage;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.itextpdf.text.Annotation;

/* JADX INFO: loaded from: classes3.dex */
public class FB extends C0690Kf {
    public static final String[] b = {"orientation"};

    public enum a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);

        public final int a;
        public final int b;
        public final int c;

        a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    public FB(Context context) {
        super(context);
    }

    public static int k(ContentResolver contentResolver, Uri uri) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = contentResolver.query(uri, b, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int i = cursorQuery.getInt(0);
                cursorQuery.close();
                return i;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public static a l(int i, int i2) {
        a aVar = a.MICRO;
        if (i <= aVar.b && i2 <= aVar.c) {
            return aVar;
        }
        a aVar2 = a.MINI;
        return (i > aVar2.b || i2 > aVar2.c) ? a.FULL : aVar2;
    }

    @Override // defpackage.C0690Kf, defpackage.AbstractC4116vL
    public boolean c(C3792rL c3792rL) {
        Uri uri = c3792rL.d;
        return Annotation.CONTENT.equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    @Override // defpackage.C0690Kf, defpackage.AbstractC4116vL
    public AbstractC4116vL.a f(C3792rL c3792rL, int i) {
        Bitmap thumbnail;
        ContentResolver contentResolver = this.a.getContentResolver();
        int iK = k(contentResolver, c3792rL.d);
        String type = contentResolver.getType(c3792rL.d);
        boolean z = type != null && type.startsWith("video/");
        if (c3792rL.c()) {
            a aVarL = l(c3792rL.h, c3792rL.i);
            if (!z && aVarL == a.FULL) {
                return new AbstractC4116vL.a(null, j(c3792rL), C4192wG.e.DISK, iK);
            }
            long id = ContentUris.parseId(c3792rL.d);
            BitmapFactory.Options optionsD = AbstractC4116vL.d(c3792rL);
            optionsD.inJustDecodeBounds = true;
            AbstractC4116vL.a(c3792rL.h, c3792rL.i, aVarL.b, aVarL.c, optionsD, c3792rL);
            if (z) {
                thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, id, aVarL == a.FULL ? 1 : aVarL.a, optionsD);
            } else {
                thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, id, aVarL.a, optionsD);
            }
            if (thumbnail != null) {
                return new AbstractC4116vL.a(thumbnail, null, C4192wG.e.DISK, iK);
            }
        }
        return new AbstractC4116vL.a(null, j(c3792rL), C4192wG.e.DISK, iK);
    }
}
