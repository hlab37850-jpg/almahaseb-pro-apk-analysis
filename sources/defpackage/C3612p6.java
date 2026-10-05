package defpackage;

import com.google.android.datatransport.cct.internal.LogResponse;

/* JADX INFO: renamed from: p6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3612p6 extends LogResponse {
    public final long a;

    public C3612p6(long j) {
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof LogResponse) && this.a == ((LogResponse) obj).getNextRequestWaitMillis();
    }

    @Override // com.google.android.datatransport.cct.internal.LogResponse
    public long getNextRequestWaitMillis() {
        return this.a;
    }

    public int hashCode() {
        long j = this.a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.a + "}";
    }
}
