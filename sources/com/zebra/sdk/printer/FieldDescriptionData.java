package com.zebra.sdk.printer;

/* JADX INFO: loaded from: classes3.dex */
public class FieldDescriptionData implements Comparable<FieldDescriptionData> {
    public final String fieldName;
    public final int fieldNumber;

    public FieldDescriptionData(int i, String str) {
        this.fieldNumber = i;
        this.fieldName = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldDescriptionData fieldDescriptionData) {
        return this.fieldNumber - fieldDescriptionData.fieldNumber;
    }
}
