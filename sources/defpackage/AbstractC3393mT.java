package defpackage;

import android.app.job.JobInfo;
import android.net.Uri;

/* JADX INFO: renamed from: mT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC3393mT {
    public static /* synthetic */ JobInfo.TriggerContentUri a(Uri uri, int i) {
        return new JobInfo.TriggerContentUri(uri, i);
    }
}
