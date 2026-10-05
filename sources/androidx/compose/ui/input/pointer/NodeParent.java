package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import defpackage.AbstractC4492zt;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NodeParent {
    private final MutableVector<Node> children = new MutableVector<>(new Node[16], 0);

    public boolean buildCache(Map<PointerId, PointerInputChange> map, LayoutCoordinates layoutCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        AbstractC4492zt.h(map, "changes");
        AbstractC4492zt.h(layoutCoordinates, "parentCoordinates");
        AbstractC4492zt.h(internalPointerEvent, "internalPointerEvent");
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size <= 0) {
            return false;
        }
        Node[] content = mutableVector.getContent();
        int i = 0;
        boolean z2 = false;
        do {
            z2 = content[i].buildCache(map, layoutCoordinates, internalPointerEvent, z) || z2;
            i++;
        } while (i < size);
        return z2;
    }

    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        AbstractC4492zt.h(internalPointerEvent, "internalPointerEvent");
        int size = this.children.getSize();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (this.children.getContent()[size].getPointerIds().isEmpty()) {
                this.children.removeAt(size);
            }
        }
    }

    public final void clear() {
        this.children.clear();
    }

    public void dispatchCancel() {
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size > 0) {
            Node[] content = mutableVector.getContent();
            int i = 0;
            do {
                content[i].dispatchCancel();
                i++;
            } while (i < size);
        }
    }

    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        AbstractC4492zt.h(internalPointerEvent, "internalPointerEvent");
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        boolean z = false;
        if (size > 0) {
            Node[] content = mutableVector.getContent();
            int i = 0;
            boolean z2 = false;
            do {
                z2 = content[i].dispatchFinalEventPass(internalPointerEvent) || z2;
                i++;
            } while (i < size);
            z = z2;
        }
        cleanUpHits(internalPointerEvent);
        return z;
    }

    public boolean dispatchMainEventPass(Map<PointerId, PointerInputChange> map, LayoutCoordinates layoutCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        AbstractC4492zt.h(map, "changes");
        AbstractC4492zt.h(layoutCoordinates, "parentCoordinates");
        AbstractC4492zt.h(internalPointerEvent, "internalPointerEvent");
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size <= 0) {
            return false;
        }
        Node[] content = mutableVector.getContent();
        int i = 0;
        boolean z2 = false;
        do {
            z2 = content[i].dispatchMainEventPass(map, layoutCoordinates, internalPointerEvent, z) || z2;
            i++;
        } while (i < size);
        return z2;
    }

    public final MutableVector<Node> getChildren() {
        return this.children;
    }

    public final void removeDetachedPointerInputFilters() {
        int i = 0;
        while (i < this.children.getSize()) {
            Node node = this.children.getContent()[i];
            if (node.getModifierNode().isAttached()) {
                i++;
                node.removeDetachedPointerInputFilters();
            } else {
                this.children.removeAt(i);
                node.dispatchCancel();
            }
        }
    }
}
