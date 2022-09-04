package org.example.hibernate.DTO;

import java.util.Set;
import java.util.UUID;

public class UserWithChatsDTO {

    private UUID id;

    private String username;

    private Set<ChatDTO> chatUserDTOSet;

}
