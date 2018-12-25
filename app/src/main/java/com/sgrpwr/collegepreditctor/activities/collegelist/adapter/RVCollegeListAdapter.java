package com.sgrpwr.collegepreditctor.activities.collegelist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sgrpwr.collegepreditctor.R;
import com.sgrpwr.collegepreditctor.components.CollegeItemView;

public class RVCollegeListAdapter extends RecyclerView.Adapter<RVCollegeListAdapter.CollegeViewHolder> {

    //private List<Movie> moviesList;

    public class CollegeViewHolder extends RecyclerView.ViewHolder {
        public CollegeItemView item;

        public CollegeViewHolder(View view) {
            super(view);
            item = view.findViewById(R.id.college_item);
        }
    }


    public RVCollegeListAdapter() {

    }

    @Override
    public CollegeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_college_list, parent, false);

        return new CollegeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CollegeViewHolder holder, int position) {
        /*Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());*/
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}