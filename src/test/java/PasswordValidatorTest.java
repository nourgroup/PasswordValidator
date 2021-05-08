import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class PasswordValidatorTest {

    private PasswordValidator mPasswordValidator= null;

    @BeforeEach
    void initPassword(){
        mPasswordValidator = new PasswordValidator();
    }

    @AfterEach
    void cleanPassword(){
        mPasswordValidator = null;
    }

    @Test
    void AtLeast6lengthTest(){
        Assert.assertEquals(false,mPasswordValidator.AtLeastlength("OKOAA"));
    }

    @Test
    void AtLeastOnedigitTest(){
        Assert.assertEquals(true,mPasswordValidator.AtLeastOneDigit("9923993Z9"));
    }

    @Test
    void AtLeastOneletterTest(){
        Assert.assertEquals(true,mPasswordValidator.AtLeastOneLetter("@111Z11"));
    }

    @Test
    void AtLeastDixCarTest(){
        Assert.assertEquals(true,mPasswordValidator.AtLeastDixCar("ZZAA@DDDKKEKEK"));
    }

    @Test
    void AtLeastOneCarSpeTest(){
        Assert.assertEquals(true,mPasswordValidator.AtLeastOneCarSpe("A@1"));
    }

    @Test
    void ErrorMsgPasswordForUserTest(){
        ArrayList<PasswordValidator.Strings> expectedError
                = new ArrayList<PasswordValidator.Strings>(
                        Arrays.asList(PasswordValidator.Strings.AtLeastlength,
                                PasswordValidator.Strings.AtLeastOneDigit));
        Assert.assertEquals(expectedError,mPasswordValidator.msgErrorUser("EEZD"));
    }

    @Test
    void ErrorMsgPasswordForAdminTest(){
        ArrayList<PasswordValidator.Strings> expectedError
                = new ArrayList<PasswordValidator.Strings>(
                Arrays.asList(PasswordValidator.Strings.AtLeastOneDigit,
                        PasswordValidator.Strings.AtLeastOneCarSpe));
        Assert.assertEquals(expectedError,mPasswordValidator.msgErrorAdmin("SAssSZZZZss"));
    }

    @Test
    void WithoutErrorMsgPasswordForUserTest(){
        ArrayList<PasswordValidator.Strings> expectedError
                = new ArrayList<PasswordValidator.Strings>(
                Arrays.asList());
        Assert.assertEquals(expectedError,mPasswordValidator.msgErrorUser("s1s12dss"));
    }

    @Test
    void WithoutErrorMsgPasswordForAdminTest(){
        ArrayList<PasswordValidator.Strings> expectedError
                = new ArrayList<PasswordValidator.Strings>(
                Arrays.asList());
        Assert.assertEquals(expectedError,mPasswordValidator.msgErrorAdmin("@33ss1s12dss"));
    }

    @Test
    void FailPasswordForUserTest(){
        Assert.assertEquals(true,mPasswordValidator.verifyAllForUser("122211"));
    }

    @Test
    void FailPasswordForAdminTest(){
        Assert.assertEquals(true,mPasswordValidator.verifyAllForAdmin("@33sdss"));
    }

    @Test
    void SuccesPasswordForUserTest(){
        Assert.assertEquals(true,mPasswordValidator.verifyAllForUser("@33ss1s12dss"));
    }

    @Test
    void SuccesPasswordForAdminTest(){
        Assert.assertEquals(true,mPasswordValidator.verifyAllForAdmin("@33ss1s12dss"));
    }
}