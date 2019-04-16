package com.malta.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResolver {
    
    
    private static final ObjectMapper jsonResolver = new ObjectMapper();
    
    public static <T> String convertToJson(T value) {
	String result = null;
	try {
	    result =  jsonResolver.writeValueAsString(value);
	} catch (JsonProcessingException e) {
	    System.err.println("Unable to parse the Json : " + e.getMessage());
	    result = "{" + "errorMessage : " + e.getMessage() + "}";
	    e.printStackTrace();
	}
	return result;
    }

}
