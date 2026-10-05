package androidx.compose.material3;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldMeasurePolicy$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Placeable $containerPlaceable;
    final /* synthetic */ Placeable $labelPlaceable;
    final /* synthetic */ Placeable $leadingPlaceable;
    final /* synthetic */ Placeable $placeholderPlaceable;
    final /* synthetic */ Placeable $prefixPlaceable;
    final /* synthetic */ Placeable $suffixPlaceable;
    final /* synthetic */ Placeable $supportingPlaceable;
    final /* synthetic */ Placeable $textFieldPlaceable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ int $topPaddingValue;
    final /* synthetic */ int $totalHeight;
    final /* synthetic */ Placeable $trailingPlaceable;
    final /* synthetic */ int $width;
    final /* synthetic */ TextFieldMeasurePolicy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldMeasurePolicy$measure$1(Placeable placeable, int i, int i2, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, TextFieldMeasurePolicy textFieldMeasurePolicy, int i3, MeasureScope measureScope) {
        super(1);
        this.$labelPlaceable = placeable;
        this.$width = i;
        this.$totalHeight = i2;
        this.$textFieldPlaceable = placeable2;
        this.$placeholderPlaceable = placeable3;
        this.$leadingPlaceable = placeable4;
        this.$trailingPlaceable = placeable5;
        this.$prefixPlaceable = placeable6;
        this.$suffixPlaceable = placeable7;
        this.$containerPlaceable = placeable8;
        this.$supportingPlaceable = placeable9;
        this.this$0 = textFieldMeasurePolicy;
        this.$topPaddingValue = i3;
        this.$this_measure = measureScope;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        Placeable placeable = this.$labelPlaceable;
        if (placeable == null) {
            TextFieldKt.placeWithoutLabel(placementScope, this.$width, this.$totalHeight, this.$textFieldPlaceable, this.$placeholderPlaceable, this.$leadingPlaceable, this.$trailingPlaceable, this.$prefixPlaceable, this.$suffixPlaceable, this.$containerPlaceable, this.$supportingPlaceable, this.this$0.singleLine, this.$this_measure.getDensity(), this.this$0.paddingValues);
            return;
        }
        int i = this.$width;
        int i2 = this.$totalHeight;
        Placeable placeable2 = this.$textFieldPlaceable;
        Placeable placeable3 = this.$placeholderPlaceable;
        Placeable placeable4 = this.$leadingPlaceable;
        Placeable placeable5 = this.$trailingPlaceable;
        Placeable placeable6 = this.$prefixPlaceable;
        Placeable placeable7 = this.$suffixPlaceable;
        Placeable placeable8 = this.$containerPlaceable;
        Placeable placeable9 = this.$supportingPlaceable;
        boolean z = this.this$0.singleLine;
        int i3 = this.$topPaddingValue;
        TextFieldKt.placeWithLabel(placementScope, i, i2, placeable2, placeable, placeable3, placeable4, placeable5, placeable6, placeable7, placeable8, placeable9, z, i3, i3 + this.$labelPlaceable.getHeight(), this.this$0.animationProgress, this.$this_measure.getDensity());
    }
}
