package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class DateInputKt$DateInputTextField$4 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$changed;
    final /* synthetic */ DateInputFormat $dateInputFormat;
    final /* synthetic */ DateInputValidator $dateInputValidator;
    final /* synthetic */ CalendarDate $initialDate;
    final /* synthetic */ int $inputIdentifier;
    final /* synthetic */ InterfaceC0526Fp $label;
    final /* synthetic */ Locale $locale;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ InterfaceC3750qp $onDateChanged;
    final /* synthetic */ InterfaceC0526Fp $placeholder;
    final /* synthetic */ StateData $stateData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateInputKt$DateInputTextField$4(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, StateData stateData, CalendarDate calendarDate, InterfaceC3750qp interfaceC3750qp, int i, DateInputValidator dateInputValidator, DateInputFormat dateInputFormat, Locale locale, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$label = interfaceC0526Fp;
        this.$placeholder = interfaceC0526Fp2;
        this.$stateData = stateData;
        this.$initialDate = calendarDate;
        this.$onDateChanged = interfaceC3750qp;
        this.$inputIdentifier = i;
        this.$dateInputValidator = dateInputValidator;
        this.$dateInputFormat = dateInputFormat;
        this.$locale = locale;
        this.$$changed = i2;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    public final void invoke(Composer composer, int i) {
        DateInputKt.m1487DateInputTextFieldzm97o8M(this.$modifier, this.$label, this.$placeholder, this.$stateData, this.$initialDate, this.$onDateChanged, this.$inputIdentifier, this.$dateInputValidator, this.$dateInputFormat, this.$locale, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
