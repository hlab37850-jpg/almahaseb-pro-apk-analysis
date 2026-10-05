package org.apache.poi.ddf;

import com.google.common.primitives.Shorts;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EscherProperty {
    private short _id;

    public EscherProperty(short s) {
        this._id = s;
    }

    public short getId() {
        return this._id;
    }

    public String getName() {
        return EscherProperties.getPropertyName(this._id);
    }

    public short getPropertyNumber() {
        return (short) (this._id & 16383);
    }

    public int getPropertySize() {
        return 6;
    }

    public boolean isBlipId() {
        return (this._id & Shorts.MAX_POWER_OF_TWO) != 0;
    }

    public boolean isComplex() {
        return (this._id & Short.MIN_VALUE) != 0;
    }

    public abstract int serializeComplexPart(byte[] bArr, int i);

    public abstract int serializeSimplePart(byte[] bArr, int i);

    public EscherProperty(short s, boolean z, boolean z2) {
        this._id = (short) (s + (z ? Short.MIN_VALUE : (short) 0) + (z2 ? 16384 : 0));
    }
}
