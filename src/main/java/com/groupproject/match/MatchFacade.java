package com.groupproject.match;

import com.groupproject.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatchFacade {
    private UserFacade userFacade;

    @Autowired
    public MatchFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }
}
