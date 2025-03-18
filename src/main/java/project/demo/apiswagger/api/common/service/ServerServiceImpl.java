package project.demo.apiswagger.api.common.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.demo.apiswagger.api.common.dao.ServerMapper;

import java.time.LocalDateTime;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ServerServiceImpl implements ServerService  {
    private final ServerMapper serverMapper;
    @Override
    public LocalDateTime searchNow() {
        return serverMapper.selectNow();
    }
}