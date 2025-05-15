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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
}
