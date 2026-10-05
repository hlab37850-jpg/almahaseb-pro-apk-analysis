package com.itextpdf.text.pdf.internal;

import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfBoolean;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;

/* JADX INFO: loaded from: classes3.dex */
public class PdfViewerPreferencesImp implements PdfViewerPreferences {
    private static final int viewerPreferencesMask = 16773120;
    private int pageLayoutAndMode = 0;
    private PdfDictionary viewerPreferences = new PdfDictionary();
    public static final PdfName[] VIEWER_PREFERENCES = {PdfName.HIDETOOLBAR, PdfName.HIDEMENUBAR, PdfName.HIDEWINDOWUI, PdfName.FITWINDOW, PdfName.CENTERWINDOW, PdfName.DISPLAYDOCTITLE, PdfName.NONFULLSCREENPAGEMODE, PdfName.DIRECTION, PdfName.VIEWAREA, PdfName.VIEWCLIP, PdfName.PRINTAREA, PdfName.PRINTCLIP, PdfName.PRINTSCALING, PdfName.DUPLEX, PdfName.PICKTRAYBYPDFSIZE, PdfName.PRINTPAGERANGE, PdfName.NUMCOPIES};
    public static final PdfName[] NONFULLSCREENPAGEMODE_PREFERENCES = {PdfName.USENONE, PdfName.USEOUTLINES, PdfName.USETHUMBS, PdfName.USEOC};
    public static final PdfName[] DIRECTION_PREFERENCES = {PdfName.L2R, PdfName.R2L};
    public static final PdfName[] PAGE_BOUNDARIES = {PdfName.MEDIABOX, PdfName.CROPBOX, PdfName.BLEEDBOX, PdfName.TRIMBOX, PdfName.ARTBOX};
    public static final PdfName[] PRINTSCALING_PREFERENCES = {PdfName.APPDEFAULT, PdfName.NONE};
    public static final PdfName[] DUPLEX_PREFERENCES = {PdfName.SIMPLEX, PdfName.DUPLEXFLIPSHORTEDGE, PdfName.DUPLEXFLIPLONGEDGE};

    private int getIndex(PdfName pdfName) {
        int i = 0;
        while (true) {
            PdfName[] pdfNameArr = VIEWER_PREFERENCES;
            if (i >= pdfNameArr.length) {
                return -1;
            }
            if (pdfNameArr[i].equals(pdfName)) {
                return i;
            }
            i++;
        }
    }

    private boolean isPossibleValue(PdfName pdfName, PdfName[] pdfNameArr) {
        for (PdfName pdfName2 : pdfNameArr) {
            if (pdfName2.equals(pdfName)) {
                return true;
            }
        }
        return false;
    }

