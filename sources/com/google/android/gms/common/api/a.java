package com.google.android.gms.common.api;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements PendingResult.StatusListener {
    public final /* synthetic */ Batch a;

    public a(Batch batch) {
        this.a = batch;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        synchronized (this.a.zai) {
            try {
                if (this.a.isCanceled()) {
                    return;
                }
                if (status.isCanceled()) {
                    this.a.zag = true;
                } else if (!status.isSuccess()) {
                    this.a.zaf = true;
                }
                this.a.zae--;
                Batch batch = this.a;
                if (batch.zae == 0) {
                    if (batch.zag) {
                        super/*com.google.android.gms.common.api.internal.BasePendingResult*/.cancel();
                    } else {
                        Status status2 = batch.zaf ? new Status(13) : Status.RESULT_SUCCESS;
                        Batch batch2 = this.a;
                        batch2.setResult(new BatchResult(status2, batch2.zah));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
