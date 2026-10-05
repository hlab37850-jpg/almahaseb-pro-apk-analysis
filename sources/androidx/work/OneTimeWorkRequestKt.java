package androidx.work;

import androidx.annotation.NonNull;
import defpackage.AbstractC0557Gu;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0635Ju;

/* JADX INFO: loaded from: classes2.dex */
public final class OneTimeWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> OneTimeWorkRequest.Builder OneTimeWorkRequestBuilder() {
        AbstractC4492zt.m(4, "W");
        return new OneTimeWorkRequest.Builder(ListenableWorker.class);
    }

    public static final OneTimeWorkRequest.Builder setInputMerger(OneTimeWorkRequest.Builder builder, @NonNull InterfaceC0635Ju interfaceC0635Ju) {
        AbstractC4492zt.h(builder, "<this>");
        AbstractC4492zt.h(interfaceC0635Ju, "inputMerger");
        return builder.setInputMerger(AbstractC0557Gu.a(interfaceC0635Ju));
    }
}
