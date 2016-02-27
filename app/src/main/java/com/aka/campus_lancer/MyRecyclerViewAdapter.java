package com.aka.campus_lancer;

/**
 * @author akshayaggarwal
 * @since 26-01-2016
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private String[] mDataset;
    private  Context mContext;
    List<Persons> persons;

    MyRecyclerViewAdapter(List<Persons> persons){
        this.persons = persons;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            personName = (TextView) itemView.findViewById(R.id.person_name);
            personAge = (TextView) itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView) itemView.findViewById(R.id.person_photo);
        }


    }

    // Provide a suitable constructor (depends on the kind of dataset)
//    public MyRecyclerViewAdapter(String[] myDataset) {
//        mDataset = myDataset;
//    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
     holder.personName.setText(persons.get(i).name);
        holder.personAge.setText(persons.get(i).age);
        holder.personPhoto.setImageResource(R.mipmap.akshay);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return persons.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}