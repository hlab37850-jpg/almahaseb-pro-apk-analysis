package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import defpackage.AbstractC0919Ss;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class NullPaddedListDiffHelperKt {
    public static final <T> NullPaddedDiffResult computeDiff(final NullPaddedList<T> nullPaddedList, final NullPaddedList<T> nullPaddedList2, final DiffUtil.ItemCallback<T> itemCallback) {
        AbstractC4492zt.h(nullPaddedList, "<this>");
        AbstractC4492zt.h(nullPaddedList2, "newList");
        AbstractC4492zt.h(itemCallback, "diffCallback");
        final int storageCount = nullPaddedList.getStorageCount();
        final int storageCount2 = nullPaddedList2.getStorageCount();
        DiffUtil.Callback callback = new DiffUtil.Callback() { // from class: androidx.paging.NullPaddedListDiffHelperKt$computeDiff$diffResult$1
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i, int i2) {
                Object fromStorage = nullPaddedList.getFromStorage(i);
                Object fromStorage2 = nullPaddedList2.getFromStorage(i2);
                if (fromStorage == fromStorage2) {
                    return true;
                }
                return itemCallback.areContentsTheSame(fromStorage, fromStorage2);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i, int i2) {
                Object fromStorage = nullPaddedList.getFromStorage(i);
                Object fromStorage2 = nullPaddedList2.getFromStorage(i2);
                if (fromStorage == fromStorage2) {
                    return true;
                }
                return itemCallback.areItemsTheSame(fromStorage, fromStorage2);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public Object getChangePayload(int i, int i2) {
                Object fromStorage = nullPaddedList.getFromStorage(i);
                Object fromStorage2 = nullPaddedList2.getFromStorage(i2);
                return fromStorage == fromStorage2 ? Boolean.TRUE : itemCallback.getChangePayload(fromStorage, fromStorage2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return storageCount2;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return storageCount;
            }
        };
        boolean z = true;
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(callback, true);
        AbstractC4492zt.g(diffResultCalculateDiff, "NullPaddedList<T>.comput…    },\n        true\n    )");
        Iterable iterableS = AbstractC3871sJ.s(0, nullPaddedList.getStorageCount());
        if ((iterableS instanceof Collection) && ((Collection) iterableS).isEmpty()) {
            z = false;
        } else {
            Iterator<T> it = iterableS.iterator();
            while (it.hasNext()) {
                if (diffResultCalculateDiff.convertOldPositionToNew(((AbstractC0919Ss) it).nextInt()) != -1) {
                }
            }
            z = false;
        }
        return new NullPaddedDiffResult(diffResultCalculateDiff, z);
    }

    public static final <T> void dispatchDiff(NullPaddedList<T> nullPaddedList, ListUpdateCallback listUpdateCallback, NullPaddedList<T> nullPaddedList2, NullPaddedDiffResult nullPaddedDiffResult) {
        AbstractC4492zt.h(nullPaddedList, "<this>");
        AbstractC4492zt.h(listUpdateCallback, "callback");
        AbstractC4492zt.h(nullPaddedList2, "newList");
        AbstractC4492zt.h(nullPaddedDiffResult, "diffResult");
        if (nullPaddedDiffResult.getHasOverlap()) {
            OverlappingListsDiffDispatcher.INSTANCE.dispatchDiff(nullPaddedList, nullPaddedList2, listUpdateCallback, nullPaddedDiffResult);
        } else {
            DistinctListsDiffDispatcher.INSTANCE.dispatchDiff(listUpdateCallback, nullPaddedList, nullPaddedList2);
        }
    }

    public static final int transformAnchorIndex(NullPaddedList<?> nullPaddedList, NullPaddedDiffResult nullPaddedDiffResult, NullPaddedList<?> nullPaddedList2, int i) {
        int iConvertOldPositionToNew;
        AbstractC4492zt.h(nullPaddedList, "<this>");
        AbstractC4492zt.h(nullPaddedDiffResult, "diffResult");
        AbstractC4492zt.h(nullPaddedList2, "newList");
        if (!nullPaddedDiffResult.getHasOverlap()) {
            return AbstractC3871sJ.m(i, AbstractC3871sJ.s(0, nullPaddedList2.getSize()));
        }
        int placeholdersBefore = i - nullPaddedList.getPlaceholdersBefore();
        int storageCount = nullPaddedList.getStorageCount();
        if (placeholdersBefore >= 0 && placeholdersBefore < storageCount) {
            for (int i2 = 0; i2 < 30; i2++) {
                int i3 = ((i2 / 2) * (i2 % 2 == 1 ? -1 : 1)) + placeholdersBefore;
                if (i3 >= 0 && i3 < nullPaddedList.getStorageCount() && (iConvertOldPositionToNew = nullPaddedDiffResult.getDiff().convertOldPositionToNew(i3)) != -1) {
                    return iConvertOldPositionToNew + nullPaddedList2.getPlaceholdersBefore();
                }
            }
        }
        return AbstractC3871sJ.m(i, AbstractC3871sJ.s(0, nullPaddedList2.getSize()));
    }
}
