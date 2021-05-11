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
import android.support.v7.widget.CardView;
import android.content.Intent;
import android.util.Log;
import android.os.*;
public class MotorsAdapter extends RecyclerView.Adapter<MotorsAdapter.MyViewHolder>
{

    


    private static final String TAG = "MotorsAdapter";
    private Context mContext;
    private List<MotorModel> motorModelList;
    private List<Outlet> outletList;
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView namaMotor, hargaSewa, nameOutlet,mAlamat,mJarak,mBintang;
        public ImageView potoMotor;
        public CardView cardViewMotor;
		
		
        public MyViewHolder(View view)
        {
            super(view);

			nameOutlet = view.findViewById(R.id.titleOutlet);
			
            namaMotor = view.findViewById(R.id.namaMotor);
            hargaSewa = view.findViewById(R.id.hargaSewa);          
            potoMotor = view.findViewById(R.id.potoMotor);
			
            cardViewMotor = view.findViewById(R.id.cardViewMotor);
        }

    }
    public MotorsAdapter (Context mContext, List<MotorModel> motorModelList) {
        this.mContext = mContext;
        this.motorModelList = motorModelList;
    }

    
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.motor_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount()
    {
        // TODO: Implement this method
        return motorModelList.size();
    }
    
    
    @Override
    public void onBindViewHolder(final MyViewHolder holder,  final int position) {
        final MotorModel motor = motorModelList.get(position);
		
        holder.namaMotor.setText(motor.getNamaMotor());
        holder.hargaSewa.setText("Rp. "+ motor.getHargaSewaMotor() +" / hari");
        //loading album cover using Glide library
        Glide.with(mContext).load(motor.getPotoMotor()).into(holder.potoMotor);
        Glide.with(mContext).load(motor.getCardViewMotor());
        holder.cardViewMotor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     
                    Toast.makeText(mContext, motorModelList.get(position).getNamaMotor(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, MotorItemActivity.class);
                    //intent.putExtra(AlbumActivity.ALBUM, album);
                    intent.putExtra("nama",motorModelList.get(position).getNamaMotor());
                    intent.putExtra("harga",motorModelList.get(position).getHargaSewaMotor());
                    intent.putExtra("poto",motorModelList.get(position).getPotoMotor());
					
//                    Intent intent = new Intent(mContext, MotorItemActivity.class);
//                    intent.putExtra("NAMA_MOTOR", mnamaMotor.get(position));
//                    intent.putExtra("POTO_MOTOR", mPotoMotor.get(position));
                    mContext.startActivity(intent);
                }
            });


    }
}
  
