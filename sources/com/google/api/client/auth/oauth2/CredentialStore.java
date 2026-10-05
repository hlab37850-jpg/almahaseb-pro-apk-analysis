package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;

/* JADX INFO: loaded from: classes2.dex */
@Beta
@Deprecated
public interface CredentialStore {
    void delete(String str, Credential credential);

    boolean load(String str, Credential credential);

    void store(String str, Credential credential);
}
