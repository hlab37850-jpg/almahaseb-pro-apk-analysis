package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.DV;
import defpackage.InterfaceC3750qp;
import defpackage.OJ;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldDelegate {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: layout-_EkL_-Y$foundation_release$default, reason: not valid java name */
        public static /* synthetic */ DV m815layout_EkL_Y$foundation_release$default(Companion companion, TextDelegate textDelegate, long j, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult, int i, Object obj) {
            if ((i & 8) != 0) {
                textLayoutResult = null;
            }
            return companion.m817layout_EkL_Y$foundation_release(textDelegate, j, layoutDirection, textLayoutResult);
        }

        /* JADX INFO: renamed from: applyCompositionDecoration-72CqOWE, reason: not valid java name */
        public final TransformedText m816applyCompositionDecoration72CqOWE(long j, TransformedText transformedText) {
            AbstractC4492zt.h(transformedText, "transformed");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(transformedText.getText());
            builder.addStyle(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Companion.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (AbstractC0419Di) null), transformedText.getOffsetMapping().originalToTransformed(TextRange.m4705getStartimpl(j)), transformedText.getOffsetMapping().originalToTransformed(TextRange.m4700getEndimpl(j)));
            return new TransformedText(builder.toAnnotatedString(), transformedText.getOffsetMapping());
        }

        public final void draw$foundation_release(Canvas canvas, TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Paint paint) {
            int iOriginalToTransformed;
            int iOriginalToTransformed2;
            AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
            AbstractC4492zt.h(textFieldValue, "value");
            AbstractC4492zt.h(offsetMapping, "offsetMapping");
            AbstractC4492zt.h(textLayoutResult, "textLayoutResult");
            AbstractC4492zt.h(paint, "selectionPaint");
            if (!TextRange.m4699getCollapsedimpl(textFieldValue.m4922getSelectiond9O1mEE()) && (iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m4703getMinimpl(textFieldValue.m4922getSelectiond9O1mEE()))) != (iOriginalToTransformed2 = offsetMapping.originalToTransformed(TextRange.m4702getMaximpl(textFieldValue.m4922getSelectiond9O1mEE())))) {
                canvas.drawPath(textLayoutResult.getPathForRange(iOriginalToTransformed, iOriginalToTransformed2), paint);
            }
            TextPainter.INSTANCE.paint(canvas, textLayoutResult);
        }

        /* JADX INFO: renamed from: layout-_EkL_-Y$foundation_release, reason: not valid java name */
        public final DV m817layout_EkL_Y$foundation_release(TextDelegate textDelegate, long j, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult) {
            AbstractC4492zt.h(textDelegate, "textDelegate");
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            TextLayoutResult textLayoutResultM807layoutNN6EwU = textDelegate.m807layoutNN6EwU(j, layoutDirection, textLayoutResult);
            return new DV(Integer.valueOf(IntSize.m5320getWidthimpl(textLayoutResultM807layoutNN6EwU.m4678getSizeYbymL2g())), Integer.valueOf(IntSize.m5319getHeightimpl(textLayoutResultM807layoutNN6EwU.m4678getSizeYbymL2g())), textLayoutResultM807layoutNN6EwU);
        }

        public final void notifyFocusedRect$foundation_release(TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, TextInputSession textInputSession, boolean z, OffsetMapping offsetMapping) {
            Rect boundingBox;
            AbstractC4492zt.h(textFieldValue, "value");
            AbstractC4492zt.h(textDelegate, "textDelegate");
            AbstractC4492zt.h(textLayoutResult, "textLayoutResult");
            AbstractC4492zt.h(layoutCoordinates, "layoutCoordinates");
            AbstractC4492zt.h(textInputSession, "textInputSession");
            AbstractC4492zt.h(offsetMapping, "offsetMapping");
            if (z) {
                int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m4702getMaximpl(textFieldValue.m4922getSelectiond9O1mEE()));
                if (iOriginalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
                    boundingBox = textLayoutResult.getBoundingBox(iOriginalToTransformed);
                } else {
                    boundingBox = iOriginalToTransformed != 0 ? textLayoutResult.getBoundingBox(iOriginalToTransformed - 1) : new Rect(0.0f, 0.0f, 1.0f, IntSize.m5319getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null)));
                }
                long jMo4168localToRootMKHz9U = layoutCoordinates.mo4168localToRootMKHz9U(OffsetKt.Offset(boundingBox.getLeft(), boundingBox.getTop()));
                textInputSession.notifyFocusedRect(RectKt.m2838Recttz77jQw(OffsetKt.Offset(Offset.m2798getXimpl(jMo4168localToRootMKHz9U), Offset.m2799getYimpl(jMo4168localToRootMKHz9U)), SizeKt.Size(boundingBox.getWidth(), boundingBox.getHeight())));
            }
        }

        public final void onBlur$foundation_release(TextInputSession textInputSession, EditProcessor editProcessor, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(textInputSession, "textInputSession");
            AbstractC4492zt.h(editProcessor, "editProcessor");
            AbstractC4492zt.h(interfaceC3750qp, "onValueChange");
            interfaceC3750qp.invoke(TextFieldValue.m4917copy3r_uNRQ$default(editProcessor.toTextFieldValue(), (AnnotatedString) null, 0L, (TextRange) null, 3, (Object) null));
            textInputSession.dispose();
        }

        public final void onEditCommand$foundation_release(List<? extends EditCommand> list, EditProcessor editProcessor, InterfaceC3750qp interfaceC3750qp, TextInputSession textInputSession) {
            AbstractC4492zt.h(list, "ops");
            AbstractC4492zt.h(editProcessor, "editProcessor");
            AbstractC4492zt.h(interfaceC3750qp, "onValueChange");
            TextFieldValue textFieldValueApply = editProcessor.apply(list);
            if (textInputSession != null) {
                textInputSession.updateState(null, textFieldValueApply);
            }
            interfaceC3750qp.invoke(textFieldValueApply);
        }

        public final TextInputSession onFocus$foundation_release(TextInputService textInputService, TextFieldValue textFieldValue, EditProcessor editProcessor, ImeOptions imeOptions, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
            AbstractC4492zt.h(textInputService, "textInputService");
            AbstractC4492zt.h(textFieldValue, "value");
            AbstractC4492zt.h(editProcessor, "editProcessor");
            AbstractC4492zt.h(imeOptions, "imeOptions");
            AbstractC4492zt.h(interfaceC3750qp, "onValueChange");
            AbstractC4492zt.h(interfaceC3750qp2, "onImeActionPerformed");
            return restartInput$foundation_release(textInputService, textFieldValue, editProcessor, imeOptions, interfaceC3750qp, interfaceC3750qp2);
        }

        public final TextInputSession restartInput$foundation_release(TextInputService textInputService, TextFieldValue textFieldValue, EditProcessor editProcessor, ImeOptions imeOptions, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
            AbstractC4492zt.h(textInputService, "textInputService");
            AbstractC4492zt.h(textFieldValue, "value");
            AbstractC4492zt.h(editProcessor, "editProcessor");
            AbstractC4492zt.h(imeOptions, "imeOptions");
            AbstractC4492zt.h(interfaceC3750qp, "onValueChange");
            AbstractC4492zt.h(interfaceC3750qp2, "onImeActionPerformed");
            OJ oj = new OJ();
            TextInputSession textInputSessionStartInput = textInputService.startInput(textFieldValue, imeOptions, new TextFieldDelegate$Companion$restartInput$1(editProcessor, interfaceC3750qp, oj), interfaceC3750qp2);
            oj.a = textInputSessionStartInput;
            return textInputSessionStartInput;
        }

        /* JADX INFO: renamed from: setCursorOffset-ULxng0E$foundation_release, reason: not valid java name */
        public final void m818setCursorOffsetULxng0E$foundation_release(long j, TextLayoutResultProxy textLayoutResultProxy, EditProcessor editProcessor, OffsetMapping offsetMapping, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(textLayoutResultProxy, "textLayoutResult");
            AbstractC4492zt.h(editProcessor, "editProcessor");
            AbstractC4492zt.h(offsetMapping, "offsetMapping");
            AbstractC4492zt.h(interfaceC3750qp, "onValueChange");
            interfaceC3750qp.invoke(TextFieldValue.m4917copy3r_uNRQ$default(editProcessor.toTextFieldValue(), (AnnotatedString) null, TextRangeKt.TextRange(offsetMapping.transformedToOriginal(TextLayoutResultProxy.m842getOffsetForPosition3MmeM6k$default(textLayoutResultProxy, j, false, 2, null))), (TextRange) null, 5, (Object) null));
        }

        private Companion() {
        }
    }
}
