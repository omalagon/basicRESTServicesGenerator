package com.oscarmalagon;

import com.oscarmalagon.generator.ServiceGenerator;
import com.oscarmalagon.test.Person;
import com.oscarmalagon.test.SimpleClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.text.ParseException;


@SpringBootApplication
public class ServicesgeneratorApplication {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(ServicesgeneratorApplication.class, args);

        String authorName = "OMalagonM";

        ServiceGenerator serviceGenerator = new ServiceGenerator();
        Class[] inputs = {SimpleClass.class, Person.class};
        serviceGenerator.generateRepository(inputs, authorName);
        serviceGenerator.generateServiceInterface(inputs, authorName);
        serviceGenerator.generateServiceImpl(inputs, authorName);

    }

}
