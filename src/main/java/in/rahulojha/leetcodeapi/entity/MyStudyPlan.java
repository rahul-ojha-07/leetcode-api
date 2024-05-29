package in.rahulojha.leetcodeapi.entity;

import java.util.List;

public record MyStudyPlan(
        boolean hasMore,
        long total,
        List<StudyPlan> planUserProgress
) {
}
