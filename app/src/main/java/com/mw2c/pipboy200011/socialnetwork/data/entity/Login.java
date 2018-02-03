package com.mw2c.pipboy200011.socialnetwork.data.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public class Login {

    @SerializedName("avatar")
    @Expose
    private String mAvatar;
    @SerializedName("birthDate")
    @Expose
    private String mBirthDate;
    @SerializedName("created")
    @Expose
    private String mCreated;
    @SerializedName("email")
    @Expose
    private String mEmail;
    @SerializedName("firstName")
    @Expose
    private String mFirstName;
    @SerializedName("friendOfMine")
    @Expose
    private Boolean mFriendOfMine;
    @SerializedName("fullName")
    @Expose
    private String mFullName;
    @SerializedName("gender")
    @Expose
    private String mGender;
    @SerializedName("id")
    @Expose
    private Integer mId;
    @SerializedName("lastName")
    @Expose
    private String mLastName;
    @SerializedName("myFriend")
    @Expose
    private Boolean mMyFriend;
    @SerializedName("pageAvatar")
    @Expose
    private String mPageAvatar;
    @SerializedName("phone")
    @Expose
    private String mPhone;
    @SerializedName("shortName")
    @Expose
    private String mShortName;

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }

    public String getBirthDate() {
        return mBirthDate;
    }

    public void setBirthDate(String birthDate) {
        mBirthDate = birthDate;
    }

    public String getCreated() {
        return mCreated;
    }

    public void setCreated(String created) {
        mCreated = created;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public Boolean getFriendOfMine() {
        return mFriendOfMine;
    }

    public void setFriendOfMine(Boolean friendOfMine) {
        mFriendOfMine = friendOfMine;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public Boolean getMyFriend() {
        return mMyFriend;
    }

    public void setMyFriend(Boolean myFriend) {
        mMyFriend = myFriend;
    }

    public String getPageAvatar() {
        return mPageAvatar;
    }

    public void setPageAvatar(String pageAvatar) {
        mPageAvatar = pageAvatar;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getShortName() {
        return mShortName;
    }

    public void setShortName(String shortName) {
        mShortName = shortName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Login login = (Login) o;
        return Objects.equal(mAvatar, login.mAvatar) &&
                Objects.equal(mBirthDate, login.mBirthDate) &&
                Objects.equal(mCreated, login.mCreated) &&
                Objects.equal(mEmail, login.mEmail) &&
                Objects.equal(mFirstName, login.mFirstName) &&
                Objects.equal(mFriendOfMine, login.mFriendOfMine) &&
                Objects.equal(mFullName, login.mFullName) &&
                Objects.equal(mGender, login.mGender) &&
                Objects.equal(mId, login.mId) &&
                Objects.equal(mLastName, login.mLastName) &&
                Objects.equal(mMyFriend, login.mMyFriend) &&
                Objects.equal(mPageAvatar, login.mPageAvatar) &&
                Objects.equal(mPhone, login.mPhone) &&
                Objects.equal(mShortName, login.mShortName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mAvatar, mBirthDate, mCreated, mEmail, mFirstName, mFriendOfMine, mFullName, mGender, mId, mLastName, mMyFriend, mPageAvatar, mPhone, mShortName);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mAvatar", mAvatar)
                .add("mBirthDate", mBirthDate)
                .add("mCreated", mCreated)
                .add("mEmail", mEmail)
                .add("mFirstName", mFirstName)
                .add("mFriendOfMine", mFriendOfMine)
                .add("mFullName", mFullName)
                .add("mGender", mGender)
                .add("mId", mId)
                .add("mLastName", mLastName)
                .add("mMyFriend", mMyFriend)
                .add("mPageAvatar", mPageAvatar)
                .add("mPhone", mPhone)
                .add("mShortName", mShortName)
                .toString();
    }
}
