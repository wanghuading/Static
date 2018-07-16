package com.sz.ddd.business.draw.repo.dao.pojo;

import com.sz.ddd.business.draw.domain.val.AwardItem;

import java.util.Date;

/**
 * 奖池
 * 根据用户类型和lotteryId得到相应的奖项
 */
public class AwardPoolPO {
    private int id;
    private int userType;
    private Date beginTime;
    private Date endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
