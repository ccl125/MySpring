package com.example.myspring.es.service;

import com.alibaba.fastjson.JSON;
import com.example.myspring.es.EsClientUtils;
import com.example.myspring.es.vo.BankInfoVo;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2023/5/19 18:41
 * @Description
 */
@Service
public class MyEsService {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Resource
    private EsClientUtils esClientUtils;

    public boolean getBankIndexExist(String indexName) {
        return esClientUtils.isIndexExist(indexName);
    }

    public List<BankInfoVo> getBankInfoVo(String indexName) {
        SearchRequest request = new SearchRequest(indexName);
        SearchResponse response;
        try {
            response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SearchHit[] hits = response.getHits().getHits();
        List<BankInfoVo> res = new ArrayList<>();
        String temp;
        for (SearchHit hit : hits) {
            temp = hit.getSourceAsString();
            BankInfoVo bankInfoVo = JSON.parseObject(temp, BankInfoVo.class);
            res.add(bankInfoVo);
        }
        return res;

    }

}
