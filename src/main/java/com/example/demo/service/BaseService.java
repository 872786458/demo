package com.example.demo.service;


import com.example.demo.bean.ResultBean;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    public static ResultBean success() {
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(true);
        resultBean.setCode(0);
        resultBean.setData(null);
        return resultBean;
    }

    public static ResultBean success(Object data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(true);
        resultBean.setCode(0);
        resultBean.setData(data);
        return resultBean;
    }

    public static  ResultBean failure() {
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(false);
        resultBean.setCode(0);
        resultBean.setM( "");
        return resultBean;
    }

    public static ResultBean failure(String msg) {
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(false);
        resultBean.setCode(0);
        resultBean.setM( msg);
        return resultBean;
    }

    public static ResultBean failure(int code) {
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(false);
        resultBean.setCode(0);
        resultBean.setM( "");
        return resultBean;
    }

    public static ResultBean failure(int code, String msg) {
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(false);
        resultBean.setCode(0);
        resultBean.setM( msg);
        return resultBean;
    }
}
