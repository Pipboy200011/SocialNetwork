package com.mw2c.pipboy200011.socialnetwork.di.registered.posts;

import com.mw2c.pipboy200011.socialnetwork.SocialNetwork;

/**
 * Created by Pavel Apanovskiy on 13.02.2018.
 */

public class PostsInjector {
    private static PostsComponent sPostsComponent;

    public static PostsComponent getPostsComponent() {
        if (sPostsComponent == null) {
            sPostsComponent = SocialNetwork.getInstance()
                    .getRegisteredComponent()
                    .getPostsComponentBuilder()
                    .makePostsModule(new PostsModule())
                    .build();
        }
        return sPostsComponent;
    }

    public static void clearPostsComponent() {
        sPostsComponent = null;
    }
}
