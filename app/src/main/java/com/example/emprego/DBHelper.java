package com.example.emprego;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME="empregos.db";
    private static final String PESSOA_TABLE_NAME ="pessoa";
    private static final String COLUMM_PESSOA_ID ="pessoaId";
    private static final String COLUMM_NAME="nome";
    private static final String COLUMM_CPF="cpf";
    private static final String COLUMM_EMAIL="email";
    private static final String COLUMM_TELEFONE="telefone";
    SQLiteDatabase db;
    private static final String TABLE_PESSOA_CREATE = "create table pessoa " +
            "(pessoaId integer primary key autoincrement, nome text not null, " +
            "email text, cpf text, telefone integer, vagaId integer);";

    private static final String EMPREGO_TABLE_NAME ="emprego";
    private static final String COLUMM_VAGA_ID ="vagaId";
    private static final String COLUMM_DESCRICAO="descricao";
    private static final String COLUMM_HORAS="horasSemana";
    private static final String COLUMM_VALOR="valor";

    private static final String TABLE_EMPREGO_CREATE = "create table emprego " +
            "(vagaId integer primary key autoincrement, descricao text not null, " +
            "horasSemana integer, valor float);";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_PESSOA_CREATE);
        db.execSQL(TABLE_EMPREGO_CREATE);

        this.db=db;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+ PESSOA_TABLE_NAME;
        db.execSQL(query);
        String query2 = "DROP TABLE IF EXISTS "+ EMPREGO_TABLE_NAME;
        db.execSQL(query2);
        this.onCreate(db);
    }

    public void inserirPessoa(Pessoa p){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMM_NAME, p.getNome());
        values.put(COLUMM_EMAIL, p.getEmail());
        values.put(COLUMM_CPF, p.getCpf());
        values.put(COLUMM_TELEFONE, p.getTelefone());
        db.insert(PESSOA_TABLE_NAME,null,values);
        db.close();
    }

    public void inserirEmprego(Emprego e){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMM_DESCRICAO, e.getDescricao());
        values.put(COLUMM_HORAS, e.getHorasSemana());
        values.put(COLUMM_VALOR, e.getValor());
        db.insert(EMPREGO_TABLE_NAME,null,values);
        db.close();
    }

    public String buscarSenha(String usuario){
        db=this.getReadableDatabase();
        String query = "select usuario, senha from "+ PESSOA_TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="não encontrado";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);
                if(a.equals(usuario)){
                    b=cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return b;
    }

    public ArrayList<Pessoa> listarPessoas() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + PESSOA_TABLE_NAME, null);
        ArrayList<Pessoa> courseModalArrayList = new ArrayList<>();

        if (cursorCourses.moveToFirst()) {
            do {
                Log.d("myTag", cursorCourses.getString(1));

//                courseModalArrayList.add(new Pessoa(cursorCourses.getString(1),
//                        cursorCourses.getString(4),
//                        cursorCourses.getString(2),
//                        cursorCourses.getString(3)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return courseModalArrayList;
    }

}
