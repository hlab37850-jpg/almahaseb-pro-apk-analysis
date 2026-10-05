package com.zebra.sdk.util.internal;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CertificateInfo {
    protected String certificate;
    protected List<String> resultMessages;
    protected CertificateSigningRequestInfo userRequestInfo;

    public CertificateInfo() {
    }

    public String getCertificate() {
        return this.certificate;
    }

    public List<String> getResultMessages() {
        return this.resultMessages;
    }

    public CertificateSigningRequestInfo getUserRequestInfo() {
        return this.userRequestInfo;
    }

    public void setCertificate(String str) {
        this.certificate = str;
    }

    public void setResultMessages(List<String> list) {
        this.resultMessages = list;
    }

    public void setUserRequestInfo(CertificateSigningRequestInfo certificateSigningRequestInfo) {
        this.userRequestInfo = certificateSigningRequestInfo;
    }

    public CertificateInfo(CertificateSigningRequestInfo certificateSigningRequestInfo) {
        setUserRequestInfo(certificateSigningRequestInfo);
        this.resultMessages = new ArrayList();
    }
}
