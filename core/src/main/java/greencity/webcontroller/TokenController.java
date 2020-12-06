package greencity.webcontroller;

import greencity.security.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@AllArgsConstructor
@RequestMapping("/token")
public class TokenController {
    private final TokenService tokenService;

    /**
     * Method that gets access token from client and set it in cookies.
     *
     * @param accessToken {@link String}
     * @param response    {@link HttpServletResponse}
     * @return html view of management page.
     */
    @PostMapping
    public String passTokenToCookies(@RequestBody String accessToken, HttpServletResponse response) {
        tokenService.passTokenToCookies(accessToken, response);

        return "redirect:/management";
    }
}
