package project.demo.apiswagger.api.common.dto.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.HashMap;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataResult extends BaseResult {
    private String code;
    private String message;
    private Object data;
    private boolean result;

    protected static final String SUCCESS_DEFAULT_CODE = "S200";
    protected static final String SUCCESS_DEFAULT_MSG = "정상적으로 처리되었습니다.";

    protected static final String FAIL_DEFAULT_CODE = "E500";
    protected static final String FAIL_DEFAULT_MSG = "서버 내부 오류가 발생했습니다.";

    public DataResult() {
        this.code = FAIL_DEFAULT_CODE;
        this.message = FAIL_DEFAULT_MSG;
        this.result = false;
    }

    public void setDefault(boolean success) {
        if (success) {
            code = SUCCESS_DEFAULT_CODE;
            message = SUCCESS_DEFAULT_MSG;
        } else {
            code = FAIL_DEFAULT_CODE;
            message = FAIL_DEFAULT_MSG;
        }
    }

    public void setData(boolean success, Object obj) {
        setDefault(success);
        this.data = obj;
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", this.code != null ? true : false);
        map.put("code", this.code);
        map.put("message", this.message);
        map.put("data", this.data);
        return map;
    }
}