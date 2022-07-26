## Getting started

Install Maven locally.

Start a container running Chrome:
````
docker run -it \
-p 4444:4444 \
-p 5900:5900 \
--name remote-chrome \
selenium/standalone-chrome-debug:3.141.59
````

Clear out any dependencies and run the tests:
````
rm -rf ~/.m2 && rm -rf target && mvn test
````
