package com.svwebink.customalertdialog2;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/*Quick Comment*/

public class CustomAlertDialog extends Dialog implements View.OnClickListener
{

    private String dialogTitle, dialogContent;
    private int dialogType;
    private onCustomDialogClickListener mCancelClickListener;
    private onCustomDialogClickListener mConfirmClickListener;
    private Button mConfirmButton, mCancelButton;
    private boolean showCancelBtn, showConfirmBtn, setEditText;
    private String confirmBtnColor, cancelBtnColor, cancelBtnText, confirmBtnTxt;
    private EditText editText;

    public CustomAlertDialog(Activity activity)
    {
        super(activity);
        this.dialogContent = "";
        this.dialogTitle = "";
        this.dialogType = 0;
        this.showCancelBtn = false;
        this.showConfirmBtn = true;
        this.confirmBtnColor = "";
        this.cancelBtnColor = "";
        this.cancelBtnText = "";
        this.confirmBtnTxt = "";
    }

    public interface onCustomDialogClickListener
    {
        void onClick(CustomAlertDialog customAlertDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);

        mConfirmButton = findViewById(R.id.mConfirmBtn);
        mCancelButton = findViewById(R.id.mCancelBtn);

        mConfirmButton.setOnClickListener(this);
        mCancelButton.setOnClickListener(this);
    }

    public void setCancelBtnTxt(String cancelBtnText)
    {
        this.cancelBtnText = cancelBtnText;
    }

    public void setConfirmBtnTxt(String confirmBtnTxt)
    {
        this.confirmBtnTxt = confirmBtnTxt;
    }

    public void setCancelBtn(boolean showCancelBtn)
    {
        this.showCancelBtn = showCancelBtn;
    }

    public void setConfirmBtn(boolean showConfirmBtn)
    {
        this.showConfirmBtn = showConfirmBtn;
    }

    public void setConfirmBtnColor(String confirmBtnColor)
    {
        this.confirmBtnColor = confirmBtnColor;
    }

    public void setCancelBtnColor(String cancelBtnColor)
    {
        this.cancelBtnColor = cancelBtnColor;
    }

    public void setDialogTitle(String dialogTitle)
    {
        this.dialogTitle = dialogTitle;
    }

    public void setDialogContent(String dialogContent)
    {
        this.dialogContent = dialogContent;
    }

    public void setDialogType(int dialogType)
    {
        this.dialogType = dialogType;
    }

    public void customEditText(EditText editText)
    {
        this.editText = editText;
    }

    public void setEditText(boolean setEditText)
    {
        this.setEditText = setEditText;
    }

    public CustomAlertDialog setCancelClickListener(onCustomDialogClickListener listener)
    {
        mCancelClickListener = listener;
        return this;
    }

    public CustomAlertDialog setConfirmClickListener(onCustomDialogClickListener listener)
    {
        mConfirmClickListener = listener;
        return this;
    }

    @Override
    public void onStart()
    {
        TextView displaymsgel = findViewById(R.id.txt_dia);
        displaymsgel.setText(this.dialogContent);

        TextView txt_dia_title = findViewById(R.id.txt_dia_title);
        txt_dia_title.setText(this.dialogTitle);

        ImageView dialogIcon = findViewById(R.id.dialogIcon);

        if (this.dialogType == 1) {
            dialogIcon.setImageResource(R.drawable.ic_green_tick);
        } else if (this.dialogType == 2) {
            dialogIcon.setImageResource(R.drawable.ic_warning_black_24dp);
        }

        if(!this.showCancelBtn)
        {
            mCancelButton.setVisibility(View.GONE);
        }

        if(!this.showConfirmBtn)
        {
            mConfirmButton.setVisibility(View.GONE);
        }

        if(mConfirmButton != null && !confirmBtnColor.equals(""))
        {
            int color = Color.parseColor(confirmBtnColor);
            mConfirmButton.setBackgroundColor(color);
        }

        if(mCancelButton != null && !cancelBtnColor.equals(""))
        {
            int color = Color.parseColor(cancelBtnColor);
            mCancelButton.setBackgroundColor(color);
        }

        if(mCancelButton != null && !cancelBtnText.equals(""))
        {
            mCancelButton.setText(cancelBtnText);
        }

        if(mConfirmButton != null && !confirmBtnTxt.equals(""))
        {
            mConfirmButton.setText(confirmBtnTxt);
        }

        if(this.setEditText)
        {
            LinearLayout customLayout = findViewById(R.id.customLayout);
            customLayout.addView(this.editText);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.mCancelBtn)
        {
            if(mCancelClickListener != null)
            {
                mCancelClickListener.onClick(CustomAlertDialog.this);
            }
            else
            {
                dismiss();
            }
        }
        else if(v.getId() == R.id.mConfirmBtn)
        {
            if(mConfirmClickListener != null)
            {
                mConfirmClickListener.onClick(CustomAlertDialog.this);
            }
            else
            {
                dismiss();
            }
        }
    }
}
