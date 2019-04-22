package com.example.msi.familyhealth.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.msi.familyhealth.Data.DbItemBean;
import com.example.msi.familyhealth.Data.DbMemberBean;
import com.example.msi.familyhealth.Data.DbProjectBean;
import com.example.msi.familyhealth.Main.MainActivity;
import com.example.msi.familyhealth.MvpBase.BaseActivity;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.ExitApplication;
import com.example.msi.familyhealth.View.TitleView;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

/**
 * 登陆注册界面
 * 控制控件的显隐实现功能转化
 */
public class LoginActivity extends BaseActivity<LoginContacts.ILoginPresenter> implements LoginContacts.ILoginView {

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
    private TitleView titleView;

    public int state;
    public static final int LOGIN = 0;
    public static final int REGISTER = 1;
    public static final int CHANGE_PASSWORD = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        ExitApplication.getInstance().addActivity(this);

        initView();

        addListener();


        initItemDataBase();
//登陆写好就删除
//        initMemberData();
    }

//    /**
//     * 数据库无用户数据时初始化一个本人的数据
//     */
//    private void initMemberData() {
//        if (DataSupport.findAll(DbMemberBean.class).size() == 0) {
//            DbMemberBean dbMemberBean = new DbMemberBean().setMemberName("自己");
//            dbMemberBean.save();
//        }
//        Log.e("11", DataSupport.findAll(DbMemberBean.class).get(0).getMemberName());
//    }

    @Override
    public void initView() {
        backBt = (ImageButton) findViewById(R.id.back_bt);
        confirmBt = (ImageButton) findViewById(R.id.confirm_bt);
        titleTv = (TextView) findViewById(R.id.title_tv);
        leftTv = (TextView) findViewById(R.id.left_tv);
//        rightTv = (TextView) findViewById(R.id.right_tv);
        registerTv = (TextView) findViewById(R.id.register_tv);
        forgetTv = (TextView) findViewById(R.id.forget_tv);
        usernameTv = (TextView) findViewById(R.id.login_username_tv);
        usernameEd = (EditText) findViewById(R.id.login_username_ed);
        passwordTx = (TextView) findViewById(R.id.login_password_tx);
        passwordEd = (EditText) findViewById(R.id.login_password_ed);
        phoneTv = (TextView) findViewById(R.id.login_phone_tv);
        phoneEd = (EditText) findViewById(R.id.login_phone_ed);
        bottomBt = (Button) findViewById(R.id.bottom_bt);
        titleView = (TitleView) findViewById(R.id.login_titleView);

        state = LOGIN;
    }

    @Override
    public void addListener() {

        bottomBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().buttomBtClick(state);
            }
        });

        //3种界面变换
        registerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRegisterView();
            }
        });

        forgetTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChangePasswordView();
            }
        });

        backBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLoginView();
            }
        });
    }

    @Override
    public LoginContacts.ILoginPresenter onBindPresenter() {
        return new LoginPresenter(this);
    }

    /**
     * 设置为登陆布局
     */
    @Override
    public void setLoginView() {
        phoneTv.setVisibility(View.GONE);
        phoneEd.setVisibility(View.GONE);
        phoneTv.startAnimation(aout_animation());
        phoneEd.startAnimation(aout_animation());
        passwordTx.setText(getResources().getString(R.string.password));
        forgetTv.setVisibility(View.VISIBLE);
        forgetTv.startAnimation(ain_animation());
        registerTv.setVisibility(View.VISIBLE);
        registerTv.startAnimation(ain_animation());
        passwordEd.setHint("");
        bottomBt.setText(getResources().getString(R.string.login));
        backBt.setVisibility(View.GONE);

        state = LOGIN;
    }

    /**
     * 注册布局
     */
    @Override
    public void setRegisterView() {
        phoneTv.setVisibility(View.VISIBLE);
        phoneEd.setVisibility(View.VISIBLE);
        phoneTv.startAnimation(at_animation());
        phoneEd.startAnimation(at_animation());
        forgetTv.setVisibility(View.GONE);
        forgetTv.startAnimation(aout_animation());
        registerTv.setVisibility(View.GONE);
        registerTv.startAnimation(aout_animation());
        passwordEd.setHint("密码为6-12位的数字");
        bottomBt.setText(getResources().getString(R.string.register));
        backBt.setVisibility(View.VISIBLE);

        state = REGISTER;
    }

    /**
     * 更改密码布局
     */
    @Override
    public void setChangePasswordView() {
        phoneTv.setText(getResources().getString(R.string.phone));
        phoneTv.setVisibility(View.VISIBLE);
        phoneEd.setVisibility(View.VISIBLE);
        phoneTv.startAnimation(at_animation());
        phoneEd.startAnimation(at_animation());
        passwordTx.setText(getResources().getString(R.string.new_password));
        passwordTx.startAnimation(ain_animation());
        forgetTv.setVisibility(View.GONE);
        forgetTv.startAnimation(aout_animation());
        registerTv.setVisibility(View.GONE);
        registerTv.startAnimation(aout_animation());
        passwordEd.setHint("密码为6-12位的数字");
        bottomBt.setText(getResources().getString(R.string.change_password));
        backBt.setVisibility(View.VISIBLE);

        state = CHANGE_PASSWORD;
    }

    @Override
    public void loginSuccess() {
        showToast("login success");
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        Connector.getDatabase();
        startActivity(intent);
        this.finish();
    }

    @Override
    public void loginFailure(String message) {
        showToast("登陆失败:" + message);
    }

    @Override
    public void registerSuccess() {
        showToast("注册成功");
        setLoginView();
    }

    @Override
    public void registerFailure(String msg) {
        usernameEd.setText("");
        passwordEd.setText("");
        phoneEd.setText("");
        showToast("注册失败:" + msg);
    }

    @Override
    public void changePasswordSuccess() {
        showToast("修改成功");
        setLoginView();
    }

    @Override
    public void changePasswordFailure(String msg) {
        usernameEd.setText("");
        passwordEd.setText("");
        phoneEd.setText("");
        showToast("修改失败:" + msg);
    }

    public String userText() {
        return usernameEd.getText().toString();
    }

    public String passwordText() {
        return passwordEd.getText().toString();
    }

    public String phoneText() {
        return phoneEd.getText().toString();
    }

    public Animation at_animation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_translate);
        return animation;
    }

    public Animation aout_animation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_out);
        return animation;
    }

    public Animation ain_animation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_in);
        return animation;
    }

    public void initItemDataBase() {
        DbProjectBean dbProjectBean = new DbProjectBean().setProject("日常");
        dbProjectBean.save();
        DbProjectBean dbProjectBean1 = new DbProjectBean().setProject("血液");
        dbProjectBean1.save();
        DbProjectBean dbProjectBean2 = new DbProjectBean().setProject("尿检");
        dbProjectBean2.save();
        DbProjectBean dbProjectBean3 = new DbProjectBean().setProject("糖尿病");
        dbProjectBean3.save();
        DbProjectBean dbProjectBean4 = new DbProjectBean().setProject("基本信息");
        dbProjectBean4.save();

        DbItemBean dbItemBean = new DbItemBean().setItem("血糖");
        dbItemBean.setDbProjectBean(dbProjectBean).save();
        DbItemBean dbItemBean1 = new DbItemBean().setItem("高压");
        dbItemBean1.setDbProjectBean(dbProjectBean).save();
        DbItemBean dbItemBean2 = new DbItemBean().setItem("低压");
        dbItemBean2.setDbProjectBean(dbProjectBean).save();
//        "甘油三酯", "胆固醇", "红细胞", "红细胞体积分布宽度", "白细胞", "血小板"
//            , "糖化血红蛋白", "心肌酶", "血尿酸"
        DbItemBean dbItemBean3 = new DbItemBean().setItem("甘油三酯");
        dbItemBean3.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean4 = new DbItemBean().setItem("胆固醇");
        dbItemBean4.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean5 = new DbItemBean().setItem("红细胞");
        dbItemBean5.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean6 = new DbItemBean().setItem("红细胞体积分布宽度");
        dbItemBean6.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean7 = new DbItemBean().setItem("白细胞");
        dbItemBean7.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean8 = new DbItemBean().setItem("血小板");
        dbItemBean8.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean9 = new DbItemBean().setItem("糖化血红蛋白");
        dbItemBean9.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean10 = new DbItemBean().setItem("心肌酶");
        dbItemBean10.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean11 = new DbItemBean().setItem("血尿酸");
        dbItemBean11.setDbProjectBean(dbProjectBean1).save();
//        {"PH", "蛋白质", "比重", "潜血", "微量白蛋白", "肌酐"};
        DbItemBean dbItemBean12 = new DbItemBean().setItem("PH");
        dbItemBean12.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean13 = new DbItemBean().setItem("蛋白质");
        dbItemBean13.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean14 = new DbItemBean().setItem("比重");
        dbItemBean14.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean15 = new DbItemBean().setItem("潜血");
        dbItemBean15.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean16 = new DbItemBean().setItem("微量白蛋白");
        dbItemBean16.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean17 = new DbItemBean().setItem("肌酐");
        dbItemBean17.setDbProjectBean(dbProjectBean2).save();
//        "胰岛素","ICA抗胰岛细胞抗体","GAD抗谷氨酸脱氢酶抗体","IAA抗胰岛素抗体"
        DbItemBean dbItemBean18 = new DbItemBean().setItem("胰岛素");
        dbItemBean18.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean19 = new DbItemBean().setItem("ICA抗胰岛细胞抗体");
        dbItemBean19.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean20 = new DbItemBean().setItem("GAD抗谷氨酸脱氢酶抗体");
        dbItemBean20.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean21 = new DbItemBean().setItem("IAA抗胰岛素抗体");
        dbItemBean21.setDbProjectBean(dbProjectBean2).save();
    }
}
