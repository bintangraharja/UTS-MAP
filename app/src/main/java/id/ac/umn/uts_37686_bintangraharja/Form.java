package id.ac.umn.uts_37686_bintangraharja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Form extends AppCompatActivity {
    private Button btnNext;
    private EditText nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        btnNext = findViewById(R.id.btnNext);
        nama = findViewById(R.id.nama);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(nama.getText())){
                    nama.setError("Kamu Siapa?!");
                }else{
                    Intent libsIntent = new Intent(Form.this, Library.class);
                    String toolbar = nama.getText().toString();
                    libsIntent.putExtra("Toolbar", toolbar);
                    startActivity(libsIntent);
                }

            }
        });
    }
}