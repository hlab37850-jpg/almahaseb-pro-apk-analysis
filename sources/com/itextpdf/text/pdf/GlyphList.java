package com.itextpdf.text.pdf;

import com.itextpdf.text.io.StreamUtil;
import com.itextpdf.text.pdf.fonts.FontsResourceAnchor;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
public class GlyphList {
    private static HashMap<Integer, String> unicode2names = new HashMap<>();
    private static HashMap<String, int[]> names2unicode = new HashMap<>();

    static {
        InputStream inputStream = null;
        try {
            try {
                new FontsResourceAnchor();
                InputStream resourceStream = StreamUtil.getResourceStream("com/itextpdf/text/pdf/fonts/glyphlist.txt", FontsResourceAnchor.class.getClassLoader());
                try {
                    if (resourceStream == null) {
                        throw new Exception("glyphlist.txt not found as resource. (It must exist as resource in the package com.itextpdf.text.pdf.fonts)");
                    }
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int i = resourceStream.read(bArr);
                        if (i < 0) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    }
                    resourceStream.close();
                    StringTokenizer stringTokenizer = new StringTokenizer(PdfEncodings.convertToString(byteArrayOutputStream.toByteArray(), null), StringUtilities.CRLF);
                    while (stringTokenizer.hasMoreTokens()) {
                        String strNextToken = stringTokenizer.nextToken();
                        if (!strNextToken.startsWith("#")) {
                            StringTokenizer stringTokenizer2 = new StringTokenizer(strNextToken, " ;\r\n\t\f");
                            if (stringTokenizer2.hasMoreTokens()) {
                                String strNextToken2 = stringTokenizer2.nextToken();
                                if (stringTokenizer2.hasMoreTokens()) {
                                    Integer numValueOf = Integer.valueOf(stringTokenizer2.nextToken(), 16);
                                    unicode2names.put(numValueOf, strNextToken2);
                                    names2unicode.put(strNextToken2, new int[]{numValueOf.intValue()});
                                }
                            }
                        }
                    }
                    return;
                } catch (Exception e) {
                    e = e;
                    inputStream = resourceStream;
                } catch (Throwable th) {
                    th = th;
                    inputStream = resourceStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        System.err.println("glyphlist.txt loading error: " + e.getMessage());
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused2) {
            }
        }
    }

    public static int[] nameToUnicode(String str) {
        int[] iArr = names2unicode.get(str);
        if (iArr == null && str.length() == 7 && str.toLowerCase().startsWith("uni")) {
            try {
                return new int[]{Integer.parseInt(str.substring(3), 16)};
            } catch (Exception unused) {
            }
        }
        return iArr;
    }

    public static String unicodeToName(int i) {
        return unicode2names.get(Integer.valueOf(i));
    }
}
