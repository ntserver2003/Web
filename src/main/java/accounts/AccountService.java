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
    public void addProfile(accounts.UserProfile userProfile){

        loginToProfile.put(userProfile.getLogin(),userProfile);

    }
    /**
     * Получение профиля
     */
    public UserProfile getProfile(String login){
        return loginToProfile.get(login);
    }
    /**
     * Добавление сессии
     */
    public void addSession(String sessionId ,UserProfile userProfile){
        sessionToProfile.put(sessionId,userProfile);
    }
    /**
     * Получение сессии профиля
     */
    public UserProfile getProfileBySession(String sessionID){
        return sessionToProfile.get(sessionID);
    }
    /**
     * Удаление сессии
     */
    public void deleteProfile(String sessionID){
        sessionToProfile.remove(sessionID);
    }

}
