package org.example.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("visitCount2")
public class SessionController {

    @ModelAttribute("visitCount2")
    public Integer initVisitCount2() {
        return 0;
    }

    @GetMapping("/visit2")
    public String trackVisit(@ModelAttribute("visitCount2") Integer visitCount2, Model model) {
        visitCount2++;
        model.addAttribute("visitCount2", visitCount2);
        return "visit2";
    }

    //    // 세션 전체 초기화
//    @GetMapping("resetVisit")
//    public String resetVisit(SessionStatus status) {
//        status.setComplete();
//        return "redirect:/visit2";
//    }

    // 특정 세션만 초기화
    @GetMapping("resetVisit")
    public String resetVisit(HttpSession session) {
        session.removeAttribute("visitCount2");
//        session.invalidate();
        return "redirect:/visit2";
    }


    //        // HttpSession을 직접 이용한 예
//    @GetMapping("/visit2")
//    public String trackVisit(HttpSession session, Model model) {

//        // 세션에서 방문 횟수 가져오기
//        Integer visitCount = (Integer) session.getAttribute("visitCount");
//        if(visitCount == null) {
//            // 처음 방문시
//            visitCount = 0;
//        }
//        visitCount++;
//        session.setAttribute("visitCount", visitCount); // session에 저장
//
//        model.addAttribute("visitCount", visitCount);
//        return "visit2";
}
