/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.cross.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.exoplatform.services.rest.resource.ResourceContainer;

/**
 * Created by The eXo Platform SAS Author : eXoPlatform bangnv@exoplatform.com
 * Sep 25, 2012
 */

@Path("/calculService/")
public class CalculService implements ResourceContainer {

  // in gate in http://localhost:8080/rest/calculService/plus/1/2
  @GET
  @Path("/plus/{x}/{y}")
  public String plusOperator(@PathParam("x")
  String x, @PathParam("y")
  String y) {
    if (x == null || y == null) {
      return "value of x and y must be not null";
    }
    float x_convert, y_convert;
    try {
      x_convert = Float.valueOf(x);
      y_convert = Float.valueOf(y);
    } catch (java.lang.NumberFormatException e) {
      return "Type of x and y must be Integer, exemple : http://localhost:8080/rest/calculService/plus/1/2";
    }
    return String.valueOf(x_convert + y_convert);
  }

  // http://localhost:8080/rest/calculService/subs/1/2
  @GET
  @Path("/subs/{x}/{y}")
  public String subsOperator(@PathParam("x")
  String x, @PathParam("y")
  String y) {
    float x_convert, y_convert;
    try {
      x_convert = Float.valueOf(x);
      y_convert = Float.valueOf(y);
    } catch (java.lang.NumberFormatException e) {
      return "Type of x and y must be Integer, exemple : http://localhost:8080/rest/calculService/subs/1/2";
    }
    return String.valueOf(x_convert - y_convert);
  }

  // http://localhost:8080/rest/calculService/multi/1/2
  @GET
  @Path("/multi/{x}/{y}")
  public String multiOperator(@PathParam("x")
  String x, @PathParam("y")
  String y) {
    float x_convert, y_convert;
    try {
      x_convert = Float.valueOf(x);
      y_convert = Float.valueOf(y);
    } catch (java.lang.NumberFormatException e) {
      return "Type of x and y must be Integer, exemple : http://localhost:8080/rest/calculService/multi/1/2";
    }
    return String.valueOf(x_convert * y_convert);
  }

  // http://localhost:8080/rest/calculService/div/1/2
  @GET
  @Path("/div/{x}/{y}")
  public String divOperator(@PathParam("x")
  String x, @PathParam("y")
  String y) {
    float x_convert, y_convert;
    try {
      x_convert = Float.valueOf(x);
      y_convert = Float.valueOf(y);
    } catch (java.lang.NumberFormatException e) {
      return "Type of x and y must be Integer, exemple : http://localhost:8080/rest/calculService/div/1/2";
    }
    return String.valueOf(x_convert / y_convert);
  }
}
