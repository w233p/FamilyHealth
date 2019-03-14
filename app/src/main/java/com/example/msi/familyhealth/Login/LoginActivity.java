package com.example.msi.familyhealth.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.msi.familyhealth.R;

public class LoginActivity extends AppCompatActivity {

    private ImageButton backBt;
    private ImageButton confirmBt;
    private TextView titleTv;
    private TextView leftTv;
    private TextView rightTv;
    private TextView registerTv;
    private TextView forgetTv;
    private TextView usernameTv;
    private EditText usernameEd;
    private TextView passwordTx;
    private TextView passwordEd;
    private TextView phoneTv;
    private TextView phoneEd;
    private Button bottomBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        backBt = (ImageButton)findViewById(R.id.back_bt);
        confirmBt = (ImageButton)findViewById(R.id.confirm_bt);
        titleTv = (TextView)findViewById(R.id.title_tv);
        leftTv = (TextView)findViewById(R.id.left_tv);
        rightTv = (TextView)findViewById(R.id.right_tv);
        registerTv = (TextView)findViewById(R.id.register_tv);
        forgetTv = (TextView)findViewById(R.id.forget_tv);
        usernameTv = (TextView)findViewById(R.id.login_username_tv);
        usernameEd = (EditText) findViewById(R.id.login_username_ed);
        passwordTx = (TextView)findViewById(R.id.login_password_tx);
        passwordEd = (EditText)findViewById(R.id.login_password_ed);
        phoneTv = (TextView)findViewById(R.id.login_phone_tv);
        phoneEd = (EditText)findViewById(R.id.login_phone_ed);
        bottomBt = (Button)findViewById(R.id.bottom_bt);
        //点击测试
        registerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneTv.setVisibility(View.VISIBLE);
                phoneEd.setVisibility(View.VISIBLE);
                forgetTv.setVisibility(View.GONE);
                registerTv.setVisibility(View.GONE);
                bottomBt.setText(getResources().getString(R.string.register));
            }
        });

        titleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("title", "onClick: 111");
            }
        });

    }

}
