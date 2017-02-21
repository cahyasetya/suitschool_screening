package id.ydev.suitschoolscreening;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

import id.ydev.suitschoolscreening.adapter.GuestAdapter;
import id.ydev.suitschoolscreening.model.Guest;

public class GuestActivity extends AppCompatActivity {
    private GridView guestGridView;
    private List<Guest> guestList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        final ProgressDialog pd=new ProgressDialog(this);
        pd.setMessage("loading...");
        pd.show();
        String url="http://dry-sierra-6832.herokuapp.com/api/people";
        JsonArrayRequest arrayRequest=new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Type tipe=new TypeToken<List<Guest>>(){}.getType();
                guestList=new Gson().fromJson(response.toString(),tipe);
                for(Guest guest:guestList){
                    guest.setImage(R.drawable.dummy);
                }
                guestGridView=(GridView)findViewById(R.id.guest_gridview);
                guestGridView.setAdapter(new GuestAdapter(GuestActivity.this, guestList));
                pd.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(arrayRequest);
    }
}
