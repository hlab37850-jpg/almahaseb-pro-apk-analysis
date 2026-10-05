package androidx.compose.material3;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
public final class BottomSheetScaffoldState {
    public static final int $stable = 0;
    private final SheetState bottomSheetState;
    private final SnackbarHostState snackbarHostState;

    public BottomSheetScaffoldState(SheetState sheetState, SnackbarHostState snackbarHostState) {
        AbstractC4492zt.h(sheetState, "bottomSheetState");
        AbstractC4492zt.h(snackbarHostState, "snackbarHostState");
        this.bottomSheetState = sheetState;
        this.snackbarHostState = snackbarHostState;
    }

    public final SheetState getBottomSheetState() {
        return this.bottomSheetState;
    }

    public final SnackbarHostState getSnackbarHostState() {
        return this.snackbarHostState;
    }
}
