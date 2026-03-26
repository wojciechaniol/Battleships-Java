package battleships.player;

import java.util.Objects;

public class GuestPlayer implements IPlayer {
    private String nickname;

    public GuestPlayer(String nickname) {
        this.nickname = Objects.requireNonNullElseGet(nickname, this::generateNickname);
    }

    private String generateNickname() {
        return "randomNickname";
    }

    @Override
    public String getNickname() {
        return nickname;
    }
}
