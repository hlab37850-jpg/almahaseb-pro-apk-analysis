package defpackage;

import android.text.TextUtils;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: wX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4209wX {
    public static final long a = TimeUnit.HOURS.toSeconds(1);

    public long a() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    public boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        return TextUtils.isEmpty(persistedInstallationEntry.getAuthToken()) || persistedInstallationEntry.getTokenCreationEpochInSecs() + persistedInstallationEntry.getExpiresInSecs() < a() + a;
    }
}
