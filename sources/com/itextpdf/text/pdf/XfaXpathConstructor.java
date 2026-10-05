package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.security.XpathConstructor;
import com.itextpdf.text.xml.xmp.PdfSchema;
import com.itextpdf.xmp.XMPConst;

/* JADX INFO: loaded from: classes3.dex */
public class XfaXpathConstructor implements XpathConstructor {
    private final String CONFIG;
    private final String CONNECTIONSET;
    private final String DATASETS;
    private final String LOCALESET;
    private final String PDF;
    private final String SOURCESET;
    private final String STYLESHEET;
    private final String TEMPLATE;
    private final String XDC;
    private final String XFDF;
    private final String XMPMETA;
    private String xpathExpression;

    /* JADX INFO: renamed from: com.itextpdf.text.pdf.XfaXpathConstructor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$XfaXpathConstructor$XdpPackage;

        static {
            int[] iArr = new int[XdpPackage.values().length];
            $SwitchMap$com$itextpdf$text$pdf$XfaXpathConstructor$XdpPackage = iArr;
            try {
                iArr[XdpPackage.Config.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$XfaXpathConstructor$XdpPackage[XdpPackage.ConnectionSet.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$XfaXpathConstructor$XdpPackage[XdpPackage.Datasets.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$XfaXpathConstructor$XdpPackage[XdpPackage.LocaleSet.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$XfaXpathConstructor$XdpPackage[XdpPackage.Pdf.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$XfaXpathConstructor$XdpPackage[XdpPackage.SourceSet.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$XfaXpathConstructor$XdpPackage[XdpPackage.Stylesheet.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$XfaXpathConstructor$XdpPackage[XdpPackage.Template.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$XfaXpathConstructor$XdpPackage[XdpPackage.Xdc.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$XfaXpathConstructor$XdpPackage[XdpPackage.Xfdf.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$XfaXpathConstructor$XdpPackage[XdpPackage.Xmpmeta.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public enum XdpPackage {
        Config,
        ConnectionSet,
        Datasets,
        LocaleSet,
        Pdf,
        SourceSet,
        Stylesheet,
        Template,
        Xdc,
        Xfdf,
        Xmpmeta
    }

    public XfaXpathConstructor() {
        this.CONFIG = "config";
        this.CONNECTIONSET = "connectionSet";
        this.DATASETS = "datasets";
        this.LOCALESET = "localeSet";
        this.PDF = PdfSchema.DEFAULT_XPATH_ID;
        this.SOURCESET = "sourceSet";
        this.STYLESHEET = "stylesheet";
        this.TEMPLATE = "template";
        this.XDC = "xdc";
        this.XFDF = "xfdf";
        this.XMPMETA = XMPConst.TAG_XMPMETA;
        this.xpathExpression = "";
    }

    @Override // com.itextpdf.text.pdf.security.XpathConstructor
    public String getXpathExpression() {
        return this.xpathExpression;
    }

    public XfaXpathConstructor(XdpPackage xdpPackage) {
        String str = "config";
        this.CONFIG = "config";
        this.CONNECTIONSET = "connectionSet";
        this.DATASETS = "datasets";
        this.LOCALESET = "localeSet";
        this.PDF = PdfSchema.DEFAULT_XPATH_ID;
        this.SOURCESET = "sourceSet";
        this.STYLESHEET = "stylesheet";
        this.TEMPLATE = "template";
        this.XDC = "xdc";
        this.XFDF = "xfdf";
        this.XMPMETA = XMPConst.TAG_XMPMETA;
        switch (AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$XfaXpathConstructor$XdpPackage[xdpPackage.ordinal()]) {
            case 1:
                break;
            case 2:
                str = "connectionSet";
                break;
            case 3:
                str = "datasets";
                break;
            case 4:
                str = "localeSet";
                break;
            case 5:
                str = PdfSchema.DEFAULT_XPATH_ID;
                break;
            case 6:
                str = "sourceSet";
                break;
            case 7:
                str = "stylesheet";
                break;
            case 8:
                str = "template";
                break;
            case 9:
                str = "xdc";
                break;
            case 10:
                str = "xfdf";
                break;
            case 11:
                str = XMPConst.TAG_XMPMETA;
                break;
            default:
                this.xpathExpression = "";
                return;
        }
        this.xpathExpression = "/xdp:xdp/*[local-name()='" + str + "']";
    }
}
