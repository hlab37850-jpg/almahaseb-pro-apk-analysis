package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.C0945Ts;
import defpackage.InterfaceC0604Ip;
import defpackage.InterfaceC3750qp;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class TrieNode<K, V> {
    public static final Companion Companion = new Companion(null);
    private static final TrieNode EMPTY = new TrieNode(0, 0, new Object[0]);
    private Object[] buffer;
    private int dataMap;
    private int nodeMap;
    private final MutabilityOwnership ownedBy;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final TrieNode getEMPTY$runtime_release() {
            return TrieNode.EMPTY;
        }

        private Companion() {
        }
    }

    public static final class ModificationResult<K, V> {
        private TrieNode<K, V> node;
        private final int sizeDelta;

        public ModificationResult(TrieNode<K, V> trieNode, int i) {
            AbstractC4492zt.h(trieNode, "node");
            this.node = trieNode;
            this.sizeDelta = i;
        }

        public final TrieNode<K, V> getNode() {
            return this.node;
        }

        public final int getSizeDelta() {
            return this.sizeDelta;
        }

        public final ModificationResult<K, V> replaceNode(InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, Annotation.OPERATION);
            setNode((TrieNode) interfaceC3750qp.invoke(getNode()));
            return this;
        }

        public final void setNode(TrieNode<K, V> trieNode) {
            AbstractC4492zt.h(trieNode, "<set-?>");
            this.node = trieNode;
        }
    }

    public TrieNode(int i, int i2, Object[] objArr, MutabilityOwnership mutabilityOwnership) {
        AbstractC4492zt.h(objArr, "buffer");
        this.dataMap = i;
        this.nodeMap = i2;
        this.ownedBy = mutabilityOwnership;
        this.buffer = objArr;
    }

    private final void accept(InterfaceC0604Ip interfaceC0604Ip, int i, int i2) {
        interfaceC0604Ip.invoke(this, Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(this.dataMap), Integer.valueOf(this.nodeMap));
        int i3 = this.nodeMap;
        while (i3 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i3);
            nodeAtIndex$runtime_release(nodeIndex$runtime_release(iLowestOneBit)).accept(interfaceC0604Ip, (Integer.numberOfTrailingZeros(iLowestOneBit) << i2) + i, i2 + 5);
            i3 -= iLowestOneBit;
        }
    }

    private final ModificationResult<K, V> asInsertResult() {
        return new ModificationResult<>(this, 1);
    }

    private final ModificationResult<K, V> asUpdateResult() {
        return new ModificationResult<>(this, 0);
    }

    private final Object[] bufferMoveEntryToNode(int i, int i2, int i3, K k, V v, int i4, MutabilityOwnership mutabilityOwnership) {
        K kKeyAtIndex = keyAtIndex(i);
        return TrieNodeKt.replaceEntryWithNode(this.buffer, i, nodeIndex$runtime_release(i2) + 1, makeNode(kKeyAtIndex != null ? kKeyAtIndex.hashCode() : 0, kKeyAtIndex, valueAtKeyIndex(i), i3, k, v, i4 + 5, mutabilityOwnership));
    }

    private final int calculateSize() {
        if (this.nodeMap == 0) {
            return this.buffer.length / 2;
        }
        int iBitCount = Integer.bitCount(this.dataMap);
        int length = this.buffer.length;
        for (int i = iBitCount * 2; i < length; i++) {
            iBitCount += nodeAtIndex$runtime_release(i).calculateSize();
        }
        return iBitCount;
    }

    private final boolean collisionContainsKey(K k) {
        C0945Ts c0945TsR = AbstractC3871sJ.r(AbstractC3871sJ.s(0, this.buffer.length), 2);
        int iB = c0945TsR.b();
        int iC = c0945TsR.c();
        int iD = c0945TsR.d();
        if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
            while (!AbstractC4492zt.d(k, this.buffer[iB])) {
                if (iB != iC) {
                    iB += iD;
                }
            }
            return true;
        }
        return false;
    }

    private final V collisionGet(K k) {
        C0945Ts c0945TsR = AbstractC3871sJ.r(AbstractC3871sJ.s(0, this.buffer.length), 2);
        int iB = c0945TsR.b();
        int iC = c0945TsR.c();
        int iD = c0945TsR.d();
        if ((iD <= 0 || iB > iC) && (iD >= 0 || iC > iB)) {
            return null;
        }
        while (!AbstractC4492zt.d(k, keyAtIndex(iB))) {
            if (iB == iC) {
                return null;
            }
            iB += iD;
        }
        return valueAtKeyIndex(iB);
    }

    private final ModificationResult<K, V> collisionPut(K k, V v) {
        C0945Ts c0945TsR = AbstractC3871sJ.r(AbstractC3871sJ.s(0, this.buffer.length), 2);
        int iB = c0945TsR.b();
        int iC = c0945TsR.c();
        int iD = c0945TsR.d();
        if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
            while (!AbstractC4492zt.d(k, keyAtIndex(iB))) {
                if (iB != iC) {
                    iB += iD;
                }
            }
            if (v == valueAtKeyIndex(iB)) {
                return null;
            }
            Object[] objArr = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            AbstractC4492zt.g(objArrCopyOf, "copyOf(this, size)");
            objArrCopyOf[iB + 1] = v;
            return new TrieNode(0, 0, objArrCopyOf).asUpdateResult();
        }
        return new TrieNode(0, 0, TrieNodeKt.insertEntryAtIndex(this.buffer, 0, k, v)).asInsertResult();
    }

    private final TrieNode<K, V> collisionRemove(K k) {
        C0945Ts c0945TsR = AbstractC3871sJ.r(AbstractC3871sJ.s(0, this.buffer.length), 2);
        int iB = c0945TsR.b();
        int iC = c0945TsR.c();
        int iD = c0945TsR.d();
        if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
            while (!AbstractC4492zt.d(k, keyAtIndex(iB))) {
                if (iB != iC) {
                    iB += iD;
                }
            }
            return collisionRemoveEntryAtIndex(iB);
        }
        return this;
    }

    private final TrieNode<K, V> collisionRemoveEntryAtIndex(int i) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new TrieNode<>(0, 0, TrieNodeKt.removeEntryAtIndex(objArr, i));
    }

    private final boolean elementsIdentityEquals(TrieNode<K, V> trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.nodeMap != trieNode.nodeMap || this.dataMap != trieNode.dataMap) {
            return false;
        }
        int length = this.buffer.length;
        for (int i = 0; i < length; i++) {
            if (this.buffer[i] != trieNode.buffer[i]) {
                return false;
            }
        }
        return true;
    }

    private final boolean hasNodeAt(int i) {
        return (i & this.nodeMap) != 0;
    }

    private final TrieNode<K, V> insertEntryAt(int i, K k, V v) {
        return new TrieNode<>(i | this.dataMap, this.nodeMap, TrieNodeKt.insertEntryAtIndex(this.buffer, entryKeyIndex$runtime_release(i), k, v));
    }

    private final K keyAtIndex(int i) {
        return (K) this.buffer[i];
    }

    private final TrieNode<K, V> makeNode(int i, K k, V v, int i2, K k2, V v2, int i3, MutabilityOwnership mutabilityOwnership) {
        if (i3 > 30) {
            return new TrieNode<>(0, 0, new Object[]{k, v, k2, v2}, mutabilityOwnership);
        }
        int iIndexSegment = TrieNodeKt.indexSegment(i, i3);
        int iIndexSegment2 = TrieNodeKt.indexSegment(i2, i3);
        if (iIndexSegment != iIndexSegment2) {
            return new TrieNode<>((1 << iIndexSegment) | (1 << iIndexSegment2), 0, iIndexSegment < iIndexSegment2 ? new Object[]{k, v, k2, v2} : new Object[]{k2, v2, k, v}, mutabilityOwnership);
        }
        return new TrieNode<>(0, 1 << iIndexSegment, new Object[]{makeNode(i, k, v, i2, k2, v2, i3 + 5, mutabilityOwnership)}, mutabilityOwnership);
    }

    private final TrieNode<K, V> moveEntryToNode(int i, int i2, int i3, K k, V v, int i4) {
        return new TrieNode<>(this.dataMap ^ i2, i2 | this.nodeMap, bufferMoveEntryToNode(i, i2, i3, k, v, i4, null));
    }

    private final TrieNode<K, V> mutableCollisionPut(K k, V v, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        C0945Ts c0945TsR = AbstractC3871sJ.r(AbstractC3871sJ.s(0, this.buffer.length), 2);
        int iB = c0945TsR.b();
        int iC = c0945TsR.c();
        int iD = c0945TsR.d();
        if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
            while (!AbstractC4492zt.d(k, keyAtIndex(iB))) {
                if (iB != iC) {
                    iB += iD;
                }
            }
            persistentHashMapBuilder.setOperationResult$runtime_release(valueAtKeyIndex(iB));
            if (this.ownedBy == persistentHashMapBuilder.getOwnership()) {
                this.buffer[iB + 1] = v;
                return this;
            }
            persistentHashMapBuilder.setModCount$runtime_release(persistentHashMapBuilder.getModCount$runtime_release() + 1);
            Object[] objArr = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            AbstractC4492zt.g(objArrCopyOf, "copyOf(this, size)");
            objArrCopyOf[iB + 1] = v;
            return new TrieNode<>(0, 0, objArrCopyOf, persistentHashMapBuilder.getOwnership());
        }
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() + 1);
        return new TrieNode<>(0, 0, TrieNodeKt.insertEntryAtIndex(this.buffer, 0, k, v), persistentHashMapBuilder.getOwnership());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TrieNode<K, V> mutableCollisionPutAll(TrieNode<K, V> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        CommonFunctionsKt.m2673assert(this.nodeMap == 0);
        CommonFunctionsKt.m2673assert(this.dataMap == 0);
        CommonFunctionsKt.m2673assert(trieNode.nodeMap == 0);
        CommonFunctionsKt.m2673assert(trieNode.dataMap == 0);
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + trieNode.buffer.length);
        AbstractC4492zt.g(objArrCopyOf, "copyOf(this, newSize)");
        int length = this.buffer.length;
        C0945Ts c0945TsR = AbstractC3871sJ.r(AbstractC3871sJ.s(0, trieNode.buffer.length), 2);
        int iB = c0945TsR.b();
        int iC = c0945TsR.c();
        int iD = c0945TsR.d();
        if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
            while (true) {
                if (collisionContainsKey(trieNode.buffer[iB])) {
                    deltaCounter.setCount(deltaCounter.getCount() + 1);
                } else {
                    Object[] objArr2 = trieNode.buffer;
                    objArrCopyOf[length] = objArr2[iB];
                    objArrCopyOf[length + 1] = objArr2[iB + 1];
                    length += 2;
                }
                if (iB == iC) {
                    break;
                }
                iB += iD;
            }
        }
        if (length == this.buffer.length) {
            return this;
        }
        if (length == trieNode.buffer.length) {
            return trieNode;
        }
        if (length == objArrCopyOf.length) {
            return new TrieNode<>(0, 0, objArrCopyOf, mutabilityOwnership);
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, length);
        AbstractC4492zt.g(objArrCopyOf2, "copyOf(this, newSize)");
        return new TrieNode<>(0, 0, objArrCopyOf2, mutabilityOwnership);
    }

    private final TrieNode<K, V> mutableCollisionRemove(K k, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        C0945Ts c0945TsR = AbstractC3871sJ.r(AbstractC3871sJ.s(0, this.buffer.length), 2);
        int iB = c0945TsR.b();
        int iC = c0945TsR.c();
        int iD = c0945TsR.d();
        if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
            while (!AbstractC4492zt.d(k, keyAtIndex(iB))) {
                if (iB != iC) {
                    iB += iD;
                }
            }
            return mutableCollisionRemoveEntryAtIndex(iB, persistentHashMapBuilder);
        }
        return this;
    }

    private final TrieNode<K, V> mutableCollisionRemoveEntryAtIndex(int i, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() - 1);
        persistentHashMapBuilder.setOperationResult$runtime_release(valueAtKeyIndex(i));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy != persistentHashMapBuilder.getOwnership()) {
            return new TrieNode<>(0, 0, TrieNodeKt.removeEntryAtIndex(this.buffer, i), persistentHashMapBuilder.getOwnership());
        }
        this.buffer = TrieNodeKt.removeEntryAtIndex(this.buffer, i);
        return this;
    }

    private final TrieNode<K, V> mutableInsertEntryAt(int i, K k, V v, MutabilityOwnership mutabilityOwnership) {
        int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i);
        if (this.ownedBy != mutabilityOwnership) {
            return new TrieNode<>(i | this.dataMap, this.nodeMap, TrieNodeKt.insertEntryAtIndex(this.buffer, iEntryKeyIndex$runtime_release, k, v), mutabilityOwnership);
        }
        this.buffer = TrieNodeKt.insertEntryAtIndex(this.buffer, iEntryKeyIndex$runtime_release, k, v);
        this.dataMap = i | this.dataMap;
        return this;
    }

    private final TrieNode<K, V> mutableMoveEntryToNode(int i, int i2, int i3, K k, V v, int i4, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy != mutabilityOwnership) {
            return new TrieNode<>(this.dataMap ^ i2, i2 | this.nodeMap, bufferMoveEntryToNode(i, i2, i3, k, v, i4, mutabilityOwnership), mutabilityOwnership);
        }
        this.buffer = bufferMoveEntryToNode(i, i2, i3, k, v, i4, mutabilityOwnership);
        this.dataMap ^= i2;
        this.nodeMap |= i2;
        return this;
    }

    private final TrieNode<K, V> mutablePutAllFromOtherNodeCell(TrieNode<K, V> trieNode, int i, int i2, DeltaCounter deltaCounter, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        if (hasNodeAt(i)) {
            TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(i));
            if (trieNode.hasNodeAt(i)) {
                return trieNodeNodeAtIndex$runtime_release.mutablePutAll(trieNode.nodeAtIndex$runtime_release(trieNode.nodeIndex$runtime_release(i)), i2 + 5, deltaCounter, persistentHashMapBuilder);
            }
            if (!trieNode.hasEntryAt$runtime_release(i)) {
                return trieNodeNodeAtIndex$runtime_release;
            }
            int iEntryKeyIndex$runtime_release = trieNode.entryKeyIndex$runtime_release(i);
            K kKeyAtIndex = trieNode.keyAtIndex(iEntryKeyIndex$runtime_release);
            V vValueAtKeyIndex = trieNode.valueAtKeyIndex(iEntryKeyIndex$runtime_release);
            int size = persistentHashMapBuilder.size();
            TrieNode<K, V> trieNodeMutablePut = trieNodeNodeAtIndex$runtime_release.mutablePut(kKeyAtIndex != null ? kKeyAtIndex.hashCode() : 0, kKeyAtIndex, vValueAtKeyIndex, i2 + 5, persistentHashMapBuilder);
            if (persistentHashMapBuilder.size() != size) {
                return trieNodeMutablePut;
            }
            deltaCounter.setCount(deltaCounter.getCount() + 1);
            return trieNodeMutablePut;
        }
        if (!trieNode.hasNodeAt(i)) {
            int iEntryKeyIndex$runtime_release2 = entryKeyIndex$runtime_release(i);
            K kKeyAtIndex2 = keyAtIndex(iEntryKeyIndex$runtime_release2);
            V vValueAtKeyIndex2 = valueAtKeyIndex(iEntryKeyIndex$runtime_release2);
            int iEntryKeyIndex$runtime_release3 = trieNode.entryKeyIndex$runtime_release(i);
            K kKeyAtIndex3 = trieNode.keyAtIndex(iEntryKeyIndex$runtime_release3);
            return makeNode(kKeyAtIndex2 != null ? kKeyAtIndex2.hashCode() : 0, kKeyAtIndex2, vValueAtKeyIndex2, kKeyAtIndex3 != null ? kKeyAtIndex3.hashCode() : 0, kKeyAtIndex3, trieNode.valueAtKeyIndex(iEntryKeyIndex$runtime_release3), i2 + 5, persistentHashMapBuilder.getOwnership());
        }
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release2 = trieNode.nodeAtIndex$runtime_release(trieNode.nodeIndex$runtime_release(i));
        if (hasEntryAt$runtime_release(i)) {
            int iEntryKeyIndex$runtime_release4 = entryKeyIndex$runtime_release(i);
            K kKeyAtIndex4 = keyAtIndex(iEntryKeyIndex$runtime_release4);
            int i3 = i2 + 5;
            if (!trieNodeNodeAtIndex$runtime_release2.containsKey(kKeyAtIndex4 != null ? kKeyAtIndex4.hashCode() : 0, kKeyAtIndex4, i3)) {
                return trieNodeNodeAtIndex$runtime_release2.mutablePut(kKeyAtIndex4 != null ? kKeyAtIndex4.hashCode() : 0, kKeyAtIndex4, valueAtKeyIndex(iEntryKeyIndex$runtime_release4), i3, persistentHashMapBuilder);
            }
            deltaCounter.setCount(deltaCounter.getCount() + 1);
        }
        return trieNodeNodeAtIndex$runtime_release2;
    }

    private final TrieNode<K, V> mutableRemoveEntryAtIndex(int i, int i2, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() - 1);
        persistentHashMapBuilder.setOperationResult$runtime_release(valueAtKeyIndex(i));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy != persistentHashMapBuilder.getOwnership()) {
            return new TrieNode<>(i2 ^ this.dataMap, this.nodeMap, TrieNodeKt.removeEntryAtIndex(this.buffer, i), persistentHashMapBuilder.getOwnership());
        }
        this.buffer = TrieNodeKt.removeEntryAtIndex(this.buffer, i);
        this.dataMap ^= i2;
        return this;
    }

    private final TrieNode<K, V> mutableRemoveNodeAtIndex(int i, int i2, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        if (this.ownedBy != mutabilityOwnership) {
            return new TrieNode<>(this.dataMap, i2 ^ this.nodeMap, TrieNodeKt.removeNodeAtIndex(objArr, i), mutabilityOwnership);
        }
        this.buffer = TrieNodeKt.removeNodeAtIndex(objArr, i);
        this.nodeMap ^= i2;
        return this;
    }

    private final TrieNode<K, V> mutableReplaceNode(TrieNode<K, V> trieNode, TrieNode<K, V> trieNode2, int i, int i2, MutabilityOwnership mutabilityOwnership) {
        if (trieNode2 == null) {
            return mutableRemoveNodeAtIndex(i, i2, mutabilityOwnership);
        }
        return (this.ownedBy == mutabilityOwnership || trieNode != trieNode2) ? mutableUpdateNodeAtIndex(i, trieNode2, mutabilityOwnership) : this;
    }

    private final TrieNode<K, V> mutableUpdateNodeAtIndex(int i, TrieNode<K, V> trieNode, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1 && trieNode.buffer.length == 2 && trieNode.nodeMap == 0) {
            trieNode.dataMap = this.nodeMap;
            return trieNode;
        }
        if (this.ownedBy == mutabilityOwnership) {
            objArr[i] = trieNode;
            return this;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC4492zt.g(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i] = trieNode;
        return new TrieNode<>(this.dataMap, this.nodeMap, objArrCopyOf, mutabilityOwnership);
    }

    private final TrieNode<K, V> mutableUpdateValueAtIndex(int i, V v, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        if (this.ownedBy == persistentHashMapBuilder.getOwnership()) {
            this.buffer[i + 1] = v;
            return this;
        }
        persistentHashMapBuilder.setModCount$runtime_release(persistentHashMapBuilder.getModCount$runtime_release() + 1);
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC4492zt.g(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i + 1] = v;
        return new TrieNode<>(this.dataMap, this.nodeMap, objArrCopyOf, persistentHashMapBuilder.getOwnership());
    }

    private final TrieNode<K, V> removeEntryAtIndex(int i, int i2) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new TrieNode<>(i2 ^ this.dataMap, this.nodeMap, TrieNodeKt.removeEntryAtIndex(objArr, i));
    }

    private final TrieNode<K, V> removeNodeAtIndex(int i, int i2) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        return new TrieNode<>(this.dataMap, i2 ^ this.nodeMap, TrieNodeKt.removeNodeAtIndex(objArr, i));
    }

    private final TrieNode<K, V> replaceNode(TrieNode<K, V> trieNode, TrieNode<K, V> trieNode2, int i, int i2) {
        if (trieNode2 == null) {
            return removeNodeAtIndex(i, i2);
        }
        return trieNode != trieNode2 ? updateNodeAtIndex(i, i2, trieNode2) : this;
    }

    private final TrieNode<K, V> updateNodeAtIndex(int i, int i2, TrieNode<K, V> trieNode) {
        Object[] objArr = trieNode.buffer;
        if (objArr.length != 2 || trieNode.nodeMap != 0) {
            Object[] objArr2 = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
            AbstractC4492zt.g(objArrCopyOf, "copyOf(this, newSize)");
            objArrCopyOf[i] = trieNode;
            return new TrieNode<>(this.dataMap, this.nodeMap, objArrCopyOf);
        }
        if (this.buffer.length == 1) {
            trieNode.dataMap = this.nodeMap;
            return trieNode;
        }
        return new TrieNode<>(this.dataMap ^ i2, i2 ^ this.nodeMap, TrieNodeKt.replaceNodeWithEntry(this.buffer, i, entryKeyIndex$runtime_release(i2), objArr[0], objArr[1]));
    }

    private final TrieNode<K, V> updateValueAtIndex(int i, V v) {
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC4492zt.g(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i + 1] = v;
        return new TrieNode<>(this.dataMap, this.nodeMap, objArrCopyOf);
    }

    private final V valueAtKeyIndex(int i) {
        return (V) this.buffer[i + 1];
    }

    public final void accept$runtime_release(InterfaceC0604Ip interfaceC0604Ip) {
        AbstractC4492zt.h(interfaceC0604Ip, "visitor");
        accept(interfaceC0604Ip, 0, 0);
    }

    public final boolean containsKey(int i, K k, int i2) {
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            return AbstractC4492zt.d(k, keyAtIndex(entryKeyIndex$runtime_release(iIndexSegment)));
        }
        if (!hasNodeAt(iIndexSegment)) {
            return false;
        }
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(iIndexSegment));
        return i2 == 30 ? trieNodeNodeAtIndex$runtime_release.collisionContainsKey(k) : trieNodeNodeAtIndex$runtime_release.containsKey(i, k, i2 + 5);
    }

    public final int entryCount$runtime_release() {
        return Integer.bitCount(this.dataMap);
    }

    public final int entryKeyIndex$runtime_release(int i) {
        return Integer.bitCount((i - 1) & this.dataMap) * 2;
    }

    public final V get(int i, K k, int i2) {
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            if (AbstractC4492zt.d(k, keyAtIndex(iEntryKeyIndex$runtime_release))) {
                return valueAtKeyIndex(iEntryKeyIndex$runtime_release);
            }
            return null;
        }
        if (!hasNodeAt(iIndexSegment)) {
            return null;
        }
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(iIndexSegment));
        return i2 == 30 ? trieNodeNodeAtIndex$runtime_release.collisionGet(k) : trieNodeNodeAtIndex$runtime_release.get(i, k, i2 + 5);
    }

    public final Object[] getBuffer$runtime_release() {
        return this.buffer;
    }

    public final boolean hasEntryAt$runtime_release(int i) {
        return (i & this.dataMap) != 0;
    }

    public final TrieNode<K, V> mutablePut(int i, K k, V v, int i2, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        AbstractC4492zt.h(persistentHashMapBuilder, "mutator");
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            if (AbstractC4492zt.d(k, keyAtIndex(iEntryKeyIndex$runtime_release))) {
                persistentHashMapBuilder.setOperationResult$runtime_release(valueAtKeyIndex(iEntryKeyIndex$runtime_release));
                return valueAtKeyIndex(iEntryKeyIndex$runtime_release) == v ? this : mutableUpdateValueAtIndex(iEntryKeyIndex$runtime_release, v, persistentHashMapBuilder);
            }
            persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() + 1);
            return mutableMoveEntryToNode(iEntryKeyIndex$runtime_release, iIndexSegment, i, k, v, i2, persistentHashMapBuilder.getOwnership());
        }
        if (!hasNodeAt(iIndexSegment)) {
            persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() + 1);
            return mutableInsertEntryAt(iIndexSegment, k, v, persistentHashMapBuilder.getOwnership());
        }
        int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
        TrieNode<K, V> trieNodeMutableCollisionPut = i2 == 30 ? trieNodeNodeAtIndex$runtime_release.mutableCollisionPut(k, v, persistentHashMapBuilder) : trieNodeNodeAtIndex$runtime_release.mutablePut(i, k, v, i2 + 5, persistentHashMapBuilder);
        return trieNodeNodeAtIndex$runtime_release == trieNodeMutableCollisionPut ? this : mutableUpdateNodeAtIndex(iNodeIndex$runtime_release, trieNodeMutableCollisionPut, persistentHashMapBuilder.getOwnership());
    }

    public final TrieNode<K, V> mutablePutAll(TrieNode<K, V> trieNode, int i, DeltaCounter deltaCounter, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        AbstractC4492zt.h(trieNode, "otherNode");
        AbstractC4492zt.h(deltaCounter, "intersectionCounter");
        AbstractC4492zt.h(persistentHashMapBuilder, "mutator");
        if (this == trieNode) {
            deltaCounter.plusAssign(calculateSize());
            return this;
        }
        if (i > 30) {
            return mutableCollisionPutAll(trieNode, deltaCounter, persistentHashMapBuilder.getOwnership());
        }
        int i2 = this.nodeMap | trieNode.nodeMap;
        int i3 = this.dataMap;
        int i4 = trieNode.dataMap;
        int i5 = (i3 ^ i4) & (~i2);
        int i6 = i3 & i4;
        int i7 = i5;
        while (i6 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i6);
            if (AbstractC4492zt.d(keyAtIndex(entryKeyIndex$runtime_release(iLowestOneBit)), trieNode.keyAtIndex(trieNode.entryKeyIndex$runtime_release(iLowestOneBit)))) {
                i7 |= iLowestOneBit;
            } else {
                i2 |= iLowestOneBit;
            }
            i6 ^= iLowestOneBit;
        }
        if ((i2 & i7) != 0) {
            throw new IllegalStateException("Check failed.");
        }
        TrieNode<K, V> trieNode2 = (AbstractC4492zt.d(this.ownedBy, persistentHashMapBuilder.getOwnership()) && this.dataMap == i7 && this.nodeMap == i2) ? this : new TrieNode<>(i7, i2, new Object[(Integer.bitCount(i7) * 2) + Integer.bitCount(i2)]);
        int i8 = 0;
        int i9 = i2;
        int i10 = 0;
        while (i9 != 0) {
            int iLowestOneBit2 = Integer.lowestOneBit(i9);
            Object[] objArr = trieNode2.buffer;
            objArr[(objArr.length - 1) - i10] = mutablePutAllFromOtherNodeCell(trieNode, iLowestOneBit2, i, deltaCounter, persistentHashMapBuilder);
            i10++;
            i9 ^= iLowestOneBit2;
        }
        while (i7 != 0) {
            int iLowestOneBit3 = Integer.lowestOneBit(i7);
            int i11 = i8 * 2;
            if (trieNode.hasEntryAt$runtime_release(iLowestOneBit3)) {
                int iEntryKeyIndex$runtime_release = trieNode.entryKeyIndex$runtime_release(iLowestOneBit3);
                trieNode2.buffer[i11] = trieNode.keyAtIndex(iEntryKeyIndex$runtime_release);
                trieNode2.buffer[i11 + 1] = trieNode.valueAtKeyIndex(iEntryKeyIndex$runtime_release);
                if (hasEntryAt$runtime_release(iLowestOneBit3)) {
                    deltaCounter.setCount(deltaCounter.getCount() + 1);
                }
            } else {
                int iEntryKeyIndex$runtime_release2 = entryKeyIndex$runtime_release(iLowestOneBit3);
                trieNode2.buffer[i11] = keyAtIndex(iEntryKeyIndex$runtime_release2);
                trieNode2.buffer[i11 + 1] = valueAtKeyIndex(iEntryKeyIndex$runtime_release2);
            }
            i8++;
            i7 ^= iLowestOneBit3;
        }
        if (elementsIdentityEquals(trieNode2)) {
            return this;
        }
        return trieNode.elementsIdentityEquals(trieNode2) ? trieNode : trieNode2;
    }

    public final TrieNode<K, V> mutableRemove(int i, K k, int i2, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        AbstractC4492zt.h(persistentHashMapBuilder, "mutator");
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            return AbstractC4492zt.d(k, keyAtIndex(iEntryKeyIndex$runtime_release)) ? mutableRemoveEntryAtIndex(iEntryKeyIndex$runtime_release, iIndexSegment, persistentHashMapBuilder) : this;
        }
        if (!hasNodeAt(iIndexSegment)) {
            return this;
        }
        int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
        return mutableReplaceNode(trieNodeNodeAtIndex$runtime_release, i2 == 30 ? trieNodeNodeAtIndex$runtime_release.mutableCollisionRemove(k, persistentHashMapBuilder) : trieNodeNodeAtIndex$runtime_release.mutableRemove(i, k, i2 + 5, persistentHashMapBuilder), iNodeIndex$runtime_release, iIndexSegment, persistentHashMapBuilder.getOwnership());
    }

    public final TrieNode<K, V> nodeAtIndex$runtime_release(int i) {
        Object obj = this.buffer[i];
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (TrieNode) obj;
    }

    public final int nodeIndex$runtime_release(int i) {
        return (this.buffer.length - 1) - Integer.bitCount((i - 1) & this.nodeMap);
    }

    public final ModificationResult<K, V> put(int i, K k, V v, int i2) {
        ModificationResult<K, V> modificationResultPut;
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            if (!AbstractC4492zt.d(k, keyAtIndex(iEntryKeyIndex$runtime_release))) {
                return moveEntryToNode(iEntryKeyIndex$runtime_release, iIndexSegment, i, k, v, i2).asInsertResult();
            }
            if (valueAtKeyIndex(iEntryKeyIndex$runtime_release) == v) {
                return null;
            }
            return updateValueAtIndex(iEntryKeyIndex$runtime_release, v).asUpdateResult();
        }
        if (!hasNodeAt(iIndexSegment)) {
            return insertEntryAt(iIndexSegment, k, v).asInsertResult();
        }
        int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
        if (i2 == 30) {
            modificationResultPut = trieNodeNodeAtIndex$runtime_release.collisionPut(k, v);
            if (modificationResultPut == null) {
                return null;
            }
        } else {
            modificationResultPut = trieNodeNodeAtIndex$runtime_release.put(i, k, v, i2 + 5);
            if (modificationResultPut == null) {
                return null;
            }
        }
        modificationResultPut.setNode(updateNodeAtIndex(iNodeIndex$runtime_release, iIndexSegment, modificationResultPut.getNode()));
        return modificationResultPut;
    }

    public final TrieNode<K, V> remove(int i, K k, int i2) {
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            return AbstractC4492zt.d(k, keyAtIndex(iEntryKeyIndex$runtime_release)) ? removeEntryAtIndex(iEntryKeyIndex$runtime_release, iIndexSegment) : this;
        }
        if (!hasNodeAt(iIndexSegment)) {
            return this;
        }
        int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
        return replaceNode(trieNodeNodeAtIndex$runtime_release, i2 == 30 ? trieNodeNodeAtIndex$runtime_release.collisionRemove(k) : trieNodeNodeAtIndex$runtime_release.remove(i, k, i2 + 5), iNodeIndex$runtime_release, iIndexSegment);
    }

    private final TrieNode<K, V> collisionRemove(K k, V v) {
        C0945Ts c0945TsR = AbstractC3871sJ.r(AbstractC3871sJ.s(0, this.buffer.length), 2);
        int iB = c0945TsR.b();
        int iC = c0945TsR.c();
        int iD = c0945TsR.d();
        if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
            while (true) {
                if (AbstractC4492zt.d(k, keyAtIndex(iB)) && AbstractC4492zt.d(v, valueAtKeyIndex(iB))) {
                    return collisionRemoveEntryAtIndex(iB);
                }
                if (iB != iC) {
                    iB += iD;
                }
            }
        }
        return this;
    }

    private final TrieNode<K, V> mutableCollisionRemove(K k, V v, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        C0945Ts c0945TsR = AbstractC3871sJ.r(AbstractC3871sJ.s(0, this.buffer.length), 2);
        int iB = c0945TsR.b();
        int iC = c0945TsR.c();
        int iD = c0945TsR.d();
        if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
            while (true) {
                if (AbstractC4492zt.d(k, keyAtIndex(iB)) && AbstractC4492zt.d(v, valueAtKeyIndex(iB))) {
                    return mutableCollisionRemoveEntryAtIndex(iB, persistentHashMapBuilder);
                }
                if (iB != iC) {
                    iB += iD;
                }
            }
        }
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TrieNode(int i, int i2, Object[] objArr) {
        this(i, i2, objArr, null);
        AbstractC4492zt.h(objArr, "buffer");
    }

    public final TrieNode<K, V> mutableRemove(int i, K k, V v, int i2, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        TrieNode<K, V> trieNodeMutableRemove;
        AbstractC4492zt.h(persistentHashMapBuilder, "mutator");
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            return (AbstractC4492zt.d(k, keyAtIndex(iEntryKeyIndex$runtime_release)) && AbstractC4492zt.d(v, valueAtKeyIndex(iEntryKeyIndex$runtime_release))) ? mutableRemoveEntryAtIndex(iEntryKeyIndex$runtime_release, iIndexSegment, persistentHashMapBuilder) : this;
        }
        if (!hasNodeAt(iIndexSegment)) {
            return this;
        }
        int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
        if (i2 == 30) {
            trieNodeMutableRemove = trieNodeNodeAtIndex$runtime_release.mutableCollisionRemove(k, v, persistentHashMapBuilder);
        } else {
            trieNodeMutableRemove = trieNodeNodeAtIndex$runtime_release.mutableRemove(i, k, v, i2 + 5, persistentHashMapBuilder);
        }
        return mutableReplaceNode(trieNodeNodeAtIndex$runtime_release, trieNodeMutableRemove, iNodeIndex$runtime_release, iIndexSegment, persistentHashMapBuilder.getOwnership());
    }

    public final TrieNode<K, V> remove(int i, K k, V v, int i2) {
        TrieNode<K, V> trieNodeRemove;
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            return (AbstractC4492zt.d(k, keyAtIndex(iEntryKeyIndex$runtime_release)) && AbstractC4492zt.d(v, valueAtKeyIndex(iEntryKeyIndex$runtime_release))) ? removeEntryAtIndex(iEntryKeyIndex$runtime_release, iIndexSegment) : this;
        }
        if (!hasNodeAt(iIndexSegment)) {
            return this;
        }
        int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
        if (i2 == 30) {
            trieNodeRemove = trieNodeNodeAtIndex$runtime_release.collisionRemove(k, v);
        } else {
            trieNodeRemove = trieNodeNodeAtIndex$runtime_release.remove(i, k, v, i2 + 5);
        }
        return replaceNode(trieNodeNodeAtIndex$runtime_release, trieNodeRemove, iNodeIndex$runtime_release, iIndexSegment);
    }
}
