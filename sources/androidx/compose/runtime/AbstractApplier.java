package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.O4;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class AbstractApplier<T> implements Applier<T> {
    public static final int $stable = 8;
    private T current;
    private final T root;
    private final List<T> stack = new ArrayList();

    public AbstractApplier(T t) {
        this.root = t;
        this.current = t;
    }

    @Override // androidx.compose.runtime.Applier
    public final void clear() {
        this.stack.clear();
        setCurrent(this.root);
        onClear();
    }

    @Override // androidx.compose.runtime.Applier
    public void down(T t) {
        this.stack.add(getCurrent());
        setCurrent(t);
    }

    @Override // androidx.compose.runtime.Applier
    public T getCurrent() {
        return this.current;
    }

    public final T getRoot() {
        return this.root;
    }

    public final void move(List<T> list, int i, int i2, int i3) {
        AbstractC4492zt.h(list, "<this>");
        int i4 = i > i2 ? i2 : i2 - i3;
        if (i3 != 1) {
            List<T> listSubList = list.subList(i, i3 + i);
            List listF0 = AbstractC3240kc.F0(listSubList);
            listSubList.clear();
            list.addAll(i4, listF0);
            return;
        }
        if (i == i2 + 1 || i == i2 - 1) {
            list.set(i, list.set(i2, list.get(i)));
        } else {
            list.add(i4, list.remove(i));
        }
    }

    @Override // androidx.compose.runtime.Applier
    public /* synthetic */ void onBeginChanges() {
        O4.a(this);
    }

    public abstract void onClear();

    @Override // androidx.compose.runtime.Applier
    public /* synthetic */ void onEndChanges() {
        O4.b(this);
    }

    public final void remove(List<T> list, int i, int i2) {
        AbstractC4492zt.h(list, "<this>");
        if (i2 == 1) {
            list.remove(i);
        } else {
            list.subList(i, i2 + i).clear();
        }
    }

    public void setCurrent(T t) {
        this.current = t;
    }

    @Override // androidx.compose.runtime.Applier
    public void up() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Check failed.");
        }
        List<T> list = this.stack;
        setCurrent(list.remove(list.size() - 1));
    }
}
