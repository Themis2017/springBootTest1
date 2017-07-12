package com.njxxx.action;

import com.njxxx.domain.Userinfos;
import com.njxxx.services.UserinfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 10195 on 2017/7/13.
 */
@Controller
@EnableAutoConfiguration
public class InitAction {
    @Autowired
    private UserinfosService userinfosService;

    /**
     * 解决页面上时间的问题
     * @param binder
     */
    @InitBinder
    private void dateBind(ServletRequestDataBinder binder){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(true);
        binder.registerCustomEditor(Date.class,new CustomDateEditor(df,true));
    }
    @RequestMapping("/init.do")
    public ModelAndView init(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("pb",userinfosService.searchAll());
        return mav;
    }
    @RequestMapping("/save.do")
    public  String save(@ModelAttribute(value = "user")Userinfos user){
        userinfosService.saveUser(user);
        return "redirect:/init.do";
    }

    /**
     * 解决页面间相互跳转的问题
     * @param pagename
     * @return
     */
    @RequestMapping("/{pagename}jump.do")
    public String home(@PathVariable( "pagename") String pagename){
        return pagename;
    }

    /**
     * 页面传参
     * @param userid
     * @return
     */
    @RequestMapping("/{userid}del.do")
    public String del(@PathVariable("userid") int userid){
        userinfosService.delUser(userid);
        return "redirect:/init.do";
    }
    @RequestMapping("/{userid}single.do")
    public ModelAndView single(@PathVariable("userid")int userid){
        ModelAndView mav = new ModelAndView("update");
        mav.addObject("user",userinfosService.single(userid));
        return mav;
    }

    /**
     * 页面提交form表单
     * @param user
     * @return
     */
    @RequestMapping("/update.do")
    public String update(@ModelAttribute(value = "user")Userinfos user){
        userinfosService.updateUser(user);
        return "redirect:/init.do";
    }
}
