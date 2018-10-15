package com.web.common.footmark;

import lombok.Data;
import java.io.Serializable;
import org.springframework.data.elasticsearch.annotations.Document;
/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/15 10:42
 */
@Data
@Document(indexName = "test",type = "goods")
public class GoodsInfo implements Serializable {

    private static final Long serialVersionUID = -1L;

    private Long id;
    private String name;
    private String description;

    public GoodsInfo(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
