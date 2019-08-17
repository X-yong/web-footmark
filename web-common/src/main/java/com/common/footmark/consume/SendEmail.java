package com.common.footmark.consume;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/8/16 16:25
 */
@Setter
@Getter
@ToString
public class SendEmail implements Serializable {
    private static final long serialVersionUID = 1L;

    private String from;

    private List<String> toUser;

    private String subject;

    private String content;

    /**
     * map 里面key 为rscId,rscPath
     */
    private List<Map> images;

    private List<String> filePath;

    private String type;

    private Map param;
}
