package com.fasteque.rxbackup.utils;

/**
 * Created by danielealtomare on 09/08/15.
 * Project: RxBackup
 */
public class StringUtils {

    /**
     * Android has it own formatter for bytes, but with this utility, there's no need to pass a Context.
     * In AppListAdapter we do not have to pass a context yet, so let's keep this method.
     */
    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));

        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");

        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }
}
