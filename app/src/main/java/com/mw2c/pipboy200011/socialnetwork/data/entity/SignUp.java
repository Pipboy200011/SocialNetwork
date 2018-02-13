package com.mw2c.pipboy200011.socialnetwork.data.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pavel Apanovskiy on 11.02.2018.
 */



/*{
  "firstName": "vasya",
  "lastName": "pupkin",
  "userName": "vasya@mail.ru",
  "password": "qwerty"
}*/
public class SignUp {

    @SerializedName("firstName")
    @Expose
    private String mFirstName;

    @SerializedName("lastName")
    @Expose
    private String mLastName;

    @SerializedName("userName")
    @Expose
    private String mUserName;

    @SerializedName("password")
    @Expose
    private String mPassword;

    public SignUp(String firstName,
                  String lastName,
                  String userName,
                  String password) {
        mFirstName = firstName;
        mLastName = lastName;
        mUserName = userName;
        mPassword = password;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SignUp signUp = (SignUp) o;
        return Objects.equal(mFirstName, signUp.mFirstName) &&
                Objects.equal(mLastName, signUp.mLastName) &&
                Objects.equal(mUserName, signUp.mUserName) &&
                Objects.equal(mPassword, signUp.mPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mFirstName, mLastName, mUserName, mPassword);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mFirstName", mFirstName)
                .add("mLastName", mLastName)
                .add("mUserName", mUserName)
                .add("mPassword", mPassword)
                .toString();
    }
}