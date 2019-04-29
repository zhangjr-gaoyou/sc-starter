package com.asiainfo.sc.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import ch.qos.logback.classic.Logger;

public class DemoFilter  extends ZuulFilter {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(DemoFilter.class);

	  @Override
	  public String filterType() {
	    return FilterConstants.PRE_TYPE;
	  }

	  @Override
	  public int filterOrder() {
	    return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
	  }

	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }

	  @Override
	  public Object run() {
	    RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();
	    DemoFilter.LOGGER.info(String.format("send %s request to %s", request.getMethod(), request.getRequestURL().toString()));
	    return null;
	  }
}
