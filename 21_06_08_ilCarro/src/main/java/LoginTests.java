
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isSignUpFormPresent()) {
            logout();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {

        click(By.xpath("//ul[@class='header__nav desktop']/li[5]"));

        fillLoginForm(new User().withEmail("hummels@gmail.com")
                .withPassword("Hummels098765"));

        submit();

        isLogoutTabPresent();

    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("[name='email']"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

}
