package com.cnblogs.gateway.mapper;

import com.cnblogs.gateway.model.Options;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 配置项表（options）
 * @author RAE
 * @date 2022/03/21
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@Mapper
public interface ConfigMapper {

    /**
     * 搜索分组的配置
     * @param groupName 分组名
     * @return 配置列表
     */
    @Select("SELECT * FROM options where group_name=#{groupName}")
    List<Options> findByGroup(String groupName);

    /**
     * 通过Key获取配置
     * @param key key
     * @return 配置项
     */
    @Select("SELECT  * FROM OPTIONS WHERE `KEY`=#{key} LIMIT 1")
    Options getByKey(String key);

    @Insert("INSERT INTO options(NAME, `KEY`, VALUE, GROUP_NAME, CREATED_AT, UPDATED_AT)VALUES(#{name},#{key},#{value},#{groupName}, now(),now())")
    void insert(Options options);
}
