package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC4492zt;
import defpackage.C1182Zu;
import defpackage.FW;
import defpackage.InterfaceC0756Mu;
import defpackage.InterfaceC3750qp;
import defpackage.KJ;
import defpackage.MJ;
import defpackage.R5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, InterfaceC0756Mu {
    private int groupsSize;
    private int readers;
    private int slotsSize;
    private int version;
    private boolean writer;
    private int[] groups = new int[0];
    private Object[] slots = new Object[0];
    private ArrayList<Anchor> anchors = new ArrayList<>();

    private final List<Integer> dataIndexes() {
        return SlotTableKt.dataAnchors(this.groups, this.groupsSize * 5);
    }

    private final int emitGroup(StringBuilder sb, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(' ');
        }
        sb.append("Group(");
        sb.append(i);
        sb.append(") key=");
        sb.append(SlotTableKt.key(this.groups, i));
        int iGroupSize = SlotTableKt.groupSize(this.groups, i);
        sb.append(", nodes=");
        sb.append(SlotTableKt.nodeCount(this.groups, i));
        sb.append(", size=");
        sb.append(iGroupSize);
        if (SlotTableKt.hasMark(this.groups, i)) {
            sb.append(", mark");
        }
        if (SlotTableKt.containsMark(this.groups, i)) {
            sb.append(", contains mark");
        }
        int iEmitGroup$dataIndex = emitGroup$dataIndex(this, i);
        int iEmitGroup = i + 1;
        int iEmitGroup$dataIndex2 = emitGroup$dataIndex(this, iEmitGroup);
        if (iEmitGroup$dataIndex < 0 || iEmitGroup$dataIndex > iEmitGroup$dataIndex2 || iEmitGroup$dataIndex2 > this.slotsSize) {
            sb.append(", *invalid data offsets " + iEmitGroup$dataIndex + '-' + iEmitGroup$dataIndex2 + '*');
        } else {
            if (SlotTableKt.hasObjectKey(this.groups, i)) {
                sb.append(" objectKey=" + this.slots[SlotTableKt.objectKeyIndex(this.groups, i)]);
            }
            if (SlotTableKt.isNode(this.groups, i)) {
                sb.append(" node=" + this.slots[SlotTableKt.nodeIndex(this.groups, i)]);
            }
            if (SlotTableKt.hasAux(this.groups, i)) {
                sb.append(" aux=" + this.slots[SlotTableKt.auxIndex(this.groups, i)]);
            }
            int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, i);
            if (iSlotAnchor < iEmitGroup$dataIndex2) {
                sb.append(", slots=[");
                sb.append(iSlotAnchor);
                sb.append(": ");
                for (int i4 = iSlotAnchor; i4 < iEmitGroup$dataIndex2; i4++) {
                    if (i4 != iSlotAnchor) {
                        sb.append(", ");
                    }
                    sb.append(String.valueOf(this.slots[i4]));
                }
                sb.append("]");
            }
        }
        sb.append('\n');
        int i5 = i + iGroupSize;
        while (iEmitGroup < i5) {
            iEmitGroup += emitGroup(sb, iEmitGroup, i2 + 1);
        }
        return iGroupSize;
    }

    private static final int emitGroup$dataIndex(SlotTable slotTable, int i) {
        return i >= slotTable.groupsSize ? slotTable.slotsSize : SlotTableKt.dataAnchor(slotTable.groups, i);
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int i) {
        while (i > 0) {
            for (Object obj : new DataIterator(this, i)) {
                if (obj instanceof RecomposeScopeImpl) {
                    return (RecomposeScopeImpl) obj;
                }
            }
            i = SlotTableKt.parentAnchor(this.groups, i);
        }
        return null;
    }

    private final List<Integer> groupSizes() {
        return SlotTableKt.groupSizes(this.groups, this.groupsSize * 5);
    }

    private final boolean invalidateGroup(int i) {
        while (i >= 0) {
            for (Object obj : new DataIterator(this, i)) {
                if (obj instanceof RecomposeScopeImpl) {
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                    recomposeScopeImpl.setRequiresRecompose(true);
                    return recomposeScopeImpl.invalidateForResult(null) != InvalidationResult.IGNORED;
                }
            }
            i = SlotTableKt.parentAnchor(this.groups, i);
        }
        return false;
    }

    private static final void invalidateGroupsWithKey$lambda$14$scanGroup(SlotReader slotReader, int i, List<Anchor> list, KJ kj, SlotTable slotTable, List<RecomposeScopeImpl> list2) {
        if (slotReader.getGroupKey() != i) {
            slotReader.startGroup();
            while (!slotReader.isGroupEnd()) {
                invalidateGroupsWithKey$lambda$14$scanGroup(slotReader, i, list, kj, slotTable, list2);
            }
            slotReader.endGroup();
            return;
        }
        list.add(SlotReader.anchor$default(slotReader, 0, 1, null));
        if (kj.a) {
            RecomposeScopeImpl recomposeScopeImplFindEffectiveRecomposeScope = slotTable.findEffectiveRecomposeScope(slotReader.getCurrentGroup());
            if (recomposeScopeImplFindEffectiveRecomposeScope != null) {
                list2.add(recomposeScopeImplFindEffectiveRecomposeScope);
            } else {
                kj.a = false;
                list2.clear();
            }
        }
        slotReader.skipGroup();
    }

    private final List<Integer> keys() {
        return SlotTableKt.keys(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> nodes() {
        return SlotTableKt.nodeCounts(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> parentIndexes() {
        return SlotTableKt.parentAnchors(this.groups, this.groupsSize * 5);
    }

    private static final int verifyWellFormed$validateGroup(MJ mj, SlotTable slotTable, int i, int i2) {
        int i3 = mj.a;
        int i4 = i3 + 1;
        mj.a = i4;
        int iParentAnchor = SlotTableKt.parentAnchor(slotTable.groups, i3);
        if (iParentAnchor != i) {
            throw new IllegalStateException(("Invalid parent index detected at " + i3 + ", expected parent index to be " + i + " found " + iParentAnchor).toString());
        }
        int iGroupSize = SlotTableKt.groupSize(slotTable.groups, i3) + i3;
        if (iGroupSize > slotTable.groupsSize) {
            throw new IllegalStateException(("A group extends past the end of the table at " + i3).toString());
        }
        if (iGroupSize > i2) {
            throw new IllegalStateException(("A group extends past its parent group at " + i3).toString());
        }
        int iDataAnchor = SlotTableKt.dataAnchor(slotTable.groups, i3);
        int iDataAnchor2 = i3 >= slotTable.groupsSize - 1 ? slotTable.slotsSize : SlotTableKt.dataAnchor(slotTable.groups, i4);
        if (iDataAnchor2 > slotTable.slots.length) {
            throw new IllegalStateException(("Slots for " + i3 + " extend past the end of the slot table").toString());
        }
        if (iDataAnchor > iDataAnchor2) {
            throw new IllegalStateException(("Invalid data anchor at " + i3).toString());
        }
        if (SlotTableKt.slotAnchor(slotTable.groups, i3) > iDataAnchor2) {
            throw new IllegalStateException(("Slots start out of range at " + i3).toString());
        }
        if (iDataAnchor2 - iDataAnchor < (SlotTableKt.isNode(slotTable.groups, i3) ? 1 : 0) + (SlotTableKt.hasObjectKey(slotTable.groups, i3) ? 1 : 0) + (SlotTableKt.hasAux(slotTable.groups, i3) ? 1 : 0)) {
            throw new IllegalStateException(("Not enough slots added for group " + i3).toString());
        }
        boolean zIsNode = SlotTableKt.isNode(slotTable.groups, i3);
        if (zIsNode && slotTable.slots[SlotTableKt.nodeIndex(slotTable.groups, i3)] == null) {
            throw new IllegalStateException(("No node recorded for a node group at " + i3).toString());
        }
        int iVerifyWellFormed$validateGroup = 0;
        while (mj.a < iGroupSize) {
            iVerifyWellFormed$validateGroup += verifyWellFormed$validateGroup(mj, slotTable, i3, iGroupSize);
        }
        int iNodeCount = SlotTableKt.nodeCount(slotTable.groups, i3);
        int iGroupSize2 = SlotTableKt.groupSize(slotTable.groups, i3);
        if (iNodeCount != iVerifyWellFormed$validateGroup) {
            throw new IllegalStateException(("Incorrect node count detected at " + i3 + ", expected " + iNodeCount + ", received " + iVerifyWellFormed$validateGroup).toString());
        }
        int i5 = mj.a - i3;
        if (iGroupSize2 != i5) {
            throw new IllegalStateException(("Incorrect slot count detected at " + i3 + ", expected " + iGroupSize2 + ", received " + i5).toString());
        }
        if (!SlotTableKt.containsAnyMark(slotTable.groups, i3) || i3 <= 0 || SlotTableKt.containsMark(slotTable.groups, i)) {
            if (zIsNode) {
                return 1;
            }
            return iVerifyWellFormed$validateGroup;
        }
        throw new IllegalStateException(("Expected group " + i + " to record it contains a mark because " + i3 + " does").toString());
    }

    public final Anchor anchor(int i) {
        int i2;
        if (this.writer) {
            ComposerKt.composeRuntimeError("use active SlotWriter to create an anchor location instead ");
            throw new C1182Zu();
        }
        if (i < 0 || i >= (i2 = this.groupsSize)) {
            throw new IllegalArgumentException("Parameter index is out of range");
        }
        ArrayList<Anchor> arrayList = this.anchors;
        int iSearch = SlotTableKt.search(arrayList, i, i2);
        if (iSearch < 0) {
            Anchor anchor = new Anchor(i);
            arrayList.add(-(iSearch + 1), anchor);
            return anchor;
        }
        Anchor anchor2 = arrayList.get(iSearch);
        AbstractC4492zt.g(anchor2, "get(location)");
        return anchor2;
    }

    public final int anchorIndex(Anchor anchor) {
        AbstractC4492zt.h(anchor, "anchor");
        if (this.writer) {
            ComposerKt.composeRuntimeError("Use active SlotWriter to determine anchor location instead");
            throw new C1182Zu();
        }
        if (anchor.getValid()) {
            return anchor.getLocation$runtime_release();
        }
        throw new IllegalArgumentException("Anchor refers to a group that was removed");
    }

    public final String asString() {
        if (this.writer) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append('\n');
        int i = this.groupsSize;
        if (i > 0) {
            int iEmitGroup = 0;
            while (iEmitGroup < i) {
                iEmitGroup += emitGroup(sb, iEmitGroup, 0);
            }
        } else {
            sb.append("<EMPTY>");
        }
        String string = sb.toString();
        AbstractC4492zt.g(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final void close$runtime_release(SlotReader slotReader) {
        AbstractC4492zt.h(slotReader, "reader");
        if (slotReader.getTable$runtime_release() == this && this.readers > 0) {
            this.readers--;
        } else {
            ComposerKt.composeRuntimeError("Unexpected reader close()");
            throw new C1182Zu();
        }
    }

    public final boolean containsMark() {
        return this.groupsSize > 0 && SlotTableKt.containsMark(this.groups, 0);
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public CompositionGroup find(Object obj) {
        AbstractC4492zt.h(obj, "identityToFind");
        return new SlotTableGroup(this, 0, 0, 4, null).find(obj);
    }

    public final ArrayList<Anchor> getAnchors$runtime_release() {
        return this.anchors;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final Object[] getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    public final int getVersion$runtime_release() {
        return this.version;
    }

    public final boolean getWriter$runtime_release() {
        return this.writer;
    }

    public final boolean groupContainsAnchor(int i, Anchor anchor) {
        AbstractC4492zt.h(anchor, "anchor");
        if (this.writer) {
            ComposerKt.composeRuntimeError("Writer is active");
            throw new C1182Zu();
        }
        if (!(i >= 0 && i < this.groupsSize)) {
            ComposerKt.composeRuntimeError("Invalid group index");
            throw new C1182Zu();
        }
        if (ownsAnchor(anchor)) {
            int iGroupSize = SlotTableKt.groupSize(this.groups, i) + i;
            int location$runtime_release = anchor.getLocation$runtime_release();
            if (i <= location$runtime_release && location$runtime_release < iGroupSize) {
                return true;
            }
        }
        return false;
    }

    public final List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release(int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        KJ kj = new KJ();
        kj.a = true;
        SlotReader slotReaderOpenReader = openReader();
        try {
            invalidateGroupsWithKey$lambda$14$scanGroup(slotReaderOpenReader, i, arrayList, kj, this, arrayList2);
            FW fw = FW.a;
            slotReaderOpenReader.close();
            SlotWriter slotWriterOpenWriter = openWriter();
            try {
                slotWriterOpenWriter.startGroup();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Anchor anchor = (Anchor) arrayList.get(i2);
                    if (anchor.toIndexFor(slotWriterOpenWriter) >= slotWriterOpenWriter.getCurrentGroup()) {
                        slotWriterOpenWriter.seek(anchor);
                        slotWriterOpenWriter.bashGroup$runtime_release();
                    }
                }
                slotWriterOpenWriter.skipToGroupEnd();
                slotWriterOpenWriter.endGroup();
                slotWriterOpenWriter.close();
                if (kj.a) {
                    return arrayList2;
                }
                return null;
            } catch (Throwable th) {
                slotWriterOpenWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            slotReaderOpenReader.close();
            throw th2;
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        return this.groupsSize == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    public final SlotReader openReader() {
        if (this.writer) {
            throw new IllegalStateException("Cannot read while a writer is pending");
        }
        this.readers++;
        return new SlotReader(this);
    }

    public final SlotWriter openWriter() {
        if (this.writer) {
            ComposerKt.composeRuntimeError("Cannot start a writer when another writer is pending");
            throw new C1182Zu();
        }
        if (!(this.readers <= 0)) {
            ComposerKt.composeRuntimeError("Cannot start a writer when a reader is pending");
            throw new C1182Zu();
        }
        this.writer = true;
        this.version++;
        return new SlotWriter(this);
    }

    public final boolean ownsAnchor(Anchor anchor) {
        int iSearch;
        AbstractC4492zt.h(anchor, "anchor");
        return anchor.getValid() && (iSearch = SlotTableKt.search(this.anchors, anchor.getLocation$runtime_release(), this.groupsSize)) >= 0 && AbstractC4492zt.d(this.anchors.get(iSearch), anchor);
    }

    public final <T> T read(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        SlotReader slotReaderOpenReader = openReader();
        try {
            return (T) interfaceC3750qp.invoke(slotReaderOpenReader);
        } finally {
            AbstractC0703Ks.b(1);
            slotReaderOpenReader.close();
            AbstractC0703Ks.a(1);
        }
    }

    public final void setAnchors$runtime_release(ArrayList<Anchor> arrayList) {
        AbstractC4492zt.h(arrayList, "<set-?>");
        this.anchors = arrayList;
    }

    public final void setTo$runtime_release(int[] iArr, int i, Object[] objArr, int i2, ArrayList<Anchor> arrayList) {
        AbstractC4492zt.h(iArr, "groups");
        AbstractC4492zt.h(objArr, "slots");
        AbstractC4492zt.h(arrayList, "anchors");
        this.groups = iArr;
        this.groupsSize = i;
        this.slots = objArr;
        this.slotsSize = i2;
        this.anchors = arrayList;
    }

    public final void setVersion$runtime_release(int i) {
        this.version = i;
    }

    public final Object slot$runtime_release(int i, int i2) {
        int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, i);
        int i3 = i + 1;
        return (i2 < 0 || i2 >= (i3 < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i3) : this.slots.length) - iSlotAnchor) ? Composer.Companion.getEmpty() : this.slots[iSlotAnchor + i2];
    }

    public final List<Object> slotsOf$runtime_release(int i) {
        int iDataAnchor = SlotTableKt.dataAnchor(this.groups, i);
        int i2 = i + 1;
        return R5.l0(this.slots).subList(iDataAnchor, i2 < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i2) : this.slots.length);
    }

    public final void verifyWellFormed() {
        int i;
        int i2;
        MJ mj = new MJ();
        int i3 = -1;
        if (this.groupsSize > 0) {
            while (true) {
                i = mj.a;
                i2 = this.groupsSize;
                if (i >= i2) {
                    break;
                } else {
                    verifyWellFormed$validateGroup(mj, this, -1, i + SlotTableKt.groupSize(this.groups, i));
                }
            }
            if (i != i2) {
                throw new IllegalStateException(("Incomplete group at root " + mj.a + " expected to be " + this.groupsSize).toString());
            }
        }
        int length = this.slots.length;
        for (int i4 = this.slotsSize; i4 < length; i4++) {
            if (this.slots[i4] != null) {
                throw new IllegalStateException(("Non null value in the slot gap at index " + i4).toString());
            }
        }
        ArrayList<Anchor> arrayList = this.anchors;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            int indexFor = arrayList.get(i5).toIndexFor(this);
            if (indexFor < 0 || indexFor > this.groupsSize) {
                throw new IllegalArgumentException("Invalid anchor, location out of bound");
            }
            if (i3 >= indexFor) {
                throw new IllegalArgumentException("Anchor is out of order");
            }
            i5++;
            i3 = indexFor;
        }
    }

    public final <T> T write(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        SlotWriter slotWriterOpenWriter = openWriter();
        try {
            return (T) interfaceC3750qp.invoke(slotWriterOpenWriter);
        } finally {
            AbstractC0703Ks.b(1);
            slotWriterOpenWriter.close();
            AbstractC0703Ks.a(1);
        }
    }

    public final void close$runtime_release(SlotWriter slotWriter, int[] iArr, int i, Object[] objArr, int i2, ArrayList<Anchor> arrayList) {
        AbstractC4492zt.h(slotWriter, "writer");
        AbstractC4492zt.h(iArr, "groups");
        AbstractC4492zt.h(objArr, "slots");
        AbstractC4492zt.h(arrayList, "anchors");
        if (slotWriter.getTable$runtime_release() == this && this.writer) {
            this.writer = false;
            setTo$runtime_release(iArr, i, objArr, i2, arrayList);
            return;
        }
        throw new IllegalArgumentException("Unexpected writer close()");
    }
}
