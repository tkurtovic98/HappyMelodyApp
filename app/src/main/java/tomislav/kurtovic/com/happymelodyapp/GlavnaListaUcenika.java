package tomislav.kurtovic.com.happymelodyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class GlavnaListaUcenika extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavna_lista_ucenika);
    }

    public void gracaniPritisnut(View view) {
        Intent gracaniIntent = new Intent(GlavnaListaUcenika.this,Gracani.class);
        startActivity(gracaniIntent);

    }

    public void markusevacPritisnut(View view) {
        Intent markusevacIntent = new Intent(GlavnaListaUcenika.this,Markusevac.class);
        startActivity(markusevacIntent);
    }

    public void miocPritisnut(View view) {
        Intent miocIntent = new Intent(GlavnaListaUcenika.this,Mioc.class);
        startActivity(miocIntent);
    }

    public void srebrnjakPritisnut(View view) {
        Intent srebrnjakIntent = new Intent(GlavnaListaUcenika.this,Srebrnjak.class);
        startActivity(srebrnjakIntent);
    }
}
