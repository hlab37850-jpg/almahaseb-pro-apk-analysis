package org.apache.poi.ddf;

/* JADX INFO: loaded from: classes2.dex */
public class EscherBoolProperty extends EscherSimpleProperty {
    public EscherBoolProperty(short s, int i) {
        super(s, i);
    }

    public boolean isFalse() {
        return this.propertyValue == 0;
    }

    public boolean isTrue() {
        return this.propertyValue != 0;
    }
}
