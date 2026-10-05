package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.OffsetKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC4492zt;
import defpackage.C3150jW;

/* JADX INFO: loaded from: classes.dex */
public final class DecodeHelper {
    private final Parcel parcel;

    public DecodeHelper(String str) {
        AbstractC4492zt.h(str, TypedValues.Custom.S_STRING);
        Parcel parcelObtain = Parcel.obtain();
        AbstractC4492zt.g(parcelObtain, "obtain()");
        this.parcel = parcelObtain;
        byte[] bArrDecode = Base64.decode(str, 0);
        parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
        parcelObtain.setDataPosition(0);
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }

    /* JADX INFO: renamed from: decodeBaselineShift-y9eOQZs, reason: not valid java name */
    private final float m4475decodeBaselineShifty9eOQZs() {
        return BaselineShift.m4960constructorimpl(decodeFloat());
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    private final Shadow decodeShadow() {
        return new Shadow(m4477decodeColor0d7_KjU(), OffsetKt.Offset(decodeFloat(), decodeFloat()), decodeFloat(), null);
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final TextDecoration decodeTextDecoration() {
        int iDecodeInt = decodeInt();
        TextDecoration.Companion companion = TextDecoration.Companion;
        boolean z = (companion.getLineThrough().getMask() & iDecodeInt) != 0;
        boolean z2 = (iDecodeInt & companion.getUnderline().getMask()) != 0;
        if (z && z2) {
            return companion.combine(AbstractC1886cc.p(companion.getLineThrough(), companion.getUnderline()));
        }
        if (z) {
            return companion.getLineThrough();
        }
        return z2 ? companion.getUnderline() : companion.getNone();
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(decodeFloat(), decodeFloat());
    }

    /* JADX INFO: renamed from: decodeULong-s-VKNKU, reason: not valid java name */
    private final long m4476decodeULongsVKNKU() {
        return C3150jW.b(this.parcel.readLong());
    }

    /* JADX INFO: renamed from: decodeColor-0d7_KjU, reason: not valid java name */
    public final long m4477decodeColor0d7_KjU() {
        return Color.m3028constructorimpl(m4476decodeULongsVKNKU());
    }

    /* JADX INFO: renamed from: decodeFontStyle-_-LCdwA, reason: not valid java name */
    public final int m4478decodeFontStyle_LCdwA() {
        byte bDecodeByte = decodeByte();
        if (bDecodeByte == 0) {
            return FontStyle.Companion.m4806getNormal_LCdwA();
        }
        return bDecodeByte == 1 ? FontStyle.Companion.m4805getItalic_LCdwA() : FontStyle.Companion.m4806getNormal_LCdwA();
    }

    /* JADX INFO: renamed from: decodeFontSynthesis-GVVA2EU, reason: not valid java name */
    public final int m4479decodeFontSynthesisGVVA2EU() {
        byte bDecodeByte = decodeByte();
        if (bDecodeByte == 0) {
            return FontSynthesis.Companion.m4817getNoneGVVA2EU();
        }
        if (bDecodeByte == 1) {
            return FontSynthesis.Companion.m4816getAllGVVA2EU();
        }
        if (bDecodeByte == 3) {
            return FontSynthesis.Companion.m4818getStyleGVVA2EU();
        }
        return bDecodeByte == 2 ? FontSynthesis.Companion.m4819getWeightGVVA2EU() : FontSynthesis.Companion.m4817getNoneGVVA2EU();
    }

    public final FontWeight decodeFontWeight() {
        return new FontWeight(decodeInt());
    }

    public final SpanStyle decodeSpanStyle() {
        MutableSpanStyle mutableSpanStyle;
        MutableSpanStyle mutableSpanStyle2 = mutableSpanStyle;
        MutableSpanStyle mutableSpanStyle3 = new MutableSpanStyle(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 16383, null);
        while (this.parcel.dataAvail() > 1) {
            byte bDecodeByte = decodeByte();
            if (bDecodeByte != 1) {
                mutableSpanStyle = mutableSpanStyle2;
                if (bDecodeByte == 2) {
                    if (dataAvailable() < 5) {
                        return mutableSpanStyle.toSpanStyle();
                    }
                    mutableSpanStyle.m4510setFontSizeR2X_6o(m4480decodeTextUnitXSAIIZE());
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (bDecodeByte == 3) {
                    if (dataAvailable() < 4) {
                        return mutableSpanStyle.toSpanStyle();
                    }
                    mutableSpanStyle.setFontWeight(decodeFontWeight());
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (bDecodeByte == 4) {
                    if (dataAvailable() < 1) {
                        return mutableSpanStyle.toSpanStyle();
                    }
                    mutableSpanStyle.m4511setFontStylemLjRB2g(FontStyle.m4798boximpl(m4478decodeFontStyle_LCdwA()));
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (bDecodeByte != 5) {
                    if (bDecodeByte == 6) {
                        mutableSpanStyle.setFontFeatureSettings(decodeString());
                    } else if (bDecodeByte == 7) {
                        if (dataAvailable() < 5) {
                            return mutableSpanStyle.toSpanStyle();
                        }
                        mutableSpanStyle.m4513setLetterSpacingR2X_6o(m4480decodeTextUnitXSAIIZE());
                    } else if (bDecodeByte == 8) {
                        if (dataAvailable() < 4) {
                            return mutableSpanStyle.toSpanStyle();
                        }
                        mutableSpanStyle.m4508setBaselineShift_isdbwI(BaselineShift.m4959boximpl(m4475decodeBaselineShifty9eOQZs()));
                    } else if (bDecodeByte == 9) {
                        if (dataAvailable() < 8) {
                            return mutableSpanStyle.toSpanStyle();
                        }
                        mutableSpanStyle.setTextGeometricTransform(decodeTextGeometricTransform());
                    } else if (bDecodeByte == 10) {
                        if (dataAvailable() < 8) {
                            return mutableSpanStyle.toSpanStyle();
                        }
                        mutableSpanStyle.m4507setBackground8_81llA(m4477decodeColor0d7_KjU());
                    } else if (bDecodeByte == 11) {
                        if (dataAvailable() < 4) {
                            return mutableSpanStyle.toSpanStyle();
                        }
                        mutableSpanStyle.setTextDecoration(decodeTextDecoration());
                    } else if (bDecodeByte == 12) {
                        if (dataAvailable() < 20) {
                            return mutableSpanStyle.toSpanStyle();
                        }
                        mutableSpanStyle.setShadow(decodeShadow());
                    }
                    mutableSpanStyle2 = mutableSpanStyle;
                } else {
                    if (dataAvailable() < 1) {
                        return mutableSpanStyle.toSpanStyle();
                    }
                    mutableSpanStyle.m4512setFontSynthesistDdu0R4(FontSynthesis.m4807boximpl(m4479decodeFontSynthesisGVVA2EU()));
                    mutableSpanStyle2 = mutableSpanStyle;
                }
            } else {
                if (dataAvailable() < 8) {
                    break;
                }
                mutableSpanStyle2.m4509setColor8_81llA(m4477decodeColor0d7_KjU());
            }
        }
        mutableSpanStyle = mutableSpanStyle2;
        return mutableSpanStyle.toSpanStyle();
    }

    /* JADX INFO: renamed from: decodeTextUnit-XSAIIZE, reason: not valid java name */
    public final long m4480decodeTextUnitXSAIIZE() {
        long jM5373getEmUIouoOA;
        byte bDecodeByte = decodeByte();
        if (bDecodeByte == 1) {
            jM5373getEmUIouoOA = TextUnitType.Companion.m5374getSpUIouoOA();
        } else {
            jM5373getEmUIouoOA = bDecodeByte == 2 ? TextUnitType.Companion.m5373getEmUIouoOA() : TextUnitType.Companion.m5375getUnspecifiedUIouoOA();
        }
        return TextUnitType.m5369equalsimpl0(jM5373getEmUIouoOA, TextUnitType.Companion.m5375getUnspecifiedUIouoOA()) ? TextUnit.Companion.m5352getUnspecifiedXSAIIZE() : TextUnitKt.m5353TextUnitanM5pPY(decodeFloat(), jM5373getEmUIouoOA);
    }
}
