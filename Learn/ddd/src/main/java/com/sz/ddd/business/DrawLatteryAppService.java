package com.sz.ddd.business;

import com.sz.ddd.business.draw.domain.val.AwardItem;
import com.sz.ddd.business.draw.service.DrawLotteryService;
import com.sz.ddd.business.draw.domain.val.DrawLotteryContext;
import com.sz.ddd.business.facade.Request;
import com.sz.ddd.business.facade.Response;
import com.sz.ddd.business.prize.service.LotteryPrizeService;
import com.sz.ddd.business.qualification.service.LotteryQualifyService;
import com.sz.ddd.business.risk.service.LotteryRiskService;

public class DrawLatteryAppService {
    private LotteryRiskService lotteryRiskService;
    private LotteryQualifyService lotteryQualifyService;
    private DrawLotteryService drawLotteryService;
    private LotteryPrizeService lotteryPrizeService;

    // 抽奖
    public Response draw(Request request) {
        // 获取request上下文
        DrawLotteryContext context = resolver(request);
        //校验风控规则
        lotteryRiskService.accquireAccess(context);
        //校验抽奖资格
        lotteryQualifyService.checkLotteryCondition(context);
        //抽奖
        AwardItem awardItem = drawLotteryService.drawLottery(context);
        //发放奖品
        lotteryPrizeService.sendAwardPrize(awardItem, context);
        return new Response();
    }

    /**
     * 获取抽奖上下文
     * @param request
     * @return
     */
    private DrawLotteryContext resolver(Request request) {
        return new DrawLotteryContext();
    }
}
