package org.example.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@JsonSerialize
@ToString
public class Rating {
    private String userId;
    private int rating;
    private String comment;
}
