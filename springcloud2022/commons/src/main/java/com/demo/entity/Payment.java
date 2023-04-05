package com.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    /**IdType.策略有ASSIGN_ID策略、ASSIGN_UUID策略、INPUT策略、AUTO策略
     * 2.1、@TableId(type = IdType.策略)注解，主键的生成策略
     * 在向数据库表中新增数据时，往往Id都是自动生成的的，而不是手动维护的。
     * 所以可以在实体类中的Id字段上加上注解@TableId(type = IdType.策略)，表示字段的生成策略。
     */
    @TableId(type = IdType.AUTO)
    private Integer  id ;
    private String serial ;
    private String name ;
    private String  dbSource ;//db_source字段自动解析成dbSource
    private Double  price ;
    //.MySQLSyntaxErrorException: Unknown column 'go_to' in 'field list' 说明设计数据库不能用驼峰字段
    //private String goTo ;

}
