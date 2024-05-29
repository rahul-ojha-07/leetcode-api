package in.rahulojha.leetcodeapi.entity;

import java.util.List;

public record SubmitStats(
        List<SubmissionNum> acSubmissionNum,
        List<SubmissionNum> totalSubmissionNum
) {
}
