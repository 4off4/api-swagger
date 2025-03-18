package project.demo.apiswagger.api.common.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

@Data
@SuppressWarnings("serial")
public class BaseResult implements Serializable {
    @Schema(description="현재페이지", defaultValue = "1") protected Integer page = 1;
    @Schema(description="페이지당개수", defaultValue = "20") protected Integer perPage = 10;
    @Schema(description="전체페이지수") protected Integer totalPage = 0;

    @JsonIgnore@Schema(description="초기 offset") protected Integer pageOffset = 0;
    @JsonIgnore @Schema(description="정렬") protected Sort sort;
    @JsonIgnore @Schema(description="전체건수") protected Integer totalCount = 0;

    public void putPagination(Pagination pagination){
        if ( pagination.getPage() != null) {
            this.page = pagination.getPage();
        }
        this.perPage = pagination.getPerPage();
        this.totalPage = pagination.getTotalCount();
        this.totalCount = pagination.getTotalCount();
        this.pageOffset = (page - 1) * perPage;
    }
}