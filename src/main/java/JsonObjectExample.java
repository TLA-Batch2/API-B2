import org.json.JSONObject;

public class JsonObjectExample {

    public static void main(String[] args) {
        String s = "{\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Bhuvaneshwar Bandopadhyay\",\n" +
                "        \"email\": \"bhuvaneshwar_bandopadhyay@pouros.io\",\n" +
                "        \"gender\": \"Male\",\n" +
                "        \"status\": true,\n" +
                "        \"created_at\": \"2020-09-23T03:50:03.625+05:30\",\n" +
                "        \"updated_at\": \"2020-09-23T03:50:03.625+05:30\"\n" +
                "    }";

        JSONObject object = new JSONObject(s);

        System.out.println(object.getInt("id"));
        System.out.println(object.getBoolean("status"));
        System.out.println(object.getString("created_at"));

    }

}
