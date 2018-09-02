package com.iscas.smurfs.core.opera1service.remote;

import com.iscas.smurfs.core.entity.Log;
import org.springframework.stereotype.Component;

@Component
public class LogRemoteHystrix implements LogRemote{

    @Override
    public String log(Log log) {
        return log.getLogTitle()+"  message failed";
    }
}
