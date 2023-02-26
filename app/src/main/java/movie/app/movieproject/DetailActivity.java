package movie.app.movieproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    TextView tvTitle, tvDesc, tvYear, tvGenre, tvDuration, tvDirector, tvActor, tvLang, tvCountry, tvAward;
    ImageView pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("plot");
        String year = intent.getStringExtra("year");
        String genre = intent.getStringExtra("genre");
        String duration = intent.getStringExtra("duration");
        String director = intent.getStringExtra("director");
        String actor = intent.getStringExtra("actor");
        String lang = intent.getStringExtra("lang");
        String country = intent.getStringExtra("country");
        String award = intent.getStringExtra("award");
        String poster = intent.getStringExtra("poster");


        tvTitle=findViewById(R.id.tv_title);
        tvDesc=findViewById(R.id.tv_desc);
        tvYear=findViewById(R.id.tv_year);
        tvGenre=findViewById(R.id.tv_genre);
        tvDuration=findViewById(R.id.tv_duration);
        tvDirector=findViewById(R.id.tv_director);
        tvActor=findViewById(R.id.tv_actors);
        tvLang=findViewById(R.id.tv_language);
        tvCountry=findViewById(R.id.tv_country);
        tvAward=findViewById(R.id.tv_awards);
        pos=findViewById(R.id.iv_poster);

        tvTitle.setText(title);
        tvDesc.setText(desc);
        tvYear.setText(year);
        tvGenre.setText(genre);
        tvDuration.setText(duration);
        tvDirector.setText(director);
        tvActor.setText(actor);
        tvLang.setText(lang);
        tvCountry.setText(country);
        if (award.equals("N/A")){
            tvAward.setText("No award(s).");
        }
        else
        {
            tvAward.setText(award);
        }


        if (poster.equals("N/A")){

        }
        else {
            Picasso.get().load(poster).into(pos);
        }
    }
}