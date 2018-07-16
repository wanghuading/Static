package com.sz.ddd.business.draw.domain.val;

public class DrawLotteryContext {
    private int lotteryId;
    private int userType;


    public int getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(int lotteryId) {
        this.lotteryId = lotteryId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
