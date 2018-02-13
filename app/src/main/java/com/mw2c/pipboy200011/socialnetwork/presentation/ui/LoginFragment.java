package com.mw2c.pipboy200011.socialnetwork.presentation.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mw2c.pipboy200011.socialnetwork.R;
import com.mw2c.pipboy200011.socialnetwork.data.entity.Login;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.login.LoginInjector;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.LoginPresenter;

import javax.inject.Inject;

/**
 * Created by Pavel Apanovskiy on 10.02.2018.
 */

public class LoginFragment extends Fragment implements ILoginView {

    @Inject
    LoginPresenter mLoginPresenter;

    private EditText mMailEditText;
    private EditText mPasswordEditText;
    private Button mEnterButton;
    private ProgressBar mProgressBar;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LoginInjector.getLoginComponent().inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        mMailEditText = view.findViewById(R.id.login_mail_edit_text);
        mPasswordEditText = view.findViewById(R.id.login_password_edit_text);
        mEnterButton = view.findViewById(R.id.login_button);
        mProgressBar = view.findViewById(R.id.login_progress);
        TextView registerTextView = view.findViewById(R.id.login_registration_text_view);

        mEnterButton.setOnClickListener(enterButtonClickListener());
        registerTextView.setOnClickListener(registerTextViewClickListener());

        mLoginPresenter.bindView(this);

        return view;
    }

    @Override
    public void onDestroy() {
        mLoginPresenter.unbindView();
        mLoginPresenter.destroyPresenter();
        super.onDestroy();
    }

    @Override
    public void showEmptyFieldsError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.warning);
        builder.setMessage(R.string.login_empty_fileds_dialog_message);
        builder.setPositiveButton(R.string.ok, null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void showProgress() {
        mEnterButton.setText(null);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showResult(Login result) {
        Toast.makeText(getActivity(), "success login", Toast.LENGTH_SHORT).show();
        startActivity(MainActivity.newInstance(getActivity()));
    }

    private View.OnClickListener enterButtonClickListener() {
        return view -> mLoginPresenter.enterButtonClick(mMailEditText.getText().toString(),
                mPasswordEditText.getText().toString());
    }

    private View.OnClickListener registerTextViewClickListener() {
        return view -> mLoginPresenter.registerButtonClick();
    }
}
