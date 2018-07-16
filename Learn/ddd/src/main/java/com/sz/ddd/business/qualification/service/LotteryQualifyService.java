package com.sz.ddd.business.qualification.service;

import com.sz.ddd.business.draw.domain.val.DrawLotteryContext;

public interface LotteryQualifyService {
    void checkLotteryCondition(DrawLotteryContext context);
}
