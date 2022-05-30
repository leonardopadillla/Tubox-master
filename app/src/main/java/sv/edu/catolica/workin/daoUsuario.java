package sv.edu.catolica.workin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class daoUsuario {

    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd="BDUsuarios";
    String tabla="create table if not exists usuariosdb(id integer primary key autoincrement, nombre text, personalizada text, pass text, altura text, peso text, edad text, resultado text, colorfav text, " +
            "rutinaPecho integer, rutinaAbdomen integer, rutinaPiernas integer, rutinaBrazo integer, rutinaTodoCuerpo integer)";

    public daoUsuario(Context c) {
        this.c=c;
        sql=c.openOrCreateDatabase(bd,c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u=new Usuario();
    }

    public boolean insertUsuario(Usuario u){
        if (buscar(u.getNombre())==0){
            ContentValues cv=new ContentValues();
            cv.put("nombre", u.getNombre());
            cv.put("personalizada", u.getPersonalizada());
            cv.put("colorfav", u.getColorfav());
            cv.put("pass", u.getPassword());
            cv.put("altura", u.getAltura());
            cv.put("peso", u.getPeso());
            cv.put("edad", u.getEdad());
            cv.put("resultado", u.getResultado());
            cv.put("rutinaPecho", u.getRutinaPecho());
            cv.put("rutinaAbdomen", u.getRutinaAbdomen());
            cv.put("rutinaPiernas", u.getRutinaPiernas());
            cv.put("rutinaBrazo", u.getRutinaBrazo());
            cv.put("rutinaTodoCuerpo", u.getRutinaTodoCuerpo());
            Log.d("user", cv.toString());
            return (sql.insert("usuariosdb", null,cv)>0);
        }else{
            return false;
        }
    }

    public int buscar(String u){
         int x=0;
         lista=selectUsuarios();
         for (Usuario us:lista){
            if (us.getNombre().equals(u)){
                x++;
            }
         }
         return x;
    }

    public ArrayList<Usuario> selectUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor cr= sql.rawQuery("select * from usuariosdb",null);
        if (cr!=null&&cr.moveToFirst()){
            do {
                Usuario u=new Usuario();
                u.setId(cr.getInt(0));
                u.setNombre(cr.getString(1));
                u.setPersonalizada(cr.getString(2));
                u.setPassword(cr.getString(3));
                u.setAltura(cr.getString(4));
                u.setPeso(cr.getString(5));
                u.setEdad(cr.getString(6));
                u.setResultado(cr.getString(7));
                u.setColorfav(cr.getString(8));
                u.setRutinaPecho(cr.getInt(9));
                u.setRutinaAbdomen(cr.getInt(10));
                u.setRutinaPiernas(cr.getInt(11));
                u.setRutinaBrazo(cr.getInt(12));
                u.setRutinaTodoCuerpo(cr.getInt(13));

                //Log.d("crDaoColor", "Nombre:" + cr.getString(1) + "Color: " + cr.getString(8));
                Log.d("crDao", DatabaseUtils.dumpCursorToString(cr));
                lista.add(u);
            }while (cr.moveToNext());
        }
        return lista;
    }

    public int login(String u, String p){
        int a=0;
        Cursor cr = sql.rawQuery("select * from usuariosdb", null);
        if (cr!=null&&cr.moveToFirst()){
            do {
                if (cr.getString(1).equals(u)&&cr.getString(3).equals(p)){
                    a++;
                }
            }while (cr.moveToNext() );
        }
        return a;
    }

    public Usuario getUsuario(String u, String p){
        lista = selectUsuarios();
        for (Usuario us:lista){
            if (us.getNombre().equals(u)&&us.getPassword().equals(p)){
                return us;
            }
        }
        return null;
    }
    public Usuario getUsuariorecover(String u){
        lista = selectUsuarios();
        for (Usuario us:lista){
            if (us.getNombre().equals(u)){
                return us;
            }
        }
        return null;
    }

    public Usuario getUsuarioById(int id){
        lista = selectUsuarios();
        for (Usuario us:lista){
            if (us.getId()== id){
                return us;
            }
        }
        return null;
     }

     public boolean updateUsuario(Usuario u){
         ContentValues cv=new ContentValues();
         cv.put("nombre", u.getNombre());
         cv.put("personalizada", u.getPersonalizada());
         cv.put("pass", u.getPassword());
         cv.put("altura", u.getAltura());
         cv.put("peso", u.getPeso());
         cv.put("edad", u.getEdad());
         cv.put("resultado", u.getResultado());
         cv.put("rutinaPecho", u.getRutinaPecho());
         cv.put("rutinaAbdomen", u.getRutinaAbdomen());
         cv.put("rutinaPiernas", u.getRutinaPiernas());
         cv.put("rutinaBrazo", u.getRutinaBrazo());
         cv.put("rutinaTodoCuerpo", u.getRutinaTodoCuerpo());
         cv.put("colorfav", u.getColorfav());
         return (sql.update("usuariosdb",cv,"id="+u.getId(),null)>0);
     }
}
