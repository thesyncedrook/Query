package com.query.query.controller;

import com.query.query.objectmapper.GeneralObject;
import com.query.query.objectmapper.Transaction;
import org.apache.catalina.startup.AddPortOffsetRule;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
public class QueryController {

    private Map<String, Map> queryMap = new HashMap<>();

    @GetMapping("/get/balance")
    public Double getBalance(@RequestParam (value = "accounNumber") String accountNumber){
        Map map= queryMap.get(accountNumber);
        Double balance = (Double) map.get("balance");
        return balance;
    }

    @GetMapping("/get/withdraws")
    public List<Transaction> getWithdraws(@RequestParam (value="accountNumber") String accountNumber){
       Map map= queryMap.get(accountNumber);
        ArrayList transactions = (ArrayList) map.get("transactions");

        Iterator itr = transactions.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        return transactions;
    }

    @PostMapping("/events")
    public void handleEvents(@RequestBody GeneralObject object) {


        if (object.getType().equals("ACCOUNT_CREATED")) {
            Map map = new HashMap();
            map.put("accountNumber", object.getAccountNumber());
            map.put("balance", object.getBalance());
            map.put("transactions", new ArrayList<>());
            queryMap.put(object.getAccountNumber(), map);
        }

        if (object.getType().equals("WITHDRAW_TRANSACTION_HAPPENED")) {
            Map map = queryMap.get(object.getAccountNumber());
            Double bal = (double) map.get("balance");
            System.out.println(bal);
            bal = bal - object.getAmount();
            map.put("balance", bal);
            Double bal1 = (double) map.get("balance");
            System.out.println(bal1);
            Transaction transaction=new Transaction();
            transaction.setAccountNumber(object.getAccountNumber());
            transaction.setAmount(object.getAmount());
            transaction.setTransactionType(object.getTransactionType());
            transaction.setTransactonNumber(object.getTransactonNumber());
            transaction.setTransactionTs(LocalDateTime.now());
            transaction.setType("WITHDRAW_TRANSACTION_HAPPENED");
            ArrayList transactions = (ArrayList) map.get("transactions");
            transactions.add(transaction);
        }

        if (object.getType().equals("DEPOSIT_TRANSACTION_HAPPENED")) {
            Map map = queryMap.get(object.getAccountNumber());
            Double bal = (double) map.get("balance");
            System.out.println(bal);
            bal = bal + object.getAmount();
            map.put("balance", bal);
            Double bal1 = (double) map.get("balance");
            System.out.println(bal1);
            Transaction transaction=new Transaction();
            transaction.setAccountNumber(object.getAccountNumber());
            transaction.setAmount(object.getAmount());
            transaction.setTransactionType(object.getTransactionType());
            transaction.setTransactonNumber(object.getTransactonNumber());
            transaction.setTransactionTs(LocalDateTime.now());
            transaction.setType("DEPOSIT_TRANSACTION_HAPPENED");
            ArrayList transactions = (ArrayList) map.get("transactions");
            transactions.add(transaction);
        }

        for (Map.Entry<String, Map> entry : queryMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }
    }
}
