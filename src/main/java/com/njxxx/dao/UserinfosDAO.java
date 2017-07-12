package com.njxxx.dao;

import com.njxxx.domain.Userinfos;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by 10195 on 2017/7/13.
 */
public interface UserinfosDAO {
    @Insert("insert into userinfos (username,birthday) values(#{username},#{birthday})")
    public void saveUser(Userinfos user);
    @Select("select * from userinfos")
    public List<Userinfos> findAll();
    @Delete("delete from userinfos where userid=#{userid}")
    public void del(int userid);
    @Select("select  *  from userinfos where userid=#{userid}")
    public Userinfos findByUserid(int userid);
    @Update("update userinfos set username=#{username},birthday=#{birthday} where userid=#{userid}")
    public void update(Userinfos user);

}
