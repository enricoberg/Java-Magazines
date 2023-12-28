
  


<a  name="readme-top"  id="readme-top"></a>

  

  
  

  

<h3  align="center">DnA MAGAZINE MANAGER- JAVA PROJECT</h3>

  

  

<!-- ABOUT THE PROJECT -->

  

## About The Project

  

  
  
  

  

The application is realized as final test to conclude the module "Java Basics" of the Start2Impact Backend Development Course.

  

  

The requisites for the development of the app:

  
  

* The app must retrieve data from three CSV files: abbonamenti.csv, utenti.csv, riviste.csv. 
* The app must enable visualization of all active subscription in the system. (pressing 1)
* The app must allow subscription to an existing magazine. (pressing 2)
* The app must allow to cancel an existing subscription. (pressing 3)
* The app must allow to insert a new user to the system. (pressing 4)
* The app must allow exporting of a CSV file with information on the available magazines. (pressing 5)
* The app must allow the user to close the program by pressing 0.


  
  
  

  
  
  

  



  

  

### Built With

  

  

![100% ](https://img.shields.io/badge/100%25-JAVA-violet?style=for-the-badge)

  
  
  
  
  
  
  
  

  
  
  

  

<!-- GETTING STARTED -->

  

## Getting Started

  

  

  
  

  

### Installation

First you need to [have JAVA installed.](https://www.java.com/it/download/help/windows_manual_download.html)

If you want to simply try the application:

 - Download the JAR File
 - Download the abbonamenti.csv , utenti.csv and riviste.csv files.
 - Place all the above inside a folder and run the JAR file from a terminal:
```xml

java -jar Java-Information.jar

```

  

<!-- USAGE EXAMPLES -->

You're good to go! Follow the instructions on the app to try its functionalities.





## Edit the Project
If you want to make modifications to the app, you are free to do it by downloading the source code.
```xml

git clone https://github.com/enricoberg/Java-Magazines.git

```
The project was built with Maven and the folder structure is the following:
```markdown
├── src
│   ├── main
│   │   ├── java
│   │   |	├── org.example
│   │   |	|	├──controllers
│   │   |	|	|	├──Controller.java
│   │   |	|	|	├──Query.java
│   │   |	|	├──models
│   │   |	|	|	├──Abbonamento.java
│   │   |	|	|	├──Utente.java
│   │   |	|	|	├──Rivista.java
│   │   |	|	|	├──ReadAbbonamento.java
│   │   |	|	|	├──ReadUtente.java
│   │   |	|	|	├──ReadRivista.java
│   │   |	|	|	├──Database.java
│   │   |	|	├──utilities
│   │   |	|	|	├──Utilities.java
│   │   |	|	├──Main.java
│   │   ├── resources
│   │   │   ├── abbonamenti.csv
│   │   │   ├── utenti.csv
│   │   │   ├── riviste.csv
├── pom.xml
├── .gitignore
```
The entry point of the app is Main.java.
Data is stored in the CSV in the resources folder.
Java classes are grouped in folders separating Models and Controllers, plus an extra class Utilities for data validation.
pom.xml is an XML file that contains information about the project and configuration details used by Maven to build the project.

### Building
To compile and run the application you need an IDE, I personally use [IntelliJ IDEA.](https://www.jetbrains.com/idea/download/?section=windows)
To import a Maven project from IntelliJ you can follow [this detailed guide.](https://www.jetbrains.com/guide/java/tutorials/working-with-maven/importing-a-project/)
To create the JAR file from within the project,
```xml
File > Project Structure>Artifacts > Add a new one (+)
```
```xml
JAR > From modules with dependencies
```
```xml
Select the Main class as entry point for the app and Apply
```
Now go to 
```xml
File > Build > Build Artifacts... > Build
```
And the JAR file will be exported in the selected folder. 🎉
Remember to add the CSV to the folder in which you'll use the JAR 😊  

## Contributing

  

  

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

  

  

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".

  

Don't forget to give the project a star! Thanks again!

  

  

1. Fork the Project

  

2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)

  

3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)

  

4. Push to the Branch (`git push origin feature/AmazingFeature`)

  

5. Open a Pull Request

  

  
  
  

  
  
  

  

<!-- CONTACT -->

  

## Contact

  

  

Enrico Bergamini - enricobergamini@outlook.it

  

[![LinkedIn][linkedin-shield]][linkedin-url]

  

  

<p  align="right">(<a  href="#readme-top">back to top</a>)</p>

  
  

  
  

<!-- MARKDOWN LINKS & IMAGES -->

  

<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

  

[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge

  

[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors

  

[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge

  

[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members

  

[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge

  

[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers

  

[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge

[HTML-url]: https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=whit

[issues-url]: https://github.com/othneildrew/Best-README-Template/issues

  

[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge

  

[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt

  

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555

  

[linkedin-url]: https://linkedin.com/in/enrico-bergamini

  

[product-screenshot]: images/screenshot.png

  

[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white

  

[Next-url]: https://nextjs.org/

  

[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB

  

[React-url]: https://reactjs.org/

  

[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D

  

[Vue-url]: https://vuejs.org/

  

[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white

  

[Angular-url]: https://angular.io/

  

[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00

  

[Svelte-url]: https://svelte.dev/

  

[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white

  

[Laravel-url]: https://laravel.com

  

[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white

  

[Bootstrap-url]: https://getbootstrap.com

  

[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white

  

[JQuery-url]: https://jquery.com

[CSS-url]: https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=whit

[JAVASCRIPT-url]: https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black