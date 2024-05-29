package in.rahulojha.leetcodeapi.entity;

public record SiteAnnouncement(
        String title,
        String content,
        String blacklistUrls,
        String whitelistUrls,
        String navbarItem
) {
}
