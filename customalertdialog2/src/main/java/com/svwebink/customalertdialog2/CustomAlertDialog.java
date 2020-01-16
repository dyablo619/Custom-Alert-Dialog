package com.svwebink.customalertdialog2;

import android.content.Context;
import android.widget.Toast;

public class CustomAlertDialog {
    public static void s(Context c, String message)
    {
        Toast.makeText(c,message,Toast.LENGTH_LONG).show();
    }
}
