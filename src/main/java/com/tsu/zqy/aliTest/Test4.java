package com.tsu.zqy.aliTest;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName Test4
 * @Author Elv1s
 * @Date 2021/2/3 21:03
 * @Description: //登陆安全的题目，如果你的系统登陆接口在被刷。
 * 我们要上线个防刷限流功能。示例代码如下：根据登陆ip，1分钟之内，只能请求10次登陆请求，不超过10次返回ture，
 * 超过10次的返回false，支持并发场景。  只考虑单机场景限制，使用java 代码原生实现（不使用中间件redis 计数器之类的方案）
 */
public class Test4 {
    private static ConcurrentHashMap<String, IpAccessInfo> cache = new ConcurrentHashMap<>();
    private static Long ONE_MINUTE_TIME_STAMPS = 60 * 1000L;
    private static Integer ONE_MINUTE_LIMIT_TIMES = 10;

    /**
     * 定义一个currentHashMap<IP, IpAccessInfo>
     * 放行前先比对info创建时间是否大于一分钟了, 如果是 就允许访问,
     * 如果小于一分钟则比较请求次数
     * 1. 请求次数小于10,允许访问,
     * 2. 反之则拒绝
     *
     * @param ip
     * @return
     */
    public boolean access(String ip) {
        long currentTimeMillis = System.currentTimeMillis();
        IpAccessInfo ipAccessInfo = cache.get(ip);
        // 第一次访问 返回true
        if (null == ipAccessInfo) {
            ipAccessInfo = new IpAccessInfo(currentTimeMillis, 1);
            cache.put(ip, ipAccessInfo);
            return true;
        }
        // 比较上次循环是不是已经大于1分钟
        Long accessInfoTimeStamp = ipAccessInfo.getTimeStamp();
        if (currentTimeMillis - accessInfoTimeStamp > ONE_MINUTE_TIME_STAMPS) {
            ipAccessInfo.setAccessCount(1);
            ipAccessInfo.setTimeStamp(currentTimeMillis);
            cache.put(ip, ipAccessInfo);
            return true;
        }

        // 距离上一次循环还小于一分钟
        int accessCount = ipAccessInfo.getAccessCount();
        if (accessCount < ONE_MINUTE_LIMIT_TIMES) {
            ipAccessInfo.setAccessCount(accessCount + 1);
            cache.put(ip, ipAccessInfo);
            return true;
        }

        return false;
    }

    private static class IpAccessInfo {
        private Long timeStamp;
        private int accessCount;

        public IpAccessInfo(Long timeStamp, int accessCount) {
            this.timeStamp = timeStamp;
            this.accessCount = accessCount;
        }

        public Long getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(Long timeStamp) {
            this.timeStamp = timeStamp;
        }

        public int getAccessCount() {
            return accessCount;
        }

        public void setAccessCount(int accessCount) {
            this.accessCount = accessCount;
        }
    }
}
