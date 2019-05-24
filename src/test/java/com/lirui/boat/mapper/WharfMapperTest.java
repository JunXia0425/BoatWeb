package com.lirui.boat.mapper;

import com.lirui.boat.entity.Wharf;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WharfMapperTest {
    @Autowired
    private WharfMapper wharfMapper;
    @Test
    @Ignore
    public void initWharf(){
        String[] wharfs = { "亚龙湾游艇会", "半山半岛帆船港", "三亚鸿洲码头", "", "鹿回头码头", "三亚港务局游艇码头", "三亚凤凰岛码头", "清水湾游艇码头", "三亚港林荫河畔", "水上飞机码头", "三亚港星华码头"};
        for (String wharf : wharfs) {
            Wharf wharf1 = new Wharf();
            wharf1.setWharf(wharf);
            wharfMapper.insert(wharf1);
        }
        Assert.assertEquals(wharfs.length,wharfMapper.selectList(null).size());
    }
}