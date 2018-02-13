package com.mw2c.pipboy200011.socialnetwork.di.registered.posts;

import com.mw2c.pipboy200011.socialnetwork.presentation.ui.MainActivity;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.PostsFragment;

import dagger.Subcomponent;

/**
 * Created by Pavel Apanovskiy on 13.02.2018.
 */
@Subcomponent(modules = PostsModule.class)
@PostsScope
public interface PostsComponent {

    @Subcomponent.Builder
    interface Builder {
        PostsComponent.Builder makePostsModule(PostsModule module);

        PostsComponent build();
    }

    void inject(MainActivity mainActivity);

    void inject(PostsFragment fragment);
}
