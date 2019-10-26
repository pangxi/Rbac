package cn.pangxi.service;

import cn.pangxi.pojo.Url;

import java.util.List;

/**
 * @author 庞小西
 * @date 2019/10/22 19:00
 */
public interface UrlService {
    List<Url> selByRid(int rid);
    List<Url> showAll();
}
