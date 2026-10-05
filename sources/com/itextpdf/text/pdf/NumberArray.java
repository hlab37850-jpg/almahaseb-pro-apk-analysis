package com.itextpdf.text.pdf;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NumberArray extends PdfArray {
    public NumberArray(float... fArr) {
        for (float f : fArr) {
            add(new PdfNumber(f));
        }
    }

    public NumberArray(List<PdfNumber> list) {
        Iterator<PdfNumber> it = list.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }
}
