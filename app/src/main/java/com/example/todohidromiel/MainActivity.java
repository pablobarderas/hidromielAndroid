package com.example.todohidromiel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnIngredientsEdit;
    private Button btnCalculateByWater;
    private Button btnCalculateByHoney;
    private Button btnCalculateByYeast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Index buttons
        btnIngredientsEdit = findViewById(R.id.btnIngredientsEdit);
        btnCalculateByWater = findViewById(R.id.btnCalculateByWater);
        btnCalculateByHoney = findViewById(R.id.btnCalculateByHoney);
        btnCalculateByYeast = findViewById(R.id.btnCalculateByYeast);

        // onclickListeners
        btnIngredientsEdit.setOnClickListener(this);
        btnCalculateByWater.setOnClickListener(this);
        btnCalculateByHoney.setOnClickListener(this);
        btnCalculateByYeast.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // Navegation
        if (view.getId() == R.id.btnIngredientsEdit) {
            Intent intent = new Intent(this, EditBaseIngredients.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btnCalculateByWater) {
            Intent intent = new Intent(this, CalculateByWater.class);
            startActivity(intent);

        } else if (view.getId() == R.id.btnCalculateByHoney) {

        } else if (view.getId() == R.id.btnCalculateByYeast) {

        }

    }
}