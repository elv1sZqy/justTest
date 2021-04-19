package com.tsu.zqy.flow;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhuQiYun
 * @create 2021/4/15
 * @description :
 */
@NoArgsConstructor
@Data
public class ActivityDefine {

    /**
     * activityName : xxx
     * workflow : [{"nodeName":"yyy","nodeType":1},{"nodeName":"er","nodeType":2}]
     */

    private String activityName;
    private List<Node> workflow;
}
