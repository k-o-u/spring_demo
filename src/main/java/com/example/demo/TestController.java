package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {
    @GetMapping("/exec")
    public String exec(Model model) {
        model.addAttribute("msg", "<h1>こんにちは</h1>");
        model.addAttribute("name", "佐藤");
        model.addAttribute("springlink", "https://spring.io/projects/spring-boot");
        model.addAttribute("id", 1);

        List<String> msgList = List.of("1番","2番","3番","4番","5番");
        model.addAttribute("msgList", msgList);
        return "testform";
    }

    @GetMapping("/view")
    public String displayView(Model model) {
        // 共通レイアウトを使用してview表示
        // 共通レイアウトに渡す情報
        model.addAttribute("title", "テスト");
        model.addAttribute("lib", "master::lib");
        model.addAttribute("main", "master::main");
        // 共通レイアウトを呼び出す
        return "common/layout";
    }
}
