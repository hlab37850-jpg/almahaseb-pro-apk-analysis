package com.zebra.sdk.settings.internal;

import com.zebra.sdk.comm.ResponseValidator;

/* JADX INFO: loaded from: classes3.dex */
public class SgdValidator implements ResponseValidator {
    @Override // com.zebra.sdk.comm.ResponseValidator
    public boolean isResponseComplete(byte[] bArr) {
        return bArr[0] == 34 && bArr[bArr.length - 1] == 34;
    }
}
