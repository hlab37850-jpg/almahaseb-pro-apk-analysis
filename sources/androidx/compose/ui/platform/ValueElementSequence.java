package androidx.compose.ui.platform;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC4362yO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ValueElementSequence implements InterfaceC4362yO {
    public static final int $stable = 8;
    private final List<ValueElement> elements = new ArrayList();

    @Override // defpackage.InterfaceC4362yO
    public Iterator<ValueElement> iterator() {
        return this.elements.iterator();
    }

    public final void set(String str, Object obj) {
        AbstractC4492zt.h(str, "name");
        this.elements.add(new ValueElement(str, obj));
    }
}
