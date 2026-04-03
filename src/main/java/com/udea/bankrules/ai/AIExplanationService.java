package com.udea.bankrules.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AIExplanationService {

    private final ChatClient chatClient;

    public AIExplanationService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String explain(List<String> appliedRules) {
        String rulesText = appliedRules.isEmpty()
            ? "Ninguna regla fue activada."
            : String.join("\n", appliedRules);

        String prompt = """
        Eres un experto en políticas de aerolíneas.

        Las siguientes reglas de negocio fueron activadas por el sistema Drools
        al evaluar el perfil de un pasajero y su vuelo:

        %s

        Para cada regla activada explica:
        - Por qué se activó (qué condición cumplió el pasajero o el vuelo)
        - Qué beneficio o restricción implica para el pasajero

        Sé claro y conciso.
        """.formatted(rulesText);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

}
