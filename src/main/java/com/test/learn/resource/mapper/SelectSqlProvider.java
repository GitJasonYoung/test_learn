package com.test.learn.resource.mapper;

import org.apache.ibatis.javassist.runtime.Desc;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author Jason
 * @Description
 * @date 2021-08-13 星期五
 */
public class SelectSqlProvider {

    public String selectByUnionIdAndTagName(String unionId, String tagName){
        return new SQL(){
            {
                SELECT("*");
                FROM("t_batchcdptag");
                if (unionId != null){
                    WHERE("union_id = #{unionId}");
                }
                AND();
                if (tagName != null){
                    WHERE("tag_name = #{tagName}");
                }
            }
        }.toString();
    }
}
