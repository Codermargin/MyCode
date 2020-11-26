package com.xyx.RingCentralExam;

import java.util.List;

public class ColliderChain implements Collider{
    //存取所有的碰撞器
    private List<Collider> colliderList;
    //初始化碰撞器链过程
    public ColliderChain(){
        //init
    }
    public void init(){
        //进行所有collider的搜索，并将其放入ColliderList中
    }
    //碰撞检测
    @Override
    public boolean collide(Object obj1, Object obj2) {
        for (Collider collider : colliderList){
            //判定两个物体能否进行碰撞
            if (!collider.collide(obj1,obj2)){
                return false;
            }
            collider.collide(obj1,obj2);
        }
        return true;

    }
}
