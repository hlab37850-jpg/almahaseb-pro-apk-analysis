package com.itextpdf.text.pdf.languages;

import com.itextpdf.text.pdf.BidiLine;
import com.itextpdf.text.pdf.BidiOrder;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ArabicLigaturizer implements LanguageProcessor {
    private static final char ALEF = 1575;
    private static final char ALEFHAMZA = 1571;
    private static final char ALEFHAMZABELOW = 1573;
    private static final char ALEFMADDA = 1570;
    private static final char ALEFMAKSURA = 1609;
    private static final char DAMMA = 1615;
    public static final int DIGITS_AN2EN = 64;
    public static final int DIGITS_EN2AN = 32;
    public static final int DIGITS_EN2AN_INIT_AL = 128;
    public static final int DIGITS_EN2AN_INIT_LR = 96;
    public static final int DIGITS_MASK = 224;
    private static final int DIGITS_RESERVED = 160;
    public static final int DIGIT_TYPE_AN = 0;
    public static final int DIGIT_TYPE_AN_EXTENDED = 256;
    public static final int DIGIT_TYPE_MASK = 256;
    private static final char FARSIYEH = 1740;
    private static final char FATHA = 1614;
    private static final char HAMZA = 1569;
    private static final char HAMZAABOVE = 1620;
    private static final char HAMZABELOW = 1621;
    private static final char KASRA = 1616;
    private static final char LAM = 1604;
    private static final char LAM_ALEF = 65275;
    private static final char LAM_ALEFHAMZA = 65271;
    private static final char LAM_ALEFHAMZABELOW = 65273;
    private static final char LAM_ALEFMADDA = 65269;
    private static final char MADDA = 1619;
    private static final char SHADDA = 1617;
    private static final char TATWEEL = 1600;
    private static final char WAW = 1608;
    private static final char WAWHAMZA = 1572;
    private static final char YEH = 1610;
    private static final char YEHHAMZA = 1574;
    private static final char ZWJ = 8205;
    public static final int ar_composedtashkeel = 4;
    public static final int ar_lig = 8;
    public static final int ar_nothing = 0;
    public static final int ar_novowel = 1;
    private static final char[][] chartable;
    private static final HashMap<Character, char[]> maptable = new HashMap<>();
    private static final HashMap<Character, Character> reverseLigatureMapTable = new HashMap<>();
    protected int options;
    protected int runDirection;

    public static class charstruct {
        char basechar;
        int lignum;
        char mark1;
        int numshapes = 1;
        char vowel;
    }

    static {
        char[][] cArr = {new char[]{HAMZA, 65152}, new char[]{ALEFMADDA, 65153, 65154}, new char[]{ALEFHAMZA, 65155, 65156}, new char[]{WAWHAMZA, 65157, 65158}, new char[]{ALEFHAMZABELOW, 65159, 65160}, new char[]{YEHHAMZA, 65161, 65162, 65163, 65164}, new char[]{ALEF, 65165, 65166}, new char[]{1576, 65167, 65168, 65169, 65170}, new char[]{1577, 65171, 65172}, new char[]{1578, 65173, 65174, 65175, 65176}, new char[]{1579, 65177, 65178, 65179, 65180}, new char[]{1580, 65181, 65182, 65183, 65184}, new char[]{1581, 65185, 65186, 65187, 65188}, new char[]{1582, 65189, 65190, 65191, 65192}, new char[]{1583, 65193, 65194}, new char[]{1584, 65195, 65196}, new char[]{1585, 65197, 65198}, new char[]{1586, 65199, 65200}, new char[]{1587, 65201, 65202, 65203, 65204}, new char[]{1588, 65205, 65206, 65207, 65208}, new char[]{1589, 65209, 65210, 65211, 65212}, new char[]{1590, 65213, 65214, 65215, 65216}, new char[]{1591, 65217, 65218, 65219, 65220}, new char[]{1592, 65221, 65222, 65223, 65224}, new char[]{1593, 65225, 65226, 65227, 65228}, new char[]{1594, 65229, 65230, 65231, 65232}, new char[]{TATWEEL, TATWEEL, TATWEEL, TATWEEL, TATWEEL}, new char[]{1601, 65233, 65234, 65235, 65236}, new char[]{1602, 65237, 65238, 65239, 65240}, new char[]{1603, 65241, 65242, 65243, 65244}, new char[]{LAM, 65245, 65246, 65247, 65248}, new char[]{1605, 65249, 65250, 65251, 65252}, new char[]{1606, 65253, 65254, 65255, 65256}, new char[]{1607, 65257, 65258, 65259, 65260}, new char[]{WAW, 65261, 65262}, new char[]{ALEFMAKSURA, 65263, 65264, 64488, 64489}, new char[]{YEH, 65265, 65266, 65267, 65268}, new char[]{1649, 64336, 64337}, new char[]{1657, 64358, 64359, 64360, 64361}, new char[]{1658, 64350, 64351, 64352, 64353}, new char[]{1659, 64338, 64339, 64340, 64341}, new char[]{1662, 64342, 64343, 64344, 64345}, new char[]{1663, 64354, 64355, 64356, 64357}, new char[]{1664, 64346, 64347, 64348, 64349}, new char[]{1667, 64374, 64375, 64376, 64377}, new char[]{1668, 64370, 64371, 64372, 64373}, new char[]{1670, 64378, 64379, 64380, 64381}, new char[]{1671, 64382, 64383, 64384, 64385}, new char[]{1672, 64392, 64393}, new char[]{1676, 64388, 64389}, new char[]{1677, 64386, 64387}, new char[]{1678, 64390, 64391}, new char[]{1681, 64396, 64397}, new char[]{1688, 64394, 64395}, new char[]{1700, 64362, 64363, 64364, 64365}, new char[]{1702, 64366, 64367, 64368, 64369}, new char[]{1705, 64398, 64399, 64400, 64401}, new char[]{1709, 64467, 64468, 64469, 64470}, new char[]{1711, 64402, 64403, 64404, 64405}, new char[]{1713, 64410, 64411, 64412, 64413}, new char[]{1715, 64406, 64407, 64408, 64409}, new char[]{1722, 64414, 64415}, new char[]{1723, 64416, 64417, 64418, 64419}, new char[]{1726, 64426, 64427, 64428, 64429}, new char[]{1728, 64420, 64421}, new char[]{1729, 64422, 64423, 64424, 64425}, new char[]{1733, 64480, 64481}, new char[]{1734, 64473, 64474}, new char[]{1735, 64471, 64472}, new char[]{1736, 64475, 64476}, new char[]{1737, 64482, 64483}, new char[]{1739, 64478, 64479}, new char[]{FARSIYEH, 64508, 64509, 64510, 64511}, new char[]{1744, 64484, 64485, 64486, 64487}, new char[]{1746, 64430, 64431}, new char[]{1747, 64432, 64433}};
        chartable = cArr;
        for (char[] cArr2 : cArr) {
            maptable.put(Character.valueOf(cArr2[0]), cArr2);
            int length = cArr2.length;
            if (length == 3) {
                HashMap<Character, Character> map = reverseLigatureMapTable;
                map.put(Character.valueOf(cArr2[2]), Character.valueOf(cArr2[1]));
                map.put(Character.valueOf(cArr2[1]), Character.valueOf(cArr2[0]));
            } else if (length == 5) {
                reverseLigatureMapTable.put(Character.valueOf(cArr2[4]), Character.valueOf(cArr2[3]));
                HashMap<Character, Character> map2 = reverseLigatureMapTable;
                map2.put(Character.valueOf(cArr2[2]), Character.valueOf(cArr2[1]));
                map2.put(Character.valueOf(cArr2[1]), Character.valueOf(cArr2[0]));
            }
            char c = cArr2[0];
            if (c == 1591 || c == 1592) {
                HashMap<Character, Character> map3 = reverseLigatureMapTable;
                map3.put(Character.valueOf(cArr2[4]), Character.valueOf(cArr2[1]));
                map3.put(Character.valueOf(cArr2[3]), Character.valueOf(cArr2[1]));
            }
        }
    }

    public ArabicLigaturizer() {
        this.options = 0;
        this.runDirection = 3;
    }

    public static int arabic_shape(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, int i5) {
        char[] cArr3 = new char[i2];
        for (int i6 = (i2 + i) - 1; i6 >= i; i6--) {
            cArr3[i6 - i] = cArr[i6];
        }
        StringBuffer stringBuffer = new StringBuffer(i2);
        shape(cArr3, stringBuffer, i5);
        if ((i5 & 12) != 0) {
            doublelig(stringBuffer, i5);
        }
        System.arraycopy(stringBuffer.toString().toCharArray(), 0, cArr2, i3, stringBuffer.length());
        return stringBuffer.length();
    }

    public static char charshape(char c, int i) {
        if (c < 1569 || c > 1747) {
            return (c < 65269 || c > 65275) ? c : (char) (c + i);
        }
        char[] cArr = maptable.get(Character.valueOf(c));
        return cArr != null ? cArr[i + 1] : c;
    }

    public static boolean connects_to_left(charstruct charstructVar) {
        return charstructVar.numshapes > 2;
    }

    public static void copycstostring(StringBuffer stringBuffer, charstruct charstructVar, int i) {
        char c = charstructVar.basechar;
        if (c == 0) {
            return;
        }
        stringBuffer.append(c);
        int i2 = charstructVar.lignum;
        charstructVar.lignum = i2 - 1;
        char c2 = charstructVar.mark1;
        if (c2 != 0) {
            if ((i & 1) == 0) {
                stringBuffer.append(c2);
                charstructVar.lignum--;
            } else {
                charstructVar.lignum = i2 - 2;
            }
        }
        char c3 = charstructVar.vowel;
        if (c3 != 0) {
            if ((i & 1) != 0) {
                charstructVar.lignum--;
            } else {
                stringBuffer.append(c3);
                charstructVar.lignum--;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:19:0x0041  */
    /* JADX WARN: Code duplicated, block: B:23:0x004c  */
    public static void doublelig(StringBuffer stringBuffer, int i) {
        char c;
        int length = stringBuffer.length();
        int i2 = length;
        int i3 = 0;
        for (int i4 = 1; i4 < length; i4++) {
            if ((i & 4) != 0) {
                c = 64608;
                switch (stringBuffer.charAt(i3)) {
                    case 1614:
                        if (stringBuffer.charAt(i4) != 1617) {
                            c = 0;
                        }
                        break;
                    case 1615:
                        if (stringBuffer.charAt(i4) == 1617) {
                            c = 64609;
                        } else {
                            c = 0;
                        }
                        break;
                    case 1616:
                        if (stringBuffer.charAt(i4) == 1617) {
                            c = 64610;
                        } else {
                            c = 0;
                        }
                        break;
                    case 1617:
                        switch (stringBuffer.charAt(i4)) {
                            case 1612:
                                c = 64606;
                                break;
                            case 1613:
                                c = 64607;
                                break;
                            case 1614:
                                break;
                            case 1615:
                                c = 64609;
                                break;
                            case 1616:
                                c = 64610;
                                break;
                            default:
                                c = 0;
                                break;
                        }
                        break;
                    default:
                        c = 0;
                        break;
                }
            } else {
                c = 0;
            }
            if ((i & 8) != 0) {
                switch (stringBuffer.charAt(i3)) {
                    case 65169:
                        char cCharAt = stringBuffer.charAt(i4);
                        if (cCharAt == 65184) {
                            c = 64668;
                        } else if (cCharAt == 65188) {
                            c = 64669;
                        } else if (cCharAt == 65192) {
                            c = 64670;
                        }
                        break;
                    case 65175:
                        char cCharAt2 = stringBuffer.charAt(i4);
                        if (cCharAt2 == 65184) {
                            c = 64673;
                        } else if (cCharAt2 == 65188) {
                            c = 64674;
                        } else if (cCharAt2 == 65192) {
                            c = 64675;
                        }
                        break;
                    case 65235:
                        if (stringBuffer.charAt(i4) == 65266) {
                            c = 64562;
                        }
                        break;
                    case 65247:
                        switch (stringBuffer.charAt(i4)) {
                            case 65182:
                                c = 64575;
                                break;
                            case 65184:
                                c = 64713;
                                break;
                            case 65186:
                                c = 64576;
                                break;
                            case 65188:
                                c = 64714;
                                break;
                            case 65190:
                                c = 64577;
                                break;
                            case 65192:
                                c = 64715;
                                break;
                            case 65250:
                                c = 64578;
                                break;
                            case 65252:
                                c = 64716;
                                break;
                        }
                        break;
                    case 65251:
                        switch (stringBuffer.charAt(i4)) {
                            case 65184:
                                c = 64718;
                                break;
                            case 65188:
                                c = 64719;
                                break;
                            case 65192:
                                c = 64720;
                                break;
                            case 65252:
                                c = 64721;
                                break;
                        }
                        break;
                    case 65255:
                        char cCharAt3 = stringBuffer.charAt(i4);
                        if (cCharAt3 == 65184) {
                            c = 64722;
                        } else if (cCharAt3 == 65188) {
                            c = 64723;
                        } else if (cCharAt3 == 65192) {
                            c = 64724;
                        }
                        break;
                    case 65256:
                        char cCharAt4 = stringBuffer.charAt(i4);
                        if (cCharAt4 == 65198) {
                            c = 64650;
                        } else if (cCharAt4 == 65200) {
                            c = 64651;
                        }
                        break;
                }
            }
            if (c != 0) {
                stringBuffer.setCharAt(i3, c);
                i2--;
            } else {
                i3++;
                stringBuffer.setCharAt(i3, stringBuffer.charAt(i4));
            }
        }
        stringBuffer.setLength(i2);
    }

    public static Character getReverseMapping(char c) {
        return reverseLigatureMapTable.get(Character.valueOf(c));
    }

    public static boolean isVowel(char c) {
        return (c >= 1611 && c <= 1621) || c == 1648;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x005b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0074  */
    public static int ligature(char c, charstruct charstructVar) {
        if (charstructVar.basechar == 0) {
            return 0;
        }
        int i = 2;
        if (!isVowel(c)) {
            if (charstructVar.vowel != 0) {
                return 0;
            }
            char c2 = charstructVar.basechar;
            if (c2 == 0) {
                charstructVar.basechar = c;
                charstructVar.numshapes = shapecount(c);
                return 1;
            }
            if (c2 != 1604) {
                return 0;
            }
            if (c == 1570) {
                charstructVar.basechar = LAM_ALEFMADDA;
                charstructVar.numshapes = 2;
            } else if (c == 1571) {
                charstructVar.basechar = LAM_ALEFHAMZA;
                charstructVar.numshapes = 2;
            } else if (c == 1573) {
                charstructVar.basechar = LAM_ALEFHAMZABELOW;
                charstructVar.numshapes = 2;
            } else {
                if (c != 1575) {
                    return 0;
                }
                charstructVar.basechar = LAM_ALEF;
                charstructVar.numshapes = 2;
            }
            return 3;
        }
        int i2 = (charstructVar.vowel == 0 || c == 1617) ? 1 : 2;
        switch (c) {
            case 1617:
                if (charstructVar.mark1 != 0) {
                    return 0;
                }
                charstructVar.mark1 = SHADDA;
                i = i2;
                if (i == 1) {
                    charstructVar.lignum++;
                }
                return i;
            case 1618:
            default:
                charstructVar.vowel = c;
                i = i2;
                if (i == 1) {
                    charstructVar.lignum++;
                }
                return i;
            case 1619:
                if (charstructVar.basechar != 1575) {
                    i = i2;
                } else {
                    charstructVar.basechar = ALEFMADDA;
                }
                if (i == 1) {
                    charstructVar.lignum++;
                }
                return i;
            case 1620:
                char c3 = charstructVar.basechar;
                if (c3 == 1575) {
                    charstructVar.basechar = ALEFHAMZA;
                } else if (c3 == 1740) {
                    charstructVar.basechar = YEHHAMZA;
                } else if (c3 != 65275) {
                    switch (c3) {
                        case 1608:
                            charstructVar.basechar = WAWHAMZA;
                            break;
                        case 1609:
                        case 1610:
                            charstructVar.basechar = YEHHAMZA;
                            break;
                        default:
                            charstructVar.mark1 = HAMZAABOVE;
                            i = i2;
                            break;
                    }
                } else {
                    charstructVar.basechar = LAM_ALEFHAMZA;
                }
                if (i == 1) {
                    charstructVar.lignum++;
                }
                return i;
            case 1621:
                char c4 = charstructVar.basechar;
                if (c4 == 1575) {
                    charstructVar.basechar = ALEFHAMZABELOW;
                } else if (c4 != 65275) {
                    charstructVar.mark1 = HAMZABELOW;
                    i = i2;
                } else {
                    charstructVar.basechar = LAM_ALEFHAMZABELOW;
                }
                if (i == 1) {
                    charstructVar.lignum++;
                }
                return i;
        }
    }

    public static void processNumbers(char[] cArr, int i, int i2, int i3) {
        char c;
        int i4 = i + i2;
        int i5 = i3 & 224;
        if (i5 != 0) {
            int i6 = i3 & 256;
            if (i6 != 0) {
                c = i6 != 256 ? '0' : (char) 1776;
            } else {
                c = 1632;
            }
            if (i5 == 32) {
                int i7 = c - '0';
                while (i < i4) {
                    char c2 = cArr[i];
                    if (c2 <= '9' && c2 >= '0') {
                        cArr[i] = (char) (c2 + i7);
                    }
                    i++;
                }
                return;
            }
            if (i5 != 64) {
                if (i5 == 96) {
                    shapeToArabicDigitsWithContext(cArr, 0, i2, c, false);
                    return;
                } else {
                    if (i5 != 128) {
                        return;
                    }
                    shapeToArabicDigitsWithContext(cArr, 0, i2, c, true);
                    return;
                }
            }
            char c3 = (char) (c + '\t');
            int i8 = '0' - c;
            while (i < i4) {
                char c4 = cArr[i];
                if (c4 <= c3 && c4 >= c) {
                    cArr[i] = (char) (c4 + i8);
                }
                i++;
            }
        }
    }

    public static void shape(char[] cArr, StringBuffer stringBuffer, int i) {
        charstruct charstructVar = new charstruct();
        charstruct charstructVar2 = new charstruct();
        int i2 = 0;
        while (i2 < cArr.length) {
            i2++;
            char c = cArr[i2];
            if (ligature(c, charstructVar2) == 0) {
                int iShapecount = shapecount(c);
                int i3 = iShapecount == 1 ? 0 : 2;
                if (connects_to_left(charstructVar)) {
                    i3++;
                }
                charstructVar2.basechar = charshape(charstructVar2.basechar, i3 % charstructVar2.numshapes);
                copycstostring(stringBuffer, charstructVar, i);
                charstruct charstructVar3 = new charstruct();
                charstructVar3.basechar = c;
                charstructVar3.numshapes = iShapecount;
                charstructVar3.lignum++;
                charstruct charstructVar4 = charstructVar2;
                charstructVar2 = charstructVar3;
                charstructVar = charstructVar4;
            }
        }
        charstructVar2.basechar = charshape(charstructVar2.basechar, (connects_to_left(charstructVar) ? 1 : 0) % charstructVar2.numshapes);
        copycstostring(stringBuffer, charstructVar, i);
        copycstostring(stringBuffer, charstructVar2, i);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0026  */
    public static void shapeToArabicDigitsWithContext(char[] cArr, int i, int i2, char c, boolean z) {
        char c2 = (char) (c - '0');
        int i3 = i2 + i;
        while (i < i3) {
            char c3 = cArr[i];
            byte direction = BidiOrder.getDirection(c3);
            if (direction == 0) {
                z = false;
            } else if (direction != 8) {
                if (direction == 3) {
                    z = false;
                } else if (direction == 4) {
                    z = true;
                }
            } else if (z && c3 <= '9') {
                cArr[i] = (char) (c3 + c2);
            }
            i++;
        }
    }

    public static int shapecount(char c) {
        if (c >= 1569 && c <= 1747 && !isVowel(c)) {
            char[] cArr = maptable.get(Character.valueOf(c));
            if (cArr != null) {
                return cArr.length - 1;
            }
        } else if (c == 8205) {
            return 4;
        }
        return 1;
    }

    @Override // com.itextpdf.text.pdf.languages.LanguageProcessor
    public boolean isRTL() {
        return true;
    }

    @Override // com.itextpdf.text.pdf.languages.LanguageProcessor
    public String process(String str) {
        return BidiLine.processLTR(str, this.runDirection, this.options);
    }

    public ArabicLigaturizer(int i, int i2) {
        this.runDirection = i;
        this.options = i2;
    }
}
