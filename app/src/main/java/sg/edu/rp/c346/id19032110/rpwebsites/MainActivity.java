package sg.edu.rp.c346.id19032110.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spnCateogry;
    Spinner spnSubCateogry;
    Button btnGO;
    ArrayList<String> alCateogry;
    ArrayAdapter<String> aaCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnCateogry = findViewById(R.id.spinnerCategory);
        spnSubCateogry = findViewById(R.id.spinnerSubCategory);
        btnGO = findViewById(R.id.buttonGO);

        alCateogry = new ArrayList<>();
        aaCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alCateogry);
        spnSubCateogry.setAdapter(aaCategory);

        final String[] strCategory = getResources().getStringArray(R.array.category);
        final String[] strRPSubCategory = getResources().getStringArray(R.array.RPsubCategory);
        final String[] strSOISubCategory = getResources().getStringArray(R.array.SOIsubCategory);

        spnCateogry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos = spnCateogry.getSelectedItemPosition();
                alCateogry.clear();
                switch (position) {
                    case 0:
                        alCateogry.addAll(Arrays.asList(strRPSubCategory));
                        spnSubCateogry.setSelection(0);
                        break;
                    case 1:
                        alCateogry.addAll(Arrays.asList(strSOISubCategory));
                        spnSubCateogry.setSelection(0);
                        break;
                    }
                    aaCategory.notifyDataSetChanged();
                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int category_pos = spnCateogry.getSelectedItemPosition();
                int subCategory_pos = spnSubCateogry.getSelectedItemPosition();
                alCateogry.clear();
                String url = null;
               // Intent intent = new Intent(MainActivity.this, rp_website.class);

                if (category_pos == 0 && subCategory_pos == 0){
                   url = "https://www.rp.edu.sg/";
                }
                else if (category_pos == 0 && subCategory_pos == 1){
                    url = "https://www.rp.edu.sg/student-life";
                }
                else if (category_pos == 1 && subCategory_pos == 0) {
                    url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                }
                else if (category_pos == 1 && subCategory_pos == 1) {
                    url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                }
                Intent intent = new Intent(MainActivity.this, rp_website.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }
}
