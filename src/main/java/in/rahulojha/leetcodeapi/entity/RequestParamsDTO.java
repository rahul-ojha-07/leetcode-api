package in.rahulojha.leetcodeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RequestParamsDTO(String categorySlug,
                               Long skip,
                               Long limit,
                               Map<String, String> filters,
                               String username) {

}