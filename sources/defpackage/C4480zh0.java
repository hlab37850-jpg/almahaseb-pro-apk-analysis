package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.DetectedActivity;
import java.util.Comparator;

/* JADX INFO: renamed from: zh0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4480zh0 implements Comparator {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        DetectedActivity detectedActivity2 = (DetectedActivity) obj2;
        Preconditions.checkNotNull(detectedActivity);
        Preconditions.checkNotNull(detectedActivity2);
        int iCompareTo = Integer.valueOf(detectedActivity2.getConfidence()).compareTo(Integer.valueOf(detectedActivity.getConfidence()));
        return iCompareTo == 0 ? Integer.valueOf(detectedActivity.getType()).compareTo(Integer.valueOf(detectedActivity2.getType())) : iCompareTo;
    }
}
