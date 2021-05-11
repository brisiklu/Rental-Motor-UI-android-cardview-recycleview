package org.asa.app;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.ArrayList;
import android.support.v7.widget.*;
import android.content.Intent;
import android.util.Log;
import java.util.*;

/**
 * Created by Akshay Raj on 8/9/2016.
 * Snow Corporation Inc.
 * www.snowcorp.org
 */
 
 
public class OutletsAdapter extends RecyclerView.Adapter<OutletsAdapter.MyViewHolder> {

    private static final String TAG = "AlbumsAdapter";

    private Context mContext;
    private List<Outlet> outletList;
    TextView mNamaOutlet,mJarak,mBintang;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, starText,jarakText;
        public ImageView thumbnail, starIco,jarakIco;
        public CardView cardViewOutlet;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            starText = view.findViewById(R.id.starText);
            jarakText = view.findViewById(R.id.jarakText);          
            thumbnail = view.findViewById(R.id.thumbnail);
            cardViewOutlet=view.findViewById(R.id.cardViewOutlet);
            
        }
    }
    
    public OutletsAdapter(Context mContext, List<Outlet> albumList) {
        this.mContext = mContext;
        this.outletList = albumList;
    }

   
    
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }
    
     
    
    
    @Override
    public void onBindViewHolder(final MyViewHolder holder,   final int position) {
      	Outlet outlet = outletList.get(position);
        holder.title.setText(outlet.getName());
        holder.starText.setText(outlet.getRating());
        holder.jarakText.setText(outlet.getJarak());
        
        
         //loading album cover using Glide library
        Glide.with(mContext).load(outlet.getThumbnail()).into(holder.thumbnail);
        Glide.with(mContext).load(outlet.getCardViewOutlet());
        holder.cardViewOutlet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, outletList.get(position).getName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, MotorActivity.class);
					intent.putExtra("NamaOutlet",outletList.get(position).getName());
					intent.putExtra("Alamat",outletList.get(position).getAlamat());
                    intent.putExtra("Jarak",outletList.get(position).getJarak());
					intent.putExtra("Bintang",outletList.get(position).getRating());
					mContext.startActivity(intent);
					
                }
            });
        
        
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
//                case R.id.action_add_favourite:
//                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
//                    return true;
//                case R.id.action_play_next:
//                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
//                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return outletList.size();
    }
}
