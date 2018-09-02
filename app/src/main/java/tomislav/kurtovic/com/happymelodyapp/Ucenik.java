package tomislav.kurtovic.com.happymelodyapp;

public class Ucenik {


    private int _id;


    private String _ime;


    private String _prezime;


    private String _aktivnost;


    private String _rata;

    public Ucenik(){
    }

    public Ucenik(int id,String ime, String prezime, String aktivnost, String rata) {
        this._id=id;
        this._ime = ime;
        this._prezime = prezime;
        this._aktivnost = aktivnost;
        this._rata = rata;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_ime() {
        return _ime;
    }

    public void set_ime(String _ime) {
        this._ime = _ime;
    }

    public String get_prezime() {
        return _prezime;
    }

    public void set_prezime(String _prezime) {
        this._prezime = _prezime;
    }

    public String get_aktivnost() {
        return _aktivnost;
    }

    public void set_aktivnost(String _aktivnost) {
        this._aktivnost = _aktivnost;
    }

    public String get_rata() {
        return _rata;
    }

    public void set_rata(String _rata) {
        this._rata = _rata;
    }
}
