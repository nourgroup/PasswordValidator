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
    void lengthTest(){
        Assert.assertEquals(true,mPasswordValidator.AtLeastlength("OKOAA"));
    }

    @Test
    void AtLeastOnedigitTest(){
        Assert.assertEquals(true,mPasswordValidator.AtLeastOneDigit("99Z39939"));
    }

    @Test
    void AtLeastOneletterTest(){
        Assert.assertEquals(true,mPasswordValidator.AtLeastOneLetter("@111Z11"));
    }

    @Test
    void AtLeastDixCarTest(){
        Assert.assertEquals(true,mPasswordValidator.AtLeastDixCar("ZZAADDD"));
    }

    @Test
    void AtLeastOneCarSpeTest(){
        Assert.assertEquals(true,mPasswordValidator.AtLeastOneCarSpe("@ss"));
    }

    @Test
    void ErrorMsgPasswordTest(){
        ArrayList<PasswordValidator.Strings> expectedError
                = new ArrayList<PasswordValidator.Strings>(
                        Arrays.asList(PasswordValidator.Strings.AtLeastOneCarSpe,
                                PasswordValidator.Strings.AtLeastDixCar));
        Assert.assertEquals(expectedError,mPasswordValidator.msgError("@ss1ss"));
    }

    @Test
    void WithoutErrorMsgPasswordTest(){
        Assert.assertEquals(true,mPasswordValidator.msgError("@ss"));
    }
}