package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.collection.PdfTargetDictionary;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class PdfAction extends PdfDictionary {
    public static final int FIRSTPAGE = 1;
    public static final int LASTPAGE = 4;
    public static final int NEXTPAGE = 3;
    public static final int PREVPAGE = 2;
    public static final int PRINTDIALOG = 5;
    public static final int RESET_EXCLUDE = 1;
    public static final int SUBMIT_CANONICAL_FORMAT = 512;
    public static final int SUBMIT_COORDINATES = 16;
    public static final int SUBMIT_EMBED_FORM = 8196;
    public static final int SUBMIT_EXCLUDE = 1;
    public static final int SUBMIT_EXCL_F_KEY = 2048;
    public static final int SUBMIT_EXCL_NON_USER_ANNOTS = 1024;
    public static final int SUBMIT_HTML_FORMAT = 4;
    public static final int SUBMIT_HTML_GET = 8;
    public static final int SUBMIT_INCLUDE_ANNOTATIONS = 128;
    public static final int SUBMIT_INCLUDE_APPEND_SAVES = 64;
    public static final int SUBMIT_INCLUDE_NO_VALUE_FIELDS = 2;
    public static final int SUBMIT_PDF = 256;
    public static final int SUBMIT_XFDF = 32;

    public PdfAction() {
    }

    public static PdfArray buildArray(Object[] objArr) {
        PdfArray pdfArray = new PdfArray();
        for (Object obj : objArr) {
            if (obj instanceof String) {
                pdfArray.add(new PdfString((String) obj));
            } else {
                if (!(obj instanceof PdfAnnotation)) {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("the.array.must.contain.string.or.pdfannotation", new Object[0]));
                }
                pdfArray.add(((PdfAnnotation) obj).getIndirectReference());
            }
        }
        return pdfArray;
    }

    public static PdfAction createHide(PdfObject pdfObject, boolean z) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.S, PdfName.HIDE);
        pdfAction.put(PdfName.T, pdfObject);
        if (!z) {
            pdfAction.put(PdfName.H, PdfBoolean.PDFFALSE);
        }
        return pdfAction;
    }

    public static PdfAction createImportData(String str) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.S, PdfName.IMPORTDATA);
        pdfAction.put(PdfName.F, new PdfString(str));
        return pdfAction;
    }

    public static PdfAction createLaunch(String str, String str2, String str3, String str4) {
        return new PdfAction(str, str2, str3, str4);
    }

    public static PdfAction createResetForm(Object[] objArr, int i) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.S, PdfName.RESETFORM);
        if (objArr != null) {
            pdfAction.put(PdfName.FIELDS, buildArray(objArr));
        }
        pdfAction.put(PdfName.FLAGS, new PdfNumber(i));
        return pdfAction;
    }

    public static PdfAction createSubmitForm(String str, Object[] objArr, int i) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.S, PdfName.SUBMITFORM);
        PdfDictionary pdfDictionary = new PdfDictionary();
        PdfName pdfName = PdfName.F;
        pdfDictionary.put(pdfName, new PdfString(str));
        pdfDictionary.put(PdfName.FS, PdfName.URL);
        pdfAction.put(pdfName, pdfDictionary);
        if (objArr != null) {
            pdfAction.put(PdfName.FIELDS, buildArray(objArr));
        }
        pdfAction.put(PdfName.FLAGS, new PdfNumber(i));
        return pdfAction;
    }

    public static PdfAction gotoEmbedded(String str, PdfTargetDictionary pdfTargetDictionary, String str2, boolean z, boolean z2) {
        return z ? gotoEmbedded(str, pdfTargetDictionary, new PdfName(str2), z2) : gotoEmbedded(str, pdfTargetDictionary, new PdfString(str2, PdfObject.TEXT_UNICODE), z2);
    }

    public static PdfAction gotoLocalPage(int i, PdfDestination pdfDestination, PdfWriter pdfWriter) {
        PdfIndirectReference pageReference = pdfWriter.getPageReference(i);
        PdfDestination pdfDestination2 = new PdfDestination(pdfDestination);
        pdfDestination2.addPage(pageReference);
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.S, PdfName.GOTO);
        pdfAction.put(PdfName.D, pdfDestination2);
        return pdfAction;
    }

    public static PdfAction gotoRemotePage(String str, String str2, boolean z, boolean z2) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.F, new PdfString(str));
        pdfAction.put(PdfName.S, PdfName.GOTOR);
        if (z) {
            pdfAction.put(PdfName.D, new PdfName(str2));
        } else {
            pdfAction.put(PdfName.D, new PdfString(str2, PdfObject.TEXT_UNICODE));
        }
        if (z2) {
            pdfAction.put(PdfName.NEWWINDOW, PdfBoolean.PDFTRUE);
        }
        return pdfAction;
    }

    public static PdfAction javaScript(String str, PdfWriter pdfWriter, boolean z) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.S, PdfName.JAVASCRIPT);
        String str2 = PdfObject.TEXT_UNICODE;
        if (z && str.length() < 50) {
            pdfAction.put(PdfName.JS, new PdfString(str, PdfObject.TEXT_UNICODE));
        } else if (z || str.length() >= 100) {
            if (!z) {
                str2 = PdfObject.TEXT_PDFDOCENCODING;
            }
            try {
                PdfStream pdfStream = new PdfStream(PdfEncodings.convertToBytes(str, str2));
                pdfStream.flateCompress(pdfWriter.getCompressionLevel());
                pdfAction.put(PdfName.JS, pdfWriter.addToBody(pdfStream).getIndirectReference());
            } catch (Exception unused) {
                pdfAction.put(PdfName.JS, new PdfString(str));
            }
        } else {
            pdfAction.put(PdfName.JS, new PdfString(str));
        }
        return pdfAction;
    }

    public static PdfAction rendition(String str, PdfFileSpecification pdfFileSpecification, String str2, PdfIndirectReference pdfIndirectReference) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.S, PdfName.RENDITION);
        pdfAction.put(PdfName.R, new PdfRendition(str, pdfFileSpecification, str2));
        pdfAction.put(new PdfName("OP"), new PdfNumber(0));
        pdfAction.put(new PdfName("AN"), pdfIndirectReference);
        return pdfAction;
    }

    public static PdfAction setOCGstate(ArrayList<Object> arrayList, boolean z) {
        PdfName pdfName;
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.S, PdfName.SETOCGSTATE);
        PdfArray pdfArray = new PdfArray();
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj != null) {
                if (obj instanceof PdfIndirectReference) {
                    pdfArray.add((PdfIndirectReference) obj);
                } else if (obj instanceof PdfLayer) {
                    pdfArray.add(((PdfLayer) obj).getRef());
                } else if (obj instanceof PdfName) {
                    pdfArray.add((PdfName) obj);
                } else {
                    if (!(obj instanceof String)) {
                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.type.was.passed.in.state.1", obj.getClass().getName()));
                    }
                    String str = (String) obj;
                    if (str.equalsIgnoreCase("on")) {
                        pdfName = PdfName.ON;
                    } else if (str.equalsIgnoreCase("off")) {
                        pdfName = PdfName.OFF;
                    } else {
                        if (!str.equalsIgnoreCase("toggle")) {
                            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("a.string.1.was.passed.in.state.only.on.off.and.toggle.are.allowed", str));
                        }
                        pdfName = PdfName.TOGGLE;
                    }
                    pdfArray.add(pdfName);
                }
            }
        }
        pdfAction.put(PdfName.STATE, pdfArray);
        if (!z) {
            pdfAction.put(PdfName.PRESERVERB, PdfBoolean.PDFFALSE);
        }
        return pdfAction;
    }

    public void next(PdfAction pdfAction) {
        PdfName pdfName = PdfName.NEXT;
        PdfObject pdfObject = get(pdfName);
        if (pdfObject == null) {
            put(pdfName, pdfAction);
        } else {
            if (!pdfObject.isDictionary()) {
                ((PdfArray) pdfObject).add(pdfAction);
                return;
            }
            PdfArray pdfArray = new PdfArray(pdfObject);
            pdfArray.add(pdfAction);
            put(pdfName, pdfArray);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) {
        PdfWriter.checkPdfIsoConformance(pdfWriter, 14, this);
        super.toPdf(pdfWriter, outputStream);
    }

    public PdfAction(URL url) {
        this(url.toExternalForm());
    }

    public PdfAction(URL url, boolean z) {
        this(url.toExternalForm(), z);
    }

    public static PdfAction gotoEmbedded(String str, PdfTargetDictionary pdfTargetDictionary, PdfObject pdfObject, boolean z) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.S, PdfName.GOTOE);
        pdfAction.put(PdfName.T, pdfTargetDictionary);
        pdfAction.put(PdfName.D, pdfObject);
        pdfAction.put(PdfName.NEWWINDOW, new PdfBoolean(z));
        if (str != null) {
            pdfAction.put(PdfName.F, new PdfString(str));
        }
        return pdfAction;
    }

    public PdfAction(String str) {
        this(str, false);
    }

    public PdfAction(String str, boolean z) {
        PdfName pdfName = PdfName.S;
        PdfName pdfName2 = PdfName.URI;
        put(pdfName, pdfName2);
        put(pdfName2, new PdfString(str));
        if (z) {
            put(PdfName.ISMAP, PdfBoolean.PDFTRUE);
        }
    }

    public static PdfAction createHide(PdfAnnotation pdfAnnotation, boolean z) {
        return createHide(pdfAnnotation.getIndirectReference(), z);
    }

    public static PdfAction createHide(String str, boolean z) {
        return createHide(new PdfString(str), z);
    }

    public static PdfAction createHide(Object[] objArr, boolean z) {
        return createHide(buildArray(objArr), z);
    }

    public static PdfAction gotoLocalPage(String str, boolean z) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.put(PdfName.S, PdfName.GOTO);
        if (z) {
            pdfAction.put(PdfName.D, new PdfName(str));
        } else {
            pdfAction.put(PdfName.D, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
        return pdfAction;
    }

    public PdfAction(PdfIndirectReference pdfIndirectReference) {
        put(PdfName.S, PdfName.GOTO);
        put(PdfName.D, pdfIndirectReference);
    }

    public PdfAction(String str, String str2) {
        put(PdfName.S, PdfName.GOTOR);
        put(PdfName.F, new PdfString(str));
        put(PdfName.D, new PdfString(str2));
    }

    public static PdfAction javaScript(String str, PdfWriter pdfWriter) {
        return javaScript(str, pdfWriter, false);
    }

    public PdfAction(String str, int i) {
        put(PdfName.S, PdfName.GOTOR);
        put(PdfName.F, new PdfString(str));
        PdfName pdfName = PdfName.D;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(i - 1);
        sb.append(" /FitH 10000]");
        put(pdfName, new PdfLiteral(sb.toString()));
    }

    public PdfAction(int i) {
        PdfName pdfName = PdfName.S;
        put(pdfName, PdfName.NAMED);
        if (i == 1) {
            put(PdfName.N, PdfName.FIRSTPAGE);
            return;
        }
        if (i == 2) {
            put(PdfName.N, PdfName.PREVPAGE);
            return;
        }
        if (i == 3) {
            put(PdfName.N, PdfName.NEXTPAGE);
            return;
        }
        if (i == 4) {
            put(PdfName.N, PdfName.LASTPAGE);
        } else {
            if (i == 5) {
                put(pdfName, PdfName.JAVASCRIPT);
                put(PdfName.JS, new PdfString("this.print(true);\r"));
                return;
            }
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.named.action", new Object[0]));
        }
    }

    public PdfAction(String str, String str2, String str3, String str4) {
        put(PdfName.S, PdfName.LAUNCH);
        if (str2 == null && str3 == null && str4 == null) {
            put(PdfName.F, new PdfString(str));
            return;
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.F, new PdfString(str));
        if (str2 != null) {
            pdfDictionary.put(PdfName.P, new PdfString(str2));
        }
        if (str3 != null) {
            pdfDictionary.put(PdfName.O, new PdfString(str3));
        }
        if (str4 != null) {
            pdfDictionary.put(PdfName.D, new PdfString(str4));
        }
        put(PdfName.WIN, pdfDictionary);
    }
}
