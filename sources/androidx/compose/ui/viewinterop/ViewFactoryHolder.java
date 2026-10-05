package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.UX;

/* JADX INFO: loaded from: classes.dex */
public final class ViewFactoryHolder<T extends View> extends AndroidViewHolder implements ViewRootForInspector {
    private final int compositeKeyHash;
    private final NestedScrollDispatcher dispatcher;
    private InterfaceC3750qp releaseBlock;
    private InterfaceC3750qp resetBlock;
    private SaveableStateRegistry.Entry savableRegistryEntry;
    private final String saveStateKey;
    private final SaveableStateRegistry saveStateRegistry;
    private final T typedView;
    private InterfaceC3750qp updateBlock;

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.ViewFactoryHolder$registerSaveStateProvider$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ ViewFactoryHolder<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewFactoryHolder<T> viewFactoryHolder) {
            super(0);
            this.this$0 = viewFactoryHolder;
        }

        @Override // defpackage.InterfaceC3588op
        public final Object invoke() {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            ((ViewFactoryHolder) this.this$0).typedView.saveHierarchyState(sparseArray);
            return sparseArray;
        }
    }

    public /* synthetic */ ViewFactoryHolder(Context context, CompositionContext compositionContext, View view, NestedScrollDispatcher nestedScrollDispatcher, SaveableStateRegistry saveableStateRegistry, int i, int i2, AbstractC0419Di abstractC0419Di) {
        this(context, (i2 & 2) != 0 ? null : compositionContext, view, (i2 & 8) != 0 ? new NestedScrollDispatcher() : nestedScrollDispatcher, saveableStateRegistry, i);
    }

    private final void registerSaveStateProvider() {
        SaveableStateRegistry saveableStateRegistry = this.saveStateRegistry;
        if (saveableStateRegistry != null) {
            setSavableRegistryEntry(saveableStateRegistry.registerProvider(this.saveStateKey, new AnonymousClass1(this)));
        }
    }

    private final void setSavableRegistryEntry(SaveableStateRegistry.Entry entry) {
        SaveableStateRegistry.Entry entry2 = this.savableRegistryEntry;
        if (entry2 != null) {
            entry2.unregister();
        }
        this.savableRegistryEntry = entry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterSaveStateProvider() {
        setSavableRegistryEntry(null);
    }

    public final NestedScrollDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final InterfaceC3750qp getReleaseBlock() {
        return this.releaseBlock;
    }

    public final InterfaceC3750qp getResetBlock() {
        return this.resetBlock;
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    public /* synthetic */ AbstractComposeView getSubCompositionView() {
        return UX.a(this);
    }

    public final InterfaceC3750qp getUpdateBlock() {
        return this.updateBlock;
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    public View getViewRoot() {
        return this;
    }

    public final void setReleaseBlock(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "value");
        this.releaseBlock = interfaceC3750qp;
        setRelease(new ViewFactoryHolder$releaseBlock$1(this));
    }

    public final void setResetBlock(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "value");
        this.resetBlock = interfaceC3750qp;
        setReset(new ViewFactoryHolder$resetBlock$1(this));
    }

    public final void setUpdateBlock(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "value");
        this.updateBlock = interfaceC3750qp;
        setUpdate(new ViewFactoryHolder$updateBlock$1(this));
    }

    private ViewFactoryHolder(Context context, CompositionContext compositionContext, T t, NestedScrollDispatcher nestedScrollDispatcher, SaveableStateRegistry saveableStateRegistry, int i) {
        super(context, compositionContext, i, nestedScrollDispatcher, t);
        this.typedView = t;
        this.dispatcher = nestedScrollDispatcher;
        this.saveStateRegistry = saveableStateRegistry;
        this.compositeKeyHash = i;
        setClipChildren(false);
        String strValueOf = String.valueOf(i);
        this.saveStateKey = strValueOf;
        Object objConsumeRestored = saveableStateRegistry != null ? saveableStateRegistry.consumeRestored(strValueOf) : null;
        SparseArray<Parcelable> sparseArray = objConsumeRestored instanceof SparseArray ? (SparseArray) objConsumeRestored : null;
        if (sparseArray != null) {
            t.restoreHierarchyState(sparseArray);
        }
        registerSaveStateProvider();
        this.updateBlock = AndroidView_androidKt.getNoOpUpdate();
        this.resetBlock = AndroidView_androidKt.getNoOpUpdate();
        this.releaseBlock = AndroidView_androidKt.getNoOpUpdate();
    }

    public /* synthetic */ ViewFactoryHolder(Context context, InterfaceC3750qp interfaceC3750qp, CompositionContext compositionContext, SaveableStateRegistry saveableStateRegistry, int i, int i2, AbstractC0419Di abstractC0419Di) {
        this(context, interfaceC3750qp, (i2 & 4) != 0 ? null : compositionContext, saveableStateRegistry, i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewFactoryHolder(Context context, InterfaceC3750qp interfaceC3750qp, CompositionContext compositionContext, SaveableStateRegistry saveableStateRegistry, int i) {
        this(context, compositionContext, (View) interfaceC3750qp.invoke(context), null, saveableStateRegistry, i, 8, null);
        AbstractC4492zt.h(context, "context");
        AbstractC4492zt.h(interfaceC3750qp, "factory");
    }
}
