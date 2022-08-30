package com.mubai.sync.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author leitengfei
 */
public class ExceptionUtils {
    public static String getStackTrace(Throwable throwable)
    {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }
}
