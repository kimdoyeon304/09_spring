package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
