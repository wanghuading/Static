package com.sz.ddd.business.draw.domain.aggregation;


import com.sz.ddd.business.draw.domain.val.AwardPool;
import com.sz.ddd.business.draw.domain.val.DrawLotteryContext;

import java.util.List;

/**
 * 聚合根对象
 */
public class DrawLottery {
    /**
     * 抽奖id,用于区分奖品批次
     */
    private String latteryId;
    private List<AwardPool> awardPools;

    public String getLatteryId() {
        return latteryId;
    }

    public void setLatteryId(String latteryId) {
        this.latteryId = latteryId;
    }

    public List<AwardPool> getAwardPools() {
        return awardPools;
    }

    public void setAwardPools(List<AwardPool> awardPools) {
        this.awardPools = awardPools;
    }

    public AwardPool chooseAwardPool(DrawLotteryContext context) {
        return chooseAwardPoolByUserType(awardPools, context.getUserType());
    }

    private AwardPool chooseAwardPoolByUserType(List<AwardPool> awardPools, int userType) {
        for (AwardPool awardPool : awardPools) {
            if (awardPool.matchUserType(userType)) {
                return awardPool;
            }
        }
        return null;
    }
}
