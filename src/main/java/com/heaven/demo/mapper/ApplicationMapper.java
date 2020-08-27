package com.heaven.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 应用信息mapper
 *
 * @author zhangjian
 * @date 2020/08/18 17:16
 */
@Mapper
public interface ApplicationMapper {

    /**
     * 应用列表查询
     *
     * @return
     */
    List<Map> list();

}
