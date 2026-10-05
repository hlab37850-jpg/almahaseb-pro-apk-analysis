package com.google.android.gms.vision;

import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.RecentlyNonNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FocusingProcessor<T> implements Detector.Processor<T> {
    private Detector<T> zza;
    private Tracker<T> zzb;
    private int zze;
    private int zzc = 3;
    private boolean zzd = false;
    private int zzf = 0;

    public FocusingProcessor(@RecentlyNonNull Detector<T> detector, @RecentlyNonNull Tracker<T> tracker) {
        this.zza = detector;
        this.zzb = tracker;
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void receiveDetections(@RecentlyNonNull Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        if (detectedItems.size() == 0) {
            if (this.zzf == this.zzc) {
                this.zzb.onDone();
                this.zzd = false;
            } else {
                this.zzb.onMissing(detections);
            }
            this.zzf++;
            return;
        }
        this.zzf = 0;
        if (this.zzd) {
            T t = detectedItems.get(this.zze);
            if (t != null) {
                this.zzb.onUpdate(detections, t);
                return;
            } else {
                this.zzb.onDone();
                this.zzd = false;
            }
        }
        int iSelectFocus = selectFocus(detections);
        T t2 = detectedItems.get(iSelectFocus);
        if (t2 == null) {
            StringBuilder sb = new StringBuilder(35);
            sb.append("Invalid focus selected: ");
            sb.append(iSelectFocus);
            Log.w("FocusingProcessor", sb.toString());
            return;
        }
        this.zzd = true;
        this.zze = iSelectFocus;
        this.zza.setFocus(iSelectFocus);
        this.zzb.onNewItem(this.zze, t2);
        this.zzb.onUpdate(detections, t2);
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void release() {
        this.zzb.onDone();
    }

    public abstract int selectFocus(@RecentlyNonNull Detector.Detections<T> detections);

    public final void zza(int i) {
        if (i >= 0) {
            this.zzc = i;
            return;
        }
        StringBuilder sb = new StringBuilder(28);
        sb.append("Invalid max gap: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
