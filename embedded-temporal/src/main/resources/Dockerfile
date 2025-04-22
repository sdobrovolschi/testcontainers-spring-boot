ARG BASE_IMAGE=alpine:3

FROM ${BASE_IMAGE} AS builder
ARG TEMPORAL_CLI_VERSION

ADD https://temporal.download/cli.sh /tmp/cli.sh
RUN sh /tmp/cli.sh --version $TEMPORAL_CLI_VERSION --dir /tmp

FROM ${BASE_IMAGE} AS runtime

COPY --from=builder /tmp/bin/temporal /bin/temporal

ENTRYPOINT ["temporal", "server", "start-dev"]
CMD ["--ip", "0.0.0.0", "--headless"]
