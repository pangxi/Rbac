package cn.pangxi.service.impl;

import cn.pangxi.mapper.ElementMapper;
import cn.pangxi.pojo.Element;
import cn.pangxi.service.ElementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庞小西
 * @date 2019/10/22 17:54
 */
@Service
public class ElementServiceImpl implements ElementService {
    @Resource
    private ElementMapper elementMapper;
    @Override
    public List<Element> selByRid(int rid) {
        return elementMapper.selByRid(rid);
    }
}
