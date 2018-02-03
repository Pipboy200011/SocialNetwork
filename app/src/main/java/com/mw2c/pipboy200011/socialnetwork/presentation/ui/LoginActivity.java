package com.mw2c.pipboy200011.socialnetwork.presentation.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mw2c.pipboy200011.socialnetwork.R;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.login.LoginInjector;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.LoginPresenter;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.view.ILoginView;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @Inject
    LoginPresenter mLoginPresenter;
    private EditText mMailEditText;
    private EditText mPasswordEditText;

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        LoginInjector.getLoginComponent().inject(this);
        findViews();
    }

    @Override
    protected void onDestroy() {
        mLoginPresenter.unbindView();
        mLoginPresenter.destroyPresenter();
        super.onDestroy();
        if (isFinishing()) {
            LoginInjector.clearLoginComponent();
        }
    }

    @Override
    public void showEmptyFieldsError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.warning);
        builder.setMessage(R.string.login_empty_fileds_dialog_message);
        builder.setPositiveButton(R.string.ok, null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void findViews() {
        mMailEditText = findViewById(R.id.login_mail_edit_text);
        mPasswordEditText = findViewById(R.id.login_password_edit_text);
        Button enterButton = findViewById(R.id.login_button);
        TextView registerTextView = findViewById(R.id.login_registration_text_view);

        enterButton.setOnClickListener(enterButtonClickListener());
        registerTextView.setOnClickListener(registerTextViewClickListener());

        mLoginPresenter.bindView(this);
    }

    private View.OnClickListener enterButtonClickListener() {
        return view -> mLoginPresenter.enterButtonClick(mMailEditText.getText().toString(),
                mPasswordEditText.getText().toString());
    }

    private View.OnClickListener registerTextViewClickListener() {
        return view -> mLoginPresenter.registerButtonClick();
    }
}
