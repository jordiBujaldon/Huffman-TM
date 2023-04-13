
Factor de compresion para diferentes tamaños:

Para longitud de 1200 simbolos: 3.236682400539447
Para longitud de 1500 simbolos: 3.2626427406199023
Para longitud de 2500 simbolos: 3.3041467041136627
Para longitud de 5000 simbolos: 3.2781511227667597

Como podemos observar, el factor de compresión que se alcanza con diferentes
longitudes es muy parecida en todos los tamaños. Podemos decir entonces, que Huffman
es capaz de comprimir los mensajes de una manera muy estable para cualquier
longitud. Al tener un factor aproximado de 3, podemos decir que hemos reducido 1/3
su tamaño original, lo cual creemos que es bastante eficiente.

El factor de compresión y la entropía guardan cierta relacion, ya que podemos decir que
si el factor de compresión es igual a la entropía, el algoritmo que hemos implementado, es 
totalmente óptimo. Si el factor de compresión, es mucho más grande que la entropía, podriamos 
decir que el algoritmo no es eficiente. Contra más distancia haya entre el factor de compresión
y la entropía, menor será la eficiencia.

         