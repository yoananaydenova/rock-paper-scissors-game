package com.yoanan.RPSGame.controller;

import com.yoanan.RPSGame.dto.GameDto;
import com.yoanan.RPSGame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @GetMapping("/")
    public String home() {
        return "Hey! You can play RSP here: ";
    }

    @PostMapping("/start")
    public ResponseEntity<String> createItem(@RequestBody  GameDto gameDto) {
        final GameDto savedGame = gameService.createGame(gameDto.getAttempts());
        return ResponseEntity.ok("The game is created!");
    }

    @PostMapping("/game/{move}")
    private ResponseEntity<String> playSimpleGame(@PathVariable String move) {
        return ResponseEntity.ok("Win!");
    }

    // With COOKIE
//    @GetMapping("/")
//    public String readCookie(@CookieValue(value = "username", defaultValue = "Atta") String username) {
//        return "Hey! My username is " + username;
//    }


//    @GetMapping("/change-username")
//    public String setCookie(HttpServletResponse response) {
//        // create a cookie
//        Cookie cookie = new Cookie("username", "Jovan");
//
//        //add cookie to response
//        response.addCookie(cookie);
//
//        return "Username is changed!";
//    }

    // With HTTP Session
//    @PostMapping("/save")
//    public String save(@RequestParam String lang,
//                       HttpServletResponse response,
//                       HttpSession session) {
//
//        session.setAttribute("lang", "newLang");
//        return "session save";
//    }
//
//
//    @GetMapping("/all")
//    public String allLangs(HttpSession session) {
//        Object preferredLang = session.getAttribute("lang");
//
//        if (preferredLang == null) {
//            preferredLang = "hiiii";
//        }
//
////        model.addAttribute("all", allLangs);
////        model.addAttribute("preferredLang", preferredLang);
//        return "languages";
//    }
//
////    @GetMapping("/")
////    private ResponseEntity<String> playSimpleGame() {
////
////        return ResponseEntity.ok("Hello player!");
////    }


//    @GetMapping("/")
//    public String process(Model model, HttpSession session) {
//        @SuppressWarnings("unchecked")
//        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
//
//        if (messages == null) {
//            messages = new ArrayList<>();
//        }
//        model.addAttribute("sessionMessages", messages);
//
//        return "index";
//    }
//
//    @PostMapping("/persistMessage")
//    public String persistMessage(@RequestParam("msg") String msg, HttpServletRequest request) {
//        @SuppressWarnings("unchecked")
//        List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
//        if (messages == null) {
//            messages = new ArrayList<>();
//            request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
//        }
//        messages.add(msg);
//        request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
//        return "redirect:/";
//    }
//
//    @PostMapping("/destroy")
//    public String destroySession(HttpServletRequest request) {
//        request.getSession().invalidate();
//        return "redirect:/";
//    }

}
