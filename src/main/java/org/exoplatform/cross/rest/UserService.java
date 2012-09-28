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

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.exoplatform.cross.bean.User;
import org.exoplatform.services.rest.resource.ResourceContainer;

/**
 * Created by The eXo Platform SAS Author : Nguyen Viet Bang
 * bangnv@exoplatform.com Sep 27, 2012
 */

@Path("/user/")
public class UserService  implements ResourceContainer{
  
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/id/{id}")
  public User findById(@PathParam("id")
  final Long id) {
    if (id.equals(100)) {
      return null;
    }
    final User user = new User();
    user.setId(id);
    user.setFirstName("Tim");
    user.setLastName("Tester");
    user.setBirthday(new Date(1321009871));
    return user;
  }
}
