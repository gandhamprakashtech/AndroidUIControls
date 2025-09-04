package com.example.uicontrols;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class activity3 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        TextView tvResult = findViewById(R.id.tvResult);

        // Get data from Intent
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String gender = getIntent().getStringExtra("gender");
        String courses = getIntent().getStringExtra("courses");
        String year = getIntent().getStringExtra("year");

        // Format nicely
        String finalResult = "👤 Name: " + name + "\n\n"
                + "📧 Email: " + email + "\n\n"
                + "⚧ Gender: " + gender + "\n\n"
                + "📚 Courses: " + courses + "\n\n"
                + "🎓 Year of Graduation: " + year;

        tvResult.setText(finalResult);
    }
}
