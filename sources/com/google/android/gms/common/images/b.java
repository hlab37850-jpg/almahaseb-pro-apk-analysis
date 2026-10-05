package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Asserts;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {
    public final Uri a;
    public final Bitmap b;
    public final CountDownLatch c;
    public final /* synthetic */ ImageManager d;

    public b(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
        this.d = imageManager;
        this.a = uri;
        this.b = bitmap;
        this.c = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.d.zai.remove(this.a);
        if (imageReceiver != null) {
            ArrayList arrayList = imageReceiver.b;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zag zagVar = (zag) arrayList.get(i);
                Bitmap bitmap = this.b;
                if (bitmap != null) {
                    zagVar.zac(this.d.zad, bitmap, false);
                } else {
                    ImageManager imageManager = this.d;
                    imageManager.zaj.put(this.a, Long.valueOf(SystemClock.elapsedRealtime()));
                    ImageManager imageManager2 = this.d;
                    zagVar.zab(imageManager2.zad, imageManager2.zag, false);
                }
                if (!(zagVar instanceof zaf)) {
                    this.d.zah.remove(zagVar);
                }
            }
        }
        this.c.countDown();
        synchronized (ImageManager.zaa) {
            ImageManager.zab.remove(this.a);
        }
    }
}
