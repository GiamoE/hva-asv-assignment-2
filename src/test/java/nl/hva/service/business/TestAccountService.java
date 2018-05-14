package nl.hva.service.business;

import nl.hva.service.business.exception.AccountNotFoundException;
import nl.hva.service.business.exception.AccountInactiveException;
import nl.hva.service.business.impl.AccountServiceImpl;
import nl.hva.service.model.Account;
import nl.hva.service.persistence.AccountRepo;
import org.junit.Before;
import org.junit.BeforeClass;
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

    AccountRepo repo;
    AccountService service;
    final String account = "NL987672212";



    @Before
    // TODO 03.01: See an example of unitary test using Mockito
    public void before() {

        // Creating a mock
        repo = mock(AccountRepo.class);
        // manually injecting the mock into the service
        service = new AccountServiceImpl(repo);

    }

    @Test(expected = AccountNotFoundException.class)
    public void testGettingAccount() throws AccountNotFoundException {

        service.getAccount("blabla");




    }

    // TODO 08: Create your unitary tests using mockito

}
