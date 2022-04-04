package com.coderman.util;



import com.coderman.vo.PageVO;
import com.coderman.vo.ResultVO;

import java.util.List;

/**
 * @author coderman
 * @Title: 响应结果工具类
 * @Description: TOD
 * @date 2022/1/116:04
 */
public class ResultUtil {


    public static <T> ResultVO<T> getResult(Class<T> clazz, int code, String msg, T vo){

        ResultVO<T> t = new ResultVO<>();
        t.setCode(code);
        t.setMsg(msg);
        t.setResult(vo);


        return t;
    }

    /**
     * 返回成功
     *
     * @return
     */
    public static ResultVO<Void> getSuccess() {
        return getSuccess(null);
    }


    /**
     * 返回成功并携带数据
     *
     * @return
     */
    public static  ResultVO<Void> getSuccess(String msg) {
       ResultVO<Void> t = new ResultVO<>();
       t.setCode(200);
       t.setMsg(msg);
       t.setResult(null);
       return t;
    }


    /**
     * 返回成功并携带数据
     *
     * @return
     */
    public static  <T>ResultVO<T> getSuccess(Class<T> clazz, T vo) {
        ResultVO<T> t = new ResultVO<>();
        t.setCode(200);
        t.setMsg(null);
        t.setResult(vo);
        return t;
    }



    /**
     * 返回成功并携带数据
     *
     * @return
     */
    public static  <T>ResultVO<T> getFail(String msg) {
        ResultVO<T> t = new ResultVO<>();
        t.setCode(402);
        t.setMsg(msg);
        t.setResult(null);
        return t;
    }


    /**
     * 返回成功并携带数据
     *
     * @return
     */
    public static  <T>ResultVO<T> getWarn(String msg) {
        ResultVO<T> t = new ResultVO<>();
        t.setCode(405);
        t.setMsg(msg);
        t.setResult(null);
        return t;
    }


    /**
     * 返回成功并携带数据
     *
     * @return
     */
    public static  <T>ResultVO<T> getFail(int code, String msg) {
        ResultVO<T> t = new ResultVO<>();
        t.setCode(code);
        t.setMsg(msg);
        t.setResult(null);
        return t;
    }


    /**
     * 返回成功并携带数据
     *
     * @return
     */
    public static  <T>ResultVO<T> getFail(Class<T> clazz, T vo, String msg) {
        ResultVO<T> t = new ResultVO<>();
        t.setCode(402);
        t.setMsg(msg);
        t.setResult(vo);
        return t;
    }


    /**
     * 返回成功并携带数据
     *
     * @return
     */
    public static  <T>ResultVO<T> getWarn(Class<T> clazz, T vo, String msg) {
        ResultVO<T> t = new ResultVO<>();
        t.setCode(405);
        t.setMsg(msg);
        t.setResult(vo);
        return t;
    }

    public static <T> ResultVO<List<T>> getList(Class<T> clazz, int code, String msg,List<T> list){


        ResultVO<List<T>> t =  new ResultVO<>();

        t.setCode(code);
        t.setMsg(msg);
        t.setResult(list);

        return t;
    }


    public static <T> ResultVO<List<T>> getSuccessList(Class<T> clazz,List<T> list){

        return getList(clazz,200,null,list);
    }


    public static <T> ResultVO<List<T>> getFailList(Class<T> clazz,List<T> list,String msg){

        return getList(clazz,402,msg,list);
    }

    public static <T> ResultVO<List<T>> getWarnList(Class<T> clazz,List<T> list,String msg){

        return getList(clazz,405,msg,list);
    }

    public static <T> ResultVO<PageVO<List<T>>> getPage(Class<T> clazz, int code, String msg, PageVO<List<T>> page){

        ResultVO<PageVO<List<T>>> t = new ResultVO<>();

        t.setCode(code);
        t.setMsg(msg);
        t.setResult(page);

        return t;
    }



    public static <T> ResultVO<PageVO<List<T>>> getSuccessPage(Class<T> clazz,PageVO<List<T>> page){
        return getPage(clazz,200,null,page);
    }

    public static <T> ResultVO<PageVO<List<T>>> getFailPage(Class<T> clazz,PageVO<List<T>> page){



        return getPage(clazz,402,null,page);
    }

    public static <T> ResultVO<PageVO<List<T>>> getWarnPage(Class<T> clazz,PageVO<List<T>> page){



        return getPage(clazz,405,null,page);
    }
}
