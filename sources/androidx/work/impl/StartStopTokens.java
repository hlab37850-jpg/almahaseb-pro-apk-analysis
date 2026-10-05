package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class StartStopTokens {
    private final Object lock = new Object();
    private final Map<WorkGenerationalId, StartStopToken> runs = new LinkedHashMap();

    public final boolean contains(WorkGenerationalId workGenerationalId) {
        boolean zContainsKey;
        AbstractC4492zt.h(workGenerationalId, HTML.Attribute.ID);
        synchronized (this.lock) {
            zContainsKey = this.runs.containsKey(workGenerationalId);
        }
        return zContainsKey;
    }

    public final StartStopToken remove(WorkGenerationalId workGenerationalId) {
        StartStopToken startStopTokenRemove;
        AbstractC4492zt.h(workGenerationalId, HTML.Attribute.ID);
        synchronized (this.lock) {
            startStopTokenRemove = this.runs.remove(workGenerationalId);
        }
        return startStopTokenRemove;
    }

    public final StartStopToken tokenFor(WorkGenerationalId workGenerationalId) {
        StartStopToken startStopToken;
        AbstractC4492zt.h(workGenerationalId, HTML.Attribute.ID);
        synchronized (this.lock) {
            try {
                Map<WorkGenerationalId, StartStopToken> map = this.runs;
                StartStopToken startStopToken2 = map.get(workGenerationalId);
                if (startStopToken2 == null) {
                    startStopToken2 = new StartStopToken(workGenerationalId);
                    map.put(workGenerationalId, startStopToken2);
                }
                startStopToken = startStopToken2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return startStopToken;
    }

    public final List<StartStopToken> remove(String str) {
        List<StartStopToken> listC0;
        AbstractC4492zt.h(str, "workSpecId");
        synchronized (this.lock) {
            try {
                Map<WorkGenerationalId, StartStopToken> map = this.runs;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<WorkGenerationalId, StartStopToken> entry : map.entrySet()) {
                    if (AbstractC4492zt.d(entry.getKey().getWorkSpecId(), str)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Iterator it = linkedHashMap.keySet().iterator();
                while (it.hasNext()) {
                    this.runs.remove((WorkGenerationalId) it.next());
                }
                listC0 = AbstractC3240kc.C0(linkedHashMap.values());
            } catch (Throwable th) {
                throw th;
            }
        }
        return listC0;
    }

    public final StartStopToken tokenFor(WorkSpec workSpec) {
        AbstractC4492zt.h(workSpec, "spec");
        return tokenFor(WorkSpecKt.generationalId(workSpec));
    }

    public final StartStopToken remove(WorkSpec workSpec) {
        AbstractC4492zt.h(workSpec, "spec");
        return remove(WorkSpecKt.generationalId(workSpec));
    }
}
