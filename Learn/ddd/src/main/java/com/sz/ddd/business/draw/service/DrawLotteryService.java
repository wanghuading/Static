package com.sz.ddd.business.draw.service;

import com.sz.ddd.business.draw.domain.val.AwardItem;
import com.sz.ddd.business.draw.domain.val.DrawLotteryContext;

public interface DrawLotteryService {
    AwardItem drawLottery(DrawLotteryContext context);
}
