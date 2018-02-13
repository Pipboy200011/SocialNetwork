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

import com.mw2c.pipboy200011.socialnetwork.R;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.login.LoginInjector;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.RegistrationPresenter;

import javax.inject.Inject;

import retrofit2.Response;

/**
 * Created by Pavel Apanovskiy on 11.02.2018.
 */

public class RegistrationFragment extends Fragment implements IRegistrationView {

    @Inject
    RegistrationPresenter mRegistrationPresenter;

    private EditText mName;
    private EditText mSurname;
    private EditText mMail;
    private EditText mPassword;
    private Button mRegistrationButton;
    private ProgressBar mProgressBar;

    public static RegistrationFragment newInstance() {
        return new RegistrationFragment();
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
        View view = inflater.inflate(R.layout.registration_fragment, container, false);

        mName = view.findViewById(R.id.registration_name_edit_text);
        mSurname = view.findViewById(R.id.registration_surname_edit_text);
        mMail = view.findViewById(R.id.registration_mail_edit_text);
        mPassword = view.findViewById(R.id.registration_password_edit_text);
        mRegistrationButton = view.findViewById(R.id.registration_button);
        mProgressBar = view.findViewById(R.id.registration_progress);

        mRegistrationButton.setOnClickListener(registrationButtonClickListener);

        mRegistrationPresenter.bindView(this);

        return view;
    }

    @Override
    public void onDestroy() {
        mRegistrationPresenter.unbindView();
        mRegistrationPresenter.destroyPresenter();
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
        mRegistrationButton.setText(null);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showResult(Response<String> result) {
    }

    private View.OnClickListener registrationButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mRegistrationPresenter.registrationButtonClick(
                    mName.getText().toString(),
                    mSurname.getText().toString(),
                    mMail.getText().toString(),
                    mPassword.getText().toString());
        }
    };
}
