package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class VV {
    static {
        String str = TypedValues.PositionType.NAME;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x000b  */
    public static int a(String str) {
        str.hashCode();
        switch (str) {
            case "transitionEasing":
                return TypedValues.PositionType.TYPE_TRANSITION_EASING;
            case "percentWidth":
                return 503;
            case "percentHeight":
                return TypedValues.PositionType.TYPE_PERCENT_HEIGHT;
            case "drawPath":
                return 502;
            case "sizePercent":
                return 505;
            case "percentX":
                return TypedValues.PositionType.TYPE_PERCENT_X;
            case "percentY":
                return TypedValues.PositionType.TYPE_PERCENT_Y;
            default:
                return -1;
        }
    }

    public static int b(int i) {
        if (i == 100) {
            return 2;
        }
        if (i == 101) {
            return 8;
        }
        switch (i) {
            case TypedValues.PositionType.TYPE_TRANSITION_EASING /* 501 */:
            case 502:
                return 8;
            case 503:
            case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
            case 505:
            case TypedValues.PositionType.TYPE_PERCENT_X /* 506 */:
            case TypedValues.PositionType.TYPE_PERCENT_Y /* 507 */:
                return 4;
            case TypedValues.PositionType.TYPE_CURVE_FIT /* 508 */:
                return 2;
            default:
                return -1;
        }
    }
}
