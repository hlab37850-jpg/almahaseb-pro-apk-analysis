package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.SynchronizedObject;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TypefaceRequestCache$runCached$currentTypefaceResult$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ TypefaceRequest $typefaceRequest;
    final /* synthetic */ TypefaceRequestCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypefaceRequestCache$runCached$currentTypefaceResult$1(TypefaceRequestCache typefaceRequestCache, TypefaceRequest typefaceRequest) {
        super(1);
        this.this$0 = typefaceRequestCache;
        this.$typefaceRequest = typefaceRequest;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TypefaceResult) obj);
        return FW.a;
    }

    public final void invoke(TypefaceResult typefaceResult) {
        AbstractC4492zt.h(typefaceResult, "finalResult");
        SynchronizedObject lock$ui_text_release = this.this$0.getLock$ui_text_release();
        TypefaceRequestCache typefaceRequestCache = this.this$0;
        TypefaceRequest typefaceRequest = this.$typefaceRequest;
        synchronized (lock$ui_text_release) {
            try {
                if (typefaceResult.getCacheable()) {
                    typefaceRequestCache.resultCache.put(typefaceRequest, typefaceResult);
                } else {
                    typefaceRequestCache.resultCache.remove(typefaceRequest);
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
