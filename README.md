# Java Project Management Application

## Descriere

Aceasta aplicație este un proiect de management realizat în **Java**, utilizând **Spring Boot**, **Spring MVC**, **Thymeleaf** și **MySQL**. Aplicația permite efectuarea operațiunilor CRUD (Create, Read, Update, Delete) pentru gestionarea datelor, având o interfață modernă și responsivă construită cu ajutorul **Bootstrap**.

De asemenea, aplicația include o pagină dedicată afișării unui **chart pie** interactiv, generat cu ajutorul bibliotecii **Chart.js**, pentru o vizualizare mai clară a datelor.

---

## Funcționalități principale

- **Operațiuni CRUD**:
  - Crearea, citirea, actualizarea și ștergerea datelor din baza de date.
- **Interfață modernă**:
  - Design responsiv realizat cu **Bootstrap**.
- **Vizualizare grafică**:
  - Integrarea unui **chart pie** interactiv pentru afișarea datelor statistice.
- **Bază de date relațională**:
  - Utilizarea **MySQL** (serverul MySQL din **XAMPP**) pentru stocarea și gestionarea datelor.
- **Arhitectură MVC**:
  - Separarea clară a logicii aplicației în componente Model, View și Controller, utilizând **Spring MVC**.
- **Template-uri dinamice**:
  - Generarea paginilor web dinamice cu ajutorul **Thymeleaf**.

---

## Tehnologii utilizate

- **Java**: Limbajul principal de programare.
- **Spring Boot**: Framework pentru dezvoltarea rapidă a aplicațiilor.
- **Spring MVC**: Arhitectură pentru separarea logicii aplicației.
- **Thymeleaf**: Motor de template-uri pentru generarea paginilor web.
- **MySQL**: Bază de date relațională (serverul MySQL din **XAMPP**) pentru stocarea datelor.
- **Bootstrap**: Framework CSS pentru design responsiv.
- **Chart.js**: Bibliotecă JavaScript pentru generarea graficelor interactive.
- **XAMPP**: Server local utilizat pentru rularea MySQL.
- **Eclipse**: IDE utilizat pentru dezvoltarea proiectului.

---

## Configurare și rulare

### Configurarea bazei de date

1. Asigurați-vă că aveți instalat și configurat **XAMPP**.
2. Porniți serverul **MySQL** din **XAMPP Control Panel**.
3. Creați o bază de date nouă și actualizați fișierul `application.properties` cu următoarele informații:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/<nume_baza_date>
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update

  
 ## Notă
 Înlocuiți `<nume_baza_date>` cu numele bazei de date pe care ați creat-o.
 Utilizatorul implicit pentru MySQL în **XAMPP** este `root`, iar parola este goală (`""`). Dacă ați configurat alt utilizator sau parolă, actualizați aceste informații în fișierul `application.properties`.
 Asigurați-vă că driverul MySQL `(com.mysql.cj.jdbc.Driver)` este inclus în dependințele proiectului.

---

## Rularea aplicației

1. Deschideți proiectul în **Eclipse**.
2. Rulați aplicația folosind clasa principală cu adnotarea `@SpringBootApplication`.

---

## Accesarea aplicației

1. Deschideți un browser web.
2. Accesați aplicația la adresa: [http://localhost:8080](http://localhost:8080).

---

## Structura proiectului

- **Controller**: Gestionarea cererilor HTTP și logica aplicației.
- **Service**: Implementarea logicii de business.
- **Repository**: Interacțiunea cu baza de date.
- **Model**: Definirea entităților utilizate în aplicație.
- **Templates**: Fișiere HTML generate dinamic cu **Thymeleaf**.

---
