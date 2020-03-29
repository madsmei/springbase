package com.mads.dao;

import com.mads.entity.ConsultConfigArea;
import com.mads.entity.MadsGoods;
import com.mads.entity.MadsTicket;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommonMapper {

    @Select("select * from consult_configarea where areaCode=#{areaCode}")
    List<ConsultConfigArea> queryAreaByAreaCode(Map param);

    @Select("select * from consult_configarea where areaCode=#{areaCode}")
    List<ConsultConfigArea> queryAreaById(String areaCode);

    @Insert("insert into consult_configarea(AREACODE,AREANAME,STATE) values(#{areaCode},#{areaName},#{state})")
    int addArea(ConsultConfigArea area);

    @Insert("insert into mads_goods (goodCode, goodName, count\n" +
            "\t\t)\n" +
            "\t\tvalues (#{goodCode,jdbcType=VARCHAR}, #{goodName,jdbcType=VARCHAR},\n" +
            "\t\t#{count,jdbcType=INTEGER}\n" +
            "\t\t)")
    int addGood(MadsGoods madsGoods);

    @Select("select * from mads_goods where goodCode=#{goodCode}")
    List<MadsGoods> queryGoodsByGoodCode(String goodCode);

    @Select("select * from mads_goods")
    List<MadsGoods> queryAll();

    @Update("update mads_ticket set version=versoin+1 where ticketId = #{ticketId} and version = #{version}")
    int updateLock(Map map);


    @Select("select * from mads_ticket where ticketId = #{ticketId}")
    List<MadsTicket> queryTicketById(String ticketId);

    @Update("update mads_ticket set ticketCount=ticketCount-#{ticketCount} where ticketId = #{ticketId} and ticketCount >= #{ticketCount}")
    int updateTicket(MadsTicket zgTicket);
}
