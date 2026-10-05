package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import defpackage.AbstractC0354Av;

/* JADX INFO: loaded from: classes3.dex */
public class LibraryVersionComponent {
    private LibraryVersionComponent() {
    }

    public static Component<?> create(String str, String str2) {
        return Component.intoSet(AbstractC0354Av.a(str, str2), AbstractC0354Av.class);
    }
}
