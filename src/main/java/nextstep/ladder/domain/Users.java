package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Users {

    private static final String COMMA = ",";
    private static final int EMPTY = 0;

    private final List<User> users;

    public Users(String usersNameString) {
        throwIfNullOrEmpty(usersNameString);
        this.users = Arrays.stream(usersNameString.split(COMMA))
                .map(User::new)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    private void throwIfNullOrEmpty(String usersNameString) {
        if (usersNameString == null || usersNameString.length() == EMPTY) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_USERS_NAME_STRING);
        }
    }

    public int size() {
        return this.users.size();
    }

    public List<User> export() {
        return this.users;
    }

}
