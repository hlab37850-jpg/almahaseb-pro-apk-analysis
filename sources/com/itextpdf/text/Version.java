package com.itextpdf.text;

/* JADX INFO: loaded from: classes3.dex */
public final class Version {
    public static String AGPL = " (AGPL-version)";
    private static Version version;
    private String iText = "iText®";
    private String release = "5.5.10";
    private String iTextVersion = this.iText + " " + this.release + " ©2000-2015 iText Group NV";
    private String key = null;

    public static Version getInstance() {
        if (version == null) {
            Version version2 = new Version();
            version = version2;
            synchronized (version2) {
                try {
                    try {
                        Class<?> cls = Class.forName("com.itextpdf.license.LicenseKey");
                        String[] strArr = (String[]) cls.getMethod("getLicenseeInfo", new Class[0]).invoke(cls.newInstance(), new Object[0]);
                        String str = strArr[3];
                        if (str == null || str.trim().length() <= 0) {
                            version.key = "Trial version ";
                            if (strArr[5] == null) {
                                StringBuilder sb = new StringBuilder();
                                Version version3 = version;
                                sb.append(version3.key);
                                sb.append("unauthorised");
                                version3.key = sb.toString();
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                Version version4 = version;
                                sb2.append(version4.key);
                                sb2.append(strArr[5]);
                                version4.key = sb2.toString();
                            }
                        } else {
                            version.key = strArr[3];
                        }
                        String str2 = strArr[4];
                        if (str2 == null || str2.trim().length() <= 0) {
                            String str3 = strArr[2];
                            if (str3 == null || str3.trim().length() <= 0) {
                                String str4 = strArr[0];
                                if (str4 == null || str4.trim().length() <= 0) {
                                    throw new Exception();
                                }
                                StringBuilder sb3 = new StringBuilder();
                                Version version5 = version;
                                sb3.append(version5.iTextVersion);
                                sb3.append(" (");
                                sb3.append(strArr[0]);
                                version5.iTextVersion = sb3.toString();
                                if (version.key.toLowerCase().startsWith("trial")) {
                                    StringBuilder sb4 = new StringBuilder();
                                    Version version6 = version;
                                    sb4.append(version6.iTextVersion);
                                    sb4.append("; ");
                                    sb4.append(version.key);
                                    sb4.append(")");
                                    version6.iTextVersion = sb4.toString();
                                } else {
                                    StringBuilder sb5 = new StringBuilder();
                                    Version version7 = version;
                                    sb5.append(version7.iTextVersion);
                                    sb5.append("; licensed version)");
                                    version7.iTextVersion = sb5.toString();
                                }
                            } else {
                                StringBuilder sb6 = new StringBuilder();
                                Version version8 = version;
                                sb6.append(version8.iTextVersion);
                                sb6.append(" (");
                                sb6.append(strArr[2]);
                                version8.iTextVersion = sb6.toString();
                                if (version.key.toLowerCase().startsWith("trial")) {
                                    StringBuilder sb7 = new StringBuilder();
                                    Version version9 = version;
                                    sb7.append(version9.iTextVersion);
                                    sb7.append("; ");
                                    sb7.append(version.key);
                                    sb7.append(")");
                                    version9.iTextVersion = sb7.toString();
                                } else {
                                    StringBuilder sb8 = new StringBuilder();
                                    Version version10 = version;
                                    sb8.append(version10.iTextVersion);
                                    sb8.append("; licensed version)");
                                    version10.iTextVersion = sb8.toString();
                                }
                            }
                        } else {
                            version.iTextVersion = strArr[4];
                        }
                    } catch (Exception unused) {
                        StringBuilder sb9 = new StringBuilder();
                        Version version11 = version;
                        sb9.append(version11.iTextVersion);
                        sb9.append(AGPL);
                        version11.iTextVersion = sb9.toString();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return version;
    }

    public static boolean isAGPLVersion() {
        return getInstance().getVersion().indexOf(AGPL) > 0;
    }

    public String getKey() {
        return this.key;
    }

    public String getProduct() {
        return this.iText;
    }

    public String getRelease() {
        return this.release;
    }

    public String getVersion() {
        return this.iTextVersion;
    }
}
