package com.phenix.study.dto;

public enum ResultCode {
    /** 成功. ErrorCode : 0 */
    SUCCESS("0", "成功"),

    /** 未知异常. ErrorCode : 01 */
    UNKNOWN_EXCEPTION("01", "未知异常"),

    /** 系统异常. ErrorCode : 02 */
    SYSTEM_EXCEPTION("02", "系统异常"),

    /** 业务错误. ErrorCode : 03 */
    BUSINESS_EXCEPTION("03", "业务错误"),

    /** 提示级错误. ErrorCode : 04 */
    INFO_EXCEPTION("04", "提示级错误"),

    /** 数据库操作异常. ErrorCode : 020001 */
    DATABASE_EXCEPTION("020001", "数据库操作异常"),

    /** 参数验证错误. ErrorCode : 040001 */
    PARAM_EXCEPTION("040001", "参数验证错误"),

    /** 系统正在维护. ErrorCode : 040001 */
    SYSTEM_MAINTAIN_EXCEPTION("11", "系统正在维护");

    private String code;
    private String message;

    //  Constructor、Getter略
    public static ResultCode getByCode(String code) {
        for (ResultCode rc : ResultCode.values()) {
            if (rc.getCode().equals(code)) {
                return rc;
            }
        }
        return null;
    }

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
