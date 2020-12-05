package com.cn.xx.test.service;

import com.cn.xx.test.mybaties.modle.Info;
import com.xx.base.BaseQuery;
import com.xx.base.PageTemplate;

import java.util.List;

/**
 * 信息内容获取服务类
 * @author lucky_morning
 */
public interface InfoService {
    /**
     * 通过条件查询
     * @param query 查询条件
     * @return
     */
    PageTemplate<Info> getByQuery(BaseQuery query);

    /**
     * 添加信息
     * @param bookInfo
     * @return
     */
    boolean add(Info bookInfo);

    /**
     * 通过id删除信息
     * @param id
     * @return
     */
    boolean delete(Long id);

    /**
     * 通过id获取信息
     * @param id
     * @return
     */
    Info getById(Long id);

    List<Info> getByType(Integer type,Integer ls , Integer le);

    /**
     * 编辑
     * @param bookInfo
     * @return
     */
    boolean edit(Info bookInfo);

    /**
     * 通过列表删除
     * @param ids
     * @return
     */
    boolean deleteList(List<Long> ids);

}
