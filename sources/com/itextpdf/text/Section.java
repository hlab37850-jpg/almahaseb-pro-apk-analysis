package com.itextpdf.text;

import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class Section extends ArrayList<Element> implements TextElementArray, LargeElement, Indentable, IAccessibleElement {
    public static final int NUMBERSTYLE_DOTTED = 0;
    public static final int NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT = 1;
    private static final long serialVersionUID = 3324172577544748043L;
    protected String bookmarkTitle;
    protected float indentation;
    protected float indentationLeft;
    protected float indentationRight;
    protected int numberDepth;
    protected Paragraph title;
    protected int numberStyle = 0;
    protected boolean bookmarkOpen = true;
    protected boolean triggerNewPage = false;
    protected int subsections = 0;
    protected ArrayList<Integer> numbers = null;
    protected boolean complete = true;
    protected boolean addedCompletely = false;
    protected boolean notAddedYet = true;

    public Section() {
        Paragraph paragraph = new Paragraph();
        this.title = paragraph;
        this.numberDepth = 1;
        paragraph.setRole(new PdfName("H" + this.numberDepth));
    }

    public static Paragraph constructTitle(Paragraph paragraph, ArrayList<Integer> arrayList, int i, int i2) {
        if (paragraph == null) {
            return null;
        }
        int iMin = Math.min(arrayList.size(), i);
        if (iMin < 1) {
            return paragraph;
        }
        StringBuffer stringBuffer = new StringBuffer(" ");
        for (int i3 = 0; i3 < iMin; i3++) {
            stringBuffer.insert(0, ".");
            stringBuffer.insert(0, arrayList.get(i3).intValue());
        }
        if (i2 == 1) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 2);
        }
        Paragraph paragraph2 = new Paragraph(paragraph);
        paragraph2.add(0, (Element) new Chunk(stringBuffer.toString(), paragraph.getFont()));
        return paragraph2;
    }

    private void setNumbers(int i, ArrayList<Integer> arrayList) {
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        this.numbers = arrayList2;
        arrayList2.add(Integer.valueOf(i));
        this.numbers.addAll(arrayList);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Element> collection) {
        if (collection.size() == 0) {
            return false;
        }
        Iterator<? extends Element> it = collection.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return true;
    }

    public MarkedSection addMarkedSection() {
        MarkedSection markedSection = new MarkedSection(new Section(null, this.numberDepth + 1));
        add((Element) markedSection);
        return markedSection;
    }

    public Section addSection(float f, Paragraph paragraph, int i) {
        if (isAddedCompletely()) {
            throw new IllegalStateException(MessageLocalization.getComposedMessage("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
        }
        Section section = new Section(paragraph, i);
        section.setIndentation(f);
        add((Element) section);
        return section;
    }

    @Override // com.itextpdf.text.LargeElement
    public void flushContent() {
        setNotAddedYet(false);
        this.title = null;
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element next = it.next();
            if (next instanceof Section) {
                Section section = (Section) next;
                if (!section.isComplete() && size() == 1) {
                    section.flushContent();
                    return;
                }
                section.setAddedCompletely(true);
            }
            it.remove();
        }
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfObject getAccessibleAttribute(PdfName pdfName) {
        return this.title.getAccessibleAttribute(pdfName);
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public HashMap<PdfName, PdfObject> getAccessibleAttributes() {
        return this.title.getAccessibleAttributes();
    }

    public Paragraph getBookmarkTitle() {
        String str = this.bookmarkTitle;
        return str == null ? getTitle() : new Paragraph(str);
    }

    @Override // com.itextpdf.text.Element
    public java.util.List<Chunk> getChunks() {
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getChunks());
        }
        return arrayList;
    }

    public int getDepth() {
        return this.numbers.size();
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public AccessibleElementId getId() {
        return this.title.getId();
    }

    public float getIndentation() {
        return this.indentation;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationLeft() {
        return this.indentationLeft;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationRight() {
        return this.indentationRight;
    }

    public int getNumberDepth() {
        return this.numberDepth;
    }

    public int getNumberStyle() {
        return this.numberStyle;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return this.title.getRole();
    }

    public Paragraph getTitle() {
        return constructTitle(this.title, this.numbers, this.numberDepth, this.numberStyle);
    }

    public boolean isAddedCompletely() {
        return this.addedCompletely;
    }

    public boolean isBookmarkOpen() {
        return this.bookmarkOpen;
    }

    public boolean isChapter() {
        return type() == 16;
    }

    @Override // com.itextpdf.text.LargeElement
    public boolean isComplete() {
        return this.complete;
    }

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return true;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return false;
    }

    public boolean isNestable() {
        return false;
    }

    public boolean isNotAddedYet() {
        return this.notAddedYet;
    }

    public boolean isSection() {
        return type() == 13;
    }

    public boolean isTriggerNewPage() {
        return this.triggerNewPage && this.notAddedYet;
    }

    public void newPage() {
        add((Element) Chunk.NEXTPAGE);
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        try {
            Iterator<Element> it = iterator();
            while (it.hasNext()) {
                elementListener.add(it.next());
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setAccessibleAttribute(PdfName pdfName, PdfObject pdfObject) {
        this.title.setAccessibleAttribute(pdfName, pdfObject);
    }

    public void setAddedCompletely(boolean z) {
        this.addedCompletely = z;
    }

    public void setBookmarkOpen(boolean z) {
        this.bookmarkOpen = z;
    }

    public void setBookmarkTitle(String str) {
        this.bookmarkTitle = str;
    }

    public void setChapterNumber(int i) {
        ArrayList<Integer> arrayList = this.numbers;
        arrayList.set(arrayList.size() - 1, Integer.valueOf(i));
        for (Element element : this) {
            if (element instanceof Section) {
                ((Section) element).setChapterNumber(i);
            }
        }
    }

    @Override // com.itextpdf.text.LargeElement
    public void setComplete(boolean z) {
        this.complete = z;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setId(AccessibleElementId accessibleElementId) {
        this.title.setId(accessibleElementId);
    }

    public void setIndentation(float f) {
        this.indentation = f;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationLeft(float f) {
        this.indentationLeft = f;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationRight(float f) {
        this.indentationRight = f;
    }

    public void setNotAddedYet(boolean z) {
        this.notAddedYet = z;
    }

    public void setNumberDepth(int i) {
        this.numberDepth = i;
    }

    public void setNumberStyle(int i) {
        this.numberStyle = i;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
        this.title.setRole(pdfName);
    }

    public void setTitle(Paragraph paragraph) {
        this.title = paragraph;
    }

    public void setTriggerNewPage(boolean z) {
        this.triggerNewPage = z;
    }

    public int type() {
        return 13;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i, Element element) {
        if (!isAddedCompletely()) {
            try {
                if (element.isNestable()) {
                    super.add(i, element);
                    return;
                }
                throw new ClassCastException(MessageLocalization.getComposedMessage("you.can.t.add.a.1.to.a.section", element.getClass().getName()));
            } catch (ClassCastException e) {
                throw new ClassCastException(MessageLocalization.getComposedMessage("insertion.of.illegal.element.1", e.getMessage()));
            }
        }
        throw new IllegalStateException(MessageLocalization.getComposedMessage("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
    }

    public Section addSection(float f, Paragraph paragraph) {
        return addSection(f, paragraph, this.numberDepth + 1);
    }

    public Section addSection(Paragraph paragraph, int i) {
        return addSection(0.0f, paragraph, i);
    }

    public Section addSection(Paragraph paragraph) {
        return addSection(0.0f, paragraph, this.numberDepth + 1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Element element) {
        if (!isAddedCompletely()) {
            try {
                if (element.type() == 13) {
                    Section section = (Section) element;
                    int i = this.subsections + 1;
                    this.subsections = i;
                    section.setNumbers(i, this.numbers);
                    return super.add(section);
                }
                if ((element instanceof MarkedSection) && ((MarkedObject) element).element.type() == 13) {
                    MarkedSection markedSection = (MarkedSection) element;
                    Section section2 = (Section) markedSection.element;
                    int i2 = this.subsections + 1;
                    this.subsections = i2;
                    section2.setNumbers(i2, this.numbers);
                    return super.add(markedSection);
                }
                if (element.isNestable()) {
                    return super.add(element);
                }
                throw new ClassCastException(MessageLocalization.getComposedMessage("you.can.t.add.a.1.to.a.section", element.getClass().getName()));
            } catch (ClassCastException e) {
                throw new ClassCastException(MessageLocalization.getComposedMessage("insertion.of.illegal.element.1", e.getMessage()));
            }
        }
        throw new IllegalStateException(MessageLocalization.getComposedMessage("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
    }

    public Section addSection(float f, String str, int i) {
        return addSection(f, new Paragraph(str), i);
    }

    public Section addSection(String str, int i) {
        return addSection(new Paragraph(str), i);
    }

    public Section addSection(float f, String str) {
        return addSection(f, new Paragraph(str));
    }

    public Section addSection(String str) {
        return addSection(new Paragraph(str));
    }

    public Section(Paragraph paragraph, int i) {
        this.numberDepth = i;
        this.title = paragraph;
        if (paragraph != null) {
            paragraph.setRole(new PdfName("H" + i));
        }
    }
}
