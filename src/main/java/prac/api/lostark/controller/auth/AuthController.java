package prac.api.lostark.controller.auth;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import prac.api.lostark.dto.AuthJoinDTO;
import prac.api.lostark.service.AuthService;


@Controller
@RequestMapping("/auth")
@Log4j2
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public void loginGET(String error, String logout){
        log.info("loginGET**************************************");
        log.info("logout : " + logout);

        if(logout != null){
            log.info("user logout......");
        }
    }
    @GetMapping("/join")
    public void joinGET(){
        log.info("joinGET**************************************");
    }
    @PostMapping("/join")
    public String joinPOST(AuthJoinDTO authJoinDTO, RedirectAttributes redirectAttributes){
        log.info("joinPOST**************************************");
        log.info("authJoinDTO : " + authJoinDTO);

        try {
            authService.join(authJoinDTO);
        } catch (AuthService.MidExistException e) {
            redirectAttributes.addFlashAttribute("error", "id 중복");
            return "redirect:/member/join";
        }

        redirectAttributes.addFlashAttribute("result", "success");
        return "redirect:/auth/login";
    }
}
