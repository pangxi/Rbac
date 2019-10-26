package cn.pangxi.service.impl;

import cn.pangxi.mapper.UrlMapper;
import cn.pangxi.pojo.Url;
import cn.pangxi.service.UrlService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庞小西
 * @date 2019/10/22 19:01
 */
@Service
public class UrlServiceImpl implements UrlService {
    @Resource
    private UrlMapper urlMapper;
    @Override
    public List<Url> selByRid(int rid) {
        return urlMapper.selByRid(rid);
    }

    @Override
    public List<Url> showAll() {
        return urlMapper.selAll();
    }
}
