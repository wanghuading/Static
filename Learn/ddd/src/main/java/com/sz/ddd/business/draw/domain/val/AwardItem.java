package com.sz.ddd.business.draw.domain.val;

/**
 * 奖项
 */
public class AwardItem {
    private int id;
    private int probability;// 概率
    private int totalNum;          //数量
    private AwardPrize awardPrize; // 奖品

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public AwardPrize getAwardPrize() {
        return awardPrize;
    }

    public void setAwardPrize(AwardPrize awardPrize) {
        this.awardPrize = awardPrize;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
