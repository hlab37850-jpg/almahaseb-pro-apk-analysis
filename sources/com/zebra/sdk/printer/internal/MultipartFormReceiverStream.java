package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import java.io.ByteArrayOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class MultipartFormReceiverStream extends PrinterConnectionInputStreamBase {
    private ByteArrayOutputStream boundaryBuffer;
    private long numBytesRead;

    public MultipartFormReceiverStream(Connection connection, long j) {
        super(connection, j);
        this.numBytesRead = 0L;
        this.boundaryBuffer = new ByteArrayOutputStream();
    }

    @Override // com.zebra.sdk.printer.internal.PrinterConnectionInputStreamBase
    public void setTerminatorBasedOnData(int i) {
        long j = this.numBytesRead + 1;
        this.numBytesRead = j;
        if (j < 100) {
            this.boundaryBuffer.write(i);
        } else if (this.terminator == null) {
            Matcher matcher = Pattern.compile("^[\\s]*--([^\\s|^-]+)\\r\\n").matcher(this.boundaryBuffer.toString());
            if (matcher.find()) {
                this.terminator = String.format("--%s--\r\n", matcher.group(1));
            }
        }
    }
}
