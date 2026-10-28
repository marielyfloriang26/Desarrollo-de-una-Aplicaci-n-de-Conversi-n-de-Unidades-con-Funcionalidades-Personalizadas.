# Aplicación de Conversión de Unidades con Funcionalidades Personalizadas

Repositorio correspondiente a la aplicación móvil desarrollada para Android, diseñada para realizar conversiones de unidades de medida (longitud, peso y temperatura) mediante un teclado numérico personalizado y una interfaz interactiva con validaciones de usuario.

---

## Descripción General
La aplicación permite a los usuarios ingresar su nombre para desbloquear las funciones de conversión, introducir cantidades utilizando un teclado numérico personalizado directamente en un `TextView` (sin usar `EditText` para los números), y alternar entre diferentes sistemas de medidas. Además, incluye soporte para modo oscuro.

---

## Características y Requisitos Implementados

1. **Interfaz de Usuario Personalizada:**
   - **Teclado Numérico:** Botones físicos en pantalla del 0 al 9 para la entrada de datos.
   - **Gestión de Nombre:** Campo de texto (`EditText`) para registrar el nombre del usuario, el cual se muestra dinámicamente en la parte superior de la pantalla.
   - **Pantalla de Resultados:** Un `TextView` central que maneja tanto la entrada de números como la visualización de los resultados de las conversiones.
   - **Botón de Reinicio (Reset):** Restaura la aplicación a su estado inicial borrando la entrada actual.

2. **Lógica de Conversión de Unidades:**
   - **Longitud:** Conversión bidireccional entre Metros y Pies.
   - **Peso:** Conversión entre Kilogramos y Libras.
   - **Temperatura:** Conversión entre Grados Celsius y Fahrenheit.

3. **Validaciones de Seguridad y Estado:**
   - **Validación de Nombre:** Los botones de conversión se mantienen deshabilitados (`enabled="false"`) hasta que el usuario introduzca un nombre válido.
   - **Control de Entradas:** Manejo de estados vacíos o entradas no numéricas antes de realizar los cálculos matemáticos.

4. **Funcionalidades Extra:**
   - **Modo Oscuro (Dark Mode):** Soporte completo para estilos adaptativos mejorando la visibilidad y experiencia de usuario.
   - **Diseño Responsivo:** Adaptado mediante layouts optimizados para una correcta visualización en emuladores y dispositivos físicos.

---

## Tecnologías y Herramientas
- **Entorno de Desarrollo:** Android Studio
- **Lenguaje:** Java / XML (Maquetación de vistas y componentes de Android)
- **Componentes Clave:** `TextView`, `EditText`, `Button`, Teclado numérico personalizado con lógica de eventos `OnClickListener`.

---

## Flujo de Uso
1. Al iniciar la app, se solicita el nombre del usuario (los botones de conversión permanecen bloqueados).
2. Una vez ingresado el nombre, se desbloquean las operaciones y el teclado numérico.
3. El usuario pulsa los números deseados (mostrados en el `TextView`) y selecciona el tipo de conversión requerida (Longitud, Peso o Temperatura) para visualizar el resultado instantáneamente.
