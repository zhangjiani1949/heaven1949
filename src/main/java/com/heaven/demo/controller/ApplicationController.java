package com.heaven.demo.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.Assert;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.enums.ApiErrorCode;
import com.heaven.demo.mapper.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 应用管理Controller
 * https://www.jianshu.com/p/9b6eb3308294
 * https://blog.51cto.com/yushiwh/2128937
 * https://my.oschina.net/u/3574106/blog/1818345
 * https://www.cnblogs.com/WUXIAOCHANG/p/10886534.html
 *
 * @author zhangjian
 * @date 2020/08/18 17:36
 */
@RestController
@RequestMapping("/app")
public class ApplicationController extends ApiController {

    @Autowired
    private ApplicationMapper applicationMapper;

    @GetMapping("/index")
    public R index(@RequestParam String name) {
        Assert.notNull(ApiErrorCode.FAILED, name);
        return success(Arrays.asList("1", "2", "3", name));
    }

    @GetMapping("/list")
    public R<List<Map>> list() {
        return success(applicationMapper.list());
    }

}
