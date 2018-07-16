package com.sz.ddd.business.draw.domain.val;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 奖池
 * 根据用户类型和lotteryId得到相应的奖项
 */
public class AwardPool {
    private int userType; //用户类型、新用户/老用户

    private Date beginTime;

    private Date endTime;

    private List<AwardItem> awardItems; //奖池中包含的奖品

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

    public List<AwardItem> getAwardItems() {
        return awardItems;
    }

    public void setAwardItems(List<AwardItem> awardItems) {
        this.awardItems = awardItems;
    }

    public boolean matchUserType(int userType) {
        return getUserType() == userType;
    }

    public AwardItem draw() {
        int sumOfProbablity = 0;
        for (AwardItem awardItem : awardItems) {
            sumOfProbablity += awardItem.getProbability();
        }
        int randomNumber = ThreadLocalRandom.current().nextInt(sumOfProbablity);
        int range = 0;
        for (AwardItem awardItem : awardItems) {
            range += awardItem.getProbability();
            if (randomNumber < range) {
                return awardItem;
            }
        }
        return null;
    }
}
