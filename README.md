# Game of life

### Build
```bash
$ mvn clean install
$ java -jar target/game-of-life-1.0.jar run
```

### Commands
```bash
$ java -jar target/game-of-life-1.0.jar help
```

### Examples
Run with green alive and yellow dead cells:
```bash
$ java -jar target/game-of-life-1.0.jar run --color_alive green --color_dead yellow --iters_count 100
```

Infinite run:
```bash
$ java -jar target/game-of-life-1.0.jar run --iters_count -1
```

Run with figures:
```bash
$ java -jar target/game-of-life-1.0.jar reset
$ java -jar target/game-of-life-1.0.jar set_params --size 20 20
$ java -jar target/game-of-life-1.0.jar add_figure --type pulsar --place 2 2
$ java -jar target/game-of-life-1.0.jar add_figure --type pulsar --place 3 3
$ java -jar target/game-of-life-1.0.jar run --iters_count 10
```


### Run from docker
```bash
$ docker pull dockertsareva/game-of-life:latest
$ docker run dockertsareva/game-of-life:latest run --color_alive blue --color_dead red --iters_count -1
```



![hippo](https://media.giphy.com/media/tZOXaZeACq20egmSrc/giphy.gif)
