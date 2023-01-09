package com.example.mvcviewsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloViewController {
    
    @GetMapping("view")
    public String helloView(){
        return "hello";
    }
}

/*
 *@RequestMappingの属性 
 * valueの使い方
 * 1.処理対象のURLパスをマッピングする
 * @RequestMapping(value="hello")
 * 2.属性だけなら省略できる
 * @RequestMapping("hello")
 * 3.複数パスを指定できる
 * @RequestMapping(value={"hello","hellospring"})
 * methodの使い方
 * 1.HTTPメソッドを指定できる
 * @RequestMapping(value="hello", method=RequestMethod.GET)
 * 2.複数のメソッドを指定できる
 * @RequestMapping(value="hello", method={RequestMethod.GET, Request<e})
 * 
 */