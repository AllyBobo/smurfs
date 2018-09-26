package com.iscas.smurfs.zuul.remote;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/7
 */
public class DbRemoteHystrix implements DbRemote{
    @Override
    public Boolean checkUserAndPermission(Integer userid, Long permissionid) {
        return false;
    }

    @Override
    public String checkUrlPermission(String url, String method) {
        return "checkUrlPermission  " +url+", this messge send failed ";
    }

    @Override
    public String getAllPermissions() {
        return "getAllPermissions this messge send failed ";
    }
}
