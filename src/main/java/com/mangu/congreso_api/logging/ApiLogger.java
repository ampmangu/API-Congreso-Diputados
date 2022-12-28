package com.mangu.congreso_api.logging;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class ApiLogger implements HandlerInterceptor {

  private static final Logger logger = LoggerFactory
      .getLogger(ApiLogger.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {
    String requestId = UUID.randomUUID().toString();
    log(request, response, requestId);
    long startTime = System.currentTimeMillis();
    request.setAttribute("startTime", startTime);
    request.setAttribute("requestId", requestId);
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) {
    long startTime = (Long) request.getAttribute("startTime");
    long endTime = System.currentTimeMillis();
    long executeTime = endTime - startTime;
    logger.info("requestId {}, Handle :{} , request take time: {}",
        request.getAttribute("requestId"), handler, executeTime);
  }

  private void log(HttpServletRequest request, HttpServletResponse response, String requestId) {
    logger.info("requestId {}, host {}  HttpMethod: {}, URI : {}", requestId,
        request.getHeader("host"),
        request.getMethod(), request.getRequestURI());
  }
}