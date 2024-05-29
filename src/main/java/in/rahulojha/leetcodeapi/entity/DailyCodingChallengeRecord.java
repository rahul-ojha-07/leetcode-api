package in.rahulojha.leetcodeapi.entity;

import java.util.List;

public record DailyCodingChallengeRecord(
        List<DailyCodingChallengeQuestion>  challenges,
        List<DailyCodingChallengeQuestion> weeklyChallenges
) {

}
