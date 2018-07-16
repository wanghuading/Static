package com.sz.ddd.business.risk.service;

import com.sz.ddd.business.draw.domain.val.DrawLotteryContext;

public interface LotteryRiskService {
    void accquireAccess(DrawLotteryContext context);
}
