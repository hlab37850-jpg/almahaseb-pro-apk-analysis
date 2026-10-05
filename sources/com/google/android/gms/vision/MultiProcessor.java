package com.google.android.gms.vision;

import android.util.SparseArray;
import androidx.annotation.RecentlyNonNull;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class MultiProcessor<T> implements Detector.Processor<T> {
    private Factory<T> zza;
    private SparseArray<a> zzb;
    private int zzc;

    public static class Builder<T> {
        private MultiProcessor<T> zza;

        public Builder(@RecentlyNonNull Factory<T> factory) {
            MultiProcessor<T> multiProcessor = new MultiProcessor<>();
            this.zza = multiProcessor;
            if (factory == null) {
                throw new IllegalArgumentException("No factory supplied.");
            }
            ((MultiProcessor) multiProcessor).zza = factory;
        }

        @RecentlyNonNull
        public MultiProcessor<T> build() {
            return this.zza;
        }

        @RecentlyNonNull
        public Builder<T> setMaxGapFrames(int i) {
            if (i >= 0) {
                ((MultiProcessor) this.zza).zzc = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(28);
            sb.append("Invalid max gap: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public interface Factory<T> {
        @RecentlyNonNull
        Tracker<T> create(@RecentlyNonNull T t);
    }

    public class a {
        public Tracker a;
        public int b;

        public a(MultiProcessor multiProcessor) {
            this.b = 0;
        }

        public static /* synthetic */ int a(a aVar, int i) {
            aVar.b = 0;
            return 0;
        }

        public static /* synthetic */ int d(a aVar) {
            int i = aVar.b;
            aVar.b = i + 1;
            return i;
        }
    }

    private MultiProcessor() {
        this.zzb = new SparseArray<>();
        this.zzc = 3;
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void receiveDetections(@RecentlyNonNull Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int iKeyAt = detectedItems.keyAt(i);
            T tValueAt = detectedItems.valueAt(i);
            if (this.zzb.get(iKeyAt) == null) {
                a aVar = new a();
                aVar.a = this.zza.create(tValueAt);
                aVar.a.onNewItem(iKeyAt, tValueAt);
                this.zzb.append(iKeyAt, aVar);
            }
        }
        SparseArray<T> detectedItems2 = detections.getDetectedItems();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.zzb.size(); i2++) {
            int iKeyAt2 = this.zzb.keyAt(i2);
            if (detectedItems2.get(iKeyAt2) == null) {
                a aVarValueAt = this.zzb.valueAt(i2);
                a.d(aVarValueAt);
                if (aVarValueAt.b >= this.zzc) {
                    aVarValueAt.a.onDone();
                    hashSet.add(Integer.valueOf(iKeyAt2));
                } else {
                    aVarValueAt.a.onMissing(detections);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.zzb.delete(((Integer) it.next()).intValue());
        }
        SparseArray<T> detectedItems3 = detections.getDetectedItems();
        for (int i3 = 0; i3 < detectedItems3.size(); i3++) {
            int iKeyAt3 = detectedItems3.keyAt(i3);
            T tValueAt2 = detectedItems3.valueAt(i3);
            a aVar2 = this.zzb.get(iKeyAt3);
            a.a(aVar2, 0);
            aVar2.a.onUpdate(detections, tValueAt2);
        }
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void release() {
        for (int i = 0; i < this.zzb.size(); i++) {
            this.zzb.valueAt(i).a.onDone();
        }
        this.zzb.clear();
    }
}
