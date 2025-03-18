package project.demo.apiswagger.api.common.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.demo.apiswagger.api.common.dto.result.*;
import project.demo.apiswagger.api.common.service.ServerService;
import java.util.Map;

@RestController
@Tag(name = "Server Time", description = "API 확인용 서버 정보")
@RequiredArgsConstructor
public class ServerRestController {
    private final ServerService serverService;

    @GetMapping("/serverTime")
    @Operation(summary = "서버 시간 정보")
    public ResponseEntity<Map<String, Object>> searchNow() {
        DataResult result = new DataResult();
        ResponseEntity<Map<String, Object>> responseEntity;

        result.setData(true, serverService.searchNow());
        responseEntity = new ResponseEntity<>(result.toHashMap(), HttpStatus.OK);

        return responseEntity;
    }
}