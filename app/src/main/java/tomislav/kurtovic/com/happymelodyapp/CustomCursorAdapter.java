package tomislav.kurtovic.com.happymelodyapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomCursorAdapter extends CursorAdapter {


    public CustomCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.custom_listview,parent,false);
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView ime = view.findViewById(R.id.imeNaListi);
        TextView prezime = view.findViewById(R.id.prezimeNaListi);
        TextView aktivnost = view.findViewById(R.id.aktivnostNaListi);
        TextView rata = view.findViewById(R.id.rataNaListi);

        String imeUcenika = cursor.getString(cursor.getColumnIndexOrThrow("ime"));
        String prezimeUcenika = cursor.getString(cursor.getColumnIndexOrThrow("prezime"));
        String aktivnostUcenika = cursor.getString(cursor.getColumnIndexOrThrow("aktivnost"));
        String rataUcenika = cursor.getString(cursor.getColumnIndexOrThrow("rata"));

        ime.setText(imeUcenika);
        prezime.setText(prezimeUcenika);
        aktivnost.setText(aktivnostUcenika);
        rata.setText(rataUcenika);

    }
}
