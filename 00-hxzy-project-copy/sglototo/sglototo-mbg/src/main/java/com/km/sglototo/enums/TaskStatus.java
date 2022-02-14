package com.km.sglototo.enums;

/**
 * @author zx
 * @Company ydtf
 * @date 2021/2/27 19:02
 */
public enum TaskStatus {


    //   作业状态：1->创建；2->指定负责人；
    INIT(1),//创建作业
    RESPONSIBLE(2),
    DELETED(10);//已删除


    private int value;

    private TaskStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
