FROM ubuntu:latest
LABEL authors="carel"

ENTRYPOINT ["top", "-b"]