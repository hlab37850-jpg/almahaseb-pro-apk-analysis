package defpackage;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

/* JADX INFO: renamed from: cs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1985cs extends CharsetEncoder {
    public C1985cs() {
        super(null, 1.0f, 1.0f);
    }

    @Override // java.nio.charset.CharsetEncoder
    public CoderResult encodeLoop(CharBuffer charBuffer, ByteBuffer byteBuffer) {
        while (charBuffer.remaining() > 0) {
            if (byteBuffer.remaining() < 1) {
                return CoderResult.OVERFLOW;
            }
            char c = charBuffer.get();
            if (c < 0 || c >= 256) {
                return CoderResult.unmappableForLength(1);
            }
            byteBuffer.put((byte) c);
        }
        return CoderResult.UNDERFLOW;
    }

    @Override // java.nio.charset.CharsetEncoder
    public boolean isLegalReplacement(byte[] bArr) {
        return true;
    }
}
