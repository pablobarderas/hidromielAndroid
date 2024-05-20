package com.example.todohidromiel.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DbRecipe extends DataBaseHelper{
    Context context;
    public DbRecipe(Context context) {
        super(context);
        this.context = context;
    }

    public void saveOrUpdateData(String water){
        // Database
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        // Get water id
        int waterId = getWaterId();

        // Save data on db
        ContentValues values = new ContentValues();
        if (!water.isEmpty()){
            values.put("water", Double.valueOf(water));
        }
        //values.put("honey", Double.valueOf(inputHoney.toString()));
        //values.put("yeast", Double.valueOf(inputYeast.toString()));

        // INSERT OR UPDATE DATA
        if (waterId == -1){
            long newRowId = db.insert("recipes", null, values);
            if (newRowId != -1) {
                Toast.makeText(context, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Error al insertar datos", Toast.LENGTH_SHORT).show();
            }
        }else {
            db.update("recipes", values, "_id = ?", new String[] { String.valueOf(waterId) });
            Toast.makeText(context, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();

        }

        db.close();

    }


    // SEARCH WATER ID
    public int getWaterId(){
        // Database
        DataBaseHelper dataBaseHelperRead = new DataBaseHelper(context);
        SQLiteDatabase dbRead = dataBaseHelperRead.getReadableDatabase();
        int waterId = -1;

        Cursor cursor = dbRead.query("recipes",null, null, null, null, null, null);
        if(cursor != null && cursor.moveToFirst()){
            waterId = cursor.getColumnIndex("water");
            cursor.close();
        }
        dbRead.close();
        return waterId;
    }

}
