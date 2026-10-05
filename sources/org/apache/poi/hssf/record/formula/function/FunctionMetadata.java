package org.apache.poi.hssf.record.formula.function;

/* JADX INFO: loaded from: classes4.dex */
public final class FunctionMetadata {
    private static final short FUNCTION_MAX_PARAMS = 30;
    private final int _index;
    private final int _maxParams;
    private final int _minParams;
    private final String _name;
    private final byte[] _parameterClassCodes;
    private final byte _returnClassCode;

    public FunctionMetadata(int i, String str, int i2, int i3, byte b, byte[] bArr) {
        this._index = i;
        this._name = str;
        this._minParams = i2;
        this._maxParams = i3;
        this._returnClassCode = b;
        this._parameterClassCodes = bArr;
    }

    public int getIndex() {
        return this._index;
    }

    public int getMaxParams() {
        return this._maxParams;
    }

    public int getMinParams() {
        return this._minParams;
    }

    public String getName() {
        return this._name;
    }

    public byte[] getParameterClassCodes() {
        return (byte[]) this._parameterClassCodes.clone();
    }

    public byte getReturnClassCode() {
        return this._returnClassCode;
    }

    public boolean hasFixedArgsLength() {
        return this._minParams == this._maxParams;
    }

    public boolean hasUnlimitedVarags() {
        return 30 == this._maxParams;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(FunctionMetadata.class.getName());
        stringBuffer.append(" [");
        stringBuffer.append(this._index);
        stringBuffer.append(" ");
        stringBuffer.append(this._name);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
