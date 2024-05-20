package com.example.todohidromiel;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.todohidromiel.adapters.CustomSpinnerAdapter;
import com.example.todohidromiel.db.DataBaseHelper;
import com.example.todohidromiel.db.DbRecipe;

import java.util.Arrays;
import java.util.List;

public class EditBaseIngredients extends AppCompatActivity implements View.OnClickListener{

    private EditText npWater, npHoney, npYeast;

    private Spinner spinnerWater, spinnerHoney, spinnerYeast;

    private Button btnBackWaterEditIngredients;

    private EditText inputWater, inputHoney, inputYeast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_base_ingredients);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_edit), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get spinners
        spinnerYeast = findViewById(R.id.spinnerGramsYeast);
        spinnerWater = findViewById(R.id.spinnerLitersWater);
        spinnerHoney = findViewById(R.id.spinnerGramsHoney);

        // Get string-array items from resources
        List<String> spinnerItemsGrams = Arrays.asList(getResources().getStringArray(R.array.spinner_values_Grams));
        List<String> spinnerItemsLiters = Arrays.asList(getResources().getStringArray(R.array.spinner_values_Liters));

        // Instance and apply adapter
        CustomSpinnerAdapter adapterGrams = new CustomSpinnerAdapter(this, spinnerItemsGrams);
        CustomSpinnerAdapter adapterLiters = new CustomSpinnerAdapter(this, spinnerItemsLiters);

        spinnerYeast.setAdapter(adapterGrams);
        spinnerWater.setAdapter(adapterLiters);
        spinnerHoney.setAdapter(adapterGrams);

        // Button initialize
        btnBackWaterEditIngredients = findViewById(R.id.btnBackEditIngredients);
        btnBackWaterEditIngredients.setOnClickListener(this);

        // Get inputs
        inputWater = findViewById(R.id.inputWater);
        inputHoney = findViewById(R.id.inputHoney);
        inputYeast = findViewById(R.id.inputYeast);



    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnBackEditIngredients){

            // Insert data on database
            String water = inputWater.getText().toString();
            DbRecipe dbHelper = new DbRecipe(this);


            if (!water.isEmpty()){
                dbHelper.saveOrUpdateData(water);
            }

            // Back to index view
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }




}