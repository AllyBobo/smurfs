package com.iscas.smurfs.opera1service.controller;

import com.iscas.smurfs.common.JsonUtils;
import com.iscas.smurfs.core.entity.Log;
import com.iscas.smurfs.opera1service.remote.DbRemote;
import com.iscas.smurfs.opera1service.remote.LogRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Opera1Controller {

    @Autowired
    DbRemote dbRemote;
    @Autowired
    LogRemote logRemote;

    @RequestMapping("db/findByCategoryType/{type}")
    @ResponseBody
    public String findByCategoryType(@PathVariable("type") String type) {
        return JsonUtils.toJson(dbRemote.findByCategoryType(type));
    }

    @RequestMapping("log")
    @ResponseBody
    public String log() {
        Log log = new Log();
        log.setLogType("warn");
        log.setLogTitle("test test");
        return logRemote.log(log);
    }

}
