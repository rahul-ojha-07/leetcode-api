package in.rahulojha.leetcodeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;



@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record QuestionMetaData(
        String id,
        double acRate,
        String difficulty,
        String freqBar,
        Long frontendQuestionId,
        boolean isFavor,
        boolean paidOnly,
        String status,
        String title,
        String titleSlug,
        List<TopicTag> topicTags,
        boolean hasSolution,
        boolean hasVideoSolution,
        String translatedTitle
) {

}
