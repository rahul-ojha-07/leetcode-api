package in.rahulojha.leetcodeapi.entity;

import java.util.List;

public record QuestionMetaData(Double acRate, String difficulty, Object freqBar, Long frontendQuestionId,
                               Boolean isFavor, Boolean paidOnly, String status, String title, String titleSlug,
                               List<TopicTag> topicTags, Boolean hasSolution, Boolean hasVideoSolution) {

}
