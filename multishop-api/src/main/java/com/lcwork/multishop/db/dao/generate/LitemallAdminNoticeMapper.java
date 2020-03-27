package com.lcwork.multishop.db.dao.generate;

import com.lcwork.multishop.db.domain.generate.LitemallAdminNotice;
import com.lcwork.multishop.db.domain.generate.LitemallAdminNoticeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LitemallAdminNoticeMapper {
    long countByExample(LitemallAdminNoticeExample example);

    int deleteByExample(LitemallAdminNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LitemallAdminNotice record);

    int insertSelective(LitemallAdminNotice record);

    LitemallAdminNotice selectOneByExample(LitemallAdminNoticeExample example);

    LitemallAdminNotice selectOneByExampleSelective(@Param("example") LitemallAdminNoticeExample example, @Param("selective") LitemallAdminNotice.Column... selective);

    List<LitemallAdminNotice> selectByExampleSelective(@Param("example") LitemallAdminNoticeExample example, @Param("selective") LitemallAdminNotice.Column... selective);

    List<LitemallAdminNotice> selectByExample(LitemallAdminNoticeExample example);

    LitemallAdminNotice selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallAdminNotice.Column... selective);

    LitemallAdminNotice selectByPrimaryKey(Integer id);

    LitemallAdminNotice selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") LitemallAdminNotice record, @Param("example") LitemallAdminNoticeExample example);

    int updateByExample(@Param("record") LitemallAdminNotice record, @Param("example") LitemallAdminNoticeExample example);

    int updateByPrimaryKeySelective(LitemallAdminNotice record);

    int updateByPrimaryKey(LitemallAdminNotice record);

    int logicalDeleteByExample(@Param("example") LitemallAdminNoticeExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}