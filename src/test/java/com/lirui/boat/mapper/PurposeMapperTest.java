package com.lirui.boat.mapper;

import com.lirui.boat.entity.Purpose;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PurposeMapperTest {
    @Autowired
    private PurposeMapper purposeMapper;
    @Test
    @Ignore
    public void initPurpose(){
        String purposes[] = {"家庭体验", "商务接待", "玩艇尝试", "休闲海钓", "亲友活动", "同学聚会", "主题Party", "专业海钓", "摄影", "潜水", "放生礼拜", "其它"};
        for (String purpose : purposes) {
            Purpose purpose1 = new Purpose();
            purpose1.setPurpose(purpose);
            purposeMapper.insert(purpose1);
        }
        Assert.assertEquals(purposes.length,purposeMapper.selectList(null).size());
    }
}