    public void addToCatalog(PdfDictionary pdfDictionary) {
        PdfName pdfName = PdfName.PAGELAYOUT;
        pdfDictionary.remove(pdfName);
        int i = this.pageLayoutAndMode;
        if ((i & 1) != 0) {
            pdfDictionary.put(pdfName, PdfName.SINGLEPAGE);
        } else if ((i & 2) != 0) {
            pdfDictionary.put(pdfName, PdfName.ONECOLUMN);
        } else if ((i & 4) != 0) {
            pdfDictionary.put(pdfName, PdfName.TWOCOLUMNLEFT);
        } else if ((i & 8) != 0) {
            pdfDictionary.put(pdfName, PdfName.TWOCOLUMNRIGHT);
        } else if ((i & 16) != 0) {
            pdfDictionary.put(pdfName, PdfName.TWOPAGELEFT);
        } else if ((i & 32) != 0) {
            pdfDictionary.put(pdfName, PdfName.TWOPAGERIGHT);
        }
        PdfName pdfName2 = PdfName.PAGEMODE;
        pdfDictionary.remove(pdfName2);
        int i2 = this.pageLayoutAndMode;
        if ((i2 & 64) != 0) {
            pdfDictionary.put(pdfName2, PdfName.USENONE);
        } else if ((i2 & 128) != 0) {
            pdfDictionary.put(pdfName2, PdfName.USEOUTLINES);
        } else if ((i2 & 256) != 0) {
            pdfDictionary.put(pdfName2, PdfName.USETHUMBS);
        } else if ((i2 & 512) != 0) {
            pdfDictionary.put(pdfName2, PdfName.FULLSCREEN);
        } else if ((i2 & 1024) != 0) {
            pdfDictionary.put(pdfName2, PdfName.USEOC);
        } else if ((i2 & 2048) != 0) {
            pdfDictionary.put(pdfName2, PdfName.USEATTACHMENTS);
        }
        PdfName pdfName3 = PdfName.VIEWERPREFERENCES;
        pdfDictionary.remove(pdfName3);
        if (this.viewerPreferences.size() > 0) {
            pdfDictionary.put(pdfName3, this.viewerPreferences);
        }
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        switch (getIndex(pdfName)) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 14:
                if (pdfObject instanceof PdfBoolean) {
                    this.viewerPreferences.put(pdfName, pdfObject);
                }
                break;
            case 6:
                if ((pdfObject instanceof PdfName) && isPossibleValue((PdfName) pdfObject, NONFULLSCREENPAGEMODE_PREFERENCES)) {
                    this.viewerPreferences.put(pdfName, pdfObject);
                    break;
                }
                break;
            case 7:
                if ((pdfObject instanceof PdfName) && isPossibleValue((PdfName) pdfObject, DIRECTION_PREFERENCES)) {
                    this.viewerPreferences.put(pdfName, pdfObject);
                    break;
                }
                break;
            case 8:
            case 9:
            case 10:
            case 11:
                if ((pdfObject instanceof PdfName) && isPossibleValue((PdfName) pdfObject, PAGE_BOUNDARIES)) {
                    this.viewerPreferences.put(pdfName, pdfObject);
                    break;
                }
                break;
            case 12:
                if ((pdfObject instanceof PdfName) && isPossibleValue((PdfName) pdfObject, PRINTSCALING_PREFERENCES)) {
                    this.viewerPreferences.put(pdfName, pdfObject);
                    break;
                }
                break;
            case 13:
                if ((pdfObject instanceof PdfName) && isPossibleValue((PdfName) pdfObject, DUPLEX_PREFERENCES)) {
                    this.viewerPreferences.put(pdfName, pdfObject);
                    break;
                }
                break;
            case 15:
                if (pdfObject instanceof PdfArray) {
                    this.viewerPreferences.put(pdfName, pdfObject);
                }
                break;
            case 16:
                if (pdfObject instanceof PdfNumber) {
                    this.viewerPreferences.put(pdfName, pdfObject);
                }
                break;
        }
    }

    public int getPageLayoutAndMode() {
        return this.pageLayoutAndMode;
    }

    public PdfDictionary getViewerPreferences() {
        return this.viewerPreferences;
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void setViewerPreferences(int i) {
        int i2 = this.pageLayoutAndMode | i;
        this.pageLayoutAndMode = i2;
        if ((viewerPreferencesMask & i) != 0) {
            this.pageLayoutAndMode = i2 & (-16773121);
            if ((i & 4096) != 0) {
                this.viewerPreferences.put(PdfName.HIDETOOLBAR, PdfBoolean.PDFTRUE);
            }
            if ((i & 8192) != 0) {
                this.viewerPreferences.put(PdfName.HIDEMENUBAR, PdfBoolean.PDFTRUE);
            }
            if ((i & 16384) != 0) {
                this.viewerPreferences.put(PdfName.HIDEWINDOWUI, PdfBoolean.PDFTRUE);
            }
            if ((32768 & i) != 0) {
                this.viewerPreferences.put(PdfName.FITWINDOW, PdfBoolean.PDFTRUE);
            }
            if ((65536 & i) != 0) {
                this.viewerPreferences.put(PdfName.CENTERWINDOW, PdfBoolean.PDFTRUE);
            }
            if ((131072 & i) != 0) {
                this.viewerPreferences.put(PdfName.DISPLAYDOCTITLE, PdfBoolean.PDFTRUE);
            }
            if ((262144 & i) != 0) {
                this.viewerPreferences.put(PdfName.NONFULLSCREENPAGEMODE, PdfName.USENONE);
            } else if ((524288 & i) != 0) {
                this.viewerPreferences.put(PdfName.NONFULLSCREENPAGEMODE, PdfName.USEOUTLINES);
            } else if ((1048576 & i) != 0) {
                this.viewerPreferences.put(PdfName.NONFULLSCREENPAGEMODE, PdfName.USETHUMBS);
            } else if ((2097152 & i) != 0) {
                this.viewerPreferences.put(PdfName.NONFULLSCREENPAGEMODE, PdfName.USEOC);
            }
            if ((4194304 & i) != 0) {
                this.viewerPreferences.put(PdfName.DIRECTION, PdfName.L2R);
            } else if ((8388608 & i) != 0) {
                this.viewerPreferences.put(PdfName.DIRECTION, PdfName.R2L);
            }
            if ((i & 16777216) != 0) {
                this.viewerPreferences.put(PdfName.PRINTSCALING, PdfName.NONE);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    public static PdfViewerPreferencesImp getViewerPreferences(PdfDictionary pdfDictionary) {
        int i;
        PdfViewerPreferencesImp pdfViewerPreferencesImp = new PdfViewerPreferencesImp();
        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.PAGELAYOUT));
        int i2 = 0;
        if (pdfObjectRelease == null || !pdfObjectRelease.isName()) {
            i = 0;
        } else {
            PdfName pdfName = (PdfName) pdfObjectRelease;
            if (pdfName.equals(PdfName.SINGLEPAGE)) {
                i = 1;
            } else if (pdfName.equals(PdfName.ONECOLUMN)) {
                i = 2;
            } else if (pdfName.equals(PdfName.TWOCOLUMNLEFT)) {
                i = 4;
            } else if (pdfName.equals(PdfName.TWOCOLUMNRIGHT)) {
                i = 8;
            } else if (pdfName.equals(PdfName.TWOPAGELEFT)) {
                i = 16;
            } else if (pdfName.equals(PdfName.TWOPAGERIGHT)) {
                i = 32;
            } else {
                i = 0;
            }
        }
        PdfObject pdfObjectRelease2 = PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.PAGEMODE));
        if (pdfObjectRelease2 != null && pdfObjectRelease2.isName()) {
            PdfName pdfName2 = (PdfName) pdfObjectRelease2;
            if (pdfName2.equals(PdfName.USENONE)) {
                i |= 64;
            } else if (pdfName2.equals(PdfName.USEOUTLINES)) {
                i |= 128;
            } else if (pdfName2.equals(PdfName.USETHUMBS)) {
                i |= 256;
            } else if (pdfName2.equals(PdfName.FULLSCREEN)) {
                i |= 512;
            } else if (pdfName2.equals(PdfName.USEOC)) {
                i |= 1024;
            } else if (pdfName2.equals(PdfName.USEATTACHMENTS)) {
                i |= 2048;
            }
        }
        pdfViewerPreferencesImp.setViewerPreferences(i);
        PdfObject pdfObjectRelease3 = PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.VIEWERPREFERENCES));
        if (pdfObjectRelease3 != null && pdfObjectRelease3.isDictionary()) {
            PdfDictionary pdfDictionary2 = (PdfDictionary) pdfObjectRelease3;
            while (true) {
                PdfName[] pdfNameArr = VIEWER_PREFERENCES;
                if (i2 >= pdfNameArr.length) {
                    break;
                }
                pdfViewerPreferencesImp.addViewerPreference(pdfNameArr[i2], PdfReader.getPdfObjectRelease(pdfDictionary2.get(pdfNameArr[i2])));
                i2++;
            }
        }
        return pdfViewerPreferencesImp;
    }
}
