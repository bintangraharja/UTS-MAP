package id.ac.umn.uts_37686_bintangraharja;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.SFXHolder> {
    private LinkedList<SFX> mSFX ;
    private LayoutInflater mInflater;
    private Context mContext;

    public LibraryAdapter(Context mContext, LinkedList<SFX> mSFX){
        this.mSFX = mSFX;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public LibraryAdapter.SFXHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemview = mInflater.inflate(R.layout.list_sfx, parent, false);
        return new SFXHolder(mItemview,this);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryAdapter.SFXHolder holder, @SuppressLint("RecyclerView") int position) {
        SFX mSound = mSFX.get(holder.getAdapterPosition());
        holder.judul.setText(mSound.getJudul());
        holder.keterangan.setText(mSound.getKeterangan());

        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mSound.getJudul()+ " Telah dihapus", Toast.LENGTH_LONG).show();
                mSFX.remove(holder.getAdapterPosition());
                LibraryAdapter.this.notifyItemRemoved(holder.getAdapterPosition());

            }
        });

    }

    @Override
    public int getItemCount() {
        return mSFX.size();
    }
    class SFXHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private SFX mSound;
        private TextView judul, keterangan;
        private ImageButton btnDel;
        private int position;
        final LibraryAdapter mAdapter;

        public SFXHolder(@NonNull View itemView, LibraryAdapter mAdapter){
            super(itemView);
            judul = itemView.findViewById(R.id.judul);
            keterangan = itemView.findViewById(R.id.keterangan);
            btnDel = itemView.findViewById(R.id.btnDel);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            position = getLayoutPosition();
            mSound = mSFX.get(position);
            Intent detailIntent = new Intent(mContext, SFXDetails.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("Sound Detail", mSound);
            detailIntent.putExtras(bundle);
            String nama = judul.getText().toString();
            detailIntent.putExtra("Judul Sound", nama);
            mContext.startActivity(detailIntent);

        }
    }
}
