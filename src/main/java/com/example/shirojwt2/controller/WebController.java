package com.example.shirojwt2.controller;

import com.example.shirojwt2.database.UserList;
import com.example.shirojwt2.pojo.JsonResult;
import com.example.shirojwt2.pojo.User;
import com.example.shirojwt2.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {


    @GetMapping("/401")
    public JsonResult unLogin(){
        return new JsonResult(401,"你还没有登陆o1",null);
    }

    @PostMapping("/login")
    public JsonResult login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password){

        User user = UserList.userList.get(username);

        System.out.println(UserList.userList.get("zhangwei"));

        if (!StringUtils.isEmpty(user) && user.getPassword().equals(password)){
            return new JsonResult(200,"登陆成功", JwtUtils.buildToken(username,password));
        }
        throw new UnauthorizedException();
    }

    @GetMapping("/porn")
    public JsonResult getPorn(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            return new JsonResult(200,"http://www.pornhub.com",null);
        }
        return new JsonResult(200,"你还没有登陆哦",null);
    }


    @GetMapping("/auth")
    @RequiresAuthentication
    public JsonResult requireAuth(){
        return new JsonResult(200,"你还没有登陆哦",null);
    }


//    @GetMapping("/require_auth")
//    @RequiresAuthentication
//    public ResponseBean requireAuth() {
//        return new ResponseBean(200, "You are authenticated", null);
//    }
//
//    @GetMapping("/require_role")
//    @RequiresRoles("admin")
//    public ResponseBean requireRole() {
//        return new ResponseBean(200, "You are visiting require_role", null);
//    }
//
//    @GetMapping("/require_permission")
//    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
//    public ResponseBean requirePermission() {
//        return new ResponseBean(200, "You are visiting permission require edit,view", null);
//    }
//
//    @RequestMapping(path = "/401")
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ResponseBean unauthorized() {
//        return new ResponseBean(401, "Unauthorized", null);
//    }
}
