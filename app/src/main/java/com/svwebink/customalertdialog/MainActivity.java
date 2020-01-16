package com.svwebink.customalertdialog;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.svwebink.customalertdialog2.CustomAlertDialog;
import java.util.Objects;

public class MainActivity extends Activity implements View.OnClickListener
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button customDialogBtn = findViewById(R.id.dialogBtn);
        customDialogBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.dialogBtn:
                final EditText autohrizedPassField = new EditText(MainActivity.this);
                autohrizedPassField.setTextColor(Color.BLACK);
                autohrizedPassField.setTextSize(20);
                autohrizedPassField.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                autohrizedPassField.setGravity(Gravity.CENTER_HORIZONTAL);

                CustomAlertDialog customDialog = new CustomAlertDialog(MainActivity.this);
                Objects.requireNonNull(customDialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
                customDialog.setCancelBtn(true);
                customDialog.setCancelBtnTxt("Cancel");
                customDialog.setConfirmBtnTxt("Submit");
                customDialog.setDialogTitle("Custom Dialog Title");
                customDialog.setDialogContent("Custom Dialog Content");
                customDialog.setEditText(true);
                customDialog.customEditText(autohrizedPassField);
                customDialog.setDialogType(2);
                customDialog.setCancelClickListener(new CustomAlertDialog.onCustomDialogClickListener() {
                    @Override
                    public void onClick(CustomAlertDialog customDialog) {
                        customDialog.dismiss();
                        Toast.makeText(MainActivity.this,"Dismissing Dialog",Toast.LENGTH_LONG).show();
                    }
                });
                customDialog.setConfirmClickListener(new CustomAlertDialog.onCustomDialogClickListener() {
                    @Override
                    public void onClick(CustomAlertDialog customDialog) {
                        Toast.makeText(MainActivity.this,"Clicking t he confirm button",Toast.LENGTH_LONG).show();
                    }
                });
                customDialog.show();
                break;
            case R.id.dialogBtn2:
                break;
        }
    }
}
