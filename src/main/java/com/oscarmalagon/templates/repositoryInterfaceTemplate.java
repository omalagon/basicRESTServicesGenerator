package com.oscarmalagon.templates;

import com.oscarmalagon.dao.ClassMetadata;
import com.oscarmalagon.dao.ObjectData;
import com.oscarmalagon.utils.Utils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.text.ParseException;
import java.util.GregorianCalendar;

import static com.oscarmalagon.utils.Utils.getDate;

/**
 * @author Oscar Malagon
 * @since 28/12/2016.
 */
public class RepositoryInterfaceTemplate {

    private RepositoryInterfaceTemplate(){

    }

    public static String generateTemplate(ClassMetadata classMetadata, ObjectData entityData) throws
        ParseException {

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty("resource.loader", "class");
        velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine.init();

        Template template = velocityEngine.getTemplate("RepositoryTemplate.vm");

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("package_name", "<edit>");
        velocityContext.put("entity_path", entityData.getPath());
        velocityContext.put("author_name", classMetadata.getAuthor());
        velocityContext.put("entity_name_repository", entityData.getName() + "Repository" );
        velocityContext.put("entity_name", entityData.getName());
        velocityContext.put("date", Utils.getDate(new GregorianCalendar()));

        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);


        return stringWriter.toString();
    }

}
