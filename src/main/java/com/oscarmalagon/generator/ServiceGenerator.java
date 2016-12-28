package com.oscarmalagon.generator;

import com.oscarmalagon.templates.repositoryInterfaceTemplate;
import com.oscarmalagon.templates.serviceInterfaceTemplate;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Oscar Malagon
 * @since 27/12/2016.
 */
@Slf4j
public class ServiceGenerator {

    private static final String PACKAGE_NAME = "<edit>";
    private static final String JAVA_EXTENSION = ".java";

    public void generateRepository (Class[] inputs, String authorName) throws ParseException {

        File repositoryFolder = new File("../Project/repositories/");
        repositoryFolder.mkdirs();

        for(Class input: inputs){
            File repositoryFile = new File(repositoryFolder.getAbsolutePath() + "/" + input.getSimpleName().toLowerCase());
            repositoryFile.mkdir();

            String repositoryName = input.getSimpleName() + "Repository";
            String tmp = repositoryInterfaceTemplate
                .generateTemplate(PACKAGE_NAME, authorName, input.getName(), input.getSimpleName());
            List<String> code = Arrays.asList(tmp);

            try {
                Files.write(Paths.get(repositoryFile.getAbsolutePath() +"/" + repositoryName + JAVA_EXTENSION),
                    code,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            } catch (IOException e) {
                log.error(String.valueOf(e));
            }
        }
    }

    public void generateServiceInterface(Class [] inputs, String authorName) throws ParseException {
        File serviceFolder = new File("../Project/services/");
        serviceFolder.mkdirs();

        for(Class input: inputs) {
            File serviceFile = new File(serviceFolder.getAbsolutePath() + "/" + input.getSimpleName().toLowerCase());
            serviceFile.mkdir();
            String serviceName = input.getSimpleName() + "Service";
            String tmp = serviceInterfaceTemplate
                .generateTemplate(PACKAGE_NAME, authorName, input.getName(), input.getSimpleName());
            List<String> code = Arrays.asList(tmp);

            try {
                Files.write(Paths.get(serviceFile.getAbsolutePath() +"/" + serviceName + JAVA_EXTENSION),
                    code,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            } catch (IOException e) {
                log.error(String.valueOf(e));
            }

        }
    }

    public void generateServiceImpl(Class [] inputs, String authorName) throws ParseException{
        File servicesFolder = new File("../Project/services/");
        servicesFolder.mkdirs();

        for(Class input: inputs) {
            File serviceImplFolder = new File(servicesFolder.getAbsolutePath() + "/" +input.getSimpleName().toLowerCase() + "/impl");
            serviceImplFolder.mkdirs();
            String serviceInterfaceName = input.getSimpleName() +"Service";
            String className = "Default" + serviceInterfaceName;
            String tmp = serviceInterfaceTemplate.generateTemplate(PACKAGE_NAME, authorName, input.getName(), input.getSimpleName());
            List<String> code = Arrays.asList(tmp);

            try {
                Files.write(Paths.get(serviceImplFolder.getAbsolutePath() +"/" + className + JAVA_EXTENSION),
                    code,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            } catch (IOException e) {
                log.error(String.valueOf(e));
            }

        }
    }

}
