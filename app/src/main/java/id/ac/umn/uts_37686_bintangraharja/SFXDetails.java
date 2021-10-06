package id.ac.umn.uts_37686_bintangraharja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class SFXDetails extends AppCompatActivity {
    private TextView judul, keterangan;
    private Button btnPlay;

    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfxdetails);
        Intent sfxIntent = getIntent();
        String nama = sfxIntent.getStringExtra("Judul Sound");
        Objects.requireNonNull(getSupportActionBar()).setTitle(nama);

        judul = findViewById(R.id.judul);
        keterangan = findViewById(R.id.keterangan);
        btnPlay = findViewById(R.id.btnPlay);

        Bundle bundle = sfxIntent.getExtras();
        SFX sfx = (SFX) bundle.getSerializable("Sound Detail");
        judul.setText(sfx.getJudul());
        keterangan.setText(sfx.getKeterangan());

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(SFXDetails.this, sfx.getUri());
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                    }
                });
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        mediaPlayer.stop();
        mediaPlayer.release();
        return true;
    }
}