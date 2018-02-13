package com.mw2c.pipboy200011.socialnetwork.presentation.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mw2c.pipboy200011.socialnetwork.R;
import com.mw2c.pipboy200011.socialnetwork.Screens;
import com.mw2c.pipboy200011.socialnetwork.di.registered.posts.PostsInjector;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Replace;

public class MainActivity extends AppCompatActivity {

    @Inject
    NavigatorHolder mNavigatorHolder;
    @Inject
    Router mRouter;

    private Navigator mNavigator;

    public static Intent newInstance(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        PostsInjector.getPostsComponent().inject(this);

        BottomNavigationView navigation = findViewById(R.id.main_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mNavigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.main_container) {
            @Override
            protected Fragment createFragment(String screenKey, Object data) {
                return PostsFragment.newInstance();
            }

            @Override
            protected void showSystemMessage(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void exit() {
                finish();
            }
        };
        mNavigator.applyCommands(new Command[]{new Replace(Screens.POSTS_SCREEN, 1)});
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mRouter.navigateTo(Screens.POSTS_SCREEN);
                return true;
            case R.id.navigation_dashboard:
                mRouter.navigateTo(Screens.POSTS_SCREEN);
                return true;
            case R.id.navigation_notifications:
                mRouter.navigateTo(Screens.POSTS_SCREEN);
                return true;
        }
        return false;
    };

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
            PostsInjector.clearPostsComponent();
        }
    }
}
