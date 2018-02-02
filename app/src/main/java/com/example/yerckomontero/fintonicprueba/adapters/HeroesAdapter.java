package com.example.yerckomontero.fintonicprueba.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yerckomontero.fintonicprueba.R;
import com.example.yerckomontero.fintonicprueba.models.Heroe;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by yerckomontero on 1/2/18.
 */


public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder> {
    private Context context;
    private List<Heroe> heroesList;
    private final IHeroesAdapter listener;

    public HeroesAdapter(Context context, List<Heroe> heroesList, IHeroesAdapter listener) {
        this.context = context;
        this.heroesList = heroesList;
        this.listener = listener;

    }

    public class HeroesViewHolder extends RecyclerView.ViewHolder {
        private ImageView photo;
        public TextView realName,height,power,abilities,groups ,name;

        public HeroesViewHolder(View view) {
            super(view);

            photo = (ImageView) view.findViewById(R.id.iv_photo);
            realName = (TextView) view.findViewById(R.id.tv_realname);
            name = (TextView) view.findViewById(R.id.tv_name);
        }
        public void bind(final Heroe item, final IHeroesAdapter listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }

    }

    @Override
    public HeroesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_list, parent, false);

        return new HeroesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HeroesViewHolder holder, int position) {
        holder.bind(heroesList.get(position), listener);

        Heroe heroe= heroesList.get(position);
        holder.name.setText(heroe.getName());
        holder.realName.setText(heroe.getRealName());
        Picasso.with(context).load(heroe.getPhoto()).into(holder.photo);

    }

    @Override
    public int getItemCount() {
        return heroesList.size();
    }
}