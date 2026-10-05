package org.apache.poi.ss.format;

import com.itextpdf.tool.xml.css.CSS;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.util.BitSet;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes4.dex */
public class CellNumberFormatter extends CellFormatter {
    private Special afterFractional;
    private Special afterInteger;
    private DecimalFormat decimalFmt;
    private Special decimalPoint;
    private String denominatorFmt;
    private List<Special> denominatorSpecials;
    private final String desc;
    private Special exponent;
    private List<Special> exponentDigitSpecials;
    private List<Special> exponentSpecials;
    private List<Special> fractionalSpecials;
    private boolean improperFraction;
    private boolean integerCommas;
    private List<Special> integerSpecials;
    private int maxDenominator;
    private Special numerator;
    private String numeratorFmt;
    private List<Special> numeratorSpecials;
    private String printfFmt;
    private double scale;
    private Special slash;
    private final List<Special> specials;
    static final CellFormatter SIMPLE_NUMBER = new CellFormatter("General") { // from class: org.apache.poi.ss.format.CellNumberFormatter.1
        @Override // org.apache.poi.ss.format.CellFormatter
        public void formatValue(StringBuffer stringBuffer, Object obj) {
            if (obj == null) {
                return;
            }
            if (!(obj instanceof Number)) {
                CellTextFormatter.SIMPLE_TEXT.formatValue(stringBuffer, obj);
            } else if (((Number) obj).doubleValue() % 1.0d == 0.0d) {
                CellNumberFormatter.SIMPLE_INT.formatValue(stringBuffer, obj);
            } else {
                CellNumberFormatter.SIMPLE_FLOAT.formatValue(stringBuffer, obj);
            }
        }

        @Override // org.apache.poi.ss.format.CellFormatter
        public void simpleValue(StringBuffer stringBuffer, Object obj) {
            formatValue(stringBuffer, obj);
        }
    };
    private static final CellFormatter SIMPLE_INT = new CellNumberFormatter("#");
    private static final CellFormatter SIMPLE_FLOAT = new CellNumberFormatter("#.#");

    public class NumPartHandler implements CellFormatPart.PartHandler {
        private char insertSignForExponent;

        private NumPartHandler() {
        }

        /* JADX WARN: Code duplicated, block: B:35:0x00d4  */
        /* JADX WARN: Code duplicated, block: B:37:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:40:0x00f7 A[LOOP:0: B:38:0x00f1->B:40:0x00f7, LOOP_END] */
        @Override // org.apache.poi.ss.format.CellFormatPart.PartHandler
        public String handlePart(Matcher matcher, String str, CellFormatType cellFormatType, StringBuffer stringBuffer) {
            int length = stringBuffer.length();
            char cCharAt = str.charAt(0);
            if (cCharAt == '#') {
                if (this.insertSignForExponent != 0) {
                    CellNumberFormatter.this.specials.add(new Special(this.insertSignForExponent, length));
                    stringBuffer.append(this.insertSignForExponent);
                    this.insertSignForExponent = (char) 0;
                    length++;
                }
                for (int i = 0; i < str.length(); i++) {
                    CellNumberFormatter.this.specials.add(new Special(str.charAt(i), length + i));
                }
            } else if (cCharAt == '%') {
                CellNumberFormatter.access$1034(CellNumberFormatter.this, 100.0d);
            } else if (cCharAt == '?') {
                if (this.insertSignForExponent != 0) {
                    CellNumberFormatter.this.specials.add(new Special(this.insertSignForExponent, length));
                    stringBuffer.append(this.insertSignForExponent);
                    this.insertSignForExponent = (char) 0;
                    length++;
                }
                while (i < str.length()) {
                    CellNumberFormatter.this.specials.add(new Special(str.charAt(i), length + i));
                }
            } else if (cCharAt != 'E' && cCharAt != 'e') {
                switch (cCharAt) {
                    case '.':
                        if (CellNumberFormatter.this.decimalPoint == null && CellNumberFormatter.this.specials.size() > 0) {
                            CellNumberFormatter.this.specials.add(CellNumberFormatter.this.decimalPoint = new Special('.', length));
                        }
                        break;
                    case '/':
                        if (CellNumberFormatter.this.slash == null && CellNumberFormatter.this.specials.size() > 0) {
                            CellNumberFormatter cellNumberFormatter = CellNumberFormatter.this;
                            cellNumberFormatter.numerator = cellNumberFormatter.previousNumber();
                            if (CellNumberFormatter.this.numerator == CellNumberFormatter.firstDigit(CellNumberFormatter.this.specials)) {
                                CellNumberFormatter.this.improperFraction = true;
                            }
                            CellNumberFormatter.this.specials.add(CellNumberFormatter.this.slash = new Special('.', length));
                        }
                        break;
                    case '0':
                        if (this.insertSignForExponent != 0) {
                            CellNumberFormatter.this.specials.add(new Special(this.insertSignForExponent, length));
                            stringBuffer.append(this.insertSignForExponent);
                            this.insertSignForExponent = (char) 0;
                            length++;
                        }
                        while (i < str.length()) {
                            CellNumberFormatter.this.specials.add(new Special(str.charAt(i), length + i));
                        }
                        break;
                    default:
                        return null;
                }
            } else if (CellNumberFormatter.this.exponent == null && CellNumberFormatter.this.specials.size() > 0) {
                CellNumberFormatter.this.specials.add(CellNumberFormatter.this.exponent = new Special('.', length));
                this.insertSignForExponent = str.charAt(1);
                return str.substring(0, 1);
            }
            return str;
        }
    }

