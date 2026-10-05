package com.itextpdf.tool.xml.pipeline.html;

import com.itextpdf.text.Image;

/* JADX INFO: loaded from: classes3.dex */
public interface ImageProvider {
    String getImageRootPath();

    void reset();

    Image retrieve(String str);

    void store(String str, Image image);
}
