package com.xinhuanet.hylanda.dao;

import com.xinhuanet.hylanda.model.entity.MediaName;

import java.util.List;

public interface MediaNameMapper {
    int deleteByPrimaryKey(Long standardId);

    int insert(MediaName record);

    MediaName selectByPrimaryKey(Long standardId);

    List<MediaName> selectAll();

    int updateByPrimaryKey(MediaName record);
}