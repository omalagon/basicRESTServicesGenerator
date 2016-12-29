package com.oscarmalagon.generator;

import com.oscarmalagon.dao.ClassMetadata;
import com.oscarmalagon.dao.ObjectData;
import com.oscarmalagon.templates.ImplServiceTemplate;
import com.oscarmalagon.templates.RepositoryInterfaceTemplate;
import com.oscarmalagon.templates.ServiceInterfaceTemplate;
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
@Slf4j public class ServiceGenerator {

    private static final String PACKAGE_NAME = "<edit>";
    private static final String JAVA_EXTENSION = ".java";
    private static final String FOLDER_RELATIVE_PATH = "../Project6";

    public void generateRepository(Class[] inputs, String authorName) throws ParseException {

        File repositoryFolder = new File(FOLDER_RELATIVE_PATH + "/repositories/");
        repositoryFolder.mkdirs();

        for (Class input : inputs) {
            File repositoryFile = new File(
                repositoryFolder.getAbsolutePath() + "/" + input.getSimpleName().toLowerCase());
            repositoryFile.mkdir();

            String repositoryName = input.getSimpleName() + "Repository";

            ClassMetadata classMetadata =
                ClassMetadata.builder()
                    .packageName(PACKAGE_NAME)
                    .author(authorName)
                    .build();

            ObjectData entityData =
                ObjectData.builder()
                    .name(input.getSimpleName())
                    .path(input.getName())
                    .build();

            String tmp = RepositoryInterfaceTemplate.generateTemplate(classMetadata, entityData);
            List<String> code = Arrays.asList(tmp);

            try {
                Files.write(Paths
                        .get(repositoryFile.getAbsolutePath() + "/" + repositoryName + JAVA_EXTENSION),
                    code, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            } catch (IOException e) {
                log.error(String.valueOf(e));
            }
        }
    }

    public void generateServiceInterface(Class[] inputs, String authorName) throws ParseException {
        File serviceFolder = new File(FOLDER_RELATIVE_PATH + "/services/");
        serviceFolder.mkdirs();

        for (Class input : inputs) {
            File serviceFile = new File(
                serviceFolder.getAbsolutePath() + "/" + input.getSimpleName().toLowerCase());
            serviceFile.mkdir();

            String serviceName = input.getSimpleName() + "Service";

            ClassMetadata classMetadata =
                ClassMetadata.builder()
                    .packageName(PACKAGE_NAME)
                    .author(authorName)
                    .build();

            ObjectData entityData =
                ObjectData.builder()
                    .name(input.getSimpleName())
                    .path(input.getName())
                    .build();

            String tmp = ServiceInterfaceTemplate.generateTemplate(classMetadata, entityData);
            List<String> code = Arrays.asList(tmp);

            try {
                Files.write(
                    Paths.get(serviceFile.getAbsolutePath() + "/" + serviceName + JAVA_EXTENSION),
                    code, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            } catch (IOException e) {
                log.error(String.valueOf(e));
            }

        }
    }

    public void generateServiceImpl(Class[] inputs, String authorName) throws ParseException {
        File servicesFolder = new File(FOLDER_RELATIVE_PATH + "/services/");
        servicesFolder.mkdirs();

        for (Class input : inputs) {

            File repositoryFolder = new File(FOLDER_RELATIVE_PATH + "/repositories/" + input.getSimpleName() + "Repository.java");

            File serviceImplFolder = new File(
                servicesFolder.getAbsolutePath() + "/" + input.getSimpleName().toLowerCase()
                    + "/impl");
            serviceImplFolder.mkdirs();

            String serviceInterfaceName = input.getSimpleName() + "Service";
            String className = "Default" + serviceInterfaceName;

            ClassMetadata classMetadata =
                ClassMetadata.builder()
                    .packageName(PACKAGE_NAME)
                    .author(authorName)
                    .build();

            ObjectData entityData =
                ObjectData.builder()
                    .name(input.getSimpleName())
                    .path(input.getName())
                    .build();

            ObjectData serviceData =
                ObjectData.builder()
                    .path("Not searched yet")
                    .build();

            ObjectData repositoryData =
                ObjectData.builder()
                    .path("Not searched yet")
                    .build();


            String tmp = ImplServiceTemplate
                .generateTemplate(classMetadata, entityData, serviceData, repositoryData);
            List<String> code = Arrays.asList(tmp);

            try {
                Files.write(Paths
                        .get(serviceImplFolder.getAbsolutePath() + "/" + className + JAVA_EXTENSION),
                    code, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            } catch (IOException e) {
                log.error(String.valueOf(e));
            }

        }
    }

}
