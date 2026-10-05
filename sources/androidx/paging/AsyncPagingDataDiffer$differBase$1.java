package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.E8;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.M8;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
public final class AsyncPagingDataDiffer$differBase$1<T> extends PagingDataDiffer<T> {
    final /* synthetic */ AsyncPagingDataDiffer<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncPagingDataDiffer$differBase$1(AsyncPagingDataDiffer<T> asyncPagingDataDiffer, DifferCallback differCallback, InterfaceC0988Vf interfaceC0988Vf) {
        super(differCallback, interfaceC0988Vf, null, 4, null);
        this.this$0 = asyncPagingDataDiffer;
    }

    @Override // androidx.paging.PagingDataDiffer
    public boolean postEvents() {
        return this.this$0.getInGetItem$paging_runtime_release();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.paging.PagingDataDiffer
    public Object presentNewList(NullPaddedList<T> nullPaddedList, NullPaddedList<T> nullPaddedList2, int i, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AsyncPagingDataDiffer$differBase$1$presentNewList$1 asyncPagingDataDiffer$differBase$1$presentNewList$1;
        AsyncPagingDataDiffer$differBase$1<T> asyncPagingDataDiffer$differBase$1;
        if (interfaceC0793Of instanceof AsyncPagingDataDiffer$differBase$1$presentNewList$1) {
            asyncPagingDataDiffer$differBase$1$presentNewList$1 = (AsyncPagingDataDiffer$differBase$1$presentNewList$1) interfaceC0793Of;
            int i2 = asyncPagingDataDiffer$differBase$1$presentNewList$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                asyncPagingDataDiffer$differBase$1$presentNewList$1.label = i2 - Integer.MIN_VALUE;
            } else {
                asyncPagingDataDiffer$differBase$1$presentNewList$1 = new AsyncPagingDataDiffer$differBase$1$presentNewList$1(this, interfaceC0793Of);
            }
        } else {
            asyncPagingDataDiffer$differBase$1$presentNewList$1 = new AsyncPagingDataDiffer$differBase$1$presentNewList$1(this, interfaceC0793Of);
        }
        Object objG = asyncPagingDataDiffer$differBase$1$presentNewList$1.result;
        Object objD = AbstractC0378Bt.d();
        int i3 = asyncPagingDataDiffer$differBase$1$presentNewList$1.label;
        if (i3 == 0) {
            LL.b(objG);
            if (nullPaddedList.getSize() == 0) {
                interfaceC3588op.invoke();
                this.this$0.getDifferCallback$paging_runtime_release().onInserted(0, nullPaddedList2.getSize());
                return null;
            }
            if (nullPaddedList2.getSize() == 0) {
                interfaceC3588op.invoke();
                this.this$0.getDifferCallback$paging_runtime_release().onRemoved(0, nullPaddedList.getSize());
                return null;
            }
            InterfaceC0988Vf interfaceC0988Vf = ((AsyncPagingDataDiffer) this.this$0).workerDispatcher;
            AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1 asyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1 = new AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1(nullPaddedList, nullPaddedList2, this.this$0, null);
            asyncPagingDataDiffer$differBase$1$presentNewList$1.L$0 = this;
            asyncPagingDataDiffer$differBase$1$presentNewList$1.L$1 = nullPaddedList;
            asyncPagingDataDiffer$differBase$1$presentNewList$1.L$2 = nullPaddedList2;
            asyncPagingDataDiffer$differBase$1$presentNewList$1.L$3 = interfaceC3588op;
            asyncPagingDataDiffer$differBase$1$presentNewList$1.I$0 = i;
            asyncPagingDataDiffer$differBase$1$presentNewList$1.label = 1;
            objG = M8.g(interfaceC0988Vf, asyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1, asyncPagingDataDiffer$differBase$1$presentNewList$1);
            if (objG == objD) {
                return objD;
            }
            asyncPagingDataDiffer$differBase$1 = this;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = asyncPagingDataDiffer$differBase$1$presentNewList$1.I$0;
            interfaceC3588op = (InterfaceC3588op) asyncPagingDataDiffer$differBase$1$presentNewList$1.L$3;
            nullPaddedList2 = (NullPaddedList) asyncPagingDataDiffer$differBase$1$presentNewList$1.L$2;
            nullPaddedList = (NullPaddedList) asyncPagingDataDiffer$differBase$1$presentNewList$1.L$1;
            asyncPagingDataDiffer$differBase$1 = (AsyncPagingDataDiffer$differBase$1) asyncPagingDataDiffer$differBase$1$presentNewList$1.L$0;
            LL.b(objG);
        }
        NullPaddedDiffResult nullPaddedDiffResult = (NullPaddedDiffResult) objG;
        interfaceC3588op.invoke();
        NullPaddedListDiffHelperKt.dispatchDiff(nullPaddedList, ((AsyncPagingDataDiffer) asyncPagingDataDiffer$differBase$1.this$0).updateCallback, nullPaddedList2, nullPaddedDiffResult);
        return E8.c(NullPaddedListDiffHelperKt.transformAnchorIndex(nullPaddedList, nullPaddedDiffResult, nullPaddedList2, i));
    }
}
