package com.mw2c.pipboy200011.socialnetwork.presentation.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mw2c.pipboy200011.socialnetwork.R;
import com.mw2c.pipboy200011.socialnetwork.di.registered.posts.PostsInjector;

/**
 * Created by Pavel Apanovskiy on 13.02.2018.
 */

public class PostsFragment extends Fragment {

    private TextView text;

    public static PostsFragment newInstance() {
        return new PostsFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        PostsInjector.getPostsComponent().inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.posts_fragment, container, false);


      //  mLoginPresenter.bindView(this);

        text = view.findViewById(R.id.posts_text_view);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        text.setText("sdfkbnsdlkfblskdfnb");

        Toast.makeText(getActivity(), "text " + text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
     //   mLoginPresenter.unbindView();
      //  mLoginPresenter.destroyPresenter();
        super.onDestroy();
    }
}
