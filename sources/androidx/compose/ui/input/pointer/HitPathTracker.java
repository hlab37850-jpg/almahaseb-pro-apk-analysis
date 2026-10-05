package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class HitPathTracker {
    private final NodeParent root;
    private final LayoutCoordinates rootCoordinates;

    public HitPathTracker(LayoutCoordinates layoutCoordinates) {
        AbstractC4492zt.h(layoutCoordinates, "rootCoordinates");
        this.rootCoordinates = layoutCoordinates;
        this.root = new NodeParent();
    }

    public static /* synthetic */ boolean dispatchChanges$default(HitPathTracker hitPathTracker, InternalPointerEvent internalPointerEvent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return hitPathTracker.dispatchChanges(internalPointerEvent, z);
    }

    /* JADX INFO: renamed from: addHitPath-KNwqfcY, reason: not valid java name */
    public final void m3982addHitPathKNwqfcY(long j, List<? extends Modifier.Node> list) {
        Node node;
        AbstractC4492zt.h(list, "pointerInputNodes");
        NodeParent nodeParent = this.root;
        int size = list.size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            Modifier.Node node2 = list.get(i);
            if (z) {
                MutableVector<Node> children = nodeParent.getChildren();
                int size2 = children.getSize();
                if (size2 <= 0) {
                    node = null;
                    break;
                }
                Node[] content = children.getContent();
                int i2 = 0;
                while (true) {
                    node = content[i2];
                    if (AbstractC4492zt.d(node.getModifierNode(), node2)) {
                        break;
                    }
                    i2++;
                    if (i2 >= size2) {
                        node = null;
                        break;
                    }
                }
                Node node3 = node;
                if (node3 != null) {
                    node3.markIsIn();
                    if (!node3.getPointerIds().contains(PointerId.m4034boximpl(j))) {
                        node3.getPointerIds().add(PointerId.m4034boximpl(j));
                    }
                    nodeParent = node3;
                } else {
                    z = false;
                    Node node4 = new Node(node2);
                    node4.getPointerIds().add(PointerId.m4034boximpl(j));
                    nodeParent.getChildren().add(node4);
                    nodeParent = node4;
                }
            } else {
                Node node5 = new Node(node2);
                node5.getPointerIds().add(PointerId.m4034boximpl(j));
                nodeParent.getChildren().add(node5);
                nodeParent = node5;
            }
        }
    }

    public final boolean dispatchChanges(InternalPointerEvent internalPointerEvent, boolean z) {
        AbstractC4492zt.h(internalPointerEvent, "internalPointerEvent");
        if (this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z)) {
            return this.root.dispatchFinalEventPass(internalPointerEvent) || this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z);
        }
        return false;
    }

    public final NodeParent getRoot$ui_release() {
        return this.root;
    }

    public final void processCancel() {
        this.root.dispatchCancel();
        this.root.clear();
    }

    public final void removeDetachedPointerInputFilters() {
        this.root.removeDetachedPointerInputFilters();
    }
}
