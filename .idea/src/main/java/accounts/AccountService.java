package accounts;

import java.util.HashMap;
import java.util.Map;
/**
 * Класс содержит хранилища сессии и
 * хранилище аккаунта(login password)
 *
 */

public class AccountService {
    /*По логину будем определять что есть аккаунт*/
    private final Map<String, UserProfile> loginToProfile;
    /*По id сессии будем определять что аккаунт авторизовался(есть сессия)*/
    private final Map<String, UserProfile> sessionToProfile;

    public AccountService(){
        loginToProfile = new HashMap<>();
        sessionToProfile = new HashMap<>();
    }
    /**
     * Добавление профиля
     */
    public void addProfile(UserProfile userProfile){
        loginToProfile.put(userProfile.getLogin(),userProfile);
    }

}
