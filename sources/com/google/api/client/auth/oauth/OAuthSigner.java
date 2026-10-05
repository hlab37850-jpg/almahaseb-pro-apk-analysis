package com.google.api.client.auth.oauth;

import com.google.api.client.util.Beta;

/* JADX INFO: loaded from: classes2.dex */
@Beta
public interface OAuthSigner {
    String computeSignature(String str);

    String getSignatureMethod();
}
