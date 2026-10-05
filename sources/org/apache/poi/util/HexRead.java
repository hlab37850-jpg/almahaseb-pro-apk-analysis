package org.apache.poi.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class HexRead {
    public static byte[] readData(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        try {
            return readData(fileInputStream, -1);
        } finally {
            fileInputStream.close();
        }
    }

    public static byte[] readFromString(String str) {
        try {
            return readData(new ByteArrayInputStream(str.getBytes()), -1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readToEOL(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        while (i != -1 && i != 10 && i != 13) {
            i = inputStream.read();
        }
    }

    public static byte[] readData(InputStream inputStream, String str) throws IOException {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            int i = inputStream.read();
            boolean z = false;
            while (i != -1) {
                if (i == 10 || i == 13) {
                    stringBuffer = new StringBuffer();
                } else {
                    if (i == 91) {
                        z = true;
                    } else if (i != 93) {
                        if (z) {
                            stringBuffer.append((char) i);
                        }
                    } else {
                        if (stringBuffer.toString().equals(str)) {
                            byte[] data = readData(inputStream, 91);
                            inputStream.close();
                            return data;
                        }
                        stringBuffer = new StringBuffer();
                    }
                    i = inputStream.read();
                }
                z = false;
                i = inputStream.read();
            }
            inputStream.close();
            throw new IOException("Section '" + str + "' not found");
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    public static byte[] readData(String str, String str2) {
        return readData(new FileInputStream(new File(str)), str2);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0020  */
    /* JADX WARN: Code duplicated, block: B:32:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x004a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x003e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0027 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0024 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x001d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:5:0x000b  */
    /* JADX WARN: Code duplicated, block: B:8:0x0012  */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x001a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x001d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0020. Please report as an issue. */
    /* JADX WARN: Switch 'out' block B:4:0x0009 for B:13:0x001a already processed. Defaulting to fallback option. */
    /* JADX WARN: Switch 'out' block B:4:0x0009 for B:14:0x001d already processed. Defaulting to fallback option. */
    /* JADX WARN: Switch 'out' block B:4:0x0009 for B:15:0x0020 already processed. Defaulting to fallback option. */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static byte[] readData(java.io.InputStream r8, int r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = 0
        L7:
            r3 = 0
            r4 = 0
        L9:
            if (r2 != 0) goto L58
            int r5 = r8.read()
            if (r5 != r9) goto L12
            goto L58
        L12:
            r6 = -1
            if (r5 == r6) goto L56
            r6 = 35
            if (r5 == r6) goto L52
            r6 = 2
            switch(r5) {
                case 48: goto L3e;
                case 49: goto L3e;
                case 50: goto L3e;
                case 51: goto L3e;
                case 52: goto L3e;
                case 53: goto L3e;
                case 54: goto L3e;
                case 55: goto L3e;
                case 56: goto L3e;
                case 57: goto L3e;
                default: goto L1d;
            }
        L1d:
            switch(r5) {
                case 65: goto L27;
                case 66: goto L27;
                case 67: goto L27;
                case 68: goto L27;
                case 69: goto L27;
                case 70: goto L27;
                default: goto L20;
            }
        L20:
            switch(r5) {
                case 97: goto L24;
                case 98: goto L24;
                case 99: goto L24;
                case 100: goto L24;
                case 101: goto L24;
                case 102: goto L24;
                default: goto L23;
            }
        L23:
            goto L9
        L24:
            r7 = 97
            goto L29
        L27:
            r7 = 65
        L29:
            int r3 = r3 << 4
            byte r3 = (byte) r3
            int r5 = r5 + 10
            int r5 = r5 - r7
            byte r5 = (byte) r5
            int r3 = r3 + r5
            byte r3 = (byte) r3
            int r4 = r4 + 1
            if (r4 != r6) goto L9
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r0.add(r3)
            goto L7
        L3e:
            int r3 = r3 << 4
            byte r3 = (byte) r3
            int r5 = r5 + (-48)
            byte r5 = (byte) r5
            int r3 = r3 + r5
            byte r3 = (byte) r3
            int r4 = r4 + 1
            if (r4 != r6) goto L9
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r0.add(r3)
            goto L7
        L52:
            readToEOL(r8)
            goto L9
        L56:
            r2 = 1
            goto L9
        L58:
            java.lang.Byte[] r8 = new java.lang.Byte[r1]
            java.lang.Object[] r8 = r0.toArray(r8)
            java.lang.Byte[] r8 = (java.lang.Byte[]) r8
            int r9 = r8.length
            byte[] r9 = new byte[r9]
        L63:
            int r0 = r8.length
            if (r1 >= r0) goto L71
            r0 = r8[r1]
            byte r0 = r0.byteValue()
            r9[r1] = r0
            int r1 = r1 + 1
            goto L63
        L71:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.util.HexRead.readData(java.io.InputStream, int):byte[]");
    }
}
