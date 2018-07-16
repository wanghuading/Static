package com.sz.ddd.business.draw.service.impl;

import com.sz.ddd.business.draw.domain.aggregation.DrawLottery;
import com.sz.ddd.business.draw.repo.respository.DrawLotteryRepository;
import com.sz.ddd.business.draw.domain.val.AwardItem;
import com.sz.ddd.business.draw.service.DrawLotteryService;
import com.sz.ddd.business.draw.domain.val.AwardPool;
import com.sz.ddd.business.draw.domain.val.DrawLotteryContext;

public class DrawLotteryServiceImpl implements DrawLotteryService {
//    @Autowire
    private DrawLotteryRepository drawLotteryRepository;

    @Override
    public AwardItem drawLottery(DrawLotteryContext context) {
        DrawLottery drawLottery = drawLotteryRepository.getDrawLotteryById(context.getLotteryId());
        AwardPool awardPool = drawLottery.chooseAwardPool(context);
        return awardPool.draw();
    }
}
