package com.enviar.email.DTOs;

import java.util.UUID;

public record EmailReceiveDTO(UUID idUsuario,
                              String emailTO,
                              String subject,
                              String text) {
}
