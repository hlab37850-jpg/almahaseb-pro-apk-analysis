package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Stable;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.C3473nR;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0864Qp;
import defpackage.R5;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Stable
public final class ComposableLambdaNImpl implements ComposableLambdaN {
    private Object _block;
    private final int arity;
    private final int key;
    private RecomposeScope scope;
    private List<RecomposeScope> scopes;
    private final boolean tracked;

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaNImpl$invoke$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ Object[] $args;
        final /* synthetic */ int $realParams;
        final /* synthetic */ ComposableLambdaNImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Object[] objArr, int i, ComposableLambdaNImpl composableLambdaNImpl) {
            super(2);
            this.$args = objArr;
            this.$realParams = i;
            this.this$0 = composableLambdaNImpl;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            AbstractC4492zt.h(composer, "nc");
            Object[] array = R5.e0(this.$args, AbstractC3871sJ.s(0, this.$realParams)).toArray(new Object[0]);
            Object obj = this.$args[this.$realParams + 1];
            AbstractC4492zt.f(obj, "null cannot be cast to non-null type kotlin.Int");
            int iUpdateChangedFlags = RecomposeScopeImplKt.updateChangedFlags(((Integer) obj).intValue());
            int length = (this.$args.length - this.$realParams) - 2;
            Object[] objArr = new Object[length];
            for (int i2 = 0; i2 < length; i2++) {
                Object obj2 = this.$args[this.$realParams + 2 + i2];
                AbstractC4492zt.f(obj2, "null cannot be cast to non-null type kotlin.Int");
                objArr[i2] = Integer.valueOf(RecomposeScopeImplKt.updateChangedFlags(((Integer) obj2).intValue()));
            }
            ComposableLambdaNImpl composableLambdaNImpl = this.this$0;
            C3473nR c3473nR = new C3473nR(4);
            c3473nR.b(array);
            c3473nR.a(composer);
            c3473nR.a(Integer.valueOf(iUpdateChangedFlags | 1));
            c3473nR.b(objArr);
            composableLambdaNImpl.invoke(c3473nR.d(new Object[c3473nR.c()]));
        }
    }

    public ComposableLambdaNImpl(int i, boolean z, int i2) {
        this.key = i;
        this.tracked = z;
        this.arity = i2;
    }

    private final int realParamCount(int i) {
        int i2 = i - 2;
        for (int i3 = 1; i3 * 10 < i2; i3++) {
            i2--;
        }
        return i2;
    }

    private final void trackRead(Composer composer) {
        RecomposeScope recomposeScope;
        if (!this.tracked || (recomposeScope = composer.getRecomposeScope()) == null) {
            return;
        }
        composer.recordUsed(recomposeScope);
        if (ComposableLambdaKt.replacableWith(this.scope, recomposeScope)) {
            this.scope = recomposeScope;
            return;
        }
        List<RecomposeScope> list = this.scopes;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.scopes = arrayList;
            arrayList.add(recomposeScope);
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (ComposableLambdaKt.replacableWith(list.get(i), recomposeScope)) {
                list.set(i, recomposeScope);
                return;
            }
        }
        list.add(recomposeScope);
    }

    private final void trackWrite() {
        if (this.tracked) {
            RecomposeScope recomposeScope = this.scope;
            if (recomposeScope != null) {
                recomposeScope.invalidate();
                this.scope = null;
            }
            List<RecomposeScope> list = this.scopes;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).invalidate();
                }
                list.clear();
            }
        }
    }

    @Override // androidx.compose.runtime.internal.ComposableLambdaN, defpackage.InterfaceC0829Pp
    public int getArity() {
        return this.arity;
    }

    public final int getKey() {
        return this.key;
    }

    @Override // androidx.compose.runtime.internal.ComposableLambdaN, defpackage.InterfaceC0864Qp
    public Object invoke(Object... objArr) {
        AbstractC4492zt.h(objArr, "args");
        int iRealParamCount = realParamCount(objArr.length);
        Object obj = objArr[iRealParamCount];
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type androidx.compose.runtime.Composer");
        Object[] array = R5.e0(objArr, AbstractC3871sJ.s(0, objArr.length - 1)).toArray(new Object[0]);
        Object obj2 = objArr[objArr.length - 1];
        AbstractC4492zt.f(obj2, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj2).intValue();
        Composer composerStartRestartGroup = ((Composer) obj).startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = iIntValue | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(iRealParamCount) : ComposableLambdaKt.sameBits(iRealParamCount));
        Object obj3 = this._block;
        AbstractC4492zt.f(obj3, "null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
        C3473nR c3473nR = new C3473nR(2);
        c3473nR.b(array);
        c3473nR.a(Integer.valueOf(iDifferentBits));
        Object objInvoke = ((InterfaceC0864Qp) obj3).invoke(c3473nR.d(new Object[c3473nR.c()]));
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(objArr, iRealParamCount, this));
        }
        return objInvoke;
    }

    public final void update(Object obj) {
        AbstractC4492zt.h(obj, CSS.Value.BLOCK);
        if (AbstractC4492zt.d(obj, this._block)) {
            return;
        }
        boolean z = this._block == null;
        this._block = (InterfaceC0864Qp) obj;
        if (z) {
            return;
        }
        trackWrite();
    }
}
