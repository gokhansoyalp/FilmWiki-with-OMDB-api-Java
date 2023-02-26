package movie.app.movieproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;
import java.util.List;

public class CustomListViewAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final List<Movie> movie;

   public CustomListViewAdapter(Activity activity, List<Movie> movie){
       inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       this.movie = movie;
   }

    @Override
    public int getCount() {
        return movie.size();
    }

    @Override
    public Object getItem(int position) {
        return movie.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position,  View view, ViewGroup viewGroup) {
        View lineView;
        lineView = inflater.inflate(R.layout.list_item,null);
        TextView textViewTitle = (TextView) lineView.findViewById(R.id.tvMovieName);
        TextView textViewDesc = (TextView) lineView.findViewById(R.id.tvMovieDesc);
        Movie m = movie.get(position);
        textViewTitle.setText(m.getTitle());
        textViewDesc.setText(m.getDesc());

/*

        ViewHolder holder;
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.list_item,null);
            holder = new ViewHolder();
            holder.movieName =  convertView.findViewById(R.id.tvMovieName);
            holder.movieDesc = convertView.findViewById(R.id.tvMovieDesc);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Movie mv = movie.get(position);
        if (mv!=null){
            holder.movieName.setText(mv.getTitle());
            holder.movieDesc.setText(mv.getDesc());
        }
*/

        return lineView;
    }
}