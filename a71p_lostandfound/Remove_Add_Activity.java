package com.example.a71p_lostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a71p_lostandfound.data.DatabaseHelper;
import com.example.a71p_lostandfound.model.AdvertisedItem;

public class Remove_Add_Activity extends AppCompatActivity {
    DatabaseHelper db;

    TextView itemName;
    TextView itemDate;
    TextView itemLocation;
    TextView finderName;
    TextView finderPhone;

    Button deleteAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_add);

        db = new DatabaseHelper(this);
        deleteAddButton = findViewById(R.id.deleteAddButton);

        //finderName = findViewById(R.id.finderTextView);
        //finderPhone = findViewById(R.id.phoneNumberFinderTextView);
        itemName = findViewById(R.id.itemTextView);
        itemDate = findViewById(R.id.dateTextView);
        itemLocation = findViewById(R.id.locationTextView);


        Intent intent = getIntent();
        String  reievedItemName = intent.getStringExtra("selectedadd");

        itemName.setText(reievedItemName);

        int foundAddNumber = db.findAddNumber(reievedItemName);

        AdvertisedItem recievedAdd = db.findItem(foundAddNumber);

        //finderName.setText(recievedAdd.getUserName());
        //finderPhone.setText(recievedAdd.getUserPhone());
        itemName.setText(recievedAdd.getItemName());
        itemDate.setText(recievedAdd.getFounddate());
        itemLocation.setText(recievedAdd.getFoundLocation());

        deleteAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.removeAdd(foundAddNumber);
                Intent intent1 = new Intent(Remove_Add_Activity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}