package com.bdyh.dao;

import com.bdyh.entity.Clazz;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ClazzDao {
    @Select("select * from clazz where clazz = #{clazzName}")
    public Clazz selectByClazzName(@Param("clazzName") String clazzName);

}
