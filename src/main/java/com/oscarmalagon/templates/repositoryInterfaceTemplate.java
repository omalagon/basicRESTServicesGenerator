package com.oscarmalagon.templates;

import java.text.ParseException;
import java.util.GregorianCalendar;

import static com.oscarmalagon.utils.Utils.getDate;

/**
 * @author Oscar Malagon
 * @since 28/12/2016.
 */
public class repositoryInterfaceTemplate {

    public static String generateTemplate(String packageName, String authorName, String entityName, String entitySimpleName) throws
        ParseException {
        String tmp =
            "package " + packageName + "\n" +
                "import " + entityName + "\n"+
                "import org.mutualser.core.repository.EntityRepository;\n" +
                "import org.springframework.stereotype.Repository;\n\n" +
                "/**\n" +
                " * @author PSL.SA - " + authorName + "\n" +
                " * @since " + getDate(new GregorianCalendar()) + "\n" +
                " */\n" +
                "@Repository\n" +
                "public interface " + entitySimpleName + "Repository extends EntityRepository<" + entitySimpleName + "> {\n\n}";

        return tmp;
    }

}
