package com.donnelly.codechallenge.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.donnelly.codechallenge.R;
import com.donnelly.codechallenge.network.models.Guide;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Steve on 6/19/2017.
 */

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.GuideViewHolder> {
    private List<Guide> dataSet;
    private Context context;

    public GuideAdapter(Context context){
        this.context = context;
    }

    public void setData (List<Guide> dataSet){
        this.dataSet = dataSet;
    }
    @Override
    public GuideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_guide_layout, parent, false);
        return new GuideViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GuideViewHolder holder, final int position) {
        Guide guide = dataSet.get(position);
        holder.displayGuide(guide);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class GuideViewHolder extends RecyclerView.ViewHolder {
        private TextView informationView;
        private ImageView iconView;

        public GuideViewHolder(View itemView){
            super(itemView);
            informationView = (TextView)itemView.findViewById(R.id.information_view);
            iconView = (ImageView)itemView.findViewById(R.id.icon_view);
        }

        public void displayGuide(Guide guide){
            String name = guide.getName();
            String city = (guide.getVenue() == null ? null : guide.getVenue().getCity());
            String state = (guide.getVenue() == null ? null : guide.getVenue().getState());
            String endDate = guide.getEndDate();
            String information = "Name: " + name + "\nCity: " + city + "\nState: " + state + "\nEnd Date: " + endDate;

            informationView.setText(information);
            Picasso.with(context).load(guide.getIconUrl()).into(iconView);
        }
    }
}
