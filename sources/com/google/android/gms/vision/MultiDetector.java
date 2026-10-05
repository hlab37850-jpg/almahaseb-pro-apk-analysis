package com.google.android.gms.vision;

import android.util.SparseArray;
import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MultiDetector extends Detector<Object> {
    private List<Detector<? extends Object>> zza;

    public static class Builder {
        private MultiDetector zza = new MultiDetector();

        @RecentlyNonNull
        public Builder add(@RecentlyNonNull Detector<? extends Object> detector) {
            this.zza.zza.add(detector);
            return this;
        }

        @RecentlyNonNull
        public MultiDetector build() {
            if (this.zza.zza.size() != 0) {
                return this.zza;
            }
            throw new RuntimeException("No underlying detectors added to MultiDetector.");
        }
    }

    private MultiDetector() {
        this.zza = new ArrayList();
    }

    @Override // com.google.android.gms.vision.Detector
    @RecentlyNonNull
    public SparseArray<Object> detect(@RecentlyNonNull Frame frame) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        Iterator<Detector<? extends Object>> it = this.zza.iterator();
        while (it.hasNext()) {
            SparseArray<? extends Object> sparseArrayDetect = it.next().detect(frame);
            for (int i = 0; i < sparseArrayDetect.size(); i++) {
                int iKeyAt = sparseArrayDetect.keyAt(i);
                if (sparseArray.get(iKeyAt) != null) {
                    StringBuilder sb = new StringBuilder(104);
                    sb.append("Detection ID overlap for id = ");
                    sb.append(iKeyAt);
                    sb.append("  This means that one of the detectors is not using global IDs.");
                    throw new IllegalStateException(sb.toString());
                }
                sparseArray.append(iKeyAt, sparseArrayDetect.valueAt(i));
            }
        }
        return sparseArray;
    }

    @Override // com.google.android.gms.vision.Detector
    public boolean isOperational() {
        Iterator<Detector<? extends Object>> it = this.zza.iterator();
        while (it.hasNext()) {
            if (!it.next().isOperational()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.vision.Detector
    public void receiveFrame(@RecentlyNonNull Frame frame) {
        Iterator<Detector<? extends Object>> it = this.zza.iterator();
        while (it.hasNext()) {
            it.next().receiveFrame(frame);
        }
    }

    @Override // com.google.android.gms.vision.Detector
    public void release() {
        Iterator<Detector<? extends Object>> it = this.zza.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.zza.clear();
    }

    @Override // com.google.android.gms.vision.Detector
    public void setProcessor(@RecentlyNonNull Detector.Processor<Object> processor) {
        throw new UnsupportedOperationException("MultiDetector.setProcessor is not supported.  You should set a processor instance on each underlying detector instead.");
    }
}
