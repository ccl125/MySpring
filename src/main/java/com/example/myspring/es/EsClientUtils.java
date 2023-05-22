package com.example.myspring.es;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: CuiChengLong
 * @Date: 2023/5/19 18:46
 * @Description
 */
@Component
@Slf4j
public class EsClientUtils {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    public boolean isIndexExist(String indexName) {
        boolean exists = false;
        GetIndexRequest request = new GetIndexRequest(indexName);
        try {
            exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            log.info("索引不存在");
        }
        return exists;
    }

}
