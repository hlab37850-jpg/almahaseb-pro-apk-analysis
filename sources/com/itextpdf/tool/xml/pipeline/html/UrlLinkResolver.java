package com.itextpdf.tool.xml.pipeline.html;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class UrlLinkResolver {
    private String rootPath;

    public UrlLinkResolver(String str) {
        this.rootPath = str;
    }

    public URL resolveLocalUrl(String str) {
        String str2 = this.rootPath;
        if (str2 != null) {
            boolean zEndsWith = str2.endsWith("/");
            boolean zStartsWith = str.startsWith("/");
            if (zEndsWith && zStartsWith) {
                String str3 = this.rootPath;
                this.rootPath = str3.substring(0, str3.length() - 1);
            } else if (!zEndsWith && !zStartsWith) {
                this.rootPath += "/";
            }
            str = this.rootPath + str;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.toURI().toURL();
        }
        return null;
    }

    public URL resolveUrl(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return resolveLocalUrl(str);
        }
    }

    public void setLocalRootPath(String str) {
        this.rootPath = str;
    }

    public UrlLinkResolver() {
    }
}
