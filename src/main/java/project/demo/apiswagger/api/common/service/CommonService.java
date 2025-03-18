package project.demo.apiswagger.api.common.service;

import project.demo.apiswagger.api.common.Entity.ErrorCode;

public interface CommonService {
    public ErrorCode getErrorCode(String code, String lang);
    public String getErrorMsg(String code, String lang);
}
