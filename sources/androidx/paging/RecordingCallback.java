package androidx.paging;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.C0945Ts;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class RecordingCallback extends PagedList.Callback {
    private static final int Changed = 0;
    public static final Companion Companion = new Companion(null);
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private final List<Integer> list = new ArrayList();

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private Companion() {
        }
    }

    public final void dispatchRecordingTo(PagedList.Callback callback) {
        AbstractC4492zt.h(callback, "other");
        C0945Ts c0945TsR = AbstractC3871sJ.r(AbstractC3871sJ.s(0, this.list.size()), 3);
        int iB = c0945TsR.b();
        int iC = c0945TsR.c();
        int iD = c0945TsR.d();
        if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
            while (true) {
                int iIntValue = this.list.get(iB).intValue();
                if (iIntValue == 0) {
                    callback.onChanged(this.list.get(iB + 1).intValue(), this.list.get(iB + 2).intValue());
                } else if (iIntValue == 1) {
                    callback.onInserted(this.list.get(iB + 1).intValue(), this.list.get(iB + 2).intValue());
                } else {
                    if (iIntValue != 2) {
                        throw new IllegalStateException("Unexpected recording value");
                    }
                    callback.onRemoved(this.list.get(iB + 1).intValue(), this.list.get(iB + 2).intValue());
                }
                if (iB == iC) {
                    break;
                } else {
                    iB += iD;
                }
            }
        }
        this.list.clear();
    }

    @Override // androidx.paging.PagedList.Callback
    public void onChanged(int i, int i2) {
        this.list.add(0);
        this.list.add(Integer.valueOf(i));
        this.list.add(Integer.valueOf(i2));
    }

    @Override // androidx.paging.PagedList.Callback
    public void onInserted(int i, int i2) {
        this.list.add(1);
        this.list.add(Integer.valueOf(i));
        this.list.add(Integer.valueOf(i2));
    }

    @Override // androidx.paging.PagedList.Callback
    public void onRemoved(int i, int i2) {
        this.list.add(2);
        this.list.add(Integer.valueOf(i));
        this.list.add(Integer.valueOf(i2));
    }
}
