package com.itextpdf.text;

import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.BaseFont;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class FontFactoryImp implements FontProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) FontFactoryImp.class);
    private static String[] TTFamilyOrder = {"3", "1", "1033", "3", "0", "1033", "1", "0", "0", "0", "3", "0"};
    public boolean defaultEmbedding;
    public String defaultEncoding;
    private final Hashtable<String, ArrayList<String>> fontFamilies;
    private final Hashtable<String, String> trueTypeFonts;

    public FontFactoryImp() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        this.trueTypeFonts = hashtable;
        Hashtable<String, ArrayList<String>> hashtable2 = new Hashtable<>();
        this.fontFamilies = hashtable2;
        this.defaultEncoding = "Cp1252";
        this.defaultEmbedding = false;
        hashtable.put("Courier".toLowerCase(), "Courier");
        hashtable.put("Courier-Bold".toLowerCase(), "Courier-Bold");
        hashtable.put("Courier-Oblique".toLowerCase(), "Courier-Oblique");
        hashtable.put("Courier-BoldOblique".toLowerCase(), "Courier-BoldOblique");
        hashtable.put("Helvetica".toLowerCase(), "Helvetica");
        hashtable.put("Helvetica-Bold".toLowerCase(), "Helvetica-Bold");
        hashtable.put("Helvetica-Oblique".toLowerCase(), "Helvetica-Oblique");
        hashtable.put("Helvetica-BoldOblique".toLowerCase(), "Helvetica-BoldOblique");
        hashtable.put("Symbol".toLowerCase(), "Symbol");
        hashtable.put("Times-Roman".toLowerCase(), "Times-Roman");
        hashtable.put("Times-Bold".toLowerCase(), "Times-Bold");
        hashtable.put("Times-Italic".toLowerCase(), "Times-Italic");
        hashtable.put("Times-BoldItalic".toLowerCase(), "Times-BoldItalic");
        hashtable.put("ZapfDingbats".toLowerCase(), "ZapfDingbats");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Courier");
        arrayList.add("Courier-Bold");
        arrayList.add("Courier-Oblique");
        arrayList.add("Courier-BoldOblique");
        hashtable2.put("Courier".toLowerCase(), arrayList);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Helvetica");
        arrayList2.add("Helvetica-Bold");
        arrayList2.add("Helvetica-Oblique");
        arrayList2.add("Helvetica-BoldOblique");
        hashtable2.put("Helvetica".toLowerCase(), arrayList2);
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("Symbol");
        hashtable2.put("Symbol".toLowerCase(), arrayList3);
        ArrayList<String> arrayList4 = new ArrayList<>();
        arrayList4.add("Times-Roman");
        arrayList4.add("Times-Bold");
        arrayList4.add("Times-Italic");
        arrayList4.add("Times-BoldItalic");
        hashtable2.put(FontFactory.TIMES.toLowerCase(), arrayList4);
        hashtable2.put("Times-Roman".toLowerCase(), arrayList4);
        ArrayList<String> arrayList5 = new ArrayList<>();
        arrayList5.add("ZapfDingbats");
        hashtable2.put("ZapfDingbats".toLowerCase(), arrayList5);
    }

    public BaseFont getBaseFont(String str, String str2, boolean z, boolean z2) {
        BaseFont baseFontCreateFont;
        String str3;
        try {
            baseFontCreateFont = BaseFont.createFont(str, str2, z, z2, null, null, true);
        } catch (DocumentException unused) {
            baseFontCreateFont = null;
        }
        return (baseFontCreateFont != null || (str3 = this.trueTypeFonts.get(str.toLowerCase())) == null) ? baseFontCreateFont : BaseFont.createFont(str3, str2, z, z2, null, null);
    }

    @Override // com.itextpdf.text.FontProvider
    public Font getFont(String str, String str2, boolean z, float f, int i, BaseColor baseColor) {
        return getFont(str, str2, z, f, i, baseColor, true);
    }

    public Set<String> getRegisteredFamilies() {
        return this.fontFamilies.keySet();
    }

    public Set<String> getRegisteredFonts() {
        return this.trueTypeFonts.keySet();
    }

    @Override // com.itextpdf.text.FontProvider
    public boolean isRegistered(String str) {
        return this.trueTypeFonts.containsKey(str.toLowerCase());
    }

    public void register(String str) {
        register(str, null);
    }

    public int registerDirectories() {
        int iRegisterDirectory;
        String str = System.getenv("windir");
        String property = System.getProperty("file.separator");
        if (str == null || property == null) {
            iRegisterDirectory = 0;
        } else {
            iRegisterDirectory = registerDirectory(str + property + "fonts");
        }
        return iRegisterDirectory + registerDirectory("/usr/share/X11/fonts", true) + registerDirectory("/usr/X/lib/X11/fonts", true) + registerDirectory("/usr/openwin/lib/X11/fonts", true) + registerDirectory("/usr/share/fonts", true) + registerDirectory("/usr/X11R6/lib/X11/fonts", true) + registerDirectory("/Library/Fonts") + registerDirectory("/System/Library/Fonts");
    }

    public int registerDirectory(String str) {
        return registerDirectory(str, false);
    }

    public void registerFamily(String str, String str2, String str3) {
        ArrayList<String> arrayList;
        if (str3 != null) {
            this.trueTypeFonts.put(str2, str3);
        }
        synchronized (this.fontFamilies) {
            try {
                arrayList = this.fontFamilies.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.fontFamilies.put(str, arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (arrayList) {
            try {
                if (!arrayList.contains(str2)) {
                    int length = str2.length();
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).length() >= length) {
                            arrayList.add(i, str2);
                        }
                    }
                    arrayList.add(str2);
                    String lowerCase = str2.toLowerCase();
                    if (lowerCase.endsWith("regular")) {
                        arrayList.add(0, str2.substring(0, lowerCase.substring(0, lowerCase.length() - 7).trim().length()));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean saveCopyOfRegularFont(String str, String str2) {
        String strTrim = str.substring(0, str.length() - 7).trim();
        if (this.trueTypeFonts.containsKey(strTrim)) {
            return false;
        }
        this.trueTypeFonts.put(strTrim, str2);
        return true;
    }

    public Font getFont(String str, String str2, boolean z, float f, int i, BaseColor baseColor, boolean z2) {
        String next;
        int i2;
        int i3 = i;
        if (str == null) {
            return new Font(Font.FontFamily.UNDEFINED, f, i3, baseColor);
        }
        ArrayList<String> arrayList = this.fontFamilies.get(str.toLowerCase());
        if (arrayList != null) {
            synchronized (arrayList) {
                boolean z3 = false;
                int i4 = i3 == -1 ? 0 : i3;
                try {
                    Iterator<String> it = arrayList.iterator();
                    int i5 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i2 = i5;
                            next = str;
                            break;
                        }
                        next = it.next();
                        String lowerCase = next.toLowerCase();
                        int i6 = lowerCase.indexOf("bold") != -1 ? 1 : 0;
                        i2 = (lowerCase.indexOf("italic") == -1 && lowerCase.indexOf("oblique") == -1) ? i6 : i6 | 2;
                        if ((i4 & 3) == i2) {
                            z3 = true;
                            break;
                        }
                        i5 = i2;
                    }
                    if (i3 != -1 && z3) {
                        i3 &= ~i2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            next = str;
        }
        try {
            BaseFont baseFont = getBaseFont(next, str2, z, z2);
            return baseFont == null ? new Font(Font.FontFamily.UNDEFINED, f, i3, baseColor) : new Font(baseFont, f, i3, baseColor);
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        } catch (IOException unused) {
            return new Font(Font.FontFamily.UNDEFINED, f, i3, baseColor);
        } catch (NullPointerException unused2) {
            return new Font(Font.FontFamily.UNDEFINED, f, i3, baseColor);
        }
    }

    public void register(String str, String str2) {
        try {
            if (str.toLowerCase().endsWith(".ttf") || str.toLowerCase().endsWith(".otf") || str.toLowerCase().indexOf(".ttc,") > 0) {
                Object[] allFontNames = BaseFont.getAllFontNames(str, "Cp1252", null);
                this.trueTypeFonts.put(((String) allFontNames[0]).toLowerCase(), str);
                if (str2 != null) {
                    String lowerCase = str2.toLowerCase();
                    this.trueTypeFonts.put(lowerCase, str);
                    if (lowerCase.endsWith("regular")) {
                        saveCopyOfRegularFont(lowerCase, str);
                    }
                }
                for (String[] strArr : (String[][]) allFontNames[2]) {
                    String lowerCase2 = strArr[3].toLowerCase();
                    this.trueTypeFonts.put(lowerCase2, str);
                    if (lowerCase2.endsWith("regular")) {
                        saveCopyOfRegularFont(lowerCase2, str);
                    }
                }
                String[][] strArr2 = (String[][]) allFontNames[1];
                String lowerCase3 = null;
                int length = 0;
                while (length < TTFamilyOrder.length) {
                    for (String[] strArr3 : strArr2) {
                        if (TTFamilyOrder[length].equals(strArr3[0]) && TTFamilyOrder[length + 1].equals(strArr3[1]) && TTFamilyOrder[length + 2].equals(strArr3[2])) {
                            lowerCase3 = strArr3[3].toLowerCase();
                            length = TTFamilyOrder.length;
                            break;
                        }
                    }
                    length += 3;
                }
                if (lowerCase3 != null) {
                    Object obj = "";
                    for (String[] strArr4 : (String[][]) allFontNames[2]) {
                        int i = 0;
                        while (true) {
                            String[] strArr5 = TTFamilyOrder;
                            if (i >= strArr5.length) {
                                break;
                            }
                            if (strArr5[i].equals(strArr4[0]) && TTFamilyOrder[i + 1].equals(strArr4[1]) && TTFamilyOrder[i + 2].equals(strArr4[2])) {
                                String str3 = strArr4[3];
                                if (!str3.equals(obj)) {
                                    registerFamily(lowerCase3, str3, null);
                                    obj = str3;
                                    break;
                                }
                            }
                            i += 3;
                        }
                    }
                }
            } else if (str.toLowerCase().endsWith(".ttc")) {
                if (str2 != null) {
                    LOGGER.error("You can't define an alias for a true type collection.");
                }
                String[] strArrEnumerateTTCNames = BaseFont.enumerateTTCNames(str);
                for (int i2 = 0; i2 < strArrEnumerateTTCNames.length; i2++) {
                    register(str + "," + i2);
                }
            } else if (str.toLowerCase().endsWith(".afm") || str.toLowerCase().endsWith(".pfm")) {
                BaseFont baseFontCreateFont = BaseFont.createFont(str, "Cp1252", false);
                String lowerCase4 = baseFontCreateFont.getFullFontName()[0][3].toLowerCase();
                String lowerCase5 = baseFontCreateFont.getFamilyFontName()[0][3].toLowerCase();
                String lowerCase6 = baseFontCreateFont.getPostscriptFontName().toLowerCase();
                registerFamily(lowerCase5, lowerCase4, null);
                this.trueTypeFonts.put(lowerCase6, str);
                this.trueTypeFonts.put(lowerCase4, str);
            }
            Logger logger = LOGGER;
            if (logger.isLogging(Level.TRACE)) {
                logger.trace(String.format("Registered %s", str));
            }
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public int registerDirectory(String str, boolean z) {
        String[] list;
        int i = 0;
        Logger logger = LOGGER;
        if (logger.isLogging(Level.DEBUG)) {
            logger.debug(String.format("Registering directory %s, looking for fonts", str));
        }
        try {
            File file = new File(str);
            if (!file.exists() || !file.isDirectory() || (list = file.list()) == null) {
                return 0;
            }
            int iRegisterDirectory = 0;
            for (String str2 : list) {
                try {
                    try {
                        File file2 = new File(str, str2);
                        if (!file2.isDirectory()) {
                            String path = file2.getPath();
                            String lowerCase = path.length() < 4 ? null : path.substring(path.length() - 4).toLowerCase();
                            if (".afm".equals(lowerCase) || ".pfm".equals(lowerCase)) {
                                if (new File(path.substring(0, path.length() - 4) + ".pfb").exists()) {
                                    register(path, null);
                                    iRegisterDirectory++;
                                }
                            } else if (".ttf".equals(lowerCase) || ".otf".equals(lowerCase) || ".ttc".equals(lowerCase)) {
                                register(path, null);
                                iRegisterDirectory++;
                            }
                        } else if (z) {
                            iRegisterDirectory += registerDirectory(file2.getAbsolutePath(), true);
                        }
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i = iRegisterDirectory;
                    return i;
                }
            }
            return iRegisterDirectory;
        } catch (Exception unused3) {
        }
    }

    public Font getFont(String str, String str2, boolean z, float f, int i) {
        return getFont(str, str2, z, f, i, null);
    }

    public Font getFont(String str, String str2, boolean z, float f) {
        return getFont(str, str2, z, f, -1, null);
    }

    public Font getFont(String str, String str2, boolean z) {
        return getFont(str, str2, z, -1.0f, -1, null);
    }

    public Font getFont(String str, String str2, float f, int i, BaseColor baseColor) {
        return getFont(str, str2, this.defaultEmbedding, f, i, baseColor);
    }

    public Font getFont(String str, String str2, float f, int i) {
        return getFont(str, str2, this.defaultEmbedding, f, i, null);
    }

    public Font getFont(String str, String str2, float f) {
        return getFont(str, str2, this.defaultEmbedding, f, -1, null);
    }

    public Font getFont(String str, float f, BaseColor baseColor) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, -1, baseColor);
    }

    public Font getFont(String str, String str2) {
        return getFont(str, str2, this.defaultEmbedding, -1.0f, -1, null);
    }

    public Font getFont(String str, float f, int i, BaseColor baseColor) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, i, baseColor);
    }

    public Font getFont(String str, float f, int i) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, i, null);
    }

    public Font getFont(String str, float f) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, -1, null);
    }

    public Font getFont(String str) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, -1.0f, -1, null);
    }
}
