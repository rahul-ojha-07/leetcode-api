package in.rahulojha.leetcodeapi.controller.profilepage;

import in.rahulojha.leetcodeapi.entity.GlobalData;
import in.rahulojha.leetcodeapi.service.LeetCodeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LeetCodeProfilePageController {
    @NonNull
    private final LeetCodeService leetCodeService;

    /**
     * Retrieves the global data for the LeetCode profile page.
     *
     * @return A ResponseEntity containing the global data for the LeetCode profile page.
     */
    @GetMapping("/globalData")
    ResponseEntity<GlobalData> getGlobalData() {
        return ResponseEntity.ok(leetCodeService.getGlobalData());
    }
}
