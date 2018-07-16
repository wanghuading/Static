package com.sz.ddd.business.draw.repo.respository;

import com.sz.ddd.business.draw.domain.aggregation.DrawLottery;
import com.sz.ddd.business.draw.repo.dao.AwardItemDao;
import com.sz.ddd.business.draw.repo.dao.AwardPoolDao;
import com.sz.ddd.business.draw.repo.dao.AwardPrizeDao;
import com.sz.ddd.business.draw.repo.dao.pojo.AwardItemPO;
import com.sz.ddd.business.draw.repo.dao.pojo.AwardPoolPO;
import com.sz.ddd.business.draw.repo.respository.cache.DrawLotteryCacheAccess;
import com.sz.ddd.business.draw.domain.val.AwardItem;
import com.sz.ddd.business.draw.domain.val.AwardPool;
import com.sz.ddd.business.draw.domain.val.AwardPrize;

import java.util.ArrayList;
import java.util.List;
//import com.sz.ddd.business.draw.repo.dao.pojo.AwardPoolPO;

public class DrawLotteryRepository {
    // @Autowire
    private DrawLotteryCacheAccess drawLotteryCacheAccess;
    // @Autowire
    private AwardPoolDao awardPoolDao;
    // @Autowire
    private AwardItemDao awardItemDao;
    // @Autowire
    private AwardPrizeDao awardPrizeDao;

    public DrawLottery getDrawLotteryById(int lotteryId) {
        // 从缓存load
        DrawLottery drawLottery = drawLotteryCacheAccess.get(lotteryId);
        if (drawLottery != null) {
            return drawLottery;
        }
        //从数据库中获取
        drawLottery=getDrawLotteryFromDB(lotteryId);
        drawLotteryCacheAccess.set(lotteryId,drawLottery);
        return drawLottery;
    }

    private DrawLottery getDrawLotteryFromDB(int lotteryId) {
        DrawLottery drawLottery = new DrawLottery();
        List<AwardPoolPO> awardPoolPOS = awardPoolDao.getAwardPoolByLotteryId(lotteryId);

        if (awardPoolPOS == null || awardPoolPOS.isEmpty()) {
            throw new RuntimeException("奖池为空");
        }
        List<AwardPool> awardPools=new ArrayList<>();

        awardPoolPOS.parallelStream().forEach(awardPoolPO -> {
            AwardPool awardPool=new AwardPool();
            awardPool.setUserType(awardPoolPO.getUserType());
            awardPool.setBeginTime(awardPoolPO.getBeginTime());
            awardPool.setEndTime(awardPoolPO.getEndTime());

            List<AwardItemPO> awardItemPOS=awardItemDao.getAwardItemByAwardPoolId(awardPoolPO.getId());
            awardPool.setAwardItems(convertPo2Vo(awardItemPOS));
            awardPools.add(awardPool);
        });

        return drawLottery;
    }

    private List<AwardItem> convertPo2Vo(List<AwardItemPO> awardItemPOList){
        List<AwardItem> awardItems=new ArrayList<>();
        awardItemPOList.parallelStream().forEach(awardItemPO -> {
            AwardItem awardItem=new AwardItem();
            awardItem.setProbability(awardItemPO.getProbability());
            awardItem.setTotalNum(awardItemPO.getTotalNum());
            AwardPrize awardPrize = awardPrizeDao.getAwardPrizeByItemId(awardItem.getId());
            awardItem.getAwardPrize().setName(awardPrize.getName());
            awardItems.add(awardItem);
        });
        return awardItems;
    }
}
