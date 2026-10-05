package defpackage;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ZW {
    public static Pattern a = Pattern.compile("^(.*@)?([^:]+)(:\\d+)?$");

    public static class a {
        public final URI a;
        public final String b;

        public a(URI uri, String str) {
            this.a = uri;
            this.b = str;
        }
    }

    public static String a(String str) {
        if (str == null) {
            throw new RuntimeException("unable to parse the host from the authority");
        }
        Matcher matcher = a.matcher(str);
        if (matcher.matches()) {
            return matcher.group(2);
        }
        throw new RuntimeException("unable to parse the host from the authority");
    }

    public static a b(URI uri) {
        String str;
        String str2;
        String str3;
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.matches("^https?|wss?$")) {
            scheme = "https";
        }
        int port = uri.getPort();
        if (port == -1) {
            if ("http".equals(scheme) || "ws".equals(scheme)) {
                port = 80;
            } else if ("https".equals(scheme) || "wss".equals(scheme)) {
                port = 443;
            }
        }
        String rawPath = uri.getRawPath();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        String rawUserInfo = uri.getRawUserInfo();
        String rawQuery = uri.getRawQuery();
        String rawFragment = uri.getRawFragment();
        String host = uri.getHost();
        if (host == null) {
            host = a(uri.getRawAuthority());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(scheme);
        sb.append("://");
        String str4 = "";
        if (rawUserInfo != null) {
            str = rawUserInfo + "@";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(host);
        if (port != -1) {
            str2 = ":" + port;
        } else {
            str2 = "";
        }
        sb.append(str2);
        sb.append(rawPath);
        if (rawQuery != null) {
            str3 = "?" + rawQuery;
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (rawFragment != null) {
            str4 = "#" + rawFragment;
        }
        sb.append(str4);
        return new a(URI.create(sb.toString()), scheme + "://" + host + ":" + port);
    }
}
