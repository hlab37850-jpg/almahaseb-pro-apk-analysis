package com.google.firebase.platforminfo;

import androidx.annotation.Nullable;
import defpackage.C1831bv;

/* JADX INFO: loaded from: classes3.dex */
public final class KotlinDetector {
    private KotlinDetector() {
    }

    @Nullable
    public static String detectVersion() {
        try {
            return C1831bv.f.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
