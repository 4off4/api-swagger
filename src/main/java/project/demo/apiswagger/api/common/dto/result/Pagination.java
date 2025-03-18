package project.demo.apiswagger.api.common.dto.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Pagination {
    Integer page = 0;
    Integer perPage = 10;
    Integer pageCount = 0;
    Integer totalCount = 0;
    @Schema(description="초기 offset") private Integer pageOffset = 0;

    public void setTotalCount(Integer totalCount){
        this.totalCount = totalCount;
        if(perPage > 0) {
            this.pageCount = (totalCount / perPage) + (totalCount % perPage == 0 ? 0 : 1);
        }else {
            this.pageCount = 0;
        }
    }

    public Pagination(Integer page, Integer perPage) {
        if (page != null && page > 0) {
            this.page = page;
        } else {
            page = 1;
        }
        if (perPage != null && perPage > 0) {
            this.perPage = perPage;
        }
        this.pageOffset = (page - 1) * perPage;
    }

    public Pagination(Integer page, Integer perPage, Integer totalCount) {
        if (page != null && page > 0) {
            this.page = page;
        } else {
            page = 1;
        }
        if (perPage != null && perPage > 0) {
            this.perPage = perPage;
        }
        this.totalCount = totalCount;
        this.pageOffset = (page - 1) * perPage;
    }
}
