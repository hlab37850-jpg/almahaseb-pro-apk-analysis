package androidx.compose.runtime;

import defpackage.AbstractC0419Di;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
@Stable
public abstract class CompositionLocal<T> {
    public static final int $stable = 0;
    private final LazyValueHolder<T> defaultValueHolder;

    public /* synthetic */ CompositionLocal(InterfaceC3588op interfaceC3588op, AbstractC0419Di abstractC0419Di) {
        this(interfaceC3588op);
    }

    public static /* synthetic */ void getCurrent$annotations() {
    }

    public static /* synthetic */ void getDefaultValueHolder$runtime_release$annotations() {
    }

    @Composable
    @ReadOnlyComposable
    public final T getCurrent(Composer composer, int i) {
        return (T) composer.consume(this);
    }

    public final LazyValueHolder<T> getDefaultValueHolder$runtime_release() {
        return this.defaultValueHolder;
    }

    @Composable
    public abstract State<T> provided$runtime_release(T t, Composer composer, int i);

    private CompositionLocal(InterfaceC3588op interfaceC3588op) {
        this.defaultValueHolder = new LazyValueHolder<>(interfaceC3588op);
    }
}
