package in.rahulojha.leetcodeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GlobalData(Long userId, boolean isSignedIn, boolean isMockUser, boolean isPremium, boolean isVerified,
                         String username, String avatar, boolean isAdmin, boolean isSuperuser, List<String> permissions,
                         boolean isTranslator, Long activeSessionId, boolean checkedInToday, boolean isStaff,
                         NotificationStatus notificationStatus
                         ) {
}

