package nl.hva.service.business.impl;

import nl.hva.service.business.AccountService;
import nl.hva.service.business.exception.AccountInactiveException;
import nl.hva.service.business.exception.AccountNotFoundException;
import nl.hva.service.business.exception.InsufficientFundsException;
import nl.hva.service.model.Account;
import nl.hva.service.persistence.AccountRepo;

public class AccountServiceImpl implements AccountService {

    /* TODO 02: See implementation of account service. It uses a persistence service to manipulate accounts
       Problem: We do not have the repo implementation yet, and the unitary test cycle must occur independently on the repo.
       We need to mock-up the repo (we can do that manually or by using a mock framework) */
    public AccountRepo repo;

    public AccountServiceImpl(AccountRepo repo) {
        this.repo = repo;
    }

    public Account getAccount(String iban) throws AccountNotFoundException {

        Account acc = repo.getAccountById(iban);

        if(acc.equals(null)) {
            throw new AccountNotFoundException("account with number " + iban + " not found");
        }

        return acc;
    }

    public void deactivate(Account acc) throws AccountInactiveException {

        if(acc.inactive = true) {
            Account changed = repo.setInactive(acc.getIban(), false);
        } else {
            throw new AccountInactiveException("The account " + acc.getIban() + " is already inactive");
        }

    }

    @Override
    public void transfer(Account source, Account destination, double amount) throws AccountInactiveException, InsufficientFundsException {

        if(source.isInactive()) {
            throw new AccountInactiveException("Source account " + source.getIban() + " is inactive");
        }

        if(!destination.isInactive()) {
            throw new AccountInactiveException("Destination account " + source.getIban() + " is inactive");
        }

        if(!source.withdraw(amount)) {
            throw new InsufficientFundsException("No funds to transfer " + amount);
        }

        destination.deposit(amount);


    }
}
