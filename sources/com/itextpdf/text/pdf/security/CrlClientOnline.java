package com.itextpdf.text.pdf.security;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CrlClientOnline implements CrlClient {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) CrlClientOnline.class);
    protected List<URL> urls;

    public CrlClientOnline() {
        this.urls = new ArrayList();
    }

    public void addUrl(String str) {
        try {
            addUrl(new URL(str));
        } catch (MalformedURLException unused) {
            LOGGER.info("Skipped CRL url (malformed): " + str);
        }
    }

    @Override // com.itextpdf.text.pdf.security.CrlClient
    public Collection<byte[]> getEncoded(X509Certificate x509Certificate, String str) {
        if (x509Certificate == null) {
            return null;
        }
        ArrayList<URL> arrayList = new ArrayList(this.urls);
        if (arrayList.size() == 0) {
            Logger logger = LOGGER;
            logger.info("Looking for CRL for certificate " + x509Certificate.getSubjectDN());
            if (str == null) {
                try {
                    str = CertificateUtil.getCRLURL(x509Certificate);
                } catch (Exception e) {
                    LOGGER.info("Skipped CRL url: " + e.getMessage());
                }
            }
            if (str == null) {
                throw new NullPointerException();
            }
            arrayList.add(new URL(str));
            logger.info("Found CRL url: " + str);
        }
        ArrayList arrayList2 = new ArrayList();
        for (URL url : arrayList) {
            try {
                LOGGER.info("Checking CRL: " + url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection.getResponseCode() / 100 != 2) {
                    throw new IOException(MessageLocalization.getComposedMessage("invalid.http.response.1", httpURLConnection.getResponseCode()));
                }
                InputStream inputStream = (InputStream) httpURLConnection.getContent();
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i = inputStream.read(bArr, 0, 1024);
                    if (i <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
                inputStream.close();
                arrayList2.add(byteArrayOutputStream.toByteArray());
                LOGGER.info("Added CRL found at: " + url);
            } catch (Exception e2) {
                LOGGER.info("Skipped CRL: " + e2.getMessage() + " for " + url);
            }
        }
        return arrayList2;
    }

    public CrlClientOnline(String... strArr) {
        this.urls = new ArrayList();
        for (String str : strArr) {
            addUrl(str);
        }
    }

    public void addUrl(URL url) {
        if (this.urls.contains(url)) {
            LOGGER.info("Skipped CRL url (duplicate): " + url);
            return;
        }
        this.urls.add(url);
        LOGGER.info("Added CRL url: " + url);
    }

    public CrlClientOnline(URL... urlArr) {
        ArrayList arrayList = new ArrayList();
        this.urls = arrayList;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            addUrl((URL) it.next());
        }
    }

    public CrlClientOnline(Certificate[] certificateArr) {
        this.urls = new ArrayList();
        for (Certificate certificate : certificateArr) {
            X509Certificate x509Certificate = (X509Certificate) certificate;
            LOGGER.info("Checking certificate: " + x509Certificate.getSubjectDN());
            try {
                addUrl(CertificateUtil.getCRLURL(x509Certificate));
            } catch (CertificateParsingException unused) {
                LOGGER.info("Skipped CRL url (certificate could not be parsed)");
            }
        }
    }
}