    public static class Special {
        final char ch;
        int pos;

        public Special(char c, int i) {
            this.ch = c;
            this.pos = i;
        }

        public String toString() {
            return "'" + this.ch + "' @ " + this.pos;
        }
    }

    public static class StringMod implements Comparable<StringMod> {
        public static final int AFTER = 2;
        public static final int BEFORE = 1;
        public static final int REPLACE = 3;
        Special end;
        boolean endInclusive;
        final int op;
        final Special special;
        boolean startInclusive;
        CharSequence toAdd;

        public boolean equals(Object obj) {
            try {
                return compareTo((StringMod) obj) == 0;
            } catch (RuntimeException unused) {
                return false;
            }
        }

        public int hashCode() {
            return this.special.hashCode() + this.op;
        }

        private StringMod(Special special, CharSequence charSequence, int i) {
            this.special = special;
            this.toAdd = charSequence;
            this.op = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(StringMod stringMod) {
            int i = this.special.pos - stringMod.special.pos;
            return i != 0 ? i : this.op - stringMod.op;
        }

        public StringMod(Special special, boolean z, Special special2, boolean z2, char c) {
            this(special, z, special2, z2);
            this.toAdd = c + "";
        }

        public StringMod(Special special, boolean z, Special special2, boolean z2) {
            this.special = special;
            this.startInclusive = z;
            this.end = special2;
            this.endInclusive = z2;
            this.op = 3;
            this.toAdd = "";
        }
    }

