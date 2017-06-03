package com.github.ipan97.enggal.damang.controller;

import com.github.ipan97.enggal.damang.model.Member;
import com.github.ipan97.enggal.damang.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired
    public void setmemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = "/member")
    public String index() {
        return "redirect:/member/1";
    }

    @RequestMapping(value = "/member/{pageNumber}", method = RequestMethod.GET)
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Member> page = memberService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "member/list";

    }

    @RequestMapping("/member/add")
    public String add(Model model) {

        model.addAttribute("member", new Member());
        return "member/form";

    }

    @RequestMapping("/member/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("member", memberService.get(id));
        return "member/form";

    }

    @RequestMapping(value = "/member/save", method = RequestMethod.POST)
    public String save(Member member, final RedirectAttributes ra) {
        member.setCreatedDate(new Date());
        member.setModifiedDate(new Date());
        Member save = memberService.save(member);
        ra.addFlashAttribute("successFlash", "Member success added.");
        return "redirect:/member";

    }

    @RequestMapping("/member/delete/{id}")
    public String delete(@PathVariable Long id) {

        memberService.delete(id);
        return "redirect:/member";

    }

}
