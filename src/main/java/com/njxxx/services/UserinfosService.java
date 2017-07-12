package com.njxxx.services;

import com.njxxx.dao.UserinfosDAO;
import com.njxxx.domain.Userinfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 10195 on 2017/7/13.
 */
@Service
@Transactional
public class UserinfosService {
    @Autowired
    private UserinfosDAO udao;
    public void saveUser(Userinfos user){
        udao.saveUser(user);
    }
    public List<Userinfos> searchAll(){
        return udao.findAll();
    }
    public void delUser(int userid){
        udao.del(userid);
    }
    public Userinfos single(int userid) {
        return udao.findByUserid(userid);
    }
    public void updateUser(Userinfos user){
        udao.update(user);
    }
}
