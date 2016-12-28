package com.oscarmalagon.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Optional;

/**
 * @author Oscar Malagon
 * @since 28/12/2016.
 */
public class Utils {


    public static  String getDate(GregorianCalendar date) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        fmt.setCalendar(date);
        String dateFormatted = fmt.format(date.getTime());
        return dateFormatted;
    }


    public static Optional<File> findFileInFolder(File folder, String prefix) {
        File[] matchingFiles = folder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith(prefix);
            }
        });
        for (File f: matchingFiles) {
            System.out.println(f.getAbsolutePath());
        }
        return Optional.ofNullable(matchingFiles[0]);
    }
}
