package in.rahulojha.leetcodeapi.entity;

import java.util.List;

public record Question(
        double acRate,
        String difficulty,
        String freqBar,
        String frontendQuestionId,
        boolean isFavor,
        boolean paidOnly,
        String status,
        String title,
        String titleSlug,
        boolean hasVideoSolution,
        boolean hasSolution,
        List<TopicTag> topicTags
) {
}
