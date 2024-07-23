# Lecture

## 1 - Lancement du logiciel

- ouvrir le terminal de l'IDE.

- se déplacer dans le dossier Lecture11

- compiler les fichiers java s'ils ne le sont pas déjà fait:
  
  ```java
 javac -d out -sourcepath src/main/java src/main/java/com/mycompany/lecture/*.java
  ```

- lancer le fichier Application.class
  
  ```java
  java -cp "out:src/main/resources" com.mycompany.lecture.Application
  ```
