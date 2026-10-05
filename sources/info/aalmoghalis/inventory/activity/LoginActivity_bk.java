package info.aalmoghalis.inventory.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;

/* JADX INFO: loaded from: classes3.dex */
public class LoginActivity_bk extends BaseActivity {
    public AutoCompleteTextView c;
    public EditText d;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginActivity_bk.this.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.d.setError(null);
        if (this.d.getText().toString().equals(Z00.W)) {
            Z00.V = "1";
            y();
        } else {
            this.d.setError(getString(R.string.error_invalid_password));
            this.d.requestFocus();
        }
    }

    private void y() {
        startActivity(new Intent(this, (Class<?>) FragmentStatePagerSupport_Main.class));
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Process.killProcess(Process.myPid());
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login);
        this.c = (AutoCompleteTextView) findViewById(R.id.email);
        this.d = (EditText) findViewById(R.id.password);
        ((Button) findViewById(R.id.email_sign_in_button)).setOnClickListener(new a());
    }
}
