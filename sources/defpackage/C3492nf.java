package defpackage;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

/* JADX INFO: renamed from: nf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3492nf extends AbstractHttpEntity {
    public final long a;
    public final StreamingContent b;

    public C3492nf(long j, StreamingContent streamingContent) {
        this.a = j;
        this.b = (StreamingContent) Preconditions.checkNotNull(streamingContent);
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.a;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return true;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) {
        if (this.a != 0) {
            this.b.writeTo(outputStream);
        }
    }
}
