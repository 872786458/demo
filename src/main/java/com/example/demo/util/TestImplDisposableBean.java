package com.example.demo.util;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @author 于振华
 * @create 2019-11-11 23:50
 */
@Component
public class TestImplDisposableBean  implements DisposableBean {

    @Override
    public void destroy()  {
        System.out.println("我被销毁了、、、、、");
        System.out.println("我被销毁了、、、、、");
    }
}


