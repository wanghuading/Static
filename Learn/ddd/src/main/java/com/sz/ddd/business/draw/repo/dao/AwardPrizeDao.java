package com.sz.ddd.business.draw.repo.dao;

import com.sz.ddd.business.draw.domain.val.AwardPrize;

public interface AwardPrizeDao {
    AwardPrize getAwardPrizeByItemId(int itemId);
}
