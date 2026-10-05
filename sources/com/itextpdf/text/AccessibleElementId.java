package com.itextpdf.text;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class AccessibleElementId implements Comparable<AccessibleElementId>, Serializable {
    private static int id_counter;
    private int id;

    public AccessibleElementId() {
        int i = id_counter + 1;
        id_counter = i;
        this.id = i;
    }

    public boolean equals(Object obj) {
        return (obj instanceof AccessibleElementId) && this.id == ((AccessibleElementId) obj).id;
    }

    public int hashCode() {
        return this.id;
    }

    public String toString() {
        return Integer.toString(this.id);
    }

    @Override // java.lang.Comparable
    public int compareTo(AccessibleElementId accessibleElementId) {
        int i = this.id;
        int i2 = accessibleElementId.id;
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }
}
