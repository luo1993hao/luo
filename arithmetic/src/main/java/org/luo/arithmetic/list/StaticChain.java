package org.luo.arithmetic.list;

public class StaticChain<T> {

    //数据链
    private T[] datas;

    //游标链
    private int[] vernier;

    private Integer size;

    private Integer length = 10;

    StaticChain() {
        datas = (T[]) new Object[length];
        vernier = new int[length];
        //将游标链的末位(头结点)初始化为0（下一节点的位置）
        //将游标链的首位(空闲位的位置)初始化为1
        for (int i = 0; i < length; i++) {
            vernier[i] = i + 1;
        }
        vernier[length - 1] = 1;
        vernier[0] = 1;
        size = 0;
    }

    public static void main(String[] args) throws Exception {
        StaticChain<String> a = new StaticChain<>();
        a.add(0, "A");
        a.add(1, "B");
        a.add(2, "C");
        a.add(1, "D");
//        a.add(2, 7);
        System.out.println(a);

    }

    //插入到第几个元素的后面
    public void add(Integer index, T t) throws Exception {
        if (index > size)
            throw new Exception("outof index");
        int insertIndex = vernier[0];
        int freeIndex = vernier[insertIndex];
        vernier[0] = freeIndex;
        datas[insertIndex] = t;
        if (index == size) {
            //将空闲位置的下标放入游标链的首位
            //将刚插入末位值对应下标的游标链的值置为0
            vernier[insertIndex] = 0;
            //将值插入对应的位置
            //获取第几个元素的游标链对应的值
            Integer preIndex = this.getIndex(index);
            //将上一个元素的游标链的值改为插入的值的下标
            vernier[preIndex] = insertIndex;
        } else {
            int temp = vernier[index];
            vernier[index] = vernier[insertIndex];
            vernier[insertIndex] = temp;
        }
        size++;
    }


    //查询几个元素的游标链对应的下标
    private Integer getIndex(Integer index) throws Exception {
        int k = length - 1;
        for (int i = 1; i <= index; i++)
            k = vernier[k];
        if (k == -1) {
            throw new Exception("outof index");
        }
        return k;
    }



    //删除第index个元素
    public T remove(Integer index) throws Exception {
        T data = null;
        if (index == 1) {
            Integer delIndex = vernier[999];
            data = datas[delIndex];
            int nextIndex = vernier[delIndex];
            vernier[length - 1] = nextIndex;
            vernier[delIndex] = vernier[0];
            vernier[0] = delIndex;
        } else {
            Integer delIndex = this.getIndex(index);
            data = datas[delIndex];
            int nextIndex = vernier[delIndex];
            Integer preIndex = this.getIndex(index - 1);
            vernier[preIndex] = nextIndex;
            vernier[delIndex] = vernier[0];
            vernier[0] = delIndex;
        }
        return data;
    }

}