package com.example.spweek5retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spweek5retrofit.model.Photo;
import com.example.spweek5retrofit.model.TeamsItem;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamViewHolder> {

    private List<Photo> listTeam;

    public TeamsAdapter(List<Photo> listTeam) {
        this.listTeam = listTeam;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team_layout, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        holder.text_teamName.setText(listTeam.get(position).getTitle());
//        holder.text_teamLocation.setText(listTeam.get(position).getLocation());
//        holder.text_teamAbbreviation.setText(listTeam.get(position).getAbbreviation());
    }

    @Override
    public int getItemCount() {
        return listTeam.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder {
        public TextView text_teamName;
        public TextView text_teamLocation;
        public TextView text_teamAbbreviation;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            text_teamName = itemView.findViewById(R.id.team_name);
            text_teamLocation = itemView.findViewById(R.id.location);
            text_teamAbbreviation = itemView.findViewById(R.id.abbreviation);

        }
    }
}
