package nl.hva.service.business;

import nl.hva.service.business.exception.AccountInactiveException;
import nl.hva.service.business.exception.AccountNotFoundException;
import nl.hva.service.business.exception.InsufficientFundsException;
import nl.hva.service.model.Account;

/**
 * Account Service Interface
 * TODO 01: See methods and possible exceptions
 */
public interface AccountService {

    public Account getAccount(String iban) throws AccountNotFoundException;
    public void deactivate(Account acc) throws AccountInactiveException;
    public void transfer(Account source, Account destination, double amount) throws AccountInactiveException, InsufficientFundsException;

}
