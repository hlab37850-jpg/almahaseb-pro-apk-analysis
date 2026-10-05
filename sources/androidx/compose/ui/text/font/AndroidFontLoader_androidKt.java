package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;
import androidx.core.content.res.ResourcesCompat;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.M8;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidFontLoader_androidKt {

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AndroidFontLoader_androidKt$loadAsync$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.ui.text.font.AndroidFontLoader_androidKt$loadAsync$2", f = "AndroidFontLoader.android.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ Context $context;
        final /* synthetic */ ResourceFont $this_loadAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ResourceFont resourceFont, Context context, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$this_loadAsync = resourceFont;
            this.$context = context;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.$this_loadAsync, this.$context, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            return AndroidFontLoader_androidKt.load(this.$this_loadAsync, this.$context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final android.graphics.Typeface load(ResourceFont resourceFont, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ResourceFontHelper.INSTANCE.load(context, resourceFont);
        }
        android.graphics.Typeface font = ResourcesCompat.getFont(context, resourceFont.getResId());
        AbstractC4492zt.e(font);
        AbstractC4492zt.g(font, "{\n        ResourcesCompa…t(context, resId)!!\n    }");
        return font;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object loadAsync(ResourceFont resourceFont, Context context, InterfaceC0793Of interfaceC0793Of) {
        return M8.g(C0368Bj.b(), new AnonymousClass2(resourceFont, context, null), interfaceC0793Of);
    }
}
