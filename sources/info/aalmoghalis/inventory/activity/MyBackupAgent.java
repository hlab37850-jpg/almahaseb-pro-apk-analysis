package info.aalmoghalis.inventory.activity;

import android.app.backup.BackupAgentHelper;
import android.app.backup.FileBackupHelper;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class MyBackupAgent extends BackupAgentHelper {
    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        return getDatabasePath("inv.db").getParentFile();
    }

    @Override // android.app.backup.BackupAgent
    public void onCreate() {
        addHelper("dbs", new FileBackupHelper(this, "inv.db"));
    }
}
