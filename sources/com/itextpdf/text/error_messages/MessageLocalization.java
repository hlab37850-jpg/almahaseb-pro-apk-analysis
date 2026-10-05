package com.itextpdf.text.error_messages;

import com.itextpdf.text.io.StreamUtil;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class MessageLocalization {
    private static final String BASE_PATH = "com/itextpdf/text/l10n/error/";
    private static HashMap<String, String> currentLanguage;
    private static HashMap<String, String> defaultLanguage;

    static {
        defaultLanguage = new HashMap<>();
        try {
            defaultLanguage = getLanguageMessages("en", null);
        } catch (Exception unused) {
        }
        if (defaultLanguage == null) {
            defaultLanguage = new HashMap<>();
        }
    }

    private MessageLocalization() {
    }

    public static String getComposedMessage(String str, int i) {
        return getComposedMessage(str, String.valueOf(i), null, null, null);
    }

    private static HashMap<String, String> getLanguageMessages(String str, String str2) throws Throwable {
        String str3;
        if (str == null) {
            throw new IllegalArgumentException("The language cannot be null.");
        }
        InputStream inputStream = null;
        try {
            if (str2 != null) {
                str3 = str + "_" + str2 + ".lng";
            } else {
                str3 = str + ".lng";
            }
            String str4 = BASE_PATH + str3;
            new MessageLocalization();
            InputStream resourceStream = StreamUtil.getResourceStream(str4, MessageLocalization.class.getClassLoader());
            try {
                if (resourceStream != null) {
                    HashMap<String, String> languageStream = readLanguageStream(resourceStream);
                    try {
                        resourceStream.close();
                    } catch (Exception unused) {
                    }
                    return languageStream;
                }
                if (str2 == null) {
                    if (resourceStream != null) {
                        try {
                            resourceStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return null;
                }
                String str5 = BASE_PATH + (str + ".lng");
                new MessageLocalization();
                InputStream resourceStream2 = StreamUtil.getResourceStream(str5, MessageLocalization.class.getClassLoader());
                if (resourceStream2 == null) {
                    if (resourceStream2 != null) {
                        try {
                            resourceStream2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return null;
                }
                try {
                    HashMap<String, String> languageStream2 = readLanguageStream(resourceStream2);
                    try {
                        resourceStream2.close();
                    } catch (Exception unused4) {
                    }
                    return languageStream2;
                } catch (Throwable th) {
                    inputStream = resourceStream2;
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = resourceStream;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String getMessage(String str) {
        return getMessage(str, true);
    }

    private static HashMap<String, String> readLanguageStream(InputStream inputStream) {
        return readLanguageStream(new InputStreamReader(inputStream, XmpWriter.UTF8));
    }

    public static boolean setLanguage(String str, String str2) throws Throwable {
        HashMap<String, String> languageMessages = getLanguageMessages(str, str2);
        if (languageMessages == null) {
            return false;
        }
        currentLanguage = languageMessages;
        return true;
    }

    public static void setMessages(Reader reader) {
        currentLanguage = readLanguageStream(reader);
    }

    public static String getComposedMessage(String str, Object... objArr) {
        String message = getMessage(str);
        if (objArr != null) {
            int i = 1;
            for (Object obj : objArr) {
                if (obj != null) {
                    message = message.replace("{" + i + "}", obj.toString());
                }
                i++;
            }
        }
        return message;
    }

    public static String getMessage(String str, boolean z) {
        String str2;
        String str3;
        HashMap<String, String> map = currentLanguage;
        if (map != null && (str3 = map.get(str)) != null) {
            return str3;
        }
        if (z && (str2 = defaultLanguage.get(str)) != null) {
            return str2;
        }
        return "No message found for " + str;
    }

    private static HashMap<String, String> readLanguageStream(Reader reader) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return map;
            }
            int iIndexOf = line.indexOf(61);
            if (iIndexOf >= 0) {
                String strTrim = line.substring(0, iIndexOf).trim();
                if (!strTrim.startsWith("#")) {
                    map.put(strTrim, line.substring(iIndexOf + 1));
                }
            }
        }
    }
}
