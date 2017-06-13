# Markov chains + Ngrams for string deduplication

Descargar libros para hacer la prueba

```
curl -sL https://www.gutenberg.org/ebooks/46279.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/54430.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/15532.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/29731.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/15532.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/29506.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/26314.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/16109.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/52502.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/28904.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/51858.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/16670.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/24536.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/37139.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/30122.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/41746.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/33474.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/24466.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/47287.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/47631.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/43030.txt.utf-8 >> textos.txt
curl -sL https://www.gutenberg.org/ebooks/13519.txt.utf-8 >> textos.txt
```

Verificar que el texto tiene muchas lineas con:
```
wc -l textos.txt
```

Crear JAR con:
```
mvn clean compile assembly:single
```


Para hacer la prueba jugar con los valores de heap maximo y con el flag de string deduplication
```
-Xmx80m -XX:+UseG1GC
-Xmx80m -XX:+UseG1GC -XX:+UseStringDeduplication
-Xmx80m -XX:+UseG1GC -XX:+UseStringDeduplication -XX:+PrintStringDeduplicationStatistics
```
