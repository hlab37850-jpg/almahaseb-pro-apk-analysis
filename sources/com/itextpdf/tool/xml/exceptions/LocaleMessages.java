package com.itextpdf.tool.xml.exceptions;

import java.util.Locale;
import java.util.ResourceBundle;

/* JADX INFO: loaded from: classes3.dex */
public class LocaleMessages {
    public static final String ADD_HEADER = "html.tag.h.create";
    public static final String A_EXTERNAL = "html.tag.a.external";
    public static final String A_LOCALGOTO = "html.tag.a.local";
    public static final String A_SETLOCALGOTO = "html.tag.a.setlocal";
    public static final String COLSPAN = "html.tag.table.colspan";
    public static final String CUSTOMCONTEXT_404_CONTINUE = "customcontext.404.continue";
    public static final String ELEMENT_NOT_ADDED = "pipeline.pdfwriter.elemnotadded";
    public static final String ELEMENT_NOT_ADDED_EXC = "pipeline.pdfwriter.elemnotaddedexc";
    public static final String HEADER_BM_DISABLED = "html.tag.h.disabled";
    public static final String HTML_IMG_RETRIEVE_FAIL = "html.tag.img.failedretrieve";
    public static final String HTML_IMG_USE = "html.tag.img.try";
    public static final String IMG_SRC_NOTCONVERTED = "exc.img.notconverted";
    public static final String INVALID_NESTED_TAG = "tag.invalidnesting";
    public static final String LINK_404 = "html.tag.link.404";
    public static final String META_404 = "html.tag.meta.404";
    public static final String META_CC = "html.tag.meta.cc";
    public static final String NO_CUSTOM_CONTEXT = "customcontext.404";
    public static final String NO_SIBLING = "tag.nosibling";
    public static final String NO_TAGPROCESSOR = "tag.noprocessor";
    public static final String OWN_CONTEXT_404 = "pipeline.owncontextmissing";
    public static final String PIPELINE_AUTODOC = "pipeline.autodoc.missingdep";
    public static final String SPACEHACK = "html.tag.a.spacehack";
    public static final String STACK_404 = "pipeline.html.missingstack";
    public static final String STYLE_NOTPARSED = "html.tag.style.notparsed";
    public static final String UNSUPPORTED_CHARSET = "unsupported.charset";
    public static final String UNSUPPORTED_CLONING = "unsupported.clone";
    private static LocaleMessages myself = new LocaleMessages();
    private final ResourceBundle bundle;

    public LocaleMessages() {
        this.bundle = ResourceBundle.getBundle("errors/errors", Locale.getDefault());
    }

    public static LocaleMessages getInstance() {
        return myself;
    }

    public String getMessage(String str) {
        return this.bundle.getString(str);
    }

    public LocaleMessages(Locale locale) {
        this.bundle = ResourceBundle.getBundle("errors/errors", locale);
    }
}
