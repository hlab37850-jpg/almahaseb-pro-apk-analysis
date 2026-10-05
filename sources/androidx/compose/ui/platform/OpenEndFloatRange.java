package androidx.compose.ui.platform;

/* JADX INFO: loaded from: classes.dex */
final class OpenEndFloatRange implements OpenEndRange<Float> {
    private final float _endExclusive;
    private final float _start;

    public OpenEndFloatRange(float f, float f2) {
        this._start = f;
        this._endExclusive = f2;
    }

    private final boolean lessThanOrEquals(float f, float f2) {
        return f <= f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.platform.OpenEndRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).floatValue());
    }

    public boolean equals(Object obj) {
        if (obj instanceof OpenEndFloatRange) {
            if (!isEmpty() || !((OpenEndFloatRange) obj).isEmpty()) {
                OpenEndFloatRange openEndFloatRange = (OpenEndFloatRange) obj;
                if (this._start != openEndFloatRange._start || this._endExclusive != openEndFloatRange._endExclusive) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.floatToIntBits(this._start) * 31) + Float.floatToIntBits(this._endExclusive);
    }

    @Override // androidx.compose.ui.platform.OpenEndRange
    public boolean isEmpty() {
        return this._start >= this._endExclusive;
    }

    public String toString() {
        return this._start + "..<" + this._endExclusive;
    }

    public boolean contains(float f) {
        return f >= this._start && f < this._endExclusive;
    }

    @Override // androidx.compose.ui.platform.OpenEndRange
    public Float getEndExclusive() {
        return Float.valueOf(this._endExclusive);
    }

    @Override // androidx.compose.ui.platform.OpenEndRange
    public Float getStart() {
        return Float.valueOf(this._start);
    }
}
