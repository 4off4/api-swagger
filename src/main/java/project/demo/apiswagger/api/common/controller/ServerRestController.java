package project.demo.apiswagger.api.common.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.demo.apiswagger.api.common.service.ServerService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@Tag(name = "Server Time", description = "API 확인용 서버 정보")
@RequiredArgsConstructor
public class ServerRestController {
    private final ServerService serverService;

    @GetMapping("/serverTime")
    @Operation(summary = "서버 시간 정보")
    public ResponseEntity<Map<String, Object>> searchNow() {
        LocalDateTime serverTime = serverService.searchNow();

        // 응답 데이터 구성
        Map<String, Object> response = new HashMap<>();
        response.put("serverTime", serverTime);

        return ResponseEntity.ok(response);
    }

}
