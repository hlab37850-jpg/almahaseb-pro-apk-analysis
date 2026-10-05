package com.itextpdf.text;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class Anchor extends Phrase {
    private static final long serialVersionUID = -852278536049236911L;
    protected String name;
    protected String reference;

    public Anchor() {
        super(16.0f);
        this.name = null;
        this.reference = null;
    }

    public boolean applyAnchor(Chunk chunk, boolean z, boolean z2) {
        if (this.name != null && z && !chunk.isEmpty()) {
            chunk.setLocalDestination(this.name);
            z = false;
        }
        if (z2) {
            chunk.setLocalGoto(this.reference.substring(1));
        } else {
            String str = this.reference;
            if (str != null) {
                chunk.setAnchor(str);
            }
        }
        return z;
    }

    @Override // com.itextpdf.text.Phrase, com.itextpdf.text.Element
    public java.util.List<Chunk> getChunks() {
        String str = this.reference;
        boolean zApplyAnchor = true;
        boolean z = str != null && str.startsWith("#");
        ArrayList arrayList = new ArrayList();
        for (Element element : this) {
            if (element instanceof Chunk) {
                Chunk chunk = (Chunk) element;
                zApplyAnchor = applyAnchor(chunk, zApplyAnchor, z);
                arrayList.add(chunk);
            } else {
                for (Chunk chunk2 : element.getChunks()) {
                    zApplyAnchor = applyAnchor(chunk2, zApplyAnchor, z);
                    arrayList.add(chunk2);
                }
            }
        }
        return arrayList;
    }

    public String getName() {
        return this.name;
    }

    public String getReference() {
        return this.reference;
    }

    public URL getUrl() {
        try {
            return new URL(this.reference);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    @Override // com.itextpdf.text.Phrase, com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        try {
            String str = this.reference;
            boolean z = str != null && str.startsWith("#");
            boolean z2 = true;
            for (Chunk chunk : getChunks()) {
                if (this.name != null && z2 && !chunk.isEmpty()) {
                    chunk.setLocalDestination(this.name);
                    z2 = false;
                }
                if (z) {
                    chunk.setLocalGoto(this.reference.substring(1));
                }
                elementListener.add(chunk);
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReference(String str) {
        this.reference = str;
    }

    @Override // com.itextpdf.text.Phrase, com.itextpdf.text.Element
    public int type() {
        return 17;
    }

    public Anchor(float f) {
        super(f);
        this.name = null;
        this.reference = null;
    }

    public Anchor(Chunk chunk) {
        super(chunk);
        this.name = null;
        this.reference = null;
    }

    public Anchor(String str) {
        super(str);
        this.name = null;
        this.reference = null;
    }

    public Anchor(String str, Font font) {
        super(str, font);
        this.name = null;
        this.reference = null;
    }

    public Anchor(float f, Chunk chunk) {
        super(f, chunk);
        this.name = null;
        this.reference = null;
    }

    public Anchor(float f, String str) {
        super(f, str);
        this.name = null;
        this.reference = null;
    }

    public Anchor(float f, String str, Font font) {
        super(f, str, font);
        this.name = null;
        this.reference = null;
    }

    public Anchor(Phrase phrase) {
        super(phrase);
        this.name = null;
        this.reference = null;
        if (phrase instanceof Anchor) {
            Anchor anchor = (Anchor) phrase;
            setName(anchor.name);
            setReference(anchor.reference);
        }
    }
}
