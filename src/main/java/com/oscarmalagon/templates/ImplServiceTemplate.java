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

/**
 * @author Oscar Malagon
 * @since 28/12/2016.
 */
public class ImplServiceTemplate {



    private ImplServiceTemplate(){

    }

    public static String generateTemplate(ClassMetadata classMetadata, ObjectData entityData, ObjectData serviceData, ObjectData repositoryData) throws ParseException {

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty("resource.loader", "class");
        velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine.init();

        Template template = velocityEngine.getTemplate("ServiceImplementationTemplate.vm");

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("package_name", classMetadata.getPackageName());
        velocityContext.put("entity_path", entityData.getPath());
        velocityContext.put("entity_repository_path", repositoryData.getPath());
        velocityContext.put("entity_service_path", serviceData.getPath());
        velocityContext.put("author_name", classMetadata.getAuthor());
        velocityContext.put("date", Utils.getDate(new GregorianCalendar()));
        velocityContext.put("attribute_name", entityData.getName().toLowerCase());
        velocityContext.put("entity_name", entityData.getName());

        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);

        return stringWriter.toString();



    }
}

