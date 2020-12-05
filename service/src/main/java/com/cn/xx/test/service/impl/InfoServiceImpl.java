package com.cn.xx.test.service.impl;

import com.cn.xx.test.mybaties.dao.InfoMapper;
import com.cn.xx.test.mybaties.modle.Info;
import com.cn.xx.test.mybaties.modle.InfoExample;
import com.cn.xx.test.service.InfoService;
import com.xx.base.BaseQuery;
import com.xx.base.PageTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Resource
    private InfoMapper mapper;

    @Override
    public PageTemplate<Info> getByQuery(BaseQuery query) {
        InfoExample example = new InfoExample();
        InfoExample.Criteria criteria = example.createCriteria();

        if (query.isNotEmpty("uid")){
            criteria.andUidEqualTo(query.getInt("uid"));
        }

        if (query.isNotEmpty("id")){
            criteria.andIdEqualTo(query.getInt("id"));
        }

        if (query.isNotEmpty("iType")){
            criteria.andITypeEqualTo(query.getString("iType"));
        }

        example.setPage(query.getCurrent(),query.getSize());
        example.setOrderByClause("created desc");

        return PageTemplate.create(example,mapper,query);
    }

    @Override
    public boolean add(Info bookInfo) {
        return mapper.insertSelective(bookInfo) > 0;
    }

    @Override
    public boolean delete(Long id) {
        Info bookInfo = getById(id);
        if (bookInfo == null){
            return true;
        }
        return mapper.deleteByPrimaryKey(id.intValue()) > 0;
    }

    @Override
    public Info getById(Long id) {
        return mapper.selectByPrimaryKey(id.intValue());
    }

    @Override
    public boolean edit(Info bookInfo) {
        return mapper.updateByPrimaryKeySelective(bookInfo) > 0;
    }

    @Override
    public boolean deleteList(List<Long> ids) {
        return false;
    }
}
