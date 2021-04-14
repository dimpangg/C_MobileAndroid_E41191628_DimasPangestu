package com.tugas.belajarintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE = 75;
    private static final int PICK_CONTACT_REQUEST = 1;
    Button buttonPindahActivity, buttonKirimData, buttonMaps, buttonCall, buttonSend,
    buttonSendTo, buttonPick;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPindahActivity = findViewById(R.id.buttonPindahActivity);
        buttonPindahActivity.setOnClickListener(this);

        buttonKirimData = findViewById(R.id.buttonKirimData);
        buttonKirimData.setOnClickListener(this);

        buttonMaps = findViewById(R.id.buttonPindahMaps);
        buttonMaps.setOnClickListener(this);

        buttonCall = findViewById(R.id.buttonCall);
        buttonCall.setOnClickListener(this);

        buttonSend = findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(this);

        buttonSendTo = findViewById(R.id.buttonSendTo);
        buttonSendTo.setOnClickListener(this);

        buttonPick = findViewById(R.id.button_pick);
        buttonPick.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonPindahActivity:
                Intent intentPindahActivity = new Intent(this, PindahActivity.class);
                startActivity(intentPindahActivity);
                break;
            case R.id.buttonKirimData:
                Intent intentKirimData = new Intent(this, ForResultActivity.class);
                intentKirimData.putExtra("extra_name", "Politeknik Negeri Jember");
                intentKirimData.putExtra("extra_umur", 40);
                startActivity(intentKirimData);
                break;
            case R.id.buttonPindahMaps:
                Intent intentMaps = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: -8.50380952257641, 114.1732344438952"));
                intentMaps.setPackage("com.google.android.apps.maps");
                if (intentMaps.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentMaps);
                }
                break;
            case R.id.buttonCall:
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:085336535128"));
                startActivity(intentCall);
                break;
            case R.id.buttonSend:
                Intent intentSend = new Intent(Intent.ACTION_SEND);
                intentSend.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                intentSend.setType("text/plain");

                Intent shareIntent = Intent.createChooser(intentSend, null);
                startActivity(shareIntent);
                break;
            case R.id.buttonSendTo:
                Intent intentSendTo =  new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:085336535128"));
                intentSendTo.putExtra("sms_body", "Hai Bro!");
                startActivity(intentSendTo);
                break;
            case R.id.button_pick:
                Intent intentPick = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
                intentPick.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(intentPick, PICK_CONTACT_REQUEST);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_CONTACT_REQUEST) {
            if (resultCode == RESULT_OK) {
                Uri contactUri = data.getData();
                String []projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};

                Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);
                cursor.moveToFirst();

                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(column);
                textViewResult.setText(number);
            }
        }
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_VALUE, 0);
                textViewResult.setText("Hasil: " + selectedValue);
            }
        }
    }
}