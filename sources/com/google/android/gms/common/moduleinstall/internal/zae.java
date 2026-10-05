package com.google.android.gms.common.moduleinstall.internal;

import android.os.IInterface;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;

/* JADX INFO: loaded from: classes2.dex */
public interface zae extends IInterface {
    void zab(Status status);

    void zac(Status status, @Nullable ModuleInstallIntentResponse moduleInstallIntentResponse);

    void zad(Status status, @Nullable ModuleInstallResponse moduleInstallResponse);

    void zae(Status status, @Nullable ModuleAvailabilityResponse moduleAvailabilityResponse);
}
