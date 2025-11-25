package com.cszy.po;

public class User {
    private String userName;
    private String userPwd;
    private String eMail;
    private String telephone;
    private Integer loginTimes;

    public User() {
        super();
    }

    public User(String userName, String userPwd, String eMail, String telephone, Integer loginTimes) {
        super();
        this.userName = userName;
        this.userPwd = userPwd;
        this.eMail = eMail;
        this.telephone = telephone;
        this.loginTimes = loginTimes;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    @Override
    public String toString() {
        return "User [userName=" + userName + ", userPwd=" + userPwd + ", eMail=" + eMail + ", telephone=" + telephone
                + ", loginTimes=" + loginTimes + "]";
    }
}
