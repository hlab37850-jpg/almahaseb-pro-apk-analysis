package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public final class LayoutIntrinsics {
    private BoringLayout.Metrics _boringMetrics;
    private float _maxIntrinsicWidth;
    private float _minIntrinsicWidth;
    private boolean boringMetricsIsInit;
    private final CharSequence charSequence;
    private final int textDirectionHeuristic;
    private final TextPaint textPaint;

    public LayoutIntrinsics(CharSequence charSequence, TextPaint textPaint, int i) {
        AbstractC4492zt.h(charSequence, "charSequence");
        AbstractC4492zt.h(textPaint, "textPaint");
        this.charSequence = charSequence;
        this.textPaint = textPaint;
        this.textDirectionHeuristic = i;
        this._maxIntrinsicWidth = Float.NaN;
        this._minIntrinsicWidth = Float.NaN;
    }

    public final BoringLayout.Metrics getBoringMetrics() {
        if (!this.boringMetricsIsInit) {
            this._boringMetrics = BoringLayoutFactory.INSTANCE.measure(this.charSequence, this.textPaint, TextLayoutKt.getTextDirectionHeuristic(this.textDirectionHeuristic));
            this.boringMetricsIsInit = true;
        }
        return this._boringMetrics;
    }

    public final float getMaxIntrinsicWidth() {
        if (!Float.isNaN(this._maxIntrinsicWidth)) {
            return this._maxIntrinsicWidth;
        }
        BoringLayout.Metrics boringMetrics = getBoringMetrics();
        Float fValueOf = boringMetrics != null ? Float.valueOf(boringMetrics.width) : null;
        if (fValueOf == null) {
            CharSequence charSequence = this.charSequence;
            fValueOf = Float.valueOf((float) Math.ceil(Layout.getDesiredWidth(charSequence, 0, charSequence.length(), this.textPaint)));
        }
        if (LayoutIntrinsicsKt.shouldIncreaseMaxIntrinsic(fValueOf.floatValue(), this.charSequence, this.textPaint)) {
            fValueOf = Float.valueOf(fValueOf.floatValue() + 0.5f);
        }
        float fFloatValue = fValueOf.floatValue();
        this._maxIntrinsicWidth = fFloatValue;
        return fFloatValue;
    }

    public final float getMinIntrinsicWidth() {
        if (!Float.isNaN(this._minIntrinsicWidth)) {
            return this._minIntrinsicWidth;
        }
        float fMinIntrinsicWidth = LayoutIntrinsicsKt.minIntrinsicWidth(this.charSequence, this.textPaint);
        this._minIntrinsicWidth = fMinIntrinsicWidth;
        return fMinIntrinsicWidth;
    }
}
