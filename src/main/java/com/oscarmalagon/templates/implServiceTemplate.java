package com.oscarmalagon.templates;

import com.oscarmalagon.dao.ClassMetadata;
import com.oscarmalagon.dao.ObjectData;
import com.oscarmalagon.utils.Utils;

import java.text.ParseException;
import java.util.GregorianCalendar;

/**
 * @author Oscar Malagon
 * @since 28/12/2016.
 */
public class ImplServiceTemplate {

    private static final String IMPORT = "import";

    private ImplServiceTemplate(){

    }


    public static String generateTemplate(ClassMetadata classMetadata, ObjectData entityData, ObjectData serviceData, ObjectData repositoryData) throws ParseException {
        String tmp = "package " + classMetadata.getPackageName() +
            "\n" +
            IMPORT + "static com.google.common.base.Preconditions.checkNotNull;\n" +
            "\n" +
            IMPORT + "java.util.List;\n" +
            IMPORT + "java.util.Optional;\n" +
            "\n" +
            IMPORT + "org.mutualser.core.commons.exception.CommonRuntimeException;\n" +
            IMPORT +  entityData.getPath() + "\n" +
            IMPORT +  repositoryData.getPath() + "\n" +
            IMPORT +  serviceData.getPath() + "\n" +
            IMPORT + " org.springframework.beans.factory.annotation.Autowired;\n" +
            IMPORT + " org.springframework.data.domain.Sort;\n" +
            IMPORT + " org.springframework.stereotype.Service;\n" +
            IMPORT + " org.springframework.transaction.annotation.Transactional;\n\n" +
            "/**\n" +
            " * @author PSL.SA - " + classMetadata.getAuthor() + "\n" +
            " * @since " + Utils.getDate(new GregorianCalendar()) + "\n" +
            " */\n\n"+
            "@Service\n" +
            "public class Default"+ serviceData.getName() +" implements " + serviceData.getName() + "+Service {\n\n" +
            "\tprivate final " + repositoryData.getName() + " " + repositoryData.getName().toLowerCase() + "\n\n" +
            "\tpublic Default"+ serviceData.getName() +"(" + repositoryData.getName() + " " + repositoryData.getName().toLowerCase() +"){\n" +
            "\t\tthis." + repositoryData.getName().toLowerCase() + " = " + repositoryData.getName().toLowerCase() + ";\n\t}\n\n" +
            "\t@Override\n\t public Optional<" + entityData.getName() + "> createOrUpdate" + entityData.getName() + "(" + entityData.getName() + " " + entityData.getName().toLowerCase() + ");\n"+
            "\t{\n\t\t return null;\n\t}"
            ;

        return tmp;

    }
}

