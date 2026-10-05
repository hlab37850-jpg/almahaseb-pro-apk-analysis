package com.itextpdf.text;

import com.itextpdf.text.pdf.draw.DrawInterface;

/* JADX INFO: loaded from: classes3.dex */
public class TabStop {
    protected Alignment alignment;
    protected char anchorChar;
    protected DrawInterface leader;
    protected float position;

    /* JADX INFO: renamed from: com.itextpdf.text.TabStop$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$TabStop$Alignment;

        static {
            int[] iArr = new int[Alignment.values().length];
            $SwitchMap$com$itextpdf$text$TabStop$Alignment = iArr;
            try {
                iArr[Alignment.RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$itextpdf$text$TabStop$Alignment[Alignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$itextpdf$text$TabStop$Alignment[Alignment.ANCHOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum Alignment {
        LEFT,
        RIGHT,
        CENTER,
        ANCHOR
    }

    public TabStop(float f) {
        this(f, Alignment.LEFT);
    }

    public static TabStop newInstance(float f, float f2) {
        float fRound = Math.round(f * 1000.0f) / 1000.0f;
        float fRound2 = Math.round(f2 * 1000.0f) / 1000.0f;
        return new TabStop((fRound + fRound2) - (fRound % fRound2));
    }

    public Alignment getAlignment() {
        return this.alignment;
    }

    public char getAnchorChar() {
        return this.anchorChar;
    }

    public DrawInterface getLeader() {
        return this.leader;
    }

    public float getPosition() {
        return this.position;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public void setAnchorChar(char c) {
        this.anchorChar = c;
    }

    public void setLeader(DrawInterface drawInterface) {
        this.leader = drawInterface;
    }

    public void setPosition(float f) {
        this.position = f;
    }

    public TabStop(float f, DrawInterface drawInterface) {
        this(f, drawInterface, Alignment.LEFT);
    }

    public float getPosition(float f, float f2, float f3) {
        float f4;
        float f5 = this.position;
        float f6 = f2 - f;
        int i = AnonymousClass1.$SwitchMap$com$itextpdf$text$TabStop$Alignment[this.alignment.ordinal()];
        if (i == 1) {
            float f7 = f + f6;
            f4 = this.position;
            if (f7 >= f4) {
                return f;
            }
        } else if (i == 2) {
            f6 /= 2.0f;
            float f8 = f + f6;
            f4 = this.position;
            if (f8 >= f4) {
                return f;
            }
        } else {
            if (i != 3) {
                return f5;
            }
            if (!Float.isNaN(f3)) {
                float f9 = this.position;
                return f3 < f9 ? f9 - (f3 - f) : f;
            }
            float f10 = f + f6;
            f4 = this.position;
            if (f10 >= f4) {
                return f;
            }
        }
        return f4 - f6;
    }

    public TabStop(float f, Alignment alignment) {
        this(f, (DrawInterface) null, alignment);
    }

    public TabStop(float f, Alignment alignment, char c) {
        this(f, null, alignment, c);
    }

    public TabStop(float f, DrawInterface drawInterface, Alignment alignment) {
        this(f, drawInterface, alignment, '.');
    }

    public TabStop(float f, DrawInterface drawInterface, Alignment alignment, char c) {
        Alignment alignment2 = Alignment.LEFT;
        this.position = f;
        this.leader = drawInterface;
        this.alignment = alignment;
        this.anchorChar = c;
    }

    public TabStop(TabStop tabStop) {
        this(tabStop.getPosition(), tabStop.getLeader(), tabStop.getAlignment(), tabStop.getAnchorChar());
    }
}
