/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.javaagent.instrumentation.netty.v4_1.server;

import io.netty.handler.codec.http.HttpRequest;
import io.opentelemetry.context.propagation.TextMapPropagator;

public class NettyRequestExtractAdapter implements TextMapPropagator.Getter<HttpRequest> {

  public static final NettyRequestExtractAdapter GETTER = new NettyRequestExtractAdapter();

  @Override
  public Iterable<String> keys(HttpRequest request) {
    return request.headers().names();
  }

  @Override
  public String get(HttpRequest request, String key) {
    return request.headers().get(key);
  }
}
