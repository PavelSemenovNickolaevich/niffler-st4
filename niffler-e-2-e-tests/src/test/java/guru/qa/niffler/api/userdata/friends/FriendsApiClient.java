package guru.qa.niffler.api.userdata.friends;

import guru.qa.niffler.api.RestClient;
import guru.qa.niffler.api.spend.SpendApi;

import javax.annotation.Nonnull;

public class FriendsApiClient extends RestClient {

    private FriendsApi friendsApi;

    public FriendsApiClient(@Nonnull String baseUri) {
        super(baseUri);
        this.friendsApi = retrofit.create(FriendsApi.class);
    }
}
