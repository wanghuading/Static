package com.sz.ddd.business.draw.repo.dao.pojo;

/**
 * 奖项
 */
public class AwardItemPO {
    private int id;
    private int probability;       //概率
    private int totalNum;          //数量
    private int awardPoolId;       //奖品池id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getAwardPoolId() {
        return awardPoolId;
    }

    public void setAwardPoolId(int awardPoolId) {
        this.awardPoolId = awardPoolId;
    }
}
