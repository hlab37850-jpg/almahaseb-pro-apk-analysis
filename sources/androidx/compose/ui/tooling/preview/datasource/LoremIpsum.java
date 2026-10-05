package androidx.compose.ui.tooling.preview.datasource;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import defpackage.AbstractC2233fv;
import defpackage.DO;
import defpackage.FO;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC4362yO;
import defpackage.MH;
import defpackage.MJ;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class LoremIpsum implements PreviewParameterProvider<String> {
    public static final int $stable = 0;
    private final int words;

    /* JADX INFO: renamed from: androidx.compose.ui.tooling.preview.datasource.LoremIpsum$generateLoremIpsum$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ int $loremIpsumMaxSize;
        final /* synthetic */ MJ $wordsUsed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MJ mj, int i) {
            super(0);
            this.$wordsUsed = mj;
            this.$loremIpsumMaxSize = i;
        }

        @Override // defpackage.InterfaceC3588op
        public final String invoke() {
            List list = LoremIpsumKt.LOREM_IPSUM_SOURCE;
            MJ mj = this.$wordsUsed;
            int i = mj.a;
            mj.a = i + 1;
            return (String) list.get(i % this.$loremIpsumMaxSize);
        }
    }

    public LoremIpsum(int i) {
        this.words = i;
    }

    private final String generateLoremIpsum(int i) {
        return FO.q(FO.u(DO.f(new AnonymousClass1(new MJ(), LoremIpsumKt.LOREM_IPSUM_SOURCE.size())), i), " ", null, null, 0, null, null, 62, null);
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public /* synthetic */ int getCount() {
        return MH.a(this);
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public InterfaceC4362yO getValues() {
        return DO.h(generateLoremIpsum(this.words));
    }

    public LoremIpsum() {
        this(500);
    }
}
