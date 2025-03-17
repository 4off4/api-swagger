package project.demo.apiswagger.utility;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class SwaggerBeanUtility {
    @Value("${swagger-ui.ip}")
    List<String> permitIpList;
}
