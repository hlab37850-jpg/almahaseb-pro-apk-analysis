package com.itextpdf.text.html;

import androidx.compose.runtime.ComposerKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.tool.xml.css.CSS;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class WebColors extends HashMap<String, int[]> {
    public static final WebColors NAMES;
    private static final long serialVersionUID = 3542523100813372896L;

    static {
        WebColors webColors = new WebColors();
        NAMES = webColors;
        webColors.put("aliceblue", new int[]{240, 248, 255, 255});
        webColors.put("antiquewhite", new int[]{ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 235, 215, 255});
        webColors.put("aqua", new int[]{0, 255, 255, 255});
        webColors.put("aquamarine", new int[]{ShapeTypes.VERTICAL_SCROLL, 255, 212, 255});
        webColors.put("azure", new int[]{240, 255, 255, 255});
        webColors.put("beige", new int[]{245, 245, 220, 255});
        webColors.put("bisque", new int[]{255, 228, 196, 255});
        webColors.put("black", new int[]{0, 0, 0, 255});
        webColors.put("blanchedalmond", new int[]{255, 235, 205, 255});
        webColors.put("blue", new int[]{0, 0, 255, 255});
        webColors.put("blueviolet", new int[]{ShapeTypes.FLOW_CHART_MULTIDOCUMENT, 43, Jpeg.M_APP2, 255});
        webColors.put("brown", new int[]{ShapeTypes.ACTION_BUTTON_FORWARD_NEXT, 42, 42, 255});
        webColors.put("burlywood", new int[]{222, ShapeTypes.PLAQUE_TABS, ShapeTypes.FLOW_CHART_PREDEFINED_PROCESS, 255});
        webColors.put("cadetblue", new int[]{95, ShapeTypes.FLOW_CHART_DELAY, 160, 255});
        webColors.put("chartreuse", new int[]{ShapeTypes.VERTICAL_SCROLL, 255, 0, 255});
        webColors.put("chocolate", new int[]{210, 105, 30, 255});
        webColors.put("coral", new int[]{255, ShapeTypes.VERTICAL_SCROLL, 80, 255});
        webColors.put("cornflowerblue", new int[]{100, ShapeTypes.FLOW_CHART_SORT, Jpeg.M_APPD, 255});
        webColors.put("cornsilk", new int[]{255, 248, 220, 255});
        webColors.put("crimson", new int[]{220, 20, 60, 255});
        webColors.put("cyan", new int[]{0, 255, 255, 255});
        webColors.put("darkblue", new int[]{0, 0, ShapeTypes.FLOW_CHART_TERMINATOR, 255});
        webColors.put("darkcyan", new int[]{0, ShapeTypes.FLOW_CHART_TERMINATOR, ShapeTypes.FLOW_CHART_TERMINATOR, 255});
        webColors.put("darkgoldenrod", new int[]{ShapeTypes.PLAQUE_TABS, ShapeTypes.FLOW_CHART_INPUT_OUTPUT, 11, 255});
        webColors.put("darkgray", new int[]{ShapeTypes.ACTION_BUTTON_RETURN, ShapeTypes.ACTION_BUTTON_RETURN, ShapeTypes.ACTION_BUTTON_RETURN, 255});
        webColors.put("darkgreen", new int[]{0, 100, 0, 255});
        webColors.put("darkkhaki", new int[]{189, ShapeTypes.SQUARE_TABS, 107, 255});
        webColors.put("darkmagenta", new int[]{ShapeTypes.FLOW_CHART_TERMINATOR, 0, ShapeTypes.FLOW_CHART_TERMINATOR, 255});
        webColors.put("darkolivegreen", new int[]{85, 107, 47, 255});
        webColors.put("darkorange", new int[]{255, ShapeTypes.FLOW_CHART_PREPARATION, 0, 255});
        webColors.put("darkorchid", new int[]{153, 50, 204, 255});
        webColors.put("darkred", new int[]{ShapeTypes.FLOW_CHART_TERMINATOR, 0, 0, 255});
        webColors.put("darksalmon", new int[]{UnknownRecord.BITMAP_00E9, 150, 122, 255});
        webColors.put("darkseagreen", new int[]{ShapeTypes.FLOW_CHART_CONNECTOR, 188, ShapeTypes.FLOW_CHART_CONNECTOR, 255});
        webColors.put("darkslateblue", new int[]{72, 61, ShapeTypes.FLOW_CHART_TERMINATOR, 255});
        webColors.put("darkslategray", new int[]{47, 79, 79, 255});
        webColors.put("darkturquoise", new int[]{0, ComposerKt.referenceKey, 209, 255});
        webColors.put("darkviolet", new int[]{148, 0, 211, 255});
        webColors.put("deeppink", new int[]{255, 20, ShapeTypes.FLOW_CHART_OR, 255});
        webColors.put("deepskyblue", new int[]{0, 191, 255, 255});
        webColors.put("dimgray", new int[]{105, 105, 105, 255});
        webColors.put("dodgerblue", new int[]{30, 144, 255, 255});
        webColors.put("firebrick", new int[]{ShapeTypes.MATH_MULTIPLY, 34, 34, 255});
        webColors.put("floralwhite", new int[]{255, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 240, 255});
        webColors.put("forestgreen", new int[]{34, ShapeTypes.FLOW_CHART_TERMINATOR, 34, 255});
        webColors.put("fuchsia", new int[]{255, 0, 255, 255});
        webColors.put("gainsboro", new int[]{220, 220, 220, 255});
        webColors.put("ghostwhite", new int[]{248, 248, 255, 255});
        webColors.put("gold", new int[]{255, 215, 0, 255});
        webColors.put("goldenrod", new int[]{218, ShapeTypes.ACTION_BUTTON_FORWARD_NEXT, 32, 255});
        webColors.put("gray", new int[]{128, 128, 128, 255});
        webColors.put("green", new int[]{0, 128, 0, 255});
        webColors.put("greenyellow", new int[]{ShapeTypes.GEAR_6, 255, 47, 255});
        webColors.put("honeydew", new int[]{240, 255, 240, 255});
        webColors.put("hotpink", new int[]{255, 105, ShapeTypes.MATH_EQUAL, 255});
        webColors.put("indianred", new int[]{205, 92, 92, 255});
        webColors.put("indigo", new int[]{75, 0, ShapeTypes.DOUBLE_WAVE, 255});
        webColors.put("ivory", new int[]{255, 255, 240, 255});
        webColors.put("khaki", new int[]{240, 230, ShapeTypes.FLOW_CHART_PREPARATION, 255});
        webColors.put("lavender", new int[]{230, 230, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 255});
        webColors.put("lavenderblush", new int[]{255, 240, 245, 255});
        webColors.put("lawngreen", new int[]{124, 252, 0, 255});
        webColors.put("lemonchiffon", new int[]{255, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 205, 255});
        webColors.put("lightblue", new int[]{ShapeTypes.GEAR_6, 216, 230, 255});
        webColors.put("lightcoral", new int[]{240, 128, 128, 255});
        webColors.put("lightcyan", new int[]{224, 255, 255, 255});
        webColors.put("lightgoldenrodyellow", new int[]{ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 210, 255});
        webColors.put("lightgreen", new int[]{144, Jpeg.M_APPE, 144, 255});
        webColors.put("lightgrey", new int[]{211, 211, 211, 255});
        webColors.put("lightpink", new int[]{255, ShapeTypes.CORNER_TABS, 193, 255});
        webColors.put("lightsalmon", new int[]{255, 160, 122, 255});
        webColors.put("lightseagreen", new int[]{32, ShapeTypes.MATH_MULTIPLY, ShapeTypes.ACTION_BUTTON_DOCUMENT, 255});
        webColors.put("lightskyblue", new int[]{ShapeTypes.FLOW_CHART_PREDEFINED_PROCESS, ComposerKt.referenceKey, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 255});
        webColors.put("lightslategray", new int[]{119, ShapeTypes.FLOW_CHART_INTERNAL_STORAGE, 153, 255});
        webColors.put("lightsteelblue", new int[]{ShapeTypes.MATH_PLUS, 196, 222, 255});
        webColors.put("lightyellow", new int[]{255, 255, 224, 255});
        webColors.put("lime", new int[]{0, 255, 0, 255});
        webColors.put("limegreen", new int[]{50, 205, 50, 255});
        webColors.put("linen", new int[]{ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 240, 230, 255});
        webColors.put("magenta", new int[]{255, 0, 255, 255});
        webColors.put("maroon", new int[]{128, 0, 0, 255});
        webColors.put("mediumaquamarine", new int[]{102, 205, ShapeTypes.ACTION_BUTTON_DOCUMENT, 255});
        webColors.put("mediumblue", new int[]{0, 0, 205, 255});
        webColors.put("mediumorchid", new int[]{ShapeTypes.CHART_STAR, 85, 211, 255});
        webColors.put("mediumpurple", new int[]{ShapeTypes.FLOW_CHART_OR, 112, 219, 255});
        webColors.put("mediumseagreen", new int[]{60, ShapeTypes.MATH_DIVIDE, 113, 255});
        webColors.put("mediumslateblue", new int[]{123, 104, Jpeg.M_APPE, 255});
        webColors.put("mediumspringgreen", new int[]{0, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, ShapeTypes.FLOW_CHART_MAGNETIC_TAPE, 255});
        webColors.put("mediumturquoise", new int[]{72, 209, 204, 255});
        webColors.put("mediumvioletred", new int[]{199, 21, ShapeTypes.FLOW_CHART_DECISION, 255});
        webColors.put("midnightblue", new int[]{25, 25, 112, 255});
        webColors.put("mintcream", new int[]{245, 255, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 255});
        webColors.put("mistyrose", new int[]{255, 228, 225, 255});
        webColors.put("moccasin", new int[]{255, 228, ShapeTypes.MATH_NOT_EQUAL, 255});
        webColors.put("navajowhite", new int[]{255, 222, ShapeTypes.GEAR_6, 255});
        webColors.put("navy", new int[]{0, 0, 128, 255});
        webColors.put("oldlace", new int[]{253, 245, 230, 255});
        webColors.put("olive", new int[]{128, 128, 0, 255});
        webColors.put("olivedrab", new int[]{107, ShapeTypes.FLOW_CHART_MANUAL_OPERATION, 35, 255});
        webColors.put("orange", new int[]{255, ShapeTypes.ACTION_BUTTON_FORWARD_NEXT, 0, 255});
        webColors.put("orangered", new int[]{255, 69, 0, 255});
        webColors.put("orchid", new int[]{218, 112, 214, 255});
        webColors.put("palegoldenrod", new int[]{Jpeg.M_APPE, 232, ShapeTypes.ACTION_BUTTON_DOCUMENT, 255});
        webColors.put("palegreen", new int[]{ShapeTypes.FLOW_CHART_OFFLINE_STORAGE, 251, ShapeTypes.FLOW_CHART_OFFLINE_STORAGE, 255});
        webColors.put("paleturquoise", new int[]{ShapeTypes.FUNNEL, Jpeg.M_APPE, Jpeg.M_APPE, 255});
        webColors.put("palevioletred", new int[]{219, 112, ShapeTypes.FLOW_CHART_OR, 255});
        webColors.put("papayawhip", new int[]{255, UnknownRecord.PHONETICPR_00EF, 213, 255});
        webColors.put("peachpuff", new int[]{255, 218, ShapeTypes.CHART_X, 255});
        webColors.put("peru", new int[]{205, ShapeTypes.FLOW_CHART_DECISION, 63, 255});
        webColors.put("pink", new int[]{255, 192, 203, 255});
        webColors.put("plum", new int[]{221, 160, 221, 255});
        webColors.put("powderblue", new int[]{ShapeTypes.MATH_PLUS, 224, 230, 255});
        webColors.put("purple", new int[]{128, 0, 128, 255});
        webColors.put("red", new int[]{255, 0, 0, 255});
        webColors.put("rosybrown", new int[]{188, ShapeTypes.FLOW_CHART_CONNECTOR, ShapeTypes.FLOW_CHART_CONNECTOR, 255});
        webColors.put("royalblue", new int[]{65, 105, 225, 255});
        webColors.put("saddlebrown", new int[]{ShapeTypes.FLOW_CHART_TERMINATOR, 69, 19, 255});
        webColors.put("salmon", new int[]{ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 128, 114, 255});
        webColors.put("sandybrown", new int[]{244, 164, 96, 255});
        webColors.put("seagreen", new int[]{46, ShapeTypes.FLOW_CHART_TERMINATOR, 87, 255});
        webColors.put("seashell", new int[]{255, 245, Jpeg.M_APPE, 255});
        webColors.put("sienna", new int[]{160, 82, 45, 255});
        webColors.put("silver", new int[]{192, 192, 192, 255});
        webColors.put("skyblue", new int[]{ShapeTypes.FLOW_CHART_PREDEFINED_PROCESS, ComposerKt.referenceKey, 235, 255});
        webColors.put("slateblue", new int[]{106, 90, 205, 255});
        webColors.put("slategray", new int[]{112, 128, 144, 255});
        webColors.put("snow", new int[]{255, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 255});
        webColors.put("springgreen", new int[]{0, 255, ShapeTypes.VERTICAL_SCROLL, 255});
        webColors.put("steelblue", new int[]{70, ShapeTypes.DOUBLE_WAVE, ShapeTypes.MATH_EQUAL, 255});
        webColors.put("tan", new int[]{210, ShapeTypes.MATH_EQUAL, ShapeTypes.FLOW_CHART_PREPARATION, 255});
        webColors.put("teal", new int[]{0, 128, 128, 255});
        webColors.put("thistle", new int[]{216, 191, 216, 255});
        webColors.put("tomato", new int[]{255, 99, 71, 255});
        webColors.put("transparent", new int[]{255, 255, 255, 0});
        webColors.put("turquoise", new int[]{64, 224, 208, 255});
        webColors.put("violet", new int[]{Jpeg.M_APPE, ShapeTypes.DOUBLE_WAVE, Jpeg.M_APPE, 255});
        webColors.put("wheat", new int[]{245, 222, ShapeTypes.MATH_DIVIDE, 255});
        webColors.put("white", new int[]{255, 255, 255, 255});
        webColors.put("whitesmoke", new int[]{245, 245, 245, 255});
        webColors.put("yellow", new int[]{255, 255, 0, 255});
        webColors.put("yellowgreen", new int[]{ShapeTypes.FLOW_CHART_MAGNETIC_TAPE, 205, 50, 255});
    }

    private static int getRGBChannelValue(String str) {
        return str.endsWith(CSS.Value.PERCENTAGE) ? (Integer.parseInt(str.substring(0, str.length() - 1)) * 255) / 100 : Integer.parseInt(str);
    }

    public static BaseColor getRGBColor(String str) {
        int[] iArr = {0, 0, 0, 255};
        String lowerCase = str.toLowerCase();
        boolean zMissingHashColorFormat = missingHashColorFormat(lowerCase);
        if (lowerCase.startsWith("#") || zMissingHashColorFormat) {
            if (!zMissingHashColorFormat) {
                lowerCase = lowerCase.substring(1);
            }
            if (lowerCase.length() != 3) {
                if (lowerCase.length() != 6) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("unknown.color.format.must.be.rgb.or.rrggbb", new Object[0]));
                }
                iArr[0] = Integer.parseInt(lowerCase.substring(0, 2), 16);
                iArr[1] = Integer.parseInt(lowerCase.substring(2, 4), 16);
                iArr[2] = Integer.parseInt(lowerCase.substring(4), 16);
                return new BaseColor(iArr[0], iArr[1], iArr[2], iArr[3]);
            }
            String strSubstring = lowerCase.substring(0, 1);
            iArr[0] = Integer.parseInt(strSubstring + strSubstring, 16);
            String strSubstring2 = lowerCase.substring(1, 2);
            iArr[1] = Integer.parseInt(strSubstring2 + strSubstring2, 16);
            String strSubstring3 = lowerCase.substring(2);
            iArr[2] = Integer.parseInt(strSubstring3 + strSubstring3, 16);
            return new BaseColor(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        if (lowerCase.startsWith("rgb(")) {
            StringTokenizer stringTokenizer = new StringTokenizer(lowerCase, "rgb(), \t\r\n\f");
            for (int i = 0; i < 3; i++) {
                if (stringTokenizer.hasMoreElements()) {
                    int rGBChannelValue = getRGBChannelValue(stringTokenizer.nextToken());
                    iArr[i] = rGBChannelValue;
                    int iMax = Math.max(0, rGBChannelValue);
                    iArr[i] = iMax;
                    iArr[i] = Math.min(255, iMax);
                }
            }
            return new BaseColor(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        if (!lowerCase.startsWith("rgba(")) {
            WebColors webColors = NAMES;
            if (!webColors.containsKey(lowerCase)) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("color.not.found", lowerCase));
            }
            int[] iArr2 = webColors.get(lowerCase);
            return new BaseColor(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(lowerCase, "rgba(), \t\r\n\f");
        for (int i2 = 0; i2 < 3; i2++) {
            if (stringTokenizer2.hasMoreElements()) {
                int rGBChannelValue2 = getRGBChannelValue(stringTokenizer2.nextToken());
                iArr[i2] = rGBChannelValue2;
                int iMax2 = Math.max(0, rGBChannelValue2);
                iArr[i2] = iMax2;
                iArr[i2] = Math.min(255, iMax2);
            }
        }
        if (stringTokenizer2.hasMoreElements()) {
            iArr[3] = (int) (((double) (Float.parseFloat(stringTokenizer2.nextToken()) * 255.0f)) + 0.5d);
        }
        return new BaseColor(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    private static boolean missingHashColorFormat(String str) {
        int length = str.length();
        if (length != 3 && length != 6) {
            return false;
        }
        return str.matches("[0-9a-f]{" + length + "}");
    }
}
