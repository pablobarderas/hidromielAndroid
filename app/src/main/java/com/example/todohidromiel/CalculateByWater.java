package com.example.todohidromiel;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.todohidromiel.db.DataBaseHelper;

public class CalculateByWater extends AppCompatActivity implements View.OnClickListener{

    private Button btnBack;
    private DataBaseHelper dataBaseHelper;
    private TextView water;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculate_by_water);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnBack = findViewById(R.id.btnBackWater);
        btnBack.setOnClickListener(this);

        water = findViewById(R.id.waterByWater);
        setData();


    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnBackWater){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
    }

    public void setData(){
        // Database
        dataBaseHelper = new DataBaseHelper(this);
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();

        Cursor cursor = db.query("recipes",null, null, null, null, null, null);
        if(cursor != null && cursor.moveToFirst()){

            do {

                int waterId = cursor.getColumnIndex("water");
                double waterValue = cursor.getDouble(waterId);
                water.setText(water.getText() + " " + waterValue);

            }while(cursor.moveToNext());

            db.close();
        }


    }
}