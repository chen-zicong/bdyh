package com.bdyh.dao;

import com.bdyh.entity.HomePicture;
import com.bdyh.entity.HomePictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomePictureMapper {
    int countByExample(HomePictureExample example);

    int deleteByExample(HomePictureExample example);

    int deleteByPrimaryKey(Integer pictureId);

    int insert(HomePicture record);

    int insertSelective(HomePicture record);

    List<HomePicture> selectByExample(HomePictureExample example);

    HomePicture selectByPrimaryKey(Integer pictureId);

    int updateByExampleSelective(@Param("record") HomePicture record, @Param("example") HomePictureExample example);

    int updateByExample(@Param("record") HomePicture record, @Param("example") HomePictureExample example);

    int updateByPrimaryKeySelective(HomePicture record);

    int updateByPrimaryKey(HomePicture record);
}