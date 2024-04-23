package org.example.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@JsonSerialize
@ToString
public class ProductSearchRequest {
    String name;
    String sortBy;
    String sortOrder;
    List<String> categories;
    List<String> attributes;
    int pageNumber;
    int pageSize;
}
