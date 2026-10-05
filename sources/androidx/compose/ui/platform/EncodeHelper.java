package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class EncodeHelper {
    private Parcel parcel;

    public EncodeHelper() {
        Parcel parcelObtain = Parcel.obtain();
        AbstractC4492zt.g(parcelObtain, "obtain()");
        this.parcel = parcelObtain;
    }

    public final void encode(SpanStyle spanStyle) {
        AbstractC4492zt.h(spanStyle, "spanStyle");
        long jM4664getColor0d7_KjU = spanStyle.m4664getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m3033equalsimpl0(jM4664getColor0d7_KjU, companion.m3068getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m4492encode8_81llA(spanStyle.m4664getColor0d7_KjU());
        }
        long jM4665getFontSizeXSAIIZE = spanStyle.m4665getFontSizeXSAIIZE();
        TextUnit.Companion companion2 = TextUnit.Companion;
        if (!TextUnit.m5338equalsimpl0(jM4665getFontSizeXSAIIZE, companion2.m5352getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m4489encodeR2X_6o(spanStyle.m4665getFontSizeXSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle fontStyleM4666getFontStyle4Lr2A7w = spanStyle.m4666getFontStyle4Lr2A7w();
        if (fontStyleM4666getFontStyle4Lr2A7w != null) {
            int iM4804unboximpl = fontStyleM4666getFontStyle4Lr2A7w.m4804unboximpl();
            encode((byte) 4);
            m4494encodenzbMABs(iM4804unboximpl);
        }
        FontSynthesis fontSynthesisM4667getFontSynthesisZQGJjVo = spanStyle.m4667getFontSynthesisZQGJjVo();
        if (fontSynthesisM4667getFontSynthesisZQGJjVo != null) {
            int iM4815unboximpl = fontSynthesisM4667getFontSynthesisZQGJjVo.m4815unboximpl();
            encode((byte) 5);
            m4491encode6p3vJLY(iM4815unboximpl);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m5338equalsimpl0(spanStyle.m4668getLetterSpacingXSAIIZE(), companion2.m5352getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m4489encodeR2X_6o(spanStyle.m4668getLetterSpacingXSAIIZE());
        }
        BaselineShift baselineShiftM4663getBaselineShift5SSeXJ0 = spanStyle.m4663getBaselineShift5SSeXJ0();
        if (baselineShiftM4663getBaselineShift5SSeXJ0 != null) {
            float fM4965unboximpl = baselineShiftM4663getBaselineShift5SSeXJ0.m4965unboximpl();
            encode((byte) 8);
            m4490encode4Dl_Bck(fM4965unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m3033equalsimpl0(spanStyle.m4662getBackground0d7_KjU(), companion.m3068getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m4492encode8_81llA(spanStyle.m4662getBackground0d7_KjU());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode((byte) 11);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) 12);
            encode(shadow);
        }
    }

    /* JADX INFO: renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m4489encodeR2X_6o(long j) {
        long jM5340getTypeUIouoOA = TextUnit.m5340getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        byte b = 0;
        if (!TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5375getUnspecifiedUIouoOA())) {
            if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5374getSpUIouoOA())) {
                b = 1;
            } else if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5373getEmUIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (TextUnitType.m5369equalsimpl0(TextUnit.m5340getTypeUIouoOA(j), companion.m5375getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m5341getValueimpl(j));
    }

    /* JADX INFO: renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m4490encode4Dl_Bck(float f) {
        encode(f);
    }

    /* JADX INFO: renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m4491encode6p3vJLY(int i) {
        FontSynthesis.Companion companion = FontSynthesis.Companion;
        byte b = 0;
        if (!FontSynthesis.m4810equalsimpl0(i, companion.m4817getNoneGVVA2EU())) {
            if (FontSynthesis.m4810equalsimpl0(i, companion.m4816getAllGVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.m4810equalsimpl0(i, companion.m4819getWeightGVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.m4810equalsimpl0(i, companion.m4818getStyleGVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* JADX INFO: renamed from: encode-8_81llA, reason: not valid java name */
    public final void m4492encode8_81llA(long j) {
        m4493encodeVKZWuLQ(j);
    }

    /* JADX INFO: renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m4493encodeVKZWuLQ(long j) {
        this.parcel.writeLong(j);
    }

    /* JADX INFO: renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m4494encodenzbMABs(int i) {
        FontStyle.Companion companion = FontStyle.Companion;
        byte b = 0;
        if (!FontStyle.m4801equalsimpl0(i, companion.m4806getNormal_LCdwA()) && FontStyle.m4801equalsimpl0(i, companion.m4805getItalic_LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    public final String encodedString() {
        String strEncodeToString = Base64.encodeToString(this.parcel.marshall(), 0);
        AbstractC4492zt.g(strEncodeToString, "encodeToString(bytes, Base64.DEFAULT)");
        return strEncodeToString;
    }

    public final void reset() {
        this.parcel.recycle();
        Parcel parcelObtain = Parcel.obtain();
        AbstractC4492zt.g(parcelObtain, "obtain()");
        this.parcel = parcelObtain;
    }

    public final void encode(FontWeight fontWeight) {
        AbstractC4492zt.h(fontWeight, "fontWeight");
        encode(fontWeight.getWeight());
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        AbstractC4492zt.h(textGeometricTransform, "textGeometricTransform");
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        AbstractC4492zt.h(textDecoration, "textDecoration");
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        AbstractC4492zt.h(shadow, "shadow");
        m4492encode8_81llA(shadow.m3328getColor0d7_KjU());
        encode(Offset.m2798getXimpl(shadow.m3329getOffsetF1C5BW0()));
        encode(Offset.m2799getYimpl(shadow.m3329getOffsetF1C5BW0()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    public final void encode(String str) {
        AbstractC4492zt.h(str, TypedValues.Custom.S_STRING);
        this.parcel.writeString(str);
    }
}
