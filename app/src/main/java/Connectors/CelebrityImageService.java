package Connectors;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class CelebrityImageService {
    private static final String ENDPOINT = "https://celebritybucks.com/images/celebs/full/";
    private String url;
    private String celebId;
    private final RequestQueue queue;
    private Celebrity Celeb;

    public CelebrityImageService(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public void ChangeCeleb(Celebrity celeb){
        Celeb = celeb;
    }

    public String Search() {
        String endpoint = ENDPOINT;
        celebId = Integer.toString(Celeb.celebId);
        url = ENDPOINT + celebId + ".jpg";
        System.out.println(url);
        return url;
    }
}
