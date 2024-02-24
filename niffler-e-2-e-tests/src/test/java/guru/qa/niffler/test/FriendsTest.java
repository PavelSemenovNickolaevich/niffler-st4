package guru.qa.niffler.test;

import com.codeborne.selenide.Selenide;
import guru.qa.niffler.jupiter.annotations.User;
import guru.qa.niffler.jupiter.extension.UsersQueueExtension;
import guru.qa.niffler.model.UserJson;
import guru.qa.niffler.pageobject.WelcomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static guru.qa.niffler.jupiter.annotations.User.UserType.*;

@ExtendWith(UsersQueueExtension.class)
public class FriendsTest extends BaseWebTest {

    @BeforeEach
    void doLogin(@User(WITH_FRIENDS) UserJson user) {
        Selenide.open("http://127.0.0.1:3000/main", WelcomePage.class)
                .clickLoginButton();
    }

    @Test
    void friendsTableShouldNotBeEmpty0(@User(WITH_FRIENDS) UserJson user) throws Exception {
        Thread.sleep(3000);
    }

    @Test
    void friendsTableShouldNotBeEmpty1(@User(WITH_FRIENDS) UserJson user) throws Exception {
        Thread.sleep(3000);
    }

    @Test
    void friendsTableShouldNotBeEmpty2(@User(WITH_FRIENDS) UserJson user) throws Exception {
        Thread.sleep(3000);
    }

    @Test
    void checkUserHasFriends(@User(WITH_FRIENDS) UserJson user) {

        loginPage
                .login(user.username(), user.testData().password());

        headerFragment.
                clickFriendsBtn();
        friendsPage
                .checkCorrectDisplayStateFriend("loki", "You are friends");
    }

    @Test
    void checkUserHasFriendsWithoutParam() {
        headerFragment.
                clickFriendsBtn();
        friendsPage
                .checkCorrectDisplayStateFriend("123", "You are friends");
    }

    @Test
    void checkUserSendFriendRequest(@User(INVITATION_SEND) UserJson user) {

        loginPage
                .login(user.username(), user.testData().password());

        headerFragment.
                clickAllPeopleBtn();
        allPeoplePage
                .checkCorrectDisplayPendingFriendState("Pending invitation", "test");

    }

    @Test
    void checkUserReceivedFriendRequest(@User(INVITATION_RECEIVED) UserJson user) {

        loginPage
                .login(user.username(), user.testData().password());

        headerFragment.
                clickFriendsBtn();
        friendsPage
                .isDisplayedActionsSubmitBtn("duck")
                .isDisplayedDeclineBtn("duck");

    }
}