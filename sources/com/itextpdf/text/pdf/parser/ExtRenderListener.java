package com.itextpdf.text.pdf.parser;

/* JADX INFO: loaded from: classes3.dex */
public interface ExtRenderListener extends RenderListener {
    void clipPath(int i);

    void modifyPath(PathConstructionRenderInfo pathConstructionRenderInfo);

    Path renderPath(PathPaintingRenderInfo pathPaintingRenderInfo);
}
