package bg.softuni.MobLeLeLe.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private String fullName;
    private boolean loggedIn;

    public String getFullName() {
        return fullName;
    }

    public CurrentUser setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
        return this;
    }

    public void clean() {
        fullName = null;
        loggedIn = false;
    }

}
