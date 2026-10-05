package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3675pv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt$HorizontalMonthsList$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ InterfaceC3750qp $dateValidator;
    final /* synthetic */ CalendarMonth $firstMonth;
    final /* synthetic */ InterfaceC3750qp $onDateSelected;
    final /* synthetic */ StateData $stateData;
    final /* synthetic */ CalendarDate $today;

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$2$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0578Hp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ CalendarMonth $firstMonth;
        final /* synthetic */ InterfaceC3750qp $onDateSelected;
        final /* synthetic */ StateData $stateData;
        final /* synthetic */ CalendarDate $today;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StateData stateData, CalendarMonth calendarMonth, InterfaceC3750qp interfaceC3750qp, CalendarDate calendarDate, InterfaceC3750qp interfaceC3750qp2, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, int i) {
            super(4);
            this.$stateData = stateData;
            this.$firstMonth = calendarMonth;
            this.$onDateSelected = interfaceC3750qp;
            this.$today = calendarDate;
            this.$dateValidator = interfaceC3750qp2;
            this.$dateFormatter = datePickerFormatter;
            this.$colors = datePickerColors;
            this.$$dirty = i;
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
            int i3;
            AbstractC4492zt.h(lazyItemScope, "$this$items");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 112) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-65053693, i2, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1300)");
            }
            CalendarMonth calendarMonthPlusMonths = this.$stateData.getCalendarModel().plusMonths(this.$firstMonth, i);
            Modifier modifierD = AbstractC3675pv.d(lazyItemScope, Modifier.Companion, 0.0f, 1, null);
            InterfaceC3750qp interfaceC3750qp = this.$onDateSelected;
            CalendarDate calendarDate = this.$today;
            StateData stateData = this.$stateData;
            InterfaceC3750qp interfaceC3750qp2 = this.$dateValidator;
            DatePickerFormatter datePickerFormatter = this.$dateFormatter;
            DatePickerColors datePickerColors = this.$colors;
            int i4 = this.$$dirty;
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierD);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            composer.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i5 = i4 << 3;
            int i6 = i4 << 6;
            DatePickerKt.Month(calendarMonthPlusMonths, interfaceC3750qp, calendarDate, stateData, false, interfaceC3750qp2, datePickerFormatter, datePickerColors, composer, (i5 & 458752) | (i5 & 112) | 24576 | (i6 & 7168) | ((i4 << 9) & 3670016) | (29360128 & i6));
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$HorizontalMonthsList$2$1(StateData stateData, CalendarMonth calendarMonth, InterfaceC3750qp interfaceC3750qp, CalendarDate calendarDate, InterfaceC3750qp interfaceC3750qp2, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, int i) {
        super(1);
        this.$stateData = stateData;
        this.$firstMonth = calendarMonth;
        this.$onDateSelected = interfaceC3750qp;
        this.$today = calendarDate;
        this.$dateValidator = interfaceC3750qp2;
        this.$dateFormatter = datePickerFormatter;
        this.$colors = datePickerColors;
        this.$$dirty = i;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LazyListScope) obj);
        return FW.a;
    }

    public final void invoke(LazyListScope lazyListScope) {
        AbstractC4492zt.h(lazyListScope, "$this$LazyRow");
        LazyListScope.CC.k(lazyListScope, this.$stateData.getTotalMonthsInRange(), null, null, ComposableLambdaKt.composableLambdaInstance(-65053693, true, new AnonymousClass1(this.$stateData, this.$firstMonth, this.$onDateSelected, this.$today, this.$dateValidator, this.$dateFormatter, this.$colors, this.$$dirty)), 6, null);
    }
}
