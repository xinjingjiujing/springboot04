package cn.edu.xync.mymavenpro.controller;
import cn.edu.xync.mymavenpro.entity.Account;
import cn.edu.xync.mymavenpro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/")
    public String toIndex(Model model) {
        List<Account> lists = accountService.findAllAcounts();
        for (Account account : lists)
            System.out.println(account);
        model.addAttribute("message", lists);
        return "index";
    }
}
