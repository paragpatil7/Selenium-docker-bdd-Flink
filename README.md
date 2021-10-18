seleniumdockerbdd

Git-Hub url
https://github.com/paragpatil7/Selenium-docker-bdd-Flink.git

prerequisites
1- Please install the Docker
2- Start the Docker

Steps to run the tests
1- Create new folder for execution
2- Pull the docker-compose file from Git-Hub in the same folder
https://github.com/paragpatil7/Selenium-docker-bdd-Flink/tree/main/Docker_Compose
3- open command prompt and go to location where we store the docker-compose.yaml
then execute command
docker-compose up

e.g F:\parag\Flink_Test>docker-compose up

It will launch dockerized grid then it will execute the docker image as container and it will create the output folder inside that it will create a result folder
check the result in output/report.html

below are the some condition we can check 

to increase the number of browser use below command
docker-compose up --scale chrome=2 --scale firefox=2

to run on Firefox browser
1-open docker-compose file and change environment value - BROWSER=chrome to - BROWSER=firefox
2- save file 
3- run command 
docker-compose up
