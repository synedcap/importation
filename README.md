# Projet d'importation 
ce projet est une application java qui permet d'importer des données à partir d'un fichier excel vers une base de données

## Prérequis
- Java 17
- Maven
- Postgresql


## Installation

### Etape 1
Avant d'exécuter l'application, vous devez créer manuellement la base de données.

### Etape 2
configurer la connexion à la base de données en mettant les informations comme  le nom utilisateur le mot de passe  et le nom de la base.

- spring.datasource.url=jdbc:postgresql://localhost:5432/nom_base_de_données
- spring.datasource.username=VotreNomUtilisateur
- spring.datasource.password=VotreMotDePasse

### Etape 3
- faire un mvn clean install
- Lancer l'application avec la commande mvn spring-boot:run . Cela permettra de créer les tables.

### Etape 4
Lancer ensuite la commande mvn clean package pour générer un fichier jar éxecutable

### Etape 5
Après avoir généré le jar vous pouvez l'éxecuter dans la console  pour demarrer l'importation avec cette commande

java -jar chemin_vers_le_jar/import-from-excel-0.0.1-SNAPSHOT.jar   "chemin vers le fichier excel" 

Exemple : java -jar target/import-from-excel-0.0.1-SNAPSHOT.jar "E:\peoplesample.xlsx"  