package com.itextpdf.tool.xml.css;

import com.itextpdf.text.html.WebColors;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.apply.MarginMemory;
import com.itextpdf.tool.xml.exceptions.NoDataException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class CssUtils {
    private static final String BORDER2 = "border-";
    private static final String COLOR = "-color";
    public static final int DEFAULT_FONT_SIZE_PT = 12;
    private static final String STYLE = "-style";
    private static final String WIDTH = "-width";
    private static final String _0_BOTTOM_1 = "{0}bottom{1}";
    private static final String _0_LEFT_1 = "{0}left{1}";
    private static final String _0_RIGHT_1 = "{0}right{1}";
    private static final String _0_TOP_1 = "{0}top{1}";
    private static CssUtils instance = new CssUtils();
    private static final Set<String> borderwidth = new HashSet(Arrays.asList(CSS.Value.THIN, CSS.Value.MEDIUM, CSS.Value.THICK));
    private static final Set<String> borderstyle = new HashSet(Arrays.asList("none", "hidden", CSS.Value.DOTTED, CSS.Value.DASHED, CSS.Value.SOLID, CSS.Value.DOUBLE, CSS.Value.GROOVE, CSS.Value.RIDGE, CSS.Value.INSET, CSS.Value.OUTSET));
    private static final Set<String> backgroundPositions = new HashSet(Arrays.asList("left", "center", "bottom", "top", "right"));

    private CssUtils() {
    }

    public static CssUtils getInstance() {
        return instance;
    }

    public float calculateMarginTop(String str, float f, MarginMemory marginMemory) {
        return calculateMarginTop(parseValueToPt(str, f), marginMemory);
    }

    public float checkMetricStyle(Tag tag, String str) {
        Float fCheckMetricStyle = checkMetricStyle(tag.getCSS(), str);
        if (fCheckMetricStyle != null) {
            return fCheckMetricStyle.floatValue();
        }
        return 0.0f;
    }

    public int determinePositionBetweenValueAndUnit(String str) {
        if (str == null) {
            return 0;
        }
        boolean z = true;
        int i = 0;
        while (z && i < str.length()) {
            switch (str.charAt(i)) {
                case '+':
                case '-':
                case '.':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i++;
                    break;
                case ',':
                case '/':
                default:
                    z = false;
                    break;
            }
        }
        return i;
    }

    public String extractUrl(String str) {
        if (!str.startsWith("url")) {
            return str;
        }
        String strTrim = str.substring(3).trim().replace("(", "").replace(")", "").trim();
        if (strTrim.startsWith("'") && strTrim.endsWith("'")) {
            return strTrim.substring(strTrim.indexOf("'") + 1, strTrim.lastIndexOf("'"));
        }
        return (strTrim.startsWith("\"") && strTrim.endsWith("\"")) ? strTrim.substring(strTrim.indexOf(34) + 1, strTrim.lastIndexOf(34)) : strTrim;
    }

    public float getLeftAndRightMargin(Tag tag, float f) {
        String str = tag.getCSS().get(CSS.Property.MARGIN_LEFT);
        float valueToPt = str != null ? 0.0f + parseValueToPt(str, f) : 0.0f;
        String str2 = tag.getCSS().get(CSS.Property.MARGIN_RIGHT);
        return str2 != null ? valueToPt + parseValueToPt(str2, f) : valueToPt;
    }

    public boolean isMetricValue(String str) {
        return str.contains(CSS.Value.PX) || str.contains(CSS.Value.IN) || str.contains(CSS.Value.CM) || str.contains(CSS.Value.MM) || str.contains(CSS.Value.PC) || str.contains(CSS.Value.PT);
    }

    public boolean isNumericValue(String str) {
        return str.matches("^-?\\d\\d*\\.\\d*$") || str.matches("^-?\\d\\d*$") || str.matches("^-?\\.\\d\\d*$");
    }

    public boolean isRelativeValue(String str) {
        return str.contains(CSS.Value.PERCENTAGE) || str.contains("em") || str.contains(CSS.Value.EX);
    }

    public Map<String, String> parseBorder(String str) {
        return parseBorder(str, null);
    }

    public Map<String, String> parseBoxValues(String str, String str2, String str3) {
        return parseBoxValues(str, str2, str3, null);
    }

    public float parsePxInCmMmPcToPt(String str, String str2) {
        float f;
        float f2;
        int iDeterminePositionBetweenValueAndUnit = determinePositionBetweenValueAndUnit(str);
        if (iDeterminePositionBetweenValueAndUnit == 0) {
            return 0.0f;
        }
        float f3 = Float.parseFloat(str.substring(0, iDeterminePositionBetweenValueAndUnit) + "f");
        String strSubstring = str.substring(iDeterminePositionBetweenValueAndUnit);
        if (!strSubstring.startsWith(CSS.Value.IN) && (!strSubstring.equals("") || !str2.equals(CSS.Value.IN))) {
            if (strSubstring.startsWith(CSS.Value.CM) || (strSubstring.equals("") && str2.equals(CSS.Value.CM))) {
                f = 2.54f;
            } else {
                if (!strSubstring.startsWith(CSS.Value.MM) && (!strSubstring.equals("") || !str2.equals(CSS.Value.MM))) {
                    if (strSubstring.startsWith(CSS.Value.PC) || (strSubstring.equals("") && str2.equals(CSS.Value.PC))) {
                        f2 = 12.0f;
                    } else {
                        if (!strSubstring.startsWith(CSS.Value.PX) && (!strSubstring.equals("") || !str2.equals(CSS.Value.PX))) {
                            return f3;
                        }
                        f2 = 0.75f;
                    }
                    return f3 * f2;
                }
                f = 25.4f;
            }
            f3 /= f;
        }
        return f3 * 72.0f;
    }

    public float parseRelativeValue(String str, float f) {
        float f2;
        float f3;
        int iDeterminePositionBetweenValueAndUnit = determinePositionBetweenValueAndUnit(str);
        if (iDeterminePositionBetweenValueAndUnit == 0) {
            return 0.0f;
        }
        float f4 = Float.parseFloat(str.substring(0, iDeterminePositionBetweenValueAndUnit) + "f");
        String strSubstring = str.substring(iDeterminePositionBetweenValueAndUnit);
        if (strSubstring.startsWith(CSS.Value.PERCENTAGE)) {
            f2 = f * f4;
            f3 = 100.0f;
        } else {
            if (strSubstring.startsWith("em")) {
                return f4 * f;
            }
            if (!strSubstring.contains(CSS.Value.EX)) {
                return f4;
            }
            f2 = f * f4;
            f3 = 2.0f;
        }
        return f2 / f3;
    }

    public float parseValueToPt(String str, float f) {
        if (isMetricValue(str) || isNumericValue(str)) {
            return parsePxInCmMmPcToPt(str);
        }
        if (isRelativeValue(str)) {
            return parseRelativeValue(str, f);
        }
        return 0.0f;
    }

    public Map<String, String> processBackground(String str) {
        HashMap map = new HashMap();
        for (String str2 : splitComplexCssStyle(str)) {
            if (str2.contains("url(")) {
                map.put(CSS.Property.BACKGROUND_IMAGE, str2);
            } else if (str2.equalsIgnoreCase(CSS.Value.REPEAT) || str2.equalsIgnoreCase(CSS.Value.NO_REPEAT) || str2.equalsIgnoreCase(CSS.Value.REPEAT_X) || str2.equalsIgnoreCase(CSS.Value.REPEAT_Y)) {
                map.put(CSS.Property.BACKGROUND_REPEAT, str2);
            } else if (str2.equalsIgnoreCase(CSS.Value.FIXED) || str2.equalsIgnoreCase(CSS.Value.SCROLL)) {
                map.put(CSS.Property.BACKGROUND_ATTACHMENT, str2);
            } else if (backgroundPositions.contains(str2)) {
                if (map.get(CSS.Property.BACKGROUND_POSITION) == null) {
                    map.put(CSS.Property.BACKGROUND_POSITION, str2);
                } else {
                    map.put(CSS.Property.BACKGROUND_POSITION, str2.concat(" " + ((String) map.get(CSS.Property.BACKGROUND_POSITION))));
                }
            } else if (isNumericValue(str2) || isMetricValue(str2) || isRelativeValue(str2)) {
                if (map.get(CSS.Property.BACKGROUND_POSITION) == null) {
                    map.put(CSS.Property.BACKGROUND_POSITION, str2);
                } else {
                    map.put(CSS.Property.BACKGROUND_POSITION, str2.concat(" " + ((String) map.get(CSS.Property.BACKGROUND_POSITION))));
                }
            } else if (str2.contains("rgb(") || str2.contains("rgba(") || str2.contains("#") || WebColors.NAMES.containsKey(str2.toLowerCase())) {
                map.put(CSS.Property.BACKGROUND_COLOR, str2);
            }
        }
        return map;
    }

    public Map<String, String> processFont(String str) {
        HashMap map = new HashMap();
        String[] strArrSplit = str.split("\\s");
        for (int i = 0; i < strArrSplit.length; i++) {
            String str2 = strArrSplit[i];
            if (str2.equalsIgnoreCase("italic") || str2.equalsIgnoreCase("oblique")) {
                map.put("font-style", str2);
            } else if (str2.equalsIgnoreCase("small-caps")) {
                map.put("font-variant", str2);
            } else if (str2.equalsIgnoreCase("bold")) {
                map.put("font-weight", str2);
            } else if (isMetricValue(str2) || isNumericValue(str2)) {
                if (str2.contains("/")) {
                    String[] strArrSplit2 = str2.split("/");
                    String str3 = strArrSplit2[0];
                    map.put("line-height", strArrSplit2[1]);
                    str2 = str3;
                }
                map.put("font-size", str2);
                if (i != strArrSplit.length - 1) {
                    map.put("font-family", strArrSplit[i + 1].replaceAll("\"", "").replaceAll("'", ""));
                }
            }
        }
        return map;
    }

    public Map<String, String> processListStyle(String str) {
        HashMap map = new HashMap();
        for (String str2 : splitComplexCssStyle(str)) {
            if (str2.equalsIgnoreCase(CSS.Value.DISC) || str2.equalsIgnoreCase(CSS.Value.SQUARE) || str2.equalsIgnoreCase(CSS.Value.CIRCLE) || str2.equalsIgnoreCase(CSS.Value.LOWER_ROMAN) || str2.equalsIgnoreCase(CSS.Value.UPPER_ROMAN) || str2.equalsIgnoreCase(CSS.Value.LOWER_GREEK) || str2.equalsIgnoreCase(CSS.Value.UPPER_GREEK) || str2.equalsIgnoreCase(CSS.Value.LOWER_ALPHA) || str2.equalsIgnoreCase(CSS.Value.UPPER_ALPHA) || str2.equalsIgnoreCase(CSS.Value.LOWER_LATIN) || str2.equalsIgnoreCase(CSS.Value.UPPER_LATIN)) {
                map.put(CSS.Property.LIST_STYLE_TYPE, str2);
            } else if (str2.equalsIgnoreCase(CSS.Value.INSIDE) || str2.equalsIgnoreCase(CSS.Value.OUTSIDE)) {
                map.put(CSS.Property.LIST_STYLE_POSITION, str2);
            } else if (str2.contains("url(")) {
                map.put(CSS.Property.LIST_STYLE_IMAGE, str2);
            }
        }
        return map;
    }

    public String[] splitComplexCssStyle(String str) {
        return str.replaceAll("\\s*,\\s*", ",").split("\\s");
    }

    public String stripDoubleSpacesAndTrim(String str) {
        char[] charArray = str.toCharArray();
        if (!str.contains("  ")) {
            return String.valueOf(charArray).trim();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c != ' ') {
                sb.append(c);
            } else {
                int i2 = i + 1;
                if (i2 < charArray.length && charArray[i2] != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString().trim();
    }

    public String stripDoubleSpacesTrimAndToLowerCase(String str) {
        return stripDoubleSpacesAndTrim(str).toLowerCase();
    }

    public String trimAndRemoveQuoutes(String str) {
        String strTrim = str.trim();
        return (((strTrim.startsWith("\"") || strTrim.startsWith("'")) && strTrim.endsWith("\"")) || strTrim.endsWith("'")) ? strTrim.substring(1, strTrim.length() - 1) : strTrim;
    }

    public float validateTextHeight(Map<String, String> map, float f) {
        if (map.get(CSS.Property.MIN_HEIGHT) == null || f >= new CssUtils().parsePxInCmMmPcToPt(map.get(CSS.Property.MIN_HEIGHT))) {
            return (map.get(CSS.Property.MAX_HEIGHT) == null || f <= new CssUtils().parsePxInCmMmPcToPt(map.get(CSS.Property.MAX_HEIGHT))) ? f : new CssUtils().parsePxInCmMmPcToPt(map.get(CSS.Property.MAX_HEIGHT));
        }
        return new CssUtils().parsePxInCmMmPcToPt(map.get(CSS.Property.MIN_HEIGHT));
    }

    public float calculateMarginTop(float f, MarginMemory marginMemory) {
        try {
            float fFloatValue = marginMemory.getLastMarginBottom().floatValue();
            if (f > fFloatValue) {
                return f - fFloatValue;
            }
            return 0.0f;
        } catch (NoDataException unused) {
            return f;
        }
    }

    public Map<String, String> parseBorder(String str, String str2) {
        HashMap map = new HashMap(0);
        String[] strArrSplitComplexCssStyle = splitComplexCssStyle(str);
        if (strArrSplitComplexCssStyle.length != 1) {
            for (String str3 : strArrSplitComplexCssStyle) {
                if (borderwidth.contains(str3) || isNumericValue(str3) || isMetricValue(str3)) {
                    map.putAll(parseBoxValues(str3, BORDER2, WIDTH, str2));
                } else if (borderstyle.contains(str3)) {
                    map.putAll(parseBoxValues(str3, BORDER2, STYLE, str2));
                } else if (str3.contains("rgb(") || str3.contains("#") || WebColors.NAMES.containsKey(str3.toLowerCase())) {
                    map.putAll(parseBoxValues(str3, BORDER2, COLOR, str2));
                }
            }
        } else if (borderwidth.contains(strArrSplitComplexCssStyle[0]) || isNumericValue(strArrSplitComplexCssStyle[0]) || isMetricValue(strArrSplitComplexCssStyle[0])) {
            map.putAll(parseBoxValues(strArrSplitComplexCssStyle[0], BORDER2, WIDTH, str2));
        } else {
            map.putAll(parseBoxValues(strArrSplitComplexCssStyle[0], BORDER2, STYLE, str2));
        }
        return map;
    }

    public Map<String, String> parseBoxValues(String str, String str2, String str3, String str4) {
        String[] strArrSplit = str.split(" ");
        int length = strArrSplit.length;
        LinkedHashMap linkedHashMap = new LinkedHashMap(4);
        if (length == 1) {
            String str5 = strArrSplit[0];
            if (str4 == null) {
                linkedHashMap.put(MessageFormat.format(_0_TOP_1, str2, str3), str5);
                linkedHashMap.put(MessageFormat.format(_0_BOTTOM_1, str2, str3), str5);
                linkedHashMap.put(MessageFormat.format(_0_RIGHT_1, str2, str3), str5);
                linkedHashMap.put(MessageFormat.format(_0_LEFT_1, str2, str3), str5);
            } else {
                linkedHashMap.put(MessageFormat.format(str4 + "{0}", str3), str5);
            }
        } else if (length == 2) {
            if (str4 == null) {
                linkedHashMap.put(MessageFormat.format(_0_TOP_1, str2, str3), strArrSplit[0]);
                linkedHashMap.put(MessageFormat.format(_0_BOTTOM_1, str2, str3), strArrSplit[0]);
                linkedHashMap.put(MessageFormat.format(_0_RIGHT_1, str2, str3), strArrSplit[1]);
                linkedHashMap.put(MessageFormat.format(_0_LEFT_1, str2, str3), strArrSplit[1]);
            } else {
                linkedHashMap.put(MessageFormat.format(str4 + "{0}", str3), strArrSplit[0]);
            }
        } else if (length == 3) {
            if (str4 == null) {
                linkedHashMap.put(MessageFormat.format(_0_TOP_1, str2, str3), strArrSplit[0]);
                linkedHashMap.put(MessageFormat.format(_0_BOTTOM_1, str2, str3), strArrSplit[2]);
                linkedHashMap.put(MessageFormat.format(_0_RIGHT_1, str2, str3), strArrSplit[1]);
                linkedHashMap.put(MessageFormat.format(_0_LEFT_1, str2, str3), strArrSplit[1]);
            } else {
                linkedHashMap.put(MessageFormat.format(str4 + "{0}", str3), strArrSplit[0]);
            }
        } else if (length == 4) {
            if (str4 == null) {
                linkedHashMap.put(MessageFormat.format(_0_TOP_1, str2, str3), strArrSplit[0]);
                linkedHashMap.put(MessageFormat.format(_0_BOTTOM_1, str2, str3), strArrSplit[2]);
                linkedHashMap.put(MessageFormat.format(_0_RIGHT_1, str2, str3), strArrSplit[1]);
                linkedHashMap.put(MessageFormat.format(_0_LEFT_1, str2, str3), strArrSplit[3]);
            } else {
                linkedHashMap.put(MessageFormat.format(str4 + "{0}", str3), strArrSplit[0]);
            }
        }
        return linkedHashMap;
    }

    public Float checkMetricStyle(Map<String, String> map, String str) {
        String str2 = map.get(str);
        if (str2 == null) {
            return null;
        }
        if (isMetricValue(str2) || isNumericValue(str2)) {
            return Float.valueOf(parsePxInCmMmPcToPt(str2));
        }
        return null;
    }

    public float parsePxInCmMmPcToPt(String str) {
        return parsePxInCmMmPcToPt(str, CSS.Value.PX);
    }
}
