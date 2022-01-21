package com.hiddevanleeuwen.amazighapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ItemAdapter extends FirebaseRecyclerAdapter<Woord, ItemAdapter.ItemViewholder> {
    MediaPlayer mediaPlayer;
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    Context x;
    public ItemAdapter(@NonNull FirebaseRecyclerOptions<Woord> options, Context context) {
        super(options);
        x = context;
    }
    @Override
    protected void onBindViewHolder(@NonNull ItemAdapter.ItemViewholder holder, int position, @NonNull Woord model) {
            holder.tvWoordned.setText(model.getWoordned());
            holder.tvWoordamz.setText(model.getWoordamz());
            holder.btSound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String audioUrl = model.getAudiopath();
                    mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource(audioUrl);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Glide.with(x).load(model.getImagepath()).into(holder.ivWoord);
    }

    @NonNull
    @Override
    public ItemAdapter.ItemViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.woord_layout, parent, false);
        return new ItemAdapter.ItemViewholder(view);
    }

    public class ItemViewholder extends RecyclerView.ViewHolder {
        TextView tvWoordned, tvWoordamz;
        ImageView ivWoord;
        View btSound;
        public ItemViewholder(@NonNull View itemView) {
            super(itemView);
            tvWoordned = itemView.findViewById(R.id.tvWoordned2);
            tvWoordamz = itemView.findViewById(R.id.tvWoordamz2);
            ivWoord = itemView.findViewById(R.id.ivWoord2);
            btSound = itemView.findViewById(R.id.btn);
        }
    }
}

