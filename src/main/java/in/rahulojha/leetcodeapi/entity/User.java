package in.rahulojha.leetcodeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record User(
        long joinedTimestamp,
        SubmitStats submitStats
) {
}
