package com.itextpdf.text;

import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.factories.RomanAlphabetFactory;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class List implements TextElementArray, Indentable, IAccessibleElement {
    public static final boolean ALPHABETICAL = true;
    public static final boolean LOWERCASE = true;
    public static final boolean NUMERICAL = false;
    public static final boolean ORDERED = true;
    public static final boolean UNORDERED = false;
    public static final boolean UPPERCASE = false;
    protected HashMap<PdfName, PdfObject> accessibleAttributes;
    protected boolean alignindent;
    protected boolean autoindent;
    protected int first;
    private AccessibleElementId id;
    protected float indentationLeft;
    protected float indentationRight;
    protected boolean lettered;
    protected ArrayList<Element> list;
    protected boolean lowercase;
    protected boolean numbered;
    protected String postSymbol;
    protected String preSymbol;
    protected PdfName role;
    protected Chunk symbol;
    protected float symbolIndent;

    public List() {
        this(false, false);
    }

    public boolean add(String str) {
        if (str != null) {
            return add(new ListItem(str));
        }
        return false;
    }

    public List cloneShallow() {
        List list = new List();
        populateProperties(list);
        return list;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfObject getAccessibleAttribute(PdfName pdfName) {
        HashMap<PdfName, PdfObject> map = this.accessibleAttributes;
        if (map != null) {
            return map.get(pdfName);
        }
        return null;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public HashMap<PdfName, PdfObject> getAccessibleAttributes() {
        return this.accessibleAttributes;
    }

    @Override // com.itextpdf.text.Element
    public java.util.List<Chunk> getChunks() {
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = this.list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getChunks());
        }
        return arrayList;
    }

    public int getFirst() {
        return this.first;
    }

    public ListItem getFirstItem() {
        Element element = this.list.size() > 0 ? this.list.get(0) : null;
        if (element != null) {
            if (element instanceof ListItem) {
                return (ListItem) element;
            }
            if (element instanceof List) {
                return ((List) element).getFirstItem();
            }
        }
        return null;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public AccessibleElementId getId() {
        if (this.id == null) {
            this.id = new AccessibleElementId();
        }
        return this.id;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationLeft() {
        return this.indentationLeft;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationRight() {
        return this.indentationRight;
    }

    public ArrayList<Element> getItems() {
        return this.list;
    }

    public ListItem getLastItem() {
        Element element;
        if (this.list.size() > 0) {
            ArrayList<Element> arrayList = this.list;
            element = arrayList.get(arrayList.size() - 1);
        } else {
            element = null;
        }
        if (element != null) {
            if (element instanceof ListItem) {
                return (ListItem) element;
            }
            if (element instanceof List) {
                return ((List) element).getLastItem();
            }
        }
        return null;
    }

    public String getPostSymbol() {
        return this.postSymbol;
    }

    public String getPreSymbol() {
        return this.preSymbol;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return this.role;
    }

    public Chunk getSymbol() {
        return this.symbol;
    }

    public float getSymbolIndent() {
        return this.symbolIndent;
    }

    public float getTotalLeading() {
        if (this.list.size() < 1) {
            return -1.0f;
        }
        return ((ListItem) this.list.get(0)).getTotalLeading();
    }

    public boolean isAlignindent() {
        return this.alignindent;
    }

    public boolean isAutoindent() {
        return this.autoindent;
    }

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return true;
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return false;
    }

    public boolean isLettered() {
        return this.lettered;
    }

    public boolean isLowercase() {
        return this.lowercase;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return true;
    }

    public boolean isNumbered() {
        return this.numbered;
    }

    public void normalizeIndentation() {
        float fMax = 0.0f;
        for (Element element : this.list) {
            if (element instanceof ListItem) {
                fMax = Math.max(fMax, ((ListItem) element).getIndentationLeft());
            }
        }
        for (Element element2 : this.list) {
            if (element2 instanceof ListItem) {
                ((ListItem) element2).setIndentationLeft(fMax);
            }
        }
    }

    public void populateProperties(List list) {
        list.indentationLeft = this.indentationLeft;
        list.indentationRight = this.indentationRight;
        list.autoindent = this.autoindent;
        list.alignindent = this.alignindent;
        list.symbolIndent = this.symbolIndent;
        list.symbol = this.symbol;
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        try {
            Iterator<Element> it = this.list.iterator();
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
        if (this.accessibleAttributes == null) {
            this.accessibleAttributes = new HashMap<>();
        }
        this.accessibleAttributes.put(pdfName, pdfObject);
    }

    public void setAlignindent(boolean z) {
        this.alignindent = z;
    }

    public void setAutoindent(boolean z) {
        this.autoindent = z;
    }

    public void setFirst(int i) {
        this.first = i;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setId(AccessibleElementId accessibleElementId) {
        this.id = accessibleElementId;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationLeft(float f) {
        this.indentationLeft = f;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationRight(float f) {
        this.indentationRight = f;
    }

    public void setLettered(boolean z) {
        this.lettered = z;
    }

    public void setListSymbol(Chunk chunk) {
        this.symbol = chunk;
    }

    public void setLowercase(boolean z) {
        this.lowercase = z;
    }

    public void setNumbered(boolean z) {
        this.numbered = z;
    }

    public void setPostSymbol(String str) {
        this.postSymbol = str;
    }

    public void setPreSymbol(String str) {
        this.preSymbol = str;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
        this.role = pdfName;
    }

    public void setSymbolIndent(float f) {
        this.symbolIndent = f;
    }

    public int size() {
        return this.list.size();
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return 14;
    }

    public List(float f) {
        this.list = new ArrayList<>();
        this.numbered = false;
        this.lettered = false;
        this.lowercase = false;
        this.autoindent = false;
        this.alignindent = false;
        this.first = 1;
        this.symbol = new Chunk("- ");
        this.preSymbol = "";
        this.postSymbol = ". ";
        this.indentationLeft = 0.0f;
        this.indentationRight = 0.0f;
        this.symbolIndent = 0.0f;
        this.role = PdfName.L;
        this.accessibleAttributes = null;
        this.id = null;
        this.symbolIndent = f;
    }

    @Override // com.itextpdf.text.TextElementArray
    public boolean add(Element element) {
        if (!(element instanceof ListItem)) {
            if (!(element instanceof List)) {
                return false;
            }
            List list = (List) element;
            list.setIndentationLeft(list.getIndentationLeft() + this.symbolIndent);
            this.first--;
            return this.list.add(list);
        }
        ListItem listItem = (ListItem) element;
        if (this.numbered || this.lettered) {
            Chunk chunk = new Chunk(this.preSymbol, this.symbol.getFont());
            chunk.setAttributes(this.symbol.getAttributes());
            int size = this.first + this.list.size();
            if (this.lettered) {
                chunk.append(RomanAlphabetFactory.getString(size, this.lowercase));
            } else {
                chunk.append(String.valueOf(size));
            }
            chunk.append(this.postSymbol);
            listItem.setListSymbol(chunk);
        } else {
            listItem.setListSymbol(this.symbol);
        }
        listItem.setIndentationLeft(this.symbolIndent, this.autoindent);
        listItem.setIndentationRight(0.0f);
        return this.list.add(listItem);
    }

    public void setListSymbol(String str) {
        this.symbol = new Chunk(str);
    }

    public List(boolean z) {
        this(z, false);
    }

    public List(boolean z, boolean z2) {
        this.list = new ArrayList<>();
        this.numbered = false;
        this.lettered = false;
        this.lowercase = false;
        this.autoindent = false;
        this.alignindent = false;
        this.first = 1;
        this.symbol = new Chunk("- ");
        this.preSymbol = "";
        this.postSymbol = ". ";
        this.indentationLeft = 0.0f;
        this.indentationRight = 0.0f;
        this.symbolIndent = 0.0f;
        this.role = PdfName.L;
        this.accessibleAttributes = null;
        this.id = null;
        this.numbered = z;
        this.lettered = z2;
        this.autoindent = true;
        this.alignindent = true;
    }

    public List(boolean z, float f) {
        this(z, false, f);
    }

    public List(boolean z, boolean z2, float f) {
        this.list = new ArrayList<>();
        this.numbered = false;
        this.lettered = false;
        this.lowercase = false;
        this.autoindent = false;
        this.alignindent = false;
        this.first = 1;
        this.symbol = new Chunk("- ");
        this.preSymbol = "";
        this.postSymbol = ". ";
        this.indentationLeft = 0.0f;
        this.indentationRight = 0.0f;
        this.symbolIndent = 0.0f;
        this.role = PdfName.L;
        this.accessibleAttributes = null;
        this.id = null;
        this.numbered = z;
        this.lettered = z2;
        this.symbolIndent = f;
    }
}
