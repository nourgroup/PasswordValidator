import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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

    void lengthTest(){
        mPasswordValidator.password = "OKOAAK";
        Assert.assertFalse(mPasswordValidator.length(mPasswordValidator.password));
    }

    void digitTest(){
        mPasswordValidator.password = "9939939";
        Assert.assertFalse(mPasswordValidator.digit(mPasswordValidator.password));
    }

    void letterTest(){
        mPasswordValidator.password = "HHHHZH";
        Assert.assertFalse(mPasswordValidator.letter(mPasswordValidator.password));
    }

}