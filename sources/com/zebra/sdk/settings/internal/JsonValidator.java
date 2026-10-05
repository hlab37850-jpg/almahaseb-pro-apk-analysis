package com.zebra.sdk.settings.internal;

import com.zebra.sdk.comm.ResponseValidator;

/* JADX INFO: loaded from: classes3.dex */
public class JsonValidator implements ResponseValidator {
    @Override // com.zebra.sdk.comm.ResponseValidator
    public boolean isResponseComplete(byte[] bArr) {
        return JsonHelper.isValidJson(bArr);
    }
}
