package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Paragraph;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class PdfOutline extends PdfDictionary {
    private PdfAction action;
    private BaseColor color;
    private int count;
    private PdfDestination destination;
    protected ArrayList<PdfOutline> kids;
    private boolean open;
    private PdfOutline parent;
    private PdfIndirectReference reference;
    private int style;
    private String tag;
    protected PdfWriter writer;

    public PdfOutline(PdfWriter pdfWriter) {
        super(PdfDictionary.OUTLINES);
        this.count = 0;
        this.kids = new ArrayList<>();
        this.style = 0;
        this.open = true;
        this.parent = null;
        this.writer = pdfWriter;
    }

    public void addKid(PdfOutline pdfOutline) {
        this.kids.add(pdfOutline);
    }

    public BaseColor getColor() {
        return this.color;
    }

    public int getCount() {
        return this.count;
    }

    public ArrayList<PdfOutline> getKids() {
        return this.kids;
    }

    public PdfDestination getPdfDestination() {
        return this.destination;
    }

    public int getStyle() {
        return this.style;
    }

    public String getTag() {
        return this.tag;
    }

    public String getTitle() {
        return ((PdfString) get(PdfName.TITLE)).toString();
    }

    public PdfIndirectReference indirectReference() {
        return this.reference;
    }

    public void initOutline(PdfOutline pdfOutline, String str, boolean z) {
        this.open = z;
        this.parent = pdfOutline;
        this.writer = pdfOutline.writer;
        put(PdfName.TITLE, new PdfString(str, PdfObject.TEXT_UNICODE));
        pdfOutline.addKid(this);
        PdfDestination pdfDestination = this.destination;
        if (pdfDestination == null || pdfDestination.hasPage()) {
            return;
        }
        setDestinationPage(this.writer.getCurrentPage());
    }

    public boolean isOpen() {
        return this.open;
    }

    public int level() {
        PdfOutline pdfOutline = this.parent;
        if (pdfOutline == null) {
            return 0;
        }
        return pdfOutline.level() + 1;
    }

    public PdfOutline parent() {
        return this.parent;
    }

    public void setColor(BaseColor baseColor) {
        this.color = baseColor;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public boolean setDestinationPage(PdfIndirectReference pdfIndirectReference) {
        PdfDestination pdfDestination = this.destination;
        if (pdfDestination == null) {
            return false;
        }
        return pdfDestination.addPage(pdfIndirectReference);
    }

    public void setIndirectReference(PdfIndirectReference pdfIndirectReference) {
        this.reference = pdfIndirectReference;
    }

    public void setKids(ArrayList<PdfOutline> arrayList) {
        this.kids = arrayList;
    }

    public void setOpen(boolean z) {
        this.open = z;
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setTitle(String str) {
        put(PdfName.TITLE, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    @Override // com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) {
        BaseColor baseColor = this.color;
        if (baseColor != null && !baseColor.equals(BaseColor.BLACK)) {
            put(PdfName.C, new PdfArray(new float[]{this.color.getRed() / 255.0f, this.color.getGreen() / 255.0f, this.color.getBlue() / 255.0f}));
        }
        int i = this.style;
        int i2 = (i & 1) != 0 ? 2 : 0;
        if ((2 & i) != 0) {
            i2 |= 1;
        }
        if (i2 != 0) {
            put(PdfName.F, new PdfNumber(i2));
        }
        PdfOutline pdfOutline = this.parent;
        if (pdfOutline != null) {
            put(PdfName.PARENT, pdfOutline.indirectReference());
        }
        PdfDestination pdfDestination = this.destination;
        if (pdfDestination != null && pdfDestination.hasPage()) {
            put(PdfName.DEST, this.destination);
        }
        PdfAction pdfAction = this.action;
        if (pdfAction != null) {
            put(PdfName.A, pdfAction);
        }
        int i3 = this.count;
        if (i3 != 0) {
            put(PdfName.COUNT, new PdfNumber(i3));
        }
        super.toPdf(pdfWriter, outputStream);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, String str) {
        this(pdfOutline, pdfAction, str, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, String str, boolean z) {
        this.count = 0;
        this.kids = new ArrayList<>();
        this.style = 0;
        this.action = pdfAction;
        initOutline(pdfOutline, str, z);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, String str) {
        this(pdfOutline, pdfDestination, str, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, String str, boolean z) {
        this.count = 0;
        this.kids = new ArrayList<>();
        this.style = 0;
        this.destination = pdfDestination;
        initOutline(pdfOutline, str, z);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, PdfString pdfString) {
        this(pdfOutline, pdfAction, pdfString, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, PdfString pdfString, boolean z) {
        this(pdfOutline, pdfAction, pdfString.toString(), z);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, PdfString pdfString) {
        this(pdfOutline, pdfDestination, pdfString, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, PdfString pdfString, boolean z) {
        this(pdfOutline, pdfDestination, pdfString.toString(), true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, Paragraph paragraph) {
        this(pdfOutline, pdfAction, paragraph, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, Paragraph paragraph, boolean z) {
        this.count = 0;
        this.kids = new ArrayList<>();
        this.style = 0;
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Chunk> it = paragraph.getChunks().iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().getContent());
        }
        this.action = pdfAction;
        initOutline(pdfOutline, stringBuffer.toString(), z);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, Paragraph paragraph) {
        this(pdfOutline, pdfDestination, paragraph, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, Paragraph paragraph, boolean z) {
        this.count = 0;
        this.kids = new ArrayList<>();
        this.style = 0;
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Chunk> it = paragraph.getChunks().iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().getContent());
        }
        this.destination = pdfDestination;
        initOutline(pdfOutline, stringBuffer.toString(), z);
    }
}
