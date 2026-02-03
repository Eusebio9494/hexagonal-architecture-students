# hexagonal-architecture-students
Proyecto para hacer uso de la arquitectura hexagonal
Se añade nueva funcionalidad para controlar excepciones y poder mapear datos con mapstruct
>Agregar yml
>Complementar configuración para usar mapstruct
>Configuración de conexión a BD
>Agregar enum con códigos y mensajes para errores de excepción
>Agregar clase manejadora de excepciones GlobalControllerAdvice especificando el estatus http, la excepción a atrapar y la construcción de la respuesta de salida ErrorResponse
>Modelo ErrorResponse que contiene atributos a mostrar en caso de que ocurran excepciones
>Clase personal de StudentException con un argumento en el constructor para el mensaje
>Corrección de nombrado en variables
>Se añade anotación a la clase StudentPersistenceAdapternt con @Component y pueda ser inyectada en la clase de servicio
>Se implementa la excepción personalizada para los casos en que no existan estudiantes enviando el mensaje según el catalogo enum