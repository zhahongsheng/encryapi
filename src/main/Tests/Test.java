import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author zhahsh
 * @date 2021/4/22
 */
public class Test {



    public Test() throws IOException {


    }

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://192.168.12.21:5050/console/console/login/getPublicKey")
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            assert response.body() != null;
            String stringTemp = response.body().string();
            JSONObject jsonObjectTemp = new JSONObject();
            jsonObjectTemp = (JSONObject)JSONObject.parse(stringTemp);
            System.out.println(jsonObjectTemp);
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }
}
