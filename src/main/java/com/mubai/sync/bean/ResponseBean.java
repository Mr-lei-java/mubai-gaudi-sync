package com.mubai.sync.bean;

import com.mubai.sync.enums.ConstantResultCode;

/**
 * @author leitengfei
 */
public class ResponseBean<T>{
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ResponseBean [errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", result=" + result + "]";
    }
    /**
     *
     */
    public ResponseBean() {

    }
    /**
     * @param errorCode
     * @param errorMsg
     * @param result
     */
    public ResponseBean(Integer errorCode, String errorMsg, T result) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.result = result;
    }
    public ResponseBean(Integer errorCode, T result) {
        this.errorCode = errorCode;
        this.errorMsg = ConstantResultCode.MESSAGE.get(errorCode);
        this.result = result;
    }
    /**
     * @return the errorCode
     */
    public Integer getErrorCode() {
        return errorCode;
    }
    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }
    /**
     * @param errorMsg the errorMsg to set
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    /**
     * @return the result
     */
    public T getResult() {
        return result;
    }
    /**
     * @param result the result to set
     */
    public void setResult(T result) {
        this.result = result;
    }

    /**
     * 错误码，0:请求正常，其他:请求失败
     */
    private Integer errorCode;

    /**
     * 错误信息，请求正常时为OK，否则显示错误原因
     */
    private String errorMsg;

    /**
     * 请求正常时为OK或者需要返回的数据
     * 请求失败时显示错误具体原因
     */
    private T result;
}
