package com.example.testcodem4.controller;

import com.example.testcodem4.model.Customer;
import com.example.testcodem4.model.Transaction;
import com.example.testcodem4.model.TransactionDTO;
import com.example.testcodem4.service.ICustomerService;
import com.example.testcodem4.service.ITransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanInfoFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ITransactionService transactionService;

    @GetMapping("")
    public String showTransactionPage(Model model) {
        List<Transaction> transactions = transactionService.getTransactions();
        model.addAttribute("transactions", transactions);
        return "transaction_page";
    }

    @GetMapping("show-add-transaction")
    public String showAddTransactionPage(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        model.addAttribute("transactionDTO", new TransactionDTO());
        return "add_transaction_page";
    }

    @GetMapping("show-detail-transaction/{id}")
    public String showDetailTransactionPage(@PathVariable int id, Model model) {
        model.addAttribute("transaction", transactionService.findTransactionById(id));
        return "detail_transaction_page";
    }

    @GetMapping("find-transaction")
    public String findTransaction(@RequestParam(name = "type", required = false) String type,
                                  @RequestParam(name = "name", required = false) String name,
                                  Model model) {

        if(type.isEmpty() && name.isEmpty()) {
            showTransactionPage(model);
        } else {
            List<Transaction> list = transactionService.findTransactionByTypeAndCustomerName(type,name);
            model.addAttribute("transactions", list);
        }
        return "transaction_page";
    }



    @PostMapping("add-transaction")
    public String addTransaction(@Valid @ModelAttribute("transactionDTO") TransactionDTO transactionDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customers", customerService.getCustomers());
            return "add_transaction_page";
        }
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionDTO, transaction);
        transactionService.addTransaction(transaction);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/";
    }

    @PostMapping("delete-transaction/{id}")
    public String deleteTransaction(@PathVariable int id,
                                    RedirectAttributes redirectAttributes) {
        transactionService.deleteTransactionById(id);
        redirectAttributes.addFlashAttribute("message", "Đã xóa thành công giao dịch!");
        return "redirect:/";
    }
}
