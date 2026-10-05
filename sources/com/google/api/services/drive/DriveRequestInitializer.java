package com.google.api.services.drive;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;

/* JADX INFO: loaded from: classes2.dex */
public class DriveRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    public DriveRequestInitializer() {
    }

    public void initializeDriveRequest(DriveRequest<?> driveRequest) {
    }

    @Override // com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer
    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        initializeDriveRequest((DriveRequest) abstractGoogleJsonClientRequest);
    }

    public DriveRequestInitializer(String str) {
        super(str);
    }

    public DriveRequestInitializer(String str, String str2) {
        super(str, str2);
    }
}
