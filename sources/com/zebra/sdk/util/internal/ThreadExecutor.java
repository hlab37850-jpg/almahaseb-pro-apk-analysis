package com.zebra.sdk.util.internal;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadExecutor {
    private ThreadExecutor() {
    }

    public static void execute(Thread[] threadArr, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            if (i2 >= threadArr.length && arrayList.size() <= 0) {
                return;
            }
            if (arrayList.size() < i && i2 < threadArr.length) {
                Thread thread = threadArr[i2];
                i2++;
                arrayList.add(thread);
                thread.start();
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (!((Thread) arrayList.get(i3)).isAlive()) {
                    arrayList.remove(i3);
                }
            }
        }
    }
}
