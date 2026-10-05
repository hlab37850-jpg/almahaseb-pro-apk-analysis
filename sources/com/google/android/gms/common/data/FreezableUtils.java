package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.itextpdf.text.ListItem;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class FreezableUtils {
    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull ArrayList<E> arrayList) {
        ListItem listItem = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            listItem.add(arrayList.get(i).freeze());
        }
        return listItem;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(@NonNull Iterable<E> iterable) {
        ListItem listItem = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            listItem.add(it.next().freeze());
        }
        return listItem;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull E[] eArr) {
        ListItem listItem = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            listItem.add(e.freeze());
        }
        return listItem;
    }
}
