package defpackage;

import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import java.util.List;

/* JADX INFO: renamed from: k6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3202k6 extends BatchedLogRequest {
    public final List a;

    public C3202k6(List list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.a = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BatchedLogRequest) {
            return this.a.equals(((BatchedLogRequest) obj).getLogRequests());
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.BatchedLogRequest
    public List getLogRequests() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.a + "}";
    }
}
