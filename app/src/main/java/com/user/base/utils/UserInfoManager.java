package com.user.base.utils;

/**
 * 管理用户基本信息
 */
public class UserInfoManager {
    private static final String USER_ID = "user_id";
    private static final String USER_PHONE = "user_phone";
    private static final String USER_SEX = "user_sex";
    private static final String USER_NAME = "user_name";
    private static final String USER_TOKEN = "user_token";

    public static String getUserId() {
        return SPUtils.getInstance().getString(USER_ID);
    }

    public static void setUserId(String userId) {
        SPUtils.getInstance().putString(USER_ID, userId);
    }

    public static String getUserPhone() {
        return SPUtils.getInstance().getString(USER_PHONE);
    }

    public static void setUserPhone(String userPhone) {
        SPUtils.getInstance().putString(USER_PHONE, userPhone);
    }

    public static int getUserSex() {
        return SPUtils.getInstance().getInt(USER_SEX);
    }

    public static void setUserSex(int userSex) {
        SPUtils.getInstance().putInt(USER_SEX, userSex);
    }

    public static String getUserName() {
        return SPUtils.getInstance().getString(USER_NAME);
    }

    public static void setUserName(String userName) {
        SPUtils.getInstance().putString(USER_NAME, userName);
    }

    public static String getUserToken() {
        return SPUtils.getInstance().getString(USER_TOKEN);
    }

    public static void setUserToken(String userToken) {
        SPUtils.getInstance().putString(USER_TOKEN, userToken);
    }


}
