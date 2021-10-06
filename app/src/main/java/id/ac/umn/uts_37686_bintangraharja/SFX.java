package id.ac.umn.uts_37686_bintangraharja;

import android.net.Uri;

import java.io.Serializable;

public class SFX implements Serializable {
    private final String judul, keterangan, URI;

    public SFX(String judul, String keterangan, String URI){
        this.judul = judul;
        this.keterangan = keterangan;
        this.URI = URI;
    }
    public String getJudul(){return this.judul;}
    public String getKeterangan(){return this.keterangan;}
    public Uri getUri(){return Uri.parse(this.URI);}
}
