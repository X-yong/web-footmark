/*
package com.footmark.service.controller;

import com.web.common.footmark.GoodsInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/15 10:51
 *//*


@RestController
@RequestMapping("web-service")
public class TestSearch {

    @Autowired
    private ElasticsearchRepository elasticsearchRepository;

    @PostMapping(value = "/search/testSearch", consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "测试", notes = "测试")
    @ApiImplicitParam(name ="user" ,value = "user",required =false ,dataType = "User")
    public void testSearch() {

        GoodsInfo goodsInfo = new GoodsInfo(1L,"商品"+System.currentTimeMillis(),"这是一个测试商品");
        elasticsearchRepository.save(goodsInfo);

        System.out.println("查询结果："+elasticsearchRepository.findOne(1L));
    }
}
*/
