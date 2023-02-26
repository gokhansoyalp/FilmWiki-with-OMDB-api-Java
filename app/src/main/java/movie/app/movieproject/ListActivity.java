package movie.app.movieproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        String data = intent.getStringExtra("form");
        sendUrl(data,this);

    }



    public void sendUrl(String data, AppCompatActivity e){
        final List<Movie> m1 = new ArrayList<Movie>();
        String url= "http://www.omdbapi.com/?t="+ data +"&plot=full&apikey=c3781ac6";
        RequestQueue queue = Volley.newRequestQueue(this);



        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject movie = new JSONObject(response);

                    String title = movie.getString("Title");

                    String desc = movie.getString("Plot");

                    String year = movie.getString("Year");

                    String genre = movie.getString("Genre");

                    String duration = movie.getString("Runtime");

                    String director = movie.getString("Director");

                    String actor = movie.getString("Actors");

                    String lang = movie.getString("Language");

                    String country = movie.getString("Country");

                    String award = movie.getString("Awards");

                    String poster = movie.getString("Poster");
                    m1.add(new Movie(title,desc,year,genre,duration,director,actor,lang,country,award,poster));

                    final ListView listView = (ListView) findViewById(R.id.lv_movie);
                    CustomListViewAdapter adapter = new CustomListViewAdapter(e, m1);
                    listView.setAdapter(adapter);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view,
                                                int position, long id) {
                        Intent intent = new Intent(e,DetailActivity.class);
                        intent.putExtra("title",m1.get(position).getTitle());
                        intent.putExtra("plot",m1.get(position).getDesc());
                        intent.putExtra("year",m1.get(position).getYear());
                        intent.putExtra("genre",m1.get(position).getGenre());
                        intent.putExtra("duration",m1.get(position).getDuration());
                        intent.putExtra("director",m1.get(position).getDirector());
                        intent.putExtra("actor",m1.get(position).getActors());
                        intent.putExtra("lang",m1.get(position).getLang());
                        intent.putExtra("country",m1.get(position).getCountry());
                        intent.putExtra("award",m1.get(position).getAward());
                        intent.putExtra("poster",m1.get(position).getPoster());
                        startActivity(intent);

                        }
                    });


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(e, "Movie Not Found !", Toast.LENGTH_SHORT).show();
            }
        }
        );
        queue.add(request);
    }

}
