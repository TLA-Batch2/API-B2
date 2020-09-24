import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonArray {
    public static void main(String[] args) {
        String a = "{\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"_id\": \"5f5ef8e68a9e7600179c537f\",\n" +
                "            \"id\": 20,\n" +
                "            \"name\": \"Selenium course\",\n" +
                "            \"duration\": \"6 months\",\n" +
                "            \"__v\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"_id\": \"5f5efb04a9ea0c0017bfe830\",\n" +
                "            \"id\": 20,\n" +
                "            \"name\": \"Java course\",\n" +
                "            \"duration\": \"3 months\",\n" +
                "            \"__v\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"_id\": \"5f623b8e897b3200176c8d1a\",\n" +
                "            \"name\": \"Java\",\n" +
                "            \"duration\": \"3 months\",\n" +
                "            \"__v\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"_id\": \"5f654487a3bc89001772403e\",\n" +
                "            \"duration\": \"1 day\",\n" +
                "            \"name\": \"Apache POI\",\n" +
                "            \"__v\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"_id\": \"5f6547bea3bc89001772403f\",\n" +
                "            \"duration\": \"2 day\",\n" +
                "            \"name\": \"CSS selectors\",\n" +
                "            \"__v\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"_id\": \"5f6547eda3bc890017724040\",\n" +
                "            \"duration\": \"2 days\",\n" +
                "            \"name\": \"Xpath selectors\",\n" +
                "            \"__v\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"_id\": \"5f654c67a3bc890017724041\",\n" +
                "            \"duration\": \"2 hours\",\n" +
                "            \"name\": \"Multiple windows\",\n" +
                "            \"__v\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"_id\": \"5f6579b03db3210017cceecd\",\n" +
                "            \"name\": \"Multiple windows\",\n" +
                "            \"duration\": \"2 hours\",\n" +
                "            \"__v\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"_id\": \"5f66289cff17240017e4abe3\",\n" +
                "            \"name\": \"API\",\n" +
                "            \"duration\": \"2 weeks\",\n" +
                "            \"__v\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"_id\": \"5f677855cc884900175ce190\",\n" +
                "            \"name\": \"Math-Juan\",\n" +
                "            \"duration\": \"3 months\",\n" +
                "            \"__v\": 0\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        JSONObject jsonObject = new JSONObject(a);

        List<String> list = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("data");

        for(int i = 0; i < jsonArray.length(); i++){
            list.add(jsonArray.getJSONObject(i).getString("name"));
        }

        list.forEach(k-> System.out.println(k));
    }
}
