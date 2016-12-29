package com.oscarmalagon.dao;

import lombok.Builder;
import lombok.Data;

/**
 * @author Oscar Malagon
 * @since 28/12/2016.
 */

@Data
public class ObjectData {

    private String name;
    private String path;

    @Builder
    public static ObjectData target(String name, String path){
        ObjectData objectData = new ObjectData();
        objectData.setName(name);
        objectData.setPath(path);

        return objectData;
    }

}
