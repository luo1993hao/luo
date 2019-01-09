package com.luo.oom;

import java.util.HashMap;
import java.util.Map;

/**
 * 内存溢出测试
 *
 * @author luohaoyu
 * @since 2018-12-28 13:12
 **/
public class KeylessEntry {
    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }

    public static void main(String[] args) {
        Map<Key,String> m = new HashMap<Key,String>();
        while(true) {
            for(int i=0;i<10000;i++) {
                if(!m.containsKey(new Key(i))) {
                    m.put(new Key(i), "Number:" + i);
                }
            }
        }
    }
}
