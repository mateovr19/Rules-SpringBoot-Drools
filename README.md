# Rules-SpringBoot-Drools ✈️

Sistema de reglas de negocio para una aerolínea implementado con **Spring Boot** y **Drools**, como parte del Laboratorio Nro. 2 de Fundamentos de Sistemas de Información - Universidad de Antioquia.

## Descripción

La aplicación evalúa el perfil de un pasajero y las características de su vuelo para determinar automáticamente qué beneficios, restricciones o acciones aplican, según un conjunto de 10 reglas de negocio definidas en Drools Rule Language (DRL).

La respuesta incluye una explicación en lenguaje natural generada por **GPT-4o-mini** de OpenAI.

---

## Tecnologías

- Java 21
- Spring Boot 3.2.5
- Drools 7.74.1.Final
- Spring AI 1.0.0-M6 (OpenAI)
- Maven

---

## Estructura del Proyecto

src/main/java/com/udea/bankrules/
├── ai/
│   └── AIExplanationService.java       # Integración con OpenAI
├── config/
│   └── DroolsConfig.java               # Configuración del motor Drools
├── controller/
│   └── AirlineController.java          # Endpoint REST
├── model/
│   ├── AirlineRequest.java             # Objeto de entrada
│   ├── AirlineResponse.java            # Objeto de salida
│   ├── Flight.java                     # Datos del vuelo
│   └── Passenger.java                  # Datos del pasajero
├── service/
│   └── AirlineEvaluationService.java   # Lógica de evaluación con Drools
└── BankrulesApplication.java
src/main/resources/
├── rules/
│   └── airline_rules.drl               # 10 reglas de negocio
└── application.yaml

---

## Reglas de Negocio

| # | Regla | Condición | Acción |
|---|-------|-----------|--------|
| 1 | UpgradeToBusinessClass | Membresía Gold/Platinum + retraso > 60 min | Ascenso a clase ejecutiva |
| 2 | PriorityCheckInForSeniors | Edad > 65 años | Check-in prioritario |
| 3 | DiscountForLightLuggage | Equipaje < 10 kg | Descuento del 10% |
| 4 | DenyUpgradeForOverweightLuggage | Equipaje > 23 kg | No elegible para ascenso |
| 5 | AssignEmergencyExitSeat | Edad 18-40 + seatPreference "Any" + asiento disponible | Asiento de salida de emergencia |
| 6 | CompensationForExtremeDelays | Retraso > 180 min | Compensación de $200 |
| 7 | ExtraLoyaltyPointsForLongFlights | Membresía no Basic + vuelo > 5h | 500 puntos de lealtad |
| 8 | RestrictLuggageOnShortFlights | Equipaje > 15 kg + vuelo < 2h | Equipaje no permitido |
| 9 | VipLoungeAccessForPlatinumMembers | Membresía Platinum | Acceso al salón VIP |
| 10 | PreferentialSeatForFamilies | Viaja con niños + seatPreference "Any" | Asiento preferencial familiar |

---

## Configuración

1. Clona el repositorio
2. Crea un archivo `application-local.yaml` en `src/main/resources/` con tu API key de OpenAI:
```yaml
spring:
  ai:
    openai:
      api-key: TU_API_KEY_AQUI
```

3. El `application.yaml` principal usa la variable de entorno:
```yaml
spring:
  application:
    name: bankrules
  ai:
    openai:
      api-key: ${OPENAI_API_KEY}
      chat:
        options:
          model: gpt-4o-mini
```

---

## Ejecutar la Aplicación
```bash
mvn spring-boot:run
```

La aplicación corre en `http://localhost:8080`.

---

## Uso del API

**Endpoint:** `POST /airline/evaluate`

**Headers:**

**Body de ejemplo:**
```json
{
  "passenger": {
    "name": "Ana Gómez",
    "age": 35,
    "membershipStatus": "Gold",
    "luggageWeight": 12,
    "travelingWithChildren": false,
    "seatPreference": "Window"
  },
  "flight": {
    "flightNumber": "AV101",
    "delayMinutes": 90,
    "durationHours": 3,
    "emergencyExitSeatAvailable": false
  }
}
```

**Respuesta:**
```json
{
  "result": {
    "upgradedToBusinessClass": true,
    "priorityCheckIn": false,
    "discount": 0.0,
    "eligibleForUpgrade": true,
    "assignedSeat": null,
    "compensation": 0.0,
    "loyaltyPointsAdded": 0,
    "luggageAllowed": true,
    "vipLoungeAccess": false,
    "appliedRules": [
      "Regla 1: Ascenso a clase ejecutiva por retraso y membresía Gold/Platinum."
    ]
  },
  "aiExplanation": "Explicación generada por GPT-4o-mini..."
}
```

---

## Valores válidos

| Campo | Valores |
|-------|---------|
| membershipStatus | `"Basic"`, `"Gold"`, `"Platinum"` |
| seatPreference | `"Any"`, `"Window"`, `"Aisle"` |

---

## Autor

Mateo Velasquez Rodriguez — Fundamentos de Sistemas de Información, Universidad de Antioquia, 2026
