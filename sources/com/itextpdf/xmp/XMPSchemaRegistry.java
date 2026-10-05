package com.itextpdf.xmp;

import com.itextpdf.xmp.properties.XMPAliasInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface XMPSchemaRegistry {
    void deleteNamespace(String str);

    XMPAliasInfo findAlias(String str);

    XMPAliasInfo[] findAliases(String str);

    Map getAliases();

    String getNamespacePrefix(String str);

    String getNamespaceURI(String str);

    Map getNamespaces();

    Map getPrefixes();

    String registerNamespace(String str, String str2);

    XMPAliasInfo resolveAlias(String str, String str2);
}
