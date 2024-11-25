package com.enviar.email.DTOs;

import java.util.UUID;

public record EmailReceiveDTO(UUID userId,
                              String emailTo,
                              String subject,
                              String text) {
}
