***Loading... Lines***

Random "Please wait..." messages to keep your users entertained.

Comes pre-packaged with original Sim City Messages and a de-luxe set of Yoda quotes.

***INSTALLATION***

```bash
$ mvn package
$ java -jar target/loadinglines-0.0.1-SNAPSHOT.jar
```

***DOCKER***

```bash
$ docker pull aarsla/loadinglines
$ docker run -p 9000:9000/tcp -p 9001:9001/tcp loadinglines
```

***ENDPOINTS***

|               |               |
| ------------- |:--------------|
| /      | This page |
| /message      | Random message      |
| /message/short | Shorter version of random message      |
| /quote | Random pearl of wisdom   |
| /sim | Original SimCity message      |

All endpoints support up to 50 messages (/message/:n).

***METRICS***

|               |               |
| ------------- |:--------------|
| /status      | Health & Metrics |

***EXAMPLES***

```bash
$ curl http://localhost:9000/message
    {"message": "Preparing Spline Graphs"}
```

***DESCRIPTION***

Having fun with Spring Boot.

***AUTHOR***

[Aid Arslanagic](https://github.com/aarsla)