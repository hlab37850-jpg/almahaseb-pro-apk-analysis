package com.itextpdf.text.pdf.security;

import com.google.common.net.HttpHeaders;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.codec.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.tsp.TimeStampRequest;
import org.spongycastle.tsp.TimeStampRequestGenerator;
import org.spongycastle.tsp.TimeStampResponse;
import org.spongycastle.tsp.TimeStampToken;
import org.spongycastle.tsp.TimeStampTokenInfo;

/* JADX INFO: loaded from: classes3.dex */
public class TSAClientBouncyCastle implements TSAClient {
    public static final String DEFAULTHASHALGORITHM = "SHA-256";
    public static final int DEFAULTTOKENSIZE = 4096;
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) TSAClientBouncyCastle.class);
    protected String digestAlgorithm;
    protected int tokenSizeEstimate;
    protected TSAInfoBouncyCastle tsaInfo;
    protected String tsaPassword;
    protected String tsaURL;
    protected String tsaUsername;

    public TSAClientBouncyCastle(String str) {
        this(str, null, null, 4096, "SHA-256");
    }

    @Override // com.itextpdf.text.pdf.security.TSAClient
    public MessageDigest getMessageDigest() {
        return new BouncyCastleDigest().getMessageDigest(this.digestAlgorithm);
    }

    public byte[] getTSAResponse(byte[] bArr) throws IOException {
        try {
            URLConnection uRLConnectionOpenConnection = new URL(this.tsaURL).openConnection();
            uRLConnectionOpenConnection.setDoInput(true);
            uRLConnectionOpenConnection.setDoOutput(true);
            uRLConnectionOpenConnection.setUseCaches(false);
            uRLConnectionOpenConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/timestamp-query");
            uRLConnectionOpenConnection.setRequestProperty("Content-Transfer-Encoding", "binary");
            String str = this.tsaUsername;
            if (str != null && !str.equals("")) {
                uRLConnectionOpenConnection.setRequestProperty(HttpHeaders.AUTHORIZATION, "Basic " + Base64.encodeBytes((this.tsaUsername + ":" + this.tsaPassword).getBytes(), 8));
            }
            OutputStream outputStream = uRLConnectionOpenConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
            InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr2, 0, 1024);
                if (i < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, i);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String contentEncoding = uRLConnectionOpenConnection.getContentEncoding();
            return (contentEncoding == null || !contentEncoding.equalsIgnoreCase("base64")) ? byteArray : Base64.decode(new String(byteArray));
        } catch (IOException unused) {
            throw new IOException(MessageLocalization.getComposedMessage("failed.to.get.tsa.response.from.1", this.tsaURL));
        }
    }

    @Override // com.itextpdf.text.pdf.security.TSAClient
    public byte[] getTimeStampToken(byte[] bArr) throws IOException {
        TimeStampRequestGenerator timeStampRequestGenerator = new TimeStampRequestGenerator();
        timeStampRequestGenerator.setCertReq(true);
        TimeStampRequest timeStampRequestGenerate = timeStampRequestGenerator.generate(new ASN1ObjectIdentifier(DigestAlgorithms.getAllowedDigests(this.digestAlgorithm)), bArr, BigInteger.valueOf(System.currentTimeMillis()));
        TimeStampResponse timeStampResponse = new TimeStampResponse(getTSAResponse(timeStampRequestGenerate.getEncoded()));
        timeStampResponse.validate(timeStampRequestGenerate);
        PKIFailureInfo failInfo = timeStampResponse.getFailInfo();
        int iIntValue = failInfo == null ? 0 : failInfo.intValue();
        if (iIntValue != 0) {
            throw new IOException(MessageLocalization.getComposedMessage("invalid.tsa.1.response.code.2", this.tsaURL, String.valueOf(iIntValue)));
        }
        TimeStampToken timeStampToken = timeStampResponse.getTimeStampToken();
        if (timeStampToken == null) {
            throw new IOException(MessageLocalization.getComposedMessage("tsa.1.failed.to.return.time.stamp.token.2", this.tsaURL, timeStampResponse.getStatusString()));
        }
        TimeStampTokenInfo timeStampInfo = timeStampToken.getTimeStampInfo();
        byte[] encoded = timeStampToken.getEncoded();
        LOGGER.info("Timestamp generated: " + timeStampInfo.getGenTime());
        TSAInfoBouncyCastle tSAInfoBouncyCastle = this.tsaInfo;
        if (tSAInfoBouncyCastle != null) {
            tSAInfoBouncyCastle.inspectTimeStampTokenInfo(timeStampInfo);
        }
        this.tokenSizeEstimate = encoded.length + 32;
        return encoded;
    }

    @Override // com.itextpdf.text.pdf.security.TSAClient
    public int getTokenSizeEstimate() {
        return this.tokenSizeEstimate;
    }

    public void setTSAInfo(TSAInfoBouncyCastle tSAInfoBouncyCastle) {
        this.tsaInfo = tSAInfoBouncyCastle;
    }

    public TSAClientBouncyCastle(String str, String str2, String str3) {
        this(str, str2, str3, 4096, "SHA-256");
    }

    public TSAClientBouncyCastle(String str, String str2, String str3, int i, String str4) {
        this.tsaURL = str;
        this.tsaUsername = str2;
        this.tsaPassword = str3;
        this.tokenSizeEstimate = i;
        this.digestAlgorithm = str4;
    }
}
