# Retries Springboot
Spring Boot Retry ofrece una forma simple para reintentar alguna operación que ha fallado. Esto es útil sobre todo cuando se tratan errores temporales o transitorios como el acceso a un recurso externo.
```
dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.retry:spring-retry:1.3.0")
    implementation("org.springframework.boot:spring-boot-starter-aop")
}
```
Para activar Spring Retry debes anotar en tu aplicación `@EnableRetry`, que fue colocado en `SpringbootRetryApplication` dentro de **src/main/kotlin/com/example/springbootretry**

Luego el siguiente paso es colocar la notation `@Retryable` en el archivo del cual se va a aplicar el método de retries. La notation sería `@Retryable(maxAttempts = $maxAttempts, backoff = Backoff(delay = $delay))` donde:
- **maxAttempts**: es un parámetro que determina cuántos intentos se realizarán antes de que se declare un fallo completo. Es el número máximo de veces que Spring Retry intentará ejecutar un método anotado con `@Retryable`. Cuando se alcanza el número máximo de intentos sin éxito (es decir, sin que se arroje una excepción que se considere exitosa para el retry), Spring Retry finaliza la ejecución y se declara un fallo. Por ejemplo, si configuras maxAttempts = 3, Spring Retry intentará ejecutar el método anotado hasta 3 veces antes de considerar que ha fallado si las tres ejecuciones terminan en una excepción.
- **backoff**: es un parámetro que controla el retardo entre los intentos de ejecución. Especifica cuánto tiempo debe esperar Spring Retry antes de volver a intentar ejecutar el método anotado después de un intento fallido. Puedes personalizar el retardo de la siguiente manera:
    - **delay**: Indica el tiempo de retardo inicial entre los intentos en milisegundos. Por ejemplo, delay = 1000 significa que habrá un retardo de 1000 milisegundos (1 segundo) antes del primer retry.
    - **maxDelay**: Opcionalmente, puedes especificar un tiempo máximo de retardo entre los intentos. Esto significa que el retardo aumentará gradualmente hasta alcanzar maxDelay si se siguen produciendo errores en los intentos. Esto es útil para evitar que los retries se realicen inmediatamente en sucesión.
    - **multiplier**: Define un multiplicador que se aplica al retardo en cada intento adicional. El retardo se calcula como delay * (multiplier ^ intento). Esto significa que el retardo aumenta exponencialmente con cada intento si se especifica un multiplicador mayor que 1. Por defecto, el multiplicador es 1.0.
    - **random**: Si lo configuras como true, se agregará un pequeño componente aleatorio al retardo para evitar la sincronización de retries en múltiples instancias de la aplicación. Esto es útil en sistemas distribuidos para evitar la congestión.

En este ejemplo, tenemos el `@Retryable` en nuestro archivo de mysql, pero podría utilizarse también en conjunto con el caso de uso. Una de las "ventajas" de tenerlos en ambos lados (que en nuestro ejemplo no ocurre) tiene que ver con la responsabilidad y el control de los reintentos en diferentes capas de la aplicación.
1. **En el MySqlAdapter (Capa de Infraestructura)**: Aquí, aplicas retry directamente en el adaptador de base de datos porque puede haber condiciones temporales o excepcionales específicas de la infraestructura que afecten la capacidad de la aplicación para acceder a la base de datos. Por ejemplo, problemas de red, sobrecarga de la base de datos o caídas temporales del servicio de base de datos. Al aplicar retry en el adaptador de base de datos, puedes abordar directamente estas situaciones de infraestructura.
2. **En el Caso de Uso (UseCase) (Capa de Aplicación)**: También aplicas retry en el caso de uso para abordar situaciones específicas de lógica de negocio donde el uso de retry es relevante. Por ejemplo, podrías aplicar retry si una operación de negocios puede fallar temporalmente debido a condiciones cambiantes o si deseas asegurarte de que la operación se intente nuevamente si falla debido a una condición temporal específica en la lógica de tu aplicación.

La aplicación de retry en ambos niveles proporciona una capa adicional de robustez y resiliencia a la aplicación. Cada capa tiene su propio propósito:

- El retry en el **adaptador de base de datos** aborda problemas específicos de la infraestructura y la conexión a la base de datos.
- El retry en el **caso de uso** permite que la lógica de negocio de la aplicación se recupere de situaciones temporales o excepcionales que pueden ocurrir en el flujo de trabajo de la aplicación.

Otra cosa que debemos saber:
- Si el `@Retryable` solo se encuentra en el caso de uso, este ultimo va a ejecutarse tantas veces hayamos declarado la variable **maxAttempts**, pero solo una vez el archivo de mysql
- Si el `@Retryable` solo se encuentra en el adaptador de base de datos, el caso de uso va a ejecutarse una única vez, y el mysql adapter tantas veces hayamos declarado la variable **maxAttempts**
- Si el `@Retryable` está en ambos lados, el caso de uso y el archivo de mysql van a ejecutarse tantas veces hayamos declarado **maxAttempts**

