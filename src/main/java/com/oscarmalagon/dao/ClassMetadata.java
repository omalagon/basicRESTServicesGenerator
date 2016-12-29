package com.oscarmalagon.dao;

import lombok.Builder;
import lombok.Data;

/**
 * @author Oscar Malagon
 * @since 28/12/2016.
 */

@Data
public class ClassMetadata {

    private String packageName;
    private String author;


    @Builder
    public static ClassMetadata target(String packageName, String author){
        ClassMetadata classMetadata = new ClassMetadata();
        classMetadata.setPackageName(packageName);
        classMetadata.setAuthor(author);

        return classMetadata;
    }
}
