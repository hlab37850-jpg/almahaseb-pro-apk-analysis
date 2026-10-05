package defpackage;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* JADX INFO: renamed from: iq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3098iq implements GR {
    public final TaskCompletionSource a;

    public C3098iq(TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // defpackage.GR
    public boolean a(PersistedInstallationEntry persistedInstallationEntry, Exception exc) {
        return false;
    }

    @Override // defpackage.GR
    public boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isUnregistered() && !persistedInstallationEntry.isRegistered() && !persistedInstallationEntry.isErrored()) {
            return false;
        }
        this.a.trySetResult(persistedInstallationEntry.getFirebaseInstallationId());
        return true;
    }
}
