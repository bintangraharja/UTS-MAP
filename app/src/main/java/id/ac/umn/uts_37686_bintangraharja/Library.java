package id.ac.umn.uts_37686_bintangraharja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Objects;

public class Library extends AppCompatActivity {
    private LinkedList<SFX> mSFX = new LinkedList<>();
    private RecyclerView recyclerView;
    LibraryAdapter mAdapter;
    ImageButton btnDel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        Intent formIntent = getIntent();
        String nama = formIntent.getStringExtra("Toolbar");
        Objects.requireNonNull(getSupportActionBar()).setTitle(nama);
        Toast.makeText(Library.this,"Selamat Datang, " + nama, Toast.LENGTH_LONG).show();

        seedSFX();

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mAdapter = new LibraryAdapter(this, mSFX);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnDel = findViewById(R.id.btnDel);
    }
    public void seedSFX(){
        mSFX.add(new SFX("Bwah", "favorit", "android.resource://"+ getPackageName()+"/"+ R.raw.bwah));
        mSFX.add(new SFX("Good Job", "anime", "android.resource://"+ getPackageName()+"/"+ R.raw.goodjob));
        mSFX.add(new SFX("Tuturu", "anime", "android.resource://"+ getPackageName()+"/"+ R.raw.tuturu));
        mSFX.add(new SFX("Mario Game Over", "game", "android.resource://"+ getPackageName()+"/"+ R.raw.mario_death));
        mSFX.add(new SFX("Mission Complete GTA SA", "game", "android.resource://"+ getPackageName()+"/"+ R.raw.gta));

    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.profile:
                Intent profileIntent = new Intent(Library.this, Profile.class);
                startActivity(profileIntent);
                return true;

            case R.id.main:
                Intent mainIntent = new Intent(Library.this, MainActivity.class);
                startActivity(mainIntent);
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }
}