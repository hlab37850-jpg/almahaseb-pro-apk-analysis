package com.itextpdf.text.pdf.security;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public interface TSAClient {
    MessageDigest getMessageDigest();

    byte[] getTimeStampToken(byte[] bArr);

    int getTokenSizeEstimate();
}
