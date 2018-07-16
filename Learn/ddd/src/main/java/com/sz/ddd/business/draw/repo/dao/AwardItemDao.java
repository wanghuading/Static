package com.sz.ddd.business.draw.repo.dao;

import com.sz.ddd.business.draw.repo.dao.pojo.AwardItemPO;

import java.util.List;

public interface AwardItemDao {
    List<AwardItemPO> getAwardItemByAwardPoolId(int id);
}
