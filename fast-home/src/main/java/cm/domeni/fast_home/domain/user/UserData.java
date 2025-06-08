package cm.domeni.fast_home.domain.user;

import lombok.Builder;

@Builder
public record UserData(
    String id, String firstName, String lastName, String email, String phoneNumber) {}
