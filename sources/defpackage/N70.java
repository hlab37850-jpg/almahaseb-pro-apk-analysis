package defpackage;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.vision.text.Text;

/* JADX INFO: loaded from: classes2.dex */
public abstract class N70 {
    public static Rect a(Text text) {
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax = Integer.MIN_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        for (Point point : text.getCornerPoints()) {
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
        }
        return new Rect(iMin, iMin2, iMax, iMax2);
    }

    public static Point[] b(zzab zzabVar) {
        double dSin = Math.sin(Math.toRadians(zzabVar.zze));
        double dCos = Math.cos(Math.toRadians(zzabVar.zze));
        double d = zzabVar.zza;
        int i = zzabVar.zzc;
        Point[] pointArr = {new Point(zzabVar.zza, zzabVar.zzb), new Point((int) (d + (((double) i) * dCos)), (int) (((double) zzabVar.zzb) + (((double) i) * dSin))), new Point((int) (d - (((double) i) * dSin)), (int) (((double) point.y) + (((double) i) * dCos))), new Point(i + (i - point.x), point.y + (point.y - point.y))};
        Point point = pointArr[1];
        double d2 = point.x;
        int i2 = zzabVar.zzd;
        Point point2 = pointArr[0];
        int i3 = point2.x;
        Point point3 = pointArr[2];
        int i4 = point3.x;
        Point point4 = pointArr[1];
        return pointArr;
    }
}
