package nl.hva.service.persistence;

import nl.hva.service.model.Account;

public interface AccountRepo {

    /** returns null if the account was not found */
    public Account getAccountById(String iban);

    /** returns the new representation of the account */
    public Account setInactive(String iban, boolean active);

    /** update the account */
    public void updateAccount(Account acc);

}
