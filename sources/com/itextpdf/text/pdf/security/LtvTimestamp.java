package com.itextpdf.text.pdf.security;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfDeveloperExtension;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfSignature;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfString;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class LtvTimestamp {
    public static void timestamp(PdfSignatureAppearance pdfSignatureAppearance, TSAClient tSAClient, String str) throws DocumentException, GeneralSecurityException, IOException {
        int tokenSizeEstimate = tSAClient.getTokenSizeEstimate();
        pdfSignatureAppearance.addDeveloperExtension(PdfDeveloperExtension.ESIC_1_7_EXTENSIONLEVEL5);
        pdfSignatureAppearance.setVisibleSignature(new Rectangle(0.0f, 0.0f, 0.0f, 0.0f), 1, str);
        PdfSignature pdfSignature = new PdfSignature(PdfName.ADOBE_PPKLITE, PdfName.ETSI_RFC3161);
        pdfSignature.put(PdfName.TYPE, PdfName.DOCTIMESTAMP);
        pdfSignatureAppearance.setCryptoDictionary(pdfSignature);
        HashMap<PdfName, Integer> map = new HashMap<>();
        map.put(PdfName.CONTENTS, new Integer((tokenSizeEstimate * 2) + 2));
        pdfSignatureAppearance.preClose(map);
        InputStream rangeStream = pdfSignatureAppearance.getRangeStream();
        MessageDigest messageDigest = tSAClient.getMessageDigest();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = rangeStream.read(bArr);
            if (i <= 0) {
                break;
            } else {
                messageDigest.update(bArr, 0, i);
            }
        }
        try {
            byte[] timeStampToken = tSAClient.getTimeStampToken(messageDigest.digest());
            if (tokenSizeEstimate + 2 < timeStampToken.length) {
                throw new IOException("Not enough space");
            }
            byte[] bArr2 = new byte[tokenSizeEstimate];
            System.arraycopy(timeStampToken, 0, bArr2, 0, timeStampToken.length);
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.CONTENTS, new PdfString(bArr2).setHexWriting(true));
            pdfSignatureAppearance.close(pdfDictionary);
        } catch (Exception e) {
            throw new GeneralSecurityException(e);
        }
    }
}
