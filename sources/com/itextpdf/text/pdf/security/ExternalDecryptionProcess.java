package com.itextpdf.text.pdf.security;

import org.spongycastle.cms.Recipient;
import org.spongycastle.cms.RecipientId;

/* JADX INFO: loaded from: classes3.dex */
public interface ExternalDecryptionProcess {
    Recipient getCmsRecipient();

    RecipientId getCmsRecipientId();
}
