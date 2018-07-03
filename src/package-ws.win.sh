#!/bin/bash


winpty docker run --rm -it -v $(pwd)/ws-a:/project -w /project maven mvn package
winpty docker run --rm -it -v $(pwd)/ws-b:/project -w /project maven mvn package
winpty docker run --rm -it -v $(pwd)/ws-c:/project -w /project maven mvn package
winpty docker run --rm -it -v $(pwd)/ws-d:/project -w /project maven mvn package
