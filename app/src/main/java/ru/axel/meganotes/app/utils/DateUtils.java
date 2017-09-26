package ru.axel.meganotes.app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    private static SimpleDateFormat sFormatCreateNote = new SimpleDateFormat("dd.MM.yyyy  k:mm", Locale.ROOT);
    private static SimpleDateFormat sFormatCreateFile = new SimpleDateFormat("yyyyMMdd_HHmmssSS", Locale.ROOT);

    public static String getDate() {
        return sFormatCreateNote.format(System.currentTimeMillis());
    }

    public static String getDateCreateFile() {
        return sFormatCreateFile.format(new Date());
    }
}
