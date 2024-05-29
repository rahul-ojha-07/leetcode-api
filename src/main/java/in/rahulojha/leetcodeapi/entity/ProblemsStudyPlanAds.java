package in.rahulojha.leetcodeapi.entity;

public record ProblemsStudyPlanAds(
        String cover,
        String highlight,
        String name,
        boolean onGoing,
        boolean premiumOnly,
        long questionNum,
        String slug
) {
}
