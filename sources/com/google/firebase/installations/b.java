package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import defpackage.C4209wX;
import defpackage.GR;

/* JADX INFO: loaded from: classes3.dex */
public class b implements GR {
    public final C4209wX a;
    public final TaskCompletionSource b;

    public b(C4209wX c4209wX, TaskCompletionSource taskCompletionSource) {
        this.a = c4209wX;
        this.b = taskCompletionSource;
    }

    @Override // defpackage.GR
    public boolean a(PersistedInstallationEntry persistedInstallationEntry, Exception exc) {
        if (!persistedInstallationEntry.isErrored() && !persistedInstallationEntry.isNotGenerated() && !persistedInstallationEntry.isUnregistered()) {
            return false;
        }
        this.b.trySetException(exc);
        return true;
    }

    @Override // defpackage.GR
    public boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isRegistered() || this.a.b(persistedInstallationEntry)) {
            return false;
        }
        this.b.setResult(InstallationTokenResult.builder().setToken(persistedInstallationEntry.getAuthToken()).setTokenExpirationTimestamp(persistedInstallationEntry.getExpiresInSecs()).setTokenCreationTimestamp(persistedInstallationEntry.getTokenCreationEpochInSecs()).build());
        return true;
    }
}
