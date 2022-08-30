package com.mubai.sync.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leitengfei
 */
public class ConstantResultCode {
    public static final Integer OK = 0;
    public static final Integer ERROR = 1;
    public static final Integer TOKEN_ERROR = 2;
    public static final Integer NO_PERMISSION = 4;
    public static final Integer VALID_FAIL = 5;
    public static final Integer VALID_FAIL_REFRESH = 6;
    public static final Integer RESULT_FAIL = 7;
    public static final Integer LOGIN_FAIL = 10001;

    public static final Map<Integer, String> MESSAGE = new HashMap<Integer, String>();
    static {
        MESSAGE.put(OK, "Ok");
        MESSAGE.put(ERROR, "服务器发生错误，请联系管理员");
        MESSAGE.put(TOKEN_ERROR, "用户未登录或超时，请重新登录");
        MESSAGE.put(NO_PERMISSION, "您的账号没有此权限");
        MESSAGE.put(LOGIN_FAIL, "用户不存在或密码错误");
        MESSAGE.put(VALID_FAIL, "请检查参数或关联数据");
        MESSAGE.put(RESULT_FAIL, "查询失败，请重试");
        MESSAGE.put(VALID_FAIL_REFRESH, "请检查参数或关联数据");
    };
}
