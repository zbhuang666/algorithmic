package com.zhs.zbhuang.sentinel;

/**
 * 令牌桶算法
 * 1 漏桶算法和令牌桶算法最明显的区别是令牌桶算法允许流量一定程度的突发。
 * 2 因为默认的令牌桶算法，取走token是不需要耗费时间的，也就是说，假设桶内有100个token时，那么可以瞬间允许100个请求通过。
 * 3 当然我们需要具体情况具体分析，只有最合适的算法，没有最优的算法。
 */
public class TokenBucket {
    public Long timeStamp = System.currentTimeMillis();
    public Long capacity;
    public Long rate;
    public Long tokens;

    public boolean grant(){
        Long now = System.currentTimeMillis();
        tokens = Math.min(capacity, tokens + (now - timeStamp) * rate);
        timeStamp = now;
        if(tokens < 1) {
            return false;
        } else {
            tokens -= 1;
            return true;
        }
    }
}
