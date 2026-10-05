package defpackage;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.Priority;

/* JADX INFO: renamed from: m6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3366m6 extends Event {
    public final Integer a;
    public final Object b;
    public final Priority c;

    public C3366m6(Integer num, Object obj, Priority priority) {
        this.a = num;
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.b = obj;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        this.c = priority;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.a;
        if (num != null ? num.equals(event.getCode()) : event.getCode() == null) {
            if (this.b.equals(event.getPayload()) && this.c.equals(event.getPriority())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.Event
    public Integer getCode() {
        return this.a;
    }

    @Override // com.google.android.datatransport.Event
    public Object getPayload() {
        return this.b;
    }

    @Override // com.google.android.datatransport.Event
    public Priority getPriority() {
        return this.c;
    }

    public int hashCode() {
        Integer num = this.a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.a + ", payload=" + this.b + ", priority=" + this.c + "}";
    }
}
