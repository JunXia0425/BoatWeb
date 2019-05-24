package com.lirui.boat.mapper;

import com.lirui.boat.entity.Classification;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassificationMapperTest {
    @Autowired
    private ClassificationMapper classificationMapper;
    @Test
    public void InitClassification(){
        String[] classifications = {
                "经济型游艇","舒适性游艇","豪华型游艇","奢华型游艇","单体帆船","双体船","钓鱼艇","运动快艇","活动会议艇","游船"
        };
        for (String classification : classifications) {
            Classification c = new Classification();
            c.setClassification(classification);
            classificationMapper.insert(c);
        }
        Assert.assertEquals(classifications.length,classificationMapper.selectList(null).size());
    }
}