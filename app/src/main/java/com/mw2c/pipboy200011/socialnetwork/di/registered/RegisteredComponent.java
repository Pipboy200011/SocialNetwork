package com.mw2c.pipboy200011.socialnetwork.di.registered;

import com.mw2c.pipboy200011.socialnetwork.di.registered.posts.PostsComponent;

import dagger.Subcomponent;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

@Subcomponent(modules = RegisteredModule.class)
@RegisteredScope
public interface RegisteredComponent {

    PostsComponent.Builder getPostsComponentBuilder();
}
