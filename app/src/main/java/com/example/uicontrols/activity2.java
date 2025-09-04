package com.example.uicontrols;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import androidx.annotation.Nullable;

public class activity2 extends Activity {

    EditText etName, etEmail;
    RadioGroup radioGroupGender;
    CheckBox cbML, cbDS, cbWeb;
    Spinner spinnerYear;
    Button btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);



        // Initialize views
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        cbML = findViewById(R.id.cbML);
        cbDS = findViewById(R.id.cbDS);
        cbWeb = findViewById(R.id.cbWeb);
        spinnerYear = findViewById(R.id.spinnerYear);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Spinner data
        String[] years = {"2023", "2024", "2025", "2026"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, years);
        spinnerYear.setAdapter(adapter);

        // Handle submit
        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();

            // Validation
            if (name.isEmpty()) {
                etName.setError("Please enter your name");
                etName.requestFocus();
                return;
            }
            if (email.isEmpty()) {
                etEmail.setError("Please enter your email");
                etEmail.requestFocus();
                return;
            }

            // Gender
            int genderId = radioGroupGender.getCheckedRadioButtonId();
            String gender = "Not selected";
            if (genderId != -1) {
                RadioButton rbGender = findViewById(genderId);
                gender = rbGender.getText().toString();
            }

            // Courses
            StringBuilder courses = new StringBuilder();
            if (cbML.isChecked()) courses.append("Machine Learning ");
            if (cbDS.isChecked()) courses.append("Data Science ");
            if (cbWeb.isChecked()) courses.append("Web Development ");

            // Graduation Year
            String year = spinnerYear.getSelectedItem().toString();

            // Send data to activity3
            Intent intent = new Intent(activity2.this, activity3.class);
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("gender", gender);
            intent.putExtra("courses", courses.toString());
            intent.putExtra("year", year);
            startActivity(intent);

            // Show confirmation
            Toast.makeText(activity2.this,
                    "Details submitted successfully",
                    Toast.LENGTH_LONG).show();
        });
    }
}
