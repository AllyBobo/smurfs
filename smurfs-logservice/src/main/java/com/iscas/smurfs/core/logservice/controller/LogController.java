package com.iscas.smurfs.core.logservice.controller;

import com.iscas.smurfs.core.common.utils.JsonUtils;
import com.iscas.smurfs.core.entity.Log;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    @RequestMapping("log")
    @ResponseBody
    public String log(@RequestBody Log log) {
        return JsonUtils.toJson(log);
    }
}