    public CellNumberFormatter(String str) {
        int iInterpretPrecision;
        int i;
        super(str);
        this.scale = 1.0d;
        LinkedList linkedList = new LinkedList();
        this.specials = linkedList;
        StringBuffer format = CellFormatPart.parseFormat(str, CellFormatType.NUMBER, new NumPartHandler());
        if ((this.decimalPoint != null || this.exponent != null) && this.slash != null) {
            this.slash = null;
            this.numerator = null;
        }
        interpretCommas(format);
        if (this.decimalPoint == null) {
            iInterpretPrecision = 0;
            i = 0;
        } else {
            iInterpretPrecision = interpretPrecision();
            i = iInterpretPrecision + 1;
            if (iInterpretPrecision == 0) {
                linkedList.remove(this.decimalPoint);
                this.decimalPoint = null;
            }
        }
        boolean z = true;
        if (iInterpretPrecision == 0) {
            this.fractionalSpecials = Collections.emptyList();
        } else {
            this.fractionalSpecials = linkedList.subList(linkedList.indexOf(this.decimalPoint) + 1, fractionalEnd());
        }
        Special special = this.exponent;
        if (special == null) {
            this.exponentSpecials = Collections.emptyList();
        } else {
            int iIndexOf = linkedList.indexOf(special);
            this.exponentSpecials = specialsFor(iIndexOf, 2);
            this.exponentDigitSpecials = specialsFor(iIndexOf + 2);
        }
        if (this.slash == null) {
            this.numeratorSpecials = Collections.emptyList();
            this.denominatorSpecials = Collections.emptyList();
        } else {
            Special special2 = this.numerator;
            if (special2 == null) {
                this.numeratorSpecials = Collections.emptyList();
            } else {
                this.numeratorSpecials = specialsFor(linkedList.indexOf(special2));
            }
            List<Special> listSpecialsFor = specialsFor(linkedList.indexOf(this.slash) + 1);
            this.denominatorSpecials = listSpecialsFor;
            if (listSpecialsFor.isEmpty()) {
                this.numeratorSpecials = Collections.emptyList();
            } else {
                this.maxDenominator = maxValue(this.denominatorSpecials);
                this.numeratorFmt = singleNumberFormat(this.numeratorSpecials);
                this.denominatorFmt = singleNumberFormat(this.denominatorSpecials);
            }
        }
        this.integerSpecials = linkedList.subList(0, integerEnd());
        if (this.exponent == null) {
            StringBuffer stringBuffer = new StringBuffer(CSS.Value.PERCENTAGE);
            int iCalculateIntegerPartWidth = calculateIntegerPartWidth() + i;
            stringBuffer.append('0');
            stringBuffer.append(iCalculateIntegerPartWidth);
            stringBuffer.append('.');
            stringBuffer.append(iInterpretPrecision);
            stringBuffer.append("f");
            this.printfFmt = stringBuffer.toString();
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            List<Special> list = this.integerSpecials;
            if (list.size() == 1) {
                stringBuffer2.append("0");
                z = false;
            } else {
                Iterator<Special> it = list.iterator();
                while (it.hasNext()) {
                    if (isDigitFmt(it.next())) {
                        stringBuffer2.append(z ? '#' : '0');
                        z = false;
                    }
                }
            }
            if (this.fractionalSpecials.size() > 0) {
                stringBuffer2.append('.');
                Iterator<Special> it2 = this.fractionalSpecials.iterator();
                while (it2.hasNext()) {
                    if (isDigitFmt(it2.next())) {
                        if (!z) {
                            stringBuffer2.append('0');
                        }
                        z = false;
                    }
                }
            }
            stringBuffer2.append('E');
            List<Special> list2 = this.exponentSpecials;
            placeZeros(stringBuffer2, list2.subList(2, list2.size()));
            this.decimalFmt = new DecimalFormat(stringBuffer2.toString());
        }
        if (this.exponent != null) {
            this.scale = 1.0d;
        }
        this.desc = format.toString();
    }

    public static /* synthetic */ double access$1034(CellNumberFormatter cellNumberFormatter, double d) {
        double d2 = cellNumberFormatter.scale * d;
        cellNumberFormatter.scale = d2;
        return d2;
    }

    private int calculateIntegerPartWidth() {
        Special next;
        ListIterator<Special> listIterator = this.specials.listIterator();
        int i = 0;
        while (listIterator.hasNext() && (next = listIterator.next()) != this.afterInteger) {
            if (isDigitFmt(next)) {
                i++;
            }
        }
        return i;
    }

