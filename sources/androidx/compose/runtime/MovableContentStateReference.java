package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@InternalComposeApi
public final class MovableContentStateReference {
    public static final int $stable = 8;
    private final Anchor anchor;
    private final ControlledComposition composition;
    private final MovableContent<Object> content;
    private List<C2020dG> invalidations;
    private final PersistentCompositionLocalMap locals;
    private final Object parameter;
    private final SlotTable slotTable;

    public MovableContentStateReference(MovableContent<Object> movableContent, Object obj, ControlledComposition controlledComposition, SlotTable slotTable, Anchor anchor, List<C2020dG> list, PersistentCompositionLocalMap persistentCompositionLocalMap) {
        AbstractC4492zt.h(movableContent, Annotation.CONTENT);
        AbstractC4492zt.h(controlledComposition, "composition");
        AbstractC4492zt.h(slotTable, "slotTable");
        AbstractC4492zt.h(anchor, "anchor");
        AbstractC4492zt.h(list, "invalidations");
        AbstractC4492zt.h(persistentCompositionLocalMap, "locals");
        this.content = movableContent;
        this.parameter = obj;
        this.composition = controlledComposition;
        this.slotTable = slotTable;
        this.anchor = anchor;
        this.invalidations = list;
        this.locals = persistentCompositionLocalMap;
    }

    public final Anchor getAnchor$runtime_release() {
        return this.anchor;
    }

    public final ControlledComposition getComposition$runtime_release() {
        return this.composition;
    }

    public final MovableContent<Object> getContent$runtime_release() {
        return this.content;
    }

    public final List<C2020dG> getInvalidations$runtime_release() {
        return this.invalidations;
    }

    public final PersistentCompositionLocalMap getLocals$runtime_release() {
        return this.locals;
    }

    public final Object getParameter$runtime_release() {
        return this.parameter;
    }

    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }

    public final void setInvalidations$runtime_release(List<C2020dG> list) {
        AbstractC4492zt.h(list, "<set-?>");
        this.invalidations = list;
    }
}
