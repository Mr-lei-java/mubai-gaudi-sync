package com.mubai.sync.exception;


import com.mubai.sync.enums.ConstantResultCode;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = -6549529146682180496L;
    private Integer code;

    public BusinessException() {
        super();
    }

    public BusinessException(Integer code) {
        super(ConstantResultCode.Message.get(code));
        this.code = code;
    }

    public BusinessException(Integer code, String extMessage) {
        super(extMessage);
        this.code = code;
    }
    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(Integer code) {
        this.code = code;
    }
}

