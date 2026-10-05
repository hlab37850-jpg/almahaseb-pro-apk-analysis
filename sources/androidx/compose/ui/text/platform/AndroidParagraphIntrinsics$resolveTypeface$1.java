package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.TypefaceResult;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0578Hp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidParagraphIntrinsics$resolveTypeface$1 extends AbstractC2233fv implements InterfaceC0578Hp {
    final /* synthetic */ AndroidParagraphIntrinsics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidParagraphIntrinsics$resolveTypeface$1(AndroidParagraphIntrinsics androidParagraphIntrinsics) {
        super(4);
        this.this$0 = androidParagraphIntrinsics;
    }

    @Override // defpackage.InterfaceC0578Hp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return m4930invokeDPcqOEQ((FontFamily) obj, (FontWeight) obj2, ((FontStyle) obj3).m4804unboximpl(), ((FontSynthesis) obj4).m4815unboximpl());
    }

    /* JADX INFO: renamed from: invoke-DPcqOEQ, reason: not valid java name */
    public final Typeface m4930invokeDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int i, int i2) {
        AbstractC4492zt.h(fontWeight, "fontWeight");
        State<Object> stateMo4776resolveDPcqOEQ = this.this$0.getFontFamilyResolver().mo4776resolveDPcqOEQ(fontFamily, fontWeight, i, i2);
        if (stateMo4776resolveDPcqOEQ instanceof TypefaceResult.Immutable) {
            Object value = stateMo4776resolveDPcqOEQ.getValue();
            AbstractC4492zt.f(value, "null cannot be cast to non-null type android.graphics.Typeface");
            return (Typeface) value;
        }
        TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList = new TypefaceDirtyTrackerLinkedList(stateMo4776resolveDPcqOEQ, this.this$0.resolvedTypefaces);
        this.this$0.resolvedTypefaces = typefaceDirtyTrackerLinkedList;
        return typefaceDirtyTrackerLinkedList.getTypeface();
    }
}
