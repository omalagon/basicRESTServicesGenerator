package com.oscarmalagon.templates;

import com.oscarmalagon.utils.Utils;

import java.text.ParseException;
import java.util.GregorianCalendar;

/**
 * @author Oscar Malagon
 * @since 28/12/2016.
 */
public class implServiceTemplate {

    public static String generateTemplate(String packageName, String entityPath, String entityName, String servicePath, String serviceName, String author,
        String repositoryPath, String repositoryName) throws ParseException {
        String tmp = "package " + packageName +
            "\n" +
            "import static com.google.common.base.Preconditions.checkNotNull;\n" +
            "\n" +
            "import java.util.List;\n" +
            "import java.util.Optional;\n" +
            "\n" +
            "import org.mutualser.core.commons.exception.CommonRuntimeException;\n" +
            "import " + entityPath + "\n" +
            "import " + repositoryPath + "\n" +
            "import " + servicePath + "\n" +
            "import org.springframework.beans.factory.annotation.Autowired;\n" +
            "import org.springframework.data.domain.Sort;\n" +
            "import org.springframework.stereotype.Service;\n" +
            "import org.springframework.transaction.annotation.Transactional;\n" +
            "/**\n" +
            " * @author PSL.SA - " + author + "\n" +
            " * @since " + Utils.getDate(new GregorianCalendar()) + "\n" +
            " */"+
            "@Service\n" +
            "public class Default"+ serviceName +" implements DepartamentoService {"
            ;

        return tmp;

    }
}

