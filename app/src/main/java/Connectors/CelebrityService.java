package Connectors;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CelebrityService {
    private static final String ENDPOINT = "https://celebritybucks.com/developers/export/JSON";
    private String url;
    private final RequestQueue queue;


    private ArrayList<Celebrity> celebs = new ArrayList<>();

    public ArrayList<Celebrity> getCelebs() {
        return celebs;
    }

    public CelebrityService(Context context){
        queue = Volley.newRequestQueue(context);
    }
    public ArrayList<Celebrity> Search(final VolleyCallBack callBack){
        String endpoint = ENDPOINT;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, endpoint, null, response->{
                    Gson gson = new Gson();
                    JSONArray items = response.optJSONArray("CelebrityValues");
                    for(int i = 0;i<items.length();i++){
                        try{
                            JSONObject object = items.getJSONObject(i);
                            Celebrity celeb = gson.fromJson(object.toString(),Celebrity.class);
                            celebs.add(celeb);
                        }catch(JSONException e){


                        }

                    }
                    callBack.onSuccess();

                },error->{
                    Log.e("ERROR ",error.getMessage());
                });

        queue.add(jsonObjectRequest);
        return celebs;

    }
}
