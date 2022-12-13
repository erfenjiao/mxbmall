package ltd.mxb.mall.controller;

import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class controller {
   @GetMapping("/info")
   @ResponseBody
    public String getInfoFromIdea() {
        return "this is a spring boot project from idea";
  }
}