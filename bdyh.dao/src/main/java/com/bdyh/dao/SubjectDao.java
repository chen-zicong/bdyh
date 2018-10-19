package com.bdyh.dao;

import com.bdyh.entity.Subject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SubjectDao {
    @Update("update subject set Status  =#{status} where  subject_id = #{subjectId}")
    public int updateStatusById(@Param("subjectId") Integer subjectId, @Param("status") Integer status);
    @Select("select * from subject where subject = #{subjectName} and clazz_id =#{clazzId}")
    Subject selectBySubjectName(@Param("subjectName") String subjectName,@Param("clazzId") Integer clazzId);
}
