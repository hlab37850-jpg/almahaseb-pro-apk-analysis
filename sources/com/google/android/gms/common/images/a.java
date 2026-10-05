package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager.ImageReceiver;
import com.google.android.gms.common.internal.Asserts;
import defpackage.C2408i20;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {
    public final zag a;
    public final /* synthetic */ ImageManager b;

    public a(ImageManager imageManager, zag zagVar) {
        this.b = imageManager;
        this.a = zagVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.b.zah.get(this.a);
        if (imageReceiver != null) {
            ImageManager imageManager = this.b;
            imageManager.zah.remove(this.a);
            imageReceiver.c(this.a);
        }
        zag zagVar = this.a;
        C2408i20 c2408i20 = zagVar.zaa;
        Uri uri = c2408i20.a;
        if (uri == null) {
            ImageManager imageManager2 = this.b;
            zagVar.zab(imageManager2.zad, imageManager2.zag, true);
            return;
        }
        Long l = (Long) this.b.zaj.get(uri);
        if (l != null) {
            if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                zag zagVar2 = this.a;
                ImageManager imageManager3 = this.b;
                zagVar2.zab(imageManager3.zad, imageManager3.zag, true);
                return;
            } else {
                ImageManager imageManager4 = this.b;
                imageManager4.zaj.remove(c2408i20.a);
            }
        }
        this.a.zaa(null, false, true, false);
        ImageManager imageManager5 = this.b;
        ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver) imageManager5.zai.get(c2408i20.a);
        if (imageReceiver2 == null) {
            ImageManager.ImageReceiver imageReceiver3 = this.b.new ImageReceiver(c2408i20.a);
            ImageManager imageManager6 = this.b;
            imageManager6.zai.put(c2408i20.a, imageReceiver3);
            imageReceiver2 = imageReceiver3;
        }
        imageReceiver2.b(this.a);
        zag zagVar3 = this.a;
        if (!(zagVar3 instanceof zaf)) {
            this.b.zah.put(zagVar3, imageReceiver2);
        }
        synchronized (ImageManager.zaa) {
            try {
                if (!ImageManager.zab.contains(c2408i20.a)) {
                    ImageManager.zab.add(c2408i20.a);
                    imageReceiver2.d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
