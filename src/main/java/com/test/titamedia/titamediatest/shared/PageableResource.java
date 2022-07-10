package com.test.titamedia.titamediatest.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageableResource<T>{
    private List<T> content;
    private Integer totalPages;
    private Long totalElements;
}
