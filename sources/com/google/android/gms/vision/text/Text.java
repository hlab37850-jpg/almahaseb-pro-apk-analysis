package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.RecentlyNonNull;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface Text {
    @RecentlyNonNull
    Rect getBoundingBox();

    @RecentlyNonNull
    List<? extends Text> getComponents();

    @RecentlyNonNull
    Point[] getCornerPoints();

    @RecentlyNonNull
    String getLanguage();

    @RecentlyNonNull
    String getValue();
}
