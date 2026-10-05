package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.vision.zzah;
import com.google.android.gms.internal.vision.zzao;
import defpackage.N70;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Line implements Text {
    private zzah zza;
    private List<Element> zzb;

    public Line(zzah zzahVar) {
        this.zza = zzahVar;
    }

    public float getAngle() {
        return this.zza.zzb.zze;
    }

    @Override // com.google.android.gms.vision.text.Text
    @RecentlyNonNull
    public Rect getBoundingBox() {
        return N70.a(this);
    }

    @Override // com.google.android.gms.vision.text.Text
    @RecentlyNonNull
    public List<? extends Text> getComponents() {
        if (this.zza.zza.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzb == null) {
            this.zzb = new ArrayList(this.zza.zza.length);
            for (zzao zzaoVar : this.zza.zza) {
                this.zzb.add(new Element(zzaoVar));
            }
        }
        return this.zzb;
    }

    @Override // com.google.android.gms.vision.text.Text
    @RecentlyNonNull
    public Point[] getCornerPoints() {
        return N70.b(this.zza.zzb);
    }

    @Override // com.google.android.gms.vision.text.Text
    @RecentlyNonNull
    public String getLanguage() {
        return this.zza.zzd;
    }

    @Override // com.google.android.gms.vision.text.Text
    @RecentlyNonNull
    public String getValue() {
        return this.zza.zzc;
    }

    public boolean isVertical() {
        return this.zza.zze;
    }
}
