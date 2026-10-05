package defpackage;

import java.io.IOException;

/* JADX INFO: renamed from: fS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2195fS extends IOException {
    public final EnumC4069ul a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2195fS(EnumC4069ul enumC4069ul) {
        super("stream was reset: " + enumC4069ul);
        AbstractC4492zt.h(enumC4069ul, "errorCode");
        this.a = enumC4069ul;
    }
}
