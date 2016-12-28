package com.oscarmalagon.templates;

import java.text.ParseException;
import java.util.GregorianCalendar;

import static com.oscarmalagon.utils.Utils.getDate;

/**
 * @author Oscar Malagon
 * @since 28/12/2016.
 */
public class serviceInterfaceTemplate {

    public static String generateTemplate(String packageName, String authorName, String entityName, String entitySimpleName) throws
        ParseException {
        String tmp =
            "package " + packageName + "\n" +
                "import " + entityName + "\n"+
                "import java.util.List;\n" +
                "import java.util.Optional;\n\n"+
                "/**\n" +
                " * @author PSL.SA - " + authorName + "\n" +
                " * @since " + getDate(new GregorianCalendar()) + "\n" +
                " */\n" +
                "public interface " + entitySimpleName + "Service{\n\n}"+
                "\tOptional<"+ entitySimpleName +"> createOrUpdate"+ entitySimpleName+ "(" + entitySimpleName + " " + entitySimpleName.toLowerCase() + ");\n"+
                "\tOptional<"+ entitySimpleName + "> findById(String id);\n"+
                "\tList<"+ entitySimpleName+ "> findAll();\n"+
                "\tOptional<"+ entitySimpleName + "> delete("+ entitySimpleName + " " + entitySimpleName.toLowerCase() + ");\n}";

        return tmp;
    }
}
