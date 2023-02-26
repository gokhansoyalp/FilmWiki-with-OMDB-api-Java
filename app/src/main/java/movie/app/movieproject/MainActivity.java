package movie.app.movieproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etMovieName;
    public String mName;
    final List<Movie> m1 = new ArrayList<Movie>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMovieName=findViewById(R.id.et_MovieName);
    }

    public void nextButton(View view) {
        mName= etMovieName.getText().toString();
        if (mName.isEmpty()){
            etMovieName.setError("Please Provide Movie Name");
        }
        else {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("form",mName);
            startActivity(intent);
            }

    }
}