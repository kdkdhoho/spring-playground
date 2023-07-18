package test.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.member.Member;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class SessionController {

    private static final String SESSION_ID = "SESSION_ID";

    private final SessionLoginService sessionLoginService;

    @PostMapping("/login")
    ResponseEntity<Void> adminLogin(
            HttpServletRequest httpRequest,
            @RequestBody LoginRequest request
    ) {
        Member member = sessionLoginService.login(request.name(), request.password());

        HttpSession session = httpRequest.getSession(true);
        session.setAttribute(SESSION_ID, member.id());

        return ResponseEntity.ok().build();
    }
}
