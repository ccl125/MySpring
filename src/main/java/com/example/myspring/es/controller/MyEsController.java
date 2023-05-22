package com.example.myspring.es.controller;

import com.example.myspring.es.service.MyEsService;
import com.example.myspring.es.vo.BankInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2023/5/19 18:58
 * @Description
 */
@RestController
@Slf4j
public class MyEsController {

    @Resource
    private MyEsService myEsService;

    @GetMapping("/es/index/exist")
    public void testEs(String indexName) {
        boolean bankInfo = myEsService.getBankIndexExist(indexName);
        log.info("索引:{}存在：{}", indexName, bankInfo);
    }

    @GetMapping("/es/index/info")
    public List<BankInfoVo> getBankInfo(String indexName) {
        List<BankInfoVo> bankInfoVo = myEsService.getBankInfoVo(indexName);
        return bankInfoVo;
    }

}
