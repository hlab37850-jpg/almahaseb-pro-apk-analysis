package org.apache.poi.util;

import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public interface FixedField {
    void readFromBytes(byte[] bArr);

    void readFromStream(InputStream inputStream);

    String toString();

    void writeToBytes(byte[] bArr);
}
