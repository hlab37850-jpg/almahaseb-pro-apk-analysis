package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzah;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.D30;
import defpackage.N70;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TextBlock implements Text {
    private zzah[] zza;
    private Point[] zzb;
    private List<Line> zzc;
    private String zzd;
    private Rect zze;

    public TextBlock(SparseArray<zzah> sparseArray) {
        this.zza = new zzah[sparseArray.size()];
        int i = 0;
        while (true) {
            zzah[] zzahVarArr = this.zza;
            if (i >= zzahVarArr.length) {
                return;
            }
            zzahVarArr[i] = sparseArray.valueAt(i);
            i++;
        }
    }

    @Override // com.google.android.gms.vision.text.Text
    @RecentlyNonNull
    public Rect getBoundingBox() {
        if (this.zze == null) {
            this.zze = N70.a(this);
        }
        return this.zze;
    }

    @Override // com.google.android.gms.vision.text.Text
    @RecentlyNonNull
    public List<? extends Text> getComponents() {
        if (this.zza.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzc == null) {
            this.zzc = new ArrayList(this.zza.length);
            for (zzah zzahVar : this.zza) {
                this.zzc.add(new Line(zzahVar));
            }
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.vision.text.Text
    @RecentlyNonNull
    public Point[] getCornerPoints() {
        TextBlock textBlock;
        zzah[] zzahVarArr;
        TextBlock textBlock2 = this;
        int i = 4;
        char c = 0;
        if (textBlock2.zzb != null) {
            textBlock = textBlock2;
        } else if (textBlock2.zza.length == 0) {
            textBlock2.zzb = new Point[0];
            textBlock = textBlock2;
        } else {
            int iMax = Integer.MIN_VALUE;
            int iMax2 = Integer.MIN_VALUE;
            int iMin = Integer.MAX_VALUE;
            int iMin2 = Integer.MAX_VALUE;
            int i2 = 0;
            while (true) {
                zzahVarArr = textBlock2.zza;
                if (i2 >= zzahVarArr.length) {
                    break;
                }
                zzab zzabVar = zzahVarArr[i2].zzb;
                zzab zzabVar2 = zzahVarArr[c].zzb;
                int i3 = -zzabVar2.zza;
                int i4 = -zzabVar2.zzb;
                double dSin = Math.sin(Math.toRadians(zzabVar2.zze));
                double dCos = Math.cos(Math.toRadians(zzabVar2.zze));
                Point[] pointArr = new Point[i];
                Point point = new Point(zzabVar.zza, zzabVar.zzb);
                pointArr[c] = point;
                point.offset(i3, i4);
                Point point2 = pointArr[c];
                int i5 = point2.x;
                int i6 = point2.y;
                int i7 = (int) ((((double) i5) * dCos) + (((double) i6) * dSin));
                int i8 = (int) ((((double) (-i5)) * dSin) + (((double) i6) * dCos));
                point2.x = i7;
                point2.y = i8;
                pointArr[1] = new Point(zzabVar.zzc + i7, i8);
                pointArr[2] = new Point(zzabVar.zzc + i7, zzabVar.zzd + i8);
                pointArr[3] = new Point(i7, i8 + zzabVar.zzd);
                iMax = iMax;
                for (int i9 = 0; i9 < 4; i9++) {
                    Point point3 = pointArr[i9];
                    iMin = Math.min(iMin, point3.x);
                    iMax = Math.max(iMax, point3.x);
                    iMin2 = Math.min(iMin2, point3.y);
                    iMax2 = Math.max(iMax2, point3.y);
                }
                i2++;
                i = 4;
                c = 0;
                textBlock2 = this;
            }
            int i10 = iMax;
            zzab zzabVar3 = zzahVarArr[0].zzb;
            int i11 = zzabVar3.zza;
            int i12 = zzabVar3.zzb;
            double dSin2 = Math.sin(Math.toRadians(zzabVar3.zze));
            double dCos2 = Math.cos(Math.toRadians(zzabVar3.zze));
            Point point4 = new Point(iMin, iMin2);
            Point point5 = new Point(i10, iMin2);
            Point point6 = new Point(i10, iMax2);
            Point point7 = new Point(iMin, iMax2);
            int i13 = 0;
            Point[] pointArr2 = {point4, point5, point6, point7};
            for (int i14 = 4; i13 < i14; i14 = 4) {
                Point point8 = pointArr2[i13];
                int i15 = point8.x;
                int i16 = point8.y;
                point8.x = (int) ((((double) i15) * dCos2) - (((double) i16) * dSin2));
                point8.y = (int) ((((double) i15) * dSin2) + (((double) i16) * dCos2));
                point8.offset(i11, i12);
                i13++;
                pointArr2 = pointArr2;
            }
            textBlock = this;
            textBlock.zzb = pointArr2;
        }
        return textBlock.zzb;
    }

    @Override // com.google.android.gms.vision.text.Text
    @RecentlyNonNull
    public String getLanguage() {
        String str = this.zzd;
        if (str != null) {
            return str;
        }
        HashMap map = new HashMap();
        for (zzah zzahVar : this.zza) {
            map.put(zzahVar.zzd, Integer.valueOf((map.containsKey(zzahVar.zzd) ? ((Integer) map.get(zzahVar.zzd)).intValue() : 0) + 1));
        }
        String str2 = (String) ((Map.Entry) Collections.max(map.entrySet(), new D30(this))).getKey();
        this.zzd = str2;
        if (str2 == null || str2.isEmpty()) {
            this.zzd = "und";
        }
        return this.zzd;
    }

    @Override // com.google.android.gms.vision.text.Text
    @RecentlyNonNull
    public String getValue() {
        zzah[] zzahVarArr = this.zza;
        if (zzahVarArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zzahVarArr[0].zzc);
        for (int i = 1; i < this.zza.length; i++) {
            sb.append(StringUtilities.LF);
            sb.append(this.zza[i].zzc);
        }
        return sb.toString();
    }
}
