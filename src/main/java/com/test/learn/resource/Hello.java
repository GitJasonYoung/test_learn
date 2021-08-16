package com.test.learn.resource;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.learn.resource.mapper.BatchCdpTagMapper;
import com.test.learn.resource.mapper.CdpTag;
import com.xxl.job.core.biz.model.ReturnT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNullApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jason
 * @Description
 * @date 2021/06/30 星期三
 */
@RequestMapping("/hello")
@RestController
@Slf4j
public class Hello {

    @Autowired
    private BatchCdpTagMapper batchCdpTagMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/mepper")
    public Object mapper (){
        log.info("queryWrapper 分组查询");
        QueryWrapper<CdpTag> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_batch",3);
        queryWrapper.groupBy("tag_name");
        queryWrapper.select("tag_name","is_batch");// 只查出对象中该字段的值,其他字段为null
        List<CdpTag> cdpTags1 = batchCdpTagMapper.selectList(queryWrapper);
        List<CdpTag> cdpTags = batchCdpTagMapper.selectList(new LambdaQueryWrapper<CdpTag>()
                .groupBy(CdpTag::getTagName)
                .select(CdpTag::getTagName)// 只查出对象中该字段的值,其他字段为null
        );
        return cdpTags1.toArray();
    }
    @RequestMapping(method = RequestMethod.GET,path = "/mepper2")
    public Object mapper2 (@RequestParam("time")String time){
        log.info("querywrapper 自定义方法查询");
        log.info("requestparam :{}",time);
        List<Map> tags = batchCdpTagMapper.list(time);
        CdpTag cdpTag = new CdpTag();
        cdpTag.setTagName("嘿嘿");
        cdpTag.setTagCode("123123123123");
        cdpTag.setTagId(000);
        cdpTag.setUnionId("嘿嘿123");
        cdpTag.setOpenId("嘿嘿123");
        cdpTag.setMemberType("babyCare");
        cdpTag.setAppId("嘿嘿123");
        cdpTag.setLastTime(time);
        cdpTag.setUpdateTime(null);
        int insert = batchCdpTagMapper.insert(cdpTag);
        log.info("insert: {}",insert);
        // 根据查询每个标签需要打的粉丝
        List<CdpTag> tagAllFans = new ArrayList<>();
        log.info("2222");
        for (Map tag : tags) {
            log.info("111111");
            tagAllFans = batchCdpTagMapper.selectByTag(time, (String) tag.get("tag_name"));

            List<String> unionIds = tagAllFans.stream().map(CdpTag::getUnionId).collect(Collectors.toList());

            return tagAllFans;
        }
        return tagAllFans;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/mepper3")//required = true 传参校验
    public Object mapper2 (@RequestParam(value = "unionId")String unionId,@RequestParam(value = "tagName")String tagName){
        log.info("sqlprovider 方法查询");
        log.info("requestparam :{},{}",unionId,tagName);
        return batchCdpTagMapper.selectByUnionIdAndTagName(unionId,tagName);
    }

    public static void main(String[] args) {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String now_add_10m = LocalDateTime.now().plusMinutes(10).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(now);
        System.out.println(now_add_10m);
    }
}
