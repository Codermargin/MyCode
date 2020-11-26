package com.xyx.RingCentralExam;

import java.io.Serializable;

public interface Collider extends Serializable {
    //碰撞检测方法
    public boolean collide(Object obj1,Object obj2);
}
