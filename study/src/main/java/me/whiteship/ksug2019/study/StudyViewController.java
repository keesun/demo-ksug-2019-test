package me.whiteship.ksug2019.study;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class StudyViewController {

    private final StudyKeywordRepository repository;

    @GetMapping("/study")
    public String home() {
        return "study";
    }

    @GetMapping("/study/keyword/{keyword}")
    public String findByKeyword(@PathVariable String keyword, Model model) {
        List<StudyKeyword> byKeyword = repository.findByKeyword(keyword);
        model.addAttribute("keyword", keyword);
        model.addAttribute("names", byKeyword.stream().map(k -> k.getUsername()).sorted().collect(Collectors.toList()));
        return "view";
    }

}
