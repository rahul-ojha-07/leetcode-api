package in.rahulojha.leetcodeapi.entity;

public record StreakCounter(
        long streakCount,
        long daysSkipped,
        boolean currentDayCompleted
) {
}
