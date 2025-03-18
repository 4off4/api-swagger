package project.demo.apiswagger.api.common.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.demo.apiswagger.api.common.Entity.*;
import project.demo.apiswagger.api.common.Repository.*;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {
    private final ErrorCodeRepository errorCodeRepository;

    @Override
    public ErrorCode getErrorCode(String code, String lang) {
        return errorCodeRepository.findByCodeAndLang(code,lang)
                .orElseThrow(() -> new RuntimeException("해당 코드가 존재하지 않습니다." + code));
    }

    @Override
    public String getErrorMsg(String code, String lang) {
        String string = errorCodeRepository.findMessageByCodeAndLang(code, lang);
        return string;
    }
}
