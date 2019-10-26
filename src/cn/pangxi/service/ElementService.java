package cn.pangxi.service;

import cn.pangxi.pojo.Element;

import java.util.List;

/**
 * @author 庞小西
 * @date 2019/10/22 17:52
 */
public interface ElementService {
    List<Element> selByRid(int rid);
}
