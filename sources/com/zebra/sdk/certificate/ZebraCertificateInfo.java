package com.zebra.sdk.certificate;

import com.zebra.sdk.util.internal.StringUtilities;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraCertificateInfo {
    public static final String CA_CERT_NRD_PRINTER_FILE_NAME = "E:CACERTSV.NRD";
    public static final String CLIENT_CERT_NRD_PRINTER_FILE_NAME = "E:CERTCLN.NRD";
    public static final String CLIENT_PRIVATE_KEY_NRD_PRINTER_FILE_NAME = "E:PRIVKEY.NRD";
    public List<String> caCertificates = new ArrayList();
    public String clientCertificate;
    public String privateKey;

    public String getCaChain() {
        if (this.caCertificates.size() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = this.caCertificates.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next() + StringUtilities.CRLF);
        }
        return stringBuffer.toString();
    }
}
