package com.csu.xavier.web;


import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author wuyanfeng
 * @Description
 * @Date 2020/6/11 14:40
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> integers = Lists.newArrayList(1, 3, 4, 6);
        List<Integer> newList = integers.stream().filter(integer -> integer > 7).map(integer -> integer * 2).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(newList));
    }
}
