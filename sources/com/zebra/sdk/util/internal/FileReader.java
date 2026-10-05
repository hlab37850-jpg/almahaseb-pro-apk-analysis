package com.zebra.sdk.util.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes3.dex */
public class FileReader {
    public static byte[] toByteArray(File file) {
        return toByteArray(file.getAbsolutePath());
    }

    public static String toString(File file) {
        return toString(file.getPath());
    }

    public static String toUtf8String(String str) {
        return toUtf8String(str, Integer.MAX_VALUE);
    }

    public static byte[] toByteArray(String str) {
        return toByteArray(str, Integer.MAX_VALUE);
    }

    public static String toString(String str) {
        return toString(str, Integer.MAX_VALUE);
    }

    public static String toUtf8String(String str, int i) {
        byte[] byteArray = toByteArray(str, i);
        if (byteArray == null) {
            return "";
        }
        try {
            return new String(byteArray, "utf8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static byte[] toByteArray(String str, int i) {
        FileInputStream fileInputStream;
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str);
            long length = file.length();
            if (length < i) {
                int i2 = (int) length;
                byte[] bArr = new byte[i2];
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        if (i2 != fileInputStream.read(bArr)) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                            return null;
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                        return bArr;
                    } catch (FileNotFoundException unused3) {
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (IOException unused4) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException unused7) {
                    fileInputStream = null;
                } catch (IOException unused8) {
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
            }
        } catch (IOException | NullPointerException unused9) {
        }
        return null;
    }

    public static String toString(String str, int i) {
        byte[] byteArray = toByteArray(str, i);
        return byteArray == null ? "" : new String(byteArray);
    }
}
