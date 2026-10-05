package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import defpackage.AbstractC4492zt;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class PointerInputEventProcessor {
    private final HitPathTracker hitPathTracker;
    private final HitTestResult hitResult;
    private boolean isProcessing;
    private final PointerInputChangeEventProducer pointerInputChangeEventProducer;
    private final LayoutNode root;

    public PointerInputEventProcessor(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "root");
        this.root = layoutNode;
        this.hitPathTracker = new HitPathTracker(layoutNode.getCoordinates());
        this.pointerInputChangeEventProducer = new PointerInputChangeEventProducer();
        this.hitResult = new HitTestResult();
    }

    /* JADX INFO: renamed from: process-BIzXfog$default, reason: not valid java name */
    public static /* synthetic */ int m4072processBIzXfog$default(PointerInputEventProcessor pointerInputEventProcessor, PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return pointerInputEventProcessor.m4073processBIzXfog(pointerInputEvent, positionCalculator, z);
    }

    public final LayoutNode getRoot() {
        return this.root;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0071 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:7:0x001b, B:9:0x0031, B:23:0x005d, B:24:0x006b, B:26:0x0071, B:28:0x0079, B:30:0x007f, B:32:0x00a5, B:33:0x00b6, B:48:0x00ff, B:36:0x00cb, B:38:0x00d9, B:41:0x00e3, B:42:0x00e7, B:44:0x00ed, B:46:0x00f9, B:14:0x003e, B:15:0x0042, B:17:0x0048, B:19:0x0054), top: B:53:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c9 A[EDGE_INSN: B:35:0x00c9->B:48:0x00ff BREAK  A[LOOP:1: B:42:0x00e7->B:66:0x00e7]] */
    /* JADX WARN: Code duplicated, block: B:36:0x00cb A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:7:0x001b, B:9:0x0031, B:23:0x005d, B:24:0x006b, B:26:0x0071, B:28:0x0079, B:30:0x007f, B:32:0x00a5, B:33:0x00b6, B:48:0x00ff, B:36:0x00cb, B:38:0x00d9, B:41:0x00e3, B:42:0x00e7, B:44:0x00ed, B:46:0x00f9, B:14:0x003e, B:15:0x0042, B:17:0x0048, B:19:0x0054), top: B:53:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e3 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:7:0x001b, B:9:0x0031, B:23:0x005d, B:24:0x006b, B:26:0x0071, B:28:0x0079, B:30:0x007f, B:32:0x00a5, B:33:0x00b6, B:48:0x00ff, B:36:0x00cb, B:38:0x00d9, B:41:0x00e3, B:42:0x00e7, B:44:0x00ed, B:46:0x00f9, B:14:0x003e, B:15:0x0042, B:17:0x0048, B:19:0x0054), top: B:53:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ed A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:7:0x001b, B:9:0x0031, B:23:0x005d, B:24:0x006b, B:26:0x0071, B:28:0x0079, B:30:0x007f, B:32:0x00a5, B:33:0x00b6, B:48:0x00ff, B:36:0x00cb, B:38:0x00d9, B:41:0x00e3, B:42:0x00e7, B:44:0x00ed, B:46:0x00f9, B:14:0x003e, B:15:0x0042, B:17:0x0048, B:19:0x0054), top: B:53:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x006b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00e7 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX INFO: renamed from: process-BIzXfog, reason: not valid java name */
    public final int m4073processBIzXfog(PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator, boolean z) {
        boolean z2;
        Collection<PointerInputChange> collectionValues;
        Iterator<T> it;
        PointerInputChange pointerInputChange;
        AbstractC4492zt.h(pointerInputEvent, "pointerEvent");
        AbstractC4492zt.h(positionCalculator, "positionCalculator");
        if (this.isProcessing) {
            return PointerInputEventProcessorKt.ProcessResult(false, false);
        }
        boolean z3 = true;
        try {
            this.isProcessing = true;
            InternalPointerEvent internalPointerEventProduce = this.pointerInputChangeEventProducer.produce(pointerInputEvent, positionCalculator);
            Collection<PointerInputChange> collectionValues2 = internalPointerEventProduce.getChanges().values();
            if (!(collectionValues2 instanceof Collection) || !collectionValues2.isEmpty()) {
                Iterator<T> it2 = collectionValues2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        PointerInputChange pointerInputChange2 = (PointerInputChange) it2.next();
                        if (pointerInputChange2.getPressed() || pointerInputChange2.getPreviousPressed()) {
                            z2 = false;
                        }
                    }
                    for (PointerInputChange pointerInputChange3 : internalPointerEventProduce.getChanges().values()) {
                        if (!z2 || PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange3)) {
                            this.root.m4289hitTestM_7yMNQ$ui_release(pointerInputChange3.m4054getPositionF1C5BW0(), this.hitResult, (8 & 4) != 0 ? false : PointerType.m4112equalsimpl0(pointerInputChange3.m4057getTypeT8wyACA(), PointerType.Companion.m4119getTouchT8wyACA()), (8 & 8) != 0);
                            if (!this.hitResult.isEmpty()) {
                                this.hitPathTracker.m3982addHitPathKNwqfcY(pointerInputChange3.m4053getIdJ3iCeTQ(), this.hitResult);
                                this.hitResult.clear();
                            }
                        }
                    }
                    this.hitPathTracker.removeDetachedPointerInputFilters();
                    boolean zDispatchChanges = this.hitPathTracker.dispatchChanges(internalPointerEventProduce, z);
                    if (!internalPointerEventProduce.getSuppressMovementConsumption()) {
                        collectionValues = internalPointerEventProduce.getChanges().values();
                        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                            it = collectionValues.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    pointerInputChange = (PointerInputChange) it.next();
                                    if (!PointerEventKt.positionChangedIgnoreConsumed(pointerInputChange) && pointerInputChange.isConsumed()) {
                                        break;
                                    }
                                }
                            }
                        }
                        z3 = false;
                        break;
                    }
                    z3 = false;
                    break;
                    return PointerInputEventProcessorKt.ProcessResult(zDispatchChanges, z3);
                }
            }
            z2 = true;
            while (r5.hasNext()) {
                if (!z2) {
                }
                this.root.m4289hitTestM_7yMNQ$ui_release(pointerInputChange3.m4054getPositionF1C5BW0(), this.hitResult, (8 & 4) != 0 ? false : PointerType.m4112equalsimpl0(pointerInputChange3.m4057getTypeT8wyACA(), PointerType.Companion.m4119getTouchT8wyACA()), (8 & 8) != 0);
                if (!this.hitResult.isEmpty()) {
                    this.hitPathTracker.m3982addHitPathKNwqfcY(pointerInputChange3.m4053getIdJ3iCeTQ(), this.hitResult);
                    this.hitResult.clear();
                }
            }
            this.hitPathTracker.removeDetachedPointerInputFilters();
            boolean zDispatchChanges2 = this.hitPathTracker.dispatchChanges(internalPointerEventProduce, z);
            if (!internalPointerEventProduce.getSuppressMovementConsumption()) {
                z3 = false;
                break;
            }
            collectionValues = internalPointerEventProduce.getChanges().values();
            if (!(collectionValues instanceof Collection)) {
                it = collectionValues.iterator();
                while (true) {
                    if (it.hasNext()) {
                        z3 = false;
                        break;
                    }
                    pointerInputChange = (PointerInputChange) it.next();
                    if (!PointerEventKt.positionChangedIgnoreConsumed(pointerInputChange)) {
                    }
                }
            } else {
                it = collectionValues.iterator();
                while (true) {
                    if (it.hasNext()) {
                        z3 = false;
                        break;
                    }
                    pointerInputChange = (PointerInputChange) it.next();
                    if (!PointerEventKt.positionChangedIgnoreConsumed(pointerInputChange)) {
                    }
                }
            }
            return PointerInputEventProcessorKt.ProcessResult(zDispatchChanges2, z3);
        } finally {
            this.isProcessing = false;
        }
    }

    public final void processCancel() {
        if (this.isProcessing) {
            return;
        }
        this.pointerInputChangeEventProducer.clear();
        this.hitPathTracker.processCancel();
    }
}
