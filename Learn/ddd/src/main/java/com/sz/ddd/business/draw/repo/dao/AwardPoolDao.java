package com.sz.ddd.business.draw.repo.dao;

import com.sz.ddd.business.draw.repo.dao.pojo.AwardPoolPO;

import java.util.List;

public interface AwardPoolDao {
    public List<AwardPoolPO> getAwardPoolByLotteryId(int lotteryId);
}
