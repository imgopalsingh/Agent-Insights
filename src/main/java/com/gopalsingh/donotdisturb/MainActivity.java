package com.gopalsingh.donotdisturb;

import android.app.Activity;
import android.widget.Switch;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends Activity {

    private EditText statusEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusEditText = findViewById(R.id.statusEditText);

        if (isAppActive()) {
            String statusMessage = "Your custom status message goes here";
            displayStatusToast(statusMessage);
        }
        statusToggle = findViewById(R.id.statusToggle);
        statusTextView = findViewById(R.id.statusTextView);
        statusTextView = findViewById(R.id.statusTextViewInactive);

        statusToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                statusTextView.setText("Status: Active");
            } else {
                statusTextView.setText("Status: Inactive");
            }
        });
    }

    public void setStatus(View view) {
        String status = statusEditText.getText().toString();

        if (status.isEmpty()) {
            Toast.makeText(this, "Please enter a status", Toast.LENGTH_SHORT).show();
        } else {
            // You can save the status to a database or use it as needed.
            Toast.makeText(this, "Status set: " + status, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isAppActive() {

        return true;
    }

    private void displayStatusToast(String statusMessage) {
        Toast.makeText(this, "Status: " + statusMessage, Toast.LENGTH_LONG).show();
    }

    private Switch statusToggle;
    private TextView statusTextView;
}

