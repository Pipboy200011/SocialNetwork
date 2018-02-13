package com.mw2c.pipboy200011.socialnetwork.presentation.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mw2c.pipboy200011.socialnetwork.R;
import com.mw2c.pipboy200011.socialnetwork.Screens;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.login.LoginInjector;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Replace;

public class LoginActivity extends AppCompatActivity {

    @Inject
    NavigatorHolder mNavigatorHolder;

    private Navigator mNavigator;

    public static Intent newInstance(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        LoginInjector.getLoginComponent().inject(this);

        mNavigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.login_container) {

            @Override
            protected Fragment createFragment(String screenKey, Object data) {
                Fragment fragment;
                switch (screenKey) {
                    case Screens.REGISTRATION_SCREEN:
                        fragment = RegistrationFragment.newInstance();
                        break;
                    default:
                        fragment = LoginFragment.newInstance();
                        break;

                }
                return fragment;
            }

            @Override
            protected void showSystemMessage(String message) {
                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void exit() {
                finish();
            }
        };
        mNavigator.applyCommands(new Command[]{new Replace(Screens.LOGIN_SCREEN, 1)});
    }


    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        mNavigatorHolder.setNavigator(mNavigator);
    }

    @Override
    protected void onPause() {
        mNavigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            LoginInjector.clearLoginComponent();
        }
    }
}
