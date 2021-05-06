package com.study.model.params;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description
 * @create 2019-05-29 11:48
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageRequest {

    private Integer pageNumber = 1;
    private Integer pageSize = 15;

    @JsonIgnore
    public Integer getOffset() {
        return (pageNumber - 1) * pageSize;
    }

    @JsonIgnore
    public Integer getLimit(){
        return pageSize;
    }
}
