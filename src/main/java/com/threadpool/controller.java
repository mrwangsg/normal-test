package com.threadpool;

import com.threadpool.entrance.Entrance;
import com.threadpool.task.SettleRefundTask;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @创建人 sgwang
 * @name controller
 * @user 91119
 * @创建时间 2020/1/11
 * @描述
 */
@RestController
public class controller {
    @Resource(name = "settleRefund")
    ThreadPoolTaskExecutor threadPoolTask;
    @Autowired
    BeanFactory beanFactory;

    @GetMapping
    public void testPrototype() {
        // 测试多例，需要工厂类，配合使用
        Entrance entrance = beanFactory.getBean(Entrance.class);
        entrance.test();
        System.err.println(entrance.toString());
    }

    @GetMapping("test")
    public void test() {
        doSomeThing();
    }

    @Async("test")
    public void doSomeThing() {
        LocalDateTime localDateTime = LocalDateTime.now();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();

        SettleRefundTask temp = null;
        try {
            for (int index = 0; index < 1000; index++) {
                temp = beanFactory.getBean(SettleRefundTask.class, " ["+index+"] ", "wangsg");
                threadPoolTask.submit(temp);
            }
        } catch (TaskRejectedException e) {
            System.err.println(temp.getUniqueNo() + " -> "+ e.getMessage());
        }
    }

}
