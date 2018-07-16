package com.sz.ddd.business.prize.service;

import com.sz.ddd.business.draw.domain.val.AwardItem;
import com.sz.ddd.business.draw.domain.val.DrawLotteryContext;

public interface LotteryPrizeService {
    void sendAwardPrize(AwardItem awardItem, DrawLotteryContext context);
}
