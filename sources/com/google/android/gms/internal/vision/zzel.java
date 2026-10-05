package com.google.android.gms.internal.vision;

import defpackage.Ab0;
import defpackage.C4051ua0;
import defpackage.La0;
import defpackage.X90;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public final class zzel<K, V> extends zzek<K, V> {
    /* JADX WARN: Code duplicated, block: B:16:0x004a  */
    /* JADX WARN: Code duplicated, block: B:18:0x0051 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0053  */
    /* JADX WARN: Code duplicated, block: B:21:0x0060  */
    /* JADX WARN: Code duplicated, block: B:25:0x007e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0084 A[LOOP:3: B:22:0x006e->B:27:0x0084, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:32:0x009b  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a3 A[LOOP:1: B:17:0x004f->B:34:0x00a3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:67:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0088 A[EDGE_INSN: B:73:0x0088->B:28:0x0088 BREAK  A[LOOP:3: B:22:0x006e->B:27:0x0084], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x0074 A[SYNTHETIC] */
    public final zzem<K, V> zza() {
        Object[] array;
        int length;
        zzeb ab0;
        int iZza;
        Object[] objArr;
        int i;
        int i2;
        int i3;
        int i4;
        int length2;
        Object objZza;
        int iHashCode;
        int iA;
        int i5;
        Object obj;
        Set<Map.Entry<K, Collection<V>>> setEntrySet = this.zza.entrySet();
        if (setEntrySet.isEmpty()) {
            return C4051ua0.a;
        }
        zzei zzeiVar = new zzei(setEntrySet.size());
        Iterator<Map.Entry<K, Collection<V>>> it = setEntrySet.iterator();
        int size = 0;
        while (true) {
            int i6 = 1;
            if (!it.hasNext()) {
                zzeiVar.zzc = true;
                return new zzem<>(C1921b.a(zzeiVar.zzb, zzeiVar.zza), size, null);
            }
            Map.Entry<K, Collection<V>> next = it.next();
            K key = next.getKey();
            Collection<V> value = next.getValue();
            if (!(value instanceof zzej) || (value instanceof SortedSet)) {
                array = value.toArray();
                length = array.length;
                while (true) {
                    if (length != 0) {
                        ab0 = c.f;
                        break;
                    }
                    if (length != i6) {
                        ab0 = new Ab0(array[0]);
                        break;
                    }
                    iZza = zzej.zza(length);
                    objArr = new Object[iZza];
                    i = iZza - 1;
                    i3 = 0;
                    i4 = 0;
                    while (i2 < length) {
                        objZza = zzeq.zza(array[i2], i2);
                        iHashCode = objZza.hashCode();
                        iA = La0.a(iHashCode);
                        while (true) {
                            i5 = iA & i;
                            obj = objArr[i5];
                            if (obj == null) {
                                array[i3] = objZza;
                                objArr[i5] = objZza;
                                i4 += iHashCode;
                                i3++;
                                break;
                            }
                            if (!obj.equals(objZza)) {
                                break;
                            }
                            iA++;
                        }
                    }
                    Arrays.fill(array, i3, length, (Object) null);
                    if (i3 == 1) {
                        ab0 = new Ab0(array[0], i4);
                        break;
                    }
                    if (zzej.zza(i3) < iZza / 2) {
                        length2 = array.length;
                        if (i3 < (length2 >> 1) + (length2 >> 2)) {
                            array = Arrays.copyOf(array, i3);
                        }
                        ab0 = new c(array, i4, objArr, i, i3);
                        break;
                    }
                    length = i3;
                    i6 = 1;
                }
            } else {
                ab0 = (zzej) value;
                if (ab0.zzf()) {
                    array = value.toArray();
                    length = array.length;
                    while (true) {
                        if (length != 0) {
                            ab0 = c.f;
                            break;
                        }
                        if (length != i6) {
                            ab0 = new Ab0(array[0]);
                            break;
                        }
                        iZza = zzej.zza(length);
                        objArr = new Object[iZza];
                        i = iZza - 1;
                        i3 = 0;
                        i4 = 0;
                        for (i2 = 0; i2 < length; i2++) {
                            objZza = zzeq.zza(array[i2], i2);
                            iHashCode = objZza.hashCode();
                            iA = La0.a(iHashCode);
                            while (true) {
                                i5 = iA & i;
                                obj = objArr[i5];
                                if (obj == null) {
                                    array[i3] = objZza;
                                    objArr[i5] = objZza;
                                    i4 += iHashCode;
                                    i3++;
                                    break;
                                    break;
                                }
                                if (!obj.equals(objZza)) {
                                    break;
                                    break;
                                }
                                iA++;
                            }
                        }
                        Arrays.fill(array, i3, length, (Object) null);
                        if (i3 == 1) {
                            ab0 = new Ab0(array[0], i4);
                            break;
                        }
                        if (zzej.zza(i3) < iZza / 2) {
                            length2 = array.length;
                            if (i3 < (length2 >> 1) + (length2 >> 2)) {
                                array = Arrays.copyOf(array, i3);
                            }
                            ab0 = new c(array, i4, objArr, i, i3);
                            break;
                        }
                        length = i3;
                        i6 = 1;
                    }
                }
            }
            if (!ab0.isEmpty()) {
                int i7 = (zzeiVar.zzb + 1) << 1;
                Object[] objArr2 = zzeiVar.zza;
                if (i7 > objArr2.length) {
                    int length3 = objArr2.length;
                    if (i7 < 0) {
                        throw new AssertionError("cannot store more than MAX_VALUE elements");
                    }
                    int iHighestOneBit = length3 + (length3 >> 1) + 1;
                    if (iHighestOneBit < i7) {
                        iHighestOneBit = Integer.highestOneBit(i7 - 1) << 1;
                    }
                    if (iHighestOneBit < 0) {
                        iHighestOneBit = Integer.MAX_VALUE;
                    }
                    zzeiVar.zza = Arrays.copyOf(objArr2, iHighestOneBit);
                    zzeiVar.zzc = false;
                }
                X90.a(key, ab0);
                Object[] objArr3 = zzeiVar.zza;
                int i8 = zzeiVar.zzb;
                objArr3[i8 * 2] = key;
                objArr3[(i8 * 2) + 1] = ab0;
                zzeiVar.zzb = i8 + 1;
                size += ab0.size();
            }
        }
    }
}
