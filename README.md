The Rick´s Portal Gun

El juego es parecido al busca minas. Debes tocar uno de los portales, si acertaste se ocultaran y saldrá que ganaste, si no,
se ocultaran todos y perderas.
Para volver a jugar hay que inicar de nuevo el juego.

*Explicación y contenido MainActivity:*
- Dos cadenas de texto (para un boton que abrirá un mensaje por AlertBox y el mensaje de salida por AlertBox de confirmación).
- Función con la música para la Activity. 
- La llamada a la Main2Activity por otro botón.
- Función onBackPressed.

*Explicación y contenido LAYOUT MainActivity:*
- Background con la imagen de fondo para el LAYOUT.
- ImageView con una imagen para el titulo del juego.
- Button con el mensaje que aparece con un AlertBox.
- Button con imagen que incia la Main2Activity.
- Función onBackPressed.

*Explicación y contenido Main2Activity:*
- Cadena de texto (para el mensaje de salida por AlertBox de confirmación).
- Cuatro Función para la generar RANDOM para las animaciones (X e Y, y tiempo de Desplazamiento de X e Y).
- Función "tarea_animacion'X'" ('X' es el numero para identificarlas por cada portal).
- Función de llamada para los dos FRAGMENT.
- Función "comprobarPartida" compara si el portal seleccionado vale para ganar si está oculto el incorrecto o
  cualquiera del que no sea el correcto perdemos, ya que solo hay un intento.
- Función "capturado" que al hacer click en el portal, lo pondra en invisible y llama al metodo para comparar si
  es el correcto para ganar, si no, perdemos.
- Función onBackPressed.

*Explicación y contenido LAYOUT Main2Activity:*
- Background con la imagen de fondo para el LAYOUT.
- Contiene un FrameLayout.
- ImageView con el titulo del juego.
- Seis GifImageView para los portales.

*Explicación y contenido BlankFragment:*
- Fragment de GANAR, donde agregamos un gif y su texto en el LAYOUT que saldrá al ganar que aparecerá en la Main2Activity.

*Explicación y contenido LAYOUT BlankFragment:*
- Un FrameLayout.
- ImageView para el texto al ganar.
- GifImageView con el gif de ganar.

*Explicación y contenido BlankFragment2:*
- Fragment de PERDER, donde agregamos un gif y su texto en el LAYOUT que saldrá al perder que aparecerá en la Main2Activity.

*Explicación y contenido LAYOUT BlankFragment2:*
- Un FrameLayout.
- ImageView para el texto al perder.
- GifImageView con el gif de perder.


-- NOTA: No hay commits ya que se subio ahora todo junto. Explicado todo lo que contiene anteriormente escrito.--
