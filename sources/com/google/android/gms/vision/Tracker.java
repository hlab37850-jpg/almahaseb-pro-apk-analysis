package com.google.android.gms.vision;

import androidx.annotation.RecentlyNonNull;

/* JADX INFO: loaded from: classes2.dex */
public class Tracker<T> {
    public void onDone() {
    }

    public void onMissing(@RecentlyNonNull Detector.Detections<T> detections) {
    }

    public void onNewItem(int i, @RecentlyNonNull T t) {
    }

    public void onUpdate(@RecentlyNonNull Detector.Detections<T> detections, @RecentlyNonNull T t) {
    }
}
