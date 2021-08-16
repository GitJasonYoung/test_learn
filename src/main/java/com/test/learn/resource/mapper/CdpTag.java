package com.test.learn.resource.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author Jason
 * @Description
 * @date 2020/12/29 星期二
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("t_batchcdptag")
@ToString
public class CdpTag {

    /**
     *  `id` bigint(64) NOT NULL AUTO_INCREMENT,
     *   `tag_name` varchar(64) DEFAULT NULL COMMENT '标签名称',
     *   `tag_code` varchar(32) DEFAULT NULL COMMENT '会员类型',
     *   `tag_id` varchar(32) DEFAULT NULL COMMENT '微信公众号',
     *   `union_id` varchar(64) DEFAULT NULL COMMENT '微信uniobid',
     * 	 `open_id` varchar(64) DEFAULT NULL COMMENT '微信openid',
     * 			 `member_type` varchar(64) DEFAULT NULL COMMENT 'membertype',
     * 			 `app_id` varchar(64) DEFAULT NULL COMMENT 'appid',
     *   `last_time` datetime DEFAULT NULL,
     */
    private Long id;
    private String tagName;
    private String tagCode;
    private Integer tagId;
    private String unionId;
    private String openId;
    private String memberType;
    private String appId;
    private String lastTime;
    private String updateTime;
    private Integer isBatch;
}
