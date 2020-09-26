package util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {
    /**
     * Method will read Json file and return as an Array
     * @param filePath is location of the Json file
     * @param attributeName is name of the array inside the Json file
     * @return method returns JSONArray
     */
    public static JSONArray readJsonArrayFromJsonFile(String filePath, String attributeName){
        JSONParser parser = new JSONParser();
        Object object = null;
        try {
            object = parser.parse(new FileReader(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject)object;

        return (JSONArray)jsonObject.get(attributeName);
    }

    /**
     * Method will read an object from .json file
     * @param filePath is location of the file
     * @return this method returns JSONObject
     */
    public static JSONObject readJsonObjectFromJsonFile(String filePath){
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            Object object = parser.parse(new FileReader(filePath));
            jsonObject = (JSONObject) object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    /**
     * This method will read a property from json file
     * @param filePath is location of the Json file with it's name
     * @param attributeName is a field name
     * @return method returns an Object
     */
    public static Object readAttributeFromJsonFile(String filePath, String attributeName){
        JSONParser parser = new JSONParser();
        Object object = null;
        try {
            object = parser.parse(new FileReader(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject)object;
        return jsonObject.get(attributeName);
    }
}
