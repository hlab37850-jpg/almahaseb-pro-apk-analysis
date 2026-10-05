package androidx.paging;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC3310lS;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.KJ;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class PagingDataDiffer$presentNewList$transformedLastAccessedIndex$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ LoadStates $mediatorLoadStates;
    final /* synthetic */ HintReceiver $newHintReceiver;
    final /* synthetic */ PagePresenter<T> $newPresenter;
    final /* synthetic */ KJ $onListPresentableCalled;
    final /* synthetic */ List<TransformablePage<T>> $pages;
    final /* synthetic */ int $placeholdersAfter;
    final /* synthetic */ int $placeholdersBefore;
    final /* synthetic */ LoadStates $sourceLoadStates;
    final /* synthetic */ PagingDataDiffer<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagingDataDiffer$presentNewList$transformedLastAccessedIndex$1(PagingDataDiffer<T> pagingDataDiffer, PagePresenter<T> pagePresenter, KJ kj, HintReceiver hintReceiver, LoadStates loadStates, List<TransformablePage<T>> list, int i, int i2, LoadStates loadStates2) {
        super(0);
        this.this$0 = pagingDataDiffer;
        this.$newPresenter = pagePresenter;
        this.$onListPresentableCalled = kj;
        this.$newHintReceiver = hintReceiver;
        this.$mediatorLoadStates = loadStates;
        this.$pages = list;
        this.$placeholdersBefore = i;
        this.$placeholdersAfter = i2;
        this.$sourceLoadStates = loadStates2;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m5437invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m5437invoke() {
        List data;
        List data2;
        ((PagingDataDiffer) this.this$0).presenter = this.$newPresenter;
        this.$onListPresentableCalled.a = true;
        ((PagingDataDiffer) this.this$0).hintReceiver = this.$newHintReceiver;
        LoadStates loadStates = this.$mediatorLoadStates;
        List<TransformablePage<T>> list = this.$pages;
        int i = this.$placeholdersBefore;
        int i2 = this.$placeholdersAfter;
        HintReceiver hintReceiver = this.$newHintReceiver;
        LoadStates loadStates2 = this.$sourceLoadStates;
        Logger logger = LoggerKt.getLOGGER();
        if (logger == null || !logger.isLoggable(3)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Presenting data:\n                            |   first item: ");
        TransformablePage transformablePage = (TransformablePage) AbstractC3240kc.d0(list);
        sb.append((transformablePage == null || (data2 = transformablePage.getData()) == null) ? null : AbstractC3240kc.d0(data2));
        sb.append("\n                            |   last item: ");
        TransformablePage transformablePage2 = (TransformablePage) AbstractC3240kc.l0(list);
        sb.append((transformablePage2 == null || (data = transformablePage2.getData()) == null) ? null : AbstractC3240kc.l0(data));
        sb.append("\n                            |   placeholdersBefore: ");
        sb.append(i);
        sb.append("\n                            |   placeholdersAfter: ");
        sb.append(i2);
        sb.append("\n                            |   hintReceiver: ");
        sb.append(hintReceiver);
        sb.append("\n                            |   sourceLoadStates: ");
        sb.append(loadStates2);
        sb.append("\n                        ");
        String string = sb.toString();
        if (loadStates != null) {
            string = string + "|   mediatorLoadStates: " + loadStates + '\n';
        }
        logger.log(3, AbstractC3310lS.h(string + "|)", null, 1, null), null);
    }
}
