package tomislav.kurtovic.com.happymelodyapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

public class Gracani extends AppCompatActivity {


    SQLiteDatabase gracaniDB;
    EditText imeUcenika, prezimeUcenika,aktivnostUcenika,rataUcenika;
    ListView listaGracani;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gracani);
        imeUcenika =  findViewById(R.id.imeUcenika);
        prezimeUcenika= findViewById(R.id.prezimeUcenika);
        aktivnostUcenika = findViewById(R.id.aktivnostUcenika);
        rataUcenika = findViewById(R.id.rataUcenika);


        // stvori novu ili otvori postojeću bazu pod
        try{
            gracaniDB = getApplicationContext().openOrCreateDatabase("UceniciGracani",MODE_PRIVATE,null);
            gracaniDB.execSQL("CREATE TABLE IF NOT EXISTS ucenici" +
              "(id integer primary key autoincrement ,ime VARCHAR , prezime VARCHAR , aktivnost VARCHAR, rata VARCHAR);");

            File baza  = getApplicationContext().getDatabasePath("UceniciGracani");
            if(baza.exists()){
                Toast.makeText(this,"Učenici uspješno učitani!",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"Neuspjeli pokušaj učitavanja",Toast.LENGTH_LONG).show();
            }


        }catch(Exception e){
            Log.e("NEUSPJEH","Nije uspjelo");
        }

/*
       if(isOpen()){
            populateListView();
       }
*/



    }


      // dodaje učenika u bazu podataka
    public void gumbPritisnut(View view){

        if(isEmpty(imeUcenika)){
            Toast.makeText(this,"Molim upišite sve podatke",Toast.LENGTH_LONG).show();
        }
        else {
            String ime = imeUcenika.getText().toString();
            String prezime = prezimeUcenika.getText().toString();
            String aktivnost = aktivnostUcenika.getText().toString();
            String rata = rataUcenika.getText().toString();

            gracaniDB.execSQL("INSERT INTO ucenici (ime,prezime,aktivnost,rata) VALUES ('" +
                    ime + "','" + prezime + "','" + aktivnost +"','" + rata + "');");

            imeUcenika.setText("");
            prezimeUcenika.setText("");
            aktivnostUcenika.setText("");
            rataUcenika.setText("");


        /* Ovaj dio koda stvara probleme
        
            Cursor c = gracaniDB.rawQuery("SELECT * FROM ucenici ORDER BY prezime",null);
           if(c.moveToFirst()) {
               listaGracani = findViewById(R.id.listaGracani);
               CustomCursorAdapter adapter = new CustomCursorAdapter(getApplicationContext(), c, 0);
               listaGracani.setAdapter(adapter);
           }
            c.close();
         */
        }


    }
    // provjerava jeli polje gdje se upisuju informacije prazno
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    public void populateListView(){

       Cursor c = gracaniDB.rawQuery("SELECT * FROM ucenici ORDER BY prezime",null);

       listaGracani = findViewById(R.id.listaGracani);
       CustomCursorAdapter adapter = new CustomCursorAdapter(this,c,0);
       listaGracani.setAdapter(adapter);

       adapter.changeCursor(c);
    }


    public boolean isOpen(){
        Cursor c = gracaniDB.rawQuery("SELECT * FROM ucenici",null);
        if (c.moveToFirst()) {
            c.close();
            return true;
        }else return false;

    }


}