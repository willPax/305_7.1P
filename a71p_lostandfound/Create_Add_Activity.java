package com.example.a71p_lostandfound;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a71p_lostandfound.data.DatabaseHelper;
import com.example.a71p_lostandfound.model.AdvertisedItem;
import com.example.a71p_lostandfound.util.Util;

import java.util.Locale;

public class Create_Add_Activity extends AppCompatActivity {
    DatabaseHelper db;

    EditText userName, userPhone, userItemName, foundDate, foundLoc;
    Button saveItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_add);

        userName = findViewById(R.id.userEnteredName);
        userPhone = findViewById(R.id.userEnteredPhone);
        userItemName = findViewById(R.id.userEnteredItem);
        foundDate = findViewById(R.id.itemFoundDateEditText);
        foundLoc =findViewById(R.id.locationFoundEditText);

        saveItem = findViewById(R.id.saveAddButton);
        db = new DatabaseHelper(this);

        saveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userName.getText().toString();
                String useritem = userItemName.getText().toString();
                String phonenumber = userPhone.getText().toString();
                String founddate = foundDate.getText().toString();
                String foundloc = foundLoc.getText().toString();

                long result = db.insertNewUser(new AdvertisedItem(username, phonenumber, useritem, founddate, foundloc));

                if (result > 0){
                    Intent intent = new Intent(Create_Add_Activity.this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Create_Add_Activity.this, "Error Adding Item to Database", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}