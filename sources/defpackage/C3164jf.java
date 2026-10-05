package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import com.itextpdf.text.Annotation;
import java.io.InputStream;

/* JADX INFO: renamed from: jf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3164jf extends AbstractC4116vL {
    public static final UriMatcher b;
    public final Context a;

    /* JADX INFO: renamed from: jf$a */
    public static class a {
        public static InputStream a(ContentResolver contentResolver, Uri uri) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        b = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "display_photo/#", 4);
    }

    public C3164jf(Context context) {
        this.a = context;
    }

    private InputStream j(C3792rL c3792rL) {
        ContentResolver contentResolver = this.a.getContentResolver();
        Uri uriLookupContact = c3792rL.d;
        int iMatch = b.match(uriLookupContact);
        if (iMatch != 1) {
            if (iMatch != 2) {
                if (iMatch != 3) {
                    if (iMatch != 4) {
                        throw new IllegalStateException("Invalid uri: " + uriLookupContact);
                    }
                }
            }
            return contentResolver.openInputStream(uriLookupContact);
        }
        uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uriLookupContact);
        if (uriLookupContact == null) {
            return null;
        }
        return a.a(contentResolver, uriLookupContact);
    }

    @Override // defpackage.AbstractC4116vL
    public boolean c(C3792rL c3792rL) {
        Uri uri = c3792rL.d;
        return Annotation.CONTENT.equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && b.match(c3792rL.d) != -1;
    }

    @Override // defpackage.AbstractC4116vL
    public AbstractC4116vL.a f(C3792rL c3792rL, int i) {
        InputStream inputStreamJ = j(c3792rL);
        if (inputStreamJ != null) {
            return new AbstractC4116vL.a(inputStreamJ, C4192wG.e.DISK);
        }
        return null;
    }
}
