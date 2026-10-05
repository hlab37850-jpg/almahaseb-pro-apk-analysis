package defpackage;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import java.util.Map;

/* JADX INFO: renamed from: zl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC4484zl implements Runnable {
    public final Map.Entry a;
    public final Event b;

    public RunnableC4484zl(Map.Entry entry, Event event) {
        this.a = entry;
        this.b = event;
    }

    public static Runnable a(Map.Entry entry, Event event) {
        return new RunnableC4484zl(entry, event);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((EventHandler) this.a.getKey()).handle(this.b);
    }
}
