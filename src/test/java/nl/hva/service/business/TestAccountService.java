package nl.hva.service.business;

import nl.hva.service.business.exception.AccountNotFoundException;
import nl.hva.service.business.exception.AccountInactiveException;
import nl.hva.service.business.impl.AccountServiceImpl;
import nl.hva.service.model.Account;
import nl.hva.service.persistence.AccountRepo;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestAccountService {


    @Test
    // TODO 03.01: See an example of unitary test using Mockito
    public void before() {

        final String account = "NL987672212";

        // Creating a mock
        // TODO 04: See an example of mock creationg
        AccountRepo repo = mock(AccountRepo.class);

        // Creating a dummy account

        Account acc = new Account(account,"John Doe",0,false);

        // Creating a rule
        // TODO 05: See examples of rules
        when(repo.getAccountById(account)).thenReturn(acc);
        when(repo.setInactive(anyString(),anyBoolean())).thenAnswer( i -> {

           acc.setInactive(((Boolean)i.getArgument(1)));
           return acc;
        });

        // calling the mock
        Account otherAccountRef = repo.getAccountById(account);
        repo.setInactive(account,true);

        // TODO 06: See example to check if the mock was used
        verify(repo).getAccountById(account);
        verify(repo).setInactive(anyString(),anyBoolean());

    }

    // TODO 08: Create your unitary tests using mockito

}
