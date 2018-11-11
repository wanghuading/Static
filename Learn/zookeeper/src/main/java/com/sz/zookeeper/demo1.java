package com.sz.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class demo1 implements Watcher{
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zooKeeper;
    public static void main(String[] args) throws IOException {
        /*zooKeeper =
                new ZooKeeper("203.195.137.15:2181",
                30000, new demo1());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(zooKeeper.getState());*/

        try {
            /*// 创建节点
            // 节点分为持久节点/临时节点、普通节点/有序节点
            String path = zooKeeper.create("/firstDemo","firstDemo".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println("path1="+path);
            String path2 = zooKeeper.create("/secondDemo", "secondDemo".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println("path2="+path2);
            String path3 = zooKeeper.create("/thirdDemo", "thirdDemo".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("path3="+path3);
            String path4 = zooKeeper.create("/fourDemo", "fourDemo".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
            System.out.println(System.in);*/
            // 删除没有回调
//            zooKeeper.delete("/thirdDemo", 1, new DeleteCallBack(), 1);
            // 查找
            /*Stat stat = new Stat();
            zooKeeper.getData("/fourDemo0000000005/fourDemo5", true, stat);*/
            /*List<String> children = zooKeeper.getChildren("/fourDemo0000000005",
                    true);*/
            /*zooKeeper.delete("/fourDemo0000000005/fourDemo5", 0);
            zooKeeper.delete("/fourDemo0000000005/fourDemo6", 0);
            zooKeeper.create("/fourDemo0000000005/fourDemo5", "fourDemo5".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            zooKeeper.create("/fourDemo0000000005/fourDemo6", "fourDemo6".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);*/
            /*stat = zooKeeper.setData("/fourDemo0000000005/fourDemo5","fourDemochange1".getBytes(), stat.getVersion());
            stat = zooKeeper.setData("/fourDemo0000000005/fourDemo5","fourDemochange2".getBytes(), stat.getVersion());
            stat = zooKeeper.setData("/fourDemo0000000005/fourDemo5","fourDemochange2".getBytes(), stat.getVersion());*/

            // 权限控制
            String path = "/auth";
            String pathChild = "/child1";
            ZooKeeper zooKeeper1 = new ZooKeeper("203.195.137.15:2181", 300000, null);
            Thread.sleep(1000);
            zooKeeper1.addAuthInfo("digest", "auth".getBytes());
            /*zooKeeper1.create(path, "auth".getBytes(),
                    ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);*/
            /*zooKeeper1.create(path+pathChild, "authChild".getBytes(),
                    ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);*/
            ZooKeeper zooKeeper2 = new ZooKeeper("203.195.137.15:2181",
                    300000, null);
            Thread.sleep(1000);
            zooKeeper2.addAuthInfo("digest", "auth".getBytes());
            zooKeeper2.getData(path, false, null);

            zooKeeper1.exists()
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void process(WatchedEvent watchedEvent) {
        countDownLatch.countDown();
        System.out.println("watchedType:" + watchedEvent.getType());
        if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
            try {
                zooKeeper.exists(watchedEvent.getPath(), true);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class DeleteCallBack implements AsyncCallback.VoidCallback {
        public void processResult(int i, String s, Object o) {
            System.out.println("i="+i+";s="+s+"o="+o.getClass().getSimpleName());
        }
    }

}
