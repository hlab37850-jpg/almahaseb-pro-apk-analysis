package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class PdfPages {
    private PdfIndirectReference topParent;
    private PdfWriter writer;
    private ArrayList<PdfIndirectReference> pages = new ArrayList<>();
    private ArrayList<PdfIndirectReference> parents = new ArrayList<>();
    private int leafSize = 10;

    public PdfPages(PdfWriter pdfWriter) {
        this.writer = pdfWriter;
    }

    public void addPage(PdfDictionary pdfDictionary) {
        try {
            if (this.pages.size() % this.leafSize == 0) {
                this.parents.add(this.writer.getPdfIndirectReference());
            }
            ArrayList<PdfIndirectReference> arrayList = this.parents;
            pdfDictionary.put(PdfName.PARENT, arrayList.get(arrayList.size() - 1));
            PdfIndirectReference currentPage = this.writer.getCurrentPage();
            this.writer.addToBody(pdfDictionary, currentPage);
            this.pages.add(currentPage);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public PdfIndirectReference addPageRef(PdfIndirectReference pdfIndirectReference) {
        try {
            if (this.pages.size() % this.leafSize == 0) {
                this.parents.add(this.writer.getPdfIndirectReference());
            }
            this.pages.add(pdfIndirectReference);
            ArrayList<PdfIndirectReference> arrayList = this.parents;
            return arrayList.get(arrayList.size() - 1);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public PdfIndirectReference getTopParent() {
        return this.topParent;
    }

    public int reorderPages(int[] iArr) throws DocumentException {
        if (iArr == null) {
            return this.pages.size();
        }
        if (this.parents.size() > 1) {
            throw new DocumentException(MessageLocalization.getComposedMessage("page.reordering.requires.a.single.parent.in.the.page.tree.call.pdfwriter.setlinearmode.after.open", new Object[0]));
        }
        if (iArr.length != this.pages.size()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("page.reordering.requires.an.array.with.the.same.size.as.the.number.of.pages", new Object[0]));
        }
        int size = this.pages.size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            int i2 = iArr[i];
            if (i2 < 1 || i2 > size) {
                throw new DocumentException(MessageLocalization.getComposedMessage("page.reordering.requires.pages.between.1.and.1.found.2", String.valueOf(size), String.valueOf(i2)));
            }
            int i3 = i2 - 1;
            if (zArr[i3]) {
                throw new DocumentException(MessageLocalization.getComposedMessage("page.reordering.requires.no.page.repetition.page.1.is.repeated", i2));
            }
            zArr[i3] = true;
        }
        ArrayList<PdfIndirectReference> arrayList = this.pages;
        PdfIndirectReference[] pdfIndirectReferenceArr = (PdfIndirectReference[]) arrayList.toArray(new PdfIndirectReference[arrayList.size()]);
        for (int i4 = 0; i4 < size; i4++) {
            this.pages.set(i4, pdfIndirectReferenceArr[iArr[i4] - 1]);
        }
        return size;
    }

    public void setLinearMode(PdfIndirectReference pdfIndirectReference) {
        if (this.parents.size() > 1) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("linear.page.mode.can.only.be.called.with.a.single.parent", new Object[0]));
        }
        if (pdfIndirectReference != null) {
            this.topParent = pdfIndirectReference;
            this.parents.clear();
            this.parents.add(pdfIndirectReference);
        }
        this.leafSize = 10000000;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public PdfIndirectReference writePageTree() throws IOException {
        int size;
        int i;
        if (this.pages.isEmpty()) {
            throw new IOException(MessageLocalization.getComposedMessage("the.document.has.no.pages", new Object[0]));
        }
        ArrayList<PdfIndirectReference> arrayList = this.parents;
        ArrayList<PdfIndirectReference> arrayList2 = this.pages;
        ArrayList<PdfIndirectReference> arrayList3 = new ArrayList<>();
        int i2 = 1;
        while (true) {
            int i3 = this.leafSize;
            i2 *= i3;
            int size2 = arrayList2.size();
            int i4 = this.leafSize;
            int i5 = size2 % i4;
            if (i5 != 0) {
                i4 = i5;
            }
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                if (i6 == arrayList.size() - 1) {
                    size = this.pages.size() % i2;
                    if (size == 0) {
                        size = i2;
                    }
                    i = i4;
                } else {
                    size = i2;
                    i = i3;
                }
                PdfDictionary pdfDictionary = new PdfDictionary(PdfName.PAGES);
                pdfDictionary.put(PdfName.COUNT, new PdfNumber(size));
                PdfArray pdfArray = new PdfArray();
                int i7 = i6 * i3;
                pdfArray.getArrayList().addAll(arrayList2.subList(i7, i + i7));
                pdfDictionary.put(PdfName.KIDS, pdfArray);
                if (arrayList.size() > 1) {
                    if (i6 % this.leafSize == 0) {
                        arrayList3.add(this.writer.getPdfIndirectReference());
                    }
                    pdfDictionary.put(PdfName.PARENT, arrayList3.get(i6 / this.leafSize));
                }
                this.writer.addToBody(pdfDictionary, arrayList.get(i6));
            }
            if (arrayList.size() == 1) {
                PdfIndirectReference pdfIndirectReference = arrayList.get(0);
                this.topParent = pdfIndirectReference;
                return pdfIndirectReference;
            }
            arrayList2 = arrayList;
            arrayList = arrayList3;
            arrayList3 = new ArrayList<>();
        }
    }

    public void addPage(PdfIndirectReference pdfIndirectReference) {
        this.pages.add(pdfIndirectReference);
    }
}
