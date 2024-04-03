# All things you need to know about this dir:

### What is docker compose for?
It is for running multiple containers at once. After you execute this command, you will have two 
containers. One is running MySQL database, and the other is running Spring backend (port 8082). Ultimately, we want to have a another container running React, so we will have three containers running Frontend, Backend, and Database in isolated environment.

### What is the difference between Dockerfile and docker-compose.yml?
Dockerfile is for defining a image. After you execute `docker build .`, you will have a image(static). Then you can use `docker run ...` to run the image up as a container(active). docker-compose.yml is for running multiple containers at once and specify detailed settings. You can think of docker-compose.yml as a convenient way to organize multiple containers.

### The docker command you would want to know:

1. run all the containers: `docker compose up`
2. when you change your docker compose file (.yml) or Dockerfile and want
to clean cache and start over: `docker system prune`
