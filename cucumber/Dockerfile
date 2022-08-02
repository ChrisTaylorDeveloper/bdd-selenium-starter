FROM maven:3.8.6-jdk-11

RUN apt-get update \
    && apt-get install -y --no-install-recommends \
    tini \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /usr/src/workdir

# tail is not designed to run with PID 1
# so run tini (the tiny init) as PID 1
# and use tini to spawn tail.
ENTRYPOINT ["/usr/bin/tini", "--"]

# Keep a container running.
CMD ["tail", "-f", "/dev/null"]
