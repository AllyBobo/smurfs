import com.iscas.smurfs.common.JsonUtils;
import com.iscas.smurfs.core.entity.Log;

public class TEST {
    public static void main(String[] args) {
        Log log = new Log();
        log.setLogTitle("test test");
        log.setLogType("warn");
        System.out.println(JsonUtils.toJson(log));
    }
}