    public static StringMod deleteMod(Special special, boolean z, Special special2, boolean z2) {
        return new StringMod(special, z, special2, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Special firstDigit(List<Special> list) {
        for (Special special : list) {
            if (isDigitFmt(special)) {
                return special;
            }
        }
        return null;
    }

    private int fractionalEnd() {
        Special special = this.exponent;
        if (special != null) {
            this.afterFractional = special;
        } else {
            Special special2 = this.numerator;
            if (special2 != null) {
                this.afterInteger = special2;
            } else {
                this.afterFractional = null;
            }
        }
        Special special3 = this.afterFractional;
        return special3 == null ? this.specials.size() : this.specials.indexOf(special3);
    }

    private static boolean hasChar(char c, List<Special>... listArr) {
        for (List<Special> list : listArr) {
            Iterator<Special> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().ch == c) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasOnly(char c, List<Special>... listArr) {
        for (List<Special> list : listArr) {
            Iterator<Special> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().ch != c) {
                    return false;
                }
            }
        }
        return true;
    }

    public static StringMod insertMod(Special special, CharSequence charSequence, int i) {
        return new StringMod(special, charSequence, i);
    }

    private int integerEnd() {
        Special special = this.decimalPoint;
        if (special != null) {
            this.afterInteger = special;
        } else {
            Special special2 = this.exponent;
            if (special2 != null) {
                this.afterInteger = special2;
            } else {
                Special special3 = this.numerator;
                if (special3 != null) {
                    this.afterInteger = special3;
                } else {
                    this.afterInteger = null;
                }
            }
        }
        Special special4 = this.afterInteger;
        return special4 == null ? this.specials.size() : this.specials.indexOf(special4);
    }

    private void interpretCommas(StringBuffer stringBuffer) {
        ListIterator<Special> listIterator = this.specials.listIterator(integerEnd());
        int i = 0;
        this.integerCommas = false;
        boolean z = true;
        while (listIterator.hasPrevious()) {
            if (listIterator.previous().ch != ',') {
                z = false;
            } else if (z) {
                this.scale /= 1000.0d;
            } else {
                this.integerCommas = true;
            }
        }
        if (this.decimalPoint != null) {
            ListIterator<Special> listIterator2 = this.specials.listIterator(fractionalEnd());
            while (listIterator2.hasPrevious() && listIterator2.previous().ch == ',') {
                this.scale /= 1000.0d;
            }
        }
        ListIterator<Special> listIterator3 = this.specials.listIterator();
        while (listIterator3.hasNext()) {
            Special next = listIterator3.next();
            next.pos -= i;
            if (next.ch == ',') {
                i++;
                listIterator3.remove();
                stringBuffer.deleteCharAt(next.pos);
            }
        }
    }

    private int interpretPrecision() {
        Special special = this.decimalPoint;
        if (special == null) {
            return -1;
        }
        List<Special> list = this.specials;
        ListIterator<Special> listIterator = list.listIterator(list.indexOf(special));
        if (listIterator.hasNext()) {
            listIterator.next();
        }
        int i = 0;
        while (listIterator.hasNext() && isDigitFmt(listIterator.next())) {
            i++;
        }
        return i;
    }

    private static boolean isDigitFmt(Special special) {
        char c = special.ch;
        return c == '0' || c == '?' || c == '#';
    }

    private static int maxValue(List<Special> list) {
        return (int) Math.round(Math.pow(10.0d, list.size()) - 1.0d);
    }

    private static void placeZeros(StringBuffer stringBuffer, List<Special> list) {
        Iterator<Special> it = list.iterator();
        while (it.hasNext()) {
            if (isDigitFmt(it.next())) {
                stringBuffer.append('0');
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Special previousNumber() {
        List<Special> list = this.specials;
        ListIterator<Special> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            Special specialPrevious = listIterator.previous();
            if (isDigitFmt(specialPrevious)) {
                while (listIterator.hasPrevious()) {
                    Special specialPrevious2 = listIterator.previous();
                    if (specialPrevious.pos - specialPrevious2.pos > 1 || !isDigitFmt(specialPrevious2)) {
                        break;
                    }
                    specialPrevious = specialPrevious2;
                }
                return specialPrevious;
            }
        }
        return null;
    }

    public static StringMod replaceMod(Special special, boolean z, Special special2, boolean z2, char c) {
        return new StringMod(special, z, special2, z2, c);
    }

    private static String singleNumberFormat(List<Special> list) {
        return "%0" + list.size() + "d";
    }

    private List<Special> specialsFor(int i, int i2) {
        if (i >= this.specials.size()) {
            return Collections.emptyList();
        }
        int i3 = i2 + i;
        ListIterator<Special> listIterator = this.specials.listIterator(i3);
        Special next = listIterator.next();
        while (listIterator.hasNext()) {
            Special next2 = listIterator.next();
            if (!isDigitFmt(next2) || next2.pos - next.pos > 1) {
                break;
            }
            i3++;
            next = next2;
        }
        return this.specials.subList(i, i3 + 1);
    }

    private void writeFraction(double d, StringBuffer stringBuffer, double d2, StringBuffer stringBuffer2, Set<StringMod> set) {
        double d3;
        int numerator;
        int denominator = 1;
        if (this.improperFraction) {
            d3 = 0.0d;
        } else {
            if (d2 == 0.0d && !hasChar('0', this.numeratorSpecials)) {
                writeInteger(stringBuffer, stringBuffer2, this.integerSpecials, set, false);
                List<Special> list = this.integerSpecials;
                Special special = list.get(list.size() - 1);
                List<Special> list2 = this.denominatorSpecials;
                Special special2 = list2.get(list2.size() - 1);
                if (hasChar('?', this.integerSpecials, this.numeratorSpecials, this.denominatorSpecials)) {
                    set.add(replaceMod(special, false, special2, true, ' '));
                    return;
                } else {
                    set.add(deleteMod(special, false, special2, true));
                    return;
                }
            }
            boolean z = d == 0.0d && d2 == 0.0d;
            boolean z2 = d2 != 0.0d || hasChar('0', this.numeratorSpecials);
            boolean z3 = z && (hasOnly('#', this.integerSpecials) || !hasChar('0', this.numeratorSpecials));
            boolean z4 = !z && d == 0.0d && z2 && !hasChar('0', this.integerSpecials);
            if (z3 || z4) {
                List<Special> list3 = this.integerSpecials;
                Special special3 = list3.get(list3.size() - 1);
                if (hasChar('?', this.integerSpecials, this.numeratorSpecials)) {
                    set.add(replaceMod(special3, true, this.numerator, false, ' '));
                } else {
                    set.add(deleteMod(special3, true, this.numerator, false));
                }
            } else {
                writeInteger(stringBuffer, stringBuffer2, this.integerSpecials, set, false);
            }
            d3 = 0.0d;
        }
        if (d2 != d3) {
            try {
                if (this.improperFraction && d2 % 1.0d == d3) {
                    numerator = (int) Math.round(d2);
                } else {
                    Fraction fraction = new Fraction(d2, this.maxDenominator);
                    numerator = fraction.getNumerator();
                    denominator = fraction.getDenominator();
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
                return;
            }
        } else {
            numerator = (int) Math.round(d2);
        }
        if (this.improperFraction) {
            numerator = (int) (((long) numerator) + Math.round(((double) denominator) * d));
        }
        writeSingleInteger(this.numeratorFmt, numerator, stringBuffer2, this.numeratorSpecials, set);
        writeSingleInteger(this.denominatorFmt, denominator, stringBuffer2, this.denominatorSpecials, set);
    }

    private void writeFractional(StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        char c;
        if (this.fractionalSpecials.size() > 0) {
            int iIndexOf = stringBuffer.indexOf(".") + 1;
            int iIndexOf2 = this.exponent != null ? stringBuffer.indexOf("e") : stringBuffer.length();
            do {
                iIndexOf2--;
                if (iIndexOf2 <= iIndexOf) {
                    break;
                }
            } while (stringBuffer.charAt(iIndexOf2) == '0');
            ListIterator<Special> listIterator = this.fractionalSpecials.listIterator();
            while (listIterator.hasNext()) {
                Special next = listIterator.next();
                char cCharAt = stringBuffer.charAt(iIndexOf);
                if (cCharAt != '0' || (c = next.ch) == '0' || iIndexOf < iIndexOf2) {
                    stringBuffer2.setCharAt(next.pos, cCharAt);
                } else if (c == '?') {
                    stringBuffer2.setCharAt(next.pos, ' ');
                }
                iIndexOf++;
            }
        }
    }

    private void writeInteger(StringBuffer stringBuffer, StringBuffer stringBuffer2, List<Special> list, Set<StringMod> set, boolean z) {
        boolean z2;
        char c;
        char cCharAt;
        int iIndexOf = stringBuffer.indexOf(".") - 1;
        if (iIndexOf < 0) {
            iIndexOf = ((this.exponent == null || list != this.integerSpecials) ? stringBuffer.length() : stringBuffer.indexOf("E")) - 1;
        }
        int i = 0;
        while (i < iIndexOf && ((cCharAt = stringBuffer.charAt(i)) == '0' || cCharAt == ',')) {
            i++;
        }
        ListIterator<Special> listIterator = list.listIterator(list.size());
        Special special = null;
        int i2 = 0;
        while (listIterator.hasPrevious()) {
            char cCharAt2 = iIndexOf >= 0 ? stringBuffer.charAt(iIndexOf) : '0';
            Special specialPrevious = listIterator.previous();
            boolean z3 = z && i2 > 0 && i2 % 3 == 0;
            if (cCharAt2 != '0' || (c = specialPrevious.ch) == '0' || c == '?' || iIndexOf >= i) {
                z2 = specialPrevious.ch == '?' && iIndexOf < i;
                int i3 = specialPrevious.pos;
                if (z2) {
                    cCharAt2 = ' ';
                }
                stringBuffer2.setCharAt(i3, cCharAt2);
                special = specialPrevious;
            } else {
                z2 = false;
            }
            if (z3) {
                set.add(insertMod(specialPrevious, z2 ? " " : ",", 2));
            }
            i2++;
            iIndexOf--;
        }
        if (iIndexOf >= 0) {
            int i4 = iIndexOf + 1;
            StringBuffer stringBuffer3 = new StringBuffer(stringBuffer.substring(0, i4));
            if (z) {
                while (i4 > 0) {
                    if (i2 > 0 && i2 % 3 == 0) {
                        stringBuffer3.insert(i4, ',');
                    }
                    i2++;
                    i4--;
                }
            }
            set.add(insertMod(special, stringBuffer3, 1));
        }
    }

    private void writeScientific(double d, StringBuffer stringBuffer, Set<StringMod> set) {
        StringBuffer stringBuffer2 = new StringBuffer();
        FieldPosition fieldPosition = new FieldPosition(1);
        this.decimalFmt.format(d, stringBuffer2, fieldPosition);
        writeInteger(stringBuffer2, stringBuffer, this.integerSpecials, set, this.integerCommas);
        writeFractional(stringBuffer2, stringBuffer);
        int endIndex = fieldPosition.getEndIndex();
        int i = endIndex + 1;
        char cCharAt = stringBuffer2.charAt(i);
        if (cCharAt != '-') {
            stringBuffer2.insert(i, '+');
            cCharAt = '+';
        }
        Special next = this.exponentSpecials.listIterator(1).next();
        char c = next.ch;
        if (cCharAt == '-' || c == '+') {
            set.add(replaceMod(next, true, next, true, cCharAt));
        } else {
            set.add(deleteMod(next, true, next, true));
        }
        writeInteger(new StringBuffer(stringBuffer2.substring(endIndex + 2)), stringBuffer, this.exponentDigitSpecials, set, false);
    }

    private void writeSingleInteger(String str, int i, StringBuffer stringBuffer, List<Special> list, Set<StringMod> set) {
        StringBuffer stringBuffer2 = new StringBuffer();
        new Formatter(stringBuffer2).format(CellFormatter.LOCALE, str, Integer.valueOf(i));
        writeInteger(stringBuffer2, stringBuffer, list, set, false);
    }

    /* JADX WARN: Code duplicated, block: B:90:0x0163 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x015b A[SYNTHETIC] */
    @Override // org.apache.poi.ss.format.CellFormatter
    public void formatValue(StringBuffer stringBuffer, Object obj) {
        double d;
        double d2;
        StringBuffer stringBuffer2;
        int i;
        double dDoubleValue = ((Number) obj).doubleValue() * this.scale;
        int i2 = 1;
        double d3 = 0.0d;
        boolean z = dDoubleValue < 0.0d;
        if (z) {
            dDoubleValue = -dDoubleValue;
        }
        if (this.slash == null) {
            d = d3;
            d2 = dDoubleValue;
        } else if (this.improperFraction) {
            d = dDoubleValue;
            d2 = 0.0d;
        } else {
            d3 = dDoubleValue % 1.0d;
            dDoubleValue = (long) dDoubleValue;
            d = d3;
            d2 = dDoubleValue;
        }
        TreeSet treeSet = new TreeSet();
        StringBuffer stringBuffer3 = new StringBuffer(this.desc);
        if (this.exponent != null) {
            writeScientific(d2, stringBuffer3, treeSet);
        } else if (this.improperFraction) {
            writeFraction(d2, null, d, stringBuffer3, treeSet);
        } else {
            StringBuffer stringBuffer4 = new StringBuffer();
            new Formatter(stringBuffer4).format(CellFormatter.LOCALE, this.printfFmt, Double.valueOf(d2));
            if (this.numerator == null) {
                writeFractional(stringBuffer4, stringBuffer3);
                writeInteger(stringBuffer4, stringBuffer3, this.integerSpecials, treeSet, this.integerCommas);
            } else {
                writeFraction(d2, stringBuffer4, d, stringBuffer3, treeSet);
            }
        }
        ListIterator<Special> listIterator = this.specials.listIterator();
        Iterator<StringMod> it = treeSet.iterator();
        StringMod next = it.hasNext() ? it.next() : null;
        BitSet bitSet = new BitSet();
        int length = 0;
        while (listIterator.hasNext()) {
            Special next2 = listIterator.next();
            int i3 = next2.pos;
            int i4 = i3 + length;
            if (!bitSet.get(i3) && stringBuffer3.charAt(i4) == '#') {
                stringBuffer3.deleteCharAt(i4);
                length--;
                bitSet.set(next2.pos);
            }
            while (next != null && next2 == next.special) {
                int length2 = stringBuffer3.length();
                int i5 = next2.pos;
                int i6 = i5 + length;
                int i7 = next.op;
                if (i7 != i2) {
                    if (i7 == 2) {
                        i = (next.toAdd.equals(",") && bitSet.get(next2.pos)) ? 0 : 1;
                    } else {
                        if (i7 != 3) {
                            throw new IllegalStateException("Unknown op: " + next.op);
                        }
                        if (!next.startInclusive) {
                            i5 += i2;
                            i6 += i2;
                        }
                        while (bitSet.get(i5)) {
                            i5 += i2;
                            i6 += i2;
                        }
                        int i8 = next.end.pos;
                        if (next.endInclusive) {
                            i8 += i2;
                        }
                        int i9 = i8 + length;
                        if (i6 < i9) {
                            CharSequence charSequence = next.toAdd;
                            if (charSequence == "") {
                                stringBuffer3.delete(i6, i9);
                            } else {
                                char cCharAt = charSequence.charAt(0);
                                while (i6 < i9) {
                                    stringBuffer3.setCharAt(i6, cCharAt);
                                    i6++;
                                }
                            }
                            i2 = 1;
                            bitSet.set(i5, i8);
                        }
                    }
                    length += stringBuffer3.length() - length2;
                    next = it.hasNext() ? it.next() : null;
                }
                stringBuffer3.insert(i6 + i, next.toAdd);
                length += stringBuffer3.length() - length2;
                if (it.hasNext()) {
                }
            }
        }
        if (z) {
            stringBuffer2 = stringBuffer;
            stringBuffer2.append('-');
        } else {
            stringBuffer2 = stringBuffer;
        }
        stringBuffer2.append(stringBuffer3);
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer stringBuffer, Object obj) {
        SIMPLE_NUMBER.formatValue(stringBuffer, obj);
    }

    private List<Special> specialsFor(int i) {
        return specialsFor(i, 0);
    }

    public static class Fraction {
        private final int denominator;
        private final int numerator;

        private Fraction(double d, double d2, int i, int i2) {
            long j;
            long j2;
            long j3;
            long j4;
            long jFloor = (long) Math.floor(d);
            String str = ")";
            String str2 = "/";
            if (jFloor > 2147483647L) {
                throw new IllegalArgumentException("Overflow trying to convert " + d + " to fraction (" + jFloor + "/1)");
            }
            if (Math.abs(jFloor - d) < d2) {
                this.numerator = (int) jFloor;
                this.denominator = 1;
                return;
            }
            double d3 = d;
            long j5 = jFloor;
            long j6 = 0;
            int i3 = 0;
            long j7 = 1;
            long j8 = 1;
            boolean z = false;
            while (true) {
                int i4 = i3 + 1;
                double d4 = 1.0d / (d3 - jFloor);
                long jFloor2 = (long) Math.floor(d4);
                long j9 = jFloor;
                j = (jFloor2 * j5) + j7;
                long j10 = j5;
                j2 = (jFloor2 * j8) + j6;
                if (j > 2147483647L || j2 > 2147483647L) {
                    break;
                }
                long j11 = jFloor2;
                String str3 = str;
                String str4 = str2;
                double d5 = j / j2;
                if (i4 >= i2 || Math.abs(d5 - d) <= d2 || j2 >= i) {
                    j3 = j8;
                    j11 = j9;
                    j4 = j10;
                    z = true;
                } else {
                    j4 = j;
                    j3 = j2;
                    j6 = j8;
                    d3 = d4;
                    j7 = j10;
                }
                if (z) {
                    if (i4 < i2) {
                        if (j2 < i) {
                            this.numerator = (int) j;
                            this.denominator = (int) j2;
                            return;
                        } else {
                            this.numerator = (int) j4;
                            this.denominator = (int) j3;
                            return;
                        }
                    }
                    throw new RuntimeException("Unable to convert " + d + " to fraction after " + i2 + " iterations");
                }
                j5 = j4;
                i3 = i4;
                j8 = j3;
                jFloor = j11;
                str = str3;
                str2 = str4;
            }
            throw new RuntimeException("Overflow trying to convert " + d + " to fraction (" + j + str2 + j2 + str);
        }

        public int getDenominator() {
            return this.denominator;
        }

        public int getNumerator() {
            return this.numerator;
        }

        public Fraction(double d, int i) {
            this(d, 0.0d, i, 100);
        }
    }
}
