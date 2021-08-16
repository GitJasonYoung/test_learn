package com.test.learn.resource.mapper;


import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * @author Jason
 * @Description
 * @date 2020/12/29 星期二
 */
@Mapper
public interface BatchCdpTagMapper extends BaseMapper<CdpTag> {

    @Select("select tag_name from t_batchcdptag where is_batch = false and last_time between DATE_SUB(#{now},INTERVAL 8 hour) and #{now} group by tag_name;")
    List<Map> list(@Param("now") String now);

    @SelectProvider(type = SelectSqlProvider.class,method = "selectByUnionIdAndTagName")
    List<CdpTag> selectByUnionIdAndTagName(@Param("unionId")String unionId,@Param("tagName")String tagName);

    @Select("select * from t_batchcdptag where is_batch = 0 and last_time between DATE_SUB(#{now},INTERVAL 8 hour) and #{now} and tag_name = #{tagName};")
    List<CdpTag> selectByTag(@Param("now") String now,@Param("tagName") String tagName);
}
