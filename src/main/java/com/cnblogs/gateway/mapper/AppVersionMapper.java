package com.cnblogs.gateway.mapper;

import com.cnblogs.gateway.domain.AppVersion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 应用版本表（app_versions）
 * @author RAE
 * @date 2022/03/21
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@Mapper
public interface AppVersionMapper {

    /**
     * 获取最新版本
     * @return 版本信息
     */
    @Select("SELECT * FROM APP_VERSIONS ORDER BY VERSION_CODE DESC LIMIT 1")
    AppVersion getLastVersion();
}
