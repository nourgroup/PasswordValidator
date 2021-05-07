import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Assert.assertTrue(mPasswordValidator.length("OKOAA"));
    }

    @Test
    void digitTest(){
        Assert.assertTrue(mPasswordValidator.OneDigit("9939939"));
    }

    @Test
    void letterTest(){
        Assert.assertTrue(mPasswordValidator.OneLetter("HHHHZH"));
    }

